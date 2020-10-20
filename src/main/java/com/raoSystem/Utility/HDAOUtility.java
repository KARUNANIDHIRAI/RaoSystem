package com.raoSystem.Utility;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOUtility {
	
	@SuppressWarnings("unused")
	public static JsonArray getAllRCIvList() {
		int geEnqStatus=0;
		Transaction transaction = null;
		JsonArray ivlist= new JsonArray();
		String erMsg;
		erMsg = " Step 2: HDAO start " ;
		System.out.println(erMsg);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	          erMsg += " 2.1: Began Tran OK. " ;
	          ArrayList<InitialValueModel> rows=(ArrayList<InitialValueModel>) sessionObj.createQuery("from InitialValueModel").list();
	          for( InitialValueModel row:rows) {
	        	  JsonObject jsonObject = new JsonObject();
	        	  jsonObject.put("id", row.getIDNO());
	        	  jsonObject.put("name", row.getName());
	        	  ivlist.add(jsonObject);
	          }
	          System.out.println(ivlist);
	          erMsg += " 2.2: Save OK. " ;
	          sessionObj.getTransaction().commit();
	          sessionObj.close();
	          erMsg = " 2.3 :GEnquiry save Successfully" ;
	          geEnqStatus=1;
	      } catch(HibernateException hibernateEx) {
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
              System.out.println("\n" + erMsg+" "+ ".......Transaction Is Being Rolled Back.......\n" + hibernateEx);
	      }catch (Exception e) {
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	          System.out.println("\n"+erMsg +"\n"+e );
		  }
		return ivlist;
	}

	public static JsonArray getRCIvItem(String parameter, String erMsg) {
		erMsg +="3.1 HDAO Start";

		return null;
	}
	

}
