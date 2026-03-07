# Python Usages within WRIMS-GUI

## Libraries
Multiple Python libraries are used within WRIMS-GUI for various purposes. 
Some are included due to requirements of dependency libraries.
More information on Python usage within WRIMS-Engine can be found in its respective documentation.

## Previous Reports
The initial report on Python usage within the WRIMS project can be found here:
[GitHub Discussion](https://github.com/CentralValleyModeling/wrims-engine/discussions/82).
Please note that some information in this report is outdated.

### JEP (Java Embedded Python)
#### Background
JEP (Java Embedded Python) is a JNI-based library which loads CPython within the WRIMS process
at runtime and is used in the Java code as an interface to Python. JEP currently provides 
interoperability between Java and Python code within the WRIMS application. The JEP DLL is 
included in the third-party bundle. This provides support for the native function method 
calls used within WRIMS-Engine. These methods interact with the CalLite 
ANN (Artificial Neural Network) interface to process model calculations.

#### Solution
Usages of the JEP interface may be refactored to use GraalPy’s interfaces. 
Alternatively, JEP can be updated to a recent version distributed via Maven. 
An important note is that JEP does not share the bidirectionality of Java and Python
interoperability present in both JPY and GraalPy. Additionally, there is limited developer 
support for both JEP and JPY when compared to the Graal ecosystem, which Oracle supports.

### JPY
#### Background
JPY is included in the third-party module dependencies. There are no direct dependencies on the 
JPY dependency specifically. However, this JAR is still important for its Python installation. 
It is present for support of Vista's Python exception handling using the 
PyException class. The presence of Vista in WRIMS requires the inclusion of a Python 
installation in the third-party bundle. This usage can be seen in these two examples:
[RegularTimeSeries](https://github.com/CADWRDeltaModeling/dsm2-vista/blob/5115fbae9edae5fa1d90ed795687fd74e69d5051/vista/src/vista/set/RegularTimeSeries.java#L348)
[TimeFactory](https://github.com/CADWRDeltaModeling/dsm2-vista/blob/5115fbae9edae5fa1d90ed795687fd74e69d5051/vista/src/vista/time/TimeFactory.java#L255)

#### Solution
Vista refactoring/replacement is planned to occur soon. The process will involve the removal 
of Python exception handling, which will eliminate the need for JPY and its associated Python 
installation to be included in the bundle.

### JPython
#### Background
JPython is included in the third-party module dependencies but is not included in the bundle. 

#### Solution
Initial testing suggests this dependency can be removed without impact, but further smoke 
testing should be conducted to confirm no regressions are introduced.

### Jython
#### Background
Jython is being excluded from the project, as it would otherwise be included via transitive
dependency by the HEC-Monolith library.