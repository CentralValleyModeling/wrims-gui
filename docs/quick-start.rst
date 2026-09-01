.. _quick-start:

WRIMS 3 GUI Quick Start
=======================

Purpose
-------

This Quick Start is intended for first-time WRIMS 3 GUI users. It provides
the shortest path from downloading WRIMS 3 GUI to loading and starting a
CalSim 3 study.

For detailed instructions on study configuration, debugging, analysis,
DSS review, and other workflows, use the main WRIMS 3 GUI documentation
after completing this Quick Start.


1. Download WRIMS 3 GUI
-----------------------

WRIMS 3 GUI distributions are available from the WRIMS GUI GitHub
Releases page:

`WRIMS GUI Releases
<https://github.com/CentralValleyModeling/wrims-gui/releases>`_

Download the latest WRIMS 3 Windows x64 application ZIP from the
**Assets** section of the release.

The application package follows a filename pattern such as:

``wrims_gui_x64_<version>.zip``

For example:

``wrims_gui_x64_3.0.0-beta.2.zip``

.. note::

   Download the WRIMS GUI application package from **Assets**. Do not use
   GitHub's automatically generated **Source code (zip)** or
   **Source code (tar.gz)** archives as the WRIMS GUI installation package.


2. Extract WRIMS 3 GUI
----------------------

Extract the downloaded WRIMS 3 GUI ZIP file to a local folder where you
have read and write access.

For example:

``C:\Users\<username>\wrims\``

This path is an example rather than a required WRIMS installation
location. Keep the WRIMS application files separate from the study
folders used for modeling work.


3. Start WRIMS 3 GUI
--------------------

Open the extracted WRIMS 3 installation folder and start WRIMS by
double-clicking:

``WRIMS3_GUI_Start.bat``

Wait for the WRIMS workspace to open.

If toolbar controls are cut off or do not display correctly, see
:ref:`GUI Scaling on High-DPI Windows Displays
<gui-scaling-high-dpi-windows>`.


4. Download a Study for the First WRIMS Session
------------------------------------------------

For this Quick Start, use the following Final DCR 2023 CalSim 3 study:

``9.3.1 danube adj``

The study is available from the California Department of Water Resources
Open Data Portal:

`Final DCR 2023 CalSim3 Models
<https://lab.data.ca.gov/dataset/final-dcr-2023-calsim3-models>`_

On the dataset page, locate **9.3.1 danube adj** and select **Download**.
The downloaded file is named ``9.3.1_danube_adj.zip``.


5. Choose a Location for the Study
----------------------------------

Before loading the study, move the downloaded study ZIP file to the local
directory where you want the extracted study folder to remain.

For example:

``C:\Users\<username>\wrims\studies\``

.. important::

   WRIMS extracts a study into a folder next to the selected ZIP file.
   Avoid loading the study directly from a temporary download location,
   such as the Windows Downloads folder, unless you intend to keep the
   extracted study there.


6. Load the Study
-----------------

Start WRIMS 3 GUI if it is not already open.

1. Select **File > Load Zip File**.
2. Browse to ``9.3.1_danube_adj.zip``.
3. Select the ZIP file and click **Open**.
4. Click **OK** when prompted.
5. Allow WRIMS to extract the study.
6. Check **Project Explorer**.

If the ZIP contains a ``.project`` file, WRIMS can import the extracted
study into the workspace. If the study is extracted but does not appear
in **Project Explorer**, see
:ref:`1.2 Basic New Study <12-basic-new-study>`.

For additional ZIP-loading details, see
:ref:`1.3 Basic Load Zip File <13-basic-load-zip-file>`.


7. Start the First Run
----------------------

After the study appears in **Project Explorer**, check whether the study
contains a ``.launch`` file.

If a usable launch file is already included:

1. Locate the ``.launch`` file in **Project Explorer**.
2. Right-click the launch file.
3. Select **Run As** and choose the available WRIMS launch configuration.
4. Verify that the run starts without an immediate configuration error.

If the study does not contain a usable launch configuration, see
:ref:`1.4 Basic Create Launch File <14-basic-create-launch-file>`.

If you need to duplicate and modify an existing launch configuration, see
:ref:`1.5 Basic Modify Launch File <15-basic-modify-launch-file>`.


8. Where to Go Next
-------------------

After completing the first study load and run, continue with the main
WRIMS 3 GUI documentation:

- :ref:`1. Getting Started <1-getting-started>` for study and launch
  configuration.
- :doc:`concepts` for GUI concepts and interface behavior.
- :doc:`wresl-editor` for WRESL source navigation.
- :doc:`debugging` for debugging workflows.
- :doc:`analysis` for analysis and diagnostics.
- :doc:`dss` for DSS review and results.
- :doc:`schematic-workflows` for schematic viewing and editing workflows.
- :doc:`troubleshooting` for common configuration and display problems.
