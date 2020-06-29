package com.rao.System.Apartment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewRwaSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		System.out.println("Step1: KNRAI model creating ");
		AptModel user = new AptModel();
	
//		HashMap<String, String> user = new HashMap<>(); 
		try {
			user = UpdateFormValueToUserObj(user, request);
			System.out.println("Step2: set user input in DwellerModel creating ");
			System.out.println(user);
			user = DAOAPTInventory.CreateNewRWASubscription(user);
			
			  if (user.isValid()) { 
				  switch (user.getSPstatus())   { 
				  case 0: // Record Not  Exist [DB] 
						session.setAttribute("Message",  " Invalid Email Id  / RWA Registraion No.");
						System.out.println("Invalid Email Id  / RWA Registraion No.");
						response.sendRedirect("Inventory/ApartmentInventoryMainPage.jsp");
						break; 
				case   1: // Record Exist [DB] 
					session.setAttribute("Message",  "  Apartment/ Flat Infromation Created Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  " Invalid Email Id / RWA NO. Record already exist");
					System.out.println("Invalid Email Id  / RWA Registraion No.");
					response.sendRedirect("Inventory/NewAPTInventory.jsp"); 
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

	public static AptModel  UpdateFormValueToUserObj(AptModel user , HttpServletRequest request) {
		user.setRwaRegNo("MK108");
		user.setUserID("KNRAI");
	
		user.setSubscriptionType( request.getParameter("inputRwaPlan"));
		user.setValidFrom(request.getParameter("inputValidFrom"));
		user.setValidTo(request.getParameter("inputValidTo"));
		user.setAuditCharge(request.getParameter("inputAuditCharge"));
	
		if (request.getParameter("inputRwaPlan").equals("2")) {
			user.setFlatFixCharge(request.getParameter("inputFlatCharge"));
			user.setAmcCharge(request.getParameter("inputAMCCharge"));
			user.setMiscCharge(request.getParameter("inputMiscCharge"));
			user.setGymCharge(request.getParameter("inputGymCharge"));
			user.setSwmPoolCharge(request.getParameter("inputSwmPoolCharge"));
	
		}
		else {
			user.setFlatFixCharge(request.getParameter("inputFloatCharge"));
			user.setAmcCharge(request.getParameter("inputAMCFloatCharge"));
			user.setMiscCharge(request.getParameter("inputMiscFloatCharge"));
			user.setGymCharge(request.getParameter("inputGymFloatCharge"));
			user.setSwmPoolCharge(request.getParameter("inputSwmPoolFloatCharge"));
	
		}
		return user;
	}
}
