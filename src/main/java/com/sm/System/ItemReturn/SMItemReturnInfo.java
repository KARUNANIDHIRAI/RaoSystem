package com.sm.System.ItemReturn;

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
import com.sm.System.ItemBorrow.SMItemBorrowedModel;
import com.sm.System.ItemBorrow.SMItemBorrowedSubModel;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMUtilities;


public class SMItemReturnInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SMItemReturnInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		SMItemReturnModel sMITRModel = new SMItemReturnModel();
		sMITRModel.setRegNo(session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString());
		sMITRModel.setRegNo("MK308");
//		sMITRModel.setFacultyCode(session.getAttribute("FMCode")==null?"":session.getAttribute("FMCode").toString());
//		sMITRModel.setFacultyCode(session.getAttribute("UserID")==null?"":session.getAttribute("UserID").toString());
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNSMItemBRInfo":	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.RETURN  + SMFixedValue.INFORMATION ;
				SMItemReturnSubModel sMIRSModel = new SMItemReturnSubModel();
				sMIRSModel.setRegNo(session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString());

				sMIRSModel = inputValueToSMIRSModel(sMIRSModel,request,session);
				excStatus = HDAOItemReturned.postItemReturnedNew(sMIRSModel);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

//				JsonArrayList = HDAOItemBorrowed.getItemsBorrowedList(sMIRSModel.getRegNo(), sMIRSModel.getAdmNo());
				JsonArrayList = HDAOItemBorrowed.getItemsBorrowedPendingList(sMIRSModel.getRegNo(),sMIRSModel.getAdmNo());
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
								
			case "xRTodayiTRView":	// retriev item return information based on school and student
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN  + SMFixedValue.TODAY +":" ;
				sMITRModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemReturned.getTodayItemReturnedList(sMITRModel.getRegNo(), sMITRModel.getAdmNo());
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XiTBrInfo10":	// retriev Borrowed item LIST based on school and student
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITRModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemReturned.getItemReturnedList(sMITRModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRiITBrMData": // delete item  based on school, admission and item idno	
				erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITRModel.setAdmNo(request.getParameter("Student"));
				sMITRModel.setiDNO(Integer.parseInt(request.getParameter("CodeId")==null?"0":request.getParameter("CodeId")));
				excStatus = HDAOItemReturned.delItemBorrowedidno(sMITRModel);
				JsonArrayList = HDAOItemReturned.getItemReturnedList(sMITRModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XSEiTBrInfo10":// Student ERP Item issued List	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITRModel.setAdmNo(session.getAttribute("Student")==null?"":session.getAttribute("Student").toString());
				if(sMITRModel.getAdmNo()!="") {
					JsonArrayList = HDAOItemReturned.getItemReturnedList(sMITRModel);
					erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				}
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "sIxRiTBRInfoList":	// Student ERP Item issued List :retriev item return information based on school and student
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN  + SMFixedValue.TODAY +":" ;
				sMITRModel.setAdmNo(session.getAttribute("Student")==null?"":session.getAttribute("Student").toString());
				sMITRModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemReturned.getItemReturnedList(sMITRModel.getRegNo(), sMITRModel.getAdmNo());
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

	private SMItemReturnSubModel inputValueToSMIRSModel(SMItemReturnSubModel sMITRsModel, 
			HttpServletRequest request, HttpSession session) {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.ITEM_RETURN_INPUTVALUES +SMFixedValue.TOMODEL ;
		List<SMItemBorrowedSubModel> rows = new ArrayList<SMItemBorrowedSubModel>();
		try {
			 rows= HDAOItemBorrowed.getBorrowedIdnoinfo(Integer.parseInt((String)request.getParameter("SmitSnoid")));
			for (SMItemBorrowedSubModel row : rows) {
				sMITRsModel.setRegNo(row.getRegNo())          ;
				sMITRsModel.setAdmNo(row.getAdmNo())          ;
				sMITRsModel.setItemCode(row.getItemCode())    ;
				sMITRsModel.setDueDate(row.getBorrowToDate()) ;
				sMITRsModel.setItemCodeFK(row.getItemCodeFK());
				sMITRsModel.setSmITBiDNOFK(row.getiDNO())     ;
			} // EOF outer for loop
			sMITRsModel.setReturnDate(new Date());	
			sMITRsModel.setStatus(SMFixedValue.STATUS);
			sMITRsModel.setReturnedQty(Integer.parseInt((String)request.getParameter("itemQty")));
			sMITRsModel.setPenaltyAmount(Integer.parseInt((String)request.getParameter("xLateFee")));
			int fmIDNO = HDAOFaculty.getfacultyMemberPK(sMITRsModel.getRegNo(), "KNR@BIRDIN.COM" ); 
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
