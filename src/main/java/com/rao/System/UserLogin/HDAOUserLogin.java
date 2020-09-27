package com.rao.System.UserLogin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.createUser.UserModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOUserLogin {
	
	public static String newUser(UserLoginModel uLModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
//			sessionObj.save(uLModel);
			sessionObj.persist(uLModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg ="";
		}catch(HibernateException hibernateEx) {
			erMsg +="...HibernateException Transaction .. \n" + hibernateEx;
			if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
    		return erMsg;
	    }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return erMsg;
 	   }finally {
 		   System.out.println("HDAO : " +erMsg);
 	   }
		return erMsg;
	}

	public static JsonArray userlList(JsonArray ulArray, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
		     int ctr= 0;
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginModel> root = creteriaQuery.from(UserLoginModel.class);
	        
	        Path<Object> rwaNo = root.get("regNo");
	        Path<Object> email = root.get("email");
	        Path<Object> FirstName = root.get("FirstName");
	        Path<Object> LastName = root.get("LastName");
	        Path<Object> Mobile = root.get("Mobile");
	        creteriaQuery.multiselect(rwaNo, email,FirstName,LastName,Mobile);
	        creteriaQuery.where(builder.equal(root.get("regNo"), "MK103"),
	        		            builder.equal(root.get("status"), "A"));
        
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	       
	       System.out.println("\n uLarray length: "+ ulArray.size());
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RWA", row[0]);
	    	   rObj.put("ULID", row[1]);
	    	   rObj.put("FName", row[2]);
	    	   rObj.put("LName", row[3]);
	    	   rObj.put("Mobile", row[4]);
	    	   ulArray.add(rObj);
	       }
	       
	       System.out.println("Array :" +ulArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return ulArray;
	}

	public static JsonArray userInfo(JsonArray userInfoArray, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
	        int ctr = 0;
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserLoginModel> creteriaQuery = builder.createQuery(UserLoginModel.class);
	        Root<UserLoginModel> root = creteriaQuery.from(UserLoginModel.class);
//	        root.join("UAdd");
	        root.fetch("UAdd");
	        creteriaQuery.where(builder.equal(root.get("regNo"), "MK103"),
		            builder.equal(root.get("status"), "A"));
	        
	        Query<UserLoginModel> query = sessionObj.createQuery(creteriaQuery);
		       ArrayList <UserLoginModel> rows =  (ArrayList<UserLoginModel>) query.getResultList();

		       for(UserLoginModel row : rows) {
		    	   JsonObject rObj = new JsonObject();
		    	   rObj.put("SNO", ++ctr);
		    	   rObj.put("RWA", row.getRegNo());
		    	   rObj.put("ULID", row.getEmail());
		    	   rObj.put("FName", row.getFirstName());
		    	   rObj.put("LName", row.getLastName());
		    	   rObj.put("Mobile", row.getMobile());
		    	   List<UserAddress> uAddress = row.getUAdd();
		    	   for( UserAddress uarow :uAddress ) {
		    		   rObj.put("Address", uarow.getAddress());
		    		   rObj.put("Sector", uarow.getSector());
		    		   rObj.put("City", uarow.getCity());
		    		   rObj.put("State", uarow.getState());
		    		   rObj.put("Country", uarow.getCountry());
		    		   rObj.put("PinCode", uarow.getPinCode());
		    	   }
			    	   userInfoArray.add(rObj);
		    	   }
		       System.out.println(userInfoArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return userInfoArray;
	}

	public static JsonArray userLoginInfo(JsonArray userInfoArray, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
	        int ctr = 0;
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginInfo");
	        sPQuery.registerStoredProcedureParameter("Emailid", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo", String.class, ParameterMode.IN);
	        sPQuery.setParameter("Emailid", "RAMA@GMAIL.COM");
	        sPQuery.setParameter("RwaRegNo", "MK103");
        
	        sPQuery.execute();
	        List<Object[]> rows =  sPQuery.getResultList();
	        System.out.println(rows.size());
	        for(Object[] row : rows) {
	    	   JsonObject krObj = new JsonObject();
	    	   krObj.put("SNO",     ++ctr);
	    	   krObj.put("ULID",    row[0]);
	    	   krObj.put("RWA",     row[1]);
	    	   krObj.put("FName",   row[2]);
	    	   krObj.put("LName",   row[3]);
	    	   krObj.put("Security",row[4]);
	    	   krObj.put("Mobile",  row[5]);
	    	   krObj.put("Address", row[6]);
	    	   krObj.put("Sector",  row[7]);
	    	   krObj.put("City",    row[8]);
	    	   krObj.put("State",   row[9]);
	    	   krObj.put("Country", row[10]);
	    	   krObj.put("PinCode", row[11]);
		        userInfoArray.add(krObj);
    	    }
	        System.out.println(userInfoArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return userInfoArray;
	}
	public static Integer  userLoginInfoEdit(UserLoginModel uLModel, String erMsg) {
        erMsg += " 2.1: Began Tran OK. " ;
        Integer  spStatus=0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginInfoUpdate");
	        sPQuery.registerStoredProcedureParameter("Emailid",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo", String.class, ParameterMode.IN);

	        sPQuery.registerStoredProcedureParameter("FName",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("LName",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Mobile",   String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Security", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UID",      String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Password", String.class, ParameterMode.IN);

	        sPQuery.registerStoredProcedureParameter("Address",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Sector",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("City",     String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("State",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Country",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("PinCode",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SPStatus", Integer.class, ParameterMode.OUT);
	        
	        sPQuery.setParameter("Emailid",  uLModel.getEmail());
	        sPQuery.setParameter("RwaRegNo", uLModel.getRegNo());
	        sPQuery.setParameter("FName",    uLModel.getFirstName());
	        sPQuery.setParameter("LName",    uLModel.getLastName());
	        sPQuery.setParameter("Mobile",   uLModel.getMobile());
	        sPQuery.setParameter("Security", uLModel.getSecurity());
	        sPQuery.setParameter("UID",      uLModel.getCreatedBy());
	        sPQuery.setParameter("Password", uLModel.getLPassword());
	        
	    	   List<UserAddress> uAddress =  uLModel.getUAdd();
	    	   for( UserAddress uarow :uAddress ) {
		         sPQuery.setParameter("Address", uarow.getAddress());
		         sPQuery.setParameter("Sector", uarow.getSector());
		         sPQuery.setParameter("City",    uarow.getCity());
		         sPQuery.setParameter("State",   uarow.getState());
		         sPQuery.setParameter("Country", uarow.getCountry());
		         sPQuery.setParameter("PinCode", uarow.getPinCode());
	    	   }
	        sPQuery.execute();
	        spStatus = (Integer) sPQuery.getOutputParameterValue("SPStatus");
	        System.out.println("spStatus:" + spStatus);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return spStatus;
	}

}
