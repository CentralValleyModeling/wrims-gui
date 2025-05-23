      SUBROUTINE ZGINTL (INTL, CHINTL, NODATA, ISTAT)
C
C     Get Interval for time series data
C     Get either a character from a number or visa versa
C
C     INPUT:
C            ISTAT = 1, GETS INTEGER INTERVAL FROM ALPHA (INTLAL)
C            ISTAT = 2, GETS ALPHA INTERVAL FROM INTEGER (INTL)
C            ISTAT = 3, Begin a list of valid E parts
C            ISTAT = 4, In a list of valid E parts (returns -1 at end)
C
C     OUTPUT:
C         ISTAT = 0, IF REGULAR INTERVAL TIME SERIES DATA
C         ISTAT = 1, IF IRREGULAR INTERVAL (NO INTERVAL VALUE RETURNED)
C         ISTAT = -1, DATA OTHER THAN TIME SERIES
C
C
      PARAMETER (MAXINT=29)
      INTEGER NVALS(MAXINT)
      INTEGER   JVALS(MAXINT), INTL
      CHARACTER*(*) CHINTL
      CHARACTER*10 CVALS(MAXINT)
      CHARACTER CINTERVAL*4
      INTEGER ILIST
      SAVE ILIST
C
      DATA JVALS /525600, 43200, 21600, 14400, 10080, 1440,
     * 720, 480, 360, 240, 180, 120, 60, 30, 20, 15, 12, 10,
     * 6,  5, 4, 3, 2, 1, -5, -4, -3, -2, -1/
      DATA NVALS /100, 120, 240, 360, 522, 366, 62, 93, 124,
     * 186, 248, 372, 744,  1488, 2232, 2976, 120, 144, 240,
     * 288, 360, 480, 720, 1440, 0, 0, 0, 0, 0/
      DATA CVALS/ '1YEAR',  '1MON',    'SEMI-MONTH', 'TRI-MONTH',
     * '1WEEK',  '1DAY',    '12HOUR',  '8HOUR',
     * '6HOUR',  '4HOUR',   '3HOUR',   '2HOUR',
     * '1HOUR',  '30MIN',   '20MIN',   '15MIN',
     * '12MIN',  '10MIN',   '6MIN',    '5MIN',
     *  '4MIN',  '3MIN',    '2MIN',    '1MIN',
     * 'IR-CENTURY', 'IR-DECADE ', 'IR-YEAR  ',
     * 'IR-MONTH  ', 'IR-DAY    '/
C
C
C
      IF (ISTAT .EQ. 1) GO TO 30
      IF (ISTAT .EQ. 2) GO TO 200
      IF (ISTAT .EQ. 3) GO TO 300
      IF (ISTAT .EQ. 4) GO TO 320
      ISTAT=-1
      RETURN
C
C     CONVERT ALPHA TO INTEGER INTERVAL
 30   CONTINUE
      CINTERVAL = CHINTL(1:4)
      CALL UPCASE(CINTERVAL)
      DO 70 I =1,MAXINT
         IF (CINTERVAL .EQ. CVALS(I)(1:4)) THEN
              INTL = JVALS(I)
              NODATA = NVALS(I)
              IF (I .GE. MAXINT-4) THEN
                   ISTAT = 1
              ELSE
                   ISTAT = 0
              END IF
              RETURN
         END IF
   70    CONTINUE
      ISTAT = -1
      RETURN
C
C     CONVERT INTEGER INTERVAL TO ALPHA
  200 DO 210 I =1,MAXINT-5
         IF (JVALS(I) .EQ. INTL) THEN
              CHINTL = CVALS(I)
              NODATA = NVALS(I)
              ISTAT = 0
              RETURN
              END IF
  210    CONTINUE
      ISTAT = -1
      RETURN
C
C
C     Return a list of valid E parts
 300  CONTINUE
      ILIST = 0
 320  CONTINUE
      ILIST = ILIST + 1
      IF (ILIST.GT.MAXINT) THEN
          CHINTL = ' '
          INTL = 0
          NODATA = 0
          ISTAT = -1
          RETURN
      ENDIF
C
C     Try to put the list in a nice order
      I = MAXINT - ILIST + 1
      CHINTL = CVALS(I)
      NODATA = NVALS(I)
      INTL = JVALS(I)
      IF (ILIST.EQ.MAXINT) THEN
          ISTAT = 0
      ELSE
          ISTAT = 4
      ENDIF
      RETURN
      RETURN
C
      END
