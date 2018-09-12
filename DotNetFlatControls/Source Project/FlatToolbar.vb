Imports dotNetFlatControls.FlatControlsShared

Public Class FlatToolbar
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
	Public WithEvents ImageListToolbar16 As System.Windows.Forms.ImageList
	Public WithEvents ToolBar1 As System.Windows.Forms.ToolBar
	Friend WithEvents ButtonPrint As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonUndo As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonNew As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonOpen As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonSave As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonPreview As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonModify As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonDelete As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonAppointment As System.Windows.Forms.ToolBarButton
	Friend WithEvents ToolBarNav As System.Windows.Forms.ToolBar
	Friend WithEvents ButtonFind As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonFirst As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonPrevious As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonNext As System.Windows.Forms.ToolBarButton
	Friend WithEvents ButtonLast As System.Windows.Forms.ToolBarButton
	Friend WithEvents lblSort As FlatLabel
	Public WithEvents cboSort As FlatComboBox
	Friend WithEvents lblCurRecord As System.Windows.Forms.Label
	Friend WithEvents lblTotalRecords As System.Windows.Forms.Label
	Friend WithEvents lblOf As System.Windows.Forms.Label
	Friend WithEvents ToolBarFilter As System.Windows.Forms.ToolBar
	Friend WithEvents ButtonFilter As System.Windows.Forms.ToolBarButton
	Friend WithEvents lblFilter As FlatLabel
	Friend WithEvents ButtonFilterOff As System.Windows.Forms.ToolBarButton
	Friend WithEvents lblFilterOff As FlatLabel
	Friend WithEvents ButtonRefresh As System.Windows.Forms.ToolBarButton
	<System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
		Me.components = New System.ComponentModel.Container()
		Dim resources As System.Resources.ResourceManager = New System.Resources.ResourceManager(GetType(FlatToolbar))
		Me.ToolBar1 = New System.Windows.Forms.ToolBar()
		Me.ButtonNew = New System.Windows.Forms.ToolBarButton()
		Me.ButtonOpen = New System.Windows.Forms.ToolBarButton()
		Me.ButtonSave = New System.Windows.Forms.ToolBarButton()
		Me.ButtonUndo = New System.Windows.Forms.ToolBarButton()
		Me.ButtonPrint = New System.Windows.Forms.ToolBarButton()
		Me.ButtonPreview = New System.Windows.Forms.ToolBarButton()
		Me.ButtonModify = New System.Windows.Forms.ToolBarButton()
		Me.ButtonDelete = New System.Windows.Forms.ToolBarButton()
		Me.ButtonAppointment = New System.Windows.Forms.ToolBarButton()
		Me.ButtonFind = New System.Windows.Forms.ToolBarButton()
		Me.ButtonRefresh = New System.Windows.Forms.ToolBarButton()
		Me.ImageListToolbar16 = New System.Windows.Forms.ImageList(Me.components)
		Me.ToolBarNav = New System.Windows.Forms.ToolBar()
		Me.ButtonFirst = New System.Windows.Forms.ToolBarButton()
		Me.ButtonPrevious = New System.Windows.Forms.ToolBarButton()
		Me.ButtonNext = New System.Windows.Forms.ToolBarButton()
		Me.ButtonLast = New System.Windows.Forms.ToolBarButton()
		Me.cboSort = New dotNetFlatControls.FlatComboBox()
		Me.lblSort = New dotNetFlatControls.FlatLabel()
		Me.lblCurRecord = New System.Windows.Forms.Label()
		Me.lblTotalRecords = New System.Windows.Forms.Label()
		Me.lblOf = New System.Windows.Forms.Label()
		Me.ToolBarFilter = New System.Windows.Forms.ToolBar()
		Me.ButtonFilter = New System.Windows.Forms.ToolBarButton()
		Me.ButtonFilterOff = New System.Windows.Forms.ToolBarButton()
		Me.lblFilter = New dotNetFlatControls.FlatLabel()
		Me.lblFilterOff = New dotNetFlatControls.FlatLabel()
		Me.SuspendLayout()
		'
		'ToolBar1
		'
		Me.ToolBar1.Appearance = System.Windows.Forms.ToolBarAppearance.Flat
		Me.ToolBar1.Buttons.AddRange(New System.Windows.Forms.ToolBarButton() {Me.ButtonNew, Me.ButtonOpen, Me.ButtonSave, Me.ButtonUndo, Me.ButtonPrint, Me.ButtonPreview, Me.ButtonModify, Me.ButtonDelete, Me.ButtonAppointment, Me.ButtonFind, Me.ButtonRefresh})
		Me.ToolBar1.ButtonSize = New System.Drawing.Size(16, 16)
		Me.ToolBar1.Divider = False
		Me.ToolBar1.Dock = System.Windows.Forms.DockStyle.None
		Me.ToolBar1.DropDownArrows = True
		Me.ToolBar1.ImageList = Me.ImageListToolbar16
		Me.ToolBar1.Name = "ToolBar1"
		Me.ToolBar1.ShowToolTips = True
		Me.ToolBar1.Size = New System.Drawing.Size(234, 23)
		Me.ToolBar1.TabIndex = 0
		'
		'ButtonNew
		'
		Me.ButtonNew.ImageIndex = 0
		Me.ButtonNew.ToolTipText = "Add to the Watch List"
		'
		'ButtonOpen
		'
		Me.ButtonOpen.ImageIndex = 1
		Me.ButtonOpen.ToolTipText = "Open"
		'
		'ButtonSave
		'
		Me.ButtonSave.ImageIndex = 2
		Me.ButtonSave.ToolTipText = "Save"
		'
		'ButtonUndo
		'
		Me.ButtonUndo.ImageIndex = 3
		Me.ButtonUndo.ToolTipText = "Undo Changes Since Last Save"
		'
		'ButtonPrint
		'
		Me.ButtonPrint.ImageIndex = 4
		Me.ButtonPrint.ToolTipText = "Print the Watch List"
		'
		'ButtonPreview
		'
		Me.ButtonPreview.ImageIndex = 5
		Me.ButtonPreview.ToolTipText = "Print Preview"
		'
		'ButtonModify
		'
		Me.ButtonModify.ImageIndex = 6
		Me.ButtonModify.ToolTipText = "Modify"
		'
		'ButtonDelete
		'
		Me.ButtonDelete.ImageIndex = 7
		Me.ButtonDelete.ToolTipText = "Remove From the Watch List"
		'
		'ButtonAppointment
		'
		Me.ButtonAppointment.ImageIndex = 8
		Me.ButtonAppointment.ToolTipText = "Schedule Appointment"
		'
		'ButtonFind
		'
		Me.ButtonFind.ImageIndex = 9
		Me.ButtonFind.ToolTipText = "Find"
		Me.ButtonFind.Visible = False
		'
		'ButtonRefresh
		'
		Me.ButtonRefresh.ImageIndex = 16
		Me.ButtonRefresh.ToolTipText = "Refresh the List"
		'
		'ImageListToolbar16
		'
		Me.ImageListToolbar16.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit
		Me.ImageListToolbar16.ImageSize = New System.Drawing.Size(16, 16)
		Me.ImageListToolbar16.ImageStream = CType(resources.GetObject("ImageListToolbar16.ImageStream"), System.Windows.Forms.ImageListStreamer)
		Me.ImageListToolbar16.TransparentColor = System.Drawing.Color.Transparent
		'
		'ToolBarNav
		'
		Me.ToolBarNav.Appearance = System.Windows.Forms.ToolBarAppearance.Flat
		Me.ToolBarNav.Buttons.AddRange(New System.Windows.Forms.ToolBarButton() {Me.ButtonFirst, Me.ButtonPrevious, Me.ButtonNext, Me.ButtonLast})
		Me.ToolBarNav.Divider = False
		Me.ToolBarNav.Dock = System.Windows.Forms.DockStyle.None
		Me.ToolBarNav.DropDownArrows = True
		Me.ToolBarNav.ImageList = Me.ImageListToolbar16
		Me.ToolBarNav.Location = New System.Drawing.Point(556, 0)
		Me.ToolBarNav.Name = "ToolBarNav"
		Me.ToolBarNav.ShowToolTips = True
		Me.ToolBarNav.Size = New System.Drawing.Size(97, 23)
		Me.ToolBarNav.TabIndex = 1
		'
		'ButtonFirst
		'
		Me.ButtonFirst.ImageIndex = 10
		Me.ButtonFirst.ToolTipText = "Move to the First Record"
		'
		'ButtonPrevious
		'
		Me.ButtonPrevious.ImageIndex = 11
		Me.ButtonPrevious.ToolTipText = "Move to the Previous Record"
		'
		'ButtonNext
		'
		Me.ButtonNext.ImageIndex = 12
		Me.ButtonNext.ToolTipText = "Move to the Next Record"
		'
		'ButtonLast
		'
		Me.ButtonLast.ImageIndex = 13
		Me.ButtonLast.ToolTipText = "Move to the Last Record"
		'
		'cboSort
		'
		Me.cboSort.BackColorDisabled = System.Drawing.Color.WhiteSmoke
		Me.cboSort.BorderColor = System.Drawing.Color.Gray
		Me.cboSort.DrawMode = System.Windows.Forms.DrawMode.OwnerDrawFixed
        'TODO        Me.cboSort.FormatStyle = dotNetFlatControls.FlatControlsShared.FormatType.Format_None
		Me.cboSort.HighlightColor = System.Drawing.SystemColors.Highlight
		Me.cboSort.IsLastTabStop = False
		Me.cboSort.Location = New System.Drawing.Point(424, 0)
		Me.cboSort.Name = "cboSort"
		Me.cboSort.Size = New System.Drawing.Size(120, 21)
		Me.cboSort.StickToList = True
		Me.cboSort.TabIndex = 2
		Me.cboSort.TargetPopup = Nothing
		'
		'lblSort
		'
		Me.lblSort.BackColor = System.Drawing.Color.Transparent
		Me.lblSort.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
		Me.lblSort.Location = New System.Drawing.Point(376, 0)
		Me.lblSort.Name = "lblSort"
		Me.lblSort.Size = New System.Drawing.Size(47, 23)
		Me.lblSort.TabIndex = 3
		Me.lblSort.Text = "Sort By"
		Me.lblSort.TextAlign = System.Drawing.ContentAlignment.MiddleLeft
		'
		'lblCurRecord
		'
		Me.lblCurRecord.Location = New System.Drawing.Point(654, 0)
		Me.lblCurRecord.Name = "lblCurRecord"
		Me.lblCurRecord.Size = New System.Drawing.Size(36, 23)
		Me.lblCurRecord.TabIndex = 4
		Me.lblCurRecord.Text = "0"
		Me.lblCurRecord.TextAlign = System.Drawing.ContentAlignment.MiddleRight
		'
		'lblTotalRecords
		'
		Me.lblTotalRecords.Location = New System.Drawing.Point(708, 0)
		Me.lblTotalRecords.Name = "lblTotalRecords"
		Me.lblTotalRecords.Size = New System.Drawing.Size(36, 23)
		Me.lblTotalRecords.TabIndex = 5
		Me.lblTotalRecords.Text = "0"
		Me.lblTotalRecords.TextAlign = System.Drawing.ContentAlignment.MiddleLeft
		'
		'lblOf
		'
		Me.lblOf.BackColor = System.Drawing.Color.Transparent
		Me.lblOf.Location = New System.Drawing.Point(654, 0)
		Me.lblOf.Name = "lblOf"
		Me.lblOf.Size = New System.Drawing.Size(91, 23)
		Me.lblOf.TabIndex = 6
		Me.lblOf.Text = "of"
		Me.lblOf.TextAlign = System.Drawing.ContentAlignment.MiddleCenter
		'
		'ToolBarFilter
		'
		Me.ToolBarFilter.Appearance = System.Windows.Forms.ToolBarAppearance.Flat
		Me.ToolBarFilter.Buttons.AddRange(New System.Windows.Forms.ToolBarButton() {Me.ButtonFilter, Me.ButtonFilterOff})
		Me.ToolBarFilter.Divider = False
		Me.ToolBarFilter.Dock = System.Windows.Forms.DockStyle.None
		Me.ToolBarFilter.DropDownArrows = True
		Me.ToolBarFilter.ImageList = Me.ImageListToolbar16
		Me.ToolBarFilter.Location = New System.Drawing.Point(268, 0)
		Me.ToolBarFilter.Name = "ToolBarFilter"
		Me.ToolBarFilter.ShowToolTips = True
		Me.ToolBarFilter.Size = New System.Drawing.Size(27, 23)
		Me.ToolBarFilter.TabIndex = 7
		Me.ToolBarFilter.TextAlign = System.Windows.Forms.ToolBarTextAlign.Right
		'
		'ButtonFilter
		'
		Me.ButtonFilter.ImageIndex = 14
		Me.ButtonFilter.ToolTipText = "Filter Records"
		'
		'ButtonFilterOff
		'
		Me.ButtonFilterOff.ImageIndex = 15
		Me.ButtonFilterOff.ToolTipText = "Clear the Filter"
		Me.ButtonFilterOff.Visible = False
		'
		'lblFilter
		'
		Me.lblFilter.Font = New System.Drawing.Font("Microsoft Sans Serif", 7.2!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
		Me.lblFilter.Location = New System.Drawing.Point(296, 0)
		Me.lblFilter.Name = "lblFilter"
		Me.lblFilter.Size = New System.Drawing.Size(70, 23)
		Me.lblFilter.TabIndex = 8
		Me.lblFilter.Text = "Filter is On"
		Me.lblFilter.TextAlign = System.Drawing.ContentAlignment.MiddleLeft
		Me.lblFilter.Visible = False
		'
		'lblFilterOff
		'
		Me.lblFilterOff.BackColor = System.Drawing.Color.Transparent
		Me.lblFilterOff.Font = New System.Drawing.Font("Microsoft Sans Serif", 7.2!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
		Me.lblFilterOff.Location = New System.Drawing.Point(296, 0)
		Me.lblFilterOff.Name = "lblFilterOff"
		Me.lblFilterOff.Size = New System.Drawing.Size(70, 23)
		Me.lblFilterOff.TabIndex = 9
		Me.lblFilterOff.Text = "Filter is Off"
		Me.lblFilterOff.TextAlign = System.Drawing.ContentAlignment.MiddleLeft
		'
		'FlatToolbar
		'
		Me.Controls.AddRange(New System.Windows.Forms.Control() {Me.lblFilterOff, Me.ToolBarFilter, Me.lblTotalRecords, Me.lblCurRecord, Me.lblOf, Me.lblSort, Me.cboSort, Me.ToolBarNav, Me.ToolBar1, Me.lblFilter})
		Me.Name = "FlatToolbar"
		Me.Size = New System.Drawing.Size(747, 23)
		Me.ResumeLayout(False)

	End Sub

#End Region

	Private m_Font As Font
	Private m_SortMargin As Integer
	Private m_RightMargin As Integer
	Private bIsFilterOn As Boolean
	Private m_InitialFontSize As Single

	Public Enum ueToolbarItems
		ueNew
		ueOpen
		ueSave
		ueUndo
		uePrint
		uePreview
		ueModify
		ueDelete
		ueAppointment
		ueFind
		ueFirst
		uePrevious
		ueNext
		ueLast
		ueFilter
		ueFilterOff
		ueRefresh
	End Enum

	Public Event ButtonClick(ByVal sender As Object, ByVal e As System.Windows.Forms.ToolBarButtonClickEventArgs)
	Public Event SortChanged(ByVal strNewSort As String)

	Private m_strSort As String

	Public Property FilterOn() As Boolean
		Get
			Return bIsFilterOn
		End Get
		Set(ByVal Value As Boolean)

			If ShowFilter Then

				bIsFilterOn = Value

				ToolBarFilter.Buttons(0).Visible = Not bIsFilterOn
				ToolBarFilter.Buttons(1).Visible = bIsFilterOn
				lblFilter.Visible = bIsFilterOn
				lblFilterOff.Visible = Not bIsFilterOn

			End If

		End Set
	End Property
	Public Property HasNew() As Boolean
		Get
			Return ButtonNew.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonNew.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasOpen() As Boolean
		Get
			Return ButtonOpen.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonOpen.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasSave() As Boolean
		Get
			Return ButtonSave.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonSave.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasUndo() As Boolean
		Get
			Return ButtonUndo.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonUndo.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasPrint() As Boolean
		Get
			Return ButtonPrint.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonPrint.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasPreview() As Boolean
		Get
			Return ButtonPreview.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonPreview.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasModify() As Boolean
		Get
			Return ButtonModify.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonModify.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasDelete() As Boolean
		Get
			Return ButtonDelete.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonDelete.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasAppointment() As Boolean
		Get
			Return ButtonAppointment.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonAppointment.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasFind() As Boolean
		Get
			Return ButtonFind.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonFind.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property HasRefresh() As Boolean
		Get
			Return ButtonRefresh.Visible
		End Get
		Set(ByVal Value As Boolean)
			ButtonRefresh.Visible = Value
			Me.Refresh()
		End Set
	End Property


	Public Property CurrentRecord() As Integer
		Get
			Return CInt(lblCurRecord.Text)
		End Get
		Set(ByVal Value As Integer)
			lblCurRecord.Text = Value.ToString
			SetNavEnabling()
		End Set
	End Property
	Public Property TotalRecords() As Integer
		Get
			Return CInt(lblTotalRecords.Text)
		End Get
		Set(ByVal Value As Integer)
			lblTotalRecords.Text = Value.ToString
			SetNavEnabling()
		End Set
	End Property
	Public Property SortValue() As String
		Get
			Return cboSort.SelectedValue
		End Get
		Set(ByVal Value As String)
			cboSort.SelectedValue = Value
			If Not cboSort.CheckIfInList(True) Then
				cboSort.SelectedIndex = -1
			End If

		End Set
	End Property

	Public Property SortMargin() As Integer
		Get
			Return m_SortMargin
		End Get
		Set(ByVal Value As Integer)
			m_SortMargin = Value
			Me.Refresh()
		End Set
	End Property
	Public Property RightMargin() As Integer
		Get
			Return m_RightMargin
		End Get
		Set(ByVal Value As Integer)
			m_RightMargin = Value
			Me.Refresh()
		End Set
	End Property
	Public Property ShowNavigation() As Boolean
		Get
			Return ToolBarNav.Visible
		End Get
		Set(ByVal Value As Boolean)
			ToolBarNav.Visible = Value
			lblCurRecord.Visible = Value
			lblOf.Visible = Value
			lblTotalRecords.Visible = Value

			Me.Refresh()
		End Set
	End Property
	Public Property ShowSortCombo() As Boolean
		Get
			Return cboSort.Visible
		End Get
		Set(ByVal Value As Boolean)
			cboSort.Visible = Value
			lblSort.Visible = Value
			Me.Refresh()
		End Set
	End Property
	Public Property ShowFilter() As Boolean
		Get
			Return ToolBarFilter.Visible
		End Get
		Set(ByVal Value As Boolean)
			ToolBarFilter.Visible = Value
			lblFilter.Visible = Value
			lblFilterOff.Visible = Value

			If Value Then
				FilterOn = False
			End If

		End Set
	End Property
	Public ReadOnly Property Buttons() As ToolBar.ToolBarButtonCollection
		Get
			Return ToolBar1.Buttons()
		End Get
	End Property
	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

	Public Shadows Property Font() As Font
		Get
			Return m_Font
		End Get
		Set(ByVal Value As Font)
			m_Font = Value

			lblFilter.Font = New Font(lblFilter.Font.FontFamily, m_Font.SizeInPoints, lblFilter.Font.Style, GraphicsUnit.Point)
			lblFilterOff.Font = New Font(lblFilterOff.Font.FontFamily, m_Font.SizeInPoints, lblFilterOff.Font.Style, GraphicsUnit.Point)
			lblSort.Font = New Font(lblSort.Font.FontFamily, m_Font.SizeInPoints, lblSort.Font.Style, GraphicsUnit.Point)
			lblCurRecord.Font = New Font(lblCurRecord.Font.FontFamily, m_Font.SizeInPoints, lblCurRecord.Font.Style, GraphicsUnit.Point)
			lblOf.Font = New Font(lblOf.Font.FontFamily, m_Font.SizeInPoints, lblOf.Font.Style, GraphicsUnit.Point)
			lblTotalRecords.Font = New Font(lblTotalRecords.Font.FontFamily, m_Font.SizeInPoints, lblTotalRecords.Font.Style, GraphicsUnit.Point)

		End Set
	End Property
	Private Sub ToolBar1_ButtonClick(ByVal sender As Object, ByVal e As System.Windows.Forms.ToolBarButtonClickEventArgs) Handles ToolBar1.ButtonClick

		RaiseEvent ButtonClick(sender, e)

	End Sub
	Private Sub ToolBarNav_ButtonClick(ByVal sender As Object, ByVal e As System.Windows.Forms.ToolBarButtonClickEventArgs) Handles ToolBarNav.ButtonClick

		RaiseEvent ButtonClick(sender, e)

	End Sub


	Private Sub SetNavEnabling()

		ToolBarNav.Buttons(0).Enabled = (CurrentRecord > 1)
		ToolBarNav.Buttons(1).Enabled = (CurrentRecord > 1)

		ToolBarNav.Buttons(2).Enabled = (CurrentRecord < TotalRecords)
		ToolBarNav.Buttons(3).Enabled = (CurrentRecord < TotalRecords)

	End Sub

	Private Sub cboSort_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles cboSort.SelectedIndexChanged

		If cboSort.SelectedValue <> m_strSort Then
			RaiseEvent SortChanged(cboSort.SelectedValue)
			m_strSort = cboSort.SelectedValue
		End If

	End Sub

	Private Sub cboSort_SelectedValueChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles cboSort.SelectedValueChanged

		If cboSort.SelectedValue <> m_strSort Then
			RaiseEvent SortChanged(cboSort.SelectedValue)
			m_strSort = cboSort.SelectedValue
		End If

	End Sub

	Private Sub ToolBarFilter_ButtonClick(ByVal sender As Object, ByVal e As System.Windows.Forms.ToolBarButtonClickEventArgs) Handles ToolBarFilter.ButtonClick

		RaiseEvent ButtonClick(sender, e)

	End Sub

	Private Sub FlatToolbar_Layout(ByVal sender As Object, ByVal e As System.Windows.Forms.LayoutEventArgs) Handles MyBase.Layout

		Dim oButton As ToolBarButton
		Dim iVisibleButtons As Integer
		Dim iSortOffset As Integer
		Dim iFilterOffset As Integer
		Dim iSavedSortIndex As Integer

		For Each oButton In ToolBar1.Buttons
			If oButton.Visible Then
				iVisibleButtons = iVisibleButtons + 1
			End If
		Next

		ToolBar1.Width = 23 * iVisibleButtons

		iSortOffset = m_RightMargin
		iFilterOffset = m_RightMargin

		If ShowNavigation Then
			lblTotalRecords.Left = Me.Width - m_RightMargin - lblTotalRecords.Width
			lblCurRecord.Left = lblTotalRecords.Left - 20 - lblCurRecord.Width
			lblOf.Left = lblCurRecord.Left
			lblOf.Width = lblTotalRecords.Right - lblCurRecord.Left
			ToolBarNav.Left = lblCurRecord.Left - ToolBarNav.Width - 10
			iSortOffset = Me.Width - ToolBarNav.Left + m_SortMargin
			iFilterOffset = iSortOffset
		End If

		If ShowSortCombo Then
			iSavedSortIndex = cboSort.SelectedIndex
			cboSort.Left = Me.Width - iSortOffset - cboSort.Width
			lblSort.Left = cboSort.Left - lblSort.Width

			cboSort.SelectedIndex = -1
			cboSort.SelectedIndex = iSavedSortIndex

			iFilterOffset = Me.Width - lblSort.Left + m_SortMargin

		End If

		If ShowFilter Then

			lblFilter.Left() = Me.Width - iFilterOffset - lblFilter.Width
			lblFilterOff.Left = lblFilter.Left
			ToolBarFilter.Left = lblFilter.Left - ToolBarFilter.Width

		End If

	End Sub

End Class
