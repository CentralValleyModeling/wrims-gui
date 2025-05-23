      SUBROUTINE ZWRITX ( IFLTAB, CPATH, NPATH, IIHEAD, NIHEAD,
     * ICHEAD, NCHEAD, IUHEAD, NUHEAD, IDATA, NDATA, JTYPE,
     * IPLAN, ISTAT, LFOUND)
C
C     Main routine for writing data to DSS file
C     Written by Bill Charley, HEC, May 1988
C
C     IPLAN = 0   Always write
C     IPLAN = 1   Only write if new record
C     IPLAN = 2   Only write if old record
C
C
      INCLUDE 'zdsskz.h'
C
      INCLUDE 'zdsslz.h'
C
      INCLUDE 'zdssiz.h'
C
      INCLUDE 'zdssmz.h'
C
      INCLUDE 'zdssnz.h'
C
      INTEGER IFLTAB(*)
      INTEGER IIHEAD(*), IDATA(*)
      CHARACTER CPATH*(*)
      LOGICAL LFOUND
C
C
      ISTAT = 0
C
      IF (MLEVEL.GE.12) WRITE (MUNIT,20) IFLTAB(KUNIT), NIHEAD,
     * NCHEAD, NUHEAD, NDATA, JTYPE, IPLAN, IFLTAB(KFSIZE),
     * CPATH(1:NPATH)
 20   FORMAT (/,T8,'-----DSS---Debug: Enter ZWRITX,  Unit:',I5,/,T12,
     * 'NIHEAD:',I5,'  NCHEAD:',I5,'  NUHEAD:',I5,
     * /,T12,'NDATA:',I6,'  TYPE:',I4,'  PLAN =',I3,'  File Size:',I9,
     * /,T12,'Pathname: ',A)
C
C     Check for garbage write
      IF ((NPATH.LE.3).OR.(NPATH.GT.MAXPATH)) GO TO 920
      IF (ICHAR(CPATH(1:1)).LT.47) GO TO 920
      IF (NDATA.LE.0) GO TO 930
C
C     If we are writing over an existing record, and NUHEAD is less
C     than zero, keep the existing user header.  IUHEAD must be
C     dimensioned to at least IABS(NUHEAD)
      NUH = IABS(NUHEAD)
C
C
C     Are we in a read only state?
      IF (IFLTAB(KREADO).EQ.1) GO TO 940
C
C     Set Multiple User Access, and read the permanent
C     section of the file
      LWRITE = .TRUE.
      CALL ZMULTU ( IFLTAB, .TRUE., .TRUE.)
C
C     Check if record exists
      IF(MLEVEL.GE.14)WRITE(MUNIT,*)'-ZWRITX:  Check PATH'
      CALL ZCHECK ( IFLTAB, CPATH, NPATH, JHEAD, JDATA, LFOUND)
      IF (IFLTAB(KSTAT).NE.0) GO TO 950
C
C
C     CHECK FOR IPLAN CODES
C
      IF (IPLAN.EQ.1) THEN
      IF (LFOUND) GO TO 900
      ELSE IF (IPLAN.EQ.2) THEN
      IF (.NOT.LFOUND) GO TO 910
      ELSE
      ENDIF
C
C
      ITYPE = JTYPE
C
C     If the pathname was not found by ZCHECK write new pointers
C
      IF (.NOT.LFOUND) THEN
C
      CALL ZNWRIT (IFLTAB, CPATH, NPATH, NIHEAD, NCHEAD, NUH, NDATA)
C
      ELSE
C
C  **** RE-WRITE OLD RECORD ****
      IF (LPROTC) GO TO 900
C
      IF ((NUHEAD.LT.0).AND.(JHEAD.GT.0)) THEN
      NUH = MIN0 (NUH, JHEAD)
      CALL ZRDINF (IFLTAB, CPATH, NH, ND, I)
      CALL ZGTREC (IFLTAB, IUHEAD, NUH, INFO(NPPWRD+KIAUHE), .FALSE.)
      ENDIF
C
      CALL ZOWRIT (IFLTAB, CPATH, NPATH, NIHEAD, NCHEAD, NUH,
     * NDATA)
C
      ENDIF
      IF (IFLTAB(KSTAT).NE.0) GO TO 950
C
C
C     The Pathname Bin and Information Blocks have been updated
C     Store the header and data arrays
C
C     Store the header array
      IF(MLEVEL.GE.14)WRITE(MUNIT,*)'-ZWRITX:  Store header arrays'
      IF (NIHEAD.GT.0)
     *CALL ZPTREC (IFLTAB, IIHEAD, NIHEAD, INFO(NPPWRD+KIAIHE), .FALSE.)
      IF (NCHEAD.GT.0)
     *CALL ZPTREC (IFLTAB, ICHEAD, NCHEAD, INFO(NPPWRD+KIACHE), .FALSE.)
      IF (NUH.GT.0)
     *CALL ZPTREC (IFLTAB, IUHEAD, NUH, INFO(NPPWRD+KIAUHE), .FALSE.)
C
C     Store the data array
      IF(MLEVEL.GE.14)WRITE(MUNIT,*)'-ZWRITX:  Store data'
      CALL ZPTREC (IFLTAB, IDATA, NDATA, INFO(NPPWRD+KIADAT), .FALSE.)
C
      IF (MLEVEL.GE.3) THEN
      IF (L80COL) THEN
      WRITE ( MUNIT,510) CPATH(1:NPATH)
 510  FORMAT(' --ZWRITE: ',A)
      ELSE
      WRITE (MUNIT,520)IFLTAB(KUNIT), INFO(NPPWRD+KIVER), CPATH(1:NPATH)
 520  FORMAT(' -----DSS---ZWRITE Unit',I4,'; Vers.',I5,':',2X,A)
      ENDIF
      ENDIF
C
 800  CONTINUE
C     Make sure that all information has been physically written
C     to the disk (request a buffer dump), and
C     Release the file for multiple user access
      CALL ZMULTU ( IFLTAB, .FALSE., .TRUE.)
C
      IF (MLEVEL.GE.12) WRITE (MUNIT,820) LFOUND, IFLTAB(KFSIZE)
 820  FORMAT(T8,'-----DSS---Debug: EXIT ZWRITX',/,T12,
     * 'FOUND ',L1,'  FILE SIZE =',I9)
*      CALL FLUSH(MUNIT)                                       Mu
      LWRITE = .FALSE.
      LPROTC = .FALSE.
C
      RETURN
C
 900  CONTINUE
      IF (MLEVEL.GE.2) WRITE (MUNIT, 901) CPATH(1:NPATH)
 901  FORMAT (' -----DSS---ZWRITE;  Record Already Exists',/,
     * ' IPLAN set to write for new records only (no data written)',/,
     * ' Pathname: ',A)
      ISTAT = -2
      GO TO 800
C
 910  CONTINUE
      IF (MLEVEL.GE.2) WRITE (MUNIT, 911) CPATH(1:NPATH)
 911  FORMAT (' -----DSS---ZWRITE;  Record Does Not Exist',/,' IPLAN',
     * ' set to write for existing records only (no data written)',/,
     * ' Pathname: ',A)
      ISTAT = -1
      GO TO 800
C
 920  CONTINUE
      IF (MLEVEL.GE.1) WRITE (MUNIT, 921) CPATH(1:NPATH)
 921  FORMAT (' -----DSS---ZWRITE:  ERROR;  Invalid Pathname',/,
     * ' Pathname: ',A)
      ISTAT = -10
      GO TO 800
C
 930  CONTINUE
      IF (MLEVEL.GE.1) WRITE (MUNIT, 931) NDATA, CPATH(1:NPATH)
 931  FORMAT (' -----DSS---ZWRITE:  ERROR;  Invalid Number of Data:',
     * I8,/,' Pathname: ',A)
      ISTAT = -11
      GO TO 800
C
C
 940  CONTINUE
      IF (MLEVEL.GE.1) WRITE (MUNIT, 941) CPATH(1:NPATH)
 941  FORMAT (' -----DSS---ZWRITE:  ERROR;  File has Read Access Only',
     * /,' Pathname: ',A)
      ISTAT = -12
      GO TO 800
C
C
 950  CONTINUE
      ISTAT = IFLTAB(KSTAT)
      IF (MLEVEL.GE.1) WRITE (MUNIT, 951) ISTAT, CPATH(1:NPATH)
 951  FORMAT (' -----DSS---ZWRITE:  ERROR;  Unable to store data,',
     * '  status:',I5,/,' Pathname: ',A)
      GO TO 800
C
      END
