package com.rao.System.PO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
import java.io.PrintWriter;

public class TempPOInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");
		System.out.println("Step1: creating Model Object  ");

		POModel TPOModel= new POModel();
		JsonArray JsonTPOList= new JsonArray();
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		System.out.println("Step1.1: creating JSon Array Object  ");
		try {
			TPOModel= UpdateFormValueToPOModel(TPOModel,request);
			System.out.println("\nStep2: Update JSP Page value to  Model Object  ");
			try {
				switch(TPOModel.getActionType()) {
				case "NEW" :
					JsonTPOList=DAOTempPO.NewTPO(TPOModel);
					System.out.println("\nStep3: return create InvoiceItem  ");
							out.print(JsonTPOList.toJson());
							out.flush();
					break;
				case "ADDITEMINPO" :
					JsonTPOList=DAOTempPO.NewTPO(TPOModel);
					System.out.println("\nStep3: return create InvoiceItem  ");
							out.print(JsonTPOList.toJson());
							out.flush();
					break;
				case "DELETE" :
					
					JsonTPOList=DAOTempPO.retriveTempPO(TPOModel);
					System.out.println("\nStep3: return create InvoiceItem  ");
							out.print(JsonTPOList.toJson());
							out.flush();
					break;
				case "EXIST" :
					JsonTPOList=DAOTempPO.retriveTempPO(TPOModel);
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
	public static POModel UpdateFormValueToPOModel(POModel TPOModel,HttpServletRequest request) {
		TPOModel.setUId(("1"));		  
		TPOModel.setRwaRegNO(("MK106"));		  
		TPOModel.setPONo(request.getParameter("PONO"));		  
		TPOModel.setSNO(request.getParameter("SNo"));		  
		TPOModel.setItemCode(request.getParameter("ItemCode"));		  
		TPOModel.setItemName(request.getParameter("ItemName"));		  
		TPOModel.setBrand(request.getParameter("BrandName"));		  
		TPOModel.setQuantity(request.getParameter("Quantity"));		  
		TPOModel.setUnit(request.getParameter("Unit"));		  
		TPOModel.setNote(request.getParameter("Remark"));		  
		TPOModel.setActionType(request.getParameter("Action"));		  
		return TPOModel;
	}
}

