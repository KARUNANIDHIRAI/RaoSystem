package com.sm.System.ItemBorrow;

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

import com.sm.System.Faculty.FacultyMemberModel;
import com.sm.System.Faculty.HDAOFaculty;
import com.sm.System.ItemMaster.HDAOItemMaster;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMDataCreatedUpdated;
import com.sm.System.SMUtility.SMUtilities;


public class ItemBorrowedInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ItemBorrowedInfo() {
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
		SMItemBorrowedModel sMITBModel = new SMItemBorrowedModel();
		sMITBModel.setRegNo(session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString());
		sMITBModel.setFacultyCode(session.getAttribute("FMCode")==null?"":session.getAttribute("FMCode").toString());
		sMITBModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNritemBorrowed":	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				SMItemBorrowedSubModel sMIBSModel = new SMItemBorrowedSubModel();
				sMIBSModel.setRegNo(session.getAttribute("RegNo")==null?"":session.getAttribute("RegNo").toString());

				sMIBSModel = inputValueToSMIBSModel(sMIBSModel,request,session);
				excStatus = HDAOItemBorrowed.itemsBorrowedNew(sMIBSModel);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOItemBorrowed.getTodayItemBorrowedList(sMIBSModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
				
			case "XiTBrInfo10":	// retriev Borrowed item information based on school and student
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITBModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemBorrowed.getItemBorrowedList(sMITBModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "XiTBrPendInfo10":	// retriev Borrowed item not return till date information based on school and student
				erMsg= SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITBModel.setAdmNo(request.getParameter("Student"));
				JsonArrayList = HDAOItemBorrowed.getItemsBorrowedPendingList(sMITBModel.getRegNo(),sMITBModel.getAdmNo());
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRiTBidInfoX":	// retriev Borrowed item information based on RegNo, AdminNo, borrowedIDNO 
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITBModel.setAdmNo(request.getParameter("Student"));
				sMITBModel.setiDNO(Integer.parseInt(request.getParameter("CodeId")==null?"0":request.getParameter("CodeId")));
				JsonArrayList = HDAOItemBorrowed.getItemBorrowedIdnoinfo(sMITBModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	

			case "xRiITBrMData": // delete item information based on school, student admission and item code idno	
				erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITBModel.setAdmNo(request.getParameter("Student"));
				sMITBModel.setiDNO(Integer.parseInt(request.getParameter("CodeId")==null?"0":request.getParameter("CodeId")));
				excStatus = HDAOItemBorrowed.delItemBorrowedidno(sMITBModel);
				JsonArrayList = HDAOItemBorrowed.getItemBorrowedList(sMITBModel);
				erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
				
			case "XSEiTBrInfo10":// Student ERP Item issued List	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				sMITBModel.setAdmNo(session.getAttribute("Student")==null?"":session.getAttribute("Student").toString());
				sMITBModel.setAdmNo(request.getParameter("Student"));
				if(sMITBModel.getAdmNo()!="") {
					JsonArrayList = HDAOItemBorrowed.getItemBorrowedList(sMITBModel);
					erMsg+= SMFixedValue.ITEM + SMFixedValue.BORROW_LIST_GENERATED;
				}
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			}
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}
		finally {
			System.out.println(erMsg);
		}
	}

	private SMItemBorrowedSubModel inputValueToSMIBSModel(SMItemBorrowedSubModel sMIBModel, 
			HttpServletRequest request, HttpSession session) {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.ITEM_BORROW_INPUTVALUES +SMFixedValue.TOMODEL ;
		Object []inputValues = request.getParameterValues("xSmITBorrowed[]");
		try {
			sMIBModel.setAdmNo(inputValues[0].toString());
			sMIBModel.setFacultyCode("DPS101");
			sMIBModel.setItemCode(inputValues[1].toString());
			
//			sMIBModel.setFacultyCode(inputValues[1].toString());
			sMIBModel.setBorrowFromDate(new SimpleDateFormat("dd-mm-yyyy").parse(inputValues[2].toString()));	
			sMIBModel.setBorrowToDate(new SimpleDateFormat("dd-mm-yyyy").parse(inputValues[3].toString()));	
			sMIBModel.setItemBorrowedQty(Integer.parseInt(inputValues[4].toString()));
			sMIBModel.setRollNo("A101");
			sMIBModel.setStudClass("KNRAI");
			sMIBModel.setItemName("ABCD");
			sMIBModel.setStatus(SMFixedValue.STATUS);
			sMIBModel.setBorrowedRetStatus(SMFixedValue.RETURN_DEFAULT_STATUS);

			int fmIDNO = HDAOFaculty.getfacultyMemberPK(sMIBModel.getRegNo(), sMIBModel.getFacultyCode() ); 
			int icode  = HDAOItemMaster.getItemCodePK(sMIBModel.getRegNo(), sMIBModel.getItemCode());
			sMIBModel.setFacultyCodeFK(fmIDNO);
			sMIBModel.setItemCodeFK(icode);
			sMIBModel.setUserRefInfo(SMUtilities.getUserInfo(session));
			
			erMsg+= sMIBModel;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return sMIBModel;
	}
	
}
