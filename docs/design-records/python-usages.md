# Python Runtime Integration in WRIMS-GUI

## Status

Proposed

## Context and Problem Statement
WRIMS-GUI requires Python interoperability for certain computation capabilities, library 
dependencies, and legacy UI features. Multiple Python runtime integrations are currently 
present in the project: ** JEP (Java Embedded Python) **, ** JPY **, ** JPython **, 
and ** Jython **. There is a need to decide which integrations to keep and which to remove, 
with the goal of consolidating the project's Python usage.

> Note: More information on Python usage within WRIMS-Engine can be found in its respective documentation.

The initial dependency analysis report on Python usage within the WRIMS project can be found here:
[GitHub Discussion #82](https://github.com/CentralValleyModeling/wrims-engine/discussions/82).

> Note: Some information in the linked discussion report may be outdated.

## Decision Drivers
- Maintainability: prefer a single, well-supported Python integration.
- Test coverage: any replacement must not introduce untested regressions.
- Dependency management: prefer dependencies available via Maven/Gradle.
- Future extensibility: prefer the integration that offers the broadest future applicability.

## Considered Options
1. Consolidate all Python usage to a single integration. Preferred candidate is GraalPy.
2. Retain multiple integrations but update to the latest versions and remove those that are no longer needed.
3. Maintain the status quo.

## Decision Outcome

**Chosen option: TBD** *(to be decided)*

This ADR is currently in a **Proposed** state. The recommended path is to standardize
on **GraalPy** (Option 1) when adequate test coverage can be established for Python usages within
WRIMS.

### Positive Consequences

- A single Python runtime reduces dependency complexity.

### Negative Consequences

- Existing Python usages currently have **no test coverage**, making a safe
  refactor difficult to verify.
- Until tests are written, there is a regression risk.

### Option 1: Consolidate all Python usage to a single integration
GraalPy is a Python runtime included in the WRIMS-Engine project. It is supported by Oracle 
and has a clear upgrade path. See: [GraalPy Documentation](https://www.graalvm.org/python/docs/).

<u>JEP (Java Embedded Python)</u>
Usages of the JEP interface may be refactored within WRIMS-Engine to use GraalPy’s interfaces.
An important note is that JEP does not share the bidirectionality of Java and Python
interoperability present in both JPY and GraalPy. Additionally, there is limited developer
support for both JEP and JPY when compared to the Graal ecosystem, which Oracle supports.

<u>JPY</u>
JPY is used by the Vista dependency for its Python installation. Inclusion of GraalPy in this
project should allow for Vista to use the GraalPy Python runtime until Vista is refactored/replaced.

<u>JPython</u>
JPython is included in the third-party module dependencies but is not included in the bundle.
Removal of this dependency is recommended.

#### Pros:
- A single Python runtime reduces dependency complexity.
- GraalPy has extensive documentation and is well-supported.
- GraalPy is already an existing Gradle dependency in the WRIMS-Engine project.

#### Cons:
- No test coverage for existing Python usages.
- Until tests are written, there is a regression risk.
- Dependent on update to WRIMS-Engine to use GraalPy.
- Requires additional effort to migrate existing Python usages.
- Requires additional manual testing to verify no regressions are introduced for UI components and functionality.
- Some current integrations may not be fully replaceable by GraalPy.

### Option 2: Retain multiple integrations but update to the latest versions and remove those that are no longer needed
Current integrations have a variety of project statuses, and some may not be easily upgraded without 
a significant refactor.

<u>JEP (Java Embedded Python)</u>

JEP (Java Embedded Python) is a JNI-based library which loads CPython within the WRIMS process
at runtime and is used in the Java code as an interface to Python. JEP currently provides 
interoperability between Java and Python code within the WRIMS application. The JEP DLL is 
included in the third-party bundle. This provides support for the native function method 
calls used within WRIMS-Engine. These methods interact with the CalLite 
ANN (Artificial Neural Network) interface to process model calculations. A newer version of 
JEP is available via Maven.

<u>JPY</u>

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

## Option 3: Maintain the status quo
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