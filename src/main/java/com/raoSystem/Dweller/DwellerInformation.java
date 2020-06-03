package com.raoSystem.Dweller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raoSystem.FLTOWN.DAOFltOwner;
import com.raoSystem.FLTOWN.FLTOWNModel;


public class DwellerInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step 1: Information Model Creating ");
		
		DwellerModel user = new DwellerModel();
		user.setEmailId(request.getParameter("EmailId"));
		//user.setRwaRegNo(request.getParameter("inputRwaRegNo"));
		user.setRwaRegNo("MK107");
		user.setMobileNO(request.getParameter("MobileNo"));
		user.setActionType(Integer.parseInt(request.getParameter("ActionType")));
		System.out.println(" Step 2: Parameter Valuse pass to SP to retrieve data--> Email ID" + user.getEmailId() + " , RWA Reg Code -"
				+ user.getRwaRegNo() + " , Mobile No.:"+ user.MobileNO +" , Action Type - "+user.getActionType());
		user.setTranType("VIEW");
		try {
			user = DAODweller.DwellerInfoRetriev(user);
			System.out.println("sp status owner information :" + user.isValid() +": " + user.getSPstatus());

			/*
			 * if(user.getSPstatus()==3) { session.setAttribute("Message",
			 * " Technical Issue !Unable to Process Driver Information. Please contact to System Admin "
			 * ); response.sendRedirect("Success.jsp"); }
			 */
			switch (user.getSPstatus()) {
			case 0: // Record Not Exist [DB]
				session.setAttribute("Message", " Invalid Email Id  / RWA Registraion No.");
				System.out.println("Invalid Email Id  / RWA Registraion No.");
				response.sendRedirect("SuccessMsf.jsp/DwellerMainPage.jsp");
				break;
			case 1: // Record Exist [DB]
				user = SetValueToSessionVar(user, session);
				System.out.println("setsession value");
				switch (user.getActionType()) {
				case 0:
					break;
				case 1:
					System.out.println("Step 3. page forward to  Dweller Information/ViewOwnInfo.jsp");
					response.sendRedirect("DwellerInformation/ViewOwnerInfo.jsp");
					break;
				case 2: // Edit Information
					System.out.println("Step 3. page forward to Dweller Information/EditDWLInfo.jsp");
					response.sendRedirect("DwellerInformation/EditDwellerInfo.jsp");
					break;
				}
				break;
			case 2:
				session.setAttribute("Message",	" Invalid Email Id / RWA NO. More than one Record Exist! Contact System Admin.");
				System.out.println("Invalid Email Id  / RWA Registraion No.");
				response.sendRedirect("DwellerInformation/DwellerMainPage.jsp");
				break;
			default:
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
				break;
			}
	
		} catch (Exception e) {
			session.setAttribute("Message",
					" Technical Issue !Unable to update Dweller Information. Please contact to System Admin ");
			response.sendRedirect("SuccessMsg.jsp");
		}
	
	}
	
	private DwellerModel SetValueToSessionVar(DwellerModel user, HttpSession session) {
		session.setAttribute("EmailID", user.getEmailId());
		session.setAttribute("RwaRegNo", user.getRwaRegNo());
		session.setAttribute("UserID ", user.getUserID());

		session.setAttribute("inputFName", user.getFname());
		session.setAttribute("inputLName", user.getLname());
		session.setAttribute("inputGender", user.getGender());
		session.setAttribute("inputEmail4", user.getEmailId());
		session.setAttribute("inputMobile", user.getMobileNO());
		session.setAttribute("inputFFName", user.getFFName());
		session.setAttribute("inputFLName", user.getFLName());
		session.setAttribute("inputFMobileNo", user.getFMobileNo());

		session.setAttribute("inputPAddress", user.getPAddress());
		session.setAttribute("inputBlock", user.getBlockNO());
		session.setAttribute("inputSector", user.getSector());
		session.setAttribute("inputCity", user.getCity());
		session.setAttribute("inputState", user.getState());
		session.setAttribute("inputCountry", user.getCountry());
		session.setAttribute("inputPincode", user.getZipCode());

		session.setAttribute("inputTAddress", user.getTAddress());
		session.setAttribute("inputTBlock", user.getTBlockNO());
		session.setAttribute("inputTSector", user.getTSector());
		session.setAttribute("inputTCity", user.getTCity());
		session.setAttribute("inputTState", user.getTState());
		session.setAttribute("inputTCountry", user.getTCountry());
		session.setAttribute("inputTPincode", user.getTZipCode());
		
		session.setAttribute("inputPreOrgName", user.getOrgName());
		session.setAttribute("inputEmpNO", user.getEmployeeNo());
		session.setAttribute("inputDesignation", user.getDesignation());
		session.setAttribute("inputOAddress", user.getOAdress());
		session.setAttribute("inputOBlock", user.getOBlock());
		session.setAttribute("inputOSector", user.getOSector());
		session.setAttribute("inputOCity", user.getOCity());
		session.setAttribute("inputOState", user.getOState());
		session.setAttribute("inputOCountry", user.getOcountry());
		session.setAttribute("inputOpincode", user.getOPinCode());

		session.setAttribute("inputVehTypel1", user.getVehcileType1());
		session.setAttribute("inputVehManufacture1", user.getVehcileManfacturer1());
		session.setAttribute("inputVehModel1", user.getVehcileModel1());
		session.setAttribute("inputVehNo1", user.getVehcileNo1());
		session.setAttribute("inputVehColor1", user.getVehcileColor1());

		session.setAttribute("inputVehTypel2", user.getVehcileType2());
		session.setAttribute("inputVehManufacture2", user.getVehcileManfacturer2());
		session.setAttribute("inputVehModel2", user.getVehcileModel2());
		session.setAttribute("inputVehNo2", user.getVehcileNo2());
		session.setAttribute("inputVehColor2", user.getVehcileColor2());
		
		session.setAttribute("inputDRVFName", user.getDrvFname());
		session.setAttribute("inputDRVLName", user.getDrvLname());
		session.setAttribute("inputDRVGender", user.getDrvGender());
		session.setAttribute("inputDRVAadharNo", user.getDrvAadharNO());
		session.setAttribute("inputDRVMobile", user.getDrvMobileNO());
		session.setAttribute("inputDRVDlNo", user.getDrvDLNo());
		
		session.setAttribute("inputHKMName", user.getHKMFname());
		session.setAttribute("inputHKMLName", user.getHKMLname());
		session.setAttribute("inputHKMGender", user.getHKMGender());
		session.setAttribute("inputHKMAadharNo", user.getHKMAadharNO());
		session.setAttribute("inputHKMMobile", user.getHKMMobileNO());

		session.setAttribute("inputShiftIn", user.getShiftIn());
		session.setAttribute("inputShiftOut", user.getShiftOut());
		session.setAttribute("inputOwnEmail4", user.getOwnEmail());
		session.setAttribute("inputOwnMobileNo", user.getOwnMobileNO());
		
		return user;
	
	}
}
