Imports System.Runtime.InteropServices

Public Enum ueTabState
    TabState1_Active
    TabState2_InActive
    TabState3_Disabled
End Enum


Public Class FlatControlsShared

    'Public Const FORMAT_TYPE_NONE As FormatType = 0
    'Public Const FORMAT_TYPE_SHORT_DATE As FormatType = 1
    'Public Const FORMAT_TYPE_DATE As FormatType = 2
    'Public Const FORMAT_TYPE_CURRENCY As FormatType = 3
    'Public Const FORMAT_TYPE_TIME As FormatType = 4
    'Public Const FORMAT_TYPE_NUMBER As FormatType = 5
    'Public Const FORMAT_TYPE_PHONE As FormatType = 6
    'Public Const FORMAT_TYPE_SSN As FormatType = 7

    'Public Enum FormatType
    '    Format_None
    '    Format_ShortDate
    '    Format_Date
    '    Format_Currency
    '    Format_Time
    '    Format_Number
    '    Format_Phone
    '    Format_SSN
    'End Enum

    'Public Const DATE_FORMAT_TYPE_MEDIUM As ueDateFormatType = 0
    'Public Const DATE_FORMAT_TYPE_SHORT As ueDateFormatType = 1
    'Public Const DATE_FORMAT_TYPE_LONG As ueDateFormatType = 2

    Public Enum ueDateFormatType
        ueDateFormat_MediumDate = 0
        ueDateFormat_ShortDate = 1
        ueDateFormat_LongDate = 2
    End Enum

    'Public Const GRADIENT_STYLE_NONE As GradientStyle = 0
    'Public Const GRADIENT_STYLE_LR As GradientStyle = 1
    'Public Const GRADIENT_STYLE_RL As GradientStyle = 2
    'Public Const GRADIENT_STYLE_MIDDLE As GradientStyle = 3
    'Public Const GRADIENT_STYLE_TB As GradientStyle = 4

    'Public Enum GradientStyle
    '    None = 0
    '    LeftToRight = 1
    '    RightToLeft = 2
    '    FromMiddle = 3
    '    TopToBottom = 4
    'End Enum

    Public Const CONTROL_LIGHT_CUSTOM As Long = -921630   ' Color.FromArgb(241, 239, 225)
    Public Const CONTROL_CUSTOM As Long = -1250855  ' Color.FromArgb(236, 233, 215)
    Public Const CONTROL_DARK_CUSTOM As Long = -5461862    ' Color.FromArgb(172, 168, 152)
    Public Const HIGHLIGHT_BLUE_CUSTOM As Long = -16776961 ' Color.Blue


    Public Const DATE_FORMAT_MEDIUM = "dddd, MMM d, yyyy"
    Public Const TIME_FORMAT_SHORT = "h:mm tt"

    Public Shared Sub SelectFirstControlInContainer(ByVal oLastControl As Control)

        ' Set focus to the control with the lowest tab index (and tab stop set true) on the parent container

        Dim oParent As Control
        Dim oChild As Control
        Dim dblLowestIndex As Double
        Dim oNextControl As Control

        oParent = oLastControl.Parent

        ' get an actual tabindex value so we're not stuck at 0
        oNextControl = oLastControl
        dblLowestIndex = oLastControl.TabIndex

        For Each oChild In oParent.Controls

            If oChild.Visible And oChild.TabStop Then

                If oChild.TabIndex < dblLowestIndex Then

                    dblLowestIndex = oChild.TabIndex
                    oNextControl = oChild

                End If

            End If

        Next

        If Not oNextControl Is Nothing Then
            oNextControl.Focus()
        End If

    End Sub
    Public Shared Function IsValidDisplayChar(ByVal chrKey As Char) As Boolean

        ' This is the set of valid characters and punctuation acceptable for display
        If Asc(chrKey) >= 32 And Asc(chrKey) <= 126 Then
            Return True
        End If

    End Function
    Public Shared Function GetDisplayHour(ByVal iHour As Integer) As Integer

        If iHour = 0 Then
            iHour = 12
        ElseIf iHour > 12 Then
            iHour = iHour - 12
        End If

        Return iHour

    End Function
    Public Shared Sub FillGradient(ByVal oControl As Control, _
      ByVal ColorFrom As Color, ByVal ColorTo As Color, Optional ByVal intStartPec As Integer = 0)

        Dim g As Graphics = oControl.CreateGraphics
        Dim rect As Rectangle = oControl.ClientRectangle
        Dim brush As System.Drawing.Drawing2D.LinearGradientBrush
        Dim rectLeft, rectRight As Rectangle
        Dim intStartingPosition As Integer
        Dim sngStart As Single

        Try

            sngStart = intStartPec / 100

            If rect.Width < 1 Or rect.Height < 1 Then
                Exit Sub
            End If

            g.Clear(oControl.BackColor)

            'Select Case style

            '    Case GradientStyle.None

            '        ' Do nothing

            '    Case GradientStyle.LeftToRight

            If sngStart > 0 Then
                intStartingPosition = sngStart * rect.Width
                rect = New Rectangle(rect.X + intStartingPosition, rect.Y, rect.Width - intStartingPosition, rect.Height)
            End If

            brush = New System.Drawing.Drawing2D.LinearGradientBrush(rect, ColorFrom, ColorTo, 0, False)

            g.FillRectangle(brush, rect)


            '    Case GradientStyle.FromMiddle

            '        ' break the supplied rectangle into two halves and fill them seperately	
            '        rectLeft = New Rectangle(rect.Location, New Size(CInt((rect.Width / 2) + 1), rect.Height))
            '        rectRight = New Rectangle(New Point(rect.Width - rectLeft.Width - 2, rectLeft.Y), rectLeft.Size)

            '        brush = New System.Drawing.Drawing2D.LinearGradientBrush(rectRight, ColorFrom, ColorTo, 0, False)

            '        g.FillRectangle(brush, rectRight)

            '        brush = New System.Drawing.Drawing2D.LinearGradientBrush(rectLeft, ColorFrom, ColorTo, 180, False)

            '        g.FillRectangle(brush, rectLeft)


            '    Case GradientStyle.TopToBottom

            '        If intStartPec > 0 Then
            '            rect = New Rectangle(rect.X, rect.Y + (sngStart * rect.Height), rect.Width, rect.Height - (sngStart * rect.Width))
            '        End If

            '        brush = New System.Drawing.Drawing2D.LinearGradientBrush(rect, ColorFrom, ColorTo, 90, False)

            '        g.FillRectangle(brush, rect)

            'End Select

        Catch
            ' Do nothing
        End Try

    End Sub

    'Public Shared Sub FillGradient(ByVal oControl As Control, _
    '  ByVal ColorFrom As Color, ByVal ColorTo As Color, ByVal style As Int16, Optional ByVal intStartPec As Integer = 0)


    'End Sub

End Class


Public Class ColorUtil
    '''''''''''''''''''''''''''''''''''''
    ' This is a helper class for converting
    ' color data around
    '''''''''''''''''''''''''''''''''''''
    Public Sub New()
        '// No need to construct this object
    End Sub

#Region " Members"
    '// Knowncolor names
    Public Shared KnownColorNames() As String = _
     {"Transparent", "Black", "DimGray", "Gray", "DarkGray", "Silver", "LightGray", "Gainsboro", "WhiteSmoke", "White", _
    "RosyBrown", "IndianRed", "Brown", "Firebrick", "LightCoral", "Maroon", "DarkRed", "Red", "Snow", "MistyRose", _
    "Salmon", "Tomato", "DarkSalmon", "Coral", "OrangeRed", "LightSalmon", "Sienna", "SeaShell", "Chocalate", _
    "SaddleBrown", "SandyBrown", "PeachPuff", "Peru", "Linen", "Bisque", "DarkOrange", "BurlyWood", "Tan", "AntiqueWhite", _
    "NavajoWhite", "BlanchedAlmond", "PapayaWhip", "Mocassin", "Orange", "Wheat", "OldLace", "FloralWhite", "DarkGoldenrod", _
    "Cornsilk", "Gold", "Khaki", "LemonChiffon", "PaleGoldenrod", "DarkKhaki", "Beige", "LightGoldenrod", "Olive", _
    "Yellow", "LightYellow", "Ivory", "OliveDrab", "YellowGreen", "DarkOliveGreen", "GreenYellow", "Chartreuse", "LawnGreen", _
    "DarkSeaGreen", "ForestGreen", "LimeGreen", "PaleGreen", "DarkGreen", "Green", "Lime", "Honeydew", "SeaGreen", "MediumSeaGreen", _
    "SpringGreen", "MintCream", "MediumSpringGreen", "MediumAquaMarine", "YellowAquaMarine", "Turquoise", "LightSeaGreen", _
    "MediumTurquoise", "DarkSlateGray", "PaleTurquoise", "Teal", "DarkCyan", "Aqua", "Cyan", "LightCyan", "Azure", "DarkTurquoise", _
    "CadetBlue", "PowderBlue", "LightBlue", "DeepSkyBlue", "SkyBlue", "LightSkyBlue", "SteelBlue", "AliceBlue", "DodgerBlue", _
    "SlateGray", "LightSlateGray", "LightSteelBlue", "CornflowerBlue", "RoyalBlue", "MidnightBlue", "Lavender", "Navy", _
    "DarkBlue", "MediumBlue", "Blue", "GhostWhite", "SlateBlue", "DarkSlateBlue", "MediumSlateBlue", "MediumPurple", _
    "BlueViolet", "Indigo", "DarkOrchid", "DarkViolet", "MediumOrchid", "Thistle", "Plum", "Violet", "Purple", "DarkMagenta", _
    "Magenta", "Fuchsia", "Orchid", "MediumVioletRed", "DeepPink", "HotPink", "LavenderBlush", "PaleVioletRed", "Crimson", _
    "Pink", "LightPink"}

    '// Systemcolors names
    Public Shared SystemColorNames() As String = { _
     "ActiveBorder", "ActiveCaption", "ActiveCaptionText", "AppWorkspace", "Control", "ControlDark", "ControlDarkDark", _
     "ControlLight", "ControlLightLight", "ControlText", "Desktop", "GrayText", "HighLight", "HighLightText", _
     "HotTrack", "InactiveBorder", "InactiveCaption", "InactiveCaptionText", "Info", "InfoText", "Menu", "MenuText", _
     "ScrollBar", "Window", "WindowFrame", "WindowText"}
#End Region

    '// Conversion between RGB and Hue, Saturation and Luminosity function helpers
    Public Shared Sub HSLToRGB(ByVal h As Single, ByVal s As Single, ByVal l As Single, ByRef r As Single, ByRef g As Single, ByRef b As Single)
        '// given h,s,l,[240 and r,g,b [0-255]
        '// convert h [0-360], s,l,r,g,b [0-1]
        h = (h / 240.0F) * 360.0F
        s /= 240
        l /= 240
        r /= 255
        g /= 255
        b /= 255

        '// Begin Foley
        Dim m1 As Single
        Dim m2 As Single

        '// Calc m2
        If l <= 0.5 Then
            '//m2=(l*(l+s)); seems to be typo in Foley??, replace l for 1
            m2 = (l * (1 + s))
        Else
            m2 = (l + s - l * s)
        End If

        '//calc m1
        m1 = 2.0F * l - m2

        '//calc r,g,b in [0-1]
        If s = 0 Then
            '	// Achromatic: There is no hue
            '	// leave out the UNDEFINED part, h will always have value
            r = g = b = l
        Else
            '	// Chromatic: There is a hue
            r = getRGBValue(m1, m2, h + 120.0F)
            g = getRGBValue(m1, m2, h)
            b = getRGBValue(m1, m2, h - 120.0F)
        End If

        '// End Foley
        '// convert to 0-255 ranges
        r *= 255.0F
        g *= 255.0F
        b *= 255.0F
    End Sub
    Private Shared Function getRGBValue(ByVal n1 As Single, ByVal n2 As Single, ByVal hue As Single) As Single
        '// Helper function for the HSLToRGB function above
        If hue > 360.0F Then
            hue -= 360.0F
        ElseIf hue < 0 Then
            hue += 360.0F
        End If

        If hue < 60.0F Then
            Return n1 + (n2 - n1) * hue / 60.0F
        ElseIf hue < 180.0F Then
            Return n2
        ElseIf hue < 240.0F Then
            Return n1 + (n2 - n1) * (240.0F - hue) / 60.0F
        Else
            Return n1
        End If
    End Function
    Public Shared Sub RGBToHSL(ByVal r As Integer, ByVal g As Integer, ByVal b As Integer, ByRef h As Single, ByRef s As Single, ByRef l As Single)

        '//Computer Graphics - Foley p.595
        Dim delta As Single
        Dim fr As Single = r / 255.0F
        Dim fg As Single = g / 255.0F
        Dim fb As Single = b / 255.0F
        Dim max As Single = Math.Max(fr, Math.Max(fg, fb))
        Dim min As Single = Math.Min(fr, Math.Min(fg, fb))

        '//calc the lightness
        l = (max + min) / 2

        If max = min Then
            '//should be undefined but this works for what we need
            s = 0.0F
            h = 240.0F
        Else
            delta = max - min
            '//calc the Saturation
            If l < 0.5F Then
                s = delta / (max + min)
            Else
                s = delta / (2.0F - (max + min))
            End If

            '//calc the hue
            If fr = max Then
                h = (fg - fb) / delta
            ElseIf fg = max Then
                h = 2.0F + (fb - fr) / delta
            ElseIf fb = max Then
                h = 4.0F + (fr - fg) / delta
            End If

            '//convert hue to degrees
            h *= 60.0F
            If h < 0.0F Then
                h += 360.0F
            End If
            '//end foley
        End If

        '//convert to 0-255 ranges
        '//h [0-360], h,l [0-1]
        l *= 240.0F
        s *= 240.0F
        h = (h / 360.0F) * 240.0F

    End Sub

    '// Visual Studio .NET colors calculation helpers
    Public Shared ReadOnly Property VSNetBackgroundColor() As Color
        Get
            Return CalculateColor(SystemColors.Window, Color.FromArgb(FlatControlsShared.CONTROL_CUSTOM), 220)
        End Get
    End Property
    Public Shared ReadOnly Property VSNetSelectionColor(Optional ByVal HighlightColorRGB As Long = -13538619) As Color
        ' NOTE: Default optional value is the RGB for the standard SystemColors.Highlight
        Get
            Return CalculateColor(Color.FromArgb(HighlightColorRGB), SystemColors.Window, 70)
        End Get
    End Property
    Public Shared ReadOnly Property VSNetStripeColor() As Color
        Get
            Return CalculateColor(Color.FromArgb(FlatControlsShared.CONTROL_CUSTOM), VSNetBackgroundColor, 195)
        End Get
    End Property
    Public Shared ReadOnly Property VSNetPressedColor(Optional ByVal HighlightColorRGB As Long = -13538619) As Color
        ' NOTE: Default value is the RGB for SystemColors.Highlight
        Get
            Return CalculateColor(Color.FromArgb(HighlightColorRGB), ColorUtil.VSNetSelectionColor, 70)
        End Get
    End Property
    Public Shared ReadOnly Property VSNetToggleColor() As Color
        Get
            Return CalculateColor(SystemColors.Highlight, SystemColors.Window, 30)
        End Get
    End Property
    Public Shared Function CalculateColor(ByVal front As Color, ByVal back As Color, ByVal alpha As Byte) As Color
        '// Use alpha blending to brigthen the colors but don't use it
        '// directly. Instead derive an opaque color that we can use.
        '// -- if we use a color with alpha blending directly we won't be able 
        '// to paint over whatever color was in the background and there
        '// would be shadows of that color showing through
        Dim frontColor As Color = Color.FromArgb(255, front)
        Dim backColor As Color = Color.FromArgb(255, back)

        Dim frontRed As Single = frontColor.R
        Dim frontGreen As Single = frontColor.G
        Dim frontBlue As Single = frontColor.B
        Dim backRed As Single = backColor.R
        Dim backGreen As Single = backColor.G
        Dim backBlue As Single = backColor.B

        Dim fRed As Single = frontRed * alpha / 255 + backRed * Convert.ToSingle((255 - alpha) / 255)
        Dim newRed As Byte = Convert.ToByte(fRed)
        Dim fGreen As Single = frontGreen * alpha / 255 + backGreen * Convert.ToSingle((255 - alpha) / 255)
        Dim newGreen As Byte = Convert.ToByte(fGreen)
        Dim fBlue As Single = frontBlue * alpha / 255 + backBlue * Convert.ToSingle((255 - alpha) / 255)
        Dim newBlue As Byte = Convert.ToByte(fBlue)

        Return Color.FromArgb(255, newRed, newGreen, newBlue)
    End Function

    '// General functions
    Public Shared Function ColorFromPoint(ByVal g As Graphics, ByVal x As Integer, ByVal y As Integer) As Color
        Dim hDC As IntPtr = g.GetHdc()
        '// Get the color of the pixel first
        Dim colorref As UInt32 = Win32API.GetPixel(hDC, x, y)
        Dim Red As Byte = GetRValue(colorref)
        Dim Green As Byte = GetGValue(colorref)
        Dim Blue As Byte = GetBValue(colorref)
        g.ReleaseHdc(hDC)
        Return Color.FromArgb(Red, Green, Blue)
    End Function
    Public Shared Function IsKnownColor(ByVal color As Color, ByRef knownColor As Color, ByVal useTransparent As Boolean) As Boolean
        '// Using the Color structrure "FromKnowColor" does not work if 
        '// we did not create the color as a known color to begin with
        '// we need to compare the rgbs of both color 
        Dim currentColor As Color = color.Empty
        Dim badColor As Boolean = False
        Dim enumValue As KnownColor
        For enumValue = 0 To knownColor.YellowGreen.ToKnownColor
            currentColor = color.FromKnownColor(enumValue)
            Dim colorName As String = currentColor.Name
            If Not useTransparent Then
                badColor = (colorName = "Transparent")
                If (color.A = currentColor.A And color.R = currentColor.R And color.G = currentColor.G _
                 And color.B = currentColor.B And Not currentColor.IsSystemColor _
                 And Not badColor) Then
                    knownColor = currentColor
                    Return True
                End If
            End If
        Next enumValue
        Return False
    End Function
    Public Shared Function IsSystemColor(ByVal color As Color, ByRef knownColor As Color) As Boolean
        '// Using the Color structrure "FromKnowColor" does not work if 
        '// we did not create the color as a known color to begin with
        '// we need to compare the rgbs of both color 
        Dim currentColor As Color = color.Empty
        Dim enumValue As KnownColor
        For enumValue = 0 To knownColor.YellowGreen.ToKnownColor
            currentColor = color.FromKnownColor(enumValue)
            Dim colorName As String = currentColor.Name
            If (color.R = currentColor.R And color.G = currentColor.G _
             And color.B = currentColor.B And currentColor.IsSystemColor) Then
                knownColor = currentColor
                Return True
            End If
        Next enumValue

        Return False
    End Function
    Public Shared Function GetCOLORREF(ByVal color As Color) As UInt32
        Return RGB(color.R, color.G, color.B)
    End Function

    '// Windows RGB related macros

    Public Shared Function GetRValue(ByVal color As UInt32) As Byte
        Dim i As Integer = 0
        Dim iBinaryNumber As Integer = 0
        Dim retVal As Byte = 0
        For i = 0 To 7
            iBinaryNumber = (2 ^ i)
            If (Convert.ToInt32(color) And iBinaryNumber) = iBinaryNumber Then
                Dim iShiftedBinaryNumber As Byte = (2 ^ i)
                retVal = retVal Or iShiftedBinaryNumber
            End If
        Next
        Return retVal
    End Function
    Public Shared Function GetGValue(ByVal color As UInt32) As Byte
        Dim i As Integer = 0
        Dim iBinaryNumber As Integer = 0
        Dim retVal As Byte = 0
        For i = 8 To 15
            iBinaryNumber = (2 ^ i)
            If (Convert.ToInt32(color) And iBinaryNumber) = iBinaryNumber Then
                Dim iShiftedBinaryNumber As Byte = (2 ^ (i - 8))
                retVal = retVal Or iShiftedBinaryNumber
            End If
        Next
        Return retVal
    End Function
    Public Shared Function GetBValue(ByVal color As UInt32) As Byte
        Dim i As Integer = 0
        Dim iBinaryNumber As Integer = 0
        Dim retVal As Byte = 0
        For i = 16 To 23
            iBinaryNumber = (2 ^ i)
            If (Convert.ToInt32(color) And iBinaryNumber) = iBinaryNumber Then
                Dim iShiftedBinaryNumber As Byte = (2 ^ (i - 16))
                retVal = retVal Or iShiftedBinaryNumber
            End If
        Next
        Return retVal
    End Function
    Public Shared Function RGB(ByVal r As Integer, ByVal g As Integer, ByVal b As Integer) As UInt32
        Dim i As Integer = 0
        Dim iBinaryNumber As Integer = 0
        Dim retVal As Integer
        For i = 0 To 7
            iBinaryNumber = (2 ^ i)
            If (r And iBinaryNumber) = iBinaryNumber Then
                Dim iShiftedBinaryNumber As Byte = (2 ^ i)
                retVal = retVal Or iShiftedBinaryNumber
            End If
        Next
        iBinaryNumber = 0
        For i = 0 To 7
            iBinaryNumber = (2 ^ i)
            If (g And iBinaryNumber) = iBinaryNumber Then
                Dim iShiftedBinaryNumber As Integer = (2 ^ (i + 8))
                retVal = retVal Or iShiftedBinaryNumber
            End If
        Next
        iBinaryNumber = 0
        For i = 0 To 7
            iBinaryNumber = (2 ^ i)
            If (b And iBinaryNumber) = iBinaryNumber Then
                Dim iShiftedBinaryNumber As Integer = (2 ^ (i + 16))
                retVal = retVal Or iShiftedBinaryNumber
            End If
        Next
        Return Convert.ToUInt32(retVal)
    End Function
End Class

Friend Class Win32API
    '''''''''''''''''''''''''''''''''''''
    ' this class is full of useful, re-usable
    ' VB ports of common Win32API stuff...
    '''''''''''''''''''''''''''''''''''''
    Public Delegate Function HookProc(ByVal nCode As Integer, ByVal wParam As IntPtr, ByVal lParam As IntPtr) As IntPtr

#Region " Enums and structs"
    Public Enum WindowsHookCodes
        WH_MSGFILTER = -1
        WH_JOURNALRECORD = 0
        WH_JOURNALPLAYBACK = 1
        WH_KEYBOARD = 2
        WH_GETMESSAGE = 3
        WH_CALLWNDPROC = 4
        WH_CBT = 5
        WH_SYSMSGFILTER = 6
        WH_MOUSE = 7
        WH_HARDWARE = 8
        WH_DEBUG = 9
        WH_SHELL = 10
        WH_FOREGROUNDIDLE = 11
        WH_CALLWNDPROCRET = 12
        WH_KEYBOARD_LL = 13
        WH_MOUSE_LL = 14
    End Enum

    Public Enum TrackerEventFlags As Integer
        TME_HOVER = &H1
        TME_LEAVE = &H2
        TME_QUERY = &H40000000
        TME_CANCEL = &H80000000
    End Enum

    Public Enum Msg
        WM_NULL = &H0
        WM_CREATE = &H1
        WM_DESTROY = &H2
        WM_MOVE = &H3
        WM_SIZE = &H5
        WM_ACTIVATE = &H6
        WM_SETFOCUS = &H7
        WM_KILLFOCUS = &H8
        WM_ENABLE = &HA
        WM_SETREDRAW = &HB
        WM_SETTEXT = &HC
        WM_GETTEXT = &HD
        WM_GETTEXTLENGTH = &HE
        WM_PAINT = &HF
        WM_CLOSE = &H10
        WM_QUERYENDSESSION = &H11
        WM_QUIT = &H12
        WM_QUERYOPEN = &H13
        WM_ERASEBKGND = &H14
        WM_SYSCOLORCHANGE = &H15
        WM_ENDSESSION = &H16
        WM_SHOWWINDOW = &H18
        WM_CTLCOLOR = &H19
        WM_WININICHANGE = &H1A
        WM_SETTINGCHANGE = &H1A
        WM_DEVMODECHANGE = &H1B
        WM_ACTIVATEAPP = &H1C
        WM_FONTCHANGE = &H1D
        WM_TIMECHANGE = &H1E
        WM_CANCELMODE = &H1F
        WM_SETCURSOR = &H20
        WM_MOUSEACTIVATE = &H21
        WM_CHILDACTIVATE = &H22
        WM_QUEUESYNC = &H23
        WM_GETMINMAXINFO = &H24
        WM_PAINTICON = &H26
        WM_ICONERASEBKGND = &H27
        WM_NEXTDLGCTL = &H28
        WM_SPOOLERSTATUS = &H2A
        WM_DRAWITEM = &H2B
        WM_MEASUREITEM = &H2C
        WM_DELETEITEM = &H2D
        WM_VKEYTOITEM = &H2E
        WM_CHARTOITEM = &H2F
        WM_SETFONT = &H30
        WM_GETFONT = &H31
        WM_SETHOTKEY = &H32
        WM_GETHOTKEY = &H33
        WM_QUERYDRAGICON = &H37
        WM_COMPAREITEM = &H39
        WM_GETOBJECT = &H3D
        WM_COMPACTING = &H41
        WM_COMMNOTIFY = &H44
        WM_WINDOWPOSCHANGING = &H46
        WM_WINDOWPOSCHANGED = &H47
        WM_POWER = &H48
        WM_COPYDATA = &H4A
        WM_CANCELJOURNAL = &H4B
        WM_NOTIFY = &H4E
        WM_INPUTLANGCHANGEREQUEST = &H50
        WM_INPUTLANGCHANGE = &H51
        WM_TCARD = &H52
        WM_HELP = &H53
        WM_USERCHANGED = &H54
        WM_NOTIFYFORMAT = &H55
        WM_CONTEXTMENU = &H7B
        WM_STYLECHANGING = &H7C
        WM_STYLECHANGED = &H7D
        WM_DISPLAYCHANGE = &H7E
        WM_GETICON = &H7F
        WM_SETICON = &H80
        WM_NCCREATE = &H81
        WM_NCDESTROY = &H82
        WM_NCCALCSIZE = &H83
        WM_NCHITTEST = &H84
        WM_NCPAINT = &H85
        WM_NCACTIVATE = &H86
        WM_GETDLGCODE = &H87
        WM_SYNCPAINT = &H88
        WM_NCMOUSEMOVE = &HA0
        WM_NCLBUTTONDOWN = &HA1
        WM_NCLBUTTONUP = &HA2
        WM_NCLBUTTONDBLCLK = &HA3
        WM_NCRBUTTONDOWN = &HA4
        WM_NCRBUTTONUP = &HA5
        WM_NCRBUTTONDBLCLK = &HA6
        WM_NCMBUTTONDOWN = &HA7
        WM_NCMBUTTONUP = &HA8
        WM_NCMBUTTONDBLCLK = &HA9
        WM_KEYDOWN = &H100
        WM_KEYUP = &H101
        WM_CHAR = &H102
        WM_DEADCHAR = &H103
        WM_SYSKEYDOWN = &H104
        WM_SYSKEYUP = &H105
        WM_SYSCHAR = &H106
        WM_SYSDEADCHAR = &H107
        WM_KEYLAST = &H108
        WM_IME_STARTCOMPOSITION = &H10D
        WM_IME_ENDCOMPOSITION = &H10E
        WM_IME_COMPOSITION = &H10F
        WM_IME_KEYLAST = &H10F
        WM_INITDIALOG = &H110
        WM_COMMAND = &H111
        WM_SYSCOMMAND = &H112
        WM_TIMER = &H113
        WM_HSCROLL = &H114
        WM_VSCROLL = &H115
        WM_INITMENU = &H116
        WM_INITMENUPOPUP = &H117
        WM_MENUSELECT = &H11F
        WM_MENUCHAR = &H120
        WM_ENTERIDLE = &H121
        WM_MENURBUTTONUP = &H122
        WM_MENUDRAG = &H123
        WM_MENUGETOBJECT = &H124
        WM_UNINITMENUPOPUP = &H125
        WM_MENUCOMMAND = &H126
        WM_CTLCOLORMSGBOX = &H132
        WM_CTLCOLOREDIT = &H133
        WM_CTLCOLORLISTBOX = &H134
        WM_CTLCOLORBTN = &H135
        WM_CTLCOLORDLG = &H136
        WM_CTLCOLORSCROLLBAR = &H137
        WM_CTLCOLORSTATIC = &H138
        WM_MOUSEMOVE = &H200
        WM_LBUTTONDOWN = &H201
        WM_LBUTTONUP = &H202
        WM_LBUTTONDBLCLK = &H203
        WM_RBUTTONDOWN = &H204
        WM_RBUTTONUP = &H205
        WM_RBUTTONDBLCLK = &H206
        WM_MBUTTONDOWN = &H207
        WM_MBUTTONUP = &H208
        WM_MBUTTONDBLCLK = &H209
        WM_MOUSEWHEEL = &H20A
        WM_PARENTNOTIFY = &H210
        WM_ENTERMENULOOP = &H211
        WM_EXITMENULOOP = &H212
        WM_NEXTMENU = &H213
        WM_SIZING = &H214
        WM_CAPTURECHANGED = &H215
        WM_MOVING = &H216
        WM_DEVICECHANGE = &H219
        WM_MDICREATE = &H220
        WM_MDIDESTROY = &H221
        WM_MDIACTIVATE = &H222
        WM_MDIRESTORE = &H223
        WM_MDINEXT = &H224
        WM_MDIMAXIMIZE = &H225
        WM_MDITILE = &H226
        WM_MDICASCADE = &H227
        WM_MDIICONARRANGE = &H228
        WM_MDIGETACTIVE = &H229
        WM_MDISETMENU = &H230
        WM_ENTERSIZEMOVE = &H231
        WM_EXITSIZEMOVE = &H232
        WM_DROPFILES = &H233
        WM_MDIREFRESHMENU = &H234
        WM_IME_SETCONTEXT = &H281
        WM_IME_NOTIFY = &H282
        WM_IME_CONTROL = &H283
        WM_IME_COMPOSITIONFULL = &H284
        WM_IME_SELECT = &H285
        WM_IME_CHAR = &H286
        WM_IME_REQUEST = &H288
        WM_IME_KEYDOWN = &H290
        WM_IME_KEYUP = &H291
        WM_MOUSEHOVER = &H2A1
        WM_MOUSELEAVE = &H2A3
        WM_CUT = &H300
        WM_COPY = &H301
        WM_PASTE = &H302
        WM_CLEAR = &H303
        WM_UNDO = &H304
        WM_RENDERFORMAT = &H305
        WM_RENDERALLFORMATS = &H306
        WM_DESTROYCLIPBOARD = &H307
        WM_DRAWCLIPBOARD = &H308
        WM_PAINTCLIPBOARD = &H309
        WM_VSCROLLCLIPBOARD = &H30A
        WM_SIZECLIPBOARD = &H30B
        WM_ASKCBFORMATNAME = &H30C
        WM_CHANGECBCHAIN = &H30D
        WM_HSCROLLCLIPBOARD = &H30E
        WM_QUERYNEWPALETTE = &H30F
        WM_PALETTEISCHANGING = &H310
        WM_PALETTECHANGED = &H311
        WM_HOTKEY = &H312
        WM_PRINT = &H317
        WM_PRINTCLIENT = &H318
        WM_HANDHELDFIRST = &H358
        WM_HANDHELDLAST = &H35F
        WM_AFXFIRST = &H360
        WM_AFXLAST = &H37F
        WM_PENWINFIRST = &H380
        WM_PENWINLAST = &H38F
        WM_APP = &H8000
        WM_USER = &H400
        WM_REFLECT = WM_USER + &H1C00
    End Enum

    Public Enum DrawTextFormatFlags As Integer
        DT_TOP = &H0
        DT_LEFT = &H0
        DT_CENTER = &H1
        DT_RIGHT = &H2
        DT_VCENTER = &H4
        DT_BOTTOM = &H8
        DT_WORDBREAK = &H10
        DT_SINGLELINE = &H20
        DT_EXPANDTABS = &H40
        DT_TABSTOP = &H80
        DT_NOCLIP = &H100
        DT_EXTERNALLEADING = &H200
        DT_CALCRECT = &H400
        DT_NOPREFIX = &H800
        DT_INTERNAL = &H1000
        DT_EDITCONTROL = &H2000
        DT_PATH_ELLIPSIS = &H4000
        DT_END_ELLIPSIS = &H8000
        DT_MODIFYSTRING = &H10000
        DT_RTLREADING = &H20000
        DT_WORD_ELLIPSIS = &H40000
    End Enum

    <StructLayout(LayoutKind.Sequential)> _
    Public Structure POINT
        Public x As Integer
        Public y As Integer
    End Structure

    <StructLayout(LayoutKind.Sequential)> _
    Public Structure RECT
        Public left As Integer
        Public top As Integer
        Public right As Integer
        Public bottom As Integer
    End Structure

    <StructLayout(LayoutKind.Sequential)> _
    Public Structure TRACKMOUSEEVENTS
        Public cbSize As UInt32
        Public dwFlags As UInt32
        Public hWnd As IntPtr
        Public dwHoverTime As UInt32
    End Structure

    Public Structure MOUSEHOOKSTRUCT
        Public pt As POINT
        Public hwnd As IntPtr
        Public wHitTestCode As Integer
        Public dwExtraInfo As IntPtr
    End Structure
#End Region

#Region " Methods"
#Region " Kernel32"
    <DllImport("kernel32.dll")> _
    Public Shared Function GetCurrentThreadId() As Integer
    End Function
#End Region

#Region " User32"
    <DllImport("user32.dll")> _
    Public Shared Function GetDlgItem(ByVal hDlg As IntPtr, ByVal nControlID As Integer) As IntPtr
    End Function
    <DllImport("user32.dll")> _
    Public Shared Function SetWindowsHookEx(ByVal hookid As Integer, ByVal pfnhook As HookProc, ByVal hinst As IntPtr, ByVal threadid As Integer) As IntPtr
    End Function
    <DllImport("user32.dll")> _
    Public Shared Function UnhookWindowsHookEx(ByVal hhook As IntPtr) As Boolean
    End Function
    <DllImport("user32.dll")> _
    Public Shared Function SetFocus(ByVal hWnd As IntPtr) As IntPtr
    End Function
    <DllImport("user32.dll")> _
    Public Shared Function CallNextHookEx(ByVal hhook As IntPtr, ByVal code As Integer, ByVal wparam As IntPtr, ByVal lparam As IntPtr) As IntPtr
    End Function
    <DllImport("User32.dll")> _
     Public Shared Function TrackMouseEvent(ByRef tme As TRACKMOUSEEVENTS) As Boolean
    End Function
    <DllImport("user32.dll")> _
    Public Shared Function GetClientRect(ByVal hWnd As IntPtr, ByRef rc As RECT) As Integer
    End Function
    <DllImport("user32.dll")> _
    Public Shared Function DrawText(ByVal hdc As IntPtr, ByVal lpString As String, ByVal nCount As Integer, ByRef lpRect As RECT, ByVal uFormat As Integer) As Integer
    End Function
#End Region

#Region " GDI32"
    <DllImport("gdi32.dll")> _
    Public Shared Function SelectObject(ByVal hDC As IntPtr, ByVal hObject As IntPtr) As IntPtr
    End Function
    <DllImport("gdi32.dll")> _
    Public Shared Function DeleteObject(ByVal hObject As IntPtr) As Boolean
    End Function
    <DllImport("gdi32.dll")> _
    Public Shared Function GetPixel(ByVal hDC As IntPtr, ByVal XPos As Integer, ByVal YPos As Integer) As UInt32
    End Function
#End Region
#End Region
End Class
