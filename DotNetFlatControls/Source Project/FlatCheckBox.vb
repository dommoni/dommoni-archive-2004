Imports System.ComponentModel

Public Class FlatCheckBox
	Inherits System.Windows.Forms.CheckBox

#Region " Windows Form Designer generated code "

	Public Sub New()
		MyBase.New()

		'This call is required by the Windows Form Designer.
		InitializeComponent()

		'Add any initialization after the InitializeComponent() call
		Me.FlatStyle = FlatStyle.Flat

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

	Private m_bIsLastTabStop As Boolean
	Private m_FixedValue As Integer
	Private m_AutoSizeHeight As Boolean = False
	Private m_AutoSizeWidth As Boolean = True
	Private m_LineCount As Integer = 1
	Private m_InitialFontSize As Single

#Region "Properties"

	Public Property IsLastTabStop() As Boolean
		Get
			Return m_bIsLastTabStop
		End Get
		Set(ByVal Value As Boolean)
			m_bIsLastTabStop = Value
		End Set
	End Property
	Public Property FixedValue() As Integer
		Get
			Return m_FixedValue
		End Get
		Set(ByVal Value As Integer)
			m_FixedValue = Value
		End Set
	End Property

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

	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

	Private Sub FlatLabel_Layout(ByVal sender As Object, ByVal e As System.Windows.Forms.LayoutEventArgs) Handles MyBase.Layout

		AutoAdjust()

	End Sub

#End Region

	Private Sub AutoAdjust()

		If m_AutoSizeHeight Then
			Me.Height = Me.FontHeight * m_LineCount
		End If

		If m_AutoSizeWidth Then
			If Me.Text > "" Then
				Dim g As Graphics = CreateGraphics()
				Me.Width = g.MeasureString(Me.Text, Me.Font).Width + 24
			End If
		End If
	End Sub

	Protected Overrides Function ProcessCmdKey(ByRef msg As System.Windows.Forms.Message, ByVal keyData As System.Windows.Forms.Keys) As Boolean

		If keyData = Keys.Tab And Me.IsLastTabStop Then
			FlatControlsShared.SelectFirstControlInContainer(Me)
			Return True
		End If

	End Function

	Private Sub FlatCheckBox_Layout(ByVal sender As Object, ByVal e As System.Windows.Forms.LayoutEventArgs) Handles MyBase.Layout

		AutoAdjust()

	End Sub

	Private Sub FlatCheckBox_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

	End Sub

End Class
