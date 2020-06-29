package com.rao.System.MIS;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rao.System.Apartment.AptModel;
import com.rao.System.Apartment.DAOAPTInventory;
import com.rao.System.Apartment.DaoRWASubscriptionList;

public class RwaSubscriptionReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		ArrayList<AptModel> RwaSubscription= new ArrayList<> ();
		RwaSubscription=DAOAPTInventory.RwaSubscriptionList();
		System.out.println("Servlet out");
		 for (AptModel s : RwaSubscription) { //Iterates as long as there are elements in the list.
			 DAOAPTInventory.ShowRWASubscriptionInputInfo(s);
		 }
		  request.setAttribute("EmpList", RwaSubscription);
		  request.getRequestDispatcher("Inventory/SubscriptionList.jsp").forward(request, response); 		  
//		  request.getRequestDispatcher("MIS/SubscriptionSummary.jsp").forward(request, response); 		  
//		  request.getRequestDispatcher("Testing.jsp").forward(request, response); 		  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		ArrayList<AptModel> RwaSubscription= new ArrayList<> ();
		RwaSubscription=DAOAPTInventory.RwaSubscriptionList();
		System.out.println("Servlet out");
		 for (AptModel s : RwaSubscription) { //Iterates as long as there are elements in the list.
			 DAOAPTInventory.ShowRWASubscriptionInputInfo(s);
		 }
		  request.setAttribute("EmpList", RwaSubscription);
		  request.getRequestDispatcher("Inventory/SubscriptionList.jsp").forward(request, response); 		  

	}

	
}
