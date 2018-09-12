Public Class FlatListBox
	Inherits System.Windows.Forms.ListBox

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call
		Me.BorderStyle = BorderStyle.None
		m_BorderColor = Color.LightGray

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
		components = New System.ComponentModel.Container()

	End Sub

#End Region

	Private m_BorderColor As Color
	Private m_InitialFontSize As Single

	Public Property BorderColor() As Color
		Get
			Return m_BorderColor
		End Get
		Set(ByVal Value As Color)
			If Not m_BorderColor.Equals(Value) Then
				m_BorderColor = Value
				Me.Refresh()
			End If
		End Set
	End Property
	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

	Protected Overrides Sub WndProc(ByRef m As System.Windows.Forms.Message)
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
		If doPainting Then

			Dim g As Graphics = CreateGraphics()

			' draw the border
			g.DrawRectangle(New Pen(m_BorderColor), ClientRectangle.Left, ClientRectangle.Top, _
			  ClientRectangle.Width - 1, ClientRectangle.Height - 1)

		End If

	End Sub

	Private Sub FlatListBox_Resize(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Resize

		Me.Refresh()

	End Sub

	Private Sub FlatListBox_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.SelectedIndexChanged

		Me.Refresh()

	End Sub

	Private Sub FlatListBox_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

	End Sub
End Class
