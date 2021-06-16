package com.SLIBM.System.BooksPurchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.TestPerformance.MarksDetialModel;
import com.sm.System.TestPerformance.TestPerformanceModel;

public class HDAOBooksPurchase {
	public static int BooksPurchaseNew(BooksPurchaseModel booksPurchaseModel) {
		String erMsg =SMFixedValue.ACTION_START + SMFixedValue.ACTION_CREATING ; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int bookPurchaseInvocieIdNo= verifyInvoiceNoExist(booksPurchaseModel) ;
			if(bookPurchaseInvocieIdNo == 0) {
				sessionObj.save(booksPurchaseModel); // Insert data first time in Parent And Child Table
			}else { // Insert data into child table only 
				BooksPurchaseDetailSubModel booksDetails = new BooksPurchaseDetailSubModel();
				List<BooksPurchaseDetailModel> booksPurchaseDetailModel = new ArrayList<BooksPurchaseDetailModel>();
				booksPurchaseDetailModel =  booksPurchaseModel.getBKPurchaseDetail();
		        for(BooksPurchaseDetailModel row:booksPurchaseDetailModel) {
					booksDetails.setRegNo(booksPurchaseModel.getRegNo());
					booksDetails.setBooksISBN(row.getBooksISBN());
					booksDetails.setBookCode(row.getBookCode());
					booksDetails.setBookTitle(row.getBookTitle());
					booksDetails.setAuthor(row.getAuthor());
					booksDetails.setEdition(row.getEdition());
					booksDetails.setPublisher(row.getPublisher());
					booksDetails.setBooKSource(row.getBooKSource());
					booksDetails.setbOOKPONO(row.getbOOKPONO());
					booksDetails.setPrice(row.getPrice());
					booksDetails.setBookCopiesNos(row.getBookCopiesNos());
					booksDetails.setTax(row.getTax());
					booksDetails.setDiscount(row.getDiscount());
					booksDetails.setNetAmount(row.getNetAmount());
					booksDetails.setStatus(row.getStatus());
					booksDetails.setCreatedBy(row.getCreatedBy());
					booksDetails.setUpdatedBy(row.getUpdatedBy());
					booksDetails.setCreatedOn(new Date());
					booksDetails.setUpdatedOn(new Date());
					booksDetails.setiDNOFK(bookPurchaseInvocieIdNo);
					System.out.println("Input values Books Detils:" + booksDetails);		        	
		        }
				sessionObj.save(booksDetails);
			}
 		    sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=SMFixedValue.COMMIT + SMFixedValue.TRANSACTION;
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()){
				transaction.rollback();
			}
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}

	private static int verifyInvoiceNoExist(BooksPurchaseModel booksPurchaseModel) {
	        String erMsg = SMFixedValue.START + SMFixedValue.VERIFY +SMFixedValue.INVNO +": " ;
	        Integer IDNOFK = 0;
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        Query query = sessionObj.createQuery(SMFixedValue.HQL_VERIFY_INVOICE_NO);
		        query.setParameter(SMFixedValue.PARM_REGNO     ,  booksPurchaseModel.getRegNo());
		        query.setParameter(SMFixedValue.PARM_INVOICE_NO,  booksPurchaseModel.getInvocieNo());
		        query.setParameter(SMFixedValue.PARM_OSTATUS   ,  "A");
		        erMsg+= SMFixedValue.PARM_SET_MSG;
				
		       ArrayList <BooksPurchaseModel> rows =  (ArrayList<BooksPurchaseModel>) query.list();
		       for(BooksPurchaseModel row: rows) {
		    	   IDNOFK = row.getiDNO();
	              break;
			   }
		       sessionObj.close();
		    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
		    	erMsg += SMFixedValue.OUTPUT + rows.size() 
		    	+SMFixedValue.INVNO +" IDNO :"+ IDNOFK;
			}catch(Exception e) {
				erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return IDNOFK;
	}
	public static JsonArray BooksPurchaseList(BooksPurchaseModel booksPurchaseModel) {
        String erMsg = SMFixedValue.START + SMFixedValue.ACTION_GENERATE +SMFixedValue.BOOK
        		      + SMFixedValue.ACTION_LIST +", " ;
		JsonArray bookPurchaseList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<BooksPurchaseModel> creteriaQuery = builder.createQuery(BooksPurchaseModel.class);
	        Root<BooksPurchaseModel> root = creteriaQuery.from(BooksPurchaseModel.class);
	        root.fetch(SMFixedValue.MODEL_BOOK_PURCHASE_DETAILS_REFIN_BKMODEL);
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), booksPurchaseModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_INVOICENO), booksPurchaseModel.getInvocieNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<BooksPurchaseModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <BooksPurchaseModel> rows=(ArrayList<BooksPurchaseModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        int sNO =0;
	        for(BooksPurchaseModel row: rows) {
		    	   List<BooksPurchaseDetailModel> booksDetails = row.getBKPurchaseDetail();
		      for ( BooksPurchaseDetailModel data:booksDetails) {
		    	  if(data.getStatus().equals(SMFixedValue.STATUS)) {
			    	  JsonObject rObj = new JsonObject();
		              rObj.put("SNO"      , Integer.toString(++ sNO)) ;
			    	  rObj.put("RegNo"    , data.getRegNo());
			    	  rObj.put("PONO"     , data.getbOOKPONO());
			    	  rObj.put("ISBN"     , data.getBooksISBN());
			    	  rObj.put("BookCode" , data.getBookCode());
			    	  rObj.put("Title"    , data.getBookTitle());
			    	  rObj.put("Author"   , data.getAuthor());
			    	  rObj.put("Qty"      , data.getBookCopiesNos());
			    	  rObj.put("Price"    , data.getPrice());
			    	  rObj.put("Discount" , data.getDiscount());
			    	  rObj.put("Tax"      , data.getTax());
			    	  rObj.put("NetAmount", data.getNetAmount());
			    	  rObj.put("Publisher", data.getPublisher());
			    	  rObj.put("Source"   , data.getBooKSource());
			    	  rObj.put("Edition"  , data.getEdition());
			    	  rObj.put("IDNO"     , data.getiDDNO());
			    	  rObj.put("IDNOFK"   , row.getiDNO() );
			    	  rObj.put("TType"    , row.getInvocieNo());
			    	  bookPurchaseList.add(rObj);	
		    	  }
		      }
		    }// EOF outer for loop
	       sessionObj.close();
	    	erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
	    	+SMFixedValue.BOOK +SMFixedValue.ACTION_LIST +"\n" +bookPurchaseList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return bookPurchaseList;
	}		
	public static int BooksRemove(BooksPurchaseModel booksPurchaseModel) {
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING + SMFixedValue.BOOK + SMFixedValue.information;
        int executeUpdate = 0;
    	Transaction transaction = null; 
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.HQL_REM_BOOK_INFO);
	        query.setParameter(SMFixedValue.PARM_IDNO, booksPurchaseModel.getiDNO());
	        query.setParameter(SMFixedValue.PARM_REGNO, booksPurchaseModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        query.setParameter(SMFixedValue.PARM_OSTATUS, "A");

	        erMsg += SMFixedValue.PARM_SET_MSG;
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
//        	sessionObj.beginTransaction().commit();
 	        sessionObj.close();
	        erMsg += Integer.toString(executeUpdate) +" "+SMFixedValue.EXEC_REMOVE_MSG + " :" + SMFixedValue.ACTION_OK ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
	}	
	public static JsonArray getBookInformation(BooksPurchaseDetailModel bKPDetailModel) {
        String erMsg = SMFixedValue.START + SMFixedValue.ACTION_GENERATE +SMFixedValue.BOOK  + SMFixedValue.INFORMATION +", " ;
		JsonArray bookInformation = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        
	        CriteriaQuery<BooksPurchaseDetailModel> creteriaQuery = builder.createQuery(BooksPurchaseDetailModel.class);
	        Root<BooksPurchaseDetailModel> root = creteriaQuery.from(BooksPurchaseDetailModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), bKPDetailModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_CODE), bKPDetailModel.getBookCode()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<BooksPurchaseDetailModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <BooksPurchaseDetailModel> rows=(ArrayList<BooksPurchaseDetailModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        int sNO =0;
	        for ( BooksPurchaseDetailModel data:rows) {
	    	  if(data.getStatus().equals(SMFixedValue.STATUS)) {
		    	  JsonObject rObj = new JsonObject();
	              rObj.put("SNO"      , Integer.toString(++ sNO)) ;
		    	  rObj.put("RegNo"    , data.getRegNo());
		    	  rObj.put("PONO"     , data.getbOOKPONO());
		    	  rObj.put("ISBN"     , data.getBooksISBN());
		    	  rObj.put("BookCode" , data.getBookCode());
		    	  rObj.put("Title"    , data.getBookTitle());
		    	  rObj.put("Author"   , data.getAuthor());
		    	  rObj.put("Qty"      , data.getBookCopiesNos());
		    	  rObj.put("Price"    , data.getPrice());
		    	  rObj.put("Discount" , data.getDiscount());
		    	  rObj.put("Tax"      , data.getTax());
		    	  rObj.put("NetAmount", data.getNetAmount());
		    	  rObj.put("Publisher", data.getPublisher());
		    	  rObj.put("Source"   , data.getBooKSource());
		    	  rObj.put("Edition"  , data.getEdition());
		    	  rObj.put("IDNO"     , data.getiDDNO());
		    	  bookInformation.add(rObj);
		    	  break;
	    	  }
	       }
	       sessionObj.close();
	       erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
	    	+SMFixedValue.BOOK +SMFixedValue.INFORMATION +"\n" +bookInformation;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return bookInformation;
	}			
}
