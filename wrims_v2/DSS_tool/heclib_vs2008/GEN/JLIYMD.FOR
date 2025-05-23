      INTEGER FUNCTION JLIYMD (JUL,IYR,IMON,IDAY)
C
      INTEGER*4 JUL, IYMDJL, IBASE, JUL2, JULB, JULC                    ML
      DATA IBASE /693960/
C
      JLIYMD = 0
C
      JULC=JUL+IBASE
      IYR=FLOAT(JULC)/365.2425
      IF (IYR.LT.0) GO TO 80
      DO 5 I=1,20
      JUL2=IYMDJL(IYR,1,1)
      IF(JUL2.GT.JUL) GO TO 7
      IYR=IYR+1
5     CONTINUE
      GO TO 80
C
7     IYR=IYR-1
      JULB=IYMDJL(IYR,1,1)
      JA=MIN0(12,(JUL-JULB+28)/28)
      DO 10 IMON=JA,12
      JUL2=IYMDJL(IYR,IMON,1)
      IF(JUL2.GT.JUL) GO TO 20
10    CONTINUE
      IMON=13
 20   IMON=IMON-1
      JUL2=IYMDJL(IYR,IMON,1)
      IDAY=JUL-JUL2+1
      GO TO 90
C
C     Invalid julian day, error
80    JLIYMD = -1
      IYR = 0
      IMON = 0
      IDAY = 0
C
90    CONTINUE
      RETURN
      END
