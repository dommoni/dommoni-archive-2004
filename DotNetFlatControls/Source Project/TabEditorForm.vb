Imports dotNetFlatControls

Public Class TabEditorForm
	Inherits System.Windows.Forms.Form

#Region " Windows Form Designer generated code "

	Public Sub New()
		MyBase.New()

		'This call is required by the Windows Form Designer.
		InitializeComponent()

		'Add any initialization after the InitializeComponent() call

	End Sub

	'Form overrides dispose to clean up the component list.
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
	Friend WithEvents cmdOK As System.Windows.Forms.Button
	Friend WithEvents cmdCancel As System.Windows.Forms.Button
	Friend WithEvents txtTabNames As FlatTextBox
	Friend WithEvents lblInstructions As System.Windows.Forms.Label
	<System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
		Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(TabEditorForm))
		Me.cmdOK = New System.Windows.Forms.Button()
		Me.cmdCancel = New System.Windows.Forms.Button()
		Me.txtTabNames = New FlatTextBox()
		Me.lblInstructions = New System.Windows.Forms.Label()
		Me.SuspendLayout()
		'
		'cmdOK
		'
		Me.cmdOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat
		Me.cmdOK.Font = New System.Drawing.Font("Microsoft Sans Serif", 7.8!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
		Me.cmdOK.Location = New System.Drawing.Point(43, 252)
		Me.cmdOK.Name = "cmdOK"
		Me.cmdOK.TabIndex = 1
		Me.cmdOK.Text = "OK"
		'
		'cmdCancel
		'
		Me.cmdCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat
		Me.cmdCancel.Location = New System.Drawing.Point(149, 252)
		Me.cmdCancel.Name = "cmdCancel"
		Me.cmdCancel.TabIndex = 2
		Me.cmdCancel.Text = "Cancel"
		'
		'txtTabNames
		'
		Me.txtTabNames.AutoSize = False
		Me.txtTabNames.BorderColor = System.Drawing.Color.LightGray
		Me.txtTabNames.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
		Me.txtTabNames.Editable = True
        ' TODO: Me.txtTabNames.FormatStyle = FlatControlsShared.FormatType.Format_None
		Me.txtTabNames.HighlightColor = System.Drawing.SystemColors.Highlight
		Me.txtTabNames.IsLastTabStop = False
		Me.txtTabNames.Location = New System.Drawing.Point(14, 76)
		Me.txtTabNames.Multiline = True
		Me.txtTabNames.Name = "txtTabNames"
		Me.txtTabNames.Size = New System.Drawing.Size(238, 166)
		Me.txtTabNames.TabIndex = 3
		Me.txtTabNames.Text = ""
		'
		'lblInstructions
		'
		Me.lblInstructions.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.0!)
		Me.lblInstructions.Location = New System.Drawing.Point(14, 15)
		Me.lblInstructions.Name = "lblInstructions"
		Me.lblInstructions.Size = New System.Drawing.Size(238, 51)
		Me.lblInstructions.TabIndex = 4
		Me.lblInstructions.Text = "Enter each tab name on a seperate line in the order you'd like it to appear. Use " & _
		"Ctrl+Enter for a new line."
		'
		'TabEditorForm
		'
		Me.AutoScaleBaseSize = New System.Drawing.Size(6, 15)
		Me.ClientSize = New System.Drawing.Size(266, 288)
		Me.Controls.AddRange(New System.Windows.Forms.Control() {Me.lblInstructions, Me.txtTabNames, Me.cmdCancel, Me.cmdOK})
		Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
		Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
		Me.KeyPreview = True
		Me.MaximizeBox = False
		Me.MinimizeBox = False
		Me.Name = "TabEditorForm"
		Me.Text = "    Edit Tab Names"
		Me.ResumeLayout(False)

	End Sub

#End Region

	Public Cancel As Boolean = True

	Public Property TabNames() As String
		Get
			Return txtTabNames.Text
		End Get
		Set(ByVal Value As String)
			txtTabNames.Text = Value
		End Set
	End Property

	Private Sub cmdOK_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles cmdOK.Click

		Cancel = False

		Me.Close()

	End Sub

	Private Sub cmdCancel_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles cmdCancel.Click
		Cancel = True

		Me.Close()

	End Sub

	Private Sub TabEditorForm_KeyUp(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyEventArgs) Handles MyBase.KeyUp
		If e.KeyCode = Keys.Enter And e.Modifiers = 0 Then
			Cancel = False
			Me.Close()
		End If
	End Sub
End Class
