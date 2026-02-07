cd ..
.\bin\RFRO.exe              .\1a_RainfallRunoff\main.dat >RFRO.log
.\bin\IDCv2_1.exe           .\2a_IDC\main.dat            >IDC.log 
.\bin\RiceModel_Avg.exe     .\3a_Rice\main.dat          >Rice.log
.\bin\RiceModel_Avg.exe     .\3b_RiceAvg\main.dat       >RiceAvg.log
.\bin\RefugeModel.exe       .\4_Refuge\main.dat         >Refuge.log
.\bin\HydroIntegration.exe  .\5_HydroIntegration\main2017.dat      >HydroIntegration.log
.\bin\HydroDU.exe           .\6_HydroDiagnoseUtility\main.dat      >HydroDU.log
pause
exit

