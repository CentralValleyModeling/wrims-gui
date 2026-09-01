.. _1-getting-started:

1. Getting Started
==================
.. note::

   If this is your first time using WRIMS 3 GUI, begin with the
   :doc:`WRIMS 3 GUI Quick Start <quick-start>`.

   The Quick Start explains where to obtain WRIMS 3 GUI, where to place
   the application and study files, where to obtain a first study, and
   how to complete an initial study load and run.

.. _11-basic-load-existing-study:

1.1 Basic Load Existing Study
-----------------------------


**Purpose**

This chapter explains how to import an existing study into the current **WRIMS 3 GUI** workspace.

**Before you start**

Before beginning, make sure that:

- **WRIMS 3 GUI** has been downloaded and extracted as described in the
  :doc:`WRIMS 3 GUI Quick Start <quick-start>`.
- You have access to an existing study folder that already contains a ``.project`` file.
- The study is not currently listed in **Project Explorer**.

**Procedure**


To launch **WRIMS 3 GUI**, open the WRIMS 3 installation folder and double-click ``WRIMS3_GUI_Start.bat``.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_720.png


If no study is listed in **Project Explorer**, import the existing study into the workspace before working with it.

For the distinction between an **existing study** and a **new study**, see :ref:`2.1 Existing Studies and New Studies <21-existing-studies-and-new-studies>`.

The following example shows an existing study folder that contains a ``.project`` file.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_2040.png


To import an existing study:

1. In **Project Explorer**, right-click and select **Import**.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3240.png


You can also open the **File** menu and select **Import**.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3360.png


2. In the **Import** dialog, expand **General**.
3. Select **Existing Project into Workspace**.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3480.png


4. Click **Next**.
5. Browse to the main folder of the study you want to import.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3960.png


6. Click **OK** to confirm the selected folder.
7. Verify that the project appears in the import list and is selected.
8. Click **Finish** to import the study into the workspace.

After the import is complete, the study appears in **Project Explorer** and is ready to use in **WRIMS 3 GUI**.

.. image:: diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_4200.png


**Notes**


- A study can only be imported as an **existing study** if its main folder contains a ``.project`` file.
- In **WRIMS 3 GUI**, each study is generally managed as a separate project in **Project Explorer**.
- If the expected project does not appear after import, verify that you selected the correct study folder.
- On some systems, a security scan prompt may appear when the GUI is launched for the first time. This depends on the local Windows and security configuration rather than on WRIMS itself.


**Related sections**


- :ref:`1.2 Basic New Study <12-basic-new-study>`
- :ref:`1.4 Basic Create Launch File <14-basic-create-launch-file>`
- :ref:`1.3 Basic Load Zip File <13-basic-load-zip-file>`


.. _12-basic-new-study:

1.2 Basic New Study
-------------------


**Purpose**

This chapter explains how to create a project entry in **WRIMS 3 GUI** for a study that has not been loaded before.

**Before you start**


- **WRIMS 3 GUI** is installed and can be launched.
- You have a new study (CALSIM3) folder that does **not** yet contain a ``.project`` file.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_600.png

For the distinction between an **existing study** and a **new study**, see :ref:`2.1 Existing Studies and New Studies <21-existing-studies-and-new-studies>`.

**Procedure**

To load a new study:

1. In **Project Explorer**, right-click and choose **New**.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_1560.png


You can also open **File > New Project**.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_1800.png


2. In the wizard, go to **General > Project**.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_2160.png


3. Click **Next**.
4. Enter a project name. For a CALSIM3 study, for example, you might enter ``cs3_2015``.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_2640.png


5. Clear the default location option.
6. Browse to the location of the study folder.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_2880.png


7. Click **OK**.
8. Click **Finish**.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_3240.png


The study is now loaded into **WRIMS 3 GUI**.

.. image:: diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_3960.png


**Notes**


- When the study is loaded, **WRIMS 3 GUI** creates a ``.project`` file in the study folder. 
- From that point forward, the study is treated as an **existing study** from the WRIMS 3 GUI perspective.


**Related sections**


- :ref:`1.1 Basic Load Existing Study <11-basic-load-existing-study>`
- :ref:`1.4 Basic Create Launch File <14-basic-create-launch-file>`
- :ref:`1.3 Basic Load Zip File <13-basic-load-zip-file>`


.. _13-basic-load-zip-file:

1.3 Basic Load Zip File
-----------------------


**Purpose**

This chapter shows how to load a study directly from a zip file.

**Before you start**


- You have a study packaged as a ``.zip`` file.
- **WRIMS 3 GUI** is open.

**Procedure**


Studies are often shared as zip files. **WRIMS 3 GUI** includes a function that can:

- unzip the file
- load the study directly into the workspace.

To do this:

1. Open **WRIMS 3 GUI**.
2. Open the **File** menu.
3. Choose **Load Zip File**.

.. image:: diagrams/frames/07_Basic_LoadZipFile/07_Basic_LoadZipFile_1320.png


4. Browse to the zip file.
5. Select the zip file.

.. image:: diagrams/frames/07_Basic_LoadZipFile/07_Basic_LoadZipFile_1920.png


6. Click **Open**.
7. Click **OK**.

WRIMS 3 GUI then:

- unzips the study;
- creates a folder next to the zip file;
- loads the study into the GUI.

If a launch file is included in the package, it is also available after the study is loaded.

.. image:: diagrams/frames/07_Basic_LoadZipFile/07_Basic_LoadZipFile_2520.png


**Notes**


- WRIMS extracts the study into a folder next to the selected ZIP file. Before using **Load Zip File**, place the ZIP file in the study working directory where you want the extracted study folder to remain.
- After extraction, verify that the expected study structure appears in **Project Explorer**.
- If there is no ``.project`` file in the ZIP file, the ZIP loader will extract the study but will not automatically import it into WRIMS 3 GUI.

** Troubleshooting **

If you receive an error when attempting to load a zip file, the contents may exceed the default maximum file size limit for zip extraction.

To resolve this:
Use the following -D flag to increase the maximum file size limit for zip extraction.
Append these flags to the command line call present in the `WRIMS3_GUI_Start.bat` script.

MAX_EXTRACTED_SIZE_KEY: `gov.ca.water.wrims.zip.max.size`
MAX_ENTRIES_KEY: `gov.ca.water.wrims.zip.max.entries`
MAX_ENTRY_SIZE_KEY: `gov.ca.water.wrims.zip.max.entry.size`

Both of the size limits are set in bytes, while the maximum entries limit is set in number of entries.

For example, to set the maximum file size limit to 10 GB, you can use the following flag:
`-Dgov.ca.water.wrims.zip.max.size=10737418240`



**Related sections**


- :ref:`1.1 Basic Load Existing Study <11-basic-load-existing-study>`
- :ref:`1.2 Basic New Study <12-basic-new-study>`
- :ref:`1.4 Basic Create Launch File <14-basic-create-launch-file>`


.. _14-basic-create-launch-file:

1.4 Basic Create Launch File
----------------------------


**Purpose**

This chapter explains how to create a launch configuration for running or debugging a study.

**Before you start**


- The study is already loaded in **Project Explorer**.
- You know the locations of the main WRESL file, DSS files, and any groundwater folder used by the study.
- You know the start date, end date, and whether the study is monthly or daily.

**Procedure**


A study may already contain multiple launch files. To create a new one, use either:

- **Debug As > Debug Configuration**
- **Run As > Run Configuration**

This chapter uses **Run Configuration**. For the role of a **launch file** and the distinction between **Run** and **Debug**, see :ref:`2.2 Launch Files and Run Modes <22-launch-files-and-run-modes>`.

1. Right-click the study and choose **Run As > Run Configuration**.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_840.png


2. In the configuration window, locate **WRESL/WRIMS2 Application**.
3. Right-click **WRESL/WRIMS2 Application** and choose **New**.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_3360.png


4. Enter a name for the launch file, such as ``testCalSim``.
5. Fill in the study information, including:
   - study name
   - author
   - date
   - description

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_4920.png


Enter a description that clearly identifies the launch configuration.

Next, browse to the main WRESL file.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_5400.png


6. Browse to the study folder.
7. Open the ``run`` folder.
8. Select the main WRESL file.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_5520.png


Then specify the DSS and related file paths:

9. Browse to the decision-variable DSS file, typically under ``run\DSS``, such as ``testDV.dss``.
10. Specify the SV DSS file, usually under ``common\DSS``.
11. Specify the initial DSS file.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_6720.png


12. If applicable, specify the groundwater folder.

In CalSim 3, for example, a groundwater folder may be located under a path such as ``CVgroundwater\data``.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_7680.png


The HEC-DSS fields are used as follows:

- The **Dvar DSS** file is the output;
- The **Svar DSS** file is an input;
- The **Initial DSS** file is also an input.

You must also provide **Part A** and **Part F** values for these DSS files.

These values are typically obtained from the pathname parts of the DSS records already used by the study. To find them, open the corresponding DV, SV, or Initial DSS file in DSSVue, inspect the pathname of the records used by the study, and copy the Part A and Part F values that match the existing naming convention.

- The three files may share the same **Part A**.
- The **Part F** values may be the same or different.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_9600.png


Then configure the time settings:

13. Choose whether the model is **monthly** or **daily**.
14. Set the starting and ending dates.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_10080.png


For a regular study that does not use position analysis or multi-study run, the main launch setup is complete at this point.

15. Click **Apply**.

**Save the launch file into the study**


After you click **Apply**, the launch file is created, but by default it may be saved in the WRIMS 3 package location.

To store the launch file with the study:

1. Change the storage option from **Local File** to **Shared File**.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_10920.png


2. Browse to the study folder.
3. Select the study folder.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_11760.png


4. Click **OK**.
5. Click **Apply** again.

The launch file is now saved inside the study.

**Use relative paths instead of absolute paths**


If the launch file uses absolute paths, another user may need to update all file references when the study is stored in a different location on a different computer.

To improve portability:

1. Replace absolute paths with relative paths.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_14520.png

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_15240.png


2. Make each path relative to the launch file location.
3. Click **Apply** again.

The main file, DV DSS file, SV file, initial file, and groundwater folder can all be converted to relative paths.

**Run or debug the launch file**


After the launch file is created, you can either:

- click **Run** directly from the configuration window;

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_15840.png


- or close the configuration window, right-click the launch file, and choose **Run As** or **Debug As**.

.. image:: diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_16200.png


**Notes**


- Use **Shared File** so the launch file is stored with the study instead of the WRIMS package area.
- Use relative paths whenever possible so the study is easier to move or share.
- **Run** and **Debug** use the same launch configuration, but **Debug** allows pausing and inspection.


**Related sections**


- :ref:`1.5 Basic Modify Launch File <15-basic-modify-launch-file>`
- :ref:`4.1 Debug Pause Variable Goal View <41-debug-pause-variable-goal-view>`
- :ref:`4.5 Debug Solver And Option <45-debug-solver-and-option>`


.. _15-basic-modify-launch-file:

1.5 Basic Modify Launch File
----------------------------


**Purpose**

This chapter explains how to create a new launch file by duplicating and modifying an existing one.

**Before you start**


- The study already contains at least one working launch file.
- You want a similar launch file with only a few fields changed.

**Procedure**


To create a new launch file from an existing one:

1. Open **Debug Configuration**.

.. image:: diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_960.png


2. Under **WRESL/WRIMS2 Application**, locate the existing launch file.
3. Right-click the existing launch file.
4. Choose **Duplicate**.

.. image:: diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_3360.png


5. Rename the duplicated launch file.
6. Click **Apply**.

.. image:: diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_4080.png


A new launch file is now available based on the existing configuration.

To update the decision-variable DSS file:

1. Browse to the decision-variable DSS file field.
2. Go to the study’s ``run\DSS`` folder.
3. Select a DSS file, such as ``testDV.dss``.
4. Click **Open**.

.. image:: diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_5280.png


If the path appears as an absolute path, convert it to a relative path.

5. Replace the absolute path with a relative path.

.. image:: diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_6000.png


6. Click **Apply**.


**Notes**


- Duplicating an existing launch file reduces setup effort and lowers the chance of configuration errors.
- After duplication, review file paths and convert absolute paths to relative paths if needed.


**Related sections**


- :ref:`1.4 Basic Create Launch File <14-basic-create-launch-file>`
- :ref:`4.1 Debug Pause Variable Goal View <41-debug-pause-variable-goal-view>`
- :ref:`4.5 Debug Solver And Option <45-debug-solver-and-option>`
