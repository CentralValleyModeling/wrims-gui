@echo off
cd ..

REM PROJECT SETTINGS: PROJECT_DIR, and LFG_FILE variables as needed.
set PROJECT_DIR=J:\wrims\projects\example_study
set LFG_FILE=example.lfg

REM Set the JAVA_HOME environment variable to the path of your java 21 JDK
set JAVA_HOME="jre"

set temp_wrims2=".\foo"

REM Add the required DLLs to the PATH. Do not change if this if run from the wrims-gui directory.
set PATH=%PATH%;lib

REM Add the external libraries to the PATH. Do not change.
set PATH=%PATH%;%PROJECT_DIR%\Run\External

REM Set the main class to run. This is the entry point for the WRIMS application. Do not change when running from wrims-gui.
set MAIN_CLASS=gov.ca.water.wrims.gui.ide.batchrun.BatchRunCmd
set LIB_JARS="lib\*"
set PLUGIN_JARS="plugins\*;batchrun\*"

%JAVA_HOME%\bin\java -Xmx4096m -Xss1024K -Djava.library.path="lib" -Dproject.dir="%PROJECT_DIR%" -cp "%LIB_JARS%;%PLUGIN_JARS%" %MAIN_CLASS% -p %PROJECT_DIR%\%LFG_FILE%

cd batchrun
pause