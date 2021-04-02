package com.sm.System.StudentPersonalInfo;
import com.sm.System.FeeDefine.HDAOFeeDefine;
import com.sm.System.StudentPersonalInfo.StudentPInformation;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.Utilities;

/**
 * Servlet implementation class StudentPInformation
 */
public class StudentPInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String erMsg= "Step1:";
		String valMsg=""; 
		StudentPersonalInfoModel SiModel = new StudentPersonalInfoModel();
		String Action = request.getParameter("Action");
		System.out.println(Action);
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "spInformation":	
				SiModel.setRegNo("MK308");
				SiModel = UpdFormValueToModelClass(SiModel,request);
				erMsg = " form value Updated.";
				int rwaStatus = HDAOSpInformation.SpInformation(SiModel,erMsg);
				String hDAOMessage= rwaStatus>0?"THANKS! YOUR ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
				session.setAttribute("Message",hDAOMessage );
				response.sendRedirect("SuccessMsg.jsp");
				break;
			case "xSPIR" :	//Retrieve informations
				erMsg +=" Retrive Fee Information :";
				
				JsonArrayList = HDAOSpInformation.rStudentListClassSectionWise(SiModel, erMsg);
				erMsg +=" Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" : Retrieve info done";
				break; 

			case "rInformation" :	//edit informations
//				System.out.println("\nknrai");
//				System.out.println(request.getParameter("RegDate"));
//				try {
//					System.out.println("String to date Reg :" +Utilities.StringToDate(request.getParameter("RegDate")));
//				} catch (ParseException e) {
//					System.out.println("Error in RegDate Convert:\n" + e);
//				}
//				SchoolInfoModel siModel = new SchoolInfoModel();
//				try {
//					siModel.setRegDate(Utilities.StringToDate(request.getParameter("RegDate")));
//					System.out.println("RegDate Convert:\n" + siModel.getRegDate());
//				} catch (ParseException e) {
//					System.out.println("Error in RegDate Convert:\n" + e);
//				}
				break; 
			case "RWAInformation":	
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}
	}
	
		


	private StudentPersonalInfoModel UpdFormValueToModelClass(StudentPersonalInfoModel siModel, HttpServletRequest request) {
		try {

			System.out.println("updating FV to Model.");
			siModel.setfName(request.getParameter("fName"));
			siModel.setlName(request.getParameter("lName"));
			siModel.setGender(request.getParameter("gender"));
			siModel.setDob(Utilities.StringToDate(request.getParameter("dob")));
			siModel.setAdmNo(request.getParameter("admNo"));
			siModel.setAdmDate(Utilities.StringToDate(request.getParameter("admDate")));
			siModel.setAdmInClass(request.getParameter("admClass"));
			siModel.setPromotedInClass(request.getParameter("curClass"));
			siModel.setSibling(request.getParameter("siblingNo"));
			siModel.setMobileNo(request.getParameter("sMobileNo"));
			siModel.setEmailId(request.getParameter("sEmail"));
			siModel.setFfName(request.getParameter("fFName"));
			siModel.setFlName(request.getParameter("fLName"));
			siModel.setFprofession(request.getParameter("fprofession"));
			siModel.setMfName(request.getParameter("mFName"));
			siModel.setMlName(request.getParameter("mLName"));
			siModel.setMprofession(request.getParameter("mProfession"));
			siModel.setpEmailId(request.getParameter("pEmail"));
			siModel.setpMobileNo(request.getParameter("pMobileNo"));
			System.out.println("siModel:\n "+siModel);

			// Student bank details information
			SBankDetailInfo sBankDetailInfo = new SBankDetailInfo();
			
			sBankDetailInfo.setaCHolderName(request.getParameter("acHName"));		
			sBankDetailInfo.setAcNo(request.getParameter("acNo"));		
			sBankDetailInfo.setActype(request.getParameter("acType"));		
			sBankDetailInfo.setBankName(request.getParameter("bName"));		
			sBankDetailInfo.setBranchName(request.getParameter("bBNnkName"));		
			sBankDetailInfo.setRegNo(siModel.getRegNo());		
			sBankDetailInfo.setiFSC(request.getParameter("ifsCode"));		
			sBankDetailInfo.setCity(request.getParameter("bankCity"));
			sBankDetailInfo.setCountry(request.getParameter("athCountry"));
	
			siModel.getsBankDtl().add(sBankDetailInfo);
			sBankDetailInfo.setStudentBankDetails(siModel);
			System.out.println("Bank Details b: "+sBankDetailInfo);
			

			//address information
			
			StudentAddress sAddress = new StudentAddress();
			sAddress.setRegNo(siModel.getRegNo());
			sAddress.setAddress(request.getParameter("Address"));
			sAddress.setSector(request.getParameter("Sector"));
			sAddress.setCity(request.getParameter("City"));
			sAddress.setState(request.getParameter("State"));
			sAddress.setPinCode(request.getParameter("PostalCode"));
			sAddress.setStatus("A");
			sAddress.setCountry(request.getParameter("country"));
			System.out.println("saddress a: "+sAddress);
			
			siModel.getStudentdAddress().add(sAddress);
			sAddress.setStdAddress(siModel);			
			
			System.out.println("siModel a: "+siModel);

					
			
			//             Student idproof information
			SIdProof sIdProofInfo = new SIdProof();
			sIdProofInfo.setIdHolder("S");
			sIdProofInfo.setRegNo(siModel.getRegNo());
			sIdProofInfo.setIdProof(request.getParameter("sIdProofNo"));
			sIdProofInfo.setIdDocType(request.getParameter("sIdDocType"));
			sIdProofInfo.setStatus("A");
			System.out.println("sIdProofInfo:" + sIdProofInfo);

			siModel.getSidProofInfo().add(sIdProofInfo);
			sIdProofInfo.setSidProof(siModel);
			System.out.println("siModel i: "+siModel);
		
				
			SIdProof fIdProofInfo = new SIdProof();
			fIdProofInfo.setIdHolder("F");
			fIdProofInfo.setRegNo(siModel.getRegNo());
			fIdProofInfo.setIdProof(request.getParameter("fIdProofNo"));
			fIdProofInfo.setIdDocType(request.getParameter("fIdDocType"));
			fIdProofInfo.setStatus("A");
			System.out.println("fIdProofInfo:" + fIdProofInfo);

			siModel.getSidProofInfo().add(sIdProofInfo);
			sIdProofInfo.setSidProof(siModel);
			System.out.println("siModel i: "+siModel);

			
			
			SIdProof mIdProofInfo = new SIdProof();
			mIdProofInfo.setIdHolder("M");
			mIdProofInfo.setRegNo(siModel.getRegNo());
			mIdProofInfo.setIdProof(request.getParameter("mIdProofNo"));
			mIdProofInfo.setIdDocType(request.getParameter("mIdDocType"));
			mIdProofInfo.setStatus("A");
			System.out.println("mIdProofInfo:" + mIdProofInfo);

			siModel.getSidProofInfo().add(mIdProofInfo);
			mIdProofInfo.setSidProof(siModel);

			System.out.println("mIdProofInfo:" + mIdProofInfo);
			
			siModel.setStatus("A");
			siModel.setCreatedBy("KNRAI");
			siModel.setUpdatedBy("KNRAI");
			siModel.setCreatedOn(new Date());
			siModel.setUpdatedOn(new Date());
			System.out.println("\nSP Information: " + siModel);
			
		} catch (Exception e) {
			System.out.println("\nError in UpdFormValueToRModel: \n" + e);
		}
		return siModel;
	}
}// SERVELET EOF
