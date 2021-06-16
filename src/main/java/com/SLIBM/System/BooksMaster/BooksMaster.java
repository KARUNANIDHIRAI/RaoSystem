package com.SLIBM.System.BooksMaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.SMInformation.SMFixedValue;

public class BooksMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		BooksMasterInfoModel bookMasterModel = new BooksMasterInfoModel();
		bookMasterModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		PrintWriter out = response.getWriter(); 
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xNrBkMS":	
				erMsg= SMFixedValue.BOOK_MS_CREATING;

				bookMasterModel = booksMasterToModel(bookMasterModel,request);
				excStatus = HDAOBooksMaster.BookMasterNew(bookMasterModel);

				hDAOMessage= excStatus>0? SMFixedValue.EXEC_CREATE_MSG:"0 "+ SMFixedValue.EXEC_CREATE_MSG; 
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg+= hDAOMessage;

				JsonArrayList = HDAOBooksMaster.getBookMasterList(bookMasterModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
				
			case "xRiBKMSData":	
				JsonArrayList = HDAOBooksMaster.getBookMasterList(bookMasterModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 	
			case "xRBKMSiU":	
				bookMasterModel= booksMasteriDNOToModel(bookMasterModel, request);
				JsonArrayList = HDAOBooksMaster.getBookMasteriDNOList(bookMasterModel);
				erMsg+= SMFixedValue.BOOK_BORROW_LIST_GENERATED;
				out.print(JsonArrayList.toJson());
				out.flush();
				
				break; 	
			case "xRBKMSiD":	
				bookMasterModel= booksMasteriDNOToModel(bookMasterModel, request);
				excStatus = HDAOBooksMaster.remBookMasteriDNOList(bookMasterModel);
				JsonArrayList = HDAOBooksMaster.getBookMasterList(bookMasterModel);
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
	private BooksMasterInfoModel booksMasteriDNOToModel(BooksMasterInfoModel booksMasterModel,HttpServletRequest request){
		String erMsg =  SMFixedValue.BOOK_MS_INPUT_UPDMODEL;
		try {
			booksMasterModel.setiDNO(Integer.parseInt((String)request.getParameter("bkMSIDNO")));
			booksMasterModel.setStatus(SMFixedValue.DELETE_STATUS);
			erMsg+= "\n"+ SMFixedValue.BOOK_MS_INPUT_VALUE +"\n" + booksMasterModel;
			erMsg+= "\n"+ SMFixedValue.BOOK_MS_INPUT_UPDMODEL  + SMFixedValue.COMPLETED;
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println(erMsg);
		}
		return booksMasterModel;
	}

	private BooksMasterInfoModel booksMasterToModel(BooksMasterInfoModel booksMasterModel,HttpServletRequest request){
		String erMsg =  SMFixedValue.BOOK_MS_INPUT_UPDMODEL;
		Object []inputValues = request.getParameterValues("xSbkBorrowed[]");
		try {
			booksMasterModel.setBookCode(inputValues[0].toString());
			booksMasterModel.setBookTitle(inputValues[1].toString());
			booksMasterModel.setAuthor(inputValues[2].toString());
			booksMasterModel.setBooksISBN(inputValues[3].toString());
			booksMasterModel.setPublisher(inputValues[4].toString());
			booksMasterModel.setEdition(inputValues[5].toString());
			booksMasterModel.setCategory(inputValues[6].toString());
			booksMasterModel.setPrice(Integer.parseInt((String)inputValues[7]));
			
			booksMasterModel.setCreatedBy("KNRAI");
			booksMasterModel.setCreatedOn(new Date());
			booksMasterModel.setUpdatedBy(booksMasterModel.getCreatedBy());
			booksMasterModel.setUpdatedOn(booksMasterModel.getCreatedOn());
			booksMasterModel.setStatus(SMFixedValue.STATUS);
			
			System.out.println("BooksMasterInfoModel : "+booksMasterModel);

			BooksMasterQtyModel bookMasterQtyModel = new BooksMasterQtyModel();
			bookMasterQtyModel.setRegNo(booksMasterModel.getRegNo());
			bookMasterQtyModel.setBookCode(booksMasterModel.getBookCode());
			bookMasterQtyModel.setOpeningBooksQty(Integer.parseInt(inputValues[8].toString()));
			bookMasterQtyModel.setTotalBooksQty(bookMasterQtyModel.getOpeningBooksQty());
			bookMasterQtyModel.setClosingBooksQty(bookMasterQtyModel.getOpeningBooksQty());
			bookMasterQtyModel.setTmpClosingBooksQty(bookMasterQtyModel.getOpeningBooksQty());
			bookMasterQtyModel.setUpdatedBy(booksMasterModel.getCreatedBy());
			bookMasterQtyModel.setUpdatedOn(new Date());

			System.out.println("bookMasterQtyModel : "+bookMasterQtyModel);
			
			booksMasterModel.setBksMasterQtyIDNO(bookMasterQtyModel);

			erMsg+= "\n"+ SMFixedValue.BOOK_MS_OUPT_VALUE +"\n" + booksMasterModel;
			erMsg = "\n"+ SMFixedValue.BOOK_MS_INPUT_UPDMODEL  + SMFixedValue.COMPLETED;
			
		} catch (Exception e) {
			erMsg+= "\n"+ SMFixedValue.EXEC_CATCH_MSG + e;
			
		}finally {
			System.out.println(erMsg);
		}
		return booksMasterModel;
	}
		

}
