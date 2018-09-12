!include "MUI.nsh"


OutFile .\install.exe 

Name "RoundTable Project Server 1.0"
InstallDir "$PROGRAMFILES\RoundTable Project Server"

XPStyle on

!define MUI_ABORTWARNING

!define REG_UNINSTALL "Software\Microsoft\Windows\CurrentVersion\Uninstall\RoundTable Project Server"

!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_LICENSE "License.rtf"
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES

!insertmacro MUI_UNPAGE_WELCOME
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES
!insertmacro MUI_UNPAGE_FINISH

!insertmacro MUI_LANGUAGE "English"

;--------------------------------
;Installer Section
Section
  SetOutPath "$INSTDIR"

  File /r ..\3rdParty\jakarta-tomcat-5.0.28_rt-dist\*.*
  File /oname="webapps\ProjectServer.war" ..\ProjectServer.war
  File /oname="webapps\WebUI.war" ..\WebUI.war

  ; Create the HSQL DB
  File /oname="derby.jar" ..\lib\derby.jar
  File /oname="ProjectServer.jar" ..\ProjectServer.jar
  File /r ..\sql
  File ..\createdb.bat

  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayName" "RoundTable Project Server"
  WriteRegStr HKLM "${REG_UNINSTALL}" "UninstallString" '"$INSTDIR\Uninstall.exe"'
  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayIcon" "$INSTDIR\Uninstall.exe"
  WriteRegStr HKLM "${REG_UNINSTALL}" "DisplayVersion" "1.0"
  WriteRegStr HKLM "${REG_UNINSTALL}" "Publisher" "Dommoni Corporation"


  execwait "bin\InstallTomcat-NT.bat"
  execwait "createdb.bat"

  ;Create uninstaller
  WriteUninstaller "$INSTDIR\Uninstall.exe"

  CreateDirectory "$INSTDIR\license"

  ;Clean up - Delete the files we no longer need
  Delete "$INSTDIR\derby.jar"
  Delete "$INSTDIR\ProjectServer.jar"
  Delete "$INSTDIR\createdb.bat"
  RMDir /r "$INSTDIR\sql"

SectionEnd

;--------------------------------
;Uninstaller Section
Section "Uninstall"

  ;ADD YOUR OWN FILES HERE...
  execwait "$INSTDIR\bin\UninstallTomcat-NT.bat"

  RMDir /r "$INSTDIR\*"
  Delete "$INSTDIR\*.*"

  Delete "$INSTDIR\Uninstall.exe"

  RMDir "$INSTDIR"
  DeleteRegKey HKLM "${REG_UNINSTALL}"

SectionEnd
