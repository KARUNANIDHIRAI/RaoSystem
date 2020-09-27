package com.rao.System.MASItem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.MaintWork.DAOServiceWork;

public class ItemMainInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");
		ItemModel ItmModel = new ItemModel();
		System.out.println("Step1: creating Model  ");
 		JsonArray JsonItemList= new JsonArray();
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		String actType=  request.getParameter("Action");
		try {
			try {
				switch(actType) {
				case "SEARCH" :
					updateJFormValueInModel(ItmModel,request);
					System.out.println("\nStep2: Update JSP Page value to  Model ok:  ") ;
					JsonItemList=DAOItem.ItemSearch(ItmModel);
					System.out.println("\n" + JsonItemList);
					System.out.println("\nStep4: retrun from DAO");
					out.print(JsonItemList.toJson());
					out.flush();
					break;
				case "1" : // View
					break;
				case "EXIST" :
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
	
	private ItemModel updateJFormValueInModel(ItemModel SrchParam, HttpServletRequest request) {
		
		SrchParam.setRwaRegNo("MK106");
		SrchParam.setICode(request.getParameter("ICode"));
		SrchParam.setIName(request.getParameter("IName"));
		SrchParam.setActionType(request.getParameter("Action"));
		return SrchParam;
	}
}
