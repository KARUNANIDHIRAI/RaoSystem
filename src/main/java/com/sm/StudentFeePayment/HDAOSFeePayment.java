package com.sm.StudentFeePayment;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOSFeePayment {

	public static int sFeePayment(SFeePayment siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(siModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" Save SpInformation.";
			rwaStatus=1;
	   }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return rwaStatus;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return rwaStatus;
	}

}
