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
- Maintainability: Prefer a single, well-supported Python integration
- Test coverage: Ensure replacements do not introduce untested regressions
- Dependency management: Prefer dependencies available via Maven/Gradle
- Future extensibility: Prefer the integration that offers the broadest future applicability

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
1. Consolidate all Python usage to a single integration. 
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

- Lack of test coverage makes changes difficult to validate
- Until tests are written, migration carries regression risk

### Option 1: Consolidate all Python usage to a single integration (GraalPy)
In this option, Python usage within WRIMS-GUI is consolidated to a single runtime, 
with GraalPy used as the primary integration approach for GUI-driven workflows 
and user-initiated execution.

GraalPy is a Python runtime included in the WRIMS-Engine project. It is supported by Oracle 
and has a clear upgrade path, and it reduces reliance on native libraries (e.g., JEP DLLs), 
uses existing project dependencies, and simplifies long-term dependency management. 
See: [GraalPy Documentation](https://www.graalvm.org/python/docs/).

**JEP (Java Embedded Python)**  
Existing usages of the JEP would be migrated to GraalPy. 
This may require corresponding changes in WRIMS-Engine to maintain compatibility.
JEP does not share the bidirectionality of Java and Python interoperability present in both JPY and GraalPy.
Additionally, there is limited developer support for both JEP and JPY when compared to the Graal ecosystem, which Oracle supports.

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

Current integrations vary in maturity and may require significant refactoring to upgrade.

#### Integration Considerations
**JEP (Java Embedded Python)**  
JEP is a JNI-based library that loads CPython natively within the WRIMS process at runtime and provides Java–Python interoperability.  
This introduces native runtime dependencies and tighter coupling to platform-specific packaging and deployment requirements.  
The JEP DLL is included in the third-party bundle, requiring distribution of platform-specific binaries with WRIMS-GUI.  

A newer version is available via Maven, but upgrading may require refactoring due to API changes.  

JEP supports integration between WRIMS-GUI and external components, including WRIMS-Engine and related model workflows such as ANN-based calculations.  
Changes to this integration may affect interoperability with existing modules that depend on this interface.  

**JPY**  
JPY is included as part of the Vista dependency and provides Python integration for that component.  
Its presence requires a Python runtime to be included in the WRIMS-GUI distribution.  

The continued use of JPY is tied to the presence of Vista within WRIMS, which is planned to be refactored or replaced.  
Removal of JPY may be possible once Vista is no longer required.

**JPython / Jython**
JPython is included in the third-party module dependencies but is not included in the bundled runtime. 
This dependency is significantly outdated and has since been renamed to Jython. 

Jython is being excluded from the project, as it would otherwise be included via a transitive dependency 
from the HEC-Monolith library. 

Initial testing suggests that this dependency can be removed without impact, but further smoke testing 
should be conducted to confirm no regressions are introduced. Removal of this dependency is recommended.

#### Pros:
- Maintains compatibility with existing integrations and workflows  
- Allows incremental updates with lower immediate migration effort  
- Removes unused or deprecated dependencies where possible  
- Preserves existing integration paths while reducing some dependency risk
  
#### Cons:
- Retains multiple Python integrations  
- Continues native dependency and packaging complexity (e.g., JEP DLL and bundled Python runtime)  
- Increases long-term maintenance burden  
- Lack of test coverage makes changes difficult to validate  
- Until tests are written, changes carry regression risk

### Option 3: Maintain the status quo
In this option, all currently present Python integrations are retained without modification.

#### Pros:
- No changes are required  
- Preserves current functionality and behavior  
- No immediate development effort required

#### Cons:
- Retains multiple Python integrations  
- Continues native dependency and packaging complexity (e.g., JEP DLL)  
- Increases long-term maintenance burden  
- Lack of test coverage makes current behavior difficult to validate  
- Until tests are written, continued use carries regression risk  
- Continued reliance on legacy libraries with limited support and documentation  

## References
- [GitHub Discussion #82 — Python Dependency Report](https://github.com/CentralValleyModeling/wrims-engine/discussions/82)
- [WRIMS-Engine Python ADR](https://github.com/CentralValleyModeling/wrims-engine/blob/main/docs/design-records/python-usage.md)
- [GraalPy Documentation](https://www.graalvm.org/python/docs/)
- [JEP Project on GitHub](https://github.com/ninia/jep)
- [JPY Project](https://github.com/bcdev/jpy)
- [Jython Project](https://www.jython.org/)
