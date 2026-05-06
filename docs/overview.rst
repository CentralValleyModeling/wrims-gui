.. _overview-page:

Overview
========


.. _overview:

Overview
--------


This guide provides user documentation for **WRIMS 3 GUI**. It covers the core tasks and interface features required to load and configure studies, navigate the workspace, inspect model structure, debug model behavior, run special execution workflows, and review DSS-based results.

The guide is organized to support both task-based use and general reference. Conceptual sections explain key interface elements, configuration behavior, and model-navigation features, while procedural sections provide step-by-step instructions for common workflows.

This document is intended to support both first-time users and experienced study developers. It may be used as:

- an onboarding guide for common **WRIMS 3 GUI** tasks;
- a reference for interface behavior, launch configuration, and model navigation;
- a procedural guide for debugging, analysis, cleanup, special executions, and DSS review.

.. _intended-audience:

Intended audience
-----------------


This guide is intended for:

- **New users** who need a clear starting point for loading studies, creating launch files, and understanding the **WRIMS 3 GUI** workspace;
- **Study developers and analysts** who need to run, inspect, compare, and troubleshoot WRIMS studies; and
- **Advanced users** who need batch execution, multi-study workflows, position analysis, and DSS-based result review.

.. _how-to-use-this-guide:

How to use this guide
---------------------


- If you are new to **WRIMS 3 GUI**, start with **Chapter 1. Getting Started**, then continue to **Chapter 2. Concepts and Interface**.
- If you need to inspect model behavior during execution, go to **Chapter 4. Core Debugging Workflow**.
- If you need to compare runs, filter goals, or analyze forced reruns, go to **Chapter 5. Analysis and Diagnostics**.
- If you need to package studies or create clean study copies, go to **Chapter 6. Study Cleanup and Packaging**.
- If you need batch execution, multi-study runs, position analysis, or sensitivity runs, go to **Chapter 7. Special Executionss**.
- If you need to review DSS data and compare DSS records, go to **Chapter 8. DSS Review and Results**.

.. _common-terms:

Common terms
------------


- **Study**: a WRIMS project and its associated files used for a model run.
- **Launch file**: the WRIMS run or debug configuration that stores model paths, DSS settings, dates, and execution options.
- **DV DSS / SV DSS / Initial DSS**: DSS files used for decision-variable output, state-variable input, and initial-condition input.
- **Cycle**: an internal model iteration at a given time step.
- **Controlling goal**: a goal that is currently binding, as indicated in the GUI by the controlling-goal marker.
- **Perspective**: a task-oriented arrangement of views and tools in the WRIMS interface.

.. _table-of-contents:

Table of contents
-----------------


- :ref:`1. Getting Started <1-getting-started>`

  - :ref:`1.1 Basic Load Existing Study <11-basic-load-existing-study>`
  - :ref:`1.2 Basic New Study <12-basic-new-study>`
  - :ref:`1.3 Basic Load Zip File <13-basic-load-zip-file>`
  - :ref:`1.4 Basic Create Launch File <14-basic-create-launch-file>`
  - :ref:`1.5 Basic Modify Launch File <15-basic-modify-launch-file>`

- :ref:`2. Concepts and Interface <2-concepts-and-interface>`

  - :ref:`2.1 Existing Studies and New Studies <21-existing-studies-and-new-studies>`
  - :ref:`2.2 Launch Files and Run Modes <22-launch-files-and-run-modes>`
  - :ref:`2.3 Variable and Goal Views <23-variable-and-goal-views>`
  - :ref:`2.4 Controlling Goals and Goal Tolerance <24-controlling-goals-and-goal-tolerance>`
  - :ref:`2.5 Basic Perspectives <25-basic-perspectives>`
  - :ref:`9.1 Schematic View Workflow <91-schematic-view-workflow>`
  - :ref:`9.2 Schematic Editor Workflow <92-schematic-editor-workflow>`
  - :ref:`2.6 Basic Outline Panel for the WRESL File <26-basic-outline-panel-for-the-wresl-file>`

- :ref:`3. Model Structure and Source Navigation <3-model-structure-and-source-navigation>`

  - :ref:`3.1 Basic WRESL Plus <31-basic-wresl-plus>`
  - :ref:`3.2 Debug Find Reference <32-debug-find-reference>`
  - :ref:`3.3 Debug Study Cycle WRESL <33-debug-study-cycle-wresl>`

- :ref:`4. Core Debugging Workflow <4-core-debugging-workflow>`

  - :ref:`4.1 Debug Pause Variable Goal View <41-debug-pause-variable-goal-view>`
  - :ref:`4.2 Debug Variable Monitor <42-debug-variable-monitor>`
  - :ref:`4.3 Debug Variable Detail <43-debug-variable-detail>`
  - :ref:`4.4 Debug Watch Variables Goals <44-debug-watch-variables-goals>`
  - :ref:`4.5 Debug Solver And Option <45-debug-solver-and-option>`
  - :ref:`4.6 Debug Error Source Code Link <46-debug-error-source-code-link>`
  - :ref:`4.7 Debug Conditional Breakpoint <47-debug-conditional-breakpoint>`

- :ref:`5. Analysis and Diagnostics <5-analysis-and-diagnostics>`

  - :ref:`5.1 Debug Compare Existing Studies <51-debug-compare-existing-studies>`
  - :ref:`5.2 Debug Filter Goals <52-debug-filter-goals>`
  - :ref:`5.3 Debug Force Variable Resimulation <53-debug-force-variable-resimulation>`

- :ref:`6. Study Cleanup and Packaging <6-study-cleanup-and-packaging>`

  - :ref:`6.1 Debug Clean SV DSS File <61-debug-clean-sv-dss-file>`
  - :ref:`6.2 Debug Clean Study <62-debug-clean-study>`
- :ref:`7. Special Executions <7-special-executions>`
  - :ref:`7.1 Special Batch Run GUI <71-special-batch-run-gui>`
  - :ref:`7.2 Special Batch Run Cmd <72-special-batch-run-cmd>`
  - :ref:`7.3 Special Multi Study Run <73-special-multi-study-run>`
  - :ref:`7.4 Special Position Analysis <74-special-position-analysis>`
  - :ref:`7.5 Sensitivity Analysis in WRIMS <75-sensitivity-analysis-in-wrims>`

- :ref:`8. DSS Review and Results <8-dss-review-and-results>`

  - :ref:`8.1 DSS Wrims DSS Perspective <81-dss-wrims-dss-perspective>`

- :ref:`9. Schematic Workflows <9-schematic-workflows>`

  - :ref:`9.1 Schematic View Workflow <91-schematic-view-workflow>`
  - :ref:`9.2 Schematic Editor Workflow <92-schematic-editor-workflow>`
