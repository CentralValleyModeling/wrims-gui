# WRIMS 2 GUI Use Guide

## Overview

This guide provides user documentation for **WRIMS 2 GUI**. It covers the core tasks and interface features required to load and configure studies, navigate the workspace, inspect model structure, debug model behavior, run advanced execution workflows, and review DSS-based results.

The guide is organized to support both task-based use and general reference. Conceptual sections explain key interface elements, configuration behavior, and model-navigation features, while procedural sections provide step-by-step instructions for common workflows.

This document is intended to support both first-time users and experienced study developers. It may be used as:

- an onboarding guide for common **WRIMS 2 GUI** tasks;
- a reference for interface behavior, launch configuration, and model navigation;
- a procedural guide for debugging, analysis, cleanup, advanced execution, and DSS review.

## Intended audience

This guide is intended for:

- **New users** who need a clear starting point for loading studies, creating launch files, and understanding the **WRIMS 2 GUI** workspace;
- **Study developers and analysts** who need to run, inspect, compare, and troubleshoot WRIMS studies; and
- **Advanced users** who need batch execution, multi-study workflows, position analysis, and DSS-based result review.

## Table of contents

- [1. Getting Started](#1-getting-started)
  - [01. Basic Load Existing Study](#01-basic-load-existing-study)
  - [02. Basic New Study](#02-basic-new-study)
  - [07. Basic Load Zip File](#07-basic-load-zip-file)
  - [03. Basic Create Launch File](#03-basic-create-launch-file)
  - [04. Basic Modify Launch File](#04-basic-modify-launch-file)
- [2. Concepts and Interface](#2-concepts-and-interface)
  - [Existing Studies and New Studies](#existing-studies-and-new-studies)
  - [Launch Files and Run Modes](#launch-files-and-run-modes)
  - [Variable and Goal Views](#variable-and-goal-views)
  - [Controlling Goals and Goal Tolerance](#controlling-goals-and-goal-tolerance)
  - [05. Basic Perspectives](#05-basic-perspectives)
  - [08. Basic Outline](#08-basic-outline)
- [3. Model Structure and Source Navigation](#3-model-structure-and-source-navigation)
  - [06. Basic WRESL Plus](#06-basic-wresl-plus)
  - [17. Debug Find Reference](#17-debug-find-reference)
  - [20. Debug Study Cycle WRESL](#20-debug-study-cycle-wresl)
- [4. Core Debugging Workflow](#4-core-debugging-workflow)
  - [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
  - [10. Debug Variable Monitor](#10-debug-variable-monitor)
  - [11. Debug Variable Detail](#11-debug-variable-detail)
  - [12. Debug Watch Variables Goals](#12-debug-watch-variables-goals)
  - [14. Debug Solver And Option](#14-debug-solver-and-option)
  - [15. Debug Error Source Code Link](#15-debug-error-source-code-link)
  - [16. Debug Conditional Breakpoint](#16-debug-conditional-breakpoint)
- [5. Analysis and Diagnostics](#5-analysis-and-diagnostics)
  - [13. Debug Compare Existing Studies](#13-debug-compare-existing-studies)
  - [21. Debug Filter Goals](#21-debug-filter-goals)
  - [22. Debug Force Variable Resimulation](#22-debug-force-variable-resimulation)
- [6. Study Cleanup and Packaging](#6-study-cleanup-and-packaging)
  - [18. Debug Clean SV DSS File](#18-debug-clean-sv-dss-file)
  - [19. Debug Clean Study](#19-debug-clean-study)
- [7. Advanced Execution](#7-advanced-execution)
  - [23. Advanced Batch Run GUI](#23-advanced-batch-run-gui)
  - [24. Advanced Batch Run Cmd](#24-advanced-batch-run-cmd)
  - [25. Advanced Multi Study Run](#25-advanced-multi-study-run)
  - [26. Advanced Position Analysis](#26-advanced-position-analysis)
- [8. DSS Review and Results](#8-dss-review-and-results)
  - [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

# 1. Getting Started

## 01. Basic Load Existing Study

### Purpose
This chapter explains how to import an existing study into the current **WRIMS 2 GUI** workspace.

### Before you start
Before beginning, make sure that:

- **WRIMS 2 GUI** is installed and can be launched from the `WRIMS2_GUI_x64` package.
- You have access to a study folder that already contains a `.project` file.
- The study is not currently listed in **Project Explorer**.

### Procedure

To launch **WRIMS 2 GUI**, open the `WRIMS2_GUI_x64` package folder and double-click `WRIMS2_GUI_x64`.

![WRIMS 2 GUI startup screen](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_720.png)

If no study is listed in **Project Explorer**, import the study into the workspace before working with it.

For the distinction between an **existing study** and a **new study**, see [Existing Studies and New Studies](#existing-studies-and-new-studies).

The following example shows a study folder that contains a `.project` file.

![Example study folder containing a .project file](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_2040.png)

To import an existing study:

1. In **Project Explorer**, right-click and select **Import**.

![Import command from Project Explorer](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3240.png)

You can also open the **File** menu and select **Import**.

![Import command from the File menu](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3360.png)

2. In the **Import** dialog, expand **General**.
3. Select **Existing Project into Workspace**.

![Existing Project into Workspace option](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3480.png)

4. Click **Next**.
5. Browse to the main folder of the study you want to import.

![Browse to the study folder](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_3960.png)

6. Click **OK** to confirm the selected folder.
7. Verify that the project appears in the import list and is selected.
8. Click **Finish** to import the study into the workspace.

After the import is complete, the study appears in **Project Explorer** and is ready to use in **WRIMS 2 GUI**.

![Imported study displayed in Project Explorer](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_4200.png)

---

### Notes

- A study can only be imported as an **existing study** if its main folder contains a `.project` file.
- In **WRIMS 2 GUI**, each study is generally managed as a separate project in **Project Explorer**.
- If the expected project does not appear after import, verify that you selected the correct study folder.

---

### Related sections

- [02. Basic New Study](#02-basic-new-study)
- [03. Basic Create Launch File](#03-basic-create-launch-file)
- [07. Basic Load Zip File](#07-basic-load-zip-file)

---

## 02. Basic New Study

### Purpose
This chapter explains how to create a project entry in **WRIMS 2 GUI** for a study that has not been loaded before.

### Before you start

- **WRIMS 2 GUI** is installed and can be launched.
- You have a study folder that does **not** yet contain a `.project` file.

### Procedure

For the distinction between an **existing study** and a **new study**, see [Existing Studies and New Studies](#existing-studies-and-new-studies).

In practice:

- A DCR study that already contains a `.project` file is treated as an existing study.
- A CALSIM3 study without a `.project` file is treated as a new study.

![New study versus existing study context](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_600.png)

To load a new study:

1. In **Project Explorer**, right-click and choose **New**.

![New command from Project Explorer](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_1560.png)

You can also open **File > New Project**.

![New Project command from File menu](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_1800.png)

2. In the wizard, go to **General > Project**.

![Project wizard under General](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_2160.png)

3. Click **Next**.
4. Enter a project name. For a CALSIM3 study, for example, you might enter `cs3_2015`.

![Project name field](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_2640.png)

5. Clear the default location option.
6. Browse to the location of the study folder.

![Browse to the study folder](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_2880.png)

7. Click **OK**.
8. Click **Finish**.

![Finish creating the project](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_3240.png)

The study is now loaded into **WRIMS 2 GUI**.

![Study loaded into WRIMS 2 GUI](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_3960.png)

When the study is loaded, **WRIMS 2 GUI** creates a `.project` file in the study folder. From that point forward, the study is treated as an **existing study** from the WRIMS 2 GUI perspective.


---

### Notes

- A study without a `.project` file is treated as a **new study**.
- After it has been loaded once, that same study is treated as an **existing study** by the GUI.

---

### Related sections

- [01. Basic Load Existing Study](#01-basic-load-existing-study)
- [03. Basic Create Launch File](#03-basic-create-launch-file)
- [07. Basic Load Zip File](#07-basic-load-zip-file)

---

## 07. Basic Load Zip File

### Purpose
This chapter shows how to load a study directly from a zip file.

### Before you start

- You have a study packaged as a `.zip` file.
- **WRIMS 2 GUI** is open.

### Procedure

Studies are often shared as zip files. **WRIMS 2 GUI** includes a function that can:

- unzip the file
- load the study directly into the workspace.

To do this:

1. Open **WRIMS 2 GUI**.
2. Open the **File** menu.
3. Choose **Load Zip File**.

![Load Zip File command](diagrams/frames/07_Basic_LoadZipFile/07_Basic_LoadZipFile_1320.png)

4. Browse to the zip file.
5. Select the zip file.

![Select the zip file](diagrams/frames/07_Basic_LoadZipFile/07_Basic_LoadZipFile_1920.png)

6. Click **Open**.
7. Click **OK**.

WRIMS 2 GUI then:

- unzips the study;
- creates a folder next to the zip file;
- loads the study into the GUI.

If a launch file is included in the package, it is also available after the study is loaded.

![Loaded study from zip file](diagrams/frames/07_Basic_LoadZipFile/07_Basic_LoadZipFile_2520.png)

---

### Notes

- Confirm where the zip file will be extracted before finishing the load operation.
- After extraction, verify that the expected study structure appears in **Project Explorer**.

---

### Related sections

- [01. Basic Load Existing Study](#01-basic-load-existing-study)
- [02. Basic New Study](#02-basic-new-study)
- [03. Basic Create Launch File](#03-basic-create-launch-file)

---

## 03. Basic Create Launch File

### Purpose
This chapter explains how to create a launch configuration for running or debugging a study.

### Before you start

- The study is already loaded in **Project Explorer**.
- You know the locations of the main WRESL file, DSS files, and any groundwater folder used by the study.
- You know the start date, end date, and whether the study is monthly or daily.

### Procedure

For the role of a **launch file** and the distinction between **Run** and **Debug**, see [Launch Files and Run Modes](#launch-files-and-run-modes).

A study may already contain multiple launch files. To create a new one, use either:

- **Debug As > Debug Configuration**
- **Run As > Run Configuration**

This chapter uses **Run Configuration**.

1. Right-click the study and choose **Run As > Run Configuration**.

![Open Run Configuration](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_840.png)

2. In the configuration window, locate **WRESL/WRIMS2 Application**.
3. Right-click **WRESL/WRIMS2 Application** and choose **New**.

![Create a new WRESL/WRIMS2 launch configuration](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_3360.png)

4. Enter a name for the launch file, such as `testCalSim`.
5. Fill in the study information, including:
   - study name
   - author
   - date
   - description

![Launch file metadata fields](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_4920.png)

Enter a description that clearly identifies the launch configuration.

Next, browse to the main WRESL file.

![Browse to the main WRESL file](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_5400.png)

6. Browse to the study folder.
7. Open the `run` folder.
8. Select the main WRESL file.

![Select the main WRESL file](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_5520.png)

Then specify the DSS and related file paths:

9. Browse to the decision-variable DSS file, typically under `run\DSS`, such as `testDV.dss`.
10. Specify the SV DSS file, usually under `common\DSS`.
11. Specify the initial DSS file.

![Specify DSS input and output files](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_6720.png)

12. If applicable, specify the groundwater folder.

In CalSim 3, for example, a groundwater folder may be located under a path such as `CVgroundwater\data`.

![Specify groundwater folder if used](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_7680.png)

The HEC-DSS fields are used as follows:

- The **DVar DSS** file is the output;
- The **SVar DSS** file is an input;
- The **Initial DSS** file is also an input.

You must also provide **Part A** and **Part F** values for these DSS files.

- The three files may share the same **Part A**.
- The **Part F** values may be the same or different.

![HEC-DSS Part A and Part F fields](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_9600.png)

Then configure the time settings:

13. Choose whether the model is **monthly** or **daily**.
14. Set the starting and ending dates.

![Set model frequency and dates](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_10080.png)

For a regular study that does not use position analysis or multi-study run, the main launch setup is complete at this point.

15. Click **Apply**.

### Save the launch file into the study

After you click **Apply**, the launch file is created, but by default it may be saved in the WRIMS 2 package location.

To store the launch file with the study:

1. Change the storage option from **Local File** to **Shared File**.

![Switch from Local File to Shared File](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_10920.png)

2. Browse to the study folder.
3. Select the study folder.

![Select the study folder for shared storage](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_11760.png)

4. Click **OK**.
5. Click **Apply** again.

The launch file is now saved inside the study.

### Use relative paths instead of absolute paths

Relative paths are preferred.

If the launch file uses absolute paths, another user may need to update all file references when the study is stored in a different location on a different computer.

To improve portability:

1. Replace absolute paths with relative paths.

![Absolute path example](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_14520.png)
![Relative path example](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_15240.png)

2. Make each path relative to the launch file location.
3. Click **Apply** again.

The main file, DV DSS file, SV file, initial file, and groundwater folder can all be converted to relative paths.

### Run or debug the launch file

After the launch file is created, you can either:

- click **Run** directly from the configuration window;

![Run from the configuration window](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_15840.png)

- or close the configuration window, right-click the launch file, and choose **Run As** or **Debug As**.

![Run or Debug from the launch file](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_16200.png)

---

### Notes

- Use **Shared File** so the launch file is stored with the study instead of the WRIMS package area.
- Use relative paths whenever possible so the study is easier to move or share.
- **Run** and **Debug** use the same launch configuration, but **Debug** allows pausing and inspection.

---

### Related sections

- [04. Basic Modify Launch File](#04-basic-modify-launch-file)
- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [14. Debug Solver And Option](#14-debug-solver-and-option)

---

## 04. Basic Modify Launch File

### Purpose
This chapter explains how to create a new launch file by duplicating and modifying an existing one.

### Before you start

- The study already contains at least one working launch file.
- You want a similar launch file with only a few fields changed.

### Procedure

A new launch file can also be created by modifying an existing one.

As described in the previous chapter, you can open launch settings from either:

- **Debug As > Debug Configuration**
- **Run As > Run Configuration**


The earlier workflow created a launch file from scratch. This workflow creates a launch file by duplicating an existing one.

To create a new launch file from an existing one:

1. Open **Debug Configuration**.

![Open Debug Configuration](diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_960.png)

2. Under **WRESL/WRIMS2 Application**, locate the existing launch file.
3. Right-click the existing launch file.
4. Choose **Duplicate**.

![Duplicate an existing launch file](diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_3360.png)

5. Rename the duplicated launch file.
6. Click **Apply**.

![Rename and apply the duplicated launch file](diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_4080.png)

A new launch file is now available based on the existing configuration.

To update the decision-variable DSS file:

1. Browse to the decision-variable DSS file field.
2. Go to the study’s `run\DSS` folder.
3. Select a DSS file, such as `testDV.dss`.
4. Click **Open**.

![Select a new DSS file](diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_5280.png)

If the path appears as an absolute path, convert it to a relative path.

5. Replace the absolute path with a relative path.

![Convert absolute path to relative path](diagrams/frames/04_Basic_ModifyLaunchFile/04_Basic_ModifyLaunchFile_6000.png)

6. Click **Apply**.

### Run vs Debug

For the distinction between **Run** and **Debug**, see [Launch Files and Run Modes](#launch-files-and-run-modes).

Selecting **Debug** starts the model in **Debug** mode.

Once the model is running, you can pause it during a cycle and inspect variable values from the file currently open in the editor.

---

### Notes

- Duplicating an existing launch file reduces setup effort and lowers the chance of configuration errors.
- After duplication, review file paths and convert absolute paths to relative paths if needed.

---

### Related sections

- [03. Basic Create Launch File](#03-basic-create-launch-file)
- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [14. Debug Solver And Option](#14-debug-solver-and-option)

---

# 2. Concepts and Interface

## Existing Studies and New Studies

In **WRIMS 2 GUI**, a study is typically represented as a project in **Project Explorer**.

- An **existing study** is a study folder that has already been imported into WRIMS 2 and contains a `.project` file in its main folder.
- A **new study** is a study folder that has not yet been imported into WRIMS 2 GUI and therefore does not contain a `.project` file.

In practice, a study without a `.project` file is treated as a new study. After it has been loaded once, WRIMS 2 GUI creates a `.project` file and the study is then treated as an existing study from the GUI perspective.

The examples below illustrate the distinction.

![Example study folder containing a .project file](diagrams/frames/01_Basic_LoadExistingStudy/01_Basic_LoadExistingStudy_2040.png)

![New study versus existing study context](diagrams/frames/02_Basic_NewStudy/02_Basic_NewStudy_600.png)


---

## Launch Files and Run Modes

A **launch file** stores the configuration used to run or debug a study. The same launch configuration can be used in either **Run** mode or **Debug** mode.

- **Run** executes the study continuously at normal speed.
- **Debug** allows the study to be paused so that variables, goals, and model behavior can be inspected during execution.

For portability, launch files are easier to manage when they are saved with the study as a **Shared File** and when referenced files use relative paths instead of absolute paths.

The following images show the launch-configuration context and the storage and path choices that matter most.

![Create a new WRESL/WRIMS2 launch configuration](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_3360.png)

![Switch from Local File to Shared File](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_10920.png)

![Absolute path example](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_14520.png)

![Relative path example](diagrams/frames/03_Basic_CreateLaunchFile/03_Basic_CreateLaunchFile_15240.png)


---

## Variable and Goal Views

When a study is paused in **Debug** mode, WRIMS 2 GUI provides both file-specific views and model-wide views.

- **Variables** and **Goal View** depend on the file currently open in the editor.
- **All Variables** and **All Goals** show the full model at the current time step and cycle.

This distinction is important when interpreting paused results, because a file can be open in the editor even when it is not active in the current cycle.

The following images illustrate the main views used during paused inspection.

![Variables panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_6600.png)

![Goal View panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_7440.png)

![All Variables panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_8400.png)

![All Goals panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_8760.png)

---

## Controlling Goals and Goal Tolerance

In the **Goal View** panel, a goal is marked as controlling when the left-hand side is equal to the right-hand side. A filtering file provides another way to evaluate controlling goals by allowing optional tolerances.

- If no tolerance is provided, the goal is treated as controlling only when both sides are exactly equal.
- If a tolerance is provided, the goal can still be treated as controlling when the difference is within the specified tolerance.

This concept is used later in the goal-filter workflow.

The images below show both the visual controlling-goal indicator and the filtering-file approach.

![Controlling goal indicator](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_7680.png)

![Filtering file concept](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_1680.png)

![Sample goal filter file](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_1800.png)

---


## 05. Basic Perspectives

### Purpose
This chapter introduces the different perspectives available in **WRIMS 2 GUI**.

### Before you start

- **WRIMS 2 GUI** is open.
- You want to understand which perspective to use for editing, debugging, plotting, or DSS analysis.

### Procedure

**WRIMS 2 GUI** includes several perspectives. A **perspective** is a task-oriented arrangement of views and tools designed for a particular type of work.

The perspectives shown in this chapter include:

- **IDE Perspective**
- **DSS Perspective**
- **Schematic**
- **Schematic Editor**
- **CalSim Hydro**
- **Database Development**

![Available perspectives in WRIMS 2 GUI](diagrams/frames/05_Basic_Perspectives/05_Basic_Perspectives_1680.png)

### IDE Perspective

Use the **IDE Perspective** to:

- edit WRESL code;
- debug the model;
- run the model;
- launch the study;
- view runtime data during execution.

### DSS Perspective

Use the **DSS Perspective** to display DSS data.

Because one of the outputs of WRIMS 2 is **HEC-DSS**, this perspective is used to visualize DSS time series in:

- tables
- charts

![DSS Perspective](diagrams/frames/05_Basic_Perspectives/05_Basic_Perspectives_1920.png)

### Schematic

Use the **Schematic** perspective to display schematic diagrams and related data.

![Schematic perspective](diagrams/frames/05_Basic_Perspectives/05_Basic_Perspectives_2640.png)

### Schematic Editor

Use the **Schematic Editor** perspective to edit the schematic.

![Schematic Editor perspective](diagrams/frames/05_Basic_Perspectives/05_Basic_Perspectives_3000.png)

### CalSim Hydro

In the **CalSim Hydro** perspective, a default CalSim Hydro study is included with the package so that users can work with CalSim Hydro directly from the GUI.

![CalSim Hydro perspective](diagrams/frames/05_Basic_Perspectives/05_Basic_Perspectives_3240.png)

### Database Development

Use the **Database Development** perspective to connect to databases such as:

- SQL Server
- MySQL

![Database Development perspective](diagrams/frames/05_Basic_Perspectives/05_Basic_Perspectives_3720.png)

This perspective is used to:

- visualize data;
- manage data;
- connect to databases;
- work with outputs written to a SQL database.

---

### Notes

- A perspective is a task-oriented arrangement of views and tools.
- The **IDE Perspective** is mainly used for code editing, running, and debugging.
- The **DSS Perspective** is mainly used for time-series inspection and comparison.

---

### Related sections

- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)
- [13. Debug Compare Existing Studies](#13-debug-compare-existing-studies)
- [23. Advanced Batch Run GUI](#23-advanced-batch-run-gui)

---

## 08. Basic Outline

### Purpose
This chapter explains the **Outline** panel.

### Before you start

- A WRESL file is open in the editor.

### Procedure

The **Outline** panel lists all variables and goals in the WRESL file currently open in the editor.

![Outline panel](diagrams/frames/08_Basic_Outline/08_Basic_Outline_960.png)

When a file is open, the **Outline** panel can show:

- decision variables;
- state variables;
- aliases;
- goals.

The symbols mean:

- **D** = decision variable
- **S** = state variable
- **A** = alias
- **G** = goal

Selecting an item in the **Outline** panel moves the editor to the definition of that variable, alias, or goal.

This allows you to navigate directly to:

- a selected goal;
- an alias definition.

![Navigate from Outline to code location](diagrams/frames/08_Basic_Outline/08_Basic_Outline_1320.png)

If you open another file, the **Outline** panel updates automatically to match the file currently open in the editor.

![Outline panel updates with the active file](diagrams/frames/08_Basic_Outline/08_Basic_Outline_2160.png)

---

### Notes

- The **Outline** panel is especially useful when a WRESL file is too long to navigate efficiently by scrolling.

---

### Related sections

- [06. Basic WRESL Plus](#06-basic-wresl-plus)
- [17. Debug Find Reference](#17-debug-find-reference)
- [20. Debug Study Cycle WRESL](#20-debug-study-cycle-wresl)

---

# 3. Model Structure and Source Navigation

## 06. Basic WRESL Plus

### Purpose
This chapter shows how to turn **WRESL Plus** on or off.

### Before you start

- A WRESL file is open in the editor.

### Procedure

Some models use **WRESL**, while others use **WRESL Plus**, which supports extended language features.

To turn the feature on or off:

1. Open the launch configuration using either **Run Configuration** or **Debug Configuration**.

![Open launch configuration](diagrams/frames/06_Basic_WRESLPlus/06_Basic_WRESLPlus_960.png)

2. Select the launch file.
3. Open the **Configuration** tab.

![Configuration tab](diagrams/frames/06_Basic_WRESLPlus/06_Basic_WRESLPlus_1560.png)

4. Locate the **WRESL Plus** option.
5. Turn it on or off as needed.

![WRESL Plus option](diagrams/frames/06_Basic_WRESLPlus/06_Basic_WRESLPlus_2160.png)

6. Click **Apply**.

If the model was written in **WRESL Plus**, this option must be enabled so that WRIMS 2 GUI can parse the model correctly.

This behavior can also be confirmed in **Debug** mode:

- open the launch file in **Debug Configuration**;
- confirm that **WRESL Plus** is enabled;
- start the model in **Debug** mode;
- check the console for the message **WRESL Plus parsing completed**.

![WRESL Plus parsing message in the console](diagrams/frames/06_Basic_WRESLPlus/06_Basic_WRESLPlus_4800.png)

If the model uses regular WRESL instead, the console shows **WRESL parsing completed**.

At the end of the run, terminating the study saves the results to DSS and ends execution.

---

### Notes

- This setting affects model parsing behavior in the editor and launch configuration.
- Use **WRESL Plus** only when the model requires the extended language features.

---

### Related sections

- [08. Basic Outline](#08-basic-outline)
- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [17. Debug Find Reference](#17-debug-find-reference)

---

## 17. Debug Find Reference

### Purpose
This chapter explains how to use **Find Reference** in the WRESL editor.

### Before you start

- A WRESL file is open in the editor.

### Procedure

In the WRESL editor, point to a variable, right-click it, and choose **Find Reference**.

![Find Reference command](diagrams/frames/17_Debug_FindReference/17_Debug_FindReference_840.png)

WRIMS 2 GUI then lists all locations where that exact variable is used.

The example shown here uses a variable such as `s_shsta`.

![Find Reference results example](diagrams/frames/17_Debug_FindReference/17_Debug_FindReference_1680.png)

The results list:

- the files where the variable is used;
- the lines where it appears.

Selecting a result opens the file and highlights the variable occurrence.

### Find Reference vs Search

**Find Reference** and regular **Search** behave differently:

- **Find Reference** matches the exact variable name only.
- **Search** may return partial matches such as variables that contain the same text, for example:
  - `s_shsta`
  - `s_shsta_1`
  - `s_shsta2`

Use **Find Reference** when precision is required.

---

### Notes

- This feature is useful when tracing model logic before editing or debugging a variable.

---

### Related sections

- [06. Basic WRESL Plus](#06-basic-wresl-plus)
- [08. Basic Outline](#08-basic-outline)
- [15. Debug Error Source Code Link](#15-debug-error-source-code-link)

---

## 20. Debug Study Cycle WRESL

### Purpose
This chapter explains how to display the WRESL files used by the study as a whole or by a selected cycle.

### Before you start

- A study is loaded.
- You want to know which WRESL files are included globally or for a specific cycle.

### Procedure

Start from the **main WRESL file**.

When you right-click the main file, two options are available:

- **Study WRESL**
- **Cycle WRESL**

![Study WRESL and Cycle WRESL options](diagrams/frames/20_Debug_StudyCycleWRESL/20_Debug_StudyCycleWRESL_960.png)

### Study WRESL

If you choose **Study WRESL**, WRIMS 2 GUI parses the main file and determines all WRESL files used by the study.

The results are displayed in the **WRESL Included** panel.

![WRESL Included panel for Study WRESL](diagrams/frames/20_Debug_StudyCycleWRESL/20_Debug_StudyCycleWRESL_3120.png)

The included list may contain folders such as:

- `misc`
- `yuba`
- `sacramento`
- `trinity`

If multiple main files exist in the study, only the one actually used by the study is included.

Selecting a file in the **WRESL Included** panel opens it in the editor.

![Open included WRESL file from the panel](diagrams/frames/20_Debug_StudyCycleWRESL/20_Debug_StudyCycleWRESL_3480.png)

### Cycle WRESL

If you choose **Cycle WRESL**, WRIMS 2 GUI prompts you to select the cycle to inspect.

![Select cycle for Cycle WRESL](diagrams/frames/20_Debug_StudyCycleWRESL/20_Debug_StudyCycleWRESL_4320.png)

After you select a cycle, WRIMS 2 GUI parses the study and determines only the WRESL files used in that cycle.

The results again appear in the **WRESL Included** panel, but this time only the files active in the selected cycle are shown.

![WRESL Included panel for Cycle WRESL](diagrams/frames/20_Debug_StudyCycleWRESL/20_Debug_StudyCycleWRESL_6720.png)

---

### Notes

- **Study WRESL** shows the full included set.
- **Cycle WRESL** narrows the list to files active in the selected cycle.

---

### Related sections

- [08. Basic Outline](#08-basic-outline)
- [15. Debug Error Source Code Link](#15-debug-error-source-code-link)
- [21. Debug Filter Goals](#21-debug-filter-goals)

---

# 4. Core Debugging Workflow

## 09. Debug Pause Variable Goal View

### Purpose
This chapter shows how to debug a study, pause the model during execution, and inspect variables and goals.

### Before you start

- A study can be started in **Debug** mode.
- You know where to set or use a breakpoint, or you are prepared to pause manually.

### Procedure

Start the model in **Debug** mode by right-clicking a launch file and selecting **Debug As**.

![Start a study in Debug mode](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_360.png)

Once the model is running, one of the primary debugging functions is the ability to pause the model during execution and inspect the run state before completion.

### Pause the model

You can pause the model in either of the following ways:

- open the **Run** menu and click **Pause**

![Pause from the Run menu](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_1320.png)
- click the **Pause** button on the toolbar

![Pause from the toolbar](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_1560.png)

### Pause at a selected month, year, and cycle

You can also configure the run to pause at a selected time step and cycle.

Select the target month, year, and cycle, such as **November 1922, cycle 8** or **December 1922, cycle 8**.

![Select a target month, year, and cycle](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_2400.png)

Resume the run.

![Resume the run](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_2640.png)

When the model reaches the selected month, year, and cycle, it pauses automatically.

![Automatic pause at the selected point](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_3960.png)

### Resume the model

Resume execution by using either:

- the **Resume** button;
- **Run > Resume**.

![Resume controls](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_2760.png)

### Move to the next cycle

When paused, you can use **Next Cycle** to move from one cycle to the next.

![Next Cycle command](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_3720.png)

If the model is paused at cycle 8, for example, **Next Cycle** advances it to cycle 9 and pauses again.

![Paused again at the next cycle](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_3840.png)

### Move to the next time step

You can also use **Next Time Step** to advance to the next time step.

![Next Time Step command](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_3960.png)

This may move the run from a cycle in **December 1922** to the next time step in **January 1923**.

### Inspect variable values in the editor

While the model is paused, you can move the mouse over a variable in the WRESL editor to view its value for the current time step and cycle.

![Inspect variable values by hovering in the editor](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_4680.png)

### Inspect goal statements

You can also select a goal statement in the editor to display the corresponding goal or constraint expression.

![Inspect goal statements](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_5280.png)

### Variables panel

The **Variables** panel on the right side shows the variables in the file currently open in the editor.

You can search for a variable such as `C5_SWP` in this panel.

![Variables panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_6600.png)

### Goal View panel

The **Goal View** panel shows the goals in the file currently open in the editor.

![Goal View panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_7440.png)

A green square **C** indicates that a goal is a **controlling goal**, meaning the left-hand side is equal to the right-hand side.

If no green **C** appears, the goal is not currently controlling.

A goal such as `IBU_force` may appear as a controlling goal.

![Controlling goal indicator](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_7680.png)

### All Variables and All Goals

The **All Variables** panel shows all variables in the model for the current time step and cycle.

![All Variables panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_8400.png)

The **All Goals** panel shows all goals in the model for the current time step and cycle.

![All Goals panel](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_8760.png)

If you click the **C** button, WRIMS 2 GUI shows the controlling goals for that time step and cycle.

### File-specific vs model-wide views

For this distinction, see [Variable and Goal Views](#variable-and-goal-views).

### Open a different file

Open a different file, such as `B2action2`, to see how the file-specific panels update.

![Open a different file in the editor](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_11400.png)

When a different file is opened:

- the **Variables** panel updates to show variables in that file;
- the **Goal View** panel updates to show goals in that file.

However, if the file is not used in the current cycle, its goals may not appear as active at the current paused point.

![File not active in the current cycle](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_11160.png)

Open another file, such as `ann_core_mrdo`, to see a case where the file is active in the current cycle. In that case, the goals from that file appear in the **Goal View** panel.

![File active in the current cycle](diagrams/frames/09_Debug_PauseVariableGoalView/09_Debug_PauseVariableGoalView_11880.png)

---

### Notes

- This chapter provides the foundation for later debug panels such as **Variable Monitor**, **Variable Detail**, and **Watch**.

---

### Related sections

- [10. Debug Variable Monitor](#10-debug-variable-monitor)
- [12. Debug Watch Variables Goals](#12-debug-watch-variables-goals)
- [15. Debug Error Source Code Link](#15-debug-error-source-code-link)

---

## 10. Debug Variable Monitor

### Purpose
This chapter assumes the study is already running in **Debug** mode and paused at an appropriate point. For the basic pause workflow, see **09. Debug Pause Variable Goal View**.

This chapter shows how to use the **Variable Monitor** panel.

### Before you start

- The study is already paused in a debug session.
- You have one or more variables to inspect.

![Variable Monitor panel location](diagrams/frames/10_Debug_VariableMonitor/10_Debug_VariableMonitor_240.png)

### Procedure

Open the **Variable Monitor** panel during a debug session. It can be repositioned within the interface as needed.

![Open the Variable Monitor panel](diagrams/frames/10_Debug_VariableMonitor/10_Debug_VariableMonitor_480.png)
![Reposition the Variable Monitor panel](diagrams/frames/10_Debug_VariableMonitor/10_Debug_VariableMonitor_720.png)

With the model paused at a selected cycle and year, choose one or more variables to display, such as:

- `rs_EC_month`
- `rs_ec_std`

The **Variable Monitor** panel displays a plot of the selected variables.

![Variable plot in Variable Monitor](diagrams/frames/10_Debug_VariableMonitor/10_Debug_VariableMonitor_480.png)

When the model resumes:

- the plot continues updating;
- pausing the model stops the plot updates;
- resuming the model restarts the updates.

![Variable Monitor updates during execution](diagrams/frames/10_Debug_VariableMonitor/10_Debug_VariableMonitor_4200.png)

If the study is terminated before completion, WRIMS 2 GUI may still save the current results to the output DSS file.

---

### Notes

- The plot updates only while the model is running.
- Even if the run is terminated early, WRIMS 2 GUI may still save output to the DV DSS file.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [11. Debug Variable Detail](#11-debug-variable-detail)
- [12. Debug Watch Variables Goals](#12-debug-watch-variables-goals)

---

## 11. Debug Variable Detail

### Purpose
This chapter is most useful after pausing execution in **Debug** mode. For the pause workflow and initial inspection views, see **09. Debug Pause Variable Goal View** and **10. Debug Variable Monitor**.

This chapter shows how to use the **Variable Detail** panel.

### Before you start

- The model is paused in **Debug** mode.
- A variable is selected in the debug interface.

### Procedure

Pause the model at a specific year, month, and cycle, such as:

- year 1923;
- month January;
- cycle 12.

![Paused model at a selected time and cycle](diagrams/frames/11_Debug_VariableDetail/11_Debug_VariableDetail_120.png)

When a variable is selected in the **Variable View**, the **Variable Detail** panel appears.

![Variable Detail panel](diagrams/frames/11_Debug_VariableDetail/11_Debug_VariableDetail_840.png)

The panel includes several sections.

### Time Series

The **Time Series** section shows values for different time steps:

- **time step 0** = the current time step;
- **-1** = the previous time step;
- earlier negative values = earlier time steps.

The list may extend back to the beginning of the model run.

![Time Series section](diagrams/frames/11_Debug_VariableDetail/11_Debug_VariableDetail_2280.png)

### Cycle

The **Cycle** section shows values from previous cycles for the selected variable.

If the current cycle is cycle 12, for example, the panel may show values from earlier cycles such as cycle 6, cycle 10, and cycle 11.

If the run advances one cycle, the **Cycle** section updates accordingly.

![Cycle section](diagrams/frames/11_Debug_VariableDetail/11_Debug_VariableDetail_2400.png)

### Future

The **Future** section is used for **multi-step optimization** studies and shows future time-step values of a variable.

This section may not be used in a regular study, but it is relevant for multi-step optimization workflows.

![Future section](diagrams/frames/11_Debug_VariableDetail/11_Debug_VariableDetail_3600.png)

### Known input variables

Select another variable, such as `i_orowl`.

![Known input variable example](diagrams/frames/11_Debug_VariableDetail/11_Debug_VariableDetail_5400.png)

For a known input variable loaded from DSS, the **Variable Detail** panel may show values across the study period because the values come from the DSS input file.

---

### Notes

- **Time Series** focuses on time-step history.
- **Cycle** focuses on values from earlier cycles.
- **Future** is especially relevant for multi-step optimization workflows.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [10. Debug Variable Monitor](#10-debug-variable-monitor)
- [17. Debug Find Reference](#17-debug-find-reference)

---

## 12. Debug Watch Variables Goals

### Purpose
This chapter builds on a paused debug session. If you have not yet paused execution or opened the relevant views, see **09. Debug Pause Variable Goal View** first.

This chapter shows how to use the **Watch** panel to collect variables and goals from different files and track them during debugging.

### Before you start

- The study is running in **Debug** mode or is paused at a point of interest.

### Procedure

The **Watch** panel allows you to collect variables and goals from different files so that you can track them during a debug run.

To add an item from the editor:

1. Select a variable or goal in the WRESL editor.
2. Right-click it.
3. Choose **Watch**.

![Add an item to Watch from the editor](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_1200.png)

The selected item is added to the **Watch** panel.

![Watch panel](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_1440.png)

You can add both variables and goals in this way.

### Pause at a selected time

Set a breakpoint at a selected time step and cycle, such as:

- February 1922;
- cycle 10.

![Pause at a selected time step and cycle](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_2280.png)

When the model reaches that point, it pauses and the **Watch** panel shows the values for the watched variables and goals.

### Add items during debugging

You can also add items while the model is paused.

To add a variable using the plus button:

1. Click the **plus** button in the **Watch** panel.

![Watch plus button](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_3120.png)

2. Enter the variable name, such as `C100`.

![Enter a variable name manually](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_3600.png)

3. Click **OK**.

The variable is added to the watch list and its value is displayed.

### Remove watched items

To remove one item:

1. Select the item in the **Watch** panel.
2. Click the **minus** button.

![Remove one watched item](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_5160.png)

To remove all watched items:

1. Click the **cross** button.

![Clear the Watch list](diagrams/frames/12_Debug_WatchVariablesGoals/12_Debug_WatchVariablesGoals_5280.png)

### Update values during the run

When the run advances to the next time step, the values in the **Watch** panel update automatically.

---

### Notes

- The **Watch** panel is useful for tracking the same items across pauses, time steps, and cycles.
- You can add items from the editor or directly in the panel.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [10. Debug Variable Monitor](#10-debug-variable-monitor)
- [21. Debug Filter Goals](#21-debug-filter-goals)

---

## 14. Debug Solver And Option

### Purpose
This chapter explains how to change the solver and runtime options.

### Before you start

- The study is loaded and can be run.
- You want to change solver selection or runtime options.

### Procedure

WRIMS 2 provides two solvers:

- **XA**
- **CBC**

To change the solver:

1. Open the **Run** menu.
2. Choose **Option**.

![Open solver options](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_840.png)

3. Select either **CBC** or **XA**.

![Select CBC or XA solver](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_1080.png)

4. Click **OK**.

Use the **Console** panel to verify which solver is currently active.

### Log file

The options dialog also allows you to enable a **log file**. This can provide intermediate information useful for:

- reviewing the model;
- debugging infeasibility;
- examining solver behavior.

![Log file option](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_1680.png)

### Allocated memory

The options dialog also allows you to change the allocated memory.

Key points:

- the default is typically **4 GB**;
- you can increase it, for example to **8 GB**;
- the value should remain below the total memory available on the PC.

![Allocated memory setting](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_2520.png)

### Change the solver during runtime

The solver can also be changed during a debug run:

1. Start the model in **Debug** mode.
2. Pause it during execution.

![Pause during a debug run](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_4200.png)

3. Open **Run > Option**.
4. Change the solver.

![Change solver during runtime](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_4440.png)

5. Click **OK**.
6. Resume the model.

![Resume after changing solver](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_4680.png)

The **Console** confirms the solver change, and the model continues with the newly selected solver.

### Re-simulate a time step with a different solver

You can also re-simulate a selected time step with another solver:

1. Pause the run at the selected time step.
2. Open **Run > Option** and select another solver.

![Select another solver before re-simulation](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_5640.png)

3. Click **OK**.
4. Open **Run > Re-simulate**.

![Open Re-simulate](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_6000.png)

5. Select the time step to rerun.

![Select time step for re-simulation](diagrams/frames/14_Debug_SolverAndOption/14_Debug_SolverAndOption_6120.png)

6. Click **OK**.

That time step is then re-simulated with the selected solver.

The allocated-memory setting is stored as a user preference and reused the next time WRIMS 2 GUI is opened.

---

### Notes

- Use the **Console** to verify the active solver.
- Increase memory carefully and stay below available system memory.

---

### Related sections

- [03. Basic Create Launch File](#03-basic-create-launch-file)
- [04. Basic Modify Launch File](#04-basic-modify-launch-file)
- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)

---

## 15. Debug Error Source Code Link

### Purpose
This chapter is typically used after a run fails or stops at an error in **Debug** mode. It pairs closely with **09. Debug Pause Variable Goal View** and **17. Debug Find Reference**.

This chapter shows how to link an error message to the corresponding source-code location.

### Before you start

- A study produces a clickable runtime error message.

### Procedure

This workflow works in either:

- **Debug** mode;
- **Run** mode.

Run the study until an error occurs. In the example shown here, the error message indicates a problem with a variable definition that uses a lookup table.

To locate the error:

1. Click the clickable link at the beginning of the error message.

![Clickable error link](diagrams/frames/15_Debug_ErrorSourceCodeLink/15_Debug_ErrorSourceCodeLink_1560.png)

WRIMS 2 GUI opens the relevant WRESL file and moves to the corresponding source location.

![Open source location from the error message](diagrams/frames/15_Debug_ErrorSourceCodeLink/15_Debug_ErrorSourceCodeLink_3120.png)

In the example shown here, a field name in a lookup table reference is incorrect. After identifying the incorrect field name, correct the source and save the file.

![Correct the source code](diagrams/frames/15_Debug_ErrorSourceCodeLink/15_Debug_ErrorSourceCodeLink_4200.png)

After saving the correction, re-simulate the current time step:

1. Open **Run > Re-simulate**.
2. Select the current time step and cycle.
3. Check **Reload Lookup Table** because the lookup table source was changed.

![Reload lookup table during re-simulation](diagrams/frames/15_Debug_ErrorSourceCodeLink/15_Debug_ErrorSourceCodeLink_5280.png)

4. Click **OK**.

The time step is rerun and the error no longer appears.

![Successful re-simulation after the fix](diagrams/frames/15_Debug_ErrorSourceCodeLink/15_Debug_ErrorSourceCodeLink_5640.png)

---

### Notes

- After correcting source content, re-simulate the current time step with the appropriate reload or recompile options.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [17. Debug Find Reference](#17-debug-find-reference)
- [20. Debug Study Cycle WRESL](#20-debug-study-cycle-wresl)

---

## 16. Debug Conditional Breakpoint

### Purpose
This chapter extends the basic debugging workflow. Create or open a launch configuration first, then enter **Debug** mode and use the pause workflow described in **09. Debug Pause Variable Goal View**.

This chapter shows how to use **Conditional Breakpoint**.

### Before you start

- The study is paused in **Debug** mode.
- You know a variable-based condition that should trigger a stop.

### Procedure

While the model is paused in **Debug** mode, open:

- **Run > Conditional Breakpoint**

![Open Conditional Breakpoint](diagrams/frames/16_Debug_ConditionalBreakpoint/16_Debug_ConditionalBreakpoint_600.png)

Enter a condition, such as:

` s_shsta > 1000 `

![Enter a conditional breakpoint expression](diagrams/frames/16_Debug_ConditionalBreakpoint/16_Debug_ConditionalBreakpoint_1320.png)

When the model resumes, WRIMS 2 GUI continues running until the condition becomes true. At that point, the model pauses automatically.

![Automatic pause when the condition is met](diagrams/frames/16_Debug_ConditionalBreakpoint/16_Debug_ConditionalBreakpoint_2040.png)

You can then check the variable value and confirm that the condition has been satisfied.

![Verify the breakpoint condition](diagrams/frames/16_Debug_ConditionalBreakpoint/16_Debug_ConditionalBreakpoint_2400.png)

The condition can also be modified during the run. For example, the threshold can be changed from `1000` to `5000`.

If the condition is not satisfied, the model continues running.

To clear the condition:

- open **Run > Clear Conditional Breakpoint**.

![Clear the conditional breakpoint](diagrams/frames/16_Debug_ConditionalBreakpoint/16_Debug_ConditionalBreakpoint_4200.png)

Once the conditional breakpoint is cleared, the model continues without stopping on that condition.

---

### Notes

- This feature is especially useful when an issue appears only after a variable crosses a threshold.
- Clear the conditional breakpoint when you no longer want automatic stopping.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [10. Debug Variable Monitor](#10-debug-variable-monitor)
- [12. Debug Watch Variables Goals](#12-debug-watch-variables-goals)

---

# 5. Analysis and Diagnostics

## 13. Debug Compare Existing Studies

### Purpose
This chapter explains how to compare a running study with one or more existing studies during a debug run.

### Before you start

- The current study is paused in **Debug** mode.
- You have DV/SV files or study outputs from one or more existing alternatives.

### Procedure

Pause the model in **Debug** mode at a point of interest, such as **March 31, 1925**.

To compare the current run with an existing study:

1. Open the **Data** menu.
2. Choose **Load DSS or Study**.

![Load DSS or Study](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_1080.png)

WRIMS 2 GUI allows up to eight alternatives:

- **Alternative 1–4** load DV and SV files from existing studies.
- **Alternative 5–8** load intermediate LP (ILP) files.

This chapter focuses on **Alternative 1–4**.

![Alternative slots in comparison workflow](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_1320.png)

### Load an alternative study

To load **Alternative 1**, browse to the existing study and select the DV and SV files.

![Load Alternative 1](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_3480.png)

After loading:

- variables show values for the **current run**;
- variables also show values for **Alternative 1**.

![Current run and Alternative 1 values](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_3600.png)

If you click a variable, the **Variable Detail** panel shows both the current-run value and the alternative value.

![Variable Detail with comparison values](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_4320.png)

### Compare watched variables

The **Watch** panel can also be used to compare watched variables between the current run and the alternative.

A watched variable such as `C8` or `C6` can display both current-run and alternative values through time.

![Watch comparison across alternatives](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_6120.png)

### Continue the run

When the run resumes and moves to a later time step, the comparison values update accordingly.

### Load another alternative

Load **Alternative 2** in the same way.

![Load Alternative 2](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_8280.png)

At that point, the interface can compare:

- the current run;
- Alternative 1;
- Alternative 2.

When a variable is selected, the **Variable Detail** panel shows all loaded comparison values.

![Variable Detail with multiple alternatives](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_8760.png)

If the study is terminated before completion, the current run is still saved to DSS.

![Termination after comparison workflow](diagrams/frames/13_Debug_CompareExistingStudies/13_Debug_CompareExistingStudies_9600.png)

---

### Notes

- Alternatives 1–4 are used for existing study DV/SV comparisons.
- This workflow is useful for regression checking, troubleshooting, and understanding why a current run diverges from a known baseline.

---

### Related sections

- [05. Basic Perspectives](#05-basic-perspectives)
- [23. Advanced Batch Run GUI](#23-advanced-batch-run-gui)
- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

## 21. Debug Filter Goals

### Purpose
This chapter is easier to understand after you are comfortable with paused inspection, watched variables, and goal views. See **09. Debug Pause Variable Goal View** and **12. Debug Watch Variables Goals** as preparation.

This chapter shows how to use a filtering file to evaluate selected goals and determine whether they should be treated as controlling goals.

### Before you start

- The study is paused in **Debug** mode.
- You have a goal-filter file with goal names, aliases, and optional tolerances.

### Procedure

For the controlling-goal concept and tolerance behavior, see [Controlling Goals and Goal Tolerance](#controlling-goals-and-goal-tolerance).

![Goal View with controlling goal indicator](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_840.png)

A filtering file provides another way to evaluate controlling goals.

![Filtering file concept](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_1680.png)

A sample filtering file contains:

- the goal name;
- an alias;
- a tolerance.

![Sample goal filter file](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_1800.png)

The tolerance rules are described in [Controlling Goals and Goal Tolerance](#controlling-goals-and-goal-tolerance).

For example, a tolerance of `100` means the goal is treated as controlling if the difference is less than 100.

To use the filter file:

1. Click the **Filter Goals** button.

![Filter Goals button](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_4560.png)

2. Browse to the filter file.

![Select the goal filter file](diagrams/frames/21_Debug_FilterGoals/21_Debug_FilterGoals_4800.png)

3. Click **OK**.

WRIMS 2 GUI displays a dialog with the filtered goals and indicates which of them are controlling under the specified tolerance.

A very large tolerance may be useful for demonstration, but it is not typical for production analysis.

---

### Notes

- A tolerance allows a goal to be treated as controlling even when the left-hand side and right-hand side are not exactly equal.
- Use realistic tolerances for analysis; very large tolerances are usually for demonstration only.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [12. Debug Watch Variables Goals](#12-debug-watch-variables-goals)
- [22. Debug Force Variable Resimulation](#22-debug-force-variable-resimulation)

---

## 22. Debug Force Variable Resimulation

### Purpose
This chapter builds on earlier debugging concepts, especially paused execution, goal inspection, and filtered analysis. Review **09. Debug Pause Variable Goal View** and **21. Debug Filter Goals** if needed.

This chapter shows how to force a variable to a specified value and re-simulate the current time step to analyze objective-function impact.

### Before you start

- The study is paused at the time step and cycle you want to investigate.
- You know the variable and trial value you want to force.

### Procedure

Pause the model in **Debug** mode at a selected time step and cycle, such as:

- December 1921;
- cycle 10.

![Paused model for forcing analysis](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_1680.png)

In the example shown here, the current value of `s_shsta` is `3147`.

![Current variable value before forcing](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_1920.png)

The objective is to test what happens if `s_shsta` is forced to `3000`.

### Step 1: Save the current DV results

First, save the current results to the DV file.

![Save current DV results](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_3240.png)

### Step 2: Load the saved DV file as Alternative 1

Load the saved DV file as **Alternative 1** so that the original value is available for comparison.

![Load original results as Alternative 1](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_4920.png)

At this point:

- current run = original value;
- Alternative 1 = same original value.

### Step 3: Add a forcing goal

Add a new goal to the WRESL code, using a unique name so that it does not conflict with any existing goal.

![Add a temporary forcing goal](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_6600.png)

A forcing goal can be written as:

    goal test { s_shsta = 3000 }

Save the file after adding the new goal.

### Step 4: Re-simulate

To rerun the time step with the new forcing goal:

1. Open **Run > Re-simulate**.
2. Select the current time step.
3. Enable **Re-compile WRESL Code** because the WRESL source has changed.

![Enable WRESL recompilation during re-simulation](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_7920.png)

4. Click **OK**.

The time step is rerun using the new goal.

At this point:

- current run = forced value, such as `3000`;

![Forced value after re-simulation](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_8760.png)

- Alternative 1 = original value, such as `3147`.

### Step 5: Analyze the objective function

To analyze the objective-function impact:

1. Open **All Variable**.

![Open All Variable](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_9360.png)

2. Retrieve the alternative data.

![Retrieve alternative data](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_9720.png)

3. Open **Weighted Variable**.

![Open Weighted Variable](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_11880.png)

4. Compare the current run and Alternative 1.
5. Sort by objective change.

![Sort by objective change](diagrams/frames/22_Debug_ForceVariableResimulation/22_Debug_ForceVariableResimulation_12240.png)

This comparison shows:

- which variables increase the objective;
- which variables decrease the objective;
- which changes contribute most to the overall difference.

---

### Notes

- Save the current DV result first so that the forced rerun can be compared against the original case.
- Recompile WRESL code if you changed the WRESL source.

---

### Related sections

- [09. Debug Pause Variable Goal View](#09-debug-pause-variable-goal-view)
- [21. Debug Filter Goals](#21-debug-filter-goals)
- [26. Advanced Position Analysis](#26-advanced-position-analysis)

---

# 6. Study Cleanup and Packaging

## 18. Debug Clean SV DSS File

### Purpose
This chapter explains how to create a clean SV DSS file that includes only the time series and variables used by the model.

### Before you start

- You have a study or DSS file that contains more SV records than you need.

### Procedure

Sometimes an SV DSS file contains significantly more data than the model actually uses. You can create a clean SV file containing only the data loaded during the run.

Because the SV DSS file is read at the beginning of the simulation, you can pause the model at any later time step and still save a clean SV file based on what has already been loaded into memory.

To do this:

1. Start the model in **Debug** mode.
2. Let it run.
3. Pause it at any time step.

![Pause during the run](diagrams/frames/18_Debug_CleanSVDssFile/18_Debug_CleanSVDssFile_2160.png)

4. Open **Data > Save to SV File**.

![Save to SV File command](diagrams/frames/18_Debug_CleanSVDssFile/18_Debug_CleanSVDssFile_2880.png)

5. Enter a new file name, such as `SV_clean.dss`.

![Specify a clean SV file name](diagrams/frames/18_Debug_CleanSVDssFile/18_Debug_CleanSVDssFile_3360.png)

6. Click **OK**.

Then open the study folder, go to `common\DSS`, refresh the folder, and confirm that the new file `SV_clean.dss` has been created.

![Saved clean SV file](diagrams/frames/18_Debug_CleanSVDssFile/18_Debug_CleanSVDssFile_4080.png)

The clean file contains only the variables and time series used by the model.

---

### Notes

- This workflow is useful when reducing noise in debugging workflows or preparing a lighter study package.

---

### Related sections

- [03. Basic Create Launch File](#03-basic-create-launch-file)
- [19. Debug Clean Study](#19-debug-clean-study)
- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

## 19. Debug Clean Study

### Purpose
This chapter explains how to export a clean study package containing only the files used by the selected launch file.

### Before you start

- You have a working study folder.
- You want to create a smaller or cleaner copy for sharing, archiving, or debugging.

### Procedure

A clean study package contains only the files required by the selected launch configuration, such as:

- the WRESL files used by the study;
- the DSS files used by the study;
- the SV and DV DSS files;
- lookup tables;
- the launch file itself.

To export a clean study:

1. Right-click the launch file.
2. Choose **Export Study**.

![Export Study command](diagrams/frames/19_Debug_CleanStudy/19_Debug_CleanStudy_1320.png)

3. Select the folder where the clean study should be exported.

![Select export folder](diagrams/frames/19_Debug_CleanStudy/19_Debug_CleanStudy_2400.png)

4. Click **OK**.

WRIMS 2 GUI then collects the files actually used by that launch configuration and copies them to the selected folder.

The exported folder contains:

- the launch file;

![Exported launch file](diagrams/frames/19_Debug_CleanStudy/19_Debug_CleanStudy_4440.png)

- the DSS files used by the selected launch configuration;

![Exported DSS files](diagrams/frames/19_Debug_CleanStudy/19_Debug_CleanStudy_4800.png)

- the WRESL files used by the study;

![Exported WRESL files](diagrams/frames/19_Debug_CleanStudy/19_Debug_CleanStudy_5040.png)

- the SV file and initial file required by the study.

![Exported SV and initial files](diagrams/frames/19_Debug_CleanStudy/19_Debug_CleanStudy_5280.png)

Unused files are not included.

---

### Notes

- This workflow is valuable when handing a study to another user or preparing a minimal bug-reproduction case.

---

### Related sections

- [18. Debug Clean SV DSS File](#18-debug-clean-sv-dss-file)
- [23. Advanced Batch Run GUI](#23-advanced-batch-run-gui)
- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

# 7. Advanced Execution

## 23. Advanced Batch Run GUI

### Purpose
This chapter explains how to run multiple studies through the GUI.

### Before you start

- You already have one or more valid launch files.
- **WRIMS 2 GUI** is open.

### Procedure

Open **WRIMS 2 GUI**, then go to:

- **Run > Batch Run**

The Batch Run dialog appears.

![Batch Run dialog](diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_720.png)

You can add launch files for different study types, such as:

- a regular study;
- a multi-step study;
- a position-analysis study.

![Add multiple study types to Batch Run](diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_2640.png)

To add launch files:

1. Browse to the launch file.

![Browse to a launch file](diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_1200.png)

2. Select it.
3. Click **Add**.

![Add the launch file to the batch list](diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_1320.png)

### Sequential vs parallel

The Batch Run dialog includes a checkbox that determines whether the studies run:

- **sequentially**;
- **in parallel**.

If the checkbox is selected, the runs are sequential. If it is cleared, the runs are parallel.

![Sequential versus parallel mode](diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_3480.png)

### Start all

After the launch files are added and the run mode is selected:

1. Click **Start All**.

![Start All button](diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_3600.png)

All selected studies begin running. Depending on the run types, multiple command windows may appear, and multi-step or position-analysis studies may proceed in blocks with intermediate processing between periods.

---

### Notes

- Parallel execution can increase resource usage significantly.
- Make sure each launch file is valid before adding it to the batch list.

---

### Related sections

- [24. Advanced Batch Run Cmd](#24-advanced-batch-run-cmd)
- [25. Advanced Multi Study Run](#25-advanced-multi-study-run)
- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

## 24. Advanced Batch Run Cmd

### Purpose
This chapter explains how to run multiple studies outside **WRIMS 2 GUI** from the command line.

### Before you start

- You have one or more valid launch files.
- You can access the WRIMS package `batchrun` folder.

![batchrun folder](diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_600.png)

### Procedure

The WRIMS 2 package contains a `batchrun` folder. In this folder, the following batch files are available:

- `parallelbatchrun`
- `sequentialbatchrun`

![Batch run command files](diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_720.png)

These scripts support:

- regular studies;
- multi-step studies;
- position-analysis studies;
- combinations of these workflows.

### Launch file group

Before running the batch scripts, create a launch-file group file, `.lfg`, which lists the launch files to run.

To prepare it:

1. Open the `.lfg` file in a text editor.

![Open the .lfg file](diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_2400.png)

2. Put one launch-file path on each line.

![Launch-file list in .lfg](diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_2640.png)

3. Save the file.

A single `.lfg` file can contain, for example:

- one regular study launch file;
- one multi-step study launch file;
- one position-analysis study launch file.

### Run the batch script

Return to the `batchrun` folder and run:

- `parallelbatchrun` for parallel execution;
- `sequentialbatchrun` for sequential execution.

![Run the batch script from the command line](diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_4680.png)

The example shown here uses the parallel batch run and displays multiple studies running at the same time.

![Parallel batch run in progress](diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_5520.png)

---

### Notes

- The `.lfg` file is the primary input list for command-line batch running.
- Choose the parallel or sequential script based on workflow requirements and available machine resources.

---

### Related sections

- [23. Advanced Batch Run GUI](#23-advanced-batch-run-gui)
- [25. Advanced Multi Study Run](#25-advanced-multi-study-run)
- [26. Advanced Position Analysis](#26-advanced-position-analysis)

---

## 25. Advanced Multi Study Run

### Purpose
This chapter depends on concepts introduced in launch file creation and batch execution. Review **03. Basic Create Launch File**, **23. Advanced Batch Run GUI**, and **24. Advanced Batch Run Cmd** before configuring multi-study workflows.

This chapter shows how to set up and run a **multi-study run**.

### Before you start

- You have a coordinated workflow that requires multiple studies to run in sequence or in blocks.
- You know the file paths and time settings for each study in the group.

### Procedure

A multi-study run contains several studies that run together as a coordinated workflow.

In the example shown here, there are three studies:

- study one;
- study two;
- study three.

The launch file is placed above the study folders so that it can control all of them.

### Open the configuration

1. Load the multi-study run project.

![Load multi-study run project](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_360.png)
![Project loaded](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_600.png)

2. Open **Run Configuration**.

![Open Run Configuration](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_2040.png)

3. Select the multi-study launch file.

![Select the multi-study launch file](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_2160.png)

### Main tab

In the **Main** tab:

![Main tab for multi-study configuration](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_2280.png)

1. Specify the number of studies, such as `3`.
2. Configure the main WRESL file, DV file, SV file, initial file, Part A, Part F, start date, and end date for study one.

Relative paths are recommended.

### Multi Study Runner tab

In the **Multi Study Runner** tab, choose whether the run uses:

- **fixed duration**;
- **variable duration**.

![Multi Study Runner tab](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_5280.png)

#### Fixed duration

With fixed duration, specify a number of months, such as `12`.

The execution pattern is then:

- study one runs 12 months;
- study two runs 12 months;
- study three runs 12 months;
- the run returns to study one for the next block.

#### Variable duration

With variable duration, specify a variable-duration file. A sample file may be available in the templates area.

![Variable-duration file example](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_5880.png)
![Variable-duration file details](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_6240.png)
![Additional variable-duration example](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_6360.png)

A variable-duration file can define different month blocks for different rounds, such as:

- 72 months;
- then 120 months;
- then 36 months.

### Configure study two and study three

For each additional study, configure:

- main WRESL file;
- DV file;
- SV file;
- initial file;
- Part A;
- Part F;
- initial Part F;
- SV Part F.

![Configuration fields for additional studies](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_9360.png)

### Initial condition logic

Initial-condition transfer works as follows:

- In the first round, each study uses its own initial file.
- After the first round:
  - study one DV becomes the initial condition for study two;
  - study two DV becomes the initial condition for study three;
  - the last study DV becomes the initial condition for study one in the next round.

### Data transfer files

**Data transfer files** move selected DSS records from one study to the next.

![Data transfer file concept](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_13800.png)

A transfer file can include:

- **DV to DV** transfer;
- **DV to SV** transfer.

Examples include:

- a time series in the DV file of study one can be transferred to the DV file of study two;
- a time series in the DV file of study one can also be transferred to the SV file of study two.

![Data transfer mapping example](diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_13920.png)

The source and destination Part B values are mapped, while Part C remains the same.

### Run the multi-study workflow

After all settings are configured, click **Run**.

The studies then rotate through the selected time blocks and continue forward through the simulation period.

---

### Notes

- Relative paths are strongly recommended.
- Choose fixed or variable duration based on how long each study should run before handing control to the next one.

---

### Related sections

- [23. Advanced Batch Run GUI](#23-advanced-batch-run-gui)
- [24. Advanced Batch Run Cmd](#24-advanced-batch-run-cmd)
- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

## 26. Advanced Position Analysis

### Purpose
This chapter depends on launch-file setup and is closely related to re-simulation concepts. Review **03. Basic Create Launch File** and **22. Debug Force Variable Resimulation** before using position analysis.

This chapter shows how to set up and run a **Position Analysis** study.

### Before you start

- You have a study suitable for repeated simulation with shifted initial conditions.
- You understand the desired start interval and duration for each position-analysis block.

### Procedure

A Position Analysis study has a folder structure similar to a regular study. The main difference is in the launch configuration.

In Position Analysis:

- the same initial condition is reused for different simulation periods;
- the initial condition is shifted forward by a selected interval.

For example:

- the initial condition from October 1921 is used to simulate October 1921 to September 1922;
- then it is shifted and used again for October 1922 to September 1923;
- then again for October 1923 to September 1924.

### Configure Position Analysis

1. Open the study launch configuration.

![Open the study launch configuration](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_1320.png)

2. In the **Main** tab, check **Position Analysis**.

![Enable Position Analysis](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_3360.png)

3. Set the usual file fields and dates.

Then open the **Position Analysis** tab.

![Position Analysis tab](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_4680.png)

### PA Start Interval

The **PA Start Interval** defines how often the initial condition is shifted forward.

For example:

- `12` months means the same initial condition is reused every 12 months.

![PA Start Interval](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_4800.png)

### PA Duration

The **PA Duration** defines how long each simulation block runs.

For example:

- `12` months means each shifted run simulates 12 months.

![PA Duration](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_6240.png)

The interval and duration do not need to be the same, although they often are.

### Delete shifted initial files

The option **Delete PA Initial File After run completed** controls whether the shifted initial-condition files are deleted after the run.

![Delete shifted initial files option](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_12120.png)

### Reset output start date

The option **Reset the Start Date of DV DSS Output** allows the simulated output to be shifted to another output year, such as mapping all results to a common year like 2013.

### Important date rule

The start date must be the **first day of the month**.

For example:

- use **October 1**;
- do not use **October 31**.

![Start date rule for Position Analysis](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_13320.png)

Using the first day of the month avoids problems when shifting the initial condition by a number of months.

### Run

After configuration, click **Run**.

![Run Position Analysis](diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_13680.png)

The run then follows a repeating pattern:

- simulate a block;
- shift the initial condition;
- simulate the next block;
- continue through the study period.

---

### Notes

- This workflow is useful for understanding how the same starting position performs across different historical windows.
- Choose **PA Start Interval** and **PA Duration** carefully; they do not have to be the same.

---

### Related sections

- [03. Basic Create Launch File](#03-basic-create-launch-file)
- [22. Debug Force Variable Resimulation](#22-debug-force-variable-resimulation)
- [27. DSS Wrims DSS Perspective](#27-dss-wrims-dss-perspective)

---

# 8. DSS Review and Results

## 27. DSS Wrims DSS Perspective

### Purpose
This chapter explains how to use the **DSS Perspective** to compare studies.

### Before you start

- You have DSS files or study results ready to compare.
- You can switch to **DSS Perspective**.

### Procedure

WRIMS 2 may reopen in the perspective that was active during the previous session. If it does not open in **DSS Perspective**, switch to that perspective first.

This workflow compares two studies by loading their DSS files.

For comparison:

- one study is treated as the **base**;
- the other is treated as the **alternative**.

Differences are then shown as:

**alternative - base**

### Load DSS files

Load the relevant DSS files for the two studies being compared.

![Load DSS file 1](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_1200.png)
![Load DSS file 2](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_1920.png)
![Additional DSS load step](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_2160.png)
![Select comparison studies](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_2640.png)
![Comparison selection dialog](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_3720.png)

If multiple studies are loaded, select the two studies you want to compare and click **OK**.

### Filter records

Once the files are loaded, use the catalog view to filter DSS records by path parts, especially:

- **B part**
- **C part**

Entering a B part, for example, filters the record list to matching variables.

![Filter DSS records by B or C part](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_6840.png)

### View plots and tables

After selecting a variable, WRIMS 2 GUI can display:

- a plot;
- a time-series table;
- side-by-side comparison tables.

![Plot view](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_7080.png)
![Time-series table](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_8640.png)
![Comparison table](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_9360.png)

The example shown here covers the full model period from October 1921 through September 2003.

### Difference view

Difference view can display:

- monthly differences;
- annual statistics;
- average annual value;
- minimum values;
- maximum values;
- average monthly values.

Color coding is also used:

- blue may indicate maximum values;
- red may indicate minimum values.

### Different chart types

The **DSS Perspective** also supports:

- plots;
- annual totals;
- exceedance views;
- monthly averages.

![Annual totals view](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_11880.png)
![Exceedance view](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_12720.png)
![Monthly averages view](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_13440.png)
![Additional chart type](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_13560.png)

### Shortcut buttons

Shortcut buttons can be used to select outputs by system feature or location, but they depend on choosing the correct CalSim type first.

If both studies are CalSim 2, for example, select that model type first.

Shortcut buttons can then be used for:

- facilities;
- locations;
- storages;
- shortages;
- selected system features.

![Shortcut buttons in DSS Perspective](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_15000.png)

### Save and reopen DSS compare projects

To avoid reloading the same DSS files repeatedly, save the DSS compare setup as a project file.

To save:

1. Click **Save**.
2. Choose a location.
3. Enter a file name.
4. Save the project.

![Save DSS compare project](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_15840.png)
![Saved DSS compare project](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_21120.png)

To reopen it later:

1. Click **Open Project**.

![Open Project button](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_22080.png)

2. Select the saved project file.

![Select saved DSS compare project](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_22200.png)

3. Click **Open**.

### Month filters

The **DSS Perspective** can also filter by month.

![Month filter control](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_23040.png)

You can:

- view all 12 months;
- choose a single month;
- choose multiple months by holding **Shift**.

![Single-month selection](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_23280.png)
![Multi-month selection](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_23640.png)

This is useful when focusing on specific seasons or operational periods.

### Reporting year type

The **DSS Perspective** supports different year types:

- **Water year**: October to September
- **Calendar year**: January to December
- **CVP contract year**: March to February

![Water year option](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_24960.png)
![Calendar year option](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_25200.png)
![CVP contract year option](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_26160.png)

Typical uses include:

- water year for most hydrologic analysis;
- calendar year for SWP delivery or allocation analysis;
- March to February for CVP deliveries and shortages.

### Time window

The time window can also be changed.

Historical periods can be isolated, such as:

- 1928 to 1934;
- 1975 to 1977;
- 1987 to 1992.

![Time-window filter](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_27120.png)

### Units

Units can be changed, for example between:

- TAF
- CFS

![Unit selection](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_30960.png)

### Multiple-variable filter operators

The filter field also supports:

- vertical bar operators for multiple variables;
- wildcard patterns such as `*`.

![Multiple-variable filter syntax](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_33240.png)
![Wildcard filter syntax](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_34320.png)

### Water year type caution

Use preloaded water-type information carefully, especially for climate-change scenario comparisons, because the built-in water-year typing may reflect existing climate conditions rather than the scenario being analyzed.

![Water-year type caution](diagrams/frames/27_DSS_WrimsDssPerspective/27_DSS_WrimsDssPerspective_35880.png)

### Notes

- Difference view is typically shown as **alternative - base**.
- Use caution with built-in water-year typing when analyzing climate-change scenarios or other nonstandard contexts.

### Related sections

- [05. Basic Perspectives](#05-basic-perspectives)
- [13. Debug Compare Existing Studies](#13-debug-compare-existing-studies)
- [25. Advanced Multi Study Run](#25-advanced-multi-study-run)
