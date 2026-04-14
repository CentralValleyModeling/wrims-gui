# Python Runtime Integration in WRIMS-GUI

## Status

Proposed

## Context and Problem Statement

WRIMS-GUI requires Python interoperability for certain computation capabilities, library dependencies, and legacy UI features. 
Multiple Python runtime integrations are currently present in the project: 
**JEP (Java Embedded Python)**, **JPY**, and legacy dependencies such as **JPython/Jython**. 
There is a need to decide which integrations to retain and which to remove, with the goal of consolidating Python usage within the project.

> Note: More information on Python usage within WRIMS-Engine can be found in its respective documentation.

The initial dependency analysis report on Python usage within the WRIMS project can be found here:
[GitHub Discussion #82](https://github.com/CentralValleyModeling/wrims-engine/discussions/82).

> Note: Some information in the linked discussion report may be outdated.

## Decision Scope / Boundary

This ADR defines how Python is used within the WRIMS Application (WRIMS-GUI).

### In Scope
- GUI-initiated Python usage  
- GUI–Python integration  
- User-facing scripting and orchestration  

### Out of Scope
- Python usage internal to WRIMS-Engine  
- Engine runtime decisions  

The WRIMS-Engine ADR defines Python usage within the compute layer.

## Relationship to WRIMS-Engine Python ADR

This ADR defines how Python is used within WRIMS-GUI. A separate ADR defines how Python is used within 
[WRIMS-Engine](https://github.com/CentralValleyModeling/wrims-engine/blob/main/docs/design-records/python-usage.md).

- The WRIMS-Engine ADR governs Python execution within the compute layer.  
- This ADR focuses on Python usage in GUI-driven workflows and user interaction.

Where possible, WRIMS-GUI should use Python integration approaches that are compatible with the WRIMS-Engine runtime. 
Differences are acceptable when required by user workflows or tooling needs.

## User Interaction Model

Python usage within WRIMS-GUI is primarily user-driven and workflow-oriented.

### Expected Usage Patterns
- Execution of user-defined scripts for pre-processing, post-processing, and analysis  
- Integration with model workflows launched through the GUI  
- Support for interactive and exploratory modeling tasks  

### Design Considerations
- Python usage should minimize required environment setup for end users where possible  
- Where users rely on external Python environments, integration should be predictable and well-defined  
- GUI-driven Python execution should prioritize transparency and debuggability  

These usage patterns differ from WRIMS-Engine, where Python (if used) is part of the internal execution model rather than a user-facing workflow tool.

## Decision Drivers
- Maintainability: Prefer a single, well-supported Python integration.
- Test coverage: Ensure replacements do not introduce untested regressions.
- Dependency management: Prefer dependencies available via Maven/Gradle.
- Future extensibility: Prefer the integration that offers the broadest future applicability.

## Unknowns and Validation Needs

### Unknowns
- Current Python usage in WRIMS workflows is not fully documented  
- GraalPy compatibility with existing user scripts and libraries is not fully validated  
- User expectations regarding Python environment control (system Python vs bundled runtime) are unclear  

### Recommended Validation
- Workflow assessment: collect or survey current model workflows using Python  
- Library validation: validate key libraries (e.g., DSS, ANN tools, post-processing scripts)  
- Environment requirements: confirm whether users require direct access to CPython environments  

## Considered Options
1. Consolidate all Python usage to a single integration. GraalPy is evaluated as the leading candidate.
2. Retain multiple integrations but update to the latest versions and remove those that are no longer needed.
3. Maintain the status quo.

## Recommendations

**Chosen option: TBD** *(to be decided)*

This ADR is currently in a **Proposed** state. The recommended path is to standardize
on **GraalPy** (Option 1) once adequate test coverage is established for existing Python usages within
WRIMS, to reduce regression risk and support the maintainability, dependency management, 
and extensibility goals identified in this ADR.

### Positive Consequences

- A single Python runtime reduces dependency complexity.

### Negative Consequences

- Lack of test coverage makes changes difficult to verify safely
- Until tests are written, migration carries regression risk

### Option 1: Consolidate all Python usage to a single integration, with GraalPy evaluated as the leading candidate
In this option, Python usage within WRIMS-GUI is consolidated to a single runtime, 
with GraalPy used as the primary integration approach for GUI-driven workflows 
and user-initiated execution.

GraalPy is a Python runtime included in the WRIMS-Engine project. It is supported by Oracle 
and has a clear upgrade path, and it reduces reliance on native libraries (e.g., JEP DLLs), 
uses existing project dependencies, and simplifies long-term dependency management. 
See: [GraalPy Documentation](https://www.graalvm.org/python/docs/).

**JEP (Java Embedded Python)**  
Existing usages of the JEP interface would be evaluated for migration to GraalPy. 
This may require corresponding changes in WRIMS-Engine to maintain compatibility.
An important note is that JEP does not share the bidirectionality of Java and Python
interoperability present in both JPY and GraalPy. Additionally, there is limited developer
support for both JEP and JPY when compared to the Graal ecosystem, which Oracle supports.

**JPY**  
JPY is included as part of the Vista dependency and supports Python integration for that component.
Its continued use is tied to the presence of Vista within WRIMS.

**JPython / Jython**  
Legacy dependencies such as JPython/Jython are not actively used in the bundled runtime and
are candidates for removal under a consolidated integration approach.

#### Pros:
- A single Python runtime reduces dependency complexity
- Aligns with the WRIMS-Engine Python integration approach
- GraalPy is well-supported and actively maintained
- Reduces reliance on native libraries (e.g., JEP DLLs)
- Simplifies long-term dependency management

#### Cons:
- Lack of test coverage makes migration difficult to validate
- Until tests are written, migration carries regression risk
- Requires additional effort to migrate existing Python usages
- May require coordination with WRIMS-Engine
- Some current integrations may not be fully replaceable by GraalPy
- Requires validation of compatibility with user scripts and libraries

### Option 2: Retain multiple integrations with updates and selective removal
In this option, WRIMS-GUI continues to support multiple Python integrations, with updates applied
to supported libraries and removal of unused or deprecated dependencies.

Current integrations have a variety of project statuses, and some may not be easily upgraded without 
a significant refactor.

#### Integration Considerations
**JEP (Java Embedded Python)**  
JEP (Java Embedded Python) is a JNI-based library which loads CPython within the WRIMS process
at runtime and is used in the Java code as an interface to Python. JEP currently provides 
interoperability between Java and Python code within the WRIMS application. The JEP DLL is 
included in the third-party bundle. This provides support for the native function method 
calls used within WRIMS-Engine. These methods interact with the CalLite 
ANN (Artificial Neural Network) interface to process model calculations. A newer version of 
JEP is available via Maven.

**JPY**  
JPY is included in the third-party module dependencies. There are no direct dependencies on the
JPY dependency specifically. However, this JAR is still important for its Python installation.
It is present for support of Vista's Python exception handling using the
PyException class. The presence of Vista in WRIMS requires the inclusion of a Python
installation in the third-party bundle. This usage can be seen in these two examples:
[RegularTimeSeries](https://github.com/CADWRDeltaModeling/dsm2-vista/blob/5115fbae9edae5fa1d90ed795687fd74e69d5051/vista/src/vista/set/RegularTimeSeries.java#L348)
[TimeFactory](https://github.com/CADWRDeltaModeling/dsm2-vista/blob/5115fbae9edae5fa1d90ed795687fd74e69d5051/vista/src/vista/time/TimeFactory.java#L255)

Vista is planned to be refactored/replaced soon. The process will involve the removal of Python
exception handling, which will eliminate the need for JPY and its associated Python installation
to be included in the bundle.

<u>JPython</u>

JPython is included in the third-party module dependencies but is not included in the bundle. This
dependency is significantly outdated, and the project has since been renamed to Jython. Replacement
with Jython may be possible but is also likely unnecessary. Initial testing suggests this 
dependency can be removed without impact, but further smoke testing should be conducted to 
confirm no regressions are introduced. Removal of this dependency is recommended.

<u>Jython</u>

Jython is being excluded from the project, as it would otherwise be included via transitive
dependency by the HEC-Monolith library. No change is necessary.

#### Pros:
- Updates dependencies to more recent versions.
- Minimal refactoring is required.
- Removes unused integrations.

#### Cons:
- No test coverage for existing Python usages.
- Until tests are written, there is a regression risk.
- Retains multiple Python integrations
- Requires continued inclusion of JEP DLL in the third-party bundle.
- Higher maintenance burden.

### Option 3: Maintain the status quo
All currently present Python integrations are maintained.

#### Pros:
- No changes are required.
- No refactoring is required.
- No additional dependencies are required.

#### Cons:
- No test coverage for existing Python usages.
- Until tests are written, there is a regression risk.
- Retains multiple Python integrations
- Requires continued inclusion of JEP DLL in the third-party bundle.
- Higher maintenance burden.
- Continued use of legacy libraries with limited support and documentation.

## References
- [GitHub Discussion #82 — Python Dependency Report](https://github.com/CentralValleyModeling/wrims-engine/discussions/82)
- [GraalPy Documentation](https://www.graalvm.org/python/docs/)
- [JEP Project on GitHub](https://github.com/ninia/jep)
