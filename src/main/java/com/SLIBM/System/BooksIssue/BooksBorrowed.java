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

public class BooksBorrowed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
				erMsg= SMFixedValue.ACTION_START + SMFixedValue.BOOK + SMFixedValue.BORROWED  + SMFixedValue.INFORMATION ;

				booksBorrowModel = BooksBorrowToModel(booksBorrowModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
				excStatus = HDAOBooksBorrowed.BooksBorrowedNew(booksBorrowModel);
				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOBooksBorrowed.getBooksBorrowedList(booksBorrowModel);
				erMsg+= SMFixedValue.EXEC_GENERATE_LIST + "Rows:" + JsonArrayList.size();
				erMsg += "\n" + JsonArrayList;	
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
			}
		} catch (Exception e) {
			System.out.println(SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e);
		}
		finally {
			System.out.println(erMsg);
		}
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
			booksBorrowModel.setStatus("A"); 
			booksBorrowModel.setCreatedBy("KNRAI");
			booksBorrowModel.setCreatedOn(new Date());
			booksBorrowModel.setUpdatedBy("KNRAI");
			booksBorrowModel.setUpdatedOn(new Date());
			erMsg+= SMFixedValue.BOOK_BORROW_INPUTVALUES +"\n" + booksBorrowModel;
		} catch (Exception e) {
		}finally {
			System.out.println(erMsg);
		}
		return booksBorrowModel;
	}
}
