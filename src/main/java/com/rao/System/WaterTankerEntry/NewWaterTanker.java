package com.rao.System.WaterTankerEntry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NewWaterTanker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("\nStep1: Creating Model");
		TankerModel user = new TankerModel();	
		try {
			user = UpdateFormValueToUserObj(user, request);
			System.out.println("Step2: Update JSP Page value to  Model Object  ");
			ShowWaterTankerDataForUpdate( user);
			user = DAOWaterTankerDetails.CreateWaterTankerInfo(user);
			  if (user.isValid()) { 
				  switch (user.getSPstatus())   { 
				  case 0: // Record Not  Exist [DB] 
						session.setAttribute("Message",  " Technical Problem Record not created");
						System.out.println("Technical Problem Record not created");
						response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp");
						break; 
				case   1: // Record Exist [DB] 
					session.setAttribute("Message",  "  Water Tanker Infromation Created Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  "  Record already exist");
					System.out.println(" Record already exist");
					response.sendRedirect("WaterSupplierInfo/NewWaterTankInfo.jsp"); 
					break;
				default: session.setAttribute("Message",  " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				  }
			  } else {
			  session.setAttribute("Message",  " Technical Issue (Water Tanker  Information not created )! Please contact to System Admin "  ); 
			  response.sendRedirect("SuccessMsg.jsp"); }
			} catch (Exception e) {
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
				System.out.println("Technical Issue ! Please contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
		}
	}
	public  TankerModel  UpdateFormValueToUserObj(TankerModel user , HttpServletRequest request) {
		  user.setRwaRegNo("MK106");
		  user.setUserId("Prashant Rai");
		  user.setWaterTankNo(request.getParameter("WaterTankNo"));
		  user.setWaterSupplier(request.getParameter("WtrSuplrNum"));
		  user.setTankerNo(request.getParameter("TankerNo"));
		  user.setTankerCapacity(request.getParameter("TankCapcity"));
		  user.setDriverName(request.getParameter("DriverName"));
		  user.setDLNO(request.getParameter("DlNo"));
		  user.setDrvMobilNo(request.getParameter("MobileNo"));
		  user.setTankerArrivalDateFrom(request.getParameter("TankerArrivalOn"));
		  user.setVerifiedByTankerIn(request.getParameter("VerifiedBy"));
		  user.setWaterLevelIn(request.getParameter("WaterLevelIn"));
		  user.setTankerInTime(request.getParameter("TankerInTime"));
		  user.setVerifiedByTankerOut(request.getParameter("VerifiedByTankerOutTime"));
		  user.setWaterLevelOut(request.getParameter("WaterLevelOut"));
		return user;
	}
	public  static void  ShowWaterTankerDataForUpdate(TankerModel user) {
	System.out.println( "\nRWA No. :" + user.getRwaRegNo() + "  Water Tanker No.: "+ user.getWaterTankNo() +" Supplier :" + user.getWaterSupplier()
	+ " Tanker No :" + user.getTankerNo() + ", Tanker Capacity :" + user.getTankerCapacity() + " Driver Name : " + user.getDriverName());
	System.out.println("\n DLNO:"+ user.getDLNO()+ "Mobile No :"+ user.getDrvMobilNo() +", Arrival Date:" +user.getTankerArrivalDateFrom()
	+ ", Verified By :"+ user.getVerifiedByTankerIn() + ", Water Level In :" + user.getWaterLevelIn() + "Tanker In Time :" + user.getTankerInTime()
	+ ", Tanker Out Time :" + user.getTankerOutTime() + "Water Level Out:" +user.getWaterLevelOut());
	return ;
	}
}
