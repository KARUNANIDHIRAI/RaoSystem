package com.sm.System.ItemMasterOPBal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMDataCreatedUpdated;
import com.sm.System.SMUtility.SMUtilities;

public class SMItemMasterOPBalQty extends HttpServlet {
	static int exeStatus = 0;
	static String regNo="";
	private static final long serialVersionUID = 1L;

	public SMItemMasterOPBalQty() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg = SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1;
		regNo = session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString();
		regNo=	"MK308";
		String hDAOMessage = "";
		int excStatus = 0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter();
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg += Action;
		try {
			switch (Action) {
			case "xNOpBlrItemInfo": // create New sprot Item

				SMItemMasterOPBalSubModel iTMOpBalSModel = new SMItemMasterOPBalSubModel();
				erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.INFORMATION;
				String valMsg= validateOPBalInputeValuse( request,  session);
				if(!valMsg.equals("InValid:")) {
					session.setAttribute(SMFixedValue.MESSAGE, valMsg);
					response.sendRedirect("SMSISystem/SMItemsInfo/SMItemsOPBal.jsp");
					System.exit(0);
				}
				iTMOpBalSModel = updateOPBalInputValModel(iTMOpBalSModel, request, session);
				SMItemMasterOPCLBalSubModel oPClBalModel = new SMItemMasterOPCLBalSubModel();
				oPClBalModel = UpdateOPCLQtyModel(iTMOpBalSModel, oPClBalModel);
				
				
				excStatus = HDAOSMItemMasterOPBal.postItemMasterOpenBalQty(iTMOpBalSModel, oPClBalModel);
				hDAOMessage += Integer.toString(excStatus) + SMFixedValue.EXEC_CREATE_MSG;
				session.setAttribute(SMFixedValue.MESSAGE, hDAOMessage);
				erMsg += hDAOMessage;
				response.sendRedirect("SMSISystem/SMItemsInfo/SMItemsOPBal.jsp");
				break;
			case "xRITOPCLBQInfoX": // verify duplicate sport item code
				JsonArrayList = HDAOSMItemMasterOPBal.getItemMasterOPCLBalList(regNo);
				erMsg += SMFixedValue.OPENBAL + SMFixedValue.EXEC_QUERY_MSG;
				out.print(JsonArrayList.toJson());
				out.flush();				
				break;
			case "xRITOPBQInfoX": // generate Opening balance item list
				JsonArrayList = HDAOSMItemMasterOPBal.getItemsOPBalList(regNo);
				erMsg += SMFixedValue.OPENBAL + SMFixedValue.EXEC_QUERY_MSG;
				out.print(JsonArrayList.toJson());
				out.flush();				
				break;
			case "RmITOPBiDxIfno": // remove item openbal
				Long oPBalidNo = Long.parseLong(SMUtilities.subtractStringAndNumber(request.getParameter("opbalIDNO"), 1));
				String itemCode = SMUtilities.subtractStringAndNumber(request.getParameter("opbalIDNO"), 2);
				excStatus = HDAOSMItemMasterOPBal.delItemOpeningBalQty(regNo, oPBalidNo, itemCode);
//				excStatus = HDAOSMItemMasterOPBal.delItemOpeningBalQty(regNo, Long.parseLong(request.getParameter("opbalIDNO")));
				hDAOMessage += Integer.toString(excStatus) + SMFixedValue.EXEC_REMOVE_MSG;
				session.setAttribute(SMFixedValue.MESSAGE, hDAOMessage);
				erMsg += hDAOMessage;
				if(excStatus>0) {
					JsonArrayList = HDAOSMItemMasterOPBal.getItemsOPBalList(regNo);
					out.print(JsonArrayList.toJson());
					out.flush();				
				}else {
				response.sendRedirect("SMSISystem/SMItemsInfo/SMItemsOPBal.jsp");
				}
				break;
			case "xSprtItemsLIst": // Generate Sport item list based on item category
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG + "\n " + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
	}

	private SMItemMasterOPCLBalSubModel UpdateOPCLQtyModel(SMItemMasterOPBalSubModel oPBalSubModel,
			SMItemMasterOPCLBalSubModel oPClBalModel) {
		String erMsg="";
		try {
			oPClBalModel.setRegNo(oPBalSubModel.getRegNo());
			oPClBalModel.setItemCode(oPBalSubModel.getItemCode());
			oPClBalModel.setOpBalQty(oPBalSubModel.getOpBalQty());
			oPClBalModel.setClBalQty(oPBalSubModel.getOpBalQty());
			oPClBalModel.setItemMasterModelFK(oPBalSubModel.getItemMasterModelFK());
			oPClBalModel.setUserRefInfo(oPBalSubModel.getUserRefInfo());
			oPClBalModel.setStatus(SMFixedValue.STATUS);
			erMsg += "\n" + SMFixedValue.ITEM + SMFixedValue.OPENBAL + SMFixedValue.INPUT_VALUES + oPClBalModel;
		} catch (Exception e) {
			exeStatus = 4;
			erMsg += "\n" + SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {
			System.out.println(erMsg);
		}
		return oPClBalModel;
	}

	SMItemMasterOPBalSubModel updateOPBalInputValModel(SMItemMasterOPBalSubModel ITMOpenBalModel,
			HttpServletRequest request, HttpSession session) {
		String erMsg = SMFixedValue.ACTION_UPDATING + SMFixedValue.ITEM + SMFixedValue.INPUT_VALUES
				+ SMFixedValue.TOMODEL;
		try {
			ITMOpenBalModel.setRegNo(regNo);
			ITMOpenBalModel.setItemCategory(request.getParameter("SportCategory"));
			ITMOpenBalModel.setItemCode(SMUtilities.subtractStringAndNumber(request.getParameter("sprtICode"), 1));
			ITMOpenBalModel.setMake(request.getParameter("sprtMake"));
			ITMOpenBalModel.setManufYear(request.getParameter("manufYear"));
			if(!request.getParameter("dor").equals("")) {
				ITMOpenBalModel
				.setExpirydate(new SimpleDateFormat("dd-mm-yyyy").parse((String) request.getParameter("dor")));
			}
			ITMOpenBalModel.setOpBalQty(Integer.parseInt((String) request.getParameter("sprtItmQty")));
			ITMOpenBalModel.setUnit(request.getParameter("Unit"));
			if(!request.getParameter("sptPrice").equals("")) {
				ITMOpenBalModel.setPrice(Math.round(Float.parseFloat((String) request.getParameter("sptPrice"))));
			}
			ITMOpenBalModel.setItemMasterModelFK(Integer.parseInt(SMUtilities.subtractStringAndNumber(request.getParameter("sprtICode"), 2)));
			ITMOpenBalModel.setStatus(SMFixedValue.STATUS);

			SMDataCreatedUpdated userInfo = new SMDataCreatedUpdated();
			userInfo = SMUtilities.getUserInfo(session);
			ITMOpenBalModel.setUserRefInfo(userInfo);
			erMsg += "\n" + SMFixedValue.ITEM  + SMFixedValue.OPENBAL  + SMFixedValue.INPUT_VALUES + ITMOpenBalModel;
		} catch (Exception e) {
			exeStatus = 4;
			erMsg += "\n" + SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {
			System.out.println(erMsg);
		}
		return ITMOpenBalModel;
	}

	private String validateOPBalInputeValuse(HttpServletRequest request, HttpSession session) {
		String erMsg="InValid:";
		String itemCode=request.getParameter("sprtICode");
		int pos = 0;
		if(request.getParameter("SportCategory").equals("")) {
			erMsg+=" Item Category; ";
		}else if(request.getParameter("sprtItmQty").equals("")){
			erMsg+="Quantity can't Zero; ";
		}else if(itemCode.equals("")){
			erMsg+="Select Item Code ; ";
		}else if(!itemCode.equals("")){
			pos =itemCode.indexOf("/");
			if(pos==0 || pos> 0 && (itemCode.substring(pos+1).equals("") || itemCode.substring(0,pos).equals(""))) {
				erMsg+="Item Code (Technical Error); ";
			}	
		}
		return erMsg;
	}
}
