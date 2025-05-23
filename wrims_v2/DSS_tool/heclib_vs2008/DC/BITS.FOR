      SUBROUTINE BITS  ( IARRAY, IBITNO, ISET, LGET)
C
C     Get or set bit.  If change, then
C     change bit IBITNO of IARRAY on (if ISET=1), or
C     off (if ISET=0).
C
      LOGICAL LGET, LBTEST
C
      COMMON /WORDS/ NCMW, NCPW, IWDS(8)
C
C
C --- DETERMINE BIT AND BYTE POSITION OF 'IBITNO' IN ARRAY IN 'IARRAY'
C
      IBYTE = ((IBITNO - 1)/ 8) + 1
      NBITP = IBITNO - ((IBYTE - 1) * 8) - 1
      IF (NBITP.LE.-1) NBITP = 7
C
C --- SINCE BYTES ARE STORED IN REVERSE ORDER IN HARRIS INTEGER*6
C --- WORDS, DETERMINE THE NEW BYTE POSITION FOR INTEGER*6
C
C     IWRD = ((IBITNO - 1) / (8*NCPW)) + 1                              H
C     IBYTE = (2 * IWRD * NCPW) - IBYTE - 5                             H
C
C
C --- KNOWING THE PROPER BIT AND BYTE POSITION OF 'IBITNO' IN 'IARRAY',
C --- CLEAR THE BIT
C
      CALL GETHOL ( IARRAY, IBYTE, ISAV )
C
      IF (LGET) THEN
C
      IF (LBTEST(ISAV,NBITP)) THEN
      ISET = 1
      ELSE
      ISET = 0
      ENDIF
C
      ELSE
C
      IF (ISET.EQ.0) THEN
      ISAV = IBCLR( ISAV, NBITP )
      ELSE
      ISAV = IBSET( ISAV, NBITP )
      ENDIF
      CALL PUTHOL ( IARRAY, IBYTE, ISAV )
      ENDIF
C
C
      RETURN
      END
