package com.SLIBM.System.BooksIssue;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.SMInformation.SMFixedValue;


public class BookIssued extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookIssued() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		BooksBorrowModel booksBorrowModel = new BooksBorrowModel();
		booksBorrowModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNrBookBorrowed":	
				erMsg= SMFixedValue.ACTION_CREATING + SMFixedValue.BOOK + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;

				booksBorrowModel = BooksBorrowToModel(booksBorrowModel,request);
				excStatus = HDAOBooksBorrowed.BooksBorrowedNew(booksBorrowModel);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOBooksBorrowed.getBooksBorrowedList(booksBorrowModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
				
			case "xRiBKRData":	
				erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.BOOK + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;
				booksBorrowModel = BooksBorrowRemToModel(booksBorrowModel,request);
				excStatus = HDAOBooksBorrowed.BooksBorrowedRemoved(booksBorrowModel);
				hDAOMessage += excStatus>0?Integer.toString(excStatus) +SMFixedValue.EXEC_REMOVE_MSG
						                  :"0" +SMFixedValue.EXEC_REMOVE_MSG;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOBooksBorrowed.getBooksBorrowedList(booksBorrowModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRiBookBorrowed":	
				booksBorrowModel = BooksBorrowListToModel(booksBorrowModel, request);
				erMsg+= SMFixedValue.PARAM_BOOK_BORROW_CRETERIA_DONE;
				JsonArrayList = HDAOBooksBorrowed.getBooksBorrowedList(booksBorrowModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRBKBRPendingL":	
				booksBorrowModel = BooksBorrowListToModel(booksBorrowModel, request);
				erMsg+= SMFixedValue.PARAM_BOOK_BORROW_CRETERIA_DONE;
				JsonArrayList = HDAOBooksBorrowed.getBooksBorrowedPendingList(booksBorrowModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
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
	private BooksBorrowModel BooksBorrowListToModel(BooksBorrowModel booksBorrowModel, HttpServletRequest request) {
		String erMsg = "\n"+ SMFixedValue.ACTION_UPDATING + SMFixedValue.BOOK_BORROW_LIST_CRETRERIA  +SMFixedValue.TOMODEL+"\n";
		try {
			booksBorrowModel.setAdmNo(request.getParameter("AdmNumber"));
			booksBorrowModel.setStatus(SMFixedValue.STATUS);
			erMsg+= SMFixedValue.BOOK_BORROW_REM_CRETRERIA+ " AdmNo :"+booksBorrowModel.getAdmNo() 
			 + ", Status:" +booksBorrowModel.getStatus() + ", RegNo:" + booksBorrowModel.getRegNo()+ "\n" ;
			erMsg+= SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
		} catch (Exception e) {
			erMsg+= "\n"+SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}finally {
			System.out.println(erMsg);
		}
		return booksBorrowModel;
	}	
	private BooksBorrowModel BooksBorrowRemToModel(BooksBorrowModel booksBorrowModel, HttpServletRequest request) {
		String erMsg = "\n"+ SMFixedValue.ACTION_UPDATING + SMFixedValue.BOOK_BORROW_REM_CRETRERIA  +SMFixedValue.TOMODEL+"\n";
		try {
			booksBorrowModel.setiDNO(Integer.parseInt((String)request.getParameter("CodeId")));
			booksBorrowModel.setAdmNo(request.getParameter("AdmNumber"));
			booksBorrowModel.setStatus(SMFixedValue.STATUS);
			erMsg+= SMFixedValue.BOOK_BORROW_REM_CRETRERIA+ booksBorrowModel.getRegNo() 
			        +",IDNO:" + Integer.toString(booksBorrowModel.getiDNO()) 
			        + ", Status:" +booksBorrowModel.getStatus() 
			        + ", RegNo" + booksBorrowModel.getRegNo()+ "\n" ;
			erMsg+= SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
		} catch (Exception e) {
			erMsg+= "\n"+SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e;
		}finally {
			System.out.println(erMsg);
		}
		return booksBorrowModel;
	}

	private BooksBorrowModel BooksBorrowToModel(BooksBorrowModel booksBorrowModel,HttpServletRequest request) throws ParseException {
		String erMsg =  SMFixedValue.ACTION_UPDATING + SMFixedValue.BOOK_BORROW_INPUTVALUES 
				        +SMFixedValue.TOMODEL ;
		Object []inputValues = request.getParameterValues("xSbkBorrowed[]");
		try {
			booksBorrowModel.setAdmNo(inputValues[0].toString());
			booksBorrowModel.setFacultyCode(inputValues[1].toString());
			booksBorrowModel.setIssuedBy(inputValues[2].toString());
			booksBorrowModel.setBookCode(inputValues[3].toString());
			booksBorrowModel.setBookName(inputValues[4].toString());
			booksBorrowModel.setBorrowFromDate(new SimpleDateFormat("dd-mm-yyyy").parse(inputValues[5].toString()));	
			booksBorrowModel.setBorrowToDate(new SimpleDateFormat("dd-mm-yyyy").parse(inputValues[6].toString()));	
			booksBorrowModel.setNoOfCopyIssued(Integer.parseInt(inputValues[7].toString()));
			booksBorrowModel.setStatus(SMFixedValue.NEW_STATUS); 
			booksBorrowModel.setBorrowedRetStatus(SMFixedValue.BK_RET_DEFAULT_STATUS);
			booksBorrowModel.setCreatedBy("KNRAI");
			booksBorrowModel.setCreatedOn(new Date());
			booksBorrowModel.setUpdatedBy("KNRAI");
			booksBorrowModel.setUpdatedOn(new Date());
			erMsg+= "\n"+ SMFixedValue.BOOK_BORROW_INPUTVALUES +"\n" + booksBorrowModel;
			erMsg = "\n"+ SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
			
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
			
		}finally {
			System.out.println(erMsg);
		}
		return booksBorrowModel;
	}

}
