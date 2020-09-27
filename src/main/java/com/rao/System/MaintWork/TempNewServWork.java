package com.rao.System.MaintWork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
import org.springframework.web.bind.annotation.GetMapping;


public class TempNewServWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");
		System.out.println("Step1: creating Model Object  ");

		TmpSWModel TSWModel= new TmpSWModel();
		JsonArray JsonTPOList= new JsonArray();
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		System.out.println("Step1.1: creating JSon Array Object  ");
		try {
			TSWModel= UpdateFormValueToModel(TSWModel,request);
			System.out.println("\nStep2: Update JSP Page value to  Model Object  ");
			try {
				switch(TSWModel.getActionType()) {
				case "NEW" :
					JsonTPOList=DAOTempServWork.NewTSW(TSWModel);
					System.out.println("\nStep4: return create InvoiceItem  ");
					out.print(JsonTPOList.toJson());
					out.flush();
					break;
				case "DELETE" :
					JsonTPOList=DAOTempServWork.NewTSW(TSWModel);
					System.out.println("\nStep3: return create InvoiceItem  ");
					out.print(JsonTPOList.toJson());
					out.flush();
					break;
				case "EXIST" :
				//	JsonTPOList=DAOTempServWork.retriveTempPO(TSWModel);
					System.out.println("\nStep3: return to  retrive Exist PO data  ");
					out.print(JsonTPOList.toJson());
					out.flush();
					break;
				default:
					break;
				}
			}catch(Exception e) {
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
				System.out.println("Technical Issue ! Please contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
			}
		}catch(Exception e) {
			session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
			System.out.println("Technical Issue ! Please contact to System Admin " + e);
			response.sendRedirect("SuccessMsg.jsp");
		}
	}
	public static TmpSWModel UpdateFormValueToModel(TmpSWModel TSWModel,HttpServletRequest request) {
		TSWModel.setUID(("1"));		  
		TSWModel.setRwaRegNo(("MK106"));		  
		TSWModel.setSWNO(request.getParameter("SCode"));		  
		TSWModel.setSNo(request.getParameter("SNo"));		  
		TSWModel.setName(request.getParameter("Name"));		  
		TSWModel.setMobileNo(request.getParameter("MobileNo"));	
		TSWModel.setDate(request.getParameter("Date"));
		TSWModel.setWages(request.getParameter("Charge"));
		TSWModel.setActionType(request.getParameter("Action"));	
		System.out.println("Action Type:" +TSWModel.getActionType());
		return TSWModel;
	}

}
