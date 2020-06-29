package com.rao.System.WaterTankerEntry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SummaryWaterTanker extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processdata(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processdata(request, response);
	}

	protected void processdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Step 1: Information Model Creating ");
		
		TankerModel user = new TankerModel();
//		user.setRwaRegNo(request.getParameter("RwaRegNo"));
	    user.setRwaRegNo("MK106");
		user.setActionType(request.getParameter("ActionType"));
		user.setTankerNo(request.getParameter("TankerNo"));
		user.setTankerArrivalDateFrom(request.getParameter("DateFrom"));
		user.setTankerArrivalDateTo(request.getParameter("DateTO"));

		System.out.println(" Step 2: Parameter Valuse pass to SP to retrieve data--> Rwa Reg No" + user.getRwaRegNo() + " , Action Type-"
				+ user.getActionType() + " , Tanker No :"+ user.getTankerNo() +" , Tanker Arrival Date From - "+user.getTankerArrivalDateFrom()+
				" , Tanker Arrival Date To - "+user.getTankerArrivalDateTo() );

	
		ArrayList<TankerModel> TankerList = new ArrayList<>();
		TankerList = DAOWaterTankerDetails.WaterTankSupplyList(user);
	
		System.out.println("Step 4.Servlet out");
		 for (TankerModel s : TankerList) { //Iterates as long as there are elements in the list.
			 DAOWaterTankerDetails.ShowNewWTInfoPassToSP(s);
		 }
		request.setAttribute("WaterTanker", TankerList);
		request.getRequestDispatcher("MIS/WaterTankerSupplySummary.jsp").forward(request, response);
		System.out.println("End of  process WaterSummaryList");
	}
}
