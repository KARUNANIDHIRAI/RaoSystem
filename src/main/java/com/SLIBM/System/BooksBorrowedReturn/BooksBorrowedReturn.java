package com.SLIBM.System.BooksBorrowedReturn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.SLIBM.System.BooksIssue.BooksBorrowModel;
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
		BooksBorrowModel booksBorrowModel = new BooksBorrowModel();
		booksBorrowModel.setiDNO(Integer.parseInt((String)("488")));
		booksBorrowedReturn.setBooksBorrowModel(booksBorrowModel);
		String hDAOMessage= "";
		int excStatus =0;
		excStatus = HDAOBooksBorrowedReturn.BooksBorrowedReturnNew(booksBorrowedReturn);
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;

	}

}
