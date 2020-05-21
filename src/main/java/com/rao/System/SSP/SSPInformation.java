package com.rao.System.SSP;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raoSystem.constants.ComVar;
import com.raoSystem.userRegistration.DaoSearchUser;
import com.raoSystem.userRegistration.UserRegInit;

public class SSPInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step1: SSPINFO Model Creating ");

		SSPModel user = new SSPModel();
		System.out.println(session.getAttribute("XPRT"));
		user.setTranType(request.getParameter("ActionType"));
		switch (user.getTranType()) {
		case "0":
			break;
		case "1":
			user.setEmailId(request.getParameter("EmailId"));
			user.setRwaRegNo(request.getParameter("rwaRegNo"));
			user.setDLNO(request.getParameter("DLNO"));
			user.setActionType(Integer.parseInt(request.getParameter("ActionType")));
			System.out.println("Parameter Valuse pass to SP -->" + user.getEmailId() + " : " + user.getRwaRegNo() + ": "
					+ user.getDLNO());
			user.setTranType("VIEW");

			try {
				user = DaoNewSSP.SSPInfoRetriev(user);
				if (user.isValid()) {
					switch (user.getSPstatus()) {
					case 0: // Record Not Exist [DB]
						session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/SSPMainPage.jsp");
						break;
					case 1: // Record Exist [DB]

						session.setAttribute("ACTYPE", "EDIT");
						response.sendRedirect("SSPInformation/EditSSPInfo.jsp");
						break;
					case 2:
						session.setAttribute("Message", " Invalid Email Id / RWA NO. Record already exist");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/NewSSPInfo.jsp");
						break;
					default:
						session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
						response.sendRedirect("SSPInformation/SSPMainPage.jsp");
						break;
					}
				} else {
					session.setAttribute("Message", " Technical Issue !Unable to update SSPInfo. Please contact to System Admin ");
					response.sendRedirect("SSPInformation/SSPMainPage.jsp");
				}
			} catch (Exception e) {
				System.out.println("Technical Issue ! Please contact to System Admin ");
				session.setAttribute("Message", " Technical Issue !(Unable to update SSPInfo). Please contact to System Admin ");
				response.sendRedirect("../SuccessMsg.jsp");
			}

			break;
		case "2" :
			user.setEmailId(request.getParameter("EmailId"));
			user.setRwaRegNo(request.getParameter("rwaRegNo"));
			user.setDLNO(request.getParameter("DLNO"));
			user.setActionType(Integer.parseInt(request.getParameter("ActionType")));
			System.out.println(" Step 2 Parameter Valuse pass to SP to retrieve data-->" + user.getEmailId() + " : " + user.getRwaRegNo() + ": "
					+ user.getDLNO());
			user.setTranType("VIEW");

			try {
				user = DaoNewSSP.SSPInfoRetriev(user);
				if (user.isValid()) {
					switch (user.getSPstatus()) {
					case 0: // Record Not Exist [DB]
						session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/SSPMainPage.jsp");
						break;
					case 1: // Record Exist [DB]

						session.setAttribute("EmailID", user.getEmailId());
						session.setAttribute("RwaRegNo", user.getRwaRegNo());

						session.setAttribute("UserID ", user.getUserID());
						session.setAttribute("inputFName", user.getFname());
						session.setAttribute("inputLName", user.getLname());
						session.setAttribute("inputGender", user.getGender());
						session.setAttribute("inputDOB", user.getDOB());
						session.setAttribute("inputPanCardNo", user.getPanCardNo());
						session.setAttribute("inputEmail4", user.getEmailId());

						session.setAttribute("inputMobile", user.getMobileNO());
						session.setAttribute("inputAadharNO", user.getAadharNO());
						session.setAttribute("inputFFName", user.getFFName());
						session.setAttribute("inputFLName", user.getFLName());
						session.setAttribute("inputFGender", user.getFGender());
						session.setAttribute("inputFMobile", user.getFMobileNO());
						session.setAttribute("inputFEmail", user.getFEmailId());
						session.setAttribute("inputFAadharNO", user.getFAadharNO());

						// permanent Address
						session.setAttribute("inputPAddress", user.getPAddress());
						session.setAttribute("inputPBlock", user.getBlockNO());
						session.setAttribute("inputPSector", user.getSector());
						session.setAttribute("inputPCity", user.getCity());
						session.setAttribute("inputPState", user.getState());
						session.setAttribute("inputPCountry", user.getCountry());
						session.setAttribute("inputPPincode", user.getZipCode());
						// sspc Address
						session.setAttribute("inputCAddress", user.getCAddress());
						session.setAttribute("inputCBlock", user.getCBlock());
						session.setAttribute("inputCSector", user.getCSector());
						session.setAttribute("inputCCity", user.getCCity());
						session.setAttribute("inputCState", user.getCState());
						session.setAttribute("inputCCountry", user.getCCountry());
						session.setAttribute("inputCPincode", user.getCZipCode());

						// ssp Arm Details
						session.setAttribute("inputGunNo", user.getArmsNo());
						session.setAttribute("inputGunType", user.getArmsType());
						session.setAttribute("inputGunMadeCity", user.getArmsMadeFromCity());
						session.setAttribute("inputPurchaseFrom", user.getArmsPurchaseFrom());
						session.setAttribute("inputPurchaseYear", user.getArmsPurchaseYear());
						session.setAttribute("inputGunIssuedName", user.getArmsIssuedInName());

						// ssp dl details

						session.setAttribute("inputLicenseNO", user.getDLNO());
						session.setAttribute("inputLicenseCity", user.getDLIssuefromCity());
						session.setAttribute("inputLicenseDate", user.getDLIssueDate());
						session.setAttribute("inputExpiryDate", user.getDLExpiryDate());
						session.setAttribute("DLIRTOAddress", user.getDLIRTOAddress());
						session.setAttribute("DLBlockNO", user.getDLBlockNO());
						session.setAttribute("DLSector", user.getDLSector());
						session.setAttribute("DLCity", user.getDLCity());
						session.setAttribute("DLState", user.getDLState());
						session.setAttribute("DLCountry", user.getDLCountry());
						session.setAttribute("DLZipCode", user.getDLZipCode());

						// ssp ex organization

						session.setAttribute("inputPreOrgName", user.getOrgName());
						session.setAttribute("inputEmpNO", user.getEmployeeNo());
						session.setAttribute("inputDesignation", user.getDesignation());
						session.setAttribute("inputDateJoin", user.getDOJ());
						session.setAttribute("inputDateRelev", user.getDOR());
						session.setAttribute("inputReproting", user.getReportingOfficer());
						session.setAttribute("inputRepEmail", user.getOEmailID());
						session.setAttribute("inputOAddress", user.getOAdress());
						session.setAttribute("inputOBlock", user.getOBlock());
						session.setAttribute("inputOSector", user.getOSector());
						session.setAttribute("inputOCity", user.getOCity());
						session.setAttribute("inputOState", user.getOState());
						session.setAttribute("inputOCountry", user.getOcountry());
						session.setAttribute("inputOpincode", user.getOPinCode());
						System.out.println("Step 3. page forward to SSSPInformation/EditSSPInfo.jsp");	
						response.sendRedirect("SSPInformation/EditSSPInfo.jsp");
						break;
					case 2:
						session.setAttribute("Message", " Invalid Email Id / RWA NO. Record already exist");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/NewSSPInfo.jsp");
						break;
					default:
						session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
						response.sendRedirect("../Success.jsp");
						break;
					}
				} else {
					session.setAttribute("Message", " Technical Issue !Unable to update SSPInfo. Please contact to System Admin ");
					response.sendRedirect("SSPInformation/SSPMainPage.jsp");
				}
			} catch (Exception e) {
				System.out.println("Technical Issue ! Please contact to System Admin ");
				session.setAttribute("Message", " Technical Issue !(Unable to update SSPInfo). Please contact to System Admin ");
				response.sendRedirect("../SuccessMsg.jsp");
			}

			break;
		case "3":
			break;
		default:
			break;
		}
/*
		if (session.getAttribute("XPRT").equals("XPRT")) {

			try {

				user.setEmailId(request.getParameter("EmailID"));
				user.setRwaRegNo(request.getParameter("RwaRegNo"));
				user.setUserID(request.getParameter("UserID"));
				user.setFname(request.getParameter("inputFName"));
				user.setLname(request.getParameter("inputLName"));
				user.setGender(request.getParameter("inputGender"));
				user.setDOB(request.getParameter("inputDOB"));
				user.setMobileNO(request.getParameter("inputMobile"));
				user.setEmailId(request.getParameter("inputEmail4"));
				user.setAadharNO(request.getParameter("inputAadharNO"));
				user.setPanCardNo(request.getParameter("inputPanCardNo"));
				user.setFFName(request.getParameter("inputFName"));
				user.setFLName(request.getParameter("inputLName"));
				user.setFGender(request.getParameter("inputFGender"));
				user.setFMobileNO(request.getParameter("inputFMobile"));
				user.setFEmailId(request.getParameter("inputFEmail"));
				user.setFAadharNO(request.getParameter("inputFAadharNO"));

				user.setPAddress(request.getParameter("inputPAddress"));
				user.setBlockNO(request.getParameter("inputPBlock"));
				user.setSector(request.getParameter("inputPSector"));
				user.setCity(request.getParameter("inputPCity"));
				user.setState(request.getParameter("inputPState"));
				user.setCountry(request.getParameter("inputPCountry"));
				user.setZipCode(request.getParameter("inputPPincode"));

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

				
				 * user.setDLIRTOAddress(request.getParameter("inputDLAddress"));
				 * user.setDLBlockNO(request.getParameter("inputDLBlock"));
				 * user.setDLSector(request.getParameter("inputDLSector"));
				 * user.setDLCity(request.getParameter("inputDLCity"));
				 * user.setDLState(request.getParameter("inputDLState"));
				 * user.setDLCountry(request.getParameter("inputDLCountry"));
				 * user.setDLZipCode(request.getParameter("inputDLpincode"));
				 
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
				ComVar.myStat.registerOutParameter(56, Types.INTEGER);

				if (session.getAttribute("ACT").equals("ACTb")) {
					user.setTranType("EDIT");
				}
				user = DaoNewSSP.CreateNewSSPInfo(user);
				// user = DaoSearchDriver.DriverCheck(user);
				if (user.isValid()) {
					switch (user.getSPstatus()) {
					case 0: // Record Not Exist [DB]
						session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/SSPMainPage.jsp");
						break;
					case 1: // Record Exist [DB]
						response.sendRedirect("SuccessMsg.jsp");
						break;
					case 2:
						session.setAttribute("InvalidFPWDMsg", " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						break;
					default:
						session.setAttribute("InvalidFPWDMsg", " Technical Issue ! Please contact to System Admin ");
						break;
					}
				} else {
					if (user.getSPstatus() == 2) {
					} else {
					}
				}
			} catch (Exception e) {
				System.out.println("Technical Issue ! Please contact to System Admin ");
				session.setAttribute("InvalidFPWDMsg",
						" Catch Technical Issue (User Not Created)! Please contact to System Admin ");
			}

		} else {

			user.setEmailId(request.getParameter("EmailId"));
			user.setRwaRegNo(request.getParameter("rwaRegNo"));
			user.setDLNO(request.getParameter("DLNO"));
			user.setActionType(Integer.parseInt(request.getParameter("ActionType")));
			System.out.println("Parameter Valuse pass to SP -->" + user.getEmailId() + " : " + user.getRwaRegNo() + ": "
					+ user.getDLNO());
			user.setTranType("VIEW");

			try {
				// user = DaoSearchDriver.DriverCheck(user);
				user = DaoNewSSP.SSPInfoRetriev(user);
				if (user.isValid()) {
					switch (user.getSPstatus()) {
					case 0: // Record Not Exist [DB]
						session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/SSPMainPage.jsp");
						break;
					case 1: // Record Exist [DB]

						session.setAttribute("EmailID", user.getEmailId());
						session.setAttribute("RwaRegNo", user.getRwaRegNo());

						session.setAttribute("UserID ", user.getUserID());
						session.setAttribute("inputFName", user.getFname());
						session.setAttribute("inputLName", user.getLname());
						session.setAttribute("inputGender", user.getGender());
						session.setAttribute("inputDOB", user.getDOB());
						session.setAttribute("inputPanCardNo", user.getPanCardNo());
						session.setAttribute("inputEmail4", user.getEmailId());

						session.setAttribute("inputMobile", user.getMobileNO());
						session.setAttribute("inputAadharNO", user.getAadharNO());
						session.setAttribute("inputFFName", user.getFFName());
						session.setAttribute("inputFLName", user.getFLName());
						session.setAttribute("inputFGender", user.getFGender());
						session.setAttribute("inputFMobile", user.getFMobileNO());
						session.setAttribute("inputFEmail", user.getFEmailId());
						session.setAttribute("inputFAadharNO.", user.getFAadharNO());

						// permanent Address
						session.setAttribute("inputPAddress", user.getPAddress());
						session.setAttribute("inputPBlock", user.getBlockNO());
						session.setAttribute("inputPSector", user.getSector());
						session.setAttribute("inputPCity", user.getCity());
						session.setAttribute("inputPState", user.getState());
						session.setAttribute("inputPCountry", user.getCountry());
						session.setAttribute("inputPPincode", user.getZipCode());
						// sspc Address
						session.setAttribute("inputCAddress", user.getCAddress());
						session.setAttribute("inputCBlock", user.getCBlock());
						session.setAttribute("inputCSector", user.getCSector());
						session.setAttribute("inputCCity", user.getCCity());
						session.setAttribute("inputCState", user.getCState());
						session.setAttribute("inputCCountry", user.getCCountry());
						session.setAttribute("inputCPincode", user.getCZipCode());

						// ssp Arm Details
						session.setAttribute("inputGunNo", user.getArmsNo());
						session.setAttribute("inputGunType", user.getArmsType());
						session.setAttribute("inputGunMadeCity", user.getArmsMadeFromCity());
						session.setAttribute("inputPurchaseFrom", user.getArmsPurchaseFrom());
						session.setAttribute("inputPurchaseYear", user.getArmsPurchaseYear());
						session.setAttribute("inputGunIssuedName", user.getArmsIssuedInName());

						// ssp dl details

						session.setAttribute("inputLicenseNO", user.getDLNO());
						session.setAttribute("inputLicenseCity", user.getDLIssuefromCity());
						session.setAttribute("inputLicenseDate", user.getDLIssueDate());
						session.setAttribute("inputExpiryDate", user.getDLExpiryDate());
						session.setAttribute("DLIRTOAddress", user.getDLIRTOAddress());
						session.setAttribute("DLBlockNO", user.getDLBlockNO());
						session.setAttribute("DLSector", user.getDLSector());
						session.setAttribute("DLCity", user.getDLCity());
						session.setAttribute("DLState", user.getDLState());
						session.setAttribute("DLCountry", user.getDLCountry());
						session.setAttribute("DLZipCode", user.getDLZipCode());

						// ssp ex organization

						session.setAttribute("inputPreOrgName", user.getOrgName());
						session.setAttribute("inputEmpNO", user.getEmployeeNo());
						session.setAttribute("inputDesignation", user.getDesignation());
						session.setAttribute("inputDateJoin", user.getDOJ());
						session.setAttribute("inputDateRelev", user.getDOR());
						session.setAttribute("inputReproting", user.getReportingOfficer());
						session.setAttribute("inputRepEmail", user.getOEmailID());
						session.setAttribute("inputOAddress", user.getOAdress());
						session.setAttribute("inputOBlock", user.getOBlock());
						session.setAttribute("inputOSector", user.getOSector());
						session.setAttribute("inputOCity", user.getOCity());
						session.setAttribute("inputOState", user.getOState());
						session.setAttribute("inputOCountry", user.getOcountry());
						session.setAttribute("inputOpincode", user.getOPinCode());

						session.setAttribute("ACTYPE", "EDIT");
						response.sendRedirect("SSPInformation/EditSSPInfo.jsp");
						break;
					case 2:
						session.setAttribute("Message", " Invalid Email Id / RWA NO. Record already exist");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("SSPInformation/NewSSPInfo.jsp");
						break;
					default:
						session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
						response.sendRedirect("../Success.jsp");
						break;
					}
				} else {
					if (user.getSPstatus() == 2) {
					} else {
					}
				}
			} catch (Exception e) {
				System.out.println("Technical Issue ! Please contact to System Admin ");
				session.setAttribute("InvalidFPWDMsg",
						" Catch Technical Issue (User Not Created)! Please contact to System Admin ");
			}

		}
*/
	}
}
