package com.sm.System.ItemLost;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.Faculty.HDAOFaculty;
import com.sm.System.ItemBorrow.HDAOItemBorrowed;
import com.sm.System.ItemBorrow.SMItemBorrowedSubModel;
import com.sm.System.ItemReturn.HDAOItemReturned;
import com.sm.System.ItemReturn.SMItemReturnModel;
import com.sm.System.ItemReturn.SMItemReturnSubModel;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMUtilities;


public class SMItemLostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_START + 1 ;
		SMItemLostModel sMILModel = new SMItemLostModel();
		sMILModel.setRegNo(session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString());
		sMILModel.setRegNo("MK308");
//		sMITRModel.setFacultyCode(session.getAttribute("FMCode")==null?"":session.getAttribute("FMCode").toString());
//		sMITBModel.setUserRefInfo(session.getAttribute("UserID")==null?"":session.getAttribute("UserID").toString());
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNSMITBLInfo":	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.LOST  + SMFixedValue.INFORMATION ;
				SMItemLostSubModel sMILSModel = new SMItemLostSubModel();
				sMILSModel.setRegNo(session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString());

				sMILSModel = inputValueToSMILSModel(sMILSModel,request,session);
				excStatus = HDAOItemLost.postItemLostNew(sMILSModel);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOItemBorrowed.getItemsBorrowedPendingList(sMILModel.getRegNo(),sMILModel.getAdmNo());
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
								
			case "xLTodayiTRV":	// retriev item return TODAY based on school and student
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN  + SMFixedValue.TODAY +":" ;
				sMILModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemLost.getTodayLostItemReported(sMILModel.getRegNo(), sMILModel.getAdmNo());
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XLiTBrInfo10":	// retriev Borrowed item LIST based on school and student
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMILModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemLost.getLostItemList(sMILModel.getRegNo(), sMILModel.getAdmNo());
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRiITBrMData": // delete item  based on school, admission and item idno	
				erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMILModel.setAdmNo(request.getParameter("Student"));
				sMILModel.setiDNO(Integer.parseInt(request.getParameter("CodeId")==null?"0":request.getParameter("CodeId")));
//				excStatus = HDAOItemReturned.delItemBorrowedidno(sMITBModel);
//				JsonArrayList = HDAOItemReturned.getItemReturnedList(sMITBModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XSEiTBrInfo10":// Student ERP Item issued List	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMILModel.setAdmNo(session.getAttribute("Student")==null?"":session.getAttribute("Student").toString());
				if(sMILModel.getAdmNo()!="") {
//					JsonArrayList = HDAOItemReturned.getItemReturnedList(sMITBModel);
					erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				}
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "sIxRiTBRInfoList":	// Student ERP Item issued List :retriev item return information based on school and student
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN  + SMFixedValue.TODAY +":" ;
				sMILModel.setAdmNo(session.getAttribute("Student")==null?"":session.getAttribute("Student").toString());
				sMILModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemReturned.getItemReturnedList(sMILModel.getRegNo(), sMILModel.getAdmNo());
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}finally {
			System.out.println(erMsg);
		}
	}

	private SMItemLostSubModel inputValueToSMILSModel(SMItemLostSubModel sMITRsModel, 
  			HttpServletRequest request, HttpSession session) {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.ITEM_LOST_INPUTVALUES +SMFixedValue.TOMODEL ;
		List<SMItemBorrowedSubModel> rows = new ArrayList<SMItemBorrowedSubModel>();
		try {
			 rows= HDAOItemBorrowed.getItemBorrowedIdnoinfo(Integer.parseInt((String)request.getParameter("SmitSnoid")));
			for (SMItemBorrowedSubModel row : rows) {
				sMITRsModel.setRegNo(row.getRegNo())          ;
				sMITRsModel.setAdmNo(row.getAdmNo())          ;
				sMITRsModel.setItemCode(row.getItemCode())    ;
				sMITRsModel.setItemCodeFK(row.getItemCodeFK());
				sMITRsModel.setSmITBiDNOFK(row.getiDNO())     ;
			} // EOF outer for loop
			sMITRsModel.setLostDate(new Date());	
			sMITRsModel.setLostQty(Integer.parseInt((String)request.getParameter("itemQty")));
			sMITRsModel.setPenaltyAmount(Integer.parseInt((String)request.getParameter("xLateFee")));
			sMITRsModel.setItemAmount(Integer.parseInt((String)request.getParameter("xLAmount")));

			sMITRsModel.setStatus(SMFixedValue.STATUS);
			int fmIDNO = HDAOFaculty.getfacultyMemberPK(sMITRsModel.getRegNo(), "KNR@BIRDIN.COM");
//			int fmIDNO = HDAOFaculty.getfacultyMemberPKey(sMITRsModel.getRegNo(), "KNR@BIRDIN.COM" ); 
			sMITRsModel.setFacultyCodeFK(fmIDNO);
			sMITRsModel.setUserRefInfo(SMUtilities.getUserInfo(session));
			erMsg+= sMITRsModel;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return sMITRsModel;
	}
}
