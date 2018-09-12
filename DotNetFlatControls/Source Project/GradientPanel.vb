Imports dotNetFlatControls.FlatControlsShared
Imports System.ComponentModel

Public Class GradientPanel
	Inherits System.Windows.Forms.Panel

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
		'GradientPanel
		'
		Me.Name = "GradientPanel"
		Me.Size = New System.Drawing.Size(254, 32)

	End Sub

#End Region

    'TODO: 	Private  uFillStyle As GradientStyle
    Private uFillStyle As Integer
    Private oColorFrom As Color
	Private oColorTo As Color
	Private intStartPerc As Integer

    'TODO: Put back
    'Public Property FillStyle() As GradientStyle
    '	Get
    '		Return uFillStyle
    '	End Get
    '	Set(ByVal Value As GradientStyle)
    '		uFillStyle = Value
    '		FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
    '	End Set
    'End Property
    Public Property FillStyle() As Integer
        Get
            Return uFillStyle
        End Get
        Set(ByVal Value As Integer)
            uFillStyle = Value
            ' TODO: Put back           FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
            FillGradient(Me, oColorFrom, oColorTo, intStartPerc)
        End Set
    End Property

    <DefaultValue(0)> _
    Public Property RelativeStartPerc() As Integer
        Get
            Return intStartPerc
        End Get
        Set(ByVal Value As Integer)
            intStartPerc = Value
            'TODO: Put back            FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
            FillGradient(Me, oColorFrom, oColorTo, intStartPerc)
        End Set
    End Property

    Public Property ColorFrom() As Color
        Get
            Return oColorFrom
        End Get
        Set(ByVal Value As Color)
            oColorFrom = Value
            'TODO: Put back            FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
            FillGradient(Me, oColorFrom, oColorTo, intStartPerc)
        End Set
    End Property

    Public Property ColorTo() As Color
        Get
            Return oColorTo
        End Get
        Set(ByVal Value As Color)
            oColorTo = Value
            'TODO: Put back                        FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
            FillGradient(Me, oColorFrom, oColorTo, intStartPerc)
        End Set
    End Property

    Private Sub GradientPanel_Paint(ByVal sender As Object, ByVal e As System.Windows.Forms.PaintEventArgs) Handles MyBase.Paint
        'TODO: Put back    FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
        FillGradient(Me, oColorFrom, oColorTo, intStartPerc)

        DrawTransparentLabels()

    End Sub

    Private Sub GradientPanel_Resize(ByVal sender As Object, ByVal e As System.EventArgs) Handles MyBase.Resize

        'TODO: Put back    FillGradient(Me, oColorFrom, oColorTo, uFillStyle, intStartPerc)
        FillGradient(Me, oColorFrom, oColorTo, intStartPerc)

    End Sub

    Private Sub DrawTransparentLabels()

        Dim g As Graphics = CreateGraphics()
        Dim oControl As Control
        Dim oLabel As FlatLabel
        Dim oIcon As TransparentIcon

        For Each oControl In Me.Controls

            If oControl.GetType.Equals(GetType(FlatLabel)) Then

                oLabel = oControl

                If oLabel.IsTransparent Then
                    oLabel.Visible = False
                    If oLabel.IsVisible Then
                        g.DrawString(oLabel.Text, oLabel.Font, New SolidBrush(oLabel.ForeColor), oLabel.Left, oLabel.Top)
                    End If
                End If

            ElseIf oControl.GetType.Equals(GetType(TransparentIcon)) Then

                oIcon = oControl

                If oIcon.IsTransparent Then
                    oIcon.Visible = False
                    If Not oIcon.Icon Is Nothing Then
                        g.DrawIcon(oIcon.Icon, New Rectangle(oIcon.Left, oIcon.Top, oIcon.Width, oIcon.Height))
                    End If
                End If

            End If

        Next

    End Sub
End Class
