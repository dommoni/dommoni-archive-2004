Public Class BorderListView
	Inherits System.Windows.Forms.ListView

#Region " Windows Form Designer generated code "

	Public Sub New()
		MyBase.New()

		'This call is required by the Windows Form Designer.
		InitializeComponent()

		'Add any initialization after the InitializeComponent() call

	End Sub

	'UserControl1 overrides dispose to clean up the component list.
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
		Me.SuspendLayout()
		'
		'
		'BorderListView
		'
		Me.Name = "BorderListView"
		Me.Size = New System.Drawing.Size(200, 114)
		Me.ResumeLayout(False)

	End Sub

#End Region

	Private oBorderColor As Color

	Public Property BorderColor() As Color
		Get
			Return oBorderColor
		End Get
		Set(ByVal Value As Color)
			oBorderColor = Value
		End Set
	End Property

	Protected Overrides Sub OnPaint(ByVal e As System.Windows.Forms.PaintEventArgs)

		Try

			MyBase.OnPaint(e)

			Dim g As Graphics = CreateGraphics()

			g.DrawRectangle(New Pen(oBorderColor), New Rectangle(0, 0, Me.Width - 1, Me.Height - 1))

		Catch ex As Exception
			MsgBox("Error in BorderListView.OnPaint: " & ex.Message)

			MsgBox(ex.Message)
		End Try

	End Sub


End Class
