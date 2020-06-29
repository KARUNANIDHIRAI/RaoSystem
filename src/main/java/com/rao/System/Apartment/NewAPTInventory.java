package com.rao.System.Apartment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewAPTInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		System.out.println("Step1: model creating ");
		AptModel user = new AptModel();
	
//		HashMap<String, String> user = new HashMap<>(); 
		try {
			user = UpdateFormValueToUserObj(user, request);
			System.out.println("Step2: Update form value to  APT Model  ");
			ShowAPTDataForUpdate( user);
			user = DAOAPTInventory.CreateNewAPTInfo(user);
			
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
					session.setAttribute("Message",  " For this Tower and Category, Record already exist");
					System.out.println("For this Tower and Category, Record already exist");
					response.sendRedirect("Inventory/ApartmentNewInventory.jsp"); 
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

	public  AptModel  UpdateFormValueToUserObj(AptModel user , HttpServletRequest request) {
		  user.setRwaRegNo("MK106");
		  user.setUserID("KNRAI");
		  user.setTowerNo(request.getParameter("inputTowerNo"));
		  user.setFlatCategory(request.getParameter("inputFlatCategoryNo"));
		  user.setFlatSize(request.getParameter("inputSizeOfFlat"));
		  user.setFlatNoFrom(request.getParameter("inputFltStartNo"));
		  user.setFlatNoTo(request.getParameter("inputFltEndNo"));
		 	
		return user;
	}
	public  static void  ShowAPTDataForUpdate(AptModel user) {

	System.out.println( "\n Rwa Reg No. :" + user.getRwaRegNo() + " Tower No.: "+ user.getTowerNo());
	System.out.println("Flat Category No :" + user.getFlatCategory() + " Size Of Flat :" + user.getFlatSize() 
	 + " Flat Starting No from :" + user.getFlatNoFrom() + " Flat ending No : " + user.getFlatNoTo());
		
		return ;
	}


}
