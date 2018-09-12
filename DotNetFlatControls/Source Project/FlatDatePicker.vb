Imports dotNetFlatControls.FlatControlsShared

Public Class FlatDatePicker
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
	Friend WithEvents txtDate As dotNetFlatControls.FlatTextBox
	Friend WithEvents MonthCalendar1 As System.Windows.Forms.MonthCalendar
	Friend WithEvents cmdDropDate As dotNetFlatControls.FlatDropButton
	<System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
		Me.txtDate = New dotNetFlatControls.FlatTextBox()
		Me.MonthCalendar1 = New System.Windows.Forms.MonthCalendar()
		Me.cmdDropDate = New dotNetFlatControls.FlatDropButton()
		Me.SuspendLayout()
		'
		'txtDate
		'
		Me.txtDate.AutoSize = False
		Me.txtDate.BorderColor = System.Drawing.Color.Gray
		Me.txtDate.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
		Me.txtDate.FormatString = ""
        ' TODO: Me.txtDate.FormatStyle = dotNetFlatControls.FlatControlsShared.FormatType.Format_Date
		Me.txtDate.HighlightColor = System.Drawing.SystemColors.Highlight
		Me.txtDate.IsHighlighted = False
		Me.txtDate.IsLastTabStop = False
		Me.txtDate.Name = "txtDate"
		Me.txtDate.Size = New System.Drawing.Size(159, 21)
		Me.txtDate.TabIndex = 18
		Me.txtDate.Text = ""
		'
		'MonthCalendar1
		'
		Me.MonthCalendar1.Location = New System.Drawing.Point(0, 21)
		Me.MonthCalendar1.Name = "MonthCalendar1"
		Me.MonthCalendar1.TabIndex = 20
		Me.MonthCalendar1.TabStop = False
		Me.MonthCalendar1.Visible = False
		'
		'cmdDropDate
		'
		Me.cmdDropDate.Anchor = (System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Right)
		Me.cmdDropDate.Location = New System.Drawing.Point(140, 2)
		Me.cmdDropDate.Name = "cmdDropDate"
		Me.cmdDropDate.Size = New System.Drawing.Size(18, 17)
		Me.cmdDropDate.TabIndex = 22
		Me.cmdDropDate.TabStop = False
		'
		'FlatDatePicker
		'
		Me.Controls.AddRange(New System.Windows.Forms.Control() {Me.cmdDropDate, Me.MonthCalendar1, Me.txtDate})
		Me.Name = "FlatDatePicker"
		Me.Size = New System.Drawing.Size(160, 21)
		Me.ResumeLayout(False)

	End Sub

#End Region

	Private bIgnoreResize As Boolean = False
	Private m_InitialFontSize As Single

	Private dtDate As Date

	Public Overrides Property Text() As String
		Get
			Return txtDate.Text
		End Get
		Set(ByVal Value As String)
			txtDate.Text = Value
		End Set
	End Property
	Public Property DateFormat() As String
		Get
			Return txtDate.FormatString
		End Get
		Set(ByVal Value As String)
			txtDate.FormatString = Value
		End Set
	End Property
	Public Property DateFormatType() As ueDateFormatType
		Get
			Return txtDate.FormatStyle
		End Get
		Set(ByVal Value As ueDateFormatType)
			txtDate.FormatStyle = Value
		End Set
	End Property
	Public Property SelectedDate() As Date
		Get
			Return dtDate
		End Get
		Set(ByVal Value As Date)
			Try
				MonthCalendar1.SetDate(Value)
				dtDate = Value
				SetTextDate()
			Catch
				MonthCalendar1.SetDate(Now)
				dtDate = Now
			End Try
		End Set
	End Property
	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

	Private Sub MonthCalendar1_DateSelected(ByVal sender As Object, ByVal e As System.Windows.Forms.DateRangeEventArgs) Handles MonthCalendar1.DateSelected

		Dim strTest As String

		dtDate = e.Start

		SetTextDate()

		MonthCalendar1.Visible = False
	End Sub

	Private Sub SetTextDate()
		' Verify that the date format is viable; if not, default to short date
		If IsDate(Format(dtDate, txtDate.FormatString)) And txtDate.FormatString > "" Then
			txtDate.Text = Format(dtDate, txtDate.FormatString)
		Else
			Select Case DateFormatType
				Case ueDateFormatType.ueDateFormat_LongDate
					txtDate.Text = Format(dtDate, "Long Date")
				Case ueDateFormatType.ueDateFormat_ShortDate
					txtDate.Text = Format(dtDate, "Short Date")
				Case ueDateFormatType.ueDateFormat_MediumDate
					txtDate.Text = Format(dtDate, DATE_FORMAT_MEDIUM)
			End Select
		End If
	End Sub

	Private Sub ShowCalendar(ByVal bShow As Boolean)

		bIgnoreResize = True
		cmdDropDate.Anchor = AnchorStyles.Top Or AnchorStyles.Left
		If bShow Then
			MonthCalendar1.Visible = True
			If Not Me.Width >= MonthCalendar1.Width Then
				Me.Width = MonthCalendar1.Width
			End If
			Me.Height = MonthCalendar1.Top + MonthCalendar1.Height
		Else
			MonthCalendar1.Visible = False
			Me.Height = txtDate.Height
			Me.Width = txtDate.Width
		End If
		bIgnoreResize = False

	End Sub

	Private Sub txtDate_Validating(ByVal sender As Object, ByVal e As System.ComponentModel.CancelEventArgs) Handles txtDate.Validating

		If IsDate(txtDate.Text) Then
			dtDate = CDate(txtDate.Text)
			MonthCalendar1.SetDate(dtDate)
		ElseIf txtDate.Text = "" Then
			dtDate = Now
			MonthCalendar1.SetDate(dtDate)
		End If

	End Sub

	Private Sub FlatDatePicker_Paint(ByVal sender As Object, ByVal e As System.Windows.Forms.PaintEventArgs) Handles MyBase.Paint

		cmdDropDate.BackColor = ColorUtil.VSNetStripeColor
		DrawBorder()

	End Sub

	Private Sub DrawBorder()

		Dim g As Graphics = CreateGraphics()

		'' Draw the white border around the dropdown arrow
		'g.DrawRectangle(New Pen(Color.WhiteSmoke), _
		' New Rectangle(cmdDropDate.Left, 1, cmdDropDate.Width, cmdDropDate.Height))

		' Draw the border around the whole thing - dropdown arrow included
		g.DrawRectangle(New Pen(txtDate.ActiveBorderColor), _
		 New Rectangle(0, 0, cmdDropDate.Right, cmdDropDate.Height + 1))

	End Sub
	Private Sub txtDate_HighlightChanged(ByVal bIsHighlight As Boolean) Handles txtDate.HighlightChanged

		DrawBorder()

	End Sub

	Private Shadows Sub cmdDropDate_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles cmdDropDate.Click
		ShowCalendar(Not MonthCalendar1.Visible)
	End Sub

	Private Sub FlatDatePicker_Resize(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Resize

		If Not bIgnoreResize Then

			bIgnoreResize = True

			txtDate.Width = Me.Width

			bIgnoreResize = False

		End If


	End Sub

	Private Sub MonthCalendar1_VisibleChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MonthCalendar1.VisibleChanged

		If Not MonthCalendar1.Visible Then
			ShowCalendar(False)
			Me.Refresh()
		End If
	End Sub

	Private Sub FlatDatePicker_Leave(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Leave

		txtDate.IsHighlighted = False

		ShowCalendar(False)

		If IsDate(txtDate.Text) Then
			dtDate = CDate(txtDate.Text)
			SetTextDate()
		End If

	End Sub

	Private Sub MonthCalendar1_Leave(ByVal sender As Object, ByVal e As System.EventArgs) Handles MonthCalendar1.Leave

		ShowCalendar(False)

	End Sub


	Private Sub cmdDropDate_MouseMoved() Handles cmdDropDate.MouseMoved
		txtDate.IsHighlighted = True
	End Sub

	Private Sub FlatDatePicker_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

		txtDate.Font = Me.Font

	End Sub

End Class
