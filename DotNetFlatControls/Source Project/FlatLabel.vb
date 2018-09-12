Imports System.ComponentModel

Public Class FlatLabel
	Inherits System.Windows.Forms.Label

#Region " Windows Form Designer generated code "

	Public Sub New()
		MyBase.New()

		'This call is required by the Windows Form Designer.
		InitializeComponent()

		'Add any initialization after the InitializeComponent() call
		SetStyle(ControlStyles.SupportsTransparentBackColor, True)

		Me.IsTransparent = True

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

		Font = New System.Drawing.Font("Microsoft Sans Serif", 8, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
		components = New System.ComponentModel.Container()
	End Sub

#End Region

	Private m_AutoSizeHeight As Boolean = False
	Private m_AutoSizeWidth As Boolean = True
	Private m_LineCount As Integer = 1
	Private m_InitialFontSize As Single
	Private m_IsTransparent As Boolean
	Private m_IsVisible As Boolean = True

	<DefaultValue(False)> _
 Public Property AutoSizeHeight() As Boolean
		Get
			Return m_AutoSizeHeight
		End Get
		Set(ByVal Value As Boolean)
			m_AutoSizeHeight = Value
		End Set
	End Property

	<DefaultValue(True)> _
	Public Property AutoSizeWidth() As Boolean
		Get
			Return m_AutoSizeWidth
		End Get
		Set(ByVal Value As Boolean)
			m_AutoSizeWidth = Value
		End Set
	End Property

	<DefaultValue(1)> _
	 Public Property LineCount() As Integer
		Get
			Return m_LineCount
		End Get
		Set(ByVal Value As Integer)
			m_LineCount = Value
		End Set
	End Property

	<DefaultValue(True)> _
	Public Property IsTransparent() As Boolean
		Get
			Return m_IsTransparent
		End Get
		Set(ByVal Value As Boolean)
			m_IsTransparent = Value
		End Set
	End Property

	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

	<DefaultValue(True)> _
	Public Property IsVisible() As Boolean
		Get
			Return m_IsVisible
		End Get
		Set(ByVal Value As Boolean)
			If m_IsVisible <> Value Then
				m_IsVisible = Value
				If Me.Parent.GetType.Equals(GetType(GradientPanel)) Then
					Me.Parent.Refresh()
				End If
			End If
		End Set
	End Property
	Private Sub FlatLabel_Layout(ByVal sender As Object, ByVal e As System.Windows.Forms.LayoutEventArgs) Handles MyBase.Layout

		AutoAdjust()

	End Sub

	Private Sub AutoAdjust()

		If m_AutoSizeHeight Then
			Me.Height = Me.FontHeight * m_LineCount
		End If

		If m_AutoSizeWidth Then
			If Me.Text > "" Then
				Dim g As Graphics = CreateGraphics()
				Me.Width = g.MeasureString(Me.Text, Me.Font).Width + 2
			End If
		End If
	End Sub

	Private Sub FlatLabel_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

		AutoAdjust()

	End Sub

	Protected Overrides Sub OnPaint(ByVal e As System.Windows.Forms.PaintEventArgs)

		SetStyle(ControlStyles.SupportsTransparentBackColor, True)
		Me.BackColor = Color.Transparent

		MyBase.OnPaint(e)

	End Sub
End Class
