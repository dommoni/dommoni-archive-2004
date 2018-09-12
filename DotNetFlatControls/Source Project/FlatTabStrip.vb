Imports System.ComponentModel
Imports System.Drawing.Design
Imports System.Windows.Forms.Design
Imports dotNetFlatControls.FlatControlsShared

Public Class FlatTabStrip
    Inherits System.Windows.Forms.UserControl

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call
        TabWidth = 120
        TabCount = 0
        SelectedIndex = 1

		Me.Font = m_def_Font
        Me.ActiveBackColor = m_def_ActiveBackColor
        Me.ActiveBorderColor = m_def_ActiveBorderColor
        Me.ActiveForeColor = m_def_ActiveForeColor
        Me.InActiveBackColor = m_def_InActiveBackColor
        Me.InActiveBorderColor = m_def_InActiveBorderColor
        Me.InActiveForeColor = m_def_InActiveForeColor
        Me.DisabledBackColor = m_def_DisabledBackColor
        Me.DisabledBorderColor = m_def_DisabledBorderColor
        Me.DisabledForeColor = m_def_DisabledForeColor
        Me.HighlightBorderColor = m_def_HighlightBorderColor

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
        'FlatTabStrip
        '
        Me.Name = "FlatTabStrip"
        Me.Size = New System.Drawing.Size(275, 42)

    End Sub

#End Region

    Private colTabs As FlatTabCollection = New FlatTabCollection()
    Private m_SelectedIndex As Integer
    Private m_TabWidth As Integer
	Private m_AutoSizeTabs As Boolean = True
	Private m_OldIndex As Integer
	Private m_Font As Font
	Private m_InitialFontSize As Single

	' Drawing Colors
	Private m_ActiveBackColor As Color
	Private m_ActiveBorderColor As Color
	Private m_ActiveForeColor As Color
	Private m_InActiveBackColor As Color
	Private m_InActiveBorderColor As Color
	Private m_InActiveForeColor As Color
	Private m_DisabledBackColor As Color
	Private m_DisabledBorderColor As Color
	Private m_DisabledForeColor As Color
	Private m_HighlightBorderColor As Color

	' Default Tab Font
	Private m_def_Font As Font = New Font("Microsoft Sans Serif", 8.0!, FontStyle.Regular, GraphicsUnit.Point)
	' Default Colors
	Private m_def_ActiveBackColor As Color = Color.Transparent
	Private m_def_ActiveBorderColor As Color = SystemColors.ActiveBorder
	Private m_def_ActiveForeColor As Color = SystemColors.ControlText
	Private m_def_InActiveBackColor As Color = Color.FromArgb(CONTROL_CUSTOM)
	Private m_def_InActiveBorderColor As Color = SystemColors.InactiveBorder
	Private m_def_InActiveForeColor As Color = SystemColors.ControlText
	Private m_def_DisabledBackColor As Color = Color.FromArgb(CONTROL_LIGHT_CUSTOM)
	Private m_def_DisabledBorderColor As Color = SystemColors.InactiveBorder
	Private m_def_DisabledForeColor As Color = SystemColors.GrayText
	Private m_def_HighlightBorderColor As Color = SystemColors.Highlight

	Public Event SelectedIndexChange(ByVal newIndex As Integer, ByVal oldIndex As Integer)
	Public Event TabClicked(ByVal index As Integer, ByRef cancel As Boolean)
	Public Shadows Event Click(ByVal sender As Object)

	<DefaultValue(0)> Public Property TabCount() As Integer
		' NOTE: It would be nice to have this set to something other than 0 so that when
		'          you place the control it defaults to a few tabs; would look nicer. However, 
		'          it was behaving funny when I did this so rather than try and figure it out I 
		'          just defaulted back to 0. - DLH
		Get
			Return colTabs.Count
		End Get
		Set(ByVal Value As Integer)

			If Not Value.Equals(colTabs.Count) Then
				If Value > colTabs.Count Then
					AddTabs(Value - colTabs.Count)
				Else
					RemoveTabs(colTabs.Count - Value)
				End If
				DrawTabStrip()
			End If

		End Set
	End Property
	<DefaultValue(120)> Public Property TabWidth() As Integer
		Get
			Return m_TabWidth
		End Get
		Set(ByVal Value As Integer)
			If Not Value.Equals(m_TabWidth) Then
				m_TabWidth = Value
				DrawTabStrip()
			End If
		End Set
	End Property
	<DefaultValue(True)> Public Property AutoSizeTabs() As Boolean
		Get
			Return m_AutoSizeTabs
		End Get
		Set(ByVal Value As Boolean)
			If Not Value.Equals(m_AutoSizeTabs) Then
				m_AutoSizeTabs = Value
				DrawTabStrip()
			End If
		End Set
	End Property
	<DefaultValue(1)> Public Property SelectedIndex() As Integer
		Get
			Return m_SelectedIndex
		End Get
		Set(ByVal Value As Integer)
			If Not Value.Equals(m_SelectedIndex) Then
				If Value > 0 And Value <= colTabs.Count Then
					m_OldIndex = m_SelectedIndex
					m_SelectedIndex = Value
					RaiseEvent SelectedIndexChange(m_SelectedIndex, m_OldIndex)
					DrawTabStrip()
				End If
			End If
		End Set
	End Property
	'Public Overrides Property Font() As Font
	'	Get
	'		If m_Font Is Nothing Then
	'			If colTabs.Count > 0 Then
	'				Return colTabs.Item(1).Font
	'			End If
	'		Else
	'			Return m_Font
	'		End If
	'	End Get
	'	Set(ByVal Value As Font)

	'	End Set
	'End Property
	<Editor(GetType(TabNameEditor), GetType(System.Drawing.Design.UITypeEditor))> _
	Public Property TabNames() As String
		Get
			Dim tab As FlatTab
			Dim strTabNames As String = ""

			For Each tab In colTabs
				If strTabNames.Length > 0 Then
					strTabNames = strTabNames & vbCrLf
				End If
				strTabNames = strTabNames & tab.Text
			Next

			Return strTabNames

		End Get
		Set(ByVal Value As String)

			Dim aryNames() As String
			Dim strName As String
			Dim i As Integer
			Dim iTabCount As Integer = 0
			Dim tab As FlatTab

			Value = Trim(Value)

			aryNames = Value.Split(Chr(13))

			For i = 0 To aryNames.GetUpperBound(0)
				' remove the line-end characters
				aryNames(i) = Replace(aryNames(i), Chr(10), "")
				aryNames(i) = Replace(aryNames(i), Chr(13), "")

				If Not aryNames(i) Is Nothing Then
					iTabCount = iTabCount + 1
					If iTabCount > colTabs.Count Then
						AddTab(aryNames(i))
					Else
						tab = colTabs.Item(iTabCount)
						tab.Text = Trim(aryNames(i))
					End If
				End If
			Next

			TabCount = iTabCount			  ' set the tab count to remove any extra tabs left over

		End Set
	End Property

	Public ReadOnly Property Tabs() As FlatTabCollection
		Get
			Return colTabs
		End Get
	End Property

	Public Property ActiveBackColor() As Color
		Get
			Return m_ActiveBackColor
		End Get
		Set(ByVal Value As Color)
			If Not Value.Equals(m_ActiveBackColor) Then
				m_ActiveBackColor = Value
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
				DrawTabStrip()
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
				UpdateColors()
			End If
		End Set
	End Property

	Public ReadOnly Property InitialFontSize() As Single
		Get
			Return m_InitialFontSize
		End Get
	End Property

	Friend Sub DrawTabStrip()

		Dim i As Integer
		Dim tab As FlatTab
		Dim iTabWidth As Integer
		Dim g As Graphics = CreateGraphics()

		If colTabs.Count = 0 Then GoTo NO_SELECTION

		' Start by clearing the control
		g.FillRectangle(New SolidBrush(BackColor), ClientRectangle)

		If AutoSizeTabs Then
			iTabWidth = GetWidestTabWidth()
		Else
			iTabWidth = TabWidth
		End If

		For i = 1 To colTabs.Count

			tab = colTabs.Item(i)

			' Make sure that the index internal to the tab is correct
			tab.Index = i

			' Set the size and position of the tab
			tab.Left = (i - 1) * iTabWidth		  ' 10/3 DLH
			tab.Top = 0
			tab.Width = iTabWidth
			tab.Height = Me.Height - 1

			If tab.Enabled Then
				If i = m_SelectedIndex Then
					tab.TabState = ueTabState.TabState1_Active
				Else
					tab.TabState = ueTabState.TabState2_InActive
				End If
			Else
				tab.TabState = ueTabState.TabState3_Disabled
			End If

			tab.DrawTab()

		Next

		' Now draw the line along the bottom. It's actually lines - one before and one after the selected tab
		If SelectedIndex > 0 Then

			tab = colTabs.Item(SelectedIndex)

			If tab.Index > 1 Then

				' Draw the line to the left of the selected tab if it's not the first tab
				g.DrawLine(New Pen(m_ActiveBorderColor), 0, ClientRectangle.Bottom - 1, _
				 tab.Left, ClientRectangle.Bottom - 1)

			ElseIf tab.Index = 1 Then

				' Draw a single pixel to fill in the gap
				g.DrawLine(New Pen(m_ActiveBorderColor), 0, ClientRectangle.Bottom - 1, _
				 1, ClientRectangle.Bottom - 1)

			End If

			' Draw the line under the selected tab to fill in the missing space
			g.DrawLine(New Pen(m_ActiveBackColor), tab.Left + 1, ClientRectangle.Bottom - 1, _
			 tab.Right - 1, ClientRectangle.Bottom - 1)

			g.DrawLine(New Pen(m_ActiveBorderColor), tab.Left + tab.Width - 1, ClientRectangle.Bottom - 1, _
			  ClientRectangle.Right, ClientRectangle.Bottom - 1)

		Else

NO_SELECTION:
			g.DrawLine(New Pen(m_ActiveBorderColor), 0, ClientRectangle.Bottom - 1, _
			  ClientRectangle.Right, ClientRectangle.Bottom - 1)
		End If

		g.Dispose()

	End Sub

	Friend Function GetWidestTabWidth() As Integer

		' Find the longest tab text and size accordingly
		Dim g As Graphics = CreateGraphics()
		Dim tab As FlatTab
		Dim iMaxWidth As Integer

		For Each tab In colTabs

			If g.MeasureString(tab.Text, tab.Font).Width > iMaxWidth Then
				iMaxWidth = g.MeasureString(tab.Text, tab.Font).Width
			End If

		Next

		Return iMaxWidth + 20

	End Function

	Friend Sub SetTabColors(ByVal tab As FlatTab)
		' Since the colors are used in the individual tabs, we just pass on the colors from the parent
		With tab
			.ActiveBackColor = Me.ActiveBackColor
			.ActiveBorderColor = Me.ActiveBorderColor
			.ActiveForeColor = Me.ActiveForeColor

			.InActiveBackColor = Me.InActiveBackColor
			.InActiveBorderColor = Me.InActiveBorderColor
			.InActiveForeColor = Me.InActiveForeColor

			.DisabledBackColor = Me.DisabledBackColor
			.DisabledBorderColor = Me.DisabledBorderColor
			.DisabledForeColor = Me.DisabledForeColor

			.HighlightBorderColor = Me.HighlightBorderColor

		End With

	End Sub

	Friend Sub UpdateColors()
		Dim tab As FlatTab
		For Each tab In colTabs
			SetTabColors(tab)
		Next
	End Sub

	Friend Sub AddTabs(ByVal iTabs2Add As Integer)
		Dim i As Integer

		' Add the specified number of tabs to the end
		For i = 1 To iTabs2Add
			AddTab()
		Next

	End Sub

	Friend Sub RemoveTabs(ByVal iTabs2Remove As Integer)
		Dim i As Integer

		' Remove the specified number of tabs from the end
		For i = 1 To iTabs2Remove
			RemoveTab()
		Next
	End Sub

	Friend Sub AddTab(Optional ByVal strText As String = "", Optional ByVal iPos As Integer = 0)

		Dim tab As FlatTab
		Dim NewTab As FlatTab = New FlatTab()
		Dim CurrentTab As FlatTab		  ' the tab currently at the specified position, if applicable

		' Add to the user control
		Me.Controls.Add(NewTab)

		' Add an event handler to catch clicks
		AddHandler NewTab.Clicked, AddressOf TabClickHandler

		' Determine the position
		If iPos < 1 Or iPos > colTabs.Count Then
			iPos = colTabs.Count + 1
		Else
			CurrentTab = colTabs.Item(iPos)
		End If

		' Give it a generic text name if unspecified
		If strText = "" Then strText = "Tab " & iPos
		NewTab.Name = strText
		NewTab.Text = strText

		' Set its font and colors
		NewTab.Font = Me.Font
		SetTabColors(NewTab)

		' Add to the tab collection in the appropriate place
		If CurrentTab Is Nothing Then
			colTabs.Add(NewTab)
		Else
			colTabs.Add(NewTab, CurrentTab)
		End If

		' If no tabs are currently selected then select the first. As long as there are tabs,
		' there should be one selected.
		If SelectedIndex < 1 Or SelectedIndex > colTabs.Count Then
			If colTabs.Count > 0 Then
				SelectedIndex = 1
			Else
				SelectedIndex = 0
			End If
		End If

		DrawTabStrip()		  ' The indexes will be reassigned here

	End Sub

	Friend Sub RemoveTab(Optional ByVal strText As String = "", Optional ByVal iPos As Integer = 0)

		Dim tab As FlatTab
		Dim Tab2Remove As FlatTab

		' First look for the tab by name, if specified, then by position
		If Not strText = "" Then
			On Error Resume Next
			Tab2Remove = colTabs.Item(strText)
			On Error GoTo 0
		End If

		If Tab2Remove Is Nothing Then

			If iPos = 0 Then iPos = colTabs.Count

			On Error Resume Next
			Tab2Remove = colTabs.Item(iPos)
			On Error GoTo 0
		End If

		' Couldn't find it. Do nothing
		If Tab2Remove Is Nothing Then Exit Sub

		' Remove from the user control
		Me.Controls.Remove(Tab2Remove)

		' Remove from the collection
		colTabs.Remove(Tab2Remove.Index)

		' If no tabs are currently selected then select the first. As long as there are tabs,
		' there should be one selected.
		If SelectedIndex < 1 Or SelectedIndex > colTabs.Count Then
			If colTabs.Count > 0 Then
				SelectedIndex = 1
			Else
				SelectedIndex = 0
			End If
		End If

		DrawTabStrip()		  ' The indexes will be reassigned properly here

	End Sub

	Private Sub FlatTabStrip_Resize(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Resize
		DrawTabStrip()
	End Sub

	Protected Overrides Sub OnPaint(ByVal e As System.Windows.Forms.PaintEventArgs)
		MyBase.OnPaint(e)
		DrawTabStrip()
	End Sub

	Private Sub TabClickHandler(ByVal index As Integer)

		Dim cancel As Boolean = False

		RaiseEvent Click(Me)
		RaiseEvent TabClicked(index, cancel)

		If Not cancel Then
			If SelectedIndex <> index And colTabs.Item(index).Enabled Then
				SelectedIndex = index
			End If
		End If

	End Sub

	Private Sub FlatTabStrip_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles MyBase.MouseUp
		RaiseEvent Click(Me)
	End Sub

	Private Sub SizeFonts()

		' start with a 5 pt font and cycle bigger in .2-point increments until it fits right
		Dim g As Graphics = CreateGraphics()
		Dim testFont As Font
		Dim nFontSize As Single
		Dim nWidth As Single
		Dim strSample As String

		If Me.TabCount = 0 Then Exit Sub

		' Get the longest string of the 

		' TitleDayFont
		nWidth = (0.95) * Me.Width		  ' Don't quite fill the whole width

		strSample = "Wednesday, September 30, 2004"		  ' widest date text I could think of
		For nFontSize = 10 To 5 Step -0.5
			testFont = New Font(Me.Font.FontFamily, nFontSize, Me.Font.Style, GraphicsUnit.Point)
			If g.MeasureString(strSample, testFont).Width < nWidth Then
				Exit For
			End If
		Next
		Me.Font = New Font(Me.Font.FontFamily, nFontSize, Me.Font.Style, GraphicsUnit.Point)

	End Sub

	Private Sub FlatTabStrip_Layout(ByVal sender As Object, ByVal e As System.Windows.Forms.LayoutEventArgs) Handles MyBase.Layout
		'		SizeFonts()
	End Sub

	Private Sub FlatTabStrip_FontChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.FontChanged

		Dim tab As FlatTab

		If m_InitialFontSize = 0 Then
			m_InitialFontSize = Me.Font.SizeInPoints
		End If

		Try

			If colTabs.Count > 0 Then

				For Each tab In colTabs
					tab.Font = Me.Font
				Next
			End If
		Catch ex As Exception
			Console.WriteLine("Error setting Font: " & ex.Message)
		End Try

	End Sub
End Class

' This is the type editor for the tab names
Friend Class TabNameEditor
    Inherits UITypeEditor

    Private edSvc As IWindowsFormsEditorService

    Public Overloads Overrides Function EditValue(ByVal context As ITypeDescriptorContext, _
                            ByVal provider As IServiceProvider, ByVal value As Object) As Object

        If Not (provider Is Nothing) And Not (value Is Nothing) Then

            Dim tabEditorForm As TabEditorForm = New TabEditorForm()

            edSvc = CType(provider.GetService(GetType(IWindowsFormsEditorService)), IWindowsFormsEditorService)

            If Not (edSvc Is Nothing) Then

                If value.GetType.Equals(GetType(String)) Then
                    tabEditorForm.TabNames = value
                End If

                edSvc.ShowDialog(tabEditorForm)

                If Not tabEditorForm.Cancel Then
                    value = tabEditorForm.TabNames
                End If

            End If

        End If

        Return value

    End Function

    Public Overloads Overrides Function GetEditStyle(ByVal context As ITypeDescriptorContext) As UITypeEditorEditStyle
        Return UITypeEditorEditStyle.Modal
    End Function

End Class

Public Class FlatTabCollection
    Inherits CollectionBase

    ' Just a boilerplate strong-typed collection class for the tabs

    ' Note: The collectionbase list object has a base of zero. Since I'd prefer
    '         to stick to a base of one for something tangible like tabs, I'll just
    '         convert the index stored in the tab to the that used by the list.
    '         Users of this class should feel like the base is 1.

    Public Sub Add(ByVal tab As FlatTab)
        List.Add(tab)
    End Sub

    Public Sub Add(ByVal tab As FlatTab, ByVal beforeTab As FlatTab)
        List.Insert(beforeTab.Index - 1, tab)
    End Sub

    Public Sub Remove(ByVal index As Integer)

        index = index - 1  ' adjust for base 0

        ' Check to see if there is a tab at the supplied index.
        If index > Count - 1 Or index < 0 Then
            ' If no tab exists, do nothing and exit
            Exit Sub
        Else
            List.RemoveAt(index)
        End If
    End Sub

    Public ReadOnly Property Item(ByVal index As Integer) As FlatTab
        Get
            index = index - 1  ' adjust for base 0

            ' The appropriate item is retrieved from the List object and 
            ' explicitly cast to the FlatTab type, then returned 
            Return CType(List.Item(index), FlatTab)
        End Get
    End Property
End Class
