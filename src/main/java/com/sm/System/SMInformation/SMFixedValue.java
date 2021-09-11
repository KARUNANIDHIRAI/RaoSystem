package com.sm.System.SMInformation;

import java.util.Date;

import javax.persistence.Parameter;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.metamodel.SingularAttribute;

public class SMFixedValue {
	public static final String USER= "User";
	public static final String LOGIN= "Login";
	public static final String ROLE= "Role";
	public static final String TYPE= "Type";
	
	public static final String ACTION_PLAIN_TEXT= "text/plain";
	public static final String NEW_STATUS= "A";
	public static final String UPDATE_STATUS= "D";
	public static final String REMOVE_STATUS= "D";
	public static final String LIST_STATUS= "A";
	public static final String STATUS= "A";
	
	public static final String SAVE="Save";
	public static final String SUBMIT="Submit";
	public static final String Action="Add";
	public static final String Edit="Edit";
	public static final String View="View";
	public static final String Remove="Remove";
	public static final String New="New";
	public static final String ACTION="Action";
	public static final String CANCEL="Cancel";
	public static final String CLICKME="Click Me";
	
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

	 public static final String HQL_FACULTY_MEMBER= " Update FacultyMemberModel set status =:nStatus "
			   +  " where fMIDNO =:remFIDNO AND regNo =:RegNo AND  status=:oStatus";
	 public static final String HQL_FACULTY_MEMBER1= " Update FacultyMemberAddressModel set status =:nStatus, "
			   +  " where fMAddress=:remFIDNO AND regNo =:RegNo AND  status=:oStatus ";
	 
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
	public static final String PARM_STATUS ="Status"; // Status
	public static final String PARM_REGNO ="RegNo";
	public static final String PARM_CODE ="Code";
	public static final String PARM_INVOICE_NO ="invoiceNo";
	
	
	
	public static final String PARM_IDNO        = "remFIDNO";
	public static final String PARM_SET_MSG     = " Param setting done";
	public static final String EXEC_GENERATE_LIST  = " Generate List Successfully ;" ;
	public static final String EXEC_REMOVE_MSG  = " Removed Inforamtion Successfully ;" ;
	public static final String EXEC_CREATE_MSG  = " Create Inforamtion Successfully ;" ;
	public static final String EXEC_UPDATE_MSG  = " Update Inforamtion Successfully ;" ;
	public static final String EXEC_TECHERROR_MSG  = "TECHNICAL ERROR! PLS TRY AFTER SOMETIME.";
	public static final String EXEC_CATCH_MSG  = " \nCatch Exception: " ;
	public static final String COMMIT           = " Commit";
	public static final String TRANSACTION      = " Transaction";
	public static final String EXEC_QUERY_MSG  = " Execute Query Successfully. " ;
	public static final String EXEC_NODATAFOUND_MSG  = " No Data found. " ;
	public static final String EXE_VALID_MSG = " Validaion Start : ";
	
	
	
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
	public static final String SKILLS           = "  Expertise";
//------------------
	public static final String BOOK             = " Book";
	public static final String PURCHASE         = " Purchase";
	public static final String ACADEMIC         = " Academic";
	public static final String PUBLICATION      = " Publicafion";
	public static final String ISBN             = " ISBN";
	public static final String TITLE         	= " Title";
	public static final String AUTHOR      		= " Author";
	public static final String EDITION          = " Edition	";
	public static final String SOURCE         	= " Source";
	public static final String BOOKCOPIES      	= " Book Copies";
	public static final String DATE             = " Date";
	public static final String BOOKPONO         = " Purchase Order No.";
	public static final String PRICE      	    = " Price";
	public static final String TAX              = " Tax";
	public static final String QUANTITY         = " Quanity";
	public static final String INVNO            = " Invoice No.";
	public static final String Invoice          = " Invoice";
	public static final String NETAMT           = " Net.Amount";	
	public static final String SUPPLIER          = " Supplier";	
	public static final String VERIFY          = " Verify ";	
	public static final String OUTPUT          = " Output: ";	
	public static final String PARM_QUERY_INPUT = " Query Input PARAM Values : ";	
	//-------------------Model List
	public static final String MODEL_BOOK_PURCHASE ="BooksPurchaseModel";
	public static final String MODEL_BOOK_PURCHASE_DETAILS="BooksPurchaseDetailModel";
	public static final String MODEL_BOOK_PURCHASE_DETAILS_REFIN_BKMODEL="BKPurchaseDetail";
	public static final String MODEL_BOOK_REGNO="regNo";
	public static final String MODEL_BOOK_INVOICENO="invocieNo";
	public static final String MODEL_BOOK_STATUS="status";
	public static final String MODEL_BOOK_CODE="bookCode";
	
	public static final String HQL_VERIFY_INVOICE_NO = " FROM BooksPurchaseModel "
	 		                   + " WHERE regNo=:RegNo AND invocieNo=:invoiceNo AND status=:oStatus";	

	public static final String REM_ITEMISSUE_INFO= " Update SMItemBorrowedModel set status =:nStatus "
			   +  " where iDNO =:remFIDNO AND regNo =:RegNo AND  status=:oStatus";
	
	public static final String REM_BOOK_INFO= " Update BooksPurchaseModel set status =:nStatus "
			   +  " where iDDNO =:remFIDNO AND regNo =:RegNo AND  status=:oStatus";
			
	public static final String HQL_BKP_LIST = "FROM BooksPurchaseModel "
	                           + " WHERE regNo=:" + SMFixedValue.PARM_REGNO 
	                           + " AND invocieNo=:" +SMFixedValue.PARM_INVOICE_NO  + " AND status=:"+ SMFixedValue.PARM_OSTATUS ;

	//------------BOOKS BORROWED
	public static final String STUDENT="Student";
	public static final String TO="To";
	public static final String BORROWED="Borrowed";
	public static final String ISSUEDBYCODE="Issued By Emp.Code";
	public static final String ISSUEDBYNAME="Issued By Emp.Name";
	public static final String FROM_DATE="From Date";
	public static final String TO_DATE="TO Date";
	public static final String MODEL_FACULTYCODE="facultyCode";
	public static final String MODEL_FACULTYREGNO="regNo";
	public static final String MODEL_FACULTYSTATUS="status";
	
	public static final String WEBPAGE_INPUTVALUE_TOMODEL=" Web page Input values to MODEL";
	public static final String MODEL_BOOK_BORROW_ADMNO="admNo";
	public static final String BKBR_RETSTATUS="P";
	public static final String MODEL_BOOK_BORROW_RETSTATUS="borrowedRetStatus";
	public static final String BOOK_BORROW_INPUTVALUES="Book Borrowed Input Values:";
	public static final String BOOK_BORROW_REM_CRETRERIA="Book Borrowed Removing Creteria:";
	public static final String ACTION_REMOVING_BOOK_BORROW ="Removing Book Borrowed:";
	public static final String TOMODEL="To Model:";
	public static final String DELETE_STATUS ="D";
	public static final String PARM_ADMNO ="AdmNo";
	public static final String HQL_BOOK_BORROWED_REMOVE = "Update BooksBorrowModel set status =:nStatus "
			                                            + " WHERE regNo=: RegNo AND iDNO =:remFIDNO AND status=:oStatus";
	public static final String BOOK_BORROW_LIST_CRETRERIA = "Books Borrowed Generating List Creteria";	
	public static final String BOOK_BORROW_LIST_GENERATING = "Books Borrowed List Generating..";
	public static final String BOOK_BORROW_LIST_GENERATED = "Books Borrowed List Generated..";
	public static final String PARAM_BOOK_BORROW_CRETERIA_DONE = "Books Borrowed Creteria Seting Done.";
	//----------BOOKS BORROWED RETURN 
	public static final String RETURN_DATE = "Return Date";
	public static final String LATE_FEE = "Late Fee";	
	public static final String BOOK_BR_PENDLIST_GENERATING = "Books Borrowed Pendning List Generating....";
	public static final String COMPLETED = "Completed.";
	//----------BOOKS Master
	public static final String BOOK_MS_CREATING        = "Books Master New Information Creatting....";
	public static final String BOOK_MS_INPUT_UPDMODEL  = "Books Master Inpute Values Updating to Model.";
	public static final String BOOK_MS_INPUT_VALUE     = "Books Master Inpute Values: ";
	public static final String BOOK_MS_OUPT_VALUE      = "Books Master Output Values: ";
	public static final String CREATING_INFO_INTOTABLE = "Inserting New Information into [DB]... ";
	public static final String MODEL_BOOK_MASTER_QTY   = "bksMasterQtyIDNO";
	public static final String MODEL_BOOK_iDNO         = "iDNO";
	public static final String HQL_REM_BOOKMASTER_IDNO =" Update BooksMasterInfoModel "
		+" SET status =:nStatus "
		+" WHERE iDNO =:remFIDNO AND regNo =:RegNo AND  status=:oStatus "
        +" AND iDNO IN(select a.iDNO from BooksMasterInfoModel a join BooksMasterQtyModel b "
        + "on a.bksMasterQtyIDNO = b.iDNO where b.issueBooksQty =b.returnBooksQty and a.iDNO =:remFIDNO)" ;	
	//----------SUPPLER Master
	public static final String SECTOR_BLOCK  = "Sector /  Block";
	public static final String CITY          = "City";
	public static final String STATE         = "State";
	public static final String COUNTRY       = "Country";
	public static final String PINCODE       = "Pin Code";
	public static final String FACEBOOK      = "Facebook";
	public static final String TWITTER       = "Twitter";
	public static final String LINKDIN       = "Linkdin";
	public static final String SUPPLIER_MASTER     = "Supplier Master ";
	public static final String INPUT_VALUES    = "Input Values : ";
	public static final String OUTPUT_VALUES   = "Output Values : ";
	public static final String NEW_INFORMATION = "New Information Creatting.... ";
	public static final String UPD_MODEL = " Model Updation Completed ";
	public static final String MODEL_SUP_MASTER_ADDRESS   = "supMAddress";
	public static final String MODEL_SUP_MASTER_CONTACT   = "supMasterContact";
	public static final String MODEL_REGNO   = "regNo";
	public static final String MODEL_STATUS   = "status";
	public static final String ADDRESS_CATEGRORY = "AD";
	public static final String ADDRESS_CATEGORY_HO = "HO";
	public static final String CONTACT_REF_HO = "HO";
	public static final String LIST_GENERATING = "List Generating ";
	public static final String MODEL_IDNO = "iDNO";
	public static final String UPDATE_MODEL = "Updating to Model";
	public static final String HQL_REM_SUPPLIER_IDNO =" Update SupplierMasterModel "
			+" SET status =:nStatus WHERE iDNO =:remFIDNO AND regNo =:RegNo AND  status=:oStatus " ;
	public static final String CONTACT_CATEGORY_HO = "HO";
	public static final String CONTACT_CATEGORY = "SP";
	public static final String PARM_BOOKCODE = "bookCode";
	public static final String PARM_BOOKISSEDUEQTY = "bkIssueQty";
	public static final String PARM_BOOKRETURNQTY = "bkReturnQty";
	public static final String UPD_BOOKMASTER_QTYBAL_BKISSUENEW = "Update BooksMasterQtyModel "
			+ " SET closingBooksQty =closingBooksQty - :bkIssueQty "
			+ ", issueBooksQty=issueBooksQty + :bkIssueQty"
			+ " WHERE regNo =:"+SMFixedValue.PARM_REGNO + " and bookCode =:"+ SMFixedValue.PARM_BOOKCODE 	
		    + " AND closingBooksQty -: "+ SMFixedValue.PARM_BOOKISSEDUEQTY +">=0";
	public static final String UPD_BOOKMASTER_QTYBAL_BKISSUEREMOVE = "Update BooksMasterQtyModel "
			+ " SET closingBooksQty =closingBooksQty + :bkIssueQty "
			+ ", issueBooksQty=issueBooksQty - :bkIssueQty"
			+ " WHERE regNo =:"+SMFixedValue.PARM_REGNO + " and bookCode =:"+ SMFixedValue.PARM_BOOKCODE 	
		    + " AND closingBooksQty -: "+ SMFixedValue.PARM_BOOKISSEDUEQTY +">=0";
	public static final String UPD_BOOKMASTER_QTYBAL_BKRETURN = "Update BooksMasterQtyModel "
			+ " SET closingBooksQty =closingBooksQty + :" + SMFixedValue.PARM_BOOKRETURNQTY
			+ ", returnBooksQty=returnBooksQty + :" + SMFixedValue.PARM_BOOKRETURNQTY
			+ " WHERE regNo =:"+SMFixedValue.PARM_REGNO + " and bookCode =:"+ SMFixedValue.PARM_BOOKCODE; 	

	public static final String UPD_BOOKBORROW_RETURN_INFO = "Update BooksBorrowModel "
			+ " SET actualReturnDate =:" + SMFixedValue.PARM_RETURN_DATE
			+ ", borrowedRetStatus =:" + SMFixedValue.PARM_RETURN_STATUS
			+ " WHERE iDNO =:" + SMFixedValue.PARM_IDNO + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			+ " AND  status=: " + SMFixedValue.PARM_STATUS ;
	
	public static final String RETRIEVING = "Retrieving ";
	public static final String EXEC_REMOVE_UPD_MSG="Update BookS Closing Balance Successflly.";
	public static final String BK_RET_DEFAULT_STATUS = "P";	
	public static final String PARM_RETURN_STATUS = "R";
	public static final String PARM_RETURN_DATE = "ReturnDate" ;
	public static final String INFORMATION_FETCH_CRITERIA = "Informatio Fetch Criteria :";
	public static final String BOOK_BORROWED_RETURN = "Book Borrowed Return ";
	public static final String BOOK_BORROW_IDNOINFO = "Retrieving Book Borrow Information base on IDNO:";
	public static final String HQL_BOOK_BORROW_IDNOINFO1 = "SELECT a.regNo, a.bookCode,"
			        + " a.bookName, borrowFromDate, BorrowToDate, noOfCopyIssued,booksISBN, edition, author, publisher, a.iDNO "
	                + " FROM BooksBorrowModel a "
	                + " INNER JOIN  BooksMasterInfoModel b on a.bookCode=b.bookCode WHERE a.iDNO =729";
	public static final String MODEL_ACUTAL_RETURNDATE = "borrowRetrunDate";
	public static final String HQL_BOOK_BORROW_IDNOINFO=" FROM BooksBorrowModel "
			        + " WHERE a.iDNO =:" + SMFixedValue.PARM_IDNO + " AND a.regNo =:" +SMFixedValue.PARM_REGNO
			        + " AND  a.status=:" + SMFixedValue.PARM_STATUS;
	 public static final String HQL_BOOK_RETURN_ON_CURDATE=" FROM BooksBorrowModel "
		        + " WHERE regNo =:" +SMFixedValue.PARM_REGNO +" AND admNo =:" + SMFixedValue.PARM_IDNO  
		        + " AND  status=:" + SMFixedValue.PARM_STATUS + " AND  actualReturnDate=:" + SMFixedValue.MODEL_ACUTAL_RETURNDATE;
	public static final String RETRIEVE = "Retrieve ";
	public static final String BOOK_RETURN = "Book Retrun ";
	public static final String SUCCESSFULLY = "Successfully ";
// SPORT INFORMATION
	public static final String SPORTS="Sports";
	public static final String MAKE="Make";
	public static final String ITEM="Item";
	public static final String MANUFACTURING_YEAR="Manufacturing Year";
	public static final String EXPIRY_DATE="Expiry Date";
	public static final String UNIT="Units";
	public static final String NOS="Nos";
	public static final String ACTION_VERIFY_ITEMCODE = "Verifying Duplicate Item Code :";
	public static final String MODEL_ITEMMASTER = "ItemMasterModel";
	public static final String MODEL_CODE = "code";
	public static final String HQL_REM_ITEM_INFO = "Update ItemMasterModel "
			+ " SET status =:" + SMFixedValue.PARM_NSTATUS
			+ " WHERE iDNO =:" + SMFixedValue.PARM_IDNO + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			+ " AND  status=: " + SMFixedValue.PARM_OSTATUS ;
	public static final String MODEL_CREATEDON = "createdOn";
	public static final String REM_SPORTITEM_INFO =  "Update ItemMasterModel "
			+ " SET status =:" + SMFixedValue.PARM_NSTATUS
			+ " WHERE iDNO =:" + SMFixedValue.PARM_IDNO + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			+ " AND  status=: " + SMFixedValue.PARM_OSTATUS ;
// URLBase accessibility
	public static final String PARM_USER_ROLE = "UserRole";
	public static final String DUPLICATE = "Duplicate";
	public static final String FNAME = "First Name";
	public static final String RESET = "Reset";
	public static final String MODEL_USERROLE = "userRole";
	public static final String MODEL_USERROLE_IDFK = "URolesModel";
	public static final String ACTION_CRITERIA = "Criteria :";
	public static final String MODEL_USERROLE_ID = "iDNO";	
	public static final String REMOVE_USERROLE_DETAIL = "Update UserRolesDetailsModel "
			+ " SET status =:" + SMFixedValue.PARM_NSTATUS
			+ " WHERE iDDNO =:" + SMFixedValue.PARM_IDNO + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			+ " AND  status=: " + SMFixedValue.PARM_OSTATUS ;
	
	public static final String UTILITY ="Utility";
	public static final String REMOVE_USERROLE_GROUP = "Update UserRolesModel "
			+ " SET status =:" + SMFixedValue.PARM_NSTATUS
			+ " WHERE iDNO =:" + SMFixedValue.PARM_IDNO + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			+ " AND  status=: " + SMFixedValue.PARM_OSTATUS ;
	public static final String DATA_ALREADY_EXIST = "Data Already Exist! Duplicate Data can't careate"; ;
	public static final String ID = "ID";
	public static final String PASSWORD = "Password";
	public static final String CREDENTIALS ="Credentials";
	public static final String ACTION_UPDATING_CRITERIA ="Updating Information Retrieve Criteria: ";
	public static final String GENERATING = "GENERATING :";
	public static final String ACTION_VALIDATING = "Validating";
	public static final String ACTION_PASSWORD = "Password";
	public static final String MODEL_EMAILID = "emailID";
	public static final String MODEL_USER_CODE = "userCode";
	public static final String MODEL_USER_FNAME = "fName";
	public static final String MODEL_USER_PASSWORD = "uLPWD";
	public static final String MODEL_USER_LOGINID = "emailID";
	public static final String CAPTCHA ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final String SPORT_ITEMCATEGORY = "itemCategory";
	public static final String OPENBAL = "Opening Balance";
	public static final String MODEL_ITEMCODE = "ItemCode";
	public static final String MODEL_iTEMCODE = "itemCode";
	public static final String EXEC_DUPLICATE_MSG = "Duplicate Data found. ";
	public static final String EXEC_NODATAINSERT_MSG = "No Data Insert. ";
	public static final String ACTION_ITEMCODE_PK = "Getting ItemCode PK...";
	public static final String MODEL_FACULTYEMAIL = "emailID";
//  sm item borrrowed by School management , staff and student
	public static final String ISSUE="Issue" ;
	public static final String ITEM_BORROW_INPUTVALUES = "Item borrowed Input Values ";
	public static final String RETURN_DEFAULT_STATUS = "P";
	public static final String PARA_ITEMCODE = "ItemCode";
	public static final String PARM_ISSUEDQTY = "IssuedQty";
	
	public static final String UPD_ITEMMASTER_OPCLBAL_ISSUE = "Update SMItemMasterOPCLBalModel "
			+ " SET clBalQty =clBalQty - :IssuedQty "
			+ ", issueQty = issueQty + :IssuedQty"
			+ " WHERE regNo =:"+SMFixedValue.PARM_REGNO + " and itemCode =:"+ SMFixedValue.PARA_ITEMCODE 	
		    + " AND clBalQty -: "+ SMFixedValue.PARM_ISSUEDQTY +">=0 and status=:"+ PARM_STATUS;
	public static final String MODEL_BORROWED_DATE = "borrowFromDate";
	public static final String MODEL_ADIMISSIONNO = "admNo";
	public static final String BORROW_LIST_GENERATED = "Borrowed List Generated sucesscfully.";
	
	public static final String RETURN = "Return ";
	public static final String PARM_RETURNEDQTY = "ReturnedQty";
	public static final String PARA_RETURNDATE = "ReturnDate";
	public static final String LATEFEE = "Late Fee";
	public static final String DUEDATE = "Due Date";

	public static final String UPD_ITEMMASTER_OPCLBAL_RETURN = "Update SMItemMasterOPCLBalModel "
			+ " SET clBalQty =clBalQty + :" +SMFixedValue.PARM_RETURNEDQTY
			+ ", returnQty = returnQty + :" +SMFixedValue.PARM_RETURNEDQTY
			+ " WHERE regNo =:"+SMFixedValue.PARM_REGNO + " and itemCode =:"+ SMFixedValue.PARA_ITEMCODE 	
		    + " AND status=:"+ PARM_STATUS;
	
	public static final String UPD_ITEM_BORROWED ="Update SMItemBorrowedModel "
			+ " SET returnDate = :" +SMFixedValue.PARA_RETURNDATE
			+ " WHERE iDNO =:" + SMFixedValue.PARM_IDNO + " AND status=:"+ PARM_STATUS;
	
	public static final String REM_ITEM_OPCLBAL = "Update SMItemMasterOPCLBalModel "
			   + " SET clBalQty = clBalQty - OpBalQty, OpBalQty =0"
			   + " WHERE itemCode =:" + SMFixedValue.PARM_CODE + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			   + " AND  status=:" + SMFixedValue.PARM_OSTATUS + " AND OpBalQty<=clBalQty";
	
	public static final String REM_ITEM_OPBAL = "Update SMItemMasterOPBalModel "
			   + " SET status =:" + SMFixedValue.PARM_NSTATUS
			   + " WHERE OPBQIDNO =:" + SMFixedValue.PARM_IDNO + " AND regNo =:" +  SMFixedValue.PARM_REGNO 
			   + " AND  status=:" + SMFixedValue.PARM_OSTATUS ;
//   Item lost
	public static final String LOST="Lost";
	public static final String LOST_CHARGES="Penality Amt.";
	public static final String ITEM_LOST_INPUTVALUES = "item lost input values ";
	public static final String TODAY_REPORT_LOSTITEM ="Today Lost Items";
	public static final String LOSTITEMS ="Lost Items List";
	public static final String LOST_STATUS = "L";
	public static final String MODEL_LOST_DATE = "lostDate";
	// Student ERP
	public static final String MODEL_STUDENT_EMAIL= "emailId";
	public static final String MENU_ITEM_BORROW   = "Item Borrowed";
	public static final String MENU_ITEM_RETURN   = "Item Borrowed Return";
	public static final String MENU_ITEM_DUE      = "Item Borrowed Due";
	public static final String MENU_ITEM_LOST     = "Item Borrowed Lost";
	public static final String ITEM_RETURN_INPUTVALUES = "item return input values ";
	public static final String MODEL_USERID       = "emailID";
	public static final String MODEL_RETURNQTY    = "returnedQty";
	public static final String TODAY              = "Today ";
	public static final String MODEL_RETURN_DATE  = "returnDate";
	public static final String TODAY_ITEM_RETURN  ="View Today Item Returned";
	public static final String LIST_ITEM_RETURN   ="List Items to Return";
	public static final String REMOVED            =" Removed";
	public static final String MODEL_OPBALQTY     = "opBalQty";
	public static final String MODEL_CLBALQTY     = "clBalQty";
	public static final String MODEL_BorrowedStatus = "borrowedRetStatus";
	public static final String MODEL_BRStatus = "borrowedRetStatus";
//  Transport route
	public static final String ROUTE          = "Route";
	public static final String TRANSPORT      = "Transport";
	public static final String DESCRIPTION    = "Description";
	public static final String PICKUP_POINT   = "Pickup Point";
	public static final String PICKUP_TIME    = "Time";
	public static final String SNO            = "SNo.";
	public static final String DROP_POINT     = "Drop Point";
	public static final String DROP_TIME      = "Time";
	public static final String PICKUP_DROP_POINT = "Pickup And Drop";
	public static final String MODEL_ROUTE_NAME = "routeName";
	public static final String HQL_PICKUP_DROP="select a.routename, b.pickDropSNo,b.pickupDropType, b.pickupDropPoint, a.idno,b.iDNOFK " + 
			" from  SMTransportRoute a" + 
			" inner join SMTransportRoutePickupDrop b on a.IDNO = b.iDNOFK" + 
			" where a.IDNO =1 and a.status='A' and b.status='A' order by b.PickupDropType, b.PickDropSNo";
	
  
}
