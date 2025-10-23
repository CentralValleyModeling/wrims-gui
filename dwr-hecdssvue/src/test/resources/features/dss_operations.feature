Feature: Dss operations
  As a user of the wrims
  I want to work in the DSS perspective
  So that I can perform DSS related operations
    
  Scenario: Dss Operations    
  	Given WRIMS GUI is started and Dss perspective opens and the dv DSS file "C:\9.3.1_danube_adj\DSS\output\DCR2023_DV_9.3.1_v2a_Danube_Adj_v1.8.dss" and sv dss file "C:\9.3.1_danube_adj\DSS\input\DCR2023_SV_Danube_Adj_v1.8.dss" exists and the study type is "CalSim 3"
	When open the dv DSS file and sv DSS file and select the study type in Alt 1
	Given B part "C_Orovl"
	When search B part
	And select the first timeseries in the searched result
	Given the new unit "TAF"
	When select the new unit
	And select "DSS Plot" tab
	Given plot type "Exceedence"
	When plot this type
	Given plot type "Annual Total"
	When plot this type
	Given plot type "Annual Exceedence"
	When plot this type
	Given plot type "Monthly Average"
	When plot this type
	Given plot type "Model Data"
	When plot this type
	Given selected month "JAN", "APR", and "JUN"
	When select those months
	Given timewindow "Oct 1928 - Sep 1934"
	When select the timewindow
	And select "DSS Monthly" tab
	Given annual type "jan-dec"
	When select this annual type
	Given the dv DSS file "C:\08.11_DCR23_BL_CC_Hydroforecast_20230830\DSS\output\2023DCR_Hist_DV.dss" and sv dss file "C:\08.11_DCR23_BL_CC_Hydroforecast_20230830\DSS\input\L2020A_Hist_041023_WestSideMod_SV.dss" exists and the study type is "CalSim 3"
	When open the dv DSS file and sv DSS file and select the study type in Alt 2
	Given mode "diff"
	When select this mode
	And selct "DSS Plot" tab
	And selct "Storage Flow" tab
	Given storage "Trinity" 
	When select this storage
	Given flow "Red Bluff"
	When select this flow 

	

