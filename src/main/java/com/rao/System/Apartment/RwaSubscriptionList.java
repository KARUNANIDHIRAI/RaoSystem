package com.rao.System.Apartment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RwaSubscriptionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<DaoRWASubscriptionList> user= new ArrayList<DaoRWASubscriptionList> ();
		
		user=DAOAPTInventory.knRwaSubscriptionList();
		System.out.println("Servlet out");
		 for (DaoRWASubscriptionList s : user) { //Iterates as long as there are elements in the list.
			 DAOAPTInventory.DisplayRWASubscription(s);
		 }
	
		
		request.setAttribute("products", user);
		request.getRequestDispatcher("Inventory/NewTest.jsp").forward(request, response);
		System.out.println("End of  process doaapatinventory");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	/*
	 * protected void processRequest(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * ArrayList<DaoRWASubscriptionList> user= new ArrayList<DaoRWASubscriptionList>
	 * ();
	 * 
	 * user=DAOAPTInventory.RwaSubscriptionList();
	 * System.out.println("Retrun after successfully process doaapatinventory");
	 * 
	 * request.setAttribute("EmpList", user); RequestDispatcher rd =
	 * request.getRequestDispatcher("Inventory/NewTest.jsp"); rd.forward(request,
	 * response); System.out.println("End of  process doaapatinventory");
	 * 
	 * }
	 */
}