package com.rao.System.MASItem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.ConfigSetting.ConfigSettingModel;
import com.rao.System.ConfigSetting.HDAOConfigSetting;
import com.rao.System.MaintWork.DAOServiceWork;

public class ItemMainInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");
		ItemModel ItmModel = new ItemModel();
		String erMsg = null;
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
					out.print(JsonItemList.toJson());
					out.flush();
					break;
				case "View" : // View
					ItmModel.setRwaRegNo("MK106");
					System.out.println("RwaREgNo:");
					JsonItemList = DAOItem.ViewItem(ItmModel, erMsg);
					erMsg +=" Step 3 : HDOA  Ok";
					System.out.println("\n" + JsonItemList);
					out.print(JsonItemList.toJson());
					out.flush();
					break;
				case "AddItem" :
					System.out.println("Step 1: Model OK");
					ItmModel = updateItemValuetoJsp(ItmModel, request);
					erMsg +=" Model Update Ok, ";
					showItemInfo(ItmModel);
					erMsg +=" show Vale Ok, ";
			 		int HDAspStatus = DAOItem.newItem(ItmModel, erMsg);
					erMsg +=" Step 3.1: HDOA New Ok";
					JsonItemList = DAOItem.ViewItem(ItmModel, erMsg);
					erMsg +=" Step 3.1: HDOA rcList Ok";
					System.out.println("\n" + JsonItemList);
					out.print(JsonItemList.toJson());
					out.flush();
					break;
				case "itmEDIT"	:
					erMsg += "step 2: " + request.getParameter("ItCode");
					System.out.println("Prashant Kumar ari");
					JsonItemList=DAOItem.getItemList(request.getParameter("ItCode"), "MK106",erMsg);
					erMsg += "step 3: HDAO getItemList OK.";
					out.print(JsonItemList.toJson());
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
	
	private void showItemInfo(ItemModel itmModel) {
		System.out.println("RwaRegNo: "+ itmModel.getRwaRegNo()+"ItemCode: " + itmModel.getICode() + " , ItemName." +itmModel.getIName()+ " ,MinLevel :" + 
				itmModel.getMinLevel()+ "Maximum Level: " + itmModel.getMaxlevel() + "ReOrderLevel: "+ itmModel.getReOrderLevel());
	}

	private ItemModel updateItemValuetoJsp(ItemModel itmModel, HttpServletRequest request) {
		itmModel.setRwaRegNo("MK106");
		itmModel.setICode(request.getParameter("ItmCode"));
		itmModel.setIName(request.getParameter("ItmName"));
		itmModel.setMinLevel(Integer.parseInt(request.getParameter("MinLevel")));
		itmModel.setMaxlevel(Integer.parseInt(request.getParameter("MaxLevel")));
		itmModel.setReOrderLevel(Integer.parseInt(request.getParameter("RLevel")));
		itmModel.setStatus("A"); 
		itmModel.setCreatedOn(new Date());
		itmModel.setCreatedBy("KNRAI");
		itmModel.setUpdatedOn(new Date());
		itmModel.setUpdatedBy("KNRAI");
		return itmModel;
	}

	private ItemModel updateJFormValueInModel(ItemModel SrchParam, HttpServletRequest request) {
		
		SrchParam.setRwaRegNo("MK106");
		SrchParam.setICode(request.getParameter("ICode"));
		SrchParam.setIName(request.getParameter("IName"));
//		SrchParam.setActionType(request.getParameter("Action"));
		return SrchParam;
	}
}
