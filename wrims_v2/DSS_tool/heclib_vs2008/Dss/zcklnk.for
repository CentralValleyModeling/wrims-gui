      SUBROUTINE ZCKLNK (IFLTAB, NERROR)
C
C     Check a DSS file's Links for possible errors.
C     (Can find all the records_.
C
C     Written by Bill Charley at HEC, 1993.
C
C
C
      INCLUDE 'zdsskz.h'
C
      INCLUDE 'zdsslz.h'
C
      INCLUDE 'zdssnz.h'
C
      INCLUDE 'zdssiz.h'
C
      INCLUDE 'zdsscz.h'
C
      INCLUDE 'zdssmz.h'
C
C
      CHARACTER CPATH*400
      INTEGER IFLTAB(*), IARRAY(NBSIZE)
      LOGICAL LFOUND
      INTEGER NPSTATS(15), NMOVED
C
C
C
      IF (MLEVEL.GE.12) WRITE (MUNIT,20) IFLTAB(KUNIT)
 20   FORMAT (T8,'-----DSS---Debug:  Enter ZCKLNK;  Unit:',I5)
C
C     Check that IFLTAB is valid (e.g., the DSS file is open)
      IF (IFLTAB(1).NE.6) THEN
      IF (MLEVEL.GE.1) WRITE (MUNIT, 30)
 30   FORMAT (/,' ERROR:  DSS File is not version 6, or file is not',
     * ' open.',/,' Only a version 6 DSS file can be checked.',/)
      GO TO 880
      ENDIF
C
C     Lock the file so we don't get erroneous results during
C     the check
      CALL ZMULTU (IFLTAB, .TRUE., .TRUE.)
      CALL ZSET ('ABORT', 'OFF', I)
C
C     Search for all information blocks in the file.
      NERROR = 0
      NMOVED = 0
      DO 38 I=1,15
         NPSTATS(I) = 0
 38   CONTINUE
C
C     Get the number of physical records in file (not data recs)
      IADD = IFLTAB(KFSIZE) - 1
      CALL ZGETRW (IADD, NRECS, IW)
C
      DO 200 IREC=2,NRECS
C
C     Read physical record IREC from file
      CALL ZGETAD (IADD, IREC, 1)
      CALL ZGTREC (IFLTAB, IARRAY, NBSIZE, IADD, .FALSE.)
C
C     Search through this record, looking for pathname flags
C
      DO 200 IWRD=1,NBSIZE
C
      IF (IARRAY(IWRD).EQ.NPFLAG) THEN
C
C     Found a flag - Get the first three words of the information
C     block to see if this indeed is the start of a data record
      CALL ZGETAD (IADD, IREC, IWRD)
      CALL ZGTREC ( IFLTAB, INFO, 3, IADD, .FALSE.)
C
      IPSTAT = INFO(KISTAT)
      IF ((IPSTAT.GE.1).AND.(IPSTAT.LE.15)) THEN
         NPSTATS(IPSTAT) = NPSTATS(IPSTAT) + 1
      ELSE IF (IPSTAT.EQ.-1) THEN
        NMOVED = NMOVED + 1
      ENDIF
C
C     Check for a valid status flag (1)
      IF ((IPSTAT.EQ.1).OR.(IPSTAT.EQ.11)) THEN
C     Check for a valid pathname length
      NPATH = INFO(KINPAT)
      IF ((NPATH.GT.4).AND.(NPATH.LE.392)) THEN
C
C     Passed, therefore a valid record - Get the full information block
      NPPWRD = (NPATH - 1)/NCPW + 1
      NPMWRD = (NPATH - 1)/NCMW + 1
      CALL ZGTREC ( IFLTAB, INFO, NINFO+NPPWRD, IADD, .FALSE.)
C
C     Get the pathname
      CPATH = ' '
      CALL HOL2CH (INFO(KIPATH), CPATH, NPMWRD)
C
      CALL ZCHECK (IFLTAB, CPATH, NPATH, NHEAD, NDATA, LFOUND)
C
      IF (LFOUND) THEN
      JADD = IPNBIN (JPNBIN+NPPWRD+KBAINF)
C
      IF (JADD.NE.IADD) THEN
      IF (MLEVEL.GE.1) WRITE (MUNIT, 100) CPATH(1:NPATH), JADD, IADD
 100  FORMAT (/' *** ZCKLNK:  Lost address link.  Bin address does not',
     * ' match info address',/,' Pathname: ',A,/,
     * ' Bin address:',I12,',  Info address:',I12)
      NERROR = NERROR + 1
      ELSE
      IF (MLEVEL.GE.7) WRITE (MUNIT, 120) CPATH(1:NPATH)
 120  FORMAT (' Record Checks: ',A)
      ENDIF
C
      ELSE
      IF (MLEVEL.GE.1) WRITE (MUNIT, 140) CPATH(1:NPATH)
 140  FORMAT(/' *** ZCKLNK:  Lost address link.  Unable to find record',
     * /,' Pathname: ',A)
      NERROR = NERROR + 1
      ENDIF
C
      ENDIF
      ENDIF
      ENDIF
C
C
C
 200  CONTINUE
C
C
 800  CONTINUE
C
      NTOTAL = NPSTATS(1) + NPSTATS(11)
      IF (NTOTAL.NE.IFLTAB(KNRECS)) THEN
      NERROR = NERROR + 1
      IF (MLEVEL.GE.1) WRITE (MUNIT, 810) IFLTAB(KNRECS), NTOTAL
 810  FORMAT (' *** ZCKLNK:  Inconsistency in the number of records',
     * ' in the file.',/,' Number Recorded: ',I6,',  Number Found:',I6)
      ENDIF
C
      IF ((MLEVEL.GE.1).AND.(NERROR.GT.0)) WRITE (MUNIT, *)' '
      IF (MLEVEL.GE.1) WRITE (MUNIT, 820) NERROR
 820  FORMAT (' Pathname Link Check Complete,',I4,' Errors found.')
      IF (MLEVEL.GE.3) WRITE (MUNIT, 830) (NPSTATS(I),I=1,4), NMOVED
 830  FORMAT (' Number of Records:        ',I7,/,
     * ' Number of Deleted Records: ',I7,/,
     * ' Number of Renamed Records: ',I7,/,
     * ' Number of Replaced Records:',I7,/,
     * ' Number of Moved Records:   ',I7)
C
      IF (MLEVEL.GE.3) WRITE (MUNIT, 840) (NPSTATS(I),I=11,14)
 840  FORMAT (' Number of Long Pathname Records:        ',I7,/,
     * ' Number of Deleted Long Pathname Records: ',I6,/,
     * ' Number of Renamed Long Pathname Records: ',I6,/,
     * ' Number of Replaced Long Pathname Records:',I6)
C
      CALL ZMULTU (IFLTAB, .FALSE., .TRUE.)
      CALL ZSET ('ABORT', 'ON', I)
C
 880  CONTINUE
      IF (MLEVEL.GE.12) WRITE (MUNIT,890) IFLTAB(KUNIT)
 890  FORMAT (T8,'-----DSS---Debug:  Exit ZCKLNK;   Unit:',I5)
C
      RETURN
C
      END
