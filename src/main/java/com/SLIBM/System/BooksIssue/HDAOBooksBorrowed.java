package com.SLIBM.System.BooksIssue;

import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.SLIBM.System.BooksMaster.BooksMasterInfoModel;
import com.SLIBM.System.BooksMaster.BooksMasterQtyModel;
import com.SLIBM.System.BooksMaster.HDAOBooksMaster;
import com.SLIBM.System.BooksPurchase.BooksPurchaseDetailModel;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.Faculty.FacultyModel;
import com.sm.System.SMInformation.SMFixedValue;
public class HDAOBooksBorrowed {

	public static int BooksBorrowedNew(BooksBorrowModel booksBorrowModel) {
		String erMsg =SMFixedValue.ACTION_CREATING 	+ SMFixedValue.BOOK+ SMFixedValue.BORROWED
				                                    + SMFixedValue.INFORMATION +":"; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			Query query = sessionObj.createQuery(SMFixedValue.UPD_BOOKMASTER_QTYBAL_BKISSUENEW);
	        query.setParameter(SMFixedValue.PARM_REGNO  , booksBorrowModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_BOOKCODE   , booksBorrowModel.getBookCode());
	        query.setParameter(SMFixedValue.PARM_BOOKISSEDUEQTY  , booksBorrowModel.getNoOfCopyIssued());
			erMsg += SMFixedValue.PARM_SET_MSG;

	        transaction =	  sessionObj.beginTransaction(); 
	        exeStatus= query.executeUpdate(); // CHECK AND UPDATE BOOKS AVAILABLE QTY
			sessionObj.save(booksBorrowModel); 
			if(exeStatus>0){
				sessionObj.getTransaction().commit();
			}
			sessionObj.close();
			erMsg +=SMFixedValue.EXEC_CREATE_MSG ;
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()){
				transaction.rollback();
			}
 	   }finally {
 		   System.out.println("\n"+erMsg);
 	   }
		return exeStatus;
	}
	public static JsonArray getBooksBorrowedList(BooksBorrowModel booksBorrowModel) {
        String erMsg = SMFixedValue.BOOK_BORROW_LIST_GENERATING;
		JsonArray bookBorrowedList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<BooksBorrowModel> creteriaQuery = builder.createQuery(BooksBorrowModel.class);
	        Root<BooksBorrowModel> root = creteriaQuery.from(BooksBorrowModel.class);
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), booksBorrowModel.getRegNo()),
	            builder.equal(root.get(SMFixedValue.MODEL_BOOK_BORROW_ADMNO), booksBorrowModel.getAdmNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<BooksBorrowModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <BooksBorrowModel> rows=(ArrayList<BooksBorrowModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        int sNO =0;
	        for(BooksBorrowModel row: rows) {
	    	  if(row.getStatus().equals(SMFixedValue.STATUS)) {
		    	  JsonObject rObj = new JsonObject();
	              rObj.put("SNO"         , Integer.toString(++ sNO)) ;
		    	  rObj.put("RegNo"       , row.getRegNo());
		    	  rObj.put("SAdmNo"      , row.getAdmNo());
		    	  rObj.put("BookCode"    , row.getBookCode());
		    	  rObj.put("BookName"    , row.getBookName());
		    	  rObj.put("IssuedByCode", row.getFacultyCode());
		    	  rObj.put("IssuedByName", row.getIssuedBy());
		    	  rObj.put("fromDate"    , row.getBorrowFromDate().toString());
		    	  rObj.put("ToDate"      , row.getBorrowToDate().toString());
		    	  rObj.put("BooksCopies" , row.getNoOfCopyIssued());
		    	  rObj.put("iDNO"        , row.getiDNO());
		    	  bookBorrowedList.add(rObj);	
	    	  }
		    }// EOF outer for loop
	       sessionObj.close();
	    	erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
	    	       + SMFixedValue.BOOK_BORROW_LIST_GENERATED +"\n" +bookBorrowedList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return bookBorrowedList;
	}
	public static int BooksBorrowedRemoved(BooksBorrowModel booksBorrowModel) {
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING_BOOK_BORROW;
		int executeUpdate = 0;
		Transaction transaction = null;
		booksBorrowModel = getBookCodeAndIssueQty(booksBorrowModel);
		if(booksBorrowModel.getBookCode().equals(null)) {
			return executeUpdate;
		}
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			 Query remBookBorrowed = sessionObj.createQuery(SMFixedValue.HQL_BOOK_BORROWED_REMOVE);
			 remBookBorrowed.setParameter(SMFixedValue.PARM_REGNO   , booksBorrowModel.getRegNo());
			 remBookBorrowed.setParameter(SMFixedValue.PARM_IDNO    , booksBorrowModel.getiDNO());
			 remBookBorrowed.setParameter(SMFixedValue.PARM_NSTATUS , SMFixedValue.DELETE_STATUS);
			 remBookBorrowed.setParameter(SMFixedValue.PARM_OSTATUS , booksBorrowModel.getStatus());
	    	erMsg += SMFixedValue.PARM_SET_MSG;

			Query updBookMasterQty = sessionObj.createQuery(SMFixedValue.UPD_BOOKMASTER_QTYBAL_BKISSUEREMOVE);
			updBookMasterQty.setParameter(SMFixedValue.PARM_REGNO         , booksBorrowModel.getRegNo());
			updBookMasterQty.setParameter(SMFixedValue.PARM_BOOKCODE      , booksBorrowModel.getBookCode());
			updBookMasterQty.setParameter(SMFixedValue.PARM_BOOKISSEDUEQTY, booksBorrowModel.getNoOfCopyIssued());
	    	
	    	transaction = sessionObj.beginTransaction(); 
			executeUpdate= remBookBorrowed.executeUpdate();// UPDATE STATUS AS 'D' FOR DEACTIVATE RECORD
	        erMsg += executeUpdate>0?Integer.toString(executeUpdate) +SMFixedValue.EXEC_REMOVE_MSG:"0" +SMFixedValue.EXEC_REMOVE_MSG;
	        if(executeUpdate>0) {
		        executeUpdate= updBookMasterQty.executeUpdate();//UPDATE BOOK MASTER BOOK QTY FOR DEACTIVATED RECORD
		        erMsg += executeUpdate>0?Integer.toString(booksBorrowModel.getNoOfCopyIssued()) + " Qty:" +SMFixedValue.EXEC_REMOVE_UPD_MSG
		        		              :"0" +SMFixedValue.EXEC_REMOVE_UPD_MSG;
	        }
	        sessionObj.close();
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()){
				transaction.rollback();
			}
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
	}
	public static JsonArray getBooksBorrowedPendingList(BooksBorrowModel booksBorrowModel) {
        String erMsg = SMFixedValue.BOOK_BR_PENDLIST_GENERATING ;
		JsonArray bookBorrowedList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<BooksBorrowModel> creteriaQuery = builder.createQuery(BooksBorrowModel.class);
	        Root<BooksBorrowModel> root = creteriaQuery.from(BooksBorrowModel.class);
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), booksBorrowModel.getRegNo()),
	            builder.equal(root.get(SMFixedValue.MODEL_BOOK_BORROW_ADMNO), booksBorrowModel.getAdmNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_BORROW_RETSTATUS), SMFixedValue.BKBR_RETSTATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<BooksBorrowModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <BooksBorrowModel> rows=(ArrayList<BooksBorrowModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        int sNO =0;
	        for(BooksBorrowModel row: rows) {
	    	  if(row.getStatus().equals(SMFixedValue.STATUS)) {
		    	  JsonObject rObj = new JsonObject();
	              rObj.put("SNO"         , Integer.toString(++ sNO)) ;
		    	  rObj.put("RegNo"       , row.getRegNo());
		    	  rObj.put("SAdmNo"      , row.getAdmNo());
		    	  rObj.put("BookCode"    , row.getBookCode());
		    	  rObj.put("BookName"    , row.getBookName());
		    	  rObj.put("IssuedByCode", row.getFacultyCode());
		    	  rObj.put("IssuedByName", row.getIssuedBy());
		    	  rObj.put("fromDate"    , row.getBorrowFromDate().toString());
		    	  rObj.put("ToDate"      , row.getBorrowToDate().toString());
		    	  rObj.put("BooksCopies" , row.getNoOfCopyIssued());
		    	  rObj.put("iDNO"        , row.getiDNO());
		    	  bookBorrowedList.add(rObj);	
	    	  }
		    }// EOF outer for loop
	       sessionObj.close();
	        erMsg+= SMFixedValue.BOOK_BR_PENDLIST_GENERATING + SMFixedValue.COMPLETED + SMFixedValue.OUTPUT 
	    	+ " Total Rows:" + rows.size() +"\n" +bookBorrowedList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return bookBorrowedList;
	}
	public static BooksBorrowModel getBookCodeAndIssueQty(BooksBorrowModel booksBorrowModel) {
		String erMsg =SMFixedValue.RETRIEVING + SMFixedValue.BOOK+ SMFixedValue.CODE+  ":"; 
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<BooksBorrowModel> creteriaQuery = builder.createQuery(BooksBorrowModel.class);
	        Root<BooksBorrowModel> root = creteriaQuery.from(BooksBorrowModel.class);
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), booksBorrowModel.getRegNo()),
	            builder.equal(root.get(SMFixedValue.MODEL_BOOK_iDNO), booksBorrowModel.getiDNO()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        Query<BooksBorrowModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <BooksBorrowModel> rows=(ArrayList<BooksBorrowModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        for(BooksBorrowModel row: rows) {
	        	booksBorrowModel.setBookCode(row.getBookCode());
	        	booksBorrowModel.setNoOfCopyIssued(row.getNoOfCopyIssued());
	        	break;
		    }
	       sessionObj.close();
	        erMsg+= SMFixedValue.BOOK+ SMFixedValue.INFORMATION + " :" + booksBorrowModel;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return booksBorrowModel;
	}
	public static JsonArray BooksBorrowedInfoIDNO(BooksBorrowModel booksBorrowModel) {
		String erMsg = SMFixedValue.BOOK_BORROW_IDNOINFO;
		JsonArray bookBorrowedInfo = new JsonArray();
		BooksMasterInfoModel booksMasterInfoModel = new BooksMasterInfoModel();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Query<BooksBorrowModel> rsQuery = sessionObj.createQuery(SMFixedValue.HQL_BOOK_BORROW_IDNOINFO);
			rsQuery.setParameter(SMFixedValue.PARM_REGNO   , booksBorrowModel.getRegNo());
			rsQuery.setParameter(SMFixedValue.PARM_IDNO    , booksBorrowModel.getiDNO());
			rsQuery.setParameter(SMFixedValue.PARM_STATUS , SMFixedValue.STATUS);
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        erMsg += SMFixedValue.INFORMATION_FETCH_CRITERIA 
	        		+ SMFixedValue.MODEL_REGNO + ":" + booksBorrowModel.getRegNo() 
	        		+ ", " + SMFixedValue.PARM_IDNO   + ":" + booksBorrowModel.getiDNO() 
	        		+ ", " + SMFixedValue.PARM_STATUS + ":" + SMFixedValue.STATUS;
	        ArrayList <BooksBorrowModel> rows = (ArrayList <BooksBorrowModel>)  rsQuery.list();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        for(BooksBorrowModel row: rows) {
		    	  JsonObject rObj = new JsonObject();
		    	  rObj.put("RegNo"          , row.getRegNo());
		    	  rObj.put("BookCode"       , row.getBookCode());
		    	  rObj.put("BookTitle"      , row.getBookName());
		    	  rObj.put("FromDate"       , row.getBorrowFromDate().toString());
		    	  rObj.put("ToDate"         , row.getBorrowToDate().toString());
		    	  rObj.put("NoOfBooksBR"    , row.getNoOfCopyIssued());
		    	  booksMasterInfoModel = HDAOBooksMaster.getBookMasterCodeInfo(row.getBookCode(),booksBorrowModel.getRegNo());
		    	  rObj.put("NoOfBooks"      , booksMasterInfoModel.getBksMasterQtyIDNO().getClosingBooksQty());
		    	  rObj.put("ISBN"           , booksMasterInfoModel.getBooksISBN());
		    	  rObj.put("Edition"        , booksMasterInfoModel.getEdition());
		    	  rObj.put("Author"         , booksMasterInfoModel.getAuthor());
		    	  rObj.put("Publisher"      , booksMasterInfoModel.getPublisher());
		    	  bookBorrowedInfo.add(rObj);
		    	  break;
		    }
	       sessionObj.close();
	    	erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:(" + rows.size() + ") :" +bookBorrowedInfo;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return bookBorrowedInfo;
	}
}
