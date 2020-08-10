package com.rao.System.PO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.PurchaseMaterial.DAOPurMaterial;


public class POSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		POMISModel POMIS = new POMISModel();
		response.setContentType("text/plain");
		System.out.println("Step1: Creating Model ");
		
		JsonArray jPOListArray = new JsonArray();
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		POMIS = POFormValueToObj(POMIS, request);
		System.out.println("\nStep2: Update JSP Page value to  Model Object  ");

		try {
			switch (POMIS.getActionType()){
			case "POList" :
				System.out.println("working perfectly");
				jPOListArray = DAOPO.retrivePOList(jPOListArray,POMIS);
				System.out.println("Step4: retrive PO List information   ");
				out.print(jPOListArray.toJson());
				out.flush();
				break;
			case "POItemList":
				jPOListArray = DAOPO.retrivePOList(jPOListArray,POMIS);
				System.out.println("Step4: retrive PO Item List information   ");
				out.print(jPOListArray.toJson());
				out.flush();
				break;
			case "EXIST":
					String PONO=request.getParameter("PONO");
//				  response.sendRedirect("PO/NewPO.jsp ?'"+POItemAdd+'"+);
			default:
				out.print(jPOListArray.toJson());
				out.flush();
				break;
			}
		}catch (Exception e) {
			System.out.println();
			session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
			System.out.println("Technical Issue ! Please contact to System Admin " + e);
			response.sendRedirect("SuccessMsg.jsp");
		}
	} 
	private static POMISModel POFormValueToObj(POMISModel POMIS , HttpServletRequest request ) {
		POMIS.setPONO((String)request.getParameter("PONO"));
		POMIS.setFromDate((String)request.getParameter("fromDate"));
		POMIS.setToDate((String)request.getParameter("toDate"));
		POMIS.setRwaRegNo("MK106");
		POMIS.setActionType((String) request.getParameter("Action"));
		return POMIS;
	}
	
}
