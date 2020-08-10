package com.rao.System.PO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
public class EditPO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");
		String erMsg="knrai ";
		erMsg+="Step1: creating Model;";
		JsonArray JsonTPOList= new JsonArray();
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			erMsg+="Step2: Update JSP Value in Model;";
			switch(request.getParameter("Action")) {
			case "NEW" :
				POModel TPOModel= new POModel();
				TPOModel= UpdFormValueToPOModel(TPOModel,request);
				JsonTPOList=DAOPO.editPO(TPOModel);
				erMsg+="Step4: Inser PO Item in [db]";
				out.print(JsonTPOList.toJson());
				out.flush();
				break;
			case "PODELITEM" :
				POMISModel poItemModel= new POMISModel();
				poItemModel= UpdFormValToPOModel(poItemModel,request);
				JsonTPOList=DAOPO.PODelItem(poItemModel);
				erMsg+="Step4: Delete PO Item [db]";
				out.print(JsonTPOList.toJson());
				out.flush();
				break;
			case "PODEL":
				POMISModel poModel= new POMISModel();
				poModel= UpdFormValToPOModel(poModel,request);
				JsonTPOList=DAOPO.poDel(poModel);
				erMsg+="Step4: Delete PO Item [db]";
				out.print(JsonTPOList.toJson());
				break;
			default:
				break;
			}
			System.out.println(erMsg);
		}catch(Exception e) {
			System.out.println("Technical Issue ! " + erMsg +"\n"+ e);
			session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
			response.sendRedirect("SuccessMsg.jsp");
		}
			
	}
	private static POModel UpdFormValueToPOModel(POModel TPOModel,HttpServletRequest request) {
		try {
			TPOModel.setUId(("1"));		  
			TPOModel.setRwaRegNO(("MK106"));		  
			TPOModel.setPONo(request.getParameter("PONO"));		  
			TPOModel.setSNO(request.getParameter("SNO"));		  
			TPOModel.setActionType(request.getParameter("Action"));	
			switch(request.getParameter("Action")) {
			case "NEW":
				TPOModel.setItemCode(request.getParameter("ItemCode"));		  
				TPOModel.setItemName(request.getParameter("ItemName"));		  
				TPOModel.setBrand(request.getParameter("BrandName"));		  
				TPOModel.setQuantity(request.getParameter("Quantity"));		  
				TPOModel.setUnit(request.getParameter("Unit"));		  
				TPOModel.setNote(request.getParameter("Remark"));		  
				break;
			case "PODEL":
			
				break;
			}
		}catch(Exception e) {
			System.out.println("Error In updateing JSP Page Vale to model");
		}
		return TPOModel;
	}

	private static POMISModel UpdFormValToPOModel(POMISModel TPOModel,HttpServletRequest request) {
		try {
			TPOModel.setUID(("1"));		  
			TPOModel.setRwaRegNo(("MK106"));		  
			TPOModel.setPONO(request.getParameter("PONO"));		  
			TPOModel.setSNo(request.getParameter("SNO"));		  
			TPOModel.setActionType(request.getParameter("Action"));	
			TPOModel.setFromDate((String)request.getParameter("fromDate"));
			TPOModel.setToDate((String)request.getParameter("toDate"));
		}catch(Exception e) {
			System.out.println("Error In updateing JSP Page Vale to model");
		}
		return TPOModel;
	}	
}