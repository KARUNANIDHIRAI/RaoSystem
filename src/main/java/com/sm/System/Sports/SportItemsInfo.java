package com.sm.System.Sports;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.ItemMasterOPBal.HDAOSMItemMasterOPBal;
import com.sm.System.ItemMasterOPBal.SMItemMasterOPBalSubModel;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMDataCreatedUpdated;
import com.sm.System.SMUtility.SMUtilities;

/**
 * Servlet implementation class SportItemsInfo
 */
public class SportItemsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg = SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1;
//		SportItemsModel itemMasterModel = new SportItemsModel();
//			itemMasterModel.setRegNo(session.getAttribute("RegNo").toString());
		String hDAOMessage = "";
		int excStatus = 0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter();
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg += Action;
		try {
			switch (Action) {
			case "xNritemInfo": // create New sprot Item
				
				SMItemMasterOPBalSubModel itemMasterOpBalQty = new  SMItemMasterOPBalSubModel();
				erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.INFORMATION;
				itemMasterOpBalQty = usPortItemInputValModel(itemMasterOpBalQty, request, session);
				excStatus = HDAOSMItemMasterOPBal.postItemMasterOpenBalQty(itemMasterOpBalQty);
				hDAOMessage += Integer.toString(excStatus) + SMFixedValue.EXEC_CREATE_MSG;
				session.setAttribute(SMFixedValue.MESSAGE, hDAOMessage);
				erMsg += hDAOMessage;
				response.sendRedirect("Sports/ItemMaster.jsp");
				break;
			case "xiTiNFOVerify": // verify duplicate sport item code
				break;
			case "xSprtItemInfoList": // generate sport item list
				break;
			case "xRiTodayITiNFO":
				break;
			case "XsprtITMRInfo01": // remove existing sport item information
				break;
			case "xSprtItemsLIst": // Generate Sport item list based on item category
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG + "\n " + e;
		} finally {
		}
	}

 SMItemMasterOPBalSubModel usPortItemInputValModel(SMItemMasterOPBalSubModel ITMOpenBalModel, 
		HttpServletRequest request,	HttpSession session) {
		String erMsg = SMFixedValue.ACTION_UPDATING + SMFixedValue.ITEM + SMFixedValue.INPUT_VALUES
				+ SMFixedValue.TOMODEL;
		try {
			ITMOpenBalModel.setRegNo("MK308");
			ITMOpenBalModel.setItemCategory(request.getParameter("SportCategory"));
			ITMOpenBalModel.setItemCode(request.getParameter("sprtICode"));
			
			ITMOpenBalModel.setMake(request.getParameter("sprtMake"));
			ITMOpenBalModel.setManufYear(request.getParameter("manufYear"));
			ITMOpenBalModel.setExpirydate(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("exprdate")));
			ITMOpenBalModel.setOpBalQty(Integer.parseInt((String)request.getParameter("sprtItmQty")));
			ITMOpenBalModel.setUnit(request.getParameter("Unit"));
			ITMOpenBalModel.setPrice(Math.round(Float.parseFloat((String)request.getParameter("sptPrice"))));

			SMDataCreatedUpdated userInfo = new SMDataCreatedUpdated();
			userInfo =  SMUtilities.getUserInfo(session);
			/*
			 * userInfo.setStatus(SMFixedValue.STATUS);
			 * userInfo.setCreatedBy("KBS TECHNOLGOY"); //
			 * userInfo.setCreatedBy(session.getAttribute("UserID").toString());
			 * userInfo.setCreatedOn(new Date());
			 * userInfo.setUpdatedBy(userInfo.getCreatedBy());
			 * userInfo.setUpdatedOn(userInfo.getCreatedOn());
			 */	
			ITMOpenBalModel.setUserRefInfo(userInfo);
			erMsg += "\n" + SMFixedValue.ITEM + SMFixedValue.OPENBAL + SMFixedValue.INPUT_VALUES + ITMOpenBalModel;
		} catch (Exception e) {
			erMsg += "\n" + SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {
			System.out.println(erMsg);
		}
		return ITMOpenBalModel;
	}

}
