package com.Sprots.System.SportItemsPurchase;

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

import com.SLIBM.System.BooksBorrowedReturn.BookBorrowedReturnModel;
import com.SLIBM.System.BooksBorrowedReturn.HDAOBooksBorrowedReturn;
import com.SLIBM.System.BooksIssue.BooksBorrowModel;
import com.SLIBM.System.BooksIssue.HDAOBooksBorrowed;
import com.SLIBM.System.BooksPurchase.BooksPurchaseDetailModel;
import com.SLIBM.System.BooksPurchase.HDAOBooksPurchase;
import com.Sprots.System.SportItemMaster.HDAOItemMaster;
import com.sm.System.SMInformation.SMFixedValue;

public class SportItemPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SportItemPurchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= SMFixedValue.ACTION_STEP + SMFixedValue.ACTION_START + 1 ;
		SportItemPurchaseModel spItemPurModel = new SportItemPurchaseModel();
		spItemPurModel.setRegNo("MK308");
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
				spItemPurModel = UpdateSPItemPurchaseToRModel(spItemPurModel,request);
				erMsg = SMFixedValue.ACTION_MODEL + SMFixedValue.ACTION_UPDATE + SMFixedValue.ACTION_OK;
				excStatus = HDAOItemMaster.sportItemsPurchaseNew(spItemPurModel);
				
				hDAOMessage= excStatus>0?SMFixedValue.EXEC_CREATE_MSG:SMFixedValue.EXEC_TECHERROR_MSG ;
				session.setAttribute(SMFixedValue.MESSAGE,hDAOMessage );
				erMsg = SMFixedValue.ACTION_CREATE + SMFixedValue.ACTION_STATUS + Integer.toString(excStatus) + ":"+hDAOMessage;
				break;
			case "xRetBKBRCD":	
				break; 	
			case "xRiBooksReturn":
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

	private SportItemPurchaseModel UpdateSPItemPurchaseToRModel(SportItemPurchaseModel spItemPurModel,
		HttpServletRequest request) {
		return spItemPurModel;
		try {
			xitmpruch10.push($("#spSource").val());

			xitmpruch10.push($("#itmCode").val());
			xitmpruch10.push($("#itmName").val());
			xitmpruch10.push($("#make").val());
			xitmpruch10.push($("#MfcDate").val());
			xitmpruch10.push($("#ExpiryDate").val());
			xitmpruch10.push($("#itmPrice").val());
			xitmpruch10.push($("#itmQty").val());
			xitmpruch10.push($("#Unit").val());
			xitmpruch10.push($("#itmDiscount").val());
			xitmpruch10.push($("#itmTax").val());
			xitmpruch10.push($("#itmNetAmt").val());
			
//			booksPurchaseModel.setRegNo(request.getParameter("RegNo"));
			spItemPurModel.setInvocieNo(request.getParameter("spPONO"));
			spItemPurModel.setSupplier(request.getParameter("supplier"));
			spItemPurModel.set
			spItemPurModel.setInvocieNo(request.getParameter("InvNo"));
			spItemPurModel.setInvoiceDate(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("invDate")));	
			spItemPurModel.setInvoiceAmount(Float.parseFloat(request.getParameter("invAmt")));
			spItemPurModel.setTotalQty(Integer.parseInt((String)request.getParameter("totQty")));
			spItemPurModel.setStatus("A");
			spItemPurModel.setCreatedBy("KNRAI");
			spItemPurModel.setUpdatedBy("KNRAI");
			spItemPurModel.setCreatedOn(new Date());
			spItemPurModel.setUpdatedOn(new Date());
			
			BooksPurchaseDetailModel booksDetails = new BooksPurchaseDetailModel();
			
			booksDetails.setRegNo(spItemPurModel.getRegNo());
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
			
			spItemPurModel.getBKPurchaseDetail().add(booksDetails);
			booksDetails.setBKPurchase(spItemPurModel);

			System.out.println("\n pk Input values:" + spItemPurModel);
			System.out.println("\n kn Input values:" + booksDetails);
			
		} catch (Exception e) {
			System.out.println("\nError in UpdFormValueToRModel: \n" + e);
		} finally {
			System.out.println("INPUT VALUES :" + spItemPurModel);
		}

	}

}
