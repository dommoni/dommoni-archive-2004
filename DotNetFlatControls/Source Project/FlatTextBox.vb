Imports System.Runtime.InteropServices
Imports System.Drawing
Imports System.ComponentModel
Imports dotNetFlatControls.FlatControlsShared

Public Class ColorConverter
    Inherits TypeConverter

    '' ?>?>1 As time permits, figure out how to implement a type converter for a class or property.

    'Public Overloads Overrides Function CanConvertFrom(ByVal context As System.ComponentModel.ITypeDescriptorContext, ByVal sourceType As System.Type) As Boolean
    '    If sourceType.Equals(GetType(System.String)) Or _
    '    sourceType.Equals(GetType(System.Drawing.Color)) Then
    '        Return True
    '    End If
    'End Function

    'Public Overloads Overrides Function CanConvertTo(ByVal context As System.ComponentModel.ITypeDescriptorContext, ByVal destinationType As System.Type) As Boolean
    '    If destinationType.Equals(GetType(System.String)) Or _
    '    destinationType.Equals(GetType(System.Drawing.Color)) Then
    '        Return True
    '    End If
    'End Function

    'Public Overloads Overrides Function ConvertTo(ByVal context As System.ComponentModel.ITypeDescriptorContext, ByVal culture As System.Globalization.CultureInfo, ByVal value As Object, ByVal destinationType As System.Type) As Object

    '    Select Case destinationType.Name

    '        Case GetType(Color).Name

    '            Dim color As Color = value

    '            Return color.Name.ToString

    '        Case GetType(String).Name

    '            Return color.FromName(value)

    '    End Select
    'End Function

End Class


Public Class FlatTextBox
    Inherits System.Windows.Forms.TextBox

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call
        Me.BorderStyle = BorderStyle.FixedSingle
        Me.AutoSize = False

    End Sub

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
		m_BorderColor = Color.DarkGray	   '	Color.LightGray ' Changed 10/10 DLH ?>?>
		m_HighlightColor = Color.RoyalBlue
		m_bIsEditable = True
        components = New System.ComponentModel.Container()
    End Sub

#End Region

    Private m_BorderColor As Color
    Private m_HighlightColor As Color
	Private m_bIsEditable As Boolean = True
	Private m_bIsLastTabStop As Boolean
    'TODO Put back: Private m_Format As FormatType
    Private m_Format As Integer
    Private m_FormatString As String
	Private m_InitialFontSize As Single

	Private bIsHighlight As Boolean
	Private bAutoAdjustBorderColor As Boolean = False

	Public Event EnterPressed()
	Public Event HighlightChanged(ByVal bIsHighlight As Boolean)

#Region " Protected Overrides"

	Protected Overrides Sub OnGotFocus(ByVal e As System.EventArgs)
		MyBase.OnGotFocus(e)
		DrawBorder()
	End Sub

	Protected Overrides Sub WndProc(ByRef m As Message)
		Dim doPainting As Boolean = False
		Select Case m.Msg
			Case Win32API.Msg.WM_PAINT
				doPainting = True

			Case Else
				Exit Select

		End Select
		MyBase.WndProc(m)

		'  Now let's do our own painting
		'  We have to do it after the textbox does its own painting in case we need to 
		'  paint over an existing border of a different color
		If doPainting Then DrawBorder()

	End Sub

#End Region

#Region " Properties"

	Protected Overrides ReadOnly Property DefaultSize() As Size
		Get
			Return New Size(100, 23)
		End Get
	End Property

	<DefaultValue(False), Browsable(True)> _
	Public Property AutoAdjustBorderColor() As Boolean
		Get
			Return bAutoAdjustBorderColor
		End Get
		Set(ByVal Value As Boolean)
			bAutoAdjustBorderColor = Value
		End Set
	End Property

	Public Property IsHighlighted() As Boolean
		Get
			Return bIsHighlight
		End Get
		Set(ByVal Value As Boolean)
			bIsHighlight = False
			DrawBorder()
		End Set
	End Property
	'<TypeConverter(GetType(ColorConverter))> _  ?>?>  see:  ?>1
	Public Property BorderColor() As Color
		Get
			Return m_BorderColor
		End Get
		Set(ByVal Value As Color)
			m_BorderColor = Value
			' bAutoAdjustBorderColor = False ?>?> 
			'  Try and find a way to have this turned off only if being set while in design-mode
			DrawBorder()
		End Set
	End Property
	Public ReadOnly Property ActiveBorderColor() As Color
		Get
			' Returns the active border color, whether regular or highlight
			If bIsHighlight Then
				Return m_HighlightColor
			Else
				Return m_BorderColor
			End If
		End Get
	End Property
	Public Property HighlightColor() As Color
		Get
			Return m_HighlightColor
		End Get
		Set(ByVal Value As Color)
			m_HighlightColor = Value
			DrawBorder()
		End Set
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

	Public Property IsLastTabStop() As Boolean
		Get
			Return m_bIsLastTabStop
		End Get
		Set(ByVal Value As Boolean)
			m_bIsLastTabStop = Value
		End Set
	End Property

	Public Property FormatString() As String
		Get

            If m_FormatString = "" Then
                Return m_FormatString
            Else
                'Select Case m_Format

                '    Case FormatType.Format_ShortDate
                '        Return "Short Date"

                '    Case FormatType.Format_Date
                '        Return "Long Date"

                '    Case FormatType.Format_Time
                '        Return TIME_FORMAT_SHORT

                '    Case FormatType.Format_Phone
                '        Return "(###) ###-####"

                '    Case FormatType.Format_SSN
                '        Return "###-##-####"

                '    Case FormatType.Format_Currency
                '        Return "Currency"

                '    Case Else

                        If FormatString <> "" Then
                            Me.Text = Me.Text.Format(m_FormatString)
                        End If

                'End Select

            End If
		End Get
		Set(ByVal Value As String)
			m_FormatString = Value
		End Set
	End Property
    'TODO: Put back    Public Property FormatStyle() As FormatType 
    Public Property FormatStyle() As Integer
        Get
            Return m_Format
        End Get
        Set(ByVal Value As Integer)
            m_Format = Value
        End Set
    End Property

    Public ReadOnly Property InitialFontSize() As Single
        Get
            Return m_InitialFontSize
        End Get
    End Property

#End Region

#Region " Friend Subs"

	Friend Sub DrawBorder()

		Dim curColor As Color

		If bIsHighlight Then
			curColor = m_HighlightColor
		Else
			curColor = m_BorderColor
		End If

		DrawBorder(curColor)

	End Sub

	Friend Sub DrawBorder(ByVal newBorderColor As Color)

		Dim g As Graphics = CreateGraphics()
		g.DrawRectangle(New Pen(newBorderColor), ClientRectangle.Left, ClientRectangle.Top, _
		  ClientRectangle.Width - 1, ClientRectangle.Height - 1)

	End Sub

#End Region

#Region " Private Subs"

	Private Sub FlatTextBox_MouseEnter(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.MouseEnter
		bIsHighlight = True
		RaiseEvent HighlightChanged(bIsHighlight)
		DrawBorder()
	End Sub

	Private Sub FlatTextBox_MouseLeave(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.MouseLeave
		If Not Me.Focused Then
			bIsHighlight = False
			RaiseEvent HighlightChanged(bIsHighlight)
		End If
		DrawBorder()
	End Sub

	Private Sub FlatTextBox_Leave(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Leave
		bIsHighlight = False
		RaiseEvent HighlightChanged(bIsHighlight)
		DrawBorder()
	End Sub

	Private Sub FlatTextBox_Enter(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Enter
		bIsHighlight = True
		RaiseEvent HighlightChanged(bIsHighlight)
		DrawBorder()
	End Sub

	Private Sub FlatTextBox_Resize(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Resize

		' If the AutoAdjustBorderColor is enabled and the container's backcolor is white,
		' set the border to a dark gray instead of the default light gray.

		If AutoAdjustBorderColor Then
			If Not Me.Parent Is Nothing Then
				If Me.Parent.BackColor().Equals(Color.White) Then
					BorderColor = Color.DarkGray
				Else
					BorderColor = Color.LightGray
				End If
			End If
		End If

		DrawBorder()

	End Sub

#End Region

	Private Sub FlatTextBox_KeyDown(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyEventArgs) Handles MyBase.KeyDown

		If e.KeyCode = Keys.Tab And Me.IsLastTabStop Then
			SelectFirstControlInContainer(Me)
		End If

	End Sub

	Protected Overrides Function ProcessCmdKey(ByRef msg As System.Windows.Forms.Message, ByVal keyData As System.Windows.Forms.Keys) As Boolean

		If keyData = Keys.Tab And Me.IsLastTabStop Then
			SelectFirstControlInContainer(Me)
			Return True

		ElseIf keyData = Keys.Enter Then
			RaiseEvent EnterPressed()
			If Me.Multiline Then
				Me.AppendText(vbCrLf)
			End If
			Return True			 ' prevent the beep on press of Enter

		Else
			MyBase.ProcessCmdKey(msg, keyData)

		End If

	End Function

	Protected Overrides Sub OnLostFocus(ByVal e As System.EventArgs)

        If Not Me.Text = "" Then

            'TODO: Put back
            'Try

            '	Select Case m_Format

            '		Case FormatType.Format_ShortDate
            '			Me.Text = Format(CDate(Me.Text), "Short Date")

            '		Case FormatType.Format_Date
            '			If Me.FormatString > "" Then

            '				If IsDate(Format(Me.Text, FormatString)) Then
            '					Me.Text = Format(CDate(Me.Text), FormatString)
            '				Else
            '					Me.Text = Format(CDate(Me.Text), "Long Date")
            '				End If
            '			End If

            '		Case FormatType.Format_Time
            '			Me.Text = Format(Me.Text, TIME_FORMAT_SHORT)

            '		Case FormatType.Format_Phone
            '			Me.Text = Format(CLng(StripNonNumbers(Me.Text)), "(###) ###-####")

            '		Case FormatType.Format_SSN
            '			Me.Text = Format(CLng(StripNonNumbers(Me.Text)), "###-##-####")

            '		Case FormatType.Format_Currency
            '			Me.Text = Format(Me.Text, "Currency")

            '		Case Else

            If FormatString <> "" Then
                Me.Text = Me.Text.Format(m_FormatString)
            End If

            '	End Select
            'Catch ex As Exception
            '	' to catch any dates/times/invalid numbers, etc.
            '	Console.WriteLine("Error in FlatTextBox.OnLostFocus: " & ex.Message)
            '	Me.Text = ""
            'End Try

        End If

        MyBase.OnLostFocus(e)

	End Sub

	Private Function StripNonNumbers(ByVal str2Clean As String) As String

		Dim strChar As String
		Dim iChar As Integer

		For iChar = 1 To Len(str2Clean)

			strChar = Mid(str2Clean, iChar, 1)

			If Asc(strChar) >= Asc("0") And _
			 Asc(strChar) <= Asc("9") Then
				StripNonNumbers = StripNonNumbers & strChar
			End If
		Next

	End Function

	Protected Overrides Sub OnKeyPress(ByVal e As System.Windows.Forms.KeyPressEventArgs)

		If Not m_bIsEditable Then
			e.Handled = True
			Exit Sub
		End If

		Select Case Me.FormatStyle

            ' TODO: Put back
            'Case FormatType.Format_ShortDate, FormatType.Format_Number, FormatType.Format_Phone, FormatType.Format_SSN, FormatType.Format_Time, FormatType.Format_Currency

            '	If Char.IsLetter(e.KeyChar) Then
            '		e.Handled = True
            '	End If

		End Select

	End Sub

	Private Sub FlatTextBox_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

	End Sub
End Class
