Imports System.ComponentModel

Public Class FlatTab
    Inherits System.Windows.Forms.UserControl

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.0!)
        Me.Index = 0
        Me.Size = New System.Drawing.Size(116, 35)
		Me.TabState = ueTabState.TabState1_Active

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
    Friend WithEvents lblTab As System.Windows.Forms.Label

	<System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
		Me.lblTab = New System.Windows.Forms.Label()
		Me.SuspendLayout()
		'
		'lblTab
		'
		Me.lblTab.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
		Me.lblTab.Location = New System.Drawing.Point(11, 5)
		Me.lblTab.Name = "lblTab"
		Me.lblTab.Size = New System.Drawing.Size(88, 22)
		Me.lblTab.TabIndex = 0
		Me.lblTab.Text = "Label1"
		Me.lblTab.TextAlign = System.Drawing.ContentAlignment.TopCenter
		'
		'FlatTab
		'
		Me.Controls.AddRange(New System.Windows.Forms.Control() {Me.lblTab})
		Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.0!)
		Me.Name = "FlatTab"
		Me.Size = New System.Drawing.Size(116, 35)
		Me.ResumeLayout(False)

	End Sub

#End Region

    Private m_TabState As ueTabState
    Private m_Index As Integer
    Private bIsHighlighted As Boolean
	Private m_InitialFontSize As Single

    ' Drawing Colors
    Private m_ActiveBackColor As Color
    Private m_ActiveForeColor As Color
    Private m_ActiveBorderColor As Color
    Private m_InActiveBackColor As Color
    Private m_InActiveForeColor As Color
    Private m_InActiveBorderColor As Color
    Private m_DisabledBackColor As Color
    Private m_DisabledForeColor As Color
    Private m_DisabledBorderColor As Color
    Private m_HighlightBorderColor As Color

    Public Event Clicked(ByVal index As Integer)

#Region " Properties"

    Public Property TabState() As ueTabState
        Get
            Return m_TabState
        End Get
        Set(ByVal Value As ueTabState)
            If Not Value.Equals(m_TabState) Then
                m_TabState = Value
                DrawTab()
            End If
        End Set
    End Property
	Public Overrides Property Text() As String
		Get
			Return lblTab.Text
		End Get
		Set(ByVal Value As String)
			lblTab.Text = Value
		End Set
	End Property
	Public Property Index() As Integer
		Get
			Return m_Index
		End Get
		Set(ByVal Value As Integer)
			m_Index = Value
		End Set
	End Property
	Public Shadows Property Font() As Font
		Get
			Return lblTab.Font
		End Get
		Set(ByVal Value As Font)
			lblTab.Font = Value
			Me.Refresh()
		End Set
	End Property
	Public Property ActiveBackColor() As Color
		Get
			Return m_ActiveBackColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_ActiveBackColor) Then
				m_ActiveBackColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property ActiveBorderColor() As Color
		Get
			Return m_ActiveBorderColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_ActiveBorderColor) Then
				m_ActiveBorderColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property ActiveForeColor() As Color
		Get
			Return m_ActiveForeColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_ActiveForeColor) Then
				m_ActiveForeColor = Value
				DrawTab()
			End If
		End Set
	End Property

	Public Property InActiveBackColor() As Color
		Get
			Return m_InActiveBackColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_InActiveBackColor) Then
				m_InActiveBackColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property InActiveBorderColor() As Color
		Get
			Return m_InActiveBorderColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_InActiveBorderColor) Then
				m_InActiveBorderColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property InActiveForeColor() As Color
		Get
			Return m_InActiveForeColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_InActiveForeColor) Then
				m_InActiveForeColor = Value
				DrawTab()
			End If
		End Set
	End Property

	Public Property DisabledBackColor() As Color
		Get
			Return m_DisabledBackColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_DisabledBackColor) Then
				m_DisabledBackColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property DisabledBorderColor() As Color
		Get
			Return m_DisabledBorderColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_DisabledBorderColor) Then
				m_DisabledBorderColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property DisabledForeColor() As Color
		Get
			Return m_DisabledForeColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_DisabledForeColor) Then
				m_DisabledForeColor = Value
				DrawTab()
			End If
		End Set
	End Property
	Public Property HighlightBorderColor() As Color
		Get
			Return m_HighlightBorderColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_HighlightBorderColor) Then
				m_HighlightBorderColor = Value
			End If
		End Set
	End Property

	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

#End Region

#Region " Methods"

    Public Sub SelectTab()

        TabState = ueTabState.TabState1_Active
        DrawTab()

    End Sub

    Public Sub DrawTab()

        Dim g As Graphics = CreateGraphics()
        Dim rect As Rectangle = ClientRectangle

        ' Make adjustments to size and position of lable
		lblTab.Font = Me.Font
        lblTab.Left = 1
        lblTab.Top = 6
        If TabState = ueTabState.TabState1_Active Then
            lblTab.Width = Me.Width - 2
        Else
            lblTab.Width = Me.Width - 4
        End If
        lblTab.Height = Me.Height - 9

        ' Fill with control backcolor. If the tab doesn't fill the whole control, this will be in the background.
        g.FillRectangle(New SolidBrush(Me.BackColor), rect)

        Select Case TabState

            Case ueTabState.TabState1_Active

                ' First fill back color, then draw the border
                g.FillRectangle(New SolidBrush(m_ActiveBackColor), rect)

                DrawBorder(m_ActiveBorderColor)

                lblTab.ForeColor = m_ActiveForeColor
                lblTab.BackColor = m_ActiveBackColor

            Case ueTabState.TabState2_InActive

                ' Fill, then draw rectangle
                g.FillRectangle(New SolidBrush(m_InActiveBackColor), _
                                    New Rectangle(rect.X, rect.Y + 2, rect.Width - 3, rect.Height - 2))


                DrawBorder(m_InActiveBorderColor)

                lblTab.ForeColor = m_InActiveForeColor
                lblTab.BackColor = m_InActiveBackColor

            Case ueTabState.TabState3_Disabled

                ' Draw disabled the same as inactive, just with different colors
                g.FillRectangle(New SolidBrush(m_DisabledBackColor), _
                                    New Rectangle(rect.X, rect.Y + 2, rect.Width - 3, rect.Height - 2))

                DrawBorder(m_InActiveBorderColor)

                lblTab.ForeColor = m_DisabledForeColor
                lblTab.BackColor = m_DisabledBackColor

        End Select

        g.Dispose()

    End Sub

#End Region



    Protected Overrides Sub OnPaint(ByVal e As System.Windows.Forms.PaintEventArgs)
        MyBase.OnPaint(e)
        DrawTab()
    End Sub

    Private Sub FlatTab_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Click
        RaiseEvent Clicked(m_Index)
    End Sub

    Private Sub FlatTab_EnabledChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.EnabledChanged
        If Not Enabled Then
            TabState = ueTabState.TabState3_Disabled
        Else
            TabState = ueTabState.TabState2_InActive ' If it's selected, this will be overridden
        End If
    End Sub

    Private Sub FlatTab_Resize(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Resize
        DrawTab()
    End Sub

    Private Sub FlatTab_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

		lblTab.Font = Me.Font

	End Sub

	Private Sub DrawBorder(ByVal color As Color)

		Dim g As Graphics = CreateGraphics()
		Dim rect As Rectangle = ClientRectangle

		bIsHighlighted = (color.Equals(m_HighlightBorderColor))

		Select Case TabState

			Case ueTabState.TabState1_Active

				' Left
				g.DrawLine(New Pen(color), rect.Left, rect.Top, _
								 rect.Left, rect.Bottom - 1)
				' Top
				g.DrawLine(New Pen(color), rect.Left, rect.Top, _
																		   rect.Left + Width - 1, rect.Top)
				'Right
				g.DrawLine(New Pen(color), rect.Left + Width - 1, rect.Top, _
								 rect.Left + Width - 1, rect.Bottom - 1)

			Case ueTabState.TabState2_InActive, ueTabState.TabState3_Disabled

				' Draw inactive and disabled tabs slightly smaller than active tab
				' Left
				g.DrawLine(New Pen(color), rect.Left, rect.Y + 2, _
																		   rect.Left, rect.Bottom)
				' Top
				g.DrawLine(New Pen(color), rect.Left, rect.Y + 2, _
																		   rect.Left + Width - 3, rect.Y + 2)
				'Right
				g.DrawLine(New Pen(color), rect.Left + Width - 3, rect.Y + 2, _
																		   rect.Left + Width - 3, rect.Bottom)

		End Select

		g.Dispose()

	End Sub

	Private Sub HandleHighlighting()

		Dim rect As Rectangle = Me.RectangleToScreen(ClientRectangle)

		If TabState = ueTabState.TabState2_InActive Then

			If MousePosition.X < rect.X + 1 Or MousePosition.X > rect.X + Width - 4 Or _
					MousePosition.Y < rect.Y + 2 Or MousePosition.Y > rect.Y + Height - 1 Then

				DrawBorder(m_InActiveBorderColor)

			Else
				If Not bIsHighlighted Then
					DrawBorder(m_HighlightBorderColor)
				End If
			End If
		End If

	End Sub

	Private Sub FlatTab_MouseLeave(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.MouseLeave
		HandleHighlighting()
	End Sub

	Private Sub FlatTab_MouseEnter(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.MouseEnter
		HandleHighlighting()
	End Sub

	Private Sub FlatTab_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles MyBase.MouseMove
		HandleHighlighting()
	End Sub

	Private Sub lblTab_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lblTab.Click
		RaiseEvent Clicked(m_Index)
	End Sub

	Private Sub lblTab_MouseLeave(ByVal sender As Object, ByVal e As System.EventArgs) Handles lblTab.MouseLeave
		HandleHighlighting()
	End Sub

	Private Sub lblTab_MouseEnter(ByVal sender As Object, ByVal e As System.EventArgs) Handles lblTab.MouseEnter
		HandleHighlighting()
	End Sub

	Private Sub lblTab_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles lblTab.MouseMove
		HandleHighlighting()
	End Sub
End Class
