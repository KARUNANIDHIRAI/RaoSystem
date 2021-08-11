package com.SLIBM.System.BooksBorrowedReturn;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.SLIBM.System.BooksIssue.BooksBorrowModel;
import com.SLIBM.System.BooksIssue.HDAOBooksBorrowed;
import com.sm.System.SMInformation.SMFixedValue;

public class BooksBorrowedReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		BookBorrowedReturnModel booksBorrowedReturn = new BookBorrowedReturnModel();
		booksBorrowedReturn.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xRetBKBRINFO":	
				erMsg= SMFixedValue.BOOK_BORROWED_RETURN;
				BooksBorrowModel booksBorrowModel = new BooksBorrowModel();
				booksBorrowModel.setRegNo("MK308");
				booksBorrowModel = BooksReturnIDNOToModel(booksBorrowModel,request);
				JsonArrayList = HDAOBooksBorrowed.BooksBorrowedInfoIDNO(booksBorrowModel);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
			case "xRetBKBRCD":	
				booksBorrowedReturn = bkBrReturnToModel(booksBorrowedReturn,request);
				excStatus = HDAOBooksBorrowedReturn.BooksBorrowedReturnIDNO(booksBorrowedReturn);
				hDAOMessage += excStatus>0?Integer.toString(excStatus) +SMFixedValue.BOOK_RETURN + SMFixedValue.SUCCESSFULLY
		                  :"0" +SMFixedValue.BOOK_RETURN + SMFixedValue.SUCCESSFULLY;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;
				response.sendRedirect("LibSystem/BooksBorrowedReturn.jsp");

				break; 	
			case "xRiBooksReturn":
				erMsg= SMFixedValue.BOOK_BORROWED_RETURN;
				booksBorrowedReturn.setAdmNo(request.getParameter("AdmNumber"));
				JsonArrayList = HDAOBooksBorrowedReturn.BooksBorrowedReturnSummary(booksBorrowedReturn);
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
	private BooksBorrowModel BooksReturnIDNOToModel(BooksBorrowModel booksBorrowModel, HttpServletRequest request) {
		String erMsg = "";
		try {
			booksBorrowModel.setiDNO(Integer.parseInt((String)request.getParameter("CodeId")));
			booksBorrowModel.setAdmNo(request.getParameter("AdmNumber"));
			booksBorrowModel.setStatus(SMFixedValue.STATUS);
			erMsg+= SMFixedValue.BOOK_BORROWED_RETURN + SMFixedValue.INPUT_VALUES + booksBorrowModel; 
		} catch (Exception e) {
			erMsg+= "\n"+SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}finally {
			System.out.println(erMsg);
		}
		return booksBorrowModel;
	}
	private BookBorrowedReturnModel  bkBrReturnToModel(BookBorrowedReturnModel bkBrReturn,HttpServletRequest request) throws ParseException {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.BOOK_RETURN + SMFixedValue.INPUT_VALUES  
				        +SMFixedValue.TOMODEL ;
		try {
			bkBrReturn.setAdmNo(request.getParameter("sAdmNo"));
			bkBrReturn.setFacultyCode(request.getParameter("takenByCode"));
			bkBrReturn.setBookTakenBy(request.getParameter("takenByName"));
			bkBrReturn.setBookCode(request.getParameter("bkCode"));
			String StringToDate2 =request.getParameter("retnDate").toString();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date= null;
            try {
                date = dateFormat.parse(StringToDate2);
	            bkBrReturn.setBorrowRetrunDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
//			bkBrReturn.setBorrowRetrunDate(new Date());
			
			bkBrReturn.setNoOfCopyReturn(Integer.parseInt(request.getParameter("bkQty").toString()));
			bkBrReturn.setLateFee((request.getParameter("bkRetLFee").equals(""))?0:
					Float.parseFloat(request.getParameter("bkRetLFee"))); 
			BooksBorrowModel booksBorrowModel = new BooksBorrowModel();
			booksBorrowModel.setiDNO(Integer.parseInt(request.getParameter("bkID").toString()));
			bkBrReturn.setBooksBorrowModel(booksBorrowModel);
			bkBrReturn.setiDNO(Integer.parseInt(request.getParameter("bkID").toString()));

			bkBrReturn.setStatus(SMFixedValue.NEW_STATUS); 
			bkBrReturn.setCreatedBy("KNRAI");
			bkBrReturn.setCreatedOn(new Date());
			bkBrReturn.setUpdatedBy("KNRAI");
			bkBrReturn.setUpdatedOn(new Date());
			erMsg+= "\n"+ SMFixedValue.BOOK_RETURN +SMFixedValue.INPUT_VALUES + bkBrReturn;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
			
		}finally {
			System.out.println(erMsg);
		}
		return bkBrReturn;
	}
	
	/*
	 * public static Date convertStringToDate(String strDate) throws ParseException
	 * { Date convertedDate = new Date(); String tempDate = ""; try { DateFormat
	 * dateFormat = new SimpleDateFormat("dd-MM-yyyy"); tempDate =
	 * dateFormat.format(strDate); convertedDate = dateFormat.parse(tempDate); }
	 * catch (Exception e) { e.printStackTrace(); } return convertedDate; }
	 */
	
}
