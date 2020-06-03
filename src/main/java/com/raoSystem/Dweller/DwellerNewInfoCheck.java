package com.raoSystem.Dweller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raoSystem.FLTOWN.DAOFltOwner;
import com.raoSystem.FLTOWN.FLTOWNModel;


public class DwellerNewInfoCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step1: KNRAI model creating ");
		DwellerModel user = new DwellerModel();
		
		try {
			user = UpdateFormValueToUserObj(user, request);
			System.out.println("Step2: set user input in DwellerModel creating ");
			user = DAODweller.CreateNewDwellerInfo(user);
			if (user.isValid()) {
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("DwellerInformation/DwellerMainPage.jsp");
					break;
				case 1: // Record Exist [DB]
					session.setAttribute("Message", "  Dweller Infromation Created Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message", " Invalid Email Id / RWA NO. Record already exist");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("DwellerInformation/NewDwellerInfo.jsp");
					break;
				default:
					session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
			} else {
				session.setAttribute("Message",
						" Technical Issue (Dweller Information not created )! Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		} catch (Exception e) {
			session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
			System.out.println("Technical Issue ! Please contact to System Admin " + e);
			response.sendRedirect("SuccessMsg.jsp");
		}

	}

	public DwellerModel UpdateFormValueToUserObj(DwellerModel user, HttpServletRequest request) {
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
			user.setFMobileNo(request.getParameter("inputFMobile"));
			user.setShiftIn(request.getParameter("inputShiftIn"));
			user.setShiftOut(request.getParameter("inputShiftOut"));

			
			user.setPAddress(request.getParameter("inputPAddress"));
			user.setBlockNO(request.getParameter("inputBlock"));
			user.setSector(request.getParameter("inputSector"));
			user.setCity(request.getParameter("inputCity"));
			user.setState(request.getParameter("inputState"));
			user.setCountry(request.getParameter("inputCountry"));
			user.setZipCode(request.getParameter("inputPincode"));

			user.setTAddress(request.getParameter("inputTAddress"));
			user.setTBlockNO(request.getParameter("inputTBlock"));
			user.setTSector(request.getParameter("inputTSector"));
			user.setTCity(request.getParameter("inputTCity"));
			user.setTState(request.getParameter("inputTState"));
			user.setTCountry(request.getParameter("inputTCountry"));
			user.setTZipCode(request.getParameter("inputTPincode"));
			
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

//			user.setOwnFname(request.getParameter("inputOwnFName"));
//			user.setOwnLname(request.getParameter("inputOwnLName"));
			user.setOwnEmail(request.getParameter("inputOwnEmail4"));
			user.setOwnMobileNO(request.getParameter("inputOwnMobile"));


		} catch (Exception e) {
           System.out.println(e);
		}
		return user;
	}
	
	
}
