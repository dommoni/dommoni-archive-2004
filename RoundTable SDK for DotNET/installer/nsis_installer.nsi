;
; NSIS Installer for RoundTable SDK for DotNET.
;
; Copyright 2005 Dommoni Corporation. All rights reserved.
;
!include "MUI.nsh"
!include "LogicLib.nsh"


OutFile ".\RoundTable SDK for DotNET.exe"

Name "RoundTable SDK for Microsoft .NET"
InstallDir "$PROGRAMFILES\RoundTable SDKs\RoundTable SDK for DotNET"

XPStyle on

!define MUI_ABORTWARNING

!define REG_UNINSTALL "Software\Microsoft\Windows\CurrentVersion\Uninstall\RoundTable SDK for DotNET"

!insertmacro MUI_PAGE_WELCOME
;!insertmacro MUI_PAGE_LICENSE "License.rtf"
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES

!insertmacro MUI_UNPAGE_WELCOME
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES
!insertmacro MUI_UNPAGE_FINISH

!insertmacro MUI_LANGUAGE "English"

Var DODELETE

;--------------------------------
;Installer Section
Section
  SetOutPath "$INSTDIR"

  File "..\bin\Release\RoundTable SDK for DotNET.dll"
  
  CreateDirectory "$INSTDIR\Dist"
  CreateDirectory "$SMPROGRAMS\RoundTable SDKs\RoundTable SDK for DotNET"
  
  CreateShortCut "$SMPROGRAMS\RoundTable SDKs\RoundTable SDK for DotNET\SDK Distributable.lnk" "$INSTDIR\Dist" 
  
  ;\
  ;"some command line parameters" "$INSTDIR\My Program.exe" 2 SW_SHOWNORMAL \
  ;ALT|CTRL|SHIFT|F5 "a description"

  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayName" "RoundTable SDK for Microsoft .NET"
  WriteRegStr HKLM "${REG_UNINSTALL}" "UninstallString" '"$INSTDIR\Uninstall.exe"'
  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayIcon" "$INSTDIR\Uninstall.exe"
  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayVersion" "1.0"
  WriteRegStr HKLM "${REG_UNINSTALL}" "Publisher" "Dommoni Corporation"

  ;Create uninstaller
  WriteUninstaller "$INSTDIR\Uninstall.exe"
  CreateShortCut "$SMPROGRAMS\RoundTable SDKs\RoundTable SDK for DotNET\Uninstall.lnk" "$INSTDIR\Uninstall.exe"

SectionEnd

;--------------------------------
;Uninstaller Section
Section "Uninstall"
  
  RMDir /r "$INSTDIR\*"
  Delete "$INSTDIR\*.*"

  Delete "$INSTDIR\Uninstall.exe"

  RMDir "$INSTDIR"

  RMDir /r "$SMPROGRAMS\RoundTable SDKs\RoundTable SDK for DotNET\*"
  Delete "$SMPROGRAMS\RoundTable SDKs\RoundTable SDK for DotNET\*.*"
  RMDir "$SMPROGRAMS\RoundTable SDKs\RoundTable SDK for DotNET"

  ; Determine if anything else is installed...
  ClearErrors
  StrCpy $DODELETE "0"
  FindFirst $R1 $R2 "$SMPROGRAMS\RoundTable SDKs\*"
  ${Unless} ${Errors}
    ${Do}
      ${Select} $R2
        ${Case2} "." ".."
          ; Do nothing
        ${CaseElse}
          StrCpy $DODELETE "1"
      ${EndSelect}
      FindNext $R1 $R2
    ${LoopUntil} ${Errors}
    FindClose $R1
  ${EndUnless}

  ; Directory is empty, we can delete it.
  ${If} $DODELETE == "0"
    RMDir "$SMPROGRAMS\RoundTable SDKs"
  ${EndIf}
  DeleteRegKey HKLM "${REG_UNINSTALL}"

SectionEnd
;
;
; $Log: nsis_installer.nsi,v $
; Revision 1.2  2005/03/30 21:20:51  brian
; Added code to determine when to remove the 'RoundTable SDKs' Directory.
;
; Revision 1.1  2005/03/30 11:13:58  brian
; initial revision
;
;
;