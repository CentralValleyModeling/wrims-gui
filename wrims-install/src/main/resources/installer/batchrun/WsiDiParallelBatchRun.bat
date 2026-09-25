@echo off
setlocal DisableDelayedExpansion
pushd "%~dp0.." || exit /b 1
set "WRIMS_JAVA=jre\bin\java.exe"
for /d %%J in ("plugins\*jre.full*") do if exist "%%~fJ\jre\bin\java.exe" set "WRIMS_JAVA=%%~fJ\jre\bin\java.exe"
if not exist "%WRIMS_JAVA%" (
    echo ERROR: Bundled Java is missing. Use the complete WRIMS3 installation. 1>&2
    popd
    exit /b 1
)
if not exist "batchrun\WsiDiLaunchFileGroup.lfg" (
    echo ERROR: Missing batchrun\WsiDiLaunchFileGroup.lfg. 1>&2
    popd
    exit /b 2
)
findstr /L /C:"REPLACE_WITH_YOUR_MODEL_FOLDER" "batchrun\WsiDiLaunchFileGroup.lfg" >nul
if not errorlevel 1 (
    echo ERROR: Configure batchrun\WsiDiLaunchFileGroup.lfg before running. 1>&2
    popd
    exit /b 2
)
"%WRIMS_JAVA%" -Djava.library.path="lib" -cp "dropins\plugins\*;plugins\*;lib\*" gov.ca.water.wrims.gui.ide.batchrun.WsiDiBatchRunCmd -p "batchrun\WsiDiLaunchFileGroup.lfg"
set "WRIMS_EXIT=%errorlevel%"
popd
exit /b %WRIMS_EXIT%
