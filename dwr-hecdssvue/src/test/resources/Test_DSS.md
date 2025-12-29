Feature: Test DSS operations
  As users of WRIMS, we want to work in the DSS perspective so that we can perform DSS related operations
    
1. Open the DSS perspective, in the tab of "DSS Files Compare", for Alt 1", load a dv DSS file, e.g. "C:\9.3.1_danube_hist\DSS\output\DCR2023_DV_9.3.1_Danube_Hist_v1.7.dss" and a sv DSS file, e.g. "C:\9.3.1_danube_hist\DSS\input\DCR2023_SV_Danube_Hist_v1.7.dss" and select study type as "CS3"
    ![LoadDssFile.png](TEST_images\LoadDssFile.png "LoadDssFile.png")
    
2. Search B part as "C_Orovl" and select the first timeseries in the searched results and give the unit "TAF" in the "DSS Options" view; then open "DSS Plot" View. The following figure shows the results from the operation.
    ![DSSPlot.png](TEST_images\DSSPlot.png)

3. On the "DSS Options" view, select plot type "Exceedence", "Annual Total", "Annual Exceedence", "Monthly Average", and "Model Data".
    ![DSSOption.png](TEST_images\DSSOption.png)

    Below are the different type of plots from the operations respectively:
![Exceedence.png](TEST_images\Exceedence.png)
![AnnualTotal.png](TEST_images\AnnualTotal.png)
![AnnualExceedence.png](TEST_images\AnnualExceedence.png)
![MonthlyAverage.png](TEST_images\MonthlyAverage.png)

5. On the "DSS Option" view, select month "JAN", "APR", and "JUN", and select annual type "jan-dec", and then select time window "Oct 1928 - Sep 1934"; and then select "DSS Monthly" view and repeat the operations to show different types of plots in Step 4.

6. For "Alt 2", load a dv DSS file, e.g.  "Z:\9.3.1_danube_adj\DSS\output\DCR2023_DV_9.3.1_v2a_Danube_Adj_v1.8.dss" and a sv dss file "Z:\9.3.1_danube_adj\DSS\input\DCR2023_SV_Danube_Adj_v1.8.dss" and select the study type as "CS3"
	![DSSFilesCompare.png](TEST_images\DSSFilesCompare.png)
	In the "DSS Options" view, select mode "comp", select "Model Data" and select "DSS Plot" and "DSS Table" view. The result should be like the following:
![comp.png](TEST_images\comp.png)

   In the "DSS Options" view, select mode "diff" and select "DSS Plot" and "DSS Table" view. The result should be like the following:
![diff.png](TEST_images\diff.png)

8. Select "Storage Flow" view, select flow "Trinity River", the plots and tables are the same as the ones in Step 7.
	![StoragesFlows.png](TEST_images\StoragesFlows.png)
