Public Class FlatDropButton
    Inherits System.Windows.Forms.UserControl

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call

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
	Friend WithEvents cmdDrop As System.Windows.Forms.Button
	<System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
		Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(FlatDropButton))
		Me.cmdDrop = New System.Windows.Forms.Button()
		Me.SuspendLayout()
		'
		'cmdDrop
		'
		Me.cmdDrop.Anchor = ((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Bottom) _
					Or System.Windows.Forms.AnchorStyles.Left)
		Me.cmdDrop.FlatStyle = System.Windows.Forms.FlatStyle.Flat
		Me.cmdDrop.Image = CType(resources.GetObject("cmdDrop.Image"), System.Drawing.Bitmap)
		Me.cmdDrop.Location = New System.Drawing.Point(-1, -1)
		Me.cmdDrop.Name = "cmdDrop"
		Me.cmdDrop.Size = New System.Drawing.Size(21, 21)
		Me.cmdDrop.TabIndex = 0
		'
		'FlatDropButton
		'
		Me.Controls.AddRange(New System.Windows.Forms.Control() {Me.cmdDrop})
		Me.Name = "FlatDropButton"
		Me.Size = New System.Drawing.Size(19, 19)
		Me.ResumeLayout(False)

	End Sub

#End Region

	Public Shadows Event Click(ByVal sender As Object, ByVal e As System.EventArgs)
	Public Event MouseMoved()

	Private Sub cmdDrop_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles cmdDrop.Click
		RaiseEvent Click(sender, e)
	End Sub

	Private Sub cmdDrop_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles cmdDrop.MouseMove
		RaiseEvent MouseMoved()
	End Sub

	Private Sub cmdDrop_MouseEnter(ByVal sender As Object, ByVal e As System.EventArgs) Handles cmdDrop.MouseEnter
		RaiseEvent MouseMoved()

	End Sub
End Class
