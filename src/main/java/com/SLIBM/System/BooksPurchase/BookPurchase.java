package com.SLIBM.System.BooksPurchase;

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

import com.sm.System.Faculty.FacultyMemberAddressModel;
import com.sm.System.Faculty.HDAOFaculty;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.TestPerformance.HDAOTestPerformance;


public class BookPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		BooksPurchaseModel booksPurchaseModel = new BooksPurchaseModel();
		booksPurchaseModel.setRegNo("MK308");
		String hDAOMessage= "";
		int excStatus =0;
		JsonArray JsonArrayList = new JsonArray();
//		response.setContentType(SMFixedValue.ACTION_PLAIN_TEXT);
		response.setContentType("text/plain");
		
		
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		String Action = request.getParameter("Action");
		erMsg+= Action;
		try {
			switch (Action) {
			case "xBookPurchase":	
				booksPurchaseModel = UpdateBookPurchaseToRModel(booksPurchaseModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
				excStatus = HDAOBooksPurchase.BooksPurchaseNew(booksPurchaseModel);
				
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_CREATE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg = SMFixedValue.ACTION_CREATE + SMFixedValue.ACTION_STATUS + Integer.toString(excStatus) + ":"+hDAOMessage;
				break;
			case "xBkRmDATA" :	//Removed Books Purchase Data	
				booksPurchaseModel = UpdateBKRemoveQueryParmToRModel(booksPurchaseModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
				excStatus = HDAOBooksPurchase.BooksRemove(booksPurchaseModel);
				
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_REMOVE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg += hDAOMessage ;	
				
				JsonArrayList = HDAOBooksPurchase.BooksPurchaseList(booksPurchaseModel);
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_GENERATE_LIST:SMFixedValue.EXEC_TECHERROR_MSG ;
				erMsg += hDAOMessage+ "\n"+ JsonArrayList;	

				out.print(JsonArrayList.toJson());
				out.flush();
				break; 				
			case "xRBKList": // retrieve Faculty Member list	
				booksPurchaseModel = UpdateBKQueryParmToRModel(booksPurchaseModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;

				JsonArrayList = HDAOBooksPurchase.BooksPurchaseList(booksPurchaseModel);
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_GENERATE_LIST:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );

				erMsg += hDAOMessage + " :" + Integer.toString(JsonArrayList.size());
				
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xRBookInfo": // retrieve Book info based on Book Code	
				BooksPurchaseDetailModel booksPurchaseDetailModel = new BooksPurchaseDetailModel();
				booksPurchaseDetailModel = bookCodeQueryParmToRModel(booksPurchaseDetailModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;

				JsonArrayList = HDAOBooksPurchase.getBookInformation(booksPurchaseDetailModel);
				hDAOMessage= JsonArrayList.size()>0?SMFixedValue.EXEC_GENERATE_LIST:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );

				erMsg += hDAOMessage + " :" + Integer.toString(JsonArrayList.size());
				
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
				
			case "xUfmIDNO": // Update FAculty Member and then retrieve Faculty Member list	
				break;
				
			}
		} catch (Exception e) {
			System.out.println(SMFixedValue.EXEC_TECHERROR_MSG +"\n "+ e);
		}
		finally {
			System.out.println(erMsg);
		}

	}

	private BooksPurchaseDetailModel bookCodeQueryParmToRModel(BooksPurchaseDetailModel booksPurchaseDetailModel,
			HttpServletRequest request) {
		
		booksPurchaseDetailModel.setRegNo("MK308");
		booksPurchaseDetailModel.setBookCode(request.getParameter("xRbookCode"));
		booksPurchaseDetailModel.setStatus(SMFixedValue.STATUS);
		System.out.println(SMFixedValue.PARM_QUERY_INPUT 
				+ "RegNo :"+ booksPurchaseDetailModel.getRegNo()
				+ "BookCode: " +booksPurchaseDetailModel.getBookCode()
		        + "Status :" + booksPurchaseDetailModel.getStatus());
		return booksPurchaseDetailModel;
	}

	private BooksPurchaseModel UpdateBKQueryParmToRModel(BooksPurchaseModel booksPurchaseModel,	HttpServletRequest request) {
		booksPurchaseModel.setInvocieNo(request.getParameter("invoice"));
		booksPurchaseModel.setStatus(SMFixedValue.STATUS);
		System.out.println(SMFixedValue.PARM_QUERY_INPUT +booksPurchaseModel);
		return booksPurchaseModel;
	}
	private BooksPurchaseModel UpdateBKRemoveQueryParmToRModel(BooksPurchaseModel booksPurchaseModel,HttpServletRequest request) {
		booksPurchaseModel.setInvocieNo(request.getParameter("invoice"));
		booksPurchaseModel.setiDNO(Integer.parseInt(request.getParameter("bkIDDNO")));
		booksPurchaseModel.setStatus(SMFixedValue.STATUS);
		System.out.println(SMFixedValue.PARM_QUERY_INPUT +booksPurchaseModel);
		return booksPurchaseModel;
	}

	private BooksPurchaseModel UpdateBookPurchaseToRModel(BooksPurchaseModel booksPurchaseModel,HttpServletRequest request) {
		try {
//			booksPurchaseModel.setRegNo(request.getParameter("RegNo"));
			booksPurchaseModel.setInvocieNo(request.getParameter("bkInvNo"));
			booksPurchaseModel.setInvoiceDate(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("dor")));	
			booksPurchaseModel.setInvoiceAmount(Float.parseFloat(request.getParameter("invAmt")));
			booksPurchaseModel.setTotalQty(Integer.parseInt((String)request.getParameter("totQty")));
			booksPurchaseModel.setSupplier(request.getParameter("supplier"));
			booksPurchaseModel.setStatus("A");
			booksPurchaseModel.setCreatedBy("KNRAI");
			booksPurchaseModel.setUpdatedBy("KNRAI");
			booksPurchaseModel.setCreatedOn(new Date());
			booksPurchaseModel.setUpdatedOn(new Date());
			
			BooksPurchaseDetailModel booksDetails = new BooksPurchaseDetailModel();
			
			booksDetails.setRegNo(booksPurchaseModel.getRegNo());
			booksDetails.setBooksISBN(request.getParameter("bkISBN"));
			booksDetails.setBookCode(request.getParameter("bkCode"));
			booksDetails.setBookTitle(request.getParameter("bkTitle"));
			booksDetails.setAuthor(request.getParameter("bkAuthor"));
			booksDetails.setEdition(request.getParameter("bkEdition"));
			booksDetails.setPublisher(request.getParameter("bkPubName"));
			booksDetails.setBooKSource(request.getParameter("bkSource"));
			booksDetails.setbOOKPONO(request.getParameter("bkPONO"));
			booksDetails.setPrice(Float.parseFloat(request.getParameter("bkPrice")));
			booksDetails.setBookCopiesNos(Math.round(Float.parseFloat((String)request.getParameter("bkQty"))));
			booksDetails.setTax(Float.parseFloat((String)request.getParameter("bkTax")));
			booksDetails.setDiscount(Float.parseFloat((String)request.getParameter("bkDiscount")));
			booksDetails.setNetAmount(Float.parseFloat((String)request.getParameter("bkNetAmt")));
			booksDetails.setStatus("A");
			booksDetails.setCreatedBy("KNRAI");
			booksDetails.setUpdatedBy("KNRAI");
			booksDetails.setCreatedOn(new Date());
			booksDetails.setUpdatedOn(new Date());
			System.out.println("Input values Books Detils:" + booksDetails);
			
			booksPurchaseModel.getBKPurchaseDetail().add(booksDetails);
			booksDetails.setBKPurchase(booksPurchaseModel);

			System.out.println("\n pk Input values:" + booksPurchaseModel);
			System.out.println("\n kn Input values:" + booksDetails);
			
		} catch (Exception e) {
			System.out.println("\nError in UpdFormValueToRModel: \n" + e);
		} finally {
			System.out.println("INPUT VALUES :" + booksPurchaseModel);
		}

		return booksPurchaseModel;
	}

}
