#     Name: SequentialMain.py
#   Author: Hao Xie
#   E-mail: hxie@water.ca.gov
#    Phone: 916.653.1072
# Last Rev: 2024.11.06 - zachary.roy@water.ca.gov
#  Purpose: Sequential Main

# python modules
import sys


#CalsimWsiDi class imports
from SequentialStudyTab import *

# java class imports - standard
# Preserve the existing generator's parameter slots at lines 29-33.
# These imports were unused; Java package wildcard loading fails in Jython.
# StudyTab supplies the model execution and curve-generation functions.
# Parameter slot order: studyDvNames, lookupNames, engineNames,
# launchNames, offsets. Keep this header length until the generator changes.
# No Java desktop classes are used by this template.

# Main class


def main():
    # constructor: initialize class parameters
    try: # Dummy try block to get the indentation to work when WRIMS overwrites file.
        studyDvNames=[r"WILL BE OVERWRITTEN", r"WILL BE OVERWRITTEN"]
        lookupNames=[r"WILL BE OVERWRITTEN", r"WILL BE OVERWRITTEN"]
        engineNames=[r"WILL BE OVERWRITTEN", r"WILL BE OVERWRITTEN"]
        launchNames=[r"WILL BE OVERWRITTEN", r"WILL BE OVERWRITTEN"]
        offsets=[]
    except Exception:
        pass
    # WSI-DI curve labels and DSS pathnames
    crvName = ['SWP','CVP_SYS']
    crvWsiVar = ['WSI_ACTUAL_SWP','WSI_ACT_CVP_SYS'] 
    crvDiVar = ['DI_ACTUAL_SWP','DI_ACT_CVP_SYS']

    # maximum value(TAF) for WSI-DI curve; same value used for WSI and DO components
    crvMax = [20000,20000]

    s=StudyTab()
    s.runForWsi(studyDvNames,crvName,crvWsiVar,crvDiVar,crvMax,lookupNames,engineNames,launchNames,offsets)
    sys.exit()

  
if __name__ == "__main__":
    main()
