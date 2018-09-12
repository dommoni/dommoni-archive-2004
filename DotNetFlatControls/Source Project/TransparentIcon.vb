Imports System.ComponentModel
Public Class TransparentIcon
	Inherits System.Windows.Forms.Panel

#Region " Windows Form Designer generated code "

	Public Sub New()
		MyBase.New()

		'This call is required by the Windows Form Designer.
		InitializeComponent()

		'Add any initialization after the InitializeComponent() call
		bIsTransparent = True
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

	Private oIcon As Icon
	Private bIsTransparent As Boolean
	Private oSize As Size

	<DefaultValue(True)> _
	Public Property IsTransparent() As Boolean
		Get
			Return bIsTransparent
		End Get
		Set(ByVal Value As Boolean)
			bIsTransparent = Value
		End Set
	End Property


	Public Property Icon() As Icon
		Get
			Return oIcon
		End Get
		Set(ByVal Value As Icon)

			oIcon = Value

			If Not oSize.IsEmpty Then
				oIcon = New Icon(oIcon, oSize)
			End If

		End Set
	End Property

	Public ReadOnly Property CurrentIconSize() As Size
		Get
			Return oIcon.Size
		End Get
	End Property

	Public Property IconSize() As Size
		Get
			Return oSize
		End Get
		Set(ByVal Value As Size)
			oSize = Value
		End Set
	End Property

End Class
