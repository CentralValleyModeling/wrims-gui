@echo off
setlocal
set BASE_DIR=%~dp0
set EXE1=%BASE_DIR%eclipse.exe
set EXE2=%BASE_DIR%eclipse\eclipse.exe

if exist "%EXE1%" (
  set "ECLIPSE_EXE=%EXE1%"
) else if exist "%EXE2%" (
  set "ECLIPSE_EXE=%EXE2%"
)

if defined ECLIPSE_EXE (
  start "" "%ECLIPSE_EXE%" -clean -consoleLog
) else (
  echo Could not find Eclipse executable. Looked for:
  echo   %EXE1%
  echo   %EXE2%
  exit /b 1
)
