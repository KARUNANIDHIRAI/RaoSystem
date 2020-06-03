package com.raoSystem.HKM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rao.System.DRV.DAODriverInfo;
import com.rao.System.DRV.DRVModel;

public class HKMInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			HKMModel user = new HKMModel();
			System.out.println("Step 4.: Created Driver information model successfully");
			try {
				user = UpdateFormValueToUserObj(user, request);
				user.setRwaRegNo((String) session.getAttribute("RwaRegNo"));
				user.setUserID("inputEmail4");
				System.out.println("Step 5 : sending data for update SSPInfo");
				user = DAOHKMInfo.UpdateHKMInfo(user);
				if (user.isValid()) {
					switch (user.getSPstatus()) {
					case 0: // Record Not Exist [DB]
						session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("DRVInformation/DRVMainPage.jsp");
						break;
					case 1: // Record Exist [DB]
						session.setAttribute("Message", " Driver Personal Infromation Updated Successfully");
						removeSessionValue(session);
						response.sendRedirect("SuccessMsg.jsp");
						break;
					default:
						session.setAttribute("Message",
								" Technical Issue ! Unable to Update Driver Information. Please contact to System Admin ");
						response.sendRedirect("SuccessMsg.jsp");
						break;
					}
				} else {
					session.setAttribute("Message",
							" Technical Issue ! Driver Info not updated . Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
				}
			} catch (Exception e) {
				System.out.println("Technical Issue ! Please contact to System Admin " + e);
				session.setAttribute("Message",
						" Technical Issue ! Driver Info not updated . Please contact to System Admin :" + e);
				response.sendRedirect("SuccessMsg.jsp");
			}
		}

		private HKMModel UpdateFormValueToUserObj(HKMModel user, HttpServletRequest request) {
			try {
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
				
				System.out.println("user.set"+user.getCCity());
				user.setCState(request.getParameter("inputCState"));
				user.setCCountry(request.getParameter("inputCCountry"));
				user.setCZipCode(request.getParameter("inputCPincode"));

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
			} catch (Exception e) {
	           System.out.println(e);
			}
			return user;
		}

		private void removeSessionValue(HttpSession session) {
			session.removeAttribute("EmailID");
			session.removeAttribute("RwaRegNo");
			session.removeAttribute("UserID");
			session.removeAttribute("inputFName");
			session.removeAttribute("inputLName");
			session.removeAttribute("inputGender");
			session.removeAttribute("inputDOB");
			session.removeAttribute("inputPanCardNo");
			session.removeAttribute("inputEmail4");
			session.removeAttribute("inputMobile");
			session.removeAttribute("inputAadharNO");
			session.removeAttribute("inputFFName");
			session.removeAttribute("inputFLName");
			session.removeAttribute("inputFGender");
			session.removeAttribute("inputFMobile");
			session.removeAttribute("inputFEmail");
			session.removeAttribute("inputFAadharNO");
			session.removeAttribute("");

			session.removeAttribute("inputPAddress");
			session.removeAttribute("inputPBlock");
			session.removeAttribute("inputPSector");
			session.removeAttribute("inputPCity");
			session.removeAttribute("inputPState");
			session.removeAttribute("inputPCountry");
			session.removeAttribute("inputPPincode");
			session.removeAttribute("inputCAddress");
			session.removeAttribute("inputCBlock");
			session.removeAttribute("inputCSector");
			session.removeAttribute("inputCCity");
			session.removeAttribute("inputCState");
			session.removeAttribute("inputCCountry");
			session.removeAttribute("inputCPincode");

			session.removeAttribute("inputPreOrgName");
			session.removeAttribute("inputEmpNO");
			session.removeAttribute("inputDesignation");
			session.removeAttribute("inputDateJoin");
			session.removeAttribute("inputDateRelev");
			session.removeAttribute("inputReproting");
			session.removeAttribute("inputRepEmail");
			session.removeAttribute("inputOAddress");
			session.removeAttribute("inputOBlock");
			session.removeAttribute("inputOSector");
			session.removeAttribute("inputOCity");
			session.removeAttribute("inputOState");
			session.removeAttribute("inputOCountry");
			session.removeAttribute("inputOpincode");
		}

}
