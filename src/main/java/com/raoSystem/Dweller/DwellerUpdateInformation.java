package com.raoSystem.Dweller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DwellerUpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession(true);
		DwellerModel user = new DwellerModel();
		System.out.println("Step 4.: Created Driver information model successfully");
		try {
			DwellerNewInfoCheck setFormValue = new DwellerNewInfoCheck();
			user = setFormValue.UpdateFormValueToUserObj(user, request);
			user.setRwaRegNo((String) session.getAttribute("RwaRegNo"));
			user.setUserID("inputEmail4");
			System.out.println("Step 5 : sending data for update SSPInfo");
			user = DAODweller.UpdateDwellerInfo(user);
			
			if (user.isValid()) {
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("DwellerInformation/DwellerMainPage.jsp");
					break;
				case 1: // Record Exist [DB]
					session.setAttribute("Message", " Owner Infromation Updated Successfully");
					removeSessionValue(session);
					response.sendRedirect("SuccessMsg.jsp");
					break;
				default:
					session.setAttribute("Message",
							" Technical Issue ! Unable to Update Owner Information. Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
			} else {
				session.setAttribute("Message",
						" Technical Issue ! Owner Information not updated . Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		} catch (Exception e) {
			System.out.println("Technical Issue ! Please contact to System Admin " + e);
			session.setAttribute("Message",
					" Technical Issue ! Owner Info not updated . Please contact to System Admin :" + e);
			response.sendRedirect("SuccessMsg.jsp");
		}
	}


	private void removeSessionValue(HttpSession session) {
		session.removeAttribute("EmailID");
		session.removeAttribute("RwaRegNo");
		
		session.removeAttribute("EmailID");
		session.removeAttribute("RwaRegNo");
		session.removeAttribute("UserID ");

		session.removeAttribute("inputFName");
		session.removeAttribute("inputLName");
		session.removeAttribute("inputGender");
		session.removeAttribute("inputEmail4");
		session.removeAttribute("inputMobile");
		session.removeAttribute("inputFFName");
		session.removeAttribute("inputFLName");
		session.removeAttribute("inputFMobileNo");

		session.removeAttribute("inputPAddress");
		session.removeAttribute("inputBlock" );
		session.removeAttribute("inputSector" );
		session.removeAttribute("inputCity" );
		session.removeAttribute("inputState");
		session.removeAttribute("inputCountry");
		session.removeAttribute("inputPincode");

		session.removeAttribute("inputTAddress");
		session.removeAttribute("inputTBlock");
		session.removeAttribute("inputTSector");
		session.removeAttribute("inputTCity");
		session.removeAttribute("inputTState");
		session.removeAttribute("inputTCountry");
		session.removeAttribute("inputTPincode");
		
		session.removeAttribute("inputPreOrgName");
		session.removeAttribute("inputEmpNO");
		session.removeAttribute("inputDesignation");
		session.removeAttribute("inputOAddress");
		session.removeAttribute("inputOBlock");
		session.removeAttribute("inputOSector");
		session.removeAttribute("inputOCity");
		session.removeAttribute("inputOState");
		session.removeAttribute("inputOCountry");
		session.removeAttribute("inputOpincode");

		session.removeAttribute("inputVehTypel1");
		session.removeAttribute("inputVehManufacture1");
		session.removeAttribute("inputVehModel1");
		session.removeAttribute("inputVehNo1");
		session.removeAttribute("inputVehColor1");

		session.removeAttribute("inputVehTypel2");
		session.removeAttribute("inputVehManufacture2");
		session.removeAttribute("inputVehModel2");
		session.removeAttribute("inputVehNo2");
		session.removeAttribute("inputVehColor2");
		
		session.removeAttribute("inputDRVFName");
		session.removeAttribute("inputDRVLName");
		session.removeAttribute("inputDRVGender");
		session.removeAttribute("inputDRVAadharNo");
		session.removeAttribute("inputDRVMobile");
		session.removeAttribute("inputDRVDlNo");
		
		session.removeAttribute("inputHKMName");
		session.removeAttribute("inputHKMLName");
		session.removeAttribute("inputHKMGender");
		session.removeAttribute("inputHKMAadharNo");
		session.removeAttribute("inputHKMMobile");

		session.removeAttribute("inputShiftIn");
		session.removeAttribute("inputShiftOut");
		session.removeAttribute("inputOwnEmail");
		session.removeAttribute("inputOwnMobileNo");
		
	
	}

}
