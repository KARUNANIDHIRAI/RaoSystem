package com.sm.System.SMInformation;

public class SMFixedValue {
	public static final String SAVE="Save";
	public static final String SUBMIT="Submit";
	public static final String Action="Add";
	public static final String Edit="Edit";
	public static final String View="View";
	public static final String Remove="Remove";
	public static final String New="New";
	public static final String ACTION="Action";
	public static final String CANCEL="Cancel";
	
	public static final String Summary="Summary";
	public static final String Item="Subject";
	public static final String Code=" Code";
	public static final String Name="Name";
	public static final String Master="Master";
	public static final String RegNo="School Registration No";
	public static final String Info="Information";
	public static final String School="School";
	

	public static final String Fee="Fee";
	public static final String Type="Type";
	public static final String Define="Define";
	public static final String Program="Courser Program";
	public static final String Valid="Valid";
	public static final String To="To";
	public static final String From="From";
	public static final String Class="Class";
	public static final String Amount="Amount";
	public static final String Applicable="Applicable";
	public static final String For="For";
	public static final String Choose="Choose";
	public static final String Slab="Slab";
	public static final String Range="Range";
	public static final String Grade="Grade";
	public static final String Penality="Penality";
	public static final String Discount="Discount";
	public static final String Percentage="%";
	
	public static final String Student="Student";
	public static final String Attendance="Attendance";
	public static final String Teacher="Teacher";
	public static final String Section="Section";
	public static final String Retrieve="Retrieve";
	public static final String RollNo="Roll No.";
	public static final String Subject="Subject";
	public static final String Save="Save";
	
	
	public static final String TEST="Test";
	public static final String TEST_TYPE="Type";
	public static final String PERFORMANCE="Performance";
	public static final String Report="Report";
	public static final String ADMISSION="Adimission";
	public static final String NO="No.";
	public static final String TEST_CYCLE="Cycle";
	public static final String MARKS="Marks";
	public static final String OBTAIN="Obtain";
	public static final String MAX="Max.";
	public static final String COURSE ="Course";
	public static final String DETAILS="Detail";
	public static final String CATEGORY="Category";
	public static final String HQL_RSPINFO="SELECT regNo,	fName, lName, promotedInClass, rollNo, course, section " 
                                          + " FROM  StudentPersonalInfoModel"
                                          + " WHERE regNo=:regNo AND admNo=:admNo AND status=:Fstatus";
	
	public static final String HQL_RSPROFILEINFO = " SELECT regNo, admNo,	course, promotedInClass,"
			         + " rollNo, section, dob,	fName,  lName ,	gender,		mobileNo, emailId,	"
	                 + " ffName, 	flName , mfName ,	mlName , fprofession, pEmailId,	pMobileNo"
			         + " FROM  StudentPersonalInfoModel"
					 + " WHERE regNo=:studentRegNo AND emailId=:studentEmailId  AND status=:Fstatus";
	                                           
	public static final String HQL_STUDENTLIST_CS = "SELECT regNo,	fName, lName, promotedInClass,"
			         + "rollNo, sIdNo " 
                     + " FROM  StudentPersonalInfoModel"
                     + " WHERE regNo=:regNO AND promotedInClass=:studentClass"
                     + " AND section=: studentClassSection AND status=:Fstatus";
	public static final String HQL_STUDENTLIST_CSR = "SELECT regNo,	fName, lName, promotedInClass,"
	                 + "rollNo, sIdNo " 
                     + " FROM  StudentPersonalInfoModel"
                     + " WHERE regNo=:regNO AND promotedInClass=:studentClass"
                     + " AND section=: studentClassSection AND rollNo=: studentRollNo AND status=:Fstatus";
	public static final String HQL_STUDENT_ATTENDANCE_SUMMARY ="SELECT regNo, subject, totalHours as TotalClassHours," 
                    + " (SELECT COUNT(sAIDNO) FROM StudentAttendanceModel B WHERE regNo=:regNO "
	                + " AND sClass=:studentClass AND section=:studentClassSection AND B.subject=A.subject)" 
                    + " FROM  TimeTableModel A WHERE regNo=:regNO AND classTT=:studentClass AND section=: studentClassSection"
			        + " AND status=:Fstatus";  
	 public static final String HQL_STUDENT_TEST_PERFORMANCE="SELECT rollNo, testType, testCycle, "
			        + " testCategory, subject, marksObtained, maxMarks "  
		        + " FROM TestPerformanceModel A "  
		        + " INNER JOIN MarksDetailSubModel B ON tPIDNOFk = tIdNo"
		        + " WHERE A.regNo=:regNO' AND  sClass=:studentClass AND section=:studentClassSection"
		        + " AND admNo=: studentAdmNo AND A.status=:Fstatus"
		        + " ORDER BY testCycle, testType, testCategory, subject";

	public static final String home          = "Home";
	public static final String profile       = "Profile";
	public static final String academic      = "Academic";
	public static final String grievance     = "Grievance";
	public static final String examination   = "Examination";
	public static final String update        = "Update";
	public static final String studentPayment= "Student Payment";
	public static final String logout        = "Logout";
	public static final String student       = "STUDENT";
	public static final String information   = "INFORMATION";
	public static final String portal        = "PORTAL";	

	public static final String TIME_TABLE    = "Time Table";	
	public static final String CLASS         = "Class";	
	public static final String TEACHER       = "Teacher";	
	public static final String DAYS          = "Day";	
	public static final String ON            = "On";	
	public static final String HRS           = "Hours";	
	public static final String ADD           = "ADD Schedule";	
	public static final String START         = "Start";	
	public static final String END           = "End";	
	public static final String TOTAL         = "Total";	
	
	public static final String FETCH_TTDATA = "FROM TimeTableModel "
	 		 + " WHERE regNo=:rregNo AND subject=:ssubject AND classTT=:cclassTT"
	 		 + " AND section=:ssection AND status=:sStatus"; 
	
	public static final String LIBRARY      = "Library";	
	public static final String MONDAY       = "MONDAY";	
	public static final String TUESDAY      = "TUESDAY";	
	public static final String WEDNESSDAY   = "WEDNESSDAY";	
	public static final String THURSDAY     = "THURSDAY";	
	public static final String FRIDAY       = "FRIDAY";	
	public static final String SATURDAY     = "SATURDAY";	
	public static final String SCHEDULE     = "Schedule";	
	// html web pages
	public static final String ATTENDANCE  = "SISystem/StudentAttendance.html" ;

	public static final String TIMETABLE ="SISystem/TimeTable.html";
	public static final String TEST_PERFORMANCE="SISystem/TestPerfromance.html";
	
	public static final String FACULTY ="Faculty";
	public static final String CREATE ="Create";
	public static final String AND ="And";
		
	public static final String HQL_FACULTY_REMOVE = "Update FacultyModel set status =:nStatus  WHERE regNo=: RegNo AND fIDNO =:remFIDNO AND status=:oStatus";
	public static final String PARM_NSTATUS ="nStatus"; // new Status
	public static final String PARM_OSTATUS ="oStatus"; // old Status
	public static final String PARM_REGNO ="RegNo";
	public static final String PARM_CODE ="Code";
	
	public static final String PARM_IDNO        = "remFIDNO";
	public static final String PARM_SET_MSG     = " Param setting done";
	public static final String EXEC_REMOVE_MSG  = " Removed Inforamtion Successfully ;" ;
	public static final String EXEC_CREATE_MSG  = " Create Inforamtion Successfully ;" ;
	public static final String EXEC_UPDATE_MSG  = " Update Inforamtion Successfully ;" ;
	public static final String EXEC_TECHERROR_MSG  = "TECHNICAL ERROR! PLS TRY AFTER SOMETIME.";
	public static final String EXEC_CATCH_MSG  = " \nCatch Exception: " ;
	public static final String COMMIT           = " Commit";
	public static final String TRANSACTION      = " Transaction";

	
	public static final String ACTION_STEP      = " Step: ";
	public static final String ACTION_START     = " Start: ";
	public static final String ACTION_REMOVING  = " Removing: ";
	public static final String ACTION_UPDATING  = " Updating: ";
	public static final String ACTION_CREATING  = " Creating: ";

	public static final String ACTION_CREATE    = " Create ";
	public static final String ACTION_UPDATE    = " Update ";
	public static final String ACTION_OK    = " OK ";
	public static final String ACTION_MODEL     = " Model ";
	public static final String ACTION_GENERATE  = " Generate ";
	public static final String ACTION_LIST      = " List ";
	public static final String ACTION_STATUS    = " Status ";
	public static final String MESSAGE          = "Message";
	
	public static final String MEMBER           = " Member"    ;
	public static final String LNAME            = " Last Name" ;
	public static final String DESIGNATION      = " Designation";
	public static final String QUALIFICATION    = " Qualificagion";
	public static final String DOB              = " Date Of Birth";
	public static final String GENDER           = " Gender";
	public static final String EMAIL            = " Email ID";
	public static final String MOBILE           = " Mobile No.";
	public static final String PHONE            = " Phone No.";
	public static final String EMPLOYEE         = " Employee";
	public static final String CODE             = " Code";
	public static final String PERSONAL         = " Personal";
	public static final String DOJ              = " Date of Joining";
	public static final String DOR              = " Date of Releaving";
	public static final String EMPLOYMENT       = " Employment";
	public static final String INFORMATION      = " Information";
	public static final String CONTACT          = " Contact";
	public static final String ADDRESS          = " Address";
	public static final String SKILLS          = "  Expertise";
	 	
	
}
