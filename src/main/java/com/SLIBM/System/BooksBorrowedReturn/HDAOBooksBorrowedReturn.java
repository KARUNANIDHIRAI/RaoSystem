package com.SLIBM.System.BooksBorrowedReturn;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.SLIBM.System.BooksIssue.BooksBorrowModel;
import com.SLIBM.System.BooksMaster.BooksMasterInfoModel;
import com.SLIBM.System.BooksMaster.HDAOBooksMaster;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOBooksBorrowedReturn {
	public static int BooksBorrowedReturnNew(BookBorrowedReturnModel booksBorrowedReturn) {
		String erMsg =SMFixedValue.ACTION_START + SMFixedValue.ACTION_CREATING 
				+ SMFixedValue.BOOK+ SMFixedValue.BORROWED + SMFixedValue.INFORMATION +":"; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(booksBorrowedReturn); 
 		    sessionObj.getTransaction().commit();
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

	public static int BooksBorrowedReturnIDNO(BookBorrowedReturnModel booksBorrowRetModel) {
		String erMsg =SMFixedValue.ACTION_CREATING 	+ SMFixedValue.BOOK_BORROWED_RETURN  + SMFixedValue.INFORMATION +":"; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			Query query = sessionObj.createQuery(SMFixedValue.UPD_BOOKMASTER_QTYBAL_BKRETURN);
			query.setParameter(SMFixedValue.PARM_REGNO  , booksBorrowRetModel.getRegNo());
			query.setParameter(SMFixedValue.PARM_BOOKCODE   , booksBorrowRetModel.getBookCode());
			query.setParameter(SMFixedValue.PARM_BOOKRETURNQTY  , booksBorrowRetModel.getNoOfCopyReturn());
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query queryBKReturn = sessionObj.createQuery(SMFixedValue.UPD_BOOKBORROW_RETURN_INFO);
			queryBKReturn.setParameter(SMFixedValue.PARM_REGNO  , booksBorrowRetModel.getRegNo());
			queryBKReturn.setParameter(SMFixedValue.PARM_IDNO   , booksBorrowRetModel.getiDNO());
			queryBKReturn.setParameter(SMFixedValue.PARM_RETURN_DATE   , booksBorrowRetModel.getBorrowRetrunDate());
			queryBKReturn.setParameter(SMFixedValue.PARM_RETURN_STATUS  , "R");
			queryBKReturn.setParameter(SMFixedValue.PARM_STATUS  , booksBorrowRetModel.getStatus());
			
			
			transaction =	  sessionObj.beginTransaction(); 
			exeStatus= query.executeUpdate(); // CHECK AND UPDATE BOOKS CLOSING BALANCE WITH RETURN  QTY
			if(exeStatus>0){
				exeStatus= queryBKReturn.executeUpdate(); // CHECK AND UPDATE BOOKS CLOSING BALANCE WITH RETURN  QTY
				sessionObj.save(booksBorrowRetModel); 
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

	public static JsonArray BooksBorrowedReturnSummary(BookBorrowedReturnModel booksBorrowedReturn) {
        String erMsg = SMFixedValue.BOOK_RETURN + SMFixedValue.Summary  ;
		JsonArray bookBorrowedList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<BookBorrowedReturnModel> creteriaQuery = builder.createQuery(BookBorrowedReturnModel.class);
	        Root<BookBorrowedReturnModel> root = creteriaQuery.from(BookBorrowedReturnModel.class);
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), booksBorrowedReturn.getRegNo()),
	            builder.equal(root.get(SMFixedValue.MODEL_BOOK_BORROW_ADMNO), booksBorrowedReturn.getAdmNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS),
	        	builder.equal(root.get(SMFixedValue.MODEL_ACUTAL_RETURNDATE), new Date()));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<BookBorrowedReturnModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <BookBorrowedReturnModel> rows=(ArrayList<BookBorrowedReturnModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        int sNO =0;
	        for(BookBorrowedReturnModel row: rows) {
	    	  if(row.getStatus().equals(SMFixedValue.STATUS)) {
		    	  JsonObject rObj = new JsonObject();
	              rObj.put("SNO"         , Integer.toString(++ sNO)) ;
		    	  rObj.put("RegNo"       , row.getRegNo());
		    	  rObj.put("SAdmNo"      , row.getAdmNo());
		    	  rObj.put("BookCode"    , row.getBookCode());
		    	  rObj.put("BookName"    , row.getBooksBorrowModel().getBookName());
		    	  rObj.put("Faculty Code", row.getFacultyCode());
		    	  rObj.put("Name"        , row.getBookTakenBy());
		    	  rObj.put("ReturnDate"   , row.getBorrowRetrunDate().toString());
		    	  rObj.put("BKReturnNos" , row.getNoOfCopyReturn());
		    	  rObj.put("fromDate"    , row.getBooksBorrowModel().getBorrowFromDate().toString());
		    	  rObj.put("ToDate"      , row.getBooksBorrowModel().getBorrowToDate().toString());
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

}
