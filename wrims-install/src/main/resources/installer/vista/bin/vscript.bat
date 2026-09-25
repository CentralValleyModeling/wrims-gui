@echo off
setlocal DisableDelayedExpansion
for %%R in ("%~dp0..\..") do set "WRIMS_HOME=%%~fR"
set "WRIMS_JAVA=%WRIMS_HOME%\jre\bin\java.exe"
for /d %%J in ("%WRIMS_HOME%\plugins\*jre.full*") do if exist "%%~fJ\jre\bin\java.exe" set "WRIMS_JAVA=%%~fJ\jre\bin\java.exe"
if not exist "%WRIMS_JAVA%" (
    echo ERROR: Bundled Java is missing. 1>&2
    exit /b 1
)
if not exist "%WRIMS_HOME%\vista\lib\jython-standalone.jar" (
    echo ERROR: The WsiDi Jython runtime is missing. 1>&2
    exit /b 1
)
"%WRIMS_JAVA%" -Dpython.console.encoding=UTF-8 -Dpython.cachedir="%LOCALAPPDATA%\WRIMS\jython-cache" -Djava.library.path="%WRIMS_HOME%\lib" -cp "%WRIMS_HOME%\vista\lib\jython-standalone.jar;%WRIMS_HOME%\lib\*" org.python.util.jython %*
exit /b %errorlevel%
