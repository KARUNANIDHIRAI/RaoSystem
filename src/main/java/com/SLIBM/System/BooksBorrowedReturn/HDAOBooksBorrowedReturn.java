package com.SLIBM.System.BooksBorrowedReturn;

import org.hibernate.Session;
import org.hibernate.Transaction;

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


}
