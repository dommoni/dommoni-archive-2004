Imports System.Runtime.InteropServices

Public Class FlatComboBox

    Inherits FlatComboBase

#Region " Windows Form Designer generated code "

    'Public Sub New()
    '    MyBase.New()

    '    'This call is required by the Windows Form Designer.
    '    InitializeComponent()

    '    'Add any initialization after the InitializeComponent() call

    'End Sub

    'UserControl overrides dispose to clean up the component list.
    Protected Overloads Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing Then
            If Not (components Is Nothing) Then
                components.Dispose()
            End If
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        components = New System.ComponentModel.Container()
    End Sub

#End Region

	Public Event EnterPressed()

	'// For use when hosted by a toolbar
    Public Sub New(ByVal toolBarUse As Boolean)
        '// Override parent, we don't want to do all the painting ourselves
        '// since we want to let the edit control deal with the text for editing
        '// the parent class ComboBoxBase knows to do the right stuff with 
        '// non-editable comboboxes as well as editable comboboxes as long
        '// as we change these flags below
        SetStyle(ControlStyles.AllPaintingInWmPaint Or ControlStyles.UserPaint Or ControlStyles.Opaque, False)
    End Sub

    Public Sub New()
        '// Override parent, we don't want to do all the painting ourselves
        '// since we want to let the edit control deal with the text for editing
        '// the parent class ComboBoxBase knows to do the right stuff with 
        '// non-editable comboboxes as well as editable comboboxes as long
        '// as we change these flags below
        InitializeComponent()

        SetStyle(ControlStyles.AllPaintingInWmPaint Or ControlStyles.UserPaint Or ControlStyles.Opaque, False)

	End Sub

	Protected Overrides Sub OnPaint(ByVal pe As PaintEventArgs)

		MyBase.OnPaint(pe)

		MyBase.DrawBoxAndArrow()

	End Sub

	Protected Overrides Sub OnDrawItem(ByVal e As DrawItemEventArgs)
		'// Call base class to do the "Flat ComboBox" drawing
		MyBase.OnDrawItem(e)
		'// Draw text
		Dim g As Graphics = e.Graphics
		Dim bounds As Rectangle = e.Bounds
		Dim selected As Boolean = (e.State And DrawItemState.Selected) > 0
		Dim editSel As Boolean = (e.State And DrawItemState.ComboBoxEdit) > 0
		If e.Index <> -1 Then
			DrawComboBoxItem(g, bounds, e.Index, selected, editSel)
		End If
	End Sub

	Protected Overrides Sub DrawComboBoxItem(ByVal g As Graphics, ByVal bounds As Rectangle, ByVal Index As Integer, ByVal selected As Boolean, ByVal editSel As Boolean)
		'// Call base class to do the "Flat ComboBox" drawing
		Dim strItem As String

		MyBase.DrawComboBoxItem(g, bounds, Index, selected, editSel)
		If Index <> -1 Then
			Dim brush As SolidBrush
			If selected And editSel Then
				brush = New SolidBrush(SystemColors.MenuText)
			ElseIf (selected) Then
				brush = New SolidBrush(SystemColors.HighlightText)
			Else
				brush = New SolidBrush(SystemColors.MenuText)
			End If

			If Me.DisplayMember <> "" Then

				On Error GoTo NO_DISPLAY_MEMBER
				strItem = CallByName(Items(Index), Me.DisplayMember, CallType.Get, Nothing)

			Else
NO_DISPLAY_MEMBER:
				strItem = Items(Index).ToString
			End If

			Dim textSize As Size = GetTextSize(g, strItem, Font)
			Dim top As Integer = bounds.Top + (bounds.Height - textSize.Height) / 2
			g.DrawString(strItem, Font, brush, New Drawing.PointF(bounds.Left + 1, top))

		End If
	End Sub

	Protected Overrides Sub DrawComboBoxItemEx(ByVal g As Graphics, ByVal bounds As Rectangle, ByVal Index As Integer, ByVal selected As Boolean, ByVal editSel As Boolean)
		'// This "hack" is necessary to avoid a clipping bug that comes from the fact that sometimes
		'// we are drawing using the Graphics object for the edit control in the combobox and sometimes
		'// we are using the graphics object for the combobox itself. If we use the same function to do our custom
		'// drawing it is hard to adjust for the clipping because of what was said about

		Dim strItem As String

		MyBase.DrawComboBoxItemEx(g, bounds, Index, selected, editSel)
		If Index <> -1 Then

			Dim brush As SolidBrush
			If selected And editSel Then
				brush = New SolidBrush(SystemColors.MenuText)
			ElseIf (selected) Then
				brush = New SolidBrush(SystemColors.HighlightText)
			Else
				brush = New SolidBrush(SystemColors.MenuText)

				If Me.DisplayMember <> "" Then
					Try
						strItem = CallByName(Items(Index), Me.DisplayMember, CallType.Get, Nothing)
					Catch
						strItem = Items(Index).ToString
					End Try
				Else
					strItem = Items(Index).ToString
				End If

				Dim textSize As Size = GetTextSize(g, strItem, Font)
				Dim top As Integer = bounds.Top + (bounds.Height - textSize.Height) / 2
				'// Clipping rectangle
				Dim clipRect As RectangleF = New RectangleF(bounds.Left + 4, top, bounds.Width - ARROW_WIDTH - 4, top + textSize.Height)
				g.DrawString(strItem, Font, brush, clipRect)
			End If
		End If
	End Sub

	Public Shared Function GetTextSize(ByVal graphics As Graphics, ByVal text As String, ByVal font As Font) As Size
		Dim hdc As IntPtr = graphics.GetHdc()
		Dim fontHandle As IntPtr = font.ToHfont()
		Dim currentFontHandle As IntPtr = Win32API.SelectObject(hdc, fontHandle)

		Dim rect As Win32API.RECT = New Win32API.RECT()
		rect.left = 0
		rect.right = 0
		rect.top = 0
		rect.bottom = 0

		Win32API.DrawText(hdc, text, text.Length, rect, _
		 (Win32API.DrawTextFormatFlags.DT_SINGLELINE Or Win32API.DrawTextFormatFlags.DT_LEFT Or Win32API.DrawTextFormatFlags.DT_CALCRECT))
		Win32API.SelectObject(hdc, currentFontHandle)
		Win32API.DeleteObject(fontHandle)
		graphics.ReleaseHdc(hdc)

		Return New Size(rect.right - rect.left, rect.bottom - rect.top)
	End Function

	Protected Overrides Function ProcessCmdKey(ByRef msg As System.Windows.Forms.Message, ByVal keyData As System.Windows.Forms.Keys) As Boolean

		If keyData = Keys.Tab And Me.IsLastTabStop Then
			FlatControlsShared.SelectFirstControlInContainer(Me)
			Return True
		Else
			Return MyBase.ProcessCmdKey(msg, keyData)
		End If

	End Function

	Protected Overrides Function ProcessDialogKey(ByVal keyData As System.Windows.Forms.Keys) As Boolean

		If keyData = Keys.KeyCode.Enter Then
			RaiseEvent EnterPressed()
			Return True			 ' kill the beep
		Else
			Return MyBase.ProcessDialogKey(keyData)
		End If

	End Function
End Class
