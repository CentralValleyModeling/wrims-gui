      SUBROUTINE ZMATCA (CPATH, IBPART, IEPART, ILPART, CCDATE, CCPROG,
     * LMATCH)
C
C     See if these pathname parts match those specified by the
C     selective catalog feature
C
C     Written by Bill Charley at HEC, 1989
C
      CHARACTER CPATH*(*), CCDATE*(*), CCPROG*(*)
      INTEGER IBPART(6), IEPART(6), ILPART(6)
      LOGICAL LMATCH
C
      INCLUDE 'zdssca.h'
C
      INCLUDE 'zdsscc.h'
C
      INCLUDE 'zdssmz.h'
C
C
C
      IF (MLEVEL.GE.12) WRITE (MUNIT,20)
 20   FORMAT (T8,'-----DSS---Debug:  Enter ZMATCA')
      LMATCH = .FALSE.
      CALL CHRLNB(CPATH, NPATH)
C
C     Scan (index) for a string in the path
      IF (NSINDEX.GT.0) THEN
         IF (INDEX(CPATH, CSINDEX(1:NSINDEX)).GT.0)
     *      LMATCH = .TRUE.
      ENDIF
C
C
      DO 190 I=1,6
      IF (JPART(1,I).EQ.1) GO TO 190
      IPLEN = JPART(2,I)
      IB = IBPART(I)
      IE = IEPART(I)      
      GO TO (190,110,120,130,140,150,160,170,180),JPART(1,I)
C
C        NAME    - Parts must be identical
 110  CONTINUE
      IF (IE.GT.NPATH) GO TO 800
      IF (ILPART(I).NE.IPLEN) GO TO 800      
      IF (IPLEN.EQ.0) GO TO 190
      IF (CPART(I)(1:IPLEN).NE.CPATH(IB:IE)) GO TO 800
      GO TO 190
C
C        NAME@   - Part must start with these characters
 120  CONTINUE
      JLEN = IB+IPLEN-1
	IF (JLEN.GT.NPATH) GO TO 800
      IF (CPART(I)(1:IPLEN).NE.CPATH(IB:IB+IPLEN-1)) GO TO 800
      GO TO 190
C
C        @NAME   - Part must end with these characters
 130  CONTINUE
      IF (IPLEN.GT.ILPART(I)) GO TO 800
      IF (IE.GT.NPATH) GO TO 800
      IF (CPATH(IE-IPLEN+1:IE).NE.CPART(I)(1:IPLEN)) GO TO 800
      GO TO 190
C
C        @NAME@  - Part must contain this line segment
 140  CONTINUE
      IF (IE.GT.NPATH) GO TO 800
      M = INDEX ( CPATH(IB:IE), CPART(I)(1:IPLEN))
      IF (M.EQ.0) GO TO 800
      GO TO 190
C
C        #NAME   - Part must not be identical
 150  CONTINUE
      IF ((ILPART(I).EQ.IPLEN) .AND.
     * (CPART(I)(1:IPLEN).EQ.CPATH(IB:IE))) GO TO 800
      GO TO 190
C
C        #NAME@  - Part must not start with these characters
 160  CONTINUE
      IF (IPLEN.GT.ILPART(I)) GO TO 800
      IF (CPART(I)(1:IPLEN).EQ.CPATH(IB:IB+IPLEN-1)) GO TO 800
      GO TO 190
C
C        #@NAME  - Part must not end with these characters
 170  CONTINUE
      IF (IPLEN.GT.ILPART(I)) GO TO 190
      IF (CPATH(IE-IPLEN+1:IE).EQ.CPART(I)(1:IPLEN)) GO TO 800
      GO TO 190
C
C        #@NAME@ - Part must not contain this line segment
 180  CONTINUE
      IF (IPLEN.GT.ILPART(I)) GO TO 800
      M = INDEX (CPATH(IB:IE), CPART(I)(1:IPLEN))
      IF (M.NE.0) GO TO 800
      GO TO 190
C
C     So far, this pathname matches ok.
 190  CONTINUE
C
C     Should we compare the last written date?
      IF (ILWFLG.GT.0) THEN
C     Yes.  Get the date of this record
      CALL DATJUL (CCDATE, JULCC, IERR)
      IF (IERR.NE.0) GO TO 800
      IF (ILWFLG.EQ.1) THEN
      IF (JULCC.GE.JULLW) GO TO 800
      ELSE IF (ILWFLG.EQ.2) THEN
      IF (JULCC.NE.JULLW) GO TO 800
      ELSE IF (ILWFLG.EQ.3) THEN
      IF (JULCC.LE.JULLW) GO TO 800
      ENDIF
      ENDIF
C
C     Should we compare the name of the program that wrote this record?
      IF (LSPROG) THEN
      IF (CSPROG(1:6).NE.CCPROG(1:6)) GO TO 800
      ENDIF
C
C     Made it through all the tests!
C     This pathname matches
      LMATCH = .TRUE.
C
 800  CONTINUE
      IF (MLEVEL.GE.12) WRITE (MUNIT,820) LMATCH, CPATH
 820  FORMAT (T8,'-----DSS---Debug:  Exit ZMATCA,  Match: ',L1,/,
     * ' Pathname: ',A)
      RETURN
      END
