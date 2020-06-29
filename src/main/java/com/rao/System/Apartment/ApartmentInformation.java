package com.rao.System.Apartment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raoSystem.Dweller.DAODweller;
import com.raoSystem.Dweller.DwellerModel;
import com.raoSystem.constants.ComVar;

public class ApartmentInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		System.out.println("Step 1: Information Model Creating ");
		
		AptModel user = new AptModel();

		user.setRwaRegNo(request.getParameter("RwaRegNo"));
		user.setActionType(request.getParameter("ActionType"));
		user.setTowerNo(request.getParameter("TowerNo"));
		user.setFlatCategory(request.getParameter("FltCategory"));

		System.out.println(" Step 2: Parameter Valuse pass to SP to retrieve data--> Rwa Reg No" + user.getRwaRegNo() + " , Action Type-"
				+ user.getActionType() + " , Tower No :"+ user.getTowerNo() +" , Flat Category - "+user.getFlatCategory() );
		user.setTranType("VIEW");
		try {
			user = DAOAPTInventory.APTInfoRetriev(user);
			System.out.println("sp status Apartment invenotry information :" + user.isValid() +": " + user.getSPstatus());

			/*
			 * if(user.getSPstatus()==3) { session.setAttribute("Message",
			 * " Technical Issue !Unable to Process Driver Information. Please contact to System Admin "
			 * ); response.sendRedirect("Success.jsp"); }
			 */
			switch (user.getSPstatus()) {
			case 0: // Record Not Exist [DB]
				session.setAttribute("Message", " No Data Found. Please Enter Valid Search Criteria. ");
				System.out.println("No Data Found. Please Enter Valid Search Criteria.");
				response.sendRedirect("Inventory/ApartmentInventoryMainPage.jsp");
				break;
			case 1: // Record Exist [DB]
				user = SetAptValueToSessionVar(user, session);
				System.out.println("set Session value Successfully" );
				switch (Integer.parseInt(user.getActionType())) {
				case 0:
					break;
				case 1:
					response.sendRedirect("Inventory/PreviewAptInventory.jsp");
					break;
				case 2: // Edit Information
					System.out.println("Step 4. page forward to Apartment Information/EditAPTInventory.jsp");
					response.sendRedirect("Inventory/EditAPTInventory.jsp");
					break;
				}
				break;
			case 2:
				session.setAttribute("Message",	" Invalid Search Criteria. Please Contact System Admin.");
				System.out.println("Invalid Search Criterai");
				response.sendRedirect("Inventory/ApartmentInventoryMainPage.jsp");
				break;
			default:
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
				break;
			}
	
		} catch (Exception e) {
			session.setAttribute("Message",
					" Technical Issue !Unable to update Apartment Monthly Subscription Information. Please contact to System Admin ");
			response.sendRedirect("SuccessMsg.jsp");
		}
	
	}
	
	public static AptModel SetAptValueToSessionVar(AptModel user, HttpSession session) {

		session.setAttribute("RwaRegNo", user.getRwaRegNo());
		session.setAttribute("inputTowerNo", user.getTowerNo());
		session.setAttribute("inputFlatCategoryNo", user.getFlatCategory());
		session.setAttribute("inputSizeOfFlat", user.getFlatSize());
		session.setAttribute("inputFltStartNo", user.getFlatNoFrom());
		session.setAttribute("inputFltEndNo", user.getFlatNoTo());
	
		return user;
	
	}
	public static void  RemoveSetAptValueToSessionVar(HttpSession session) {

		session.removeAttribute("RwaRegNo");
		session.removeAttribute("inputTowerNo");
		session.removeAttribute("inputFlatCategoryNo");
		session.removeAttribute("inputSizeOfFlat");
		session.removeAttribute("inputFltStartNo");
		session.removeAttribute("inputFltEndNo");
	
		return ;
	
	}


}
