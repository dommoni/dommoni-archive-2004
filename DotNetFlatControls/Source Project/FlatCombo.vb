Option Explicit On 

Imports System.Security
Imports System.Runtime.InteropServices
Imports System.ComponentModel
Imports dotNetFlatControls.FlatControlsShared

''''''''''''''''''''''''''''''''''''''''''''''''''''''''
' Author: Stacey Brown (ibanezowner@yahoo.com)
' Date: June, 2002
' Reason: Bored
' URL: staceybrown.hispeed.com (I gave up on this site back around 1998)
'
' Overview:
'   In .NET, Microsoft has given us many things to work 
' with. It's nice how they standardized properties like 
' Text and Name on most controls. However, what's the story 
' with the Flat look?
'
'   Some controls have a flat look as a property, either 
' through the FlatStyle property or the Border property. 
' I love the flat look and have been using it for all my 
' controls, except one. The combobox. Do you know how funny 
' a data entry form looks when all its text boxes, checkboxes, 
' radio buttons, command buttons, etc are flat, but its 
' combo boxes are 3D? You probably do, and that's why
' you're looking here...
'
'   This project is nothing more than a simple combobox that 
' inherits from combobox. All events and properties of the 
' regular combo box are there. It even does databinding. The 
' great thing is that it's flat.
'
'   I didn't exactly write this code. I'm a VB developer mostly, 
' and at work we're almost 100% VB. I needed to find a combobox 
' control with a flat look written in VB. What did I find? I 
' found the coolest code on CodeProject.com in an article named, 
' "VSNetToolbar (flat toolbar with embedded combo boxes) written in C#" 
' by Carlos H. Perez. It's an incredibly awesome project to have. 
' However, it's not in VB. I ported his code, line for line, 
' coming up with my own VB equivalents for things like bit 
' shifting, etc. I converted all the API calls and structures 
' needed, also. This was a lot of fun to convert.
'
'   If you like the code, thank Carlos. If you like the fact 
' that it's in VB, thank me! Enjoy..
''''''''''''''''''''''''''''''''''''''''''''''''''''''''

Public Class FlatComboBase
    '''''''''''''''''''''''''''''''''''''
    ' This class serves as a base class
    ' handling most of the events from
    ' combobox. It can be further inherited
    ' and extended. In fact, in Carlos'
    ' C# project, he creates flat dropdowns
    ' with bitmaps in them!
    '''''''''''''''''''''''''''''''''''''
    Inherits System.Windows.Forms.ComboBox
    Private eraseDropDownHightLight As Boolean = False
    Private mouseHookHandle As IntPtr = IntPtr.Zero
    Private mouseProcHandle As GCHandle
    Public toolBarUse As Boolean = False
    Private hooked As Boolean = False
	Public Const ARROW_WIDTH As Integer = 12
    Private editHook As EditComboHook = Nothing
    Friend forceUpdate As Boolean = False
    Private bIsFirstDraw As Boolean = True
    Private m_BorderColor As Color
    Private m_HighlightColor As Color
    Private m_BackColorDisabled As Color
	Private m_TargetPopup As String
	Private m_bIsLastTabStop As Boolean
	Private uDrawState As ueDrawState
    Private bIsDroppedDown As Boolean
	Private bStickToList As Boolean
	Private m_bIsEditable As Boolean
    'TODO: Put back 	Private m_Format As FormatType
    Private m_Format As Integer
    Private m_LastEditText As String
	Private bLastEditWasKeyPress As Boolean
	Private m_InitialFontSize As Single

	Friend Enum ueDrawState
		Draw_Normal
		Draw_Highlighted
		Draw_Selected
		Draw_Disabled
	End Enum

	Private ReadOnly Property DefaultBackColorDisabled() As Color
		Get
			Return Color.WhiteSmoke()
		End Get
	End Property

	Friend Property DrawState() As ueDrawState

		' Note: The current draw-state is overridden (in the get and set) if the control is disabled or has focus.
		Get

			If Not Enabled Then
				uDrawState = ueDrawState.Draw_Disabled
			ElseIf ContainsFocus Then
				uDrawState = ueDrawState.Draw_Selected
			End If

			Return uDrawState

		End Get
		Set(ByVal Value As ueDrawState)

			Dim uInitialState As ueDrawState = uDrawState

			If Not Enabled Then
				uDrawState = ueDrawState.Draw_Disabled
			ElseIf ContainsFocus Then
				uDrawState = ueDrawState.Draw_Selected
			Else
				If Value <> uDrawState Then
					uDrawState = Value
				End If
			End If

			' Only draw if the state changed
			If uDrawState <> uInitialState Then
				DrawBoxAndArrow()
			End If

		End Set
	End Property

	Public Event NotInList()

#Region " Public methods"
	Public Sub New(ByVal toolBarUse As Boolean)
		'// Flag to indicate that combo box will be used
		'// in a toolbar --which means we will use some window hooks
		'// to reset the focus of the combobox--
		Me.toolBarUse = toolBarUse

		DrawMode = DrawMode.OwnerDrawFixed
		BorderColor = Color.DarkGray	   '	 Color.LightGray Changed 10/10/03  DLH  ?>?>?>
		HighlightColor = SystemColors.Highlight
		BackColorDisabled = Color.WhiteSmoke
		SetStyle(ControlStyles.AllPaintingInWmPaint Or ControlStyles.UserPaint Or ControlStyles.Opaque, True)

		'// Use Menu font so that the combobox uses the same font as the toolbar buttons
		Font = SystemInformation.MenuFont
		'// When use in a toolbar we don't need tab stop
		TabStop = False
	End Sub

	Public Sub New()
		DrawMode = DrawMode.OwnerDrawFixed
		BorderColor = Color.LightGray
		HighlightColor = SystemColors.Highlight

		m_bIsEditable = True

		SetStyle(ControlStyles.AllPaintingInWmPaint Or ControlStyles.UserPaint Or ControlStyles.Opaque, True)

	End Sub

	Public Sub SetFontHeight(ByVal newHeight As Integer)
		FontHeight = newHeight
	End Sub

	Public Sub AutoSizeDropDown()

		' resizes the dropdown width based on the size of the largest list item. minimum size is the combo width

		Dim g As Graphics = CreateGraphics()
		Dim oItem As Object
		Dim strItem As String
		Dim iCurWidth As Integer
		Dim iWidest As Integer

		Try

			If Items.Count > 0 Then

				iWidest = Me.Width

				For Each oItem In Me.Items

					If Me.DisplayMember <> "" Then
						strItem = CallByName(oItem, Me.DisplayMember, CallType.Get, Nothing)

					Else
						strItem = oItem.ToString

					End If

					iCurWidth = g.MeasureString(strItem, Me.Font).Width

					If iCurWidth > iWidest Then iWidest = iCurWidth

				Next

			End If

			Me.DropDownWidth = iWidest

		Catch ex As Exception

			Console.WriteLine("Error in AutoSizeDropDown: " & ex.Message)

		End Try

	End Sub

#End Region

#Region " Protected methods"
	Protected Overrides Sub OnHandleCreated(ByVal e As EventArgs)
		MyBase.OnHandleCreated(e)
		'// Hook the edit control
		If DropDownStyle = ComboBoxStyle.DropDown Then
			Dim hEditControl As IntPtr = Win32API.GetDlgItem(Handle, &H3E9)
			Debug.Assert(Not hEditControl.ToInt64 = IntPtr.Zero.ToInt64, "Fail to get ComboBox's Edit Control Handle...")
			editHook = New EditComboHook(Me)
			editHook.AssignHandle(hEditControl)
		End If
	End Sub

	Protected Overrides Sub OnDrawItem(ByVal e As DrawItemEventArgs)
		'// Draw bitmap strech to the size of the combobox
		Dim g As Graphics = e.Graphics
		Dim bounds As Rectangle = e.Bounds
		Dim selected As Boolean = (e.State And DrawItemState.Selected) > 0
		Dim editSel As Boolean = (e.State & DrawItemState.ComboBoxEdit) > 0
		If e.Index <> -1 Then
			DrawComboBoxItem(g, bounds, e.Index, selected, editSel)
		End If
	End Sub

	Protected Overrides Sub WndProc(ByRef m As Message)

		Dim doPainting As Boolean = False

		' ======================================================
		' ?>?> NOTE: The following handy chunk of code is for debugging purposes only. It writes 
		'                  the message name to the Output window. Remove before release.
		'Dim uMsg As Win32API.Msg
		'Dim aryMsg() As Integer
		'Dim value As Win32API.Msg

		'aryMsg = uMsg.GetValues(GetType(Win32API.Msg))
		'For Each value In aryMsg
		'    If CInt(value) = CInt(m.Msg.ToString) Then
		'        Console.WriteLine(value.ToString)
		'    End If
		'Next
		' ======================================================

		Select Case m.Msg
			Case Win32API.Msg.WM_PAINT
				doPainting = True

			Case Win32API.Msg.WM_MOUSELEAVE

				DrawState = ueDrawState.Draw_Normal

			Case Win32API.Msg.WM_WINDOWPOSCHANGING, Win32API.Msg.WM_LBUTTONUP

				If bIsDroppedDown And Not DroppedDown Then
					DrawBoxAndArrow()
				End If

			Case Else

		End Select

		MyBase.WndProc(m)

		'// Now let's do our own painting
		'// we have to do it after the combox
		'// does its own painting so that we can 
		'// let the edit control in the combobox
		'// take care of the text

		If doPainting Then ForcePaint(m)

	End Sub

	Public Function CheckIfInList(Optional ByVal bNoBeep As Boolean = False) As Boolean

		If StickToList Then

			If Me.SelectedIndex > -1 Then

				If Me.DisplayMember > "" Then
					Try

						If Me.EditText <> CallByName(Me.SelectedItem, Me.DisplayMember, CallType.Get) Then
							GoTo NOT_IN_LIST
						End If

					Catch
					End Try
				Else
					If Me.EditText <> Me.SelectedItem.ToString Then
						GoTo NOT_IN_LIST
					End If
				End If

			Else

				If Me.EditText > "" Then
					GoTo NOT_IN_LIST
				End If
			End If

		End If

		Return True

NOT_IN_LIST:
		If Not bNoBeep Then
			Beep()
		End If
		Me.SelectedIndex = -1
		Me.Text = ""
		Return False

	End Function

	Protected Overrides Sub OnLostFocus(ByVal e As EventArgs)
		MyBase.OnLostFocus(e)

		DrawState = ueDrawState.Draw_Normal

		CheckIfInList()

		If toolBarUse And hooked Then
			hooked = False
			EndHook()
		End If
	End Sub

	Protected Overrides Sub OnGotFocus(ByVal e As EventArgs)
		MyBase.OnGotFocus(e)

		DrawState = ueDrawState.Draw_Selected

		If toolBarUse And Not hooked Then
			hooked = True
			StartHook()
		End If

	End Sub

	Protected Overrides Sub OnDropDown(ByVal e As EventArgs)
		eraseDropDownHightLight = True
		MyBase.OnDropDown(e)
	End Sub

	Protected Overrides Sub OnSelectedIndexChanged(ByVal e As EventArgs)
		MyBase.OnSelectedIndexChanged(e)
		If eraseDropDownHightLight Then
			DrawComboBoxArrow()
			eraseDropDownHightLight = False
		End If
	End Sub

	Protected Overridable Sub DrawComboBoxItem(ByVal g As Graphics, ByVal bounds As Rectangle, ByVal Index As Integer, ByVal selected As Boolean, ByVal editSel As Boolean)
		'// Draw the the combo item
		g.FillRectangle(New SolidBrush(SystemColors.Window), bounds.Left, bounds.Top, bounds.Width, bounds.Height)

		If selected And Not editSel Then
			'// Draw highlight rectangle
			g.FillRectangle(New SolidBrush(SystemColors.Highlight), bounds.Left, bounds.Top, bounds.Width, bounds.Height)			 ' HighlightColor
		Else
			'// Erase highlight rectangle
			g.FillRectangle(New SolidBrush(SystemColors.Window), bounds.Left, bounds.Top, bounds.Width, bounds.Height)

			If editSel And ContainsFocus Then
				'// Draw higlighted arrow
				DrawComboBoxArrow()
			End If
		End If
	End Sub

	Protected Overridable Sub DrawComboBoxItemEx(ByVal g As Graphics, ByVal bounds As Rectangle, ByVal Index As Integer, ByVal selected As Boolean, ByVal editSel As Boolean)
		'// This function is only called form the OnPaint handler and the Graphics object passed is the one
		'// for the combobox itself as opossed to the one for the edit control in the combobox
		'// doing this allows us to be able to avoid clipping problems with text strings

		'// Draw the the combo item
		bounds.Inflate(-3, -3)
		g.FillRectangle(New SolidBrush(SystemColors.Window), bounds.Left, bounds.Top, bounds.Width, bounds.Height)

		If selected And Not editSel Then
			'// Draw highlight rectangle
			g.FillRectangle(New SolidBrush(SystemColors.Highlight), bounds.Left, bounds.Top, bounds.Width, bounds.Height)			 ' HighlightColor  replaced with system.highlight
		Else
			'// Erase highlight rectangle
			g.FillRectangle(New SolidBrush(SystemColors.Window), bounds.Left, bounds.Top, bounds.Width, bounds.Height)
			If editSel And ContainsFocus Then
				'// Draw higlighted arrow
				DrawComboBoxArrow()
			End If
		End If
	End Sub
#End Region

#Region " Friend methods"

	Friend Sub DrawBoxAndArrow()	  ' Added by DLH to correct problem where border would not be drawn on first paint

		Select Case DrawState

			Case ueDrawState.Draw_Normal

				DrawComboBoxBorder(Me.BorderColor)
				DrawComboBoxArrow()

			Case ueDrawState.Draw_Highlighted, ueDrawState.Draw_Selected

				DrawComboBoxBorder(Me.HighlightColor)
				DrawComboBoxArrow()

			Case ueDrawState.Draw_Disabled

				PaintComboBoxBackground(BackColorDisabled)
				DrawComboBoxBorder(BorderColor)
				DrawComboBoxArrow()

		End Select

	End Sub

	Friend Sub DrawComboBoxBorder(ByVal color As Color)

		Dim g = CreateGraphics()

		Dim pen As Pen = New Pen(New SolidBrush(color), 1)
		g.DrawRectangle(pen, ClientRectangle.Left, ClientRectangle.Top, ClientRectangle.Width - 1, ClientRectangle.Height - 1)

		'// We need to draw an extra "inner" border to erase the ugly 3D look of  the combobox
		g.DrawRectangle(IIf(Enabled, Pens.White, New Pen(BackColorDisabled)), ClientRectangle.Left + 1, _
		 ClientRectangle.Top + 1, _
		 ClientRectangle.Width - SystemInformation.VerticalScrollBarWidth - 1, _
		 ClientRectangle.Height - 3)

		g.Dispose()

	End Sub

	Friend Sub DrawComboBoxArrowNormal(ByVal g As Graphics, ByVal disable As Boolean)
		Dim left As Integer
		Dim top As Integer
		Dim arrowWidth As Integer
		Dim height As Integer
		Dim bDisposeGraphics As Boolean = False

		If g Is Nothing Then
			g = CreateGraphics()
			bDisposeGraphics = True
		End If

		CalculateArrowBoxCoordinates(left, top, arrowWidth, height)

		'// We are not going to draw the arrow background using the total
		'// width of the arrow button in the combobox because it too wide
		'// and it does not look nice. However, we need to paint over the section
		'// that correspond to the "original" arrow button dimension to avoid
		'// clipping or painting problems
		Dim stripeColorBrush As Brush = New SolidBrush(ColorUtil.VSNetStripeColor)
		If Enabled Then
			Dim Width As Integer = SystemInformation.VerticalScrollBarWidth - ARROW_WIDTH
			g.FillRectangle(Brushes.White, _
			 New Rectangle(left - Width, _
			   top, _
			   SystemInformation.VerticalScrollBarWidth, _
			   height))
		End If

		If Not disable Then
			'// Erase previous selected rectangle first
			EraseArrow()
			'// Now draw the unselected background
			g.FillRectangle(stripeColorBrush, left, top, arrowWidth, height)
		Else
			'// Now draw the unselected background
			g.FillRectangle(stripeColorBrush, left - 1, top - 1, arrowWidth + 2, height + 2)
		End If
		DrawArrowGlyph(g, disable)

		If bDisposeGraphics Then g.Dispose()

	End Sub

	Friend Sub DrawComboBoxArrow()

		Dim left As Integer
		Dim top As Integer
		Dim arrowWidth As Integer
		Dim height As Integer
		Dim cutwidth As Integer
		Dim g As Graphics = CreateGraphics()

		CalculateArrowBoxCoordinates(left, top, arrowWidth, height)

		'// We are not going to draw the arrow background using the total
		'// width of the arrow button in the combobox because it too wide
		'// and it does not look nice. However, we need to paint over the section
		'// that correspond to the "original" arrow button dimension to avoid
		'// clipping or painting problems
		cutwidth = SystemInformation.VerticalScrollBarWidth - ARROW_WIDTH
		g.FillRectangle(IIf(Enabled, Brushes.White, New SolidBrush(BackColorDisabled)), _
		 New Rectangle(left - cutwidth, _
		   top, _
		   SystemInformation.VerticalScrollBarWidth, _
		   height))

		bIsDroppedDown = False

		Select Case DrawState

			Case ueDrawState.Draw_Normal, ueDrawState.Draw_Highlighted, ueDrawState.Draw_Disabled

				'// We are not going to draw the arrow background using the total
				'// width of the arrow button in the combobox because it too wide
				'// and it does not look nice. However, we need to paint over the section
				'// that correspond to the "original" arrow button dimension to avoid
				'// clipping or painting problems
				Dim stripeColorBrush As Brush = New SolidBrush(ColorUtil.VSNetStripeColor)
				If Enabled Then
					Dim Width As Integer = SystemInformation.VerticalScrollBarWidth - ARROW_WIDTH
					g.FillRectangle(Brushes.White, _
					 New Rectangle(left - Width - 1, _
					   top - 1, _
					   SystemInformation.VerticalScrollBarWidth + 1, _
					   height + 2))
				End If

				If Enabled Then
					'// Erase previous selected rectangle first
					EraseArrow()
					'// Now draw the unselected background
					g.FillRectangle(stripeColorBrush, left, top, arrowWidth, height)
				Else
					'// Now draw the unselected background
					g.FillRectangle(stripeColorBrush, left - 1, top - 1, arrowWidth + 2, height + 2)
				End If

				DrawArrowGlyph(g, Not Enabled)


			Case ueDrawState.Draw_Selected

				If Enabled Then
					Dim Width As Integer = SystemInformation.VerticalScrollBarWidth - ARROW_WIDTH
					g.FillRectangle(Brushes.White, _
					 New Rectangle(left - Width - 1, _
					   top - 1, _
					   SystemInformation.VerticalScrollBarWidth + 1, _
					   height + 2))
				End If

				If (DroppedDown) Then

					bIsDroppedDown = True

					'// If showing the list portion of the combo box, draw the arrow portion background using
					'// the highlight color with some transparency -  ' Edit from line below -  was HighlightColor.ToArgb
					g.FillRectangle(New SolidBrush(ColorUtil.VSNetPressedColor(SystemColors.Highlight.ToArgb)), _
					  left, top - 1, arrowWidth + 1, height + 2)
					g.DrawRectangle(New Pen(New SolidBrush(HighlightColor), 1), left, top - 1, arrowWidth + 1, height + 3)
					forceUpdate = True
				Else
					' Edit - was HighlightColor.ToArgb
					g.FillRectangle(New SolidBrush(ColorUtil.VSNetSelectionColor(SystemColors.Highlight.ToArgb)), left, top - 1, arrowWidth + 1, height + 2)
					g.DrawRectangle(New Pen(New SolidBrush(HighlightColor), 1), left, top - 2, arrowWidth + 1, height + 3)
				End If

				DrawArrowGlyph(g, False)

		End Select

		g.Dispose()

	End Sub

	Friend Sub EraseArrow()

		Dim left As Integer
		Dim top As Integer
		Dim arrowWidth As Integer
		Dim height As Integer
		Dim g As Graphics = CreateGraphics()

		CalculateArrowBoxCoordinates(left, top, arrowWidth, height)

		g.FillRectangle(IIf(Enabled, Brushes.White, New SolidBrush(BackColorDisabled)), _
		  left - 1, top - 1, arrowWidth + 2, height + 2)

		g.Dispose()

	End Sub

#End Region

#Region " Private methods"

	Private Sub PaintComboBoxBackground(ByVal backColor As Color)

		Dim g = CreateGraphics()

		Dim rc As Rectangle = ClientRectangle
		rc.Inflate(-1, -1)
		g.FillRectangle(New SolidBrush(backColor), rc)

		g.Dispose()

	End Sub

	Private Sub CalculateArrowBoxCoordinates(ByRef left As Integer, ByRef top As Integer, ByRef width As Integer, ByRef height As Integer)
		Dim rc As Rectangle = ClientRectangle
		width = ARROW_WIDTH + 4		 ' Added 6: DLH;   6/3 - back down to 4
		left = rc.Right - width - 2
		top = rc.Top + 2
		height = rc.Height - 4
	End Sub

	Private Sub DrawArrowGlyph(ByVal g As Graphics, ByVal disable As Boolean)
		Dim left As Integer
		Dim top As Integer
		Dim arrowWidth As Integer
		Dim height As Integer
		Dim oPen As Pen

		CalculateArrowBoxCoordinates(left, top, arrowWidth, height)

		'// Draw arrow glyph
		' Original code defines and fills a polygon, but it resulted in a funny arrow.
		' Modified to create the arrow using four lines

		'Dim pts(2) As Point
		'pts(0) = New Point(left + arrowWidth / 2 - 3, top + height / 2 - 1)
		'pts(1) = New Point(left + arrowWidth / 2 + 4, top + height / 2 - 1)
		'pts(2) = New Point(left + arrowWidth / 2, (top + height / 2 - 1) + 4)

		'If disable Then
		'	g.FillPolygon(New SolidBrush(CONTROL_CUSTOMDark), pts)
		'Else
		'	g.FillPolygon(Brushes.Black, pts)
		'End If

		If disable Then
			oPen = New Pen(Color.FromArgb(CONTROL_DARK_CUSTOM))
		Else
			oPen = New Pen(Color.Black)
		End If

		Dim iCenter As Integer = Fix(left + (arrowWidth / 2))
		Dim iTop As Integer = Fix(top + (height / 2) - 1)

		g.DrawLine(oPen, iCenter - 3, iTop, iCenter + 4, iTop)
		g.DrawLine(oPen, iCenter - 2, iTop + 1, iCenter + 3, iTop + 1)
		g.DrawLine(oPen, iCenter - 1, iTop + 2, iCenter + 2, iTop + 2)
		g.DrawLine(oPen, iCenter, iTop + 3, iCenter + 1, iTop + 3)

	End Sub

	Private Sub ForcePaint(ByRef m As Message)

		'// Similar code to the OnPaint handler

		DrawBoxAndArrow()

		If Not Enabled Then
			Exit Sub
		End If

	End Sub

	Private Sub StartHook()
		'// Mouse hook
		Dim mouseHookProc As Win32API.HookProc = New Win32API.HookProc(AddressOf MouseHook)
		mouseProcHandle = GCHandle.Alloc(mouseHookProc)
		mouseHookHandle = Win32API.SetWindowsHookEx(Win32API.WindowsHookCodes.WH_MOUSE, mouseHookProc, IntPtr.Zero, Win32API.GetCurrentThreadId())
		If mouseHookHandle.ToInt64 = IntPtr.Zero.ToInt64 Then
			Throw New SecurityException()
		End If
	End Sub

	Private Sub EndHook()
		'// Unhook		
		Win32API.UnhookWindowsHookEx(mouseHookHandle)
		mouseProcHandle.Free()
		mouseHookHandle = IntPtr.Zero
	End Sub

	Private Function MouseHook(ByVal code As Integer, ByVal wparam As IntPtr, ByVal lparam As IntPtr) As IntPtr
		Dim mh As Win32API.MOUSEHOOKSTRUCT = Marshal.PtrToStructure(lparam, GetType(Win32API.MOUSEHOOKSTRUCT))
		If mh.hwnd.ToInt64 <> Handle.ToInt64 And Not DroppedDown And (wparam.ToInt64 = Convert.ToInt64(Win32API.Msg.WM_LBUTTONDOWN) Or wparam.ToInt64 = Convert.ToInt64(Win32API.Msg.WM_RBUTTONDOWN)) Or wparam.ToInt64 = Convert.ToInt64(Win32API.Msg.WM_NCLBUTTONDOWN) Then
			'// Loose focus
			Win32API.SetFocus(IntPtr.Zero)
		ElseIf mh.hwnd.ToInt64 <> Handle.ToInt64 And Not DroppedDown And (wparam.ToInt64 = Convert.ToInt64(Win32API.Msg.WM_LBUTTONUP) Or wparam.ToInt64 = Convert.ToInt64(Win32API.Msg.WM_RBUTTONUP)) Or wparam.ToInt64 = Convert.ToInt64(Win32API.Msg.WM_NCLBUTTONUP) Then
			Win32API.SetFocus(IntPtr.Zero)
		End If
		Return Win32API.CallNextHookEx(mouseHookHandle, code, wparam, lparam)
	End Function

#End Region

#Region " Properties"

	' ?>?> I know the string doesn't work for the default value,  but it doesn't hurt, 
	'        so I'll leave it there until I can get a type converter working - DLH
	<DefaultValue("WhiteSmoke"), Browsable(True)> _
	Public Property BackColorDisabled() As Color
		Get
			If m_BackColorDisabled.IsEmpty Then
				m_BackColorDisabled = DefaultBackColorDisabled
			End If
			Return m_BackColorDisabled
		End Get
		Set(ByVal Value As Color)
			m_BackColorDisabled = Value
		End Set
	End Property

    ' TODO: Put back 
    'Public Property FormatStyle() As FormatType
    '    Get
    '        Return m_Format
    '    End Get
    '    Set(ByVal Value As FormatType)
    '        m_Format = Value
    '    End Set
    'End Property
    Public Property FormatStyle() As Integer
        Get
            Return m_Format
        End Get
        Set(ByVal Value As Integer)
            m_Format = Value
        End Set
    End Property

    Public Property BorderColor() As Color
        Get
            Return m_BorderColor
        End Get
        Set(ByVal Value As Color)
            m_BorderColor = Value
        End Set
    End Property
    Public Property HighlightColor() As Color
        Get
            Return m_HighlightColor
        End Get
        Set(ByVal Value As Color)
            m_HighlightColor = Value
        End Set
    End Property
    Public Property TargetPopup() As String
        Get
            Return m_TargetPopup
        End Get
        Set(ByVal Value As String)
            m_TargetPopup = Value
        End Set
    End Property
    Public Property StickToList() As Boolean
        Get
            Return bStickToList
        End Get
        Set(ByVal Value As Boolean)
            bStickToList = Value
        End Set
    End Property
    Public Property IsLastTabStop() As Boolean
        Get
            Return m_bIsLastTabStop
        End Get
        Set(ByVal Value As Boolean)
            m_bIsLastTabStop = Value
        End Set
    End Property
    Public ReadOnly Property ItemValue() As String
        Get

            If Me.SelectedIndex = -1 Or Me.SelectedItem Is Nothing Then

                If StickToList Then
                    Return ""
                Else
                    Return Me.Text
                End If

            Else

                If Me.DisplayMember = "" Then
                    Try
                        Return Me.SelectedItem.ToString()
                    Catch
                        Debug.Assert(False)
                        Return ""
                    End Try

                Else
                    Try
                        Return CallByName(Me.SelectedItem, Me.ValueMember, CallType.Get, Nothing)
                    Catch
                        Debug.Assert(False)
                        Return ""
                    End Try

                End If

            End If
        End Get
    End Property
    Public ReadOnly Property EditText() As String
        Get
            Return m_LastEditText
        End Get
    End Property
    <DefaultValue(True)> _
    Public Property Editable() As Boolean
        Get
            Return m_bIsEditable
        End Get
        Set(ByVal Value As Boolean)
            m_bIsEditable = Value
        End Set
    End Property

    Public ReadOnly Property InitialFontSize() As Single
        Get
            Return m_InitialFontSize
        End Get
    End Property

    Public Shadows Property SelectedValue() As Object
        Get
            If Not MyBase.SelectedValue() Is Nothing Then
                Return MyBase.SelectedValue
            Else
                Try
                    If Not Me.SelectedIndex = -1 Then
                        If Me.ValueMember > "" Then
                            Return CallByName(Me.SelectedItem, Me.ValueMember, CallType.Get, Nothing)
                        Else
                            Return Me.SelectedItem.ToString
                        End If
                    End If
                Catch ex As Exception
                    Console.WriteLine("FlatComboBase - SelectedValue Get - " & ex.Message)
                End Try
            End If
        End Get
        Set(ByVal Value As Object)

            Dim oItem As Object
            Dim i As Integer

            For i = 0 To Me.Items.Count - 1

                oItem = Me.Items(i)

                Try
                    If Me.ValueMember > "" Then
                        If CallByName(oItem, Me.ValueMember, CallType.Get, Nothing) = Value Then
                            If Me.SelectedIndex <> i Then
                                Me.SelectedIndex = i
                            End If
                            Exit Property
                        End If
                    Else
                        If oItem.ToString = Value Then
                            If Me.SelectedIndex <> i Then
                                Me.SelectedIndex = i
                            End If
                            Exit Property
                        End If
                    End If

                Catch ex As Exception
                    Console.WriteLine("FlatComboBase - SelectedValue Set - " & ex.Message)
                End Try
            Next

        End Set
    End Property
    Friend Property IsFirstDraw() As Boolean
        Get
            Return bIsFirstDraw
        End Get
        Set(ByVal Value As Boolean)
            bIsFirstDraw = False
        End Set
    End Property

#End Region

	Private Sub FullRefresh()

		Dim g As Graphics = Me.CreateGraphics

		g.Clear(Me.BackColor)

		Me.Refresh()

	End Sub

	Private Sub FlatComboBase_MouseLeave(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.MouseLeave

		DrawState = ueDrawState.Draw_Normal

	End Sub
	Private Sub FlatComboBase_MouseEnter(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.MouseEnter

		DrawState = ueDrawState.Draw_Highlighted

	End Sub
	Private Sub FlatComboBase_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles MyBase.MouseMove

		' The MouseEnter event may not fire if the mouse moves fast, so if there's
		' any movement in the control, raising this even, do the same thing.
		DrawState = ueDrawState.Draw_Highlighted

	End Sub
	Protected Overrides ReadOnly Property DefaultSize() As System.Drawing.Size
		Get
			Return New Size(120, 23)
		End Get
	End Property
	Private Sub FlatComboBase_EnabledChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.EnabledChanged

		If Enabled Then
			DrawState = ueDrawState.Draw_Normal
		Else
			DrawState = ueDrawState.Draw_Disabled
		End If

	End Sub
	Private Sub FlatComboBase_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles MyBase.MouseDown

		If bIsDroppedDown And Not DroppedDown Then
			DrawBoxAndArrow()
		End If

	End Sub
	Private Sub FlatComboBase_KeyPress(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyPressEventArgs) Handles MyBase.KeyPress

		Dim cboCombo As ComboBox
		Dim intPossibleMatch As Integer
		Dim bIsPM As Boolean
		Dim iHours As Integer
		Dim iMinutes As Integer
		Dim strTextBefore As String

		cboCombo = CType(sender, ComboBox)
		If Not Char.IsControl(e.KeyChar) Then
			'Characters only 
			intPossibleMatch = 0
			strTextBefore = cboCombo.Text

            ' TODO: Put back
            'If FormatStyle = FormatType.Format_Time Then

            '	Try
            '		' Special check for time combo - check for A or P
            '		If UCase(e.KeyChar) = "A" Or _
            '		 UCase(e.KeyChar) = "P" Then

            '			If UCase(e.KeyChar) = "P" Then
            '				bIsPM = True
            '			End If

            '			If Len(strTextBefore) > 1 Then
            '				strTextBefore = Microsoft.VisualBasic.Left(strTextBefore, Len(strTextBefore) - 1)
            '			End If
            '			If InStr(strTextBefore, ":") > 1 Then
            '				iHours = Microsoft.VisualBasic.Left(strTextBefore, InStr(strTextBefore, ":") - 1)
            '				iMinutes = Val(Mid(strTextBefore, InStr(strTextBefore, ":") + 1))
            '			Else
            '				iHours = Val(strTextBefore)
            '			End If

            '		End If

            '	Catch ex As Exception
            '		Console.WriteLine("Error handling time keypress in FlatCombo: " & ex.Message)
            '	End Try

            'End If

			If Not cboCombo.DroppedDown Then
				'Show dropdown 
				cboCombo.DroppedDown = True
			End If

			intPossibleMatch = cboCombo.FindString(strTextBefore)

            If (intPossibleMatch >= 0) Then
                'TODO: put back
                'If FormatStyle = FormatType.Format_Time Then
                '	If iHours > 0 Then
                '		If iHours = 12 Then iHours = 0
                '		If bIsPM Then
                '			iHours = iHours + 12
                '		End If
                '		Dim dtTest As New Date(1, 1, 1, iHours, iMinutes, 0)
                '		intPossibleMatch = cboCombo.FindString(Format(dtTest, TIME_FORMAT_SHORT))
                '	End If
                'End If
            End If

            If (intPossibleMatch >= 0) Then

                'Select and show match 
                cboCombo.SelectedIndex = intPossibleMatch
                cboCombo.Select(strTextBefore.Length, cboCombo.Text.Length - strTextBefore.Length)

                bLastEditWasKeyPress = True
                m_LastEditText = cboCombo.Text

            Else
                bLastEditWasKeyPress = True
                m_LastEditText = strTextBefore
            End If
        Else
			If e.KeyChar = Chr(13) Then
				CheckIfInList()
			End If
		End If

	End Sub

	Protected Overrides Sub OnTextChanged(ByVal e As System.EventArgs)

		MyBase.OnTextChanged(e)

		If Me.Text > "" And Me.SelectedIndex = -1 Then
			RaiseEvent NotInList()
		End If

	End Sub

	Private Sub FlatComboBase_Validating(ByVal sender As Object, ByVal e As System.ComponentModel.CancelEventArgs) Handles MyBase.Validating
		If Not m_bIsEditable Then
			e.Cancel = True
		End If
	End Sub

	Private Sub FlatComboBase_LocationChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.LocationChanged
		FullRefresh()
	End Sub

	Private Sub FlatComboBase_TextChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.TextChanged
		If bLastEditWasKeyPress Then
			bLastEditWasKeyPress = False
		Else
			m_LastEditText = Me.Text
		End If
	End Sub

	Private Sub FlatComboBase_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.SelectedIndexChanged
		m_LastEditText = Me.Text
	End Sub

	Private Sub FlatComboBase_KeyDown(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyEventArgs) Handles MyBase.KeyDown
		If e.KeyCode = Keys.Delete And Me.DropDownStyle <> ComboBoxStyle.DropDown Then
			Me.SelectedIndex = -1
		End If
	End Sub

	Private Sub FlatComboBase_Enter(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Enter
		DrawBoxAndArrow()
	End Sub

	Private Sub FlatComboBase_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

	End Sub
End Class


Friend Class EditComboHook
	'''''''''''''''''''''''''''''''''''''
	' This class is used by the combobox classes
	' to hook into some windows events.
	'''''''''''''''''''''''''''''''''''''
	Inherits System.Windows.Forms.NativeWindow
	Dim comboBox As FlatComboBase = Nothing
	Dim ignoreNextPaintMessage As Boolean = False

	Public Sub New(ByVal cb As FlatComboBase)
		comboBox = cb
	End Sub

	Protected Overrides Sub WndProc(ByRef m As Message)

		' ======================================================
		' ?>?> NOTE: The following handy chunk of code is for debugging purposes only. It writes 
		'                  the message name to the Output window. Remove before release.
		'Dim uMsg As Win32API.Msg
		'Dim aryMsg() As Integer
		'Dim value As Win32API.Msg

		'aryMsg = uMsg.GetValues(GetType(Win32API.Msg))
		'For Each value In aryMsg
		'    If CInt(value) = CInt(m.Msg.ToString) Then
		'        Console.WriteLine(value.ToString)
		'    End If
		'Next
		' ======================================================

		Select Case m.Msg
			Case Win32API.Msg.WM_PAINT
				If ignoreNextPaintMessage Then
					ignoreNextPaintMessage = False
					Exit Sub
				End If

				If comboBox.forceUpdate And Not comboBox.DroppedDown Then
					comboBox.forceUpdate = False
					comboBox.DrawBoxAndArrow()
				End If

				If Not comboBox.Enabled Then
					'// Let the edit control do its thing first
					MyBase.WndProc(m)
					'// This is going to generate another paint message
					'// ignore it
					ignoreNextPaintMessage = True
					DrawDisableState()
					Exit Sub
				End If

				If comboBox.IsFirstDraw Then
					comboBox.DrawBoxAndArrow()
					comboBox.IsFirstDraw = False
				End If

			Case Win32API.Msg.WM_MOUSEMOVE
				RequestMouseLeaveMessage(Me.Handle)

			Case Win32API.Msg.WM_MOUSELEAVE

				comboBox.DrawState = FlatComboBase.ueDrawState.Draw_Normal

		End Select

		MyBase.WndProc(m)
	End Sub

	Private Sub DrawDisableState()
		'// we are just going to fill the edit area
		'// with a white background, the combobox 
		'// already does the hard part
		Dim g As Graphics = Graphics.FromHwnd(Handle)
		Dim rc As Win32API.RECT = New Win32API.RECT()
		Win32API.GetClientRect(Handle, rc)
		Dim clientSize As Rectangle = New Rectangle(rc.left, rc.top, rc.right - rc.left, rc.bottom - rc.top)

		g.FillRectangle(New SolidBrush(comboBox.BackColorDisabled), clientSize)
		comboBox.DrawComboBoxBorder(comboBox.BorderColor)
		comboBox.DrawComboBoxArrow()
	End Sub

	Private Sub RequestMouseLeaveMessage(ByVal hWnd As IntPtr)
		'// Crea the structure needed for WindowsAPI call
		Dim tme As Win32API.TRACKMOUSEEVENTS = New Win32API.TRACKMOUSEEVENTS()

		'// Fill in the structure
		tme.cbSize = Convert.ToUInt32(16)
		tme.dwFlags = Convert.ToUInt32(Win32API.TrackerEventFlags.TME_LEAVE)
		tme.hWnd = hWnd
		tme.dwHoverTime = Convert.ToUInt32(0)

		'// Request that a message gets sent when mouse leaves this window
		Win32API.TrackMouseEvent(tme)
	End Sub

End Class
