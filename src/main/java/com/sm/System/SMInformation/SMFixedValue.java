package com.sm.System.SMInformation;

public class SMFixedValue {
	public static final String Action="Add";
	public static final String Edit="Edit";
	public static final String View="View";
	public static final String Remove="Remove";
	public static final String New="New";
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
	
	public static final String HQL_RSPROFILEINFO = " SELECT regNo, admNo,	course, promotedInClass, rollNo, section, "
	                                           + " dob,	fName,  lName ,	gender,		mobileNo, emailId,	"
	                                           + " ffName, 	flName , mfName ,	mlName , fprofession, pEmailId,	pMobileNo"
											   + " FROM  StudentPersonalInfoModel"
											   + " WHERE regNo=:studentRegNo AND emailId=:studentEmailId  AND status=:Fstatus";
	                                           

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
	
	public static final String LIBRARY         = "Library";	
}
