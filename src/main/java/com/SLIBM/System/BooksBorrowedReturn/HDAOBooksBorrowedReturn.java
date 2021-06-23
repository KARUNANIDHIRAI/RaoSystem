package com.SLIBM.System.BooksBorrowedReturn;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;

import com.SLIBM.System.BooksIssue.BooksBorrowModel;
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
}
