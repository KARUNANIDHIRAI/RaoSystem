package com.sm.System.SMPickupDrop;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOSMPickupDrop {

	public static int postStudentPickupDrop(SMPickupDropSubModel sMPDSModel) {
			Transaction transaction = null;
			String erMsg =" Step 3.0 Start HDAO - ";
			int rwaStatus=0;
			try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
				transaction = sessionObj.beginTransaction();
				sessionObj.save(sMPDSModel);
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
