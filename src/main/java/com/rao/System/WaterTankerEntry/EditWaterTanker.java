package com.rao.System.WaterTankerEntry;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditWaterTanker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println(request.getParameter("id"));
		System.out.println("step 1: Create water tanker model");
		TankerModel WaterTanker = new TankerModel();
		try {
			System.out.println("Step 2: Update form value in model");	
			WaterTanker= NewWaterTanker.UpdateFormValueToUserObj(WaterTanker, request);
			WaterTanker.setTankerId(request.getParameter("IDNO"));
			System.out.println("Tanker ID :"+WaterTanker.getTankerId());
			NewWaterTanker.ShowWaterTankerDataForUpdate( WaterTanker);
			System.out.println("step 3: Show model value for update in Db");
			WaterTanker= DAOWaterTankerDetails.UpdateWaterTankerInfo(WaterTanker);
			  if (WaterTanker.isValid()) { 
				  switch (WaterTanker.getSPstatus())   { 
				  case 0: // Record Not  Exist [DB] 
						session.setAttribute("Message",  " Technical Problem Record not created");
						System.out.println("Technical Problem Record not created");
						response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp");
						break; 
				case   1: // Record Exist [DB] 
					session.setAttribute("Message",  "  Water Tanker Infromation Updated Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  " No Record not exist in [Database]");
					System.out.println("  No Record not exist in [Database]");
					response.sendRedirect("WaterSupplierInfo/WaterSupplierMainPage.jsp"); 
					break;
				default: session.setAttribute("Message",  " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				  }
			  } else {
			  session.setAttribute("Message",  " Technical Issue ( Information not  updated Sucessfully)!Contact to System Admin "  ); 
			  response.sendRedirect("SuccessMsg.jsp"); }
			} catch (Exception e) {
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
				System.out.println("Technical Issue ! Please contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
		
			}
		}
}
