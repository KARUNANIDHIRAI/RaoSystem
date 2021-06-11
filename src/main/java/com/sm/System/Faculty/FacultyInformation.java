package com.sm.System.Faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.Utilities;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.StudentPersonalInfo.StudentAddress;
import com.sm.System.SubjectMaster.HDAOSubjects;
import com.sm.System.SubjectMaster.Subjects;

public class FacultyInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FacultyInformation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		FacultyModel facultyModel = new FacultyModel();
		facultyModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "XNFaculty":	
				facultyModel = UpdateFacultyValuesToRModel(facultyModel,request);
				erMsg = " Model Update OK.";
				excStatus = HDAOFaculty.facultyNew(facultyModel,erMsg);
				
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_CREATE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute("Message",hDAOMessage );
				erMsg = " create Status :" + Integer.toString(excStatus) + ":"+hDAOMessage;

				JsonArrayList = HDAOFaculty.facultyList(facultyModel, erMsg);
				erMsg +=" Step 3: Generate vlist Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xRLFaculty" :	//Retrieve Faculty List
				JsonArrayList = HDAOFaculty.facultyList(facultyModel, erMsg);
				erMsg +=" Step 3: Generate vlist Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" Step 3:  vlist done";
				break; 
			case "xRNLFaculty" :	//Retrieve Faculty List
				facultyModel.setRegNo("MK308");
				JsonArrayList = HDAOFaculty.facultyNameList(facultyModel, erMsg);
				erMsg +=" Step 3: Generate vlist Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" Step 3:  vlist done";
				break; 
				
			case "xRMFaculty":	 // remove Faculty Code and Name
				facultyModel.setfIDNO(Integer.parseInt((String)request.getParameter("Code")));
				System.out.println("RegNo:" +facultyModel.getRegNo() + "Faculty Code:" +facultyModel.getfIDNO());
				int remfaculty = HDAOFaculty.facultyRemove(facultyModel, erMsg);
				erMsg +=" 3: removed data ;";
				hDAOMessage= remfaculty>0?SMFixedValue.EXEC_REMOVE_MSG:SMFixedValue.EXEC_TECHERROR_MSG; 
				session.setAttribute("Message",hDAOMessage );
				erMsg = " create Status :" + Integer.toString(remfaculty) + ":"+hDAOMessage;
				if(remfaculty>0) {
					JsonArrayList = HDAOFaculty.facultyList(facultyModel, erMsg);
					erMsg +=" 4: Retrieved Faculty list after removed data.";
					out.print(JsonArrayList.toJson());
					out.flush();
				}
				break; 
			case "XNMFaculty":	
				FacultyMemberModel facultyMemberModel = new FacultyMemberModel();
				facultyMemberModel = UpdateFMValuesToRModel(facultyMemberModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
				excStatus = HDAOFaculty.facultyMemberNew(facultyMemberModel,erMsg);
				
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_CREATE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg = SMFixedValue.ACTION_CREATE + SMFixedValue.ACTION_STATUS + Integer.toString(excStatus) + ":"+hDAOMessage;
				break;
				
			case "xRfmList": // retrieve Faculty Member list	
				FacultyMemberModel xfacultyMemberModel = new FacultyMemberModel();
				xfacultyMemberModel.setRegNo("MK308");
				System.out.println("\nInput Param:" +xfacultyMemberModel.getRegNo());
				JsonArrayList = HDAOFaculty.facultyMemberList(xfacultyMemberModel,erMsg);
				
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_GENERATE_LIST:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg += hDAOMessage + " :" + Integer.toString(JsonArrayList.size());
				System.out.println("\n Output Faculty Member List:\n" +JsonArrayList.toJson());

				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xRfmIDNO": // Remove FAculty Member and then retrieve Faculty Member list	
				FacultyMemberModel rfacultyMemberModel = new FacultyMemberModel();
				rfacultyMemberModel= UpdateCriteriaToModel(rfacultyMemberModel, request);
				ViewParameter(rfacultyMemberModel);
				excStatus = HDAOFaculty.facultyMemberRemoveInfo(rfacultyMemberModel,erMsg);
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_REMOVE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				
				JsonArrayList = HDAOFaculty.facultyMemberList(rfacultyMemberModel,erMsg);
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_GENERATE_LIST:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg += hDAOMessage + " :" + Integer.toString(JsonArrayList.size());
				System.out.println("\n Output Faculty Member List:\n" +JsonArrayList.toJson());

				out.print(JsonArrayList.toJson());
				out.flush();
				break;
				

			case "xUfmIDNO": // Update FAculty Member and then retrieve Faculty Member list	
				FacultyMemberModel ufacultyMemberModel = new FacultyMemberModel();
				ufacultyMemberModel= UpdateCriteriaToModel(ufacultyMemberModel,  request);
				ViewParameter(ufacultyMemberModel);
				excStatus = HDAOFaculty.facultyMemberUpdateInfo(ufacultyMemberModel,erMsg);
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_UPDATE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				
				JsonArrayList = HDAOFaculty.facultyMemberList(ufacultyMemberModel,erMsg);
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_CREATE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg = SMFixedValue.ACTION_CREATE + SMFixedValue.ACTION_LIST +
						SMFixedValue.ACTION_STATUS + Integer.toString(JsonArrayList.size())
						+ ": "+hDAOMessage;
				System.out.println("\n Output Faculty Member List:\n" +JsonArrayList.toJson());

				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xRBKIssuedBy": // Update FAculty Member and then retrieve Faculty Member list	
				FacultyMemberModel iFacultyMemberModel = new FacultyMemberModel();
				iFacultyMemberModel= issByCriteriaToModel(iFacultyMemberModel, request);
				ViewIssuedByParameter(iFacultyMemberModel);

				JsonArrayList = HDAOFaculty.facultyMemberInformation(iFacultyMemberModel);
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_CREATE_MSG:SMFixedValue.EXEC_NODATAFOUND_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg = hDAOMessage +SMFixedValue.FACULTY+":"+ Integer.toString(JsonArrayList.size());
				erMsg+="\n"+SMFixedValue.OUTPUT +JsonArrayList.toJson();

				out.print(JsonArrayList.toJson());
				out.flush();
				break;				
			}
		} catch (Exception e) {
			System.out.println(SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e);
		}
		finally {
			System.out.println(erMsg);
		}

	}

	private FacultyMemberModel issByCriteriaToModel(FacultyMemberModel iFacultyMemberModel, HttpServletRequest request) {
		iFacultyMemberModel.setRegNo("MK308");
		iFacultyMemberModel.setStatus(SMFixedValue.STATUS); 
		iFacultyMemberModel.setFacultyCode(request.getParameter("bkIssueedBy"));
		return iFacultyMemberModel;
	}
	private void ViewIssuedByParameter(FacultyMemberModel iFacultyMemberModel) {
		System.out.println(SMFixedValue.PARM_QUERY_INPUT 
				+ "RegNo: " +iFacultyMemberModel.getRegNo()
		        + " EmpCode: " + iFacultyMemberModel.getFacultyCode()
		        + " Status : " + iFacultyMemberModel.getStatus());
	}

	private FacultyMemberModel UpdateCriteriaToModel(FacultyMemberModel ufacultyMemberModel, HttpServletRequest request) {
		ufacultyMemberModel.setRegNo("MK308");
		ufacultyMemberModel.setStatus("D"); // for Remove Status
		ufacultyMemberModel.setfMIDNO(Integer.parseInt((String)request.getParameter("fmIDNOU")));
		return ufacultyMemberModel;
	}

	private void ViewParameter(FacultyMemberModel ufacultyMemberModel) {
		System.out.println("\nInput Param:"+ufacultyMemberModel.getRegNo() +" Upd fmIDNOU:" + ufacultyMemberModel.getfMIDNO().toString());
		
	}

	private FacultyMemberModel UpdateFMValuesToRModel(FacultyMemberModel facultyMemberModel, HttpServletRequest request) throws ParseException {
		try {
			facultyMemberModel.setRegNo(request.getParameter("RegNo"));
			facultyMemberModel.setFaculty(request.getParameter("faculty"));
			facultyMemberModel.setDesignation(request.getParameter("designation"));
			facultyMemberModel.setFacultyCode(request.getParameter("fmCode"));
			facultyMemberModel.setdOJ(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("doj")));	
			facultyMemberModel.setdOR(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("dor")));	
			facultyMemberModel.setName(request.getParameter("Name"));
			facultyMemberModel.setlName(request.getParameter("lName"));
			facultyMemberModel.setGender(request.getParameter("Gender"));
			facultyMemberModel.setdOB(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("dob")));	
			facultyMemberModel.setQualification(request.getParameter("fmQaul"));
			facultyMemberModel.setSkillArea(request.getParameter("skillArea"));
			facultyMemberModel.setEmailID(request.getParameter("email"));
			facultyMemberModel.setMobileNo(request.getParameter("MobileNo"));
			facultyMemberModel.setPhoneNo(request.getParameter("PhoneNo"));
			facultyMemberModel.setSkillArea(request.getParameter("skillArea"));
	
			facultyMemberModel.setStatus("A");
			facultyMemberModel.setCreatedBy("KNRAI");
			facultyMemberModel.setUpdatedBy("KNRAI");
			facultyMemberModel.setCreatedOn(new Date());
			facultyMemberModel.setUpdatedOn(new Date());		
	
			System.out.println("saddress a: "+facultyMemberModel);
			
			//address information
			FacultyMemberAddressModel facultyMemberAddressModel = new FacultyMemberAddressModel();
			facultyMemberAddressModel.setRegNo(facultyMemberModel.getRegNo());
			facultyMemberAddressModel.setAddress(request.getParameter("Address"));
			facultyMemberAddressModel.setSector(request.getParameter("Sector"));
			facultyMemberAddressModel.setCity(request.getParameter("City"));
			facultyMemberAddressModel.setState(request.getParameter("State"));
			facultyMemberAddressModel.setPinCode(request.getParameter("PostalCode"));
			facultyMemberAddressModel.setCategory("R");
			facultyMemberAddressModel.setStatus("A");
	
			CountryList country = new CountryList();
			country.setName(request.getParameter("country"));
			country.setCode(request.getParameter("country"));
			facultyMemberAddressModel.setCountryList(country);		
	
			System.out.println("FACulty Member Address: "+facultyMemberAddressModel);
			facultyMemberModel.getAddress().add(facultyMemberAddressModel);
			facultyMemberAddressModel.setfMAddress(facultyMemberModel);
		} catch (Exception e) {
			System.out.println("\nError in UpdFormValueToRModel: \n" + e);
		} finally {
			System.out.println("INPUT VALUES :" + facultyMemberModel);
		}
		return facultyMemberModel;
	}		

	private FacultyModel UpdateFacultyValuesToRModel(FacultyModel siModel, HttpServletRequest request) {
		System.out.println("action2 :" );
        try {
			siModel.setCode(request.getParameter("Code"));
			siModel.setName(request.getParameter("Name"));
			siModel.setRegNo("MK308");
			siModel.setStatus("A");
			siModel.setCreatedBy("KNRAI");
			siModel.setUpdatedBy("KNRAI");
			siModel.setCreatedOn(new Date());
			siModel.setUpdatedOn(new Date());
			System.out.println("Faculty Information: "+siModel);
        }catch (Exception e) {
        	System.out.println("Error: update value in model :" + e);
        }
		return siModel;
	}

}
