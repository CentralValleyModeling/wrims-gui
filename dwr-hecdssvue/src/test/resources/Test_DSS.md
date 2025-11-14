Feature: Test Dss operations
  As users of the wrims, we want to work in the DSS perspective so that we can perform DSS related operations
    
1. Open the DSS perspective, in the tab of "DSS Files Compare", for Alt 1", load a dv DSS file, e.g. "C:\9.3.1_danube_hist\DSS\output\DCR2023_DV_9.3.1_v2a_Danube_Adj_v1.8.dss" and a sv DSS file, e.g. "C:\9.3.1_danube_hist\DSS\input\DCR2023_SV_Danube_Adj_v1.8.dss" and select study type as "CalSim 3"
    ![LoadDssFile.png](TEST_images\LoadDssFile.png)
    
2. Search B part as "C_Orovl" and select the first timeseries in the searched resuls and give the unit "TAF" in the DSSOption view; then open "DSS Plot" View
    ![DSSPlot.png](TEST_images\DSSPlot.png)

3. On the "DSS Option" view, select plot type "Exceedence", "Annual Total", "Annual Exceedence", "Monthly Average", and "Model Data".
    ![DSSOption.png](TEST_images\DSSOption.png)
    
4. On the "DSS Option" view, select month "JAN", "APR", and "JUN", and select annual type "jan-dec", and then select timewindow "Oct 1928 - Sep 1934"; and then select "DSS Monthly" view.

5. For "Alt 2", load a dv DSS file, e.g.  "" and a sv dss file "" and select the study type as "CalSim 3"
	![DSSFilesCompare.png](TEST_images\DSSFilesCompare.png)
	In the "DSS Option" view, select mode "diff" and selct "DSS Plot" view

6. Selct "Storage Flow" view, select storage "Trinity", and then select flow "Red Bluff"
	![StoragesFlows.png](TEST_images\StoragesFlows.png)