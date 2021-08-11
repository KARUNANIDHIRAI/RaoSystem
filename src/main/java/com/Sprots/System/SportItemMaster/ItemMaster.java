package com.Sprots.System.SportItemMaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;


import com.sm.System.SMInformation.SMFixedValue;

public class ItemMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemMaster() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		ItemMasterModel itemMasterModel = new ItemMasterModel();
		itemMasterModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNritemInfo":	// create New sprot Item
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM +  SMFixedValue.INFORMATION ;

				itemMasterModel = ItemMasterModel(itemMasterModel,request);
				excStatus = HDAOItemMaster.ItemMasterNew(itemMasterModel);
				hDAOMessage += Integer.toString(excStatus) +SMFixedValue.EXEC_CREATE_MSG;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				response.sendRedirect("Sport/ItemMaster?Action=xNritemInfo");
				break; 				
			case "xiTiNFOVerify": // verify duplicate sport item code
				erMsg=  SMFixedValue.RETRIEVE + SMFixedValue.ITEM + SMFixedValue.INFORMATION;;
				itemMasterModel.setCode(request.getParameter("iCode"));
				String iName= HDAOItemMaster.verifyDuplicateItemCode(itemMasterModel);
				out.print(iName);
				out.flush();
				break; 	
			case "xSprtItemInfoList": // generate sport item list
				erMsg=  SMFixedValue.RETRIEVE + SMFixedValue.ITEM + SMFixedValue.INFORMATION;;
				JsonArrayList= HDAOItemMaster.getItemMasterList(itemMasterModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRiTodayITiNFO":	
				erMsg= SMFixedValue.BOOK_BORROWED_RETURN;
				itemMasterModel.setCreatedOn(new Date());
				JsonArrayList = HDAOItemMaster.getTodayItemList(itemMasterModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XsprtITMRInfo01":	// remove existing sport item information
				itemMasterModel = removeSprtItemInfo(itemMasterModel,request);
				excStatus = HDAOItemMaster.sprotItemMasterRemove(itemMasterModel);

				hDAOMessage += Integer.toString(excStatus) +SMFixedValue.EXEC_REMOVE_MSG;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				JsonArrayList= HDAOItemMaster.getItemMasterList(itemMasterModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				
				break; 	
			case "xRBKBRPendingL":	
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}
		finally {
			System.out.println(erMsg);
		}
	}
	private ItemMasterModel ItemMasterModel(ItemMasterModel itemMasterModel,HttpServletRequest request) throws ParseException {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.ITEM + SMFixedValue.INPUT_VALUES 
				        +SMFixedValue.TOMODEL ;
		try {
			/*
			 * itemMasterModel.setCode(request.getParameter("sICode"));
			 * itemMasterModel.setName(request.getParameter("sIName"));
			 * itemMasterModel.setItemCategory(request.getParameter("SportCategory"));
			 */
			itemMasterModel.setCode("SP102");
			itemMasterModel.setName("CRICKET");
			itemMasterModel.setItemCategory("SportCategory");
			itemMasterModel.setStatus(SMFixedValue.NEW_STATUS); 
			itemMasterModel.setCreatedBy("KNRAI");
			itemMasterModel.setCreatedOn(new Date());
			itemMasterModel.setUpdatedBy(itemMasterModel.getCreatedBy());
			itemMasterModel.setUpdatedOn(itemMasterModel.getCreatedOn());
			erMsg+= "\n"+ SMFixedValue.ITEM + SMFixedValue.INPUT_VALUES + itemMasterModel;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return itemMasterModel;
	}
	private ItemMasterModel removeSprtItemInfo(ItemMasterModel itemMasterModel,HttpServletRequest request) throws ParseException {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.SPORTS + SMFixedValue.ITEM + SMFixedValue.INPUT_VALUES 
				        +SMFixedValue.TOMODEL ;
		try {
			itemMasterModel.setiDNO(Integer.parseInt(request.getParameter("iCode")));
			itemMasterModel.setStatus(SMFixedValue.NEW_STATUS); 
			itemMasterModel.setUpdatedBy("KNRAI");
			itemMasterModel.setUpdatedOn(new Date());
			erMsg+= "\n"+ SMFixedValue.SPORTS + SMFixedValue.ITEM + SMFixedValue.INPUT_VALUES + itemMasterModel;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return itemMasterModel;
	}	
}
