package com.rao.System.SSP;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raoSystem.constants.ComVar;

public class SSPInfoCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step1: KNRAI model creating ");

		SSPModel user = new SSPModel();
		System.out.println("Step1: Assign value to DAO class");

		System.out.println(session.getAttribute("XPRT"));
		DaoNewSSP.ShowSSPUserInputInfo(user);

		try {
			
			/*
			 * user.setEmailId(request.getParameter("inputEmail4"));
			 * user.setRwaRegNo(request.getParameter("RwaRegNo"));
			 * user.setUserID(request.getParameter("KNRAI"));
			 */

			  user.setRwaRegNo("MK107");
			  user.setUserID("KNRAI");
				DaoNewSSP.ShowSSPUserInputInfo(user);
			  
			  
			  user.setFname(request.getParameter("inputFName"));
			  user.setLname(request.getParameter("inputLName"));
			  user.setGender(request.getParameter("inputGender"));
			  user.setDOB(request.getParameter("inputDOB"));
			  user.setPanCardNo(request.getParameter("inputPanCardNo"));
			  user.setEmailId(request.getParameter("inputEmail4"));
			  user.setMobileNO(request.getParameter("inputMobile"));
			  user.setAadharNO(request.getParameter("inputAadharNO"));
			  user.setFFName(request.getParameter("inputFFName"));
			  user.setFLName(request.getParameter("inputFLName"));
			  user.setFGender(request.getParameter("inputFGender"));
			  user.setFMobileNO(request.getParameter("inputFMobile"));
			  user.setFEmailId(request.getParameter("inputFEmail"));
			  user.setFAadharNO(request.getParameter("inputFAadharNO"));
	        
	        user.setPAddress(request.getParameter("inputPAddress"));
	    	user.setBlockNO(request.getParameter("inputBlock"));
	    	user.setSector(request.getParameter("inputSector"));
	    	user.setCity(request.getParameter("inputCity"));
	    	user.setState(request.getParameter("inputState"));
	    	user.setCountry(request.getParameter("inputCountry"));
	    	user.setZipCode(request.getParameter("inputpincode"));

	    	
	     	user.setCAddress(request.getParameter("inputCAddress"));
	        user.setCBlock(request.getParameter("inputCBlock"));
	        user.setCSector(request.getParameter("inputCSector"));
	        user.setCCity(request.getParameter("inputCCity"));
	        user.setCState(request.getParameter("inputCState"));
	        user.setCCountry(request.getParameter("inputCCountry"));
	        user.setCZipCode(request.getParameter("inputCPincode")); 

	        
	    	user.setArmsNo(request.getParameter("inputGunNo")); 
	    	user.setArmsType(request.getParameter("inputGunType")); 
	    	user.setArmsMadeFromCity(request.getParameter("inputGunMadeCity")); 
	    	user.setArmsPurchaseFrom(request.getParameter("inputPurchaseFrom")); 
	    	user.setArmsPurchaseYear(request.getParameter("inputPurchaseYear")); 
	    	user.setArmsIssuedInName(request.getParameter("inputGunIssuedName")); 	
    	
	        user.setDLNO(request.getParameter("inputLicenseNO"));
	        user.setDLIssuefromCity(request.getParameter("inputLicenseCity"));
	        user.setDLIssueDate(request.getParameter("inputLicenseDate"));
	        user.setDLExpiryDate(request.getParameter("inputExpiryDate"));

			/*
			  user.setDLIRTOAddress(request.getParameter("inputDLAddress"));
			  user.setDLBlockNO(request.getParameter("inputDLBlock"));
			  user.setDLSector(request.getParameter("inputDLSector"));
			  user.setDLCity(request.getParameter("inputDLCity"));
			  user.setDLState(request.getParameter("inputDLState"));
			  user.setDLCountry(request.getParameter("inputDLCountry"));
			  user.setDLZipCode(request.getParameter("inputDLpincode"));
			*/ 
			user.setOrgName(request.getParameter("inputPreOrgName"));
			user.setEmployeeNo(request.getParameter("inputEmpNO"));
			user.setDesignation(request.getParameter("inputDesignation"));
			user.setDOJ(request.getParameter("inputDateJoin"));
			user.setDOR(request.getParameter("inputDateRelev"));
			user.setReportingOfficer(request.getParameter("inputReproting"));
			user.setOEmailID(request.getParameter("inputRepEmail"));
			user.setOAdress(request.getParameter("inputOAddress"));
			user.setOBlock(request.getParameter("inputOBlock"));
			user.setOSector(request.getParameter("inputOSector"));
			user.setOCity(request.getParameter("inputOCity"));
			user.setOState(request.getParameter("inputOState"));
			user.setOcountry(request.getParameter("inputOCountry"));
			user.setOPinCode(request.getParameter("inputOpincode"));		        
	
			DaoNewSSP.ShowSSPUserInputInfo(user);
			System.out.println("ACT TYPE :" +session.getAttribute("ACT"));

			if (session.getAttribute("ACT").equals("ACTb")) {
				user.setTranType("EDIT");
			}	
			user = DaoNewSSP.CreateNewSSPInfo(user);
		//	user = DaoSearchDriver.DriverCheck(user);
			if (user.isValid()) {
			    switch(user.getSPstatus()){  
			    case 0:   // Record Not Exist [DB]
			    	session.setAttribute("Message"," Invalid Email Id  / RWA Registraion No.");
		            System.out.println("Invalid Email Id  / RWA Registraion No.") ;
			    	response.sendRedirect("SSPInformation/SSPMainPage.jsp");
			    	break;
			    case 1:   // Record Exist [DB]
			    	session.setAttribute("Message"," Secuirty Staff Infromation Created Successfully");
			    	response.sendRedirect("SuccessMsg.jsp");
			    	break;  
			    case 2:   
			    	session.setAttribute("Message"," Invalid Email Id / RWA NO. Record already exist");
		            System.out.println("Invalid Email Id  / RWA Registraion No.") ;
			    	response.sendRedirect("SSPInformation/NewSSPInfo.jsp");
			    	break;  
			    default:  
			    	session.setAttribute("Message"," Technical Issue ! Please contact to System Admin ");
			    	response.sendRedirect("SuccessMsg.jsp");
			    	break;  
				}
			} else {
				if (user.getSPstatus()==2){
				} else {
				}
			}
		}catch (Exception e){
	    	session.setAttribute("Message"," Technical Issue ! Please contact to System Admin ()");
	           System.out.println("Technical Issue ! Please contact to System Admin " + e) ;
	    	response.sendRedirect("SuccessMsg.jsp");
 		}
	} 

}



