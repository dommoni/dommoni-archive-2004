!include "MUI.nsh"


OutFile .\install.exe 

Name "RoundTable LFG"
InstallDir "$PROGRAMFILES\RoundTable LFG"

XPStyle on

!define MUI_ABORTWARNING

!define REG_UNINSTALL "Software\Microsoft\Windows\CurrentVersion\Uninstall\RoundTable LFG"

Var STARTMENU_FOLDER
var MUI_TEMP

;----------------------------------
; Pages

; install
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_DIRECTORY

  !define MUI_STARTMENUPAGE_REGISTRY_ROOT "HKCU" 
  !define MUI_STARTMENUPAGE_REGISTRY_KEY "Software\RoundTable LFG" 
  !define MUI_STARTMENUPAGE_REGISTRY_VALUENAME "Start Menu Folder"
  
!insertmacro MUI_PAGE_STARTMENU Application $STARTMENU_FOLDER
!insertmacro MUI_PAGE_INSTFILES

; Uninstall section
!insertmacro MUI_UNPAGE_WELCOME
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES
!insertmacro MUI_UNPAGE_FINISH

!insertmacro MUI_LANGUAGE "English"

;--------------------------------
;Installer Section
Section
  SetOutPath "$INSTDIR"

  File /oname="RoundTableLFG.exe" "..\bin\Release\RoundTable LFG.exe"
  File /oname="RoundTableLFG.exe.manifest" "..\bin\Release\RoundTable LFG.exe.manifest"

  !insertmacro MUI_STARTMENU_WRITE_BEGIN Application
    
    ;Create shortcuts
    CreateDirectory "$SMPROGRAMS\$STARTMENU_FOLDER"
    CreateShortCut "$SMPROGRAMS\$STARTMENU_FOLDER\RoundTable LFG.lnk" "$INSTDIR\RoundTableLFG.exe"
    CreateShortCut "$SMPROGRAMS\$STARTMENU_FOLDER\Uninstall.lnk" "$INSTDIR\Uninstall.exe"
  
  !insertmacro MUI_STARTMENU_WRITE_END

  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayName" "RoundTable LFG"
  WriteRegStr HKLM "${REG_UNINSTALL}" "UninstallString" '"$INSTDIR\Uninstall.exe"'
  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayIcon" "$INSTDIR\Uninstall.exe"
  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayVersion" "1.0"
  WriteRegStr HKLM "${REG_UNINSTALL}" "Publisher" "Dommoni Corporation"

  ;Create uninstaller
  WriteUninstaller "$INSTDIR\Uninstall.exe"
SectionEnd

;--------------------------------
;Uninstaller Section
Section "Uninstall"

  

  ;====================================================
  ; Start Menu Delete Section
  !insertmacro MUI_STARTMENU_GETFOLDER Application $MUI_TEMP
    
  Delete "$SMPROGRAMS\$MUI_TEMP\Uninstall.lnk"
  Delete "$SMPROGRAMS\$MUI_TEMP\RoundTable LFG.lnk"
  
  ;Delete empty start menu parent diretories
  StrCpy $MUI_TEMP "$SMPROGRAMS\$MUI_TEMP"
 
  startMenuDeleteLoop:
    RMDir $MUI_TEMP
    GetFullPathName $MUI_TEMP "$MUI_TEMP\.."
    
    IfErrors startMenuDeleteLoopDone
  
    StrCmp $MUI_TEMP $SMPROGRAMS startMenuDeleteLoopDone startMenuDeleteLoop
  startMenuDeleteLoopDone:

  DeleteRegKey /ifempty HKCU "Software\RoundTable LFG"


  ; rest
  RMDir /r "$INSTDIR\*"
  Delete "$INSTDIR\*.*"

  Delete "$INSTDIR\Uninstall.exe"

  RMDir "$INSTDIR"
  DeleteRegKey HKLM "${REG_UNINSTALL}"

SectionEnd
