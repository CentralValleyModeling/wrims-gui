Feature: Test schematics
  As users of WRIMS, we want to load and operate a schematic

1. Open the "Schematic" perspective.

2. Load a schematic by clicking the "Open" button and select a XML file, e.g. "C:\wrims_gui_x64_3.0.0\schematic\CS3_NetworkSchematic.xml".
![SchematicPerspective.png](TEST_images\SchematicPerspective.png "SchematicPerspective.png")
3. Use "Zoom to Rectangle" button zoom to a small domain to avoid two much DSS data is loaded on the schematic; move the focused area using the rectangle in the "Schematic Overview". 
![Zoom.png](TEST_images\Zoom.png)
4. Turn off "Zoom to Rectangle", and move the schematic around; click "Zoom In" and "Zoom Out" buttons
![buttons.png](TEST_images\buttons.png)

5. Open the "DSS" perspective; in the tab of "DSS Files Compare", for Alt 1", load a dv DSS file, e.g. "C:\9.3.1_danube_hist\DSS\output\DCR2023_DV_9.3.1_Danube_Hist_v1.7.dss" and a sv DSS file, e.g. "C:\9.3.1_danube_hist\DSS\input\DCR2023_SV_Danube_Hist_v1.7.dss" and select study type as "CalSim 3"; for "Alt 2", load a dv DSS file, e.g.  "Z:\9.3.1_danube_adj\DSS\output\DCR2023_DV_9.3.1_v2a_Danube_Adj_v1.8.dss" and a sv DSS file "Z:\9.3.1_danube_adj\DSS\input\DCR2023_SV_Danube_Adj_v1.8.dss" and select the study type as "CalSim 3"
![DSSFilesCompare.png](TEST_images\DSSFilesCompare.png)
6. Then switch back to the "Schematic" perspective. Select the time step e.g. Dec 1921 in the dropdown box, use arrow buttons to move forward and backward of timestep and see the value changes on the schematic.
![Timestep.png](TEST_images\Timestep.png)
7. Go back to the "DSS" perspective. Select "Diff", select months of "Nov", "Feb", and "Mar" and change units to "TAF" in the "DSS Options" view
![DssOptions.png](TEST_images\DssOptions.png)

8. Go back to the "Schematic" view, select time period of "Oct 1928 to Sep 1934".
![AverageTimePeriod.png](TEST_images\AverageTimePeriod.png)
