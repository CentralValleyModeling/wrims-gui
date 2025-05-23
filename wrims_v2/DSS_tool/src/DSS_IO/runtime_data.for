      module runtime_data
      use type_defs
c-----dates, timestep
c-----Note: julian minutes are minutes from 01jan1900 0000 (31dec1899 2400)
      integer
     &     max_print_dates      ! maximum number of start/stop output date/times            
     &     ,time_step           ! time step in minutes
     &     ,prev_time_step      ! previous time step in minutes
      integer :: nprints = 1    ! number of start/stop output date/times


      integer*4
     &     julmin               ! current model time in julian minutes
     &     ,prev_julmin         ! previous model time in julian minutes
     &     ,start_julmin        ! model start time, julian minutes
     &     ,end_julmin          ! model end time, julian minutes
     &     ,jul_generic_date    ! julian minute of generic_dt
     &     ,tf_start_julmin     ! (hydro) when to start writing tidefile, jul mins

      parameter (
     &     max_print_dates=10
     &     )
      character*14 :: current_date = ' '   ! current date/time (corresponds to julmin)
      character*14 :: run_start_date = ' ' ! date/time of start of run
      character*14 :: run_end_date = ' '   ! date/time of end of run
      character*14 :: tf_start_date = ' '  ! (hydro) date/time of when to start writing tidefile
      character*14 :: print_start_date(max_print_dates) = ' '! date/time of print starts
      character*14 :: print_end_date(max_print_dates) = ' ' ! date/time of print ends

c-----alternate method: instead of start/end dates, specify run length
c-----in form, e.g. 5day_3hour.  Model will generate end date/times.
      character*80 :: run_length = ' '

c-----time step
      character*80 :: time_step_intvl_hydro = ' '
      character*80 :: time_step_intvl_qual = ' '
      character*80 :: time_step_intvl_ptm = ' '

c-----flush output interval
      character*80 :: flush_intvl = '5DAY'

c-----display time interval
      character*80 :: display_intvl = ' '
      
      
c-----Program name and version number, set in the main routine
c-----of Hydro, Qual and PTM

      character*5 dsm2_name
      character*7 dsm2_version
     &     ,restart_version     ! the version of the program that produced the restart file
     &     ,tidefile_version    ! the version of the program that produced the tidefile


c-----runtime identification and run date/time, set in read_fixed
      integer*4
     &     dsm2_module          ! module ID
     &     ,irid                ! run ID as integer
     &     ,irdt                ! run date/time as integer: YYMMDDhhmm
      character
     &     crid*13              ! run ID as character
     &     ,crdt14*14           ! run date/time as character: DDMMMYYYY hhmm
     &     ,crdt10*10           ! run date/time as character: YYMMDDhhmm
      
c-----input sections structure
      type(form_t) hdr_form(max_sections)

c-----titles
      integer
     &     max_titles           ! maximum number of titles allowed
     &     ,ntitles             ! actual number of titles

      parameter (
     &     max_titles=30
     &     )

      character*80
     &     title(max_titles)
      
      end module

