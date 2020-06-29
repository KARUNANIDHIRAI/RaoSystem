package com.rao.System.Apartment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditAPTInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step 1 Creating APT Model");
		AptModel user = new AptModel();
		user.setActionType("2");

		user.setTranType("VIEW");
		try {
			NewAPTInventory setFormValue = new NewAPTInventory();
			user = setFormValue.UpdateFormValueToUserObj(user, request);
			NewAPTInventory.ShowAPTDataForUpdate(user);		
			System.out.println("Step 2 : Updating Data in APT Model successfully");

			
			System.out.println("Step 3 : sending data for update DB");
			user = DAOAPTInventory.UpdateAPTInventory(user);
			
			if (user.isValid()) {
				switch (user.getSPstatus()) {
				case 0: // Record Not Exist [DB]
					session.setAttribute("Message", " Invalid Search Criteria. NO Record Found in Databaase");
					System.out.println("Invalid Search Criteria. NO Record Found in Databaase");
					response.sendRedirect("Inventory/ApartmentInventoryMainPage.jsp");
					break;
				case 1: // Record Exist [DB]
					session.setAttribute("Message", " Apartment Inventory Updated Successfully");
					ApartmentInformation.RemoveSetAptValueToSessionVar(session);
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  " Invalid Search Criteria. No Record found in [DB]");
					System.out.println(" Invalid Search Criteria. No Record found in [DB]");
					response.sendRedirect("Inventory/ApartmentInventoryMainPage.jsp"); 
					break;

				default:
					session.setAttribute("Message",
							" Technical Issue ! Unable to Update Apartment Inventory Information. Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				}
			} else {
				session.setAttribute("Message",
						" Technical Issue ! Apartment Inventory not updated . Please contact to System Admin ");
				response.sendRedirect("SuccessMsg.jsp");
			}
		} catch (Exception e) {
			System.out.println("Technical Issue ! Please contact to System Admin " + e);
			session.setAttribute("Message",
					" Technical Issue ! Apartment Inventory not updated . Please contact to System Admin :" + e);
			response.sendRedirect("SuccessMsg.jsp");
		}
	}

}
