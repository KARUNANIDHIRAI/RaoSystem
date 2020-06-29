package com.rao.System.Apartment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IteratorExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*
		 * EmployeeDetails empDetails = new EmployeeDetails(0, 0, "KNRAI", "NKSINGH");
		 * empDetails.getEmployeeDetails();
		 * 
		 * 
		 * request.setAttribute("EmpList", empDetails.getEmployeeDetails());
		 * request.getRequestDispatcher("Inventory/KNRAI.jsp").forward(request,
		 * response);
		 */
		 
		  
			ArrayList<DaoRWASubscriptionList> empDetails= new ArrayList<> ();
			empDetails=DAOAPTInventory.knRwaSubscriptionList();
			
			System.out.println("Servlet out");
			 for (DaoRWASubscriptionList s : empDetails) { //Iterates as long as there are elements in the list.
				 DAOAPTInventory.DisplayRWASubscription(s);
			 }
		
			  request.setAttribute("EmpList", empDetails);
			  request.getRequestDispatcher("Inventory/KNRAI.jsp").forward(request, response); 		  
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
