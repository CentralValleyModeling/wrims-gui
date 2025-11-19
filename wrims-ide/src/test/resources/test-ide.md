Feature: Test debugging a study
  As users of the wrims, we want to launch a regular run a CalSim study in debug mode so that we can debug the study

1. start WRIMS GUI by click "WRIMS2_GUI_Start.bat" under the root folder of WRIMS 2 GUI package
   
2. Import the study/project e.g. "C:\9.3.1_danube_adj_hist" if ""C:\9.3.1_danube_hist\.project" exists by click the menu of "File->Import..." and then select "General'" and then "Existing Projects into Workspace" in the dialog of "Import" and then select the root directory of the project
![ImportProject.png](TEST_images\ImportProject.png)
    Otherwise, create a new project with "C:\9.3.1_danube_hist" by clicking the menu of "File->New->Project", and then select "General Project" in the dialog of "New Project"; in the next page of the dialog, give a name of the project and then uncheck "Use default location" and select the root project folder as the location
![NewProject.png](TEST_images\NewProject.png)
    
3. Set timestamp of year 1923 and month 10 and date 31 and cycle 1 as breakpoint
![Breakpoint.png](TEST_images\Breakpoint.png)   
4. Right click "Project Explorer", in the popup menu, select "Debug As->Debug Configurations", and at the "Debug Configurations" dialog select the launch configuraiton e.g. "CS3_Hist_Dev" under the "WRESL/WRIMS2 Application"; and then click "Debug" button
![DebugConfigurations.png](TEST_images\DebugConfigurations.png)
	
5. When the study reach the breakpoint; click "next step" button; then click "next cycle" button on the "Console" view
![buttons.png](TEST_images\buttons.png)
6. Click the menu of "Run->Next step"; then click the menu of "Run->Next cycle" button

7. Open a wresl file on the WRESL Editor, e.g. "C:\9.3.1_danube_adj\Run\COA\coa.wresl"; then check the views of "Variables", "Goals", "All Variables", "All Goals"
![variables-goals.png](TEST_images\variables-goals.png)
8. Click the menu of "Data\Load Dss/Studies" and load a dv dss file, .e.g. "DCR2023_DV_9.3.1_Danube_Hist_v1.7.dss" and a sv dss file, e.g. "DCR2023_SV_Danube_Hist_v1.7.dss"
![LoadAltDssStudies.png](TEST_images\LoadAltDssStudies.png)
9. Click "all variables from DSS" button in this view of "All Variables" to see all the values of "All Variables" in both current run and the alternatives
    
10. Open the view of "All Goals" and click "Control Goals" button in this view to see all the control goals
![controlgoals.png](TEST_images\controlgoals.png)
11. Open the view of "Watch", add a variable, e.g. "s_shsta" to the watch list; and add a constraint, e.g. "coa_cvp3" to the watch list; and then delete this constraint from watch list
![watch.png](TEST_images\watch.png)
12. Hove over on a variable .e.g. "I_SHSTA" in the wresl file of "C:\9.3.1_danube_hist\Run\COA\coa.wresl"; and hove over on a constraint, e.g. "swp_storage_change" in the wresl file "C:\9.3.1_danube_hist\Run\COA\coa.wresl"
![hove-over.png](TEST_images\hove-over.png)
13. Click "Resume" button and then click "Pause" button on the "Console" View after 2 second
	
14. Click the "Terminate" button to terminate the debug run
![Terminate.png](TEST_images\Terminate.png)