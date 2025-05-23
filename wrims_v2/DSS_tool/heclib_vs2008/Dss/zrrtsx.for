      SUBROUTINE ZRRTSX ( IFLTAB, CPATH, CDATE, CTIME, NVALS, SVALUES,
     * JQUAL, LQUAL, LQREAD, CUNITS, CTYPE, IUHEAD, KUHEAD, NUHEAD,
     * IOFSET, JCOMP, ISTAT)
C
C     Z-Retrieve Regular interval Time-Series data
C     This routine provides an altertantive means from ZGTDTS of
C     retrieving time-series data.  Data can either be retrieved
C     according to a time window set, or all the data from the
C     pathname specified.
C
C     Input:
C        IFLTAB:  Working DSS array used in ZOPEN call.  Must be
C                 be dimensioned as INTEGER with 1200 words
C        CPATH:   Pathname of the data to be retrieved.  If a time
C                 window is specified (CDATE and CTIME), the 'D'
C                 part is ignored;  Otherwise all parts must be
C                 correct.  CPATH sould be declared as CHARACTER*80
C        CDATE:   Beginning date of the time window.  This may be
C                 a standard military style date (e.g. 01MAR74).
C                 If the data is to be retrieved without a time window
C                 (i.e. all data specified by pathname), set CDATE to
C                 all blanks, or make length short (e.g. ' ').
C        CTIME:   Beginning time of the time window.  This must be
C                 a standard 24 hour clock time (e.g. 1630).  If no
C                 time window is set, this parameter is ignored.
C                 CTIME should be declared as CHARACTER*4.
C        NVALS:   The number of data values to retrieve.  This parameter
C                 defines the end of the time window.  If the entire
C                 record is to be retrived (CDATE equal ' '), then NVALS
C                 is returned with the number of data read.  In this
C                 case, VALUES must be dimensioned large enough to
C                 hold all the data in the record, and NVALS may be
C                 the dimension of the array VALUES.
C        ISTAT:   If set to -1, don't print the ZREAD message.
C
C     Output:
C        NVALS:   The number of data retrieved.  Note that this is
C                 also and input argument.
C        VALUES:  The data retrieved.
C        CUNITS:  Character string returning the units of the data.
C                 CUNITS must be declared CHARACTER*8
C        CTYPE:   Character string returning the type of the data
C                 (e.g., PER-AVER).  CTYPE must be declared CHARACTER*8
C        IOFSET:  The time offset of the data in minutes.  If there
C                 is no offset, IOFSET is returned as zero.
C        ISTAT:   Integer status parameter, indicating the
C                 successfullness of the retrieval.
C                 ISTAT = 0  All ok.
C                 ISTAT = 1  Some missing data (still ok)
C                 ISTAT = 2  Missing data blocks, but some data found
C                 ISTAT = 3  Combination of 1 and 2 (some data found)
C                 ISTAT = 4  No data found, although a pathname was read
C                 ISTAT = 5  No pathname(s) found
C                 ISTAT > 9  Illegal call to ZRRTS
C
C     Written by Bill Charley
C
C
C     DIMENSION STATEMENTS
C
C     Argument Dimensions
      CHARACTER CPATH*(*), CTYPE*(*), CUNITS*(*), CDATE*(*), CTIME*(*)
      INTEGER IFLTAB(*), IUHEAD(*), JQUAL(*), ICDESC(6)
      REAL SVALUES(*)
      DOUBLE PRECISION DVALUES(1), COORDS(3)
      LOGICAL LFILDOB, LCOORDS
C
      KVALS = NVALS
      CALL ZRRTSI (IFLTAB, CPATH, CDATE, CTIME, KVALS, NVALS,
     * .FALSE., LFILDOB, SVALUES, DVALUES, JQUAL, LQUAL, LQREAD,
     * CUNITS, CTYPE, IUHEAD, KUHEAD, NUHEAD, IOFSET, JCOMP, 
     * COORDS, ICDESC, LCOORDS, ISTAT)
C
      RETURN
      END
