package com.sm.System.SchoolInformation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOSchoolInfo {
	public static int newRwa(SchoolInfoModel siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(siModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" hibernate commit transaction HDAQ1";
			rwaStatus=1;
		}catch(HibernateException hibernateEx) {
			erMsg +="...HibernateException Transaction .. \n" + hibernateEx;
			
			if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
    		return rwaStatus;
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
