package com.SLIBM.System.BooksMaster;


import java.util.ArrayList;

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

public class HDAOBooksMaster {
	public static int BookMasterNew(BooksMasterInfoModel booksMasterInfoModel) {
	  String erMsg =SMFixedValue.ACTION_START +
	  SMFixedValue.CREATING_INFO_INTOTABLE + SMFixedValue.BOOK+ SMFixedValue.Master ;
	  Transaction transaction = null;
	  int exeStatus=0;
	  try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
		  transaction =	  sessionObj.beginTransaction(); 
		  sessionObj.save(booksMasterInfoModel);
		  sessionObj.getTransaction().commit();
		  sessionObj.close();
	  erMsg += "\n" +SMFixedValue.BOOK + SMFixedValue.Master + SMFixedValue.EXEC_CREATE_MSG ;
	  exeStatus=1;
	  }catch (Exception e) { 
		  erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
	  }finally {
		  System.out.println("\n"+erMsg); } return exeStatus;
	  }
	 
	public static JsonArray getBookMasterList(BooksMasterInfoModel bookMasteModel) {
	       String erMsg = SMFixedValue.BOOK_BORROW_LIST_GENERATING;
			JsonArray bookBorrowedList = new JsonArray();
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<BooksMasterInfoModel> creteriaQuery = builder.createQuery(BooksMasterInfoModel.class);
		        Root<BooksMasterInfoModel> root = creteriaQuery.from(BooksMasterInfoModel.class);
		        root.fetch(SMFixedValue.MODEL_BOOK_MASTER_QTY);
		        
		        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), bookMasteModel.getRegNo()),
		        	builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS));
		        erMsg += SMFixedValue.PARM_SET_MSG;

		        Query<BooksMasterInfoModel> query = sessionObj.createQuery(creteriaQuery);
		        ArrayList <BooksMasterInfoModel> rows=(ArrayList<BooksMasterInfoModel>) query.getResultList();
		    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
		        int sNO =0;
		        for(BooksMasterInfoModel row: rows) {
			    	  JsonObject rObj = new JsonObject();
		              rObj.put("SNO"          , Integer.toString(++ sNO)) ;
			    	  rObj.put("RegNo"        , row.getRegNo());
			    	  rObj.put("BookCode"     , row.getBookCode());
			    	  rObj.put("BookTitle"    , row.getBookTitle());
			    	  rObj.put("Author"       , row.getAuthor());
			    	  rObj.put("ISBN"         , row.getBooksISBN());
			    	  rObj.put("EDITION"      , row.getEdition());
			    	  rObj.put("PUBLISHER"    , row.getPublisher());
			    	  rObj.put("Category"     , row.getCategory());
			    	  rObj.put("Price"        , row.getPrice());
			    	  rObj.put("NoOfBooks"    , row.getBksMasterQtyIDNO().getTotalBooksQty());
			    	  rObj.put("BKMQiDNOFK"   , row.getBksMasterQtyIDNO().getiDNO());
			    	  rObj.put("iDNO"         , row.getiDNO());
			    	  bookBorrowedList.add(rObj);	
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

	public static JsonArray getBookMasteriDNOList(BooksMasterInfoModel booksMasterModel) {
	       String erMsg = SMFixedValue.BOOK_BORROW_LIST_GENERATING;
			JsonArray bookMaterIdnoList = new JsonArray();
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<BooksMasterInfoModel> creteriaQuery = builder.createQuery(BooksMasterInfoModel.class);
		        Root<BooksMasterInfoModel> root = creteriaQuery.from(BooksMasterInfoModel.class);
		        root.fetch(SMFixedValue.MODEL_BOOK_MASTER_QTY);
		        
		        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_BOOK_REGNO), booksMasterModel.getRegNo()),
		        		            builder.equal(root.get(SMFixedValue.MODEL_BOOK_iDNO), booksMasterModel.getiDNO()),
		        	                builder.equal(root.get(SMFixedValue.MODEL_BOOK_STATUS), SMFixedValue.LIST_STATUS));
		        erMsg += SMFixedValue.PARM_SET_MSG;

		        Query<BooksMasterInfoModel> query = sessionObj.createQuery(creteriaQuery);
		        ArrayList <BooksMasterInfoModel> rows=(ArrayList<BooksMasterInfoModel>) query.getResultList();
		    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
		        int sNO =0;
		        for(BooksMasterInfoModel row: rows) {
			    	  JsonObject rObj = new JsonObject();
		              rObj.put("SNO"          , Integer.toString(++ sNO)) ;
			    	  rObj.put("RegNo"        , row.getRegNo());
			    	  rObj.put("BookCode"     , row.getBookCode());
			    	  rObj.put("BookTitle"    , row.getBookTitle());
			    	  rObj.put("Author"       , row.getAuthor());
			    	  rObj.put("ISBN"         , row.getBooksISBN());
			    	  rObj.put("EDITION"      , row.getEdition());
			    	  rObj.put("PUBLISHER"    , row.getPublisher());
			    	  rObj.put("Category"     , row.getCategory());
			    	  rObj.put("Price"        , Integer.toString(row.getPrice()));
			    	  rObj.put("NoOfBooks"    , Integer.toString(row.getBksMasterQtyIDNO().getTotalBooksQty()));
		//	    	  rObj.put("BKMQiDNOFK"   , Integer.toString(row.getBksMasterQtyIDNO().getiDNO()));
			    	  rObj.put("iDNO"         , Integer.toString(row.getiDNO()));
			    	  bookMaterIdnoList.add(rObj);	
			    }// EOF outer for loop
		       sessionObj.close();
		    	erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
		    	       + SMFixedValue.BOOK_BORROW_LIST_GENERATED +"\n" +bookMaterIdnoList;
			}catch(Exception e) {
				erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}
			return bookMaterIdnoList;
	}

	public static int remBookMasteriDNOList(BooksMasterInfoModel bookMasterModel) {
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING + SMFixedValue.BOOK + SMFixedValue.information;
        int executeUpdate = 0;
    	Transaction transaction = null; 
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.HQL_REM_BOOKMASTER_IDNO);
	        query.setParameter(SMFixedValue.PARM_IDNO   , bookMasterModel.getiDNO());
	        query.setParameter(SMFixedValue.PARM_REGNO  , bookMasterModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);

	        erMsg += SMFixedValue.PARM_SET_MSG;  
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
//        	sessionObj.beginTransaction().commit();
 	        sessionObj.close();
	        erMsg += Integer.toString(executeUpdate) +" "+SMFixedValue.EXEC_REMOVE_MSG ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;	}


}
