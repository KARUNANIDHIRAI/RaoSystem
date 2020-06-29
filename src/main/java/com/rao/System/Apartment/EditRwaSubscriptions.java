package com.rao.System.Apartment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditRwaSubscriptions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		System.out.println("Step1: Update Model creating ");
		AptModel user = new AptModel();
	
//		HashMap<String, String> user = new HashMap<>(); 
		try {
			user = NewRwaSubscription.UpdateFormValueToUserObj(user, request);
			System.out.println("Step2: set user input in RWA Subscription Model ");
			System.out.println(user);
			user = DAOAPTInventory.UpdateRWASubscription(user);
			
			  if (user.isValid()) { 
				  switch (user.getSPstatus())   { 
				  case 0: // Record Not  Exist [DB] 
						session.setAttribute("Message",  " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Step 4: Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("Inventory/RWASubscriptionMainPage.jsp");
						break; 
				case   1: // Record Exist [DB] 
					session.setAttribute("Message",  "  RWA Subscription Infromation updated Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  " Invalid Search Criteria. No Record found in [DB]");
					System.out.println("Step 4: Invalid Search Criteria. No Record found in [DB]");
					response.sendRedirect("Inventory/RWASubscriptionMainPage.jsp"); 
					break;
				default: session.setAttribute("Message",  " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				  }
			  } else {
			  session.setAttribute("Message",  " Technical Issue (Apartment/ Flat Information not created )! Please contact to System Admin "  ); 
			  response.sendRedirect("SuccessMsg.jsp"); }
			 	
			} catch (Exception e) {
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
				System.out.println("Technical Issue ! Please contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
		}
	}

}
