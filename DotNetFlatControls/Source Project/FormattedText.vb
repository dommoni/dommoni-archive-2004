Public Class FormattedText
	Inherits System.Windows.Forms.Label

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
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
		'
		'FormattedText
		'
		Me.Name = "FormattedText"
		Me.Size = New System.Drawing.Size(264, 62)

	End Sub

#End Region


	Protected Overrides Sub OnPaint(ByVal e As System.Windows.Forms.PaintEventArgs)

		Dim g As Graphics = Me.Parent.CreateGraphics()

		'		g.DrawString(Me.Text, Me.Font, New SolidBrush(Me.ForeColor), Me.Left, Me.Top)

	End Sub

End Class
