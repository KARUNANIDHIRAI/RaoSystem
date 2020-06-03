package com.raoSystem.FLTOWN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raoSystem.HKM.DAOHKMInfo;

public class FlatOwnerUpdateInfoCehck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		FLTOWNModel user = new FLTOWNModel();
		System.out.println("Step 4.: Created Driver information model successfully");
		try {
			user = UpdateFormValueToUserObj(user, request);
			user.setRwaRegNo((String) session.getAttribute("RwaRegNo"));
			user.setUserID("inputEmail4");
			System.out.println("Step 5 : sending data for update SSPInfo");
			user = DAOFltOwner.UpdateFlatOnwerInfo(user);
			
			if (user.isValid()) {
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("OwnerInformation/OwnerMainPage.jsp");
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

	private FLTOWNModel UpdateFormValueToUserObj(FLTOWNModel user, HttpServletRequest request) {
		try {
			user.setRwaRegNo("MK107");
			user.setUserID("KNRAI");
			user.setFname(request.getParameter("inputFName"));
			user.setLname(request.getParameter("inputLName"));
			user.setGender(request.getParameter("inputGender"));
			user.setEmailId(request.getParameter("inputEmail4"));
			user.setMobileNO(request.getParameter("inputMobile"));
			user.setFFName(request.getParameter("inputFFName"));
			user.setFLName(request.getParameter("inputFLName"));
			user.setFGender(request.getParameter("inputFGender"));

			user.setPAddress(request.getParameter("inputPAddress"));
			user.setBlockNO(request.getParameter("inputBlock"));
			user.setSector(request.getParameter("inputSector"));
			user.setCity(request.getParameter("inputCity"));
			user.setState(request.getParameter("inputState"));
			user.setCountry(request.getParameter("inputCountry"));
			user.setZipCode(request.getParameter("inputPincode"));

			user.setOrgName(request.getParameter("inputPreOrgName"));
			user.setEmployeeNo(request.getParameter("inputEmpNO"));
			user.setDesignation(request.getParameter("inputDesignation"));
			user.setOAdress(request.getParameter("inputOAddress"));
			user.setOBlock(request.getParameter("inputOBlock"));
			user.setOSector(request.getParameter("inputOSector"));
			user.setOCity(request.getParameter("inputOCity"));
			user.setOState(request.getParameter("inputOState"));
			user.setOcountry(request.getParameter("inputOCountry"));
			user.setOPinCode(request.getParameter("inputOpincode"));

			user.setVehcileType1(request.getParameter("inputVehTypel1"));
			user.setVehcileManfacturer1(request.getParameter("inputVehManufacture1"));
			user.setVehcileModel1(request.getParameter("inputVehModel1"));
			user.setVehcileNo1(request.getParameter("inputVehNo1"));
			user.setVehcileColor1(request.getParameter("inputVehColor1"));

			user.setVehcileType2(request.getParameter("inputVehTypel2"));
			user.setVehcileManfacturer2(request.getParameter("inputVehManufacture2"));
			user.setVehcileModel2(request.getParameter("inputVehModel2"));
			user.setVehcileNo2(request.getParameter("inputVehNo2"));
			user.setVehcileColor2(request.getParameter("inputVehColor2"));
			
			user.setDrvFname(request.getParameter("inputDRVFName"));
			user.setDrvLname(request.getParameter("inputDRVLName"));
			user.setDrvGender(request.getParameter("inputDRVGender"));
			user.setDrvAadharNO(request.getParameter("inputDRVAadharNo"));
			user.setDrvMobileNO(request.getParameter("inputDRVMobile"));
			user.setDrvDLNo(request.getParameter("inputDRVDlNo"));
			
			user.setHKMFname(request.getParameter("inputHKMName"));
			user.setHKMLname(request.getParameter("inputHKMLName"));
			user.setHKMGender(request.getParameter("inputHKMGender"));
			user.setHKMAadharNO(request.getParameter("inputHKMAadharNo"));
			user.setHKMMobileNO(request.getParameter("inputHKMMobile"));

		} catch (Exception e) {
           System.out.println(e);
		}
		return user;
	}

	private void removeSessionValue(HttpSession session) {
		session.removeAttribute("EmailID");
		session.removeAttribute("RwaRegNo");
		session.removeAttribute("inputFName");
		session.removeAttribute("inputLName");
		session.removeAttribute("inputGender");
		session.removeAttribute("inputEmail4");
		session.removeAttribute("inputMobile");
		session.removeAttribute("inputFFName");
		session.removeAttribute("inputFLName");
		session.removeAttribute("inputFGender");

		session.removeAttribute("inputPAddress");
		session.removeAttribute("inputBlock");
		session.removeAttribute("inputSector");
		session.removeAttribute("inputCity");
		session.removeAttribute("inputState");
		session.removeAttribute("inputCountry");
		session.removeAttribute("inputPincode");

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
	
	}
}
