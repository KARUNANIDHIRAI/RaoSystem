package com.raoSystem.HKM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rao.System.DRV.DAODriverInfo;
import com.rao.System.DRV.DRVModel;

public class HKMInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step1: Information Model Creating ");
	
		HKMModel user = new HKMModel();
		user.setEmailId(request.getParameter("EmailId"));
		user.setRwaRegNo(request.getParameter("rwaRegNo"));
		user.setAadharNO(request.getParameter("MobileNo"));
		user.setActionType(Integer.parseInt(request.getParameter("ActionType")));
		System.out.println(" Step 2 Parameter Valuse pass to SP to retrieve data-->" + user.getEmailId() + " : "
				+ user.getRwaRegNo() + ": " + user.getAadharNO()+ " "+user.getActionType());
		user.setTranType("VIEW");
		try {
			user = DAOHKMInfo.HKMInfoRetriev(user);
			System.out.println("sp status drvinformation :" + user.isValid() +": " + user.getSPstatus());
	
			if (user.isValid()) {
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("HKMInformation/HKMMainPage.jsp");
					break;
				case 1: // Record Exist [DB]
					user = SetValueToSessionVar(user, session);
					System.out.println("setsession value");
					switch (user.getActionType()) {
					case 0:
						break;
					case 1:
						System.out.println("Step 3. page forward to HKMInformation/ViewHKMInfo.jsp");
						response.sendRedirect("HKMInformation/PreviewHKMInfo.jsp");
						break;
					case 2: // Edit Information
						System.out.println("Step 3. page forward to HKMInformation/EditHKMInfo.jsp");
						response.sendRedirect("HKMInformation/EditHKMInfo.jsp");
						break;
					}
					break;
				case 2:
					session.setAttribute("Message",	" Invalid Email Id / RWA NO. More than one Record Exist! Contact System Admin.");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("HKMInformation/HKMMainPage.jsp");
					break;
				default:
					session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("Success.jsp");
					break;
				}
			} else {
				session.setAttribute("Message",
						" Technical Issue !Unable to Process Driver Information. Please contact to System Admin ");
				response.sendRedirect("Success.jsp");
			}
	
		} catch (Exception e) {
			session.setAttribute("Message",
					" Technical Issue !Unable to update Driver Information. Please contact to System Admin ");
			response.sendRedirect("Success.jsp");
	
			
		}
	
	}
	
	public static HKMModel SetValueToSessionVar(HKMModel user, HttpSession session) {
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
		System.out.println("Session Value"+session.getAttribute("inputCCity"));
		session.setAttribute("inputCState", user.getCState());
		session.setAttribute("inputCCountry", user.getCCountry());
		session.setAttribute("inputCPincode", user.getCZipCode());
	

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
	
		return user;
	
	}
}
