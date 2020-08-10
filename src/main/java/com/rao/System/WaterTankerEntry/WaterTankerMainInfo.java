package com.rao.System.WaterTankerEntry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WaterTankerMainInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WaterTankerMainInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		switch (Integer.parseInt(request.getParameter("ActionType"))) {
		case 0:
			break;
		case 1:
			processdata(request,response,session);
			break;
		case 2: // Edit Information
			processdata(request,response,session);
			break;
		case 3: // Edit Information
			session.setAttribute("Message", " Record Removed Succesfully");
			response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp");
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		switch (Integer.parseInt(request.getParameter("ActionType"))) {
		case 0:
			break;
		case 1:
			processdata(request,response,session);
			break;
		case 2: // Edit Information
			processdata(request,response,session);
			break;
		case 3: // Edit Information
			session.setAttribute("Message", " Record Removed Succesfully");
			response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp");
			break;
		}
	}
	
	public static TankerModel SetAptValueToSessionVar(TankerModel user, HttpSession session) {

		return user;
	
	}
	public static void  RemoveSetAptValueToSessionVar(HttpSession session) {

	
	
		return ;
	

		
	}
	protected void processdata(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException{
		System.out.println("Step 1: Information Model Creating ");
		try {
			TankerModel user = new TankerModel();

			user.setRwaRegNo("MK106");
			user.setActionType(request.getParameter("ActionType"));
			user.setTankerNo(request.getParameter("TankerNo"));
			user.setTankerArrivalDateFrom(request.getParameter("DateFrom"));

			ArrayList<TankerModel> TankerList = new ArrayList<>();

			System.out.println("User Search Parameter :"+ user.RwaRegNo + "," +user.ActionType + "," +user.TankerNo + "," +user.TankerArrivalDateFrom);
			user.setTranType("VIEW");
			TankerList = DAOWaterTankerDetails.WaterTankerInfoRetriev(user);
			if (TankerList.size()==0) {
				session.setAttribute("Message", " No Data Found. Please Enter Valid Search Criteria. ");
				System.out.println("\nNo Data Found. Please Enter Valid Search Criteria.");
//				response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp");
				request.setAttribute("Message", " No Data Found. Please Enter Valid Search Criteria.");
				request.getRequestDispatcher("WaterSupplierInfo/WaterSupplierMainPage.jsp").forward(request, response);
				
			}
			switch (Integer.parseInt(user.getActionType())) {
			case 1:
				System.out.println("Step 4.Servlet output Case-1");
				/*
				 * for (TankerModel s : TankerList) { //Iterates as long as there are elements
				 * in the list. DAOWaterTankerDetails.ShowNewWTInfoPassToSP(s); }
				 */
				request.setAttribute("WaterTanker", TankerList);
				request.getRequestDispatcher("MIS/WaterTankerSupplySummary.jsp").forward(request, response);
				System.out.println("End of  process WaterSummaryList");
				break;
			case 2:
				System.out.println("Step 4.Servlet output case-2");
				request.setAttribute("WaterTanker", TankerList);
				request.getRequestDispatcher("WaterSupplierInfo/WaterSupplierMainPage.jsp").forward(request, response);
				System.out.println("End of  process WaterSummaryList");
				break;
			}

		} catch (Exception e) {
			session.setAttribute("Message", " Technical error encountered! please contact to Admin");
			System.out.println("Technical error encountered! please contact to Admin");
			response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp");
		}
	}

	

}
