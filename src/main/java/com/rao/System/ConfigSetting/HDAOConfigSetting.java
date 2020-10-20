package com.rao.System.ConfigSetting;

import java.sql.SQLException;
import java.util.ArrayList;

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

import com.rao.System.UserLogin.UserLoginModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOConfigSetting {

	public static int newConfig(ConfigSettingModel cSModel,String erMsg) {
        erMsg += " 2.1: Began Tran OK. " ;
        Integer  spStatus=0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("RWAConfigSetting");

	        sPQuery.registerStoredProcedureParameter("RwaNo", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SValueType",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SValue",    Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("pfix",   String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UID",      String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SPStatus", Integer.class, ParameterMode.OUT);
	        
	        sPQuery.setParameter("RwaNo",      cSModel.getRwaNo());
	        sPQuery.setParameter("SValueType",    cSModel.getNameType());
	        sPQuery.setParameter("SValue",   cSModel.getStartNo());
	        sPQuery.setParameter("pfix", cSModel.getPrefixStartNo());
	        sPQuery.setParameter("UID",           cSModel.getCreatedBy());
	        
	        sPQuery.execute();
	        spStatus = (Integer) sPQuery.getOutputParameterValue("SPStatus");
	        System.out.println("spStatus:" + spStatus);
	        sessionObj.close();
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
			return spStatus;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
				return spStatus;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return spStatus;
	}
	public static JsonArray NewConfigSetting(ConfigSettingModel cSModel,String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		showConfValue(cSModel) ;
		JsonArray jsonArray = new JsonArray();
		erMsg+=" Step 3.1 Print array[] : ";
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(cSModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg ="";
		}catch(HibernateException hibernateEx) {
			erMsg +="...HibernateException Transaction .. \n" + hibernateEx;
			if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	    }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	    	  
 	   }finally {
 		   System.out.println("HDAO : " +erMsg);
 	   }
		return jsonArray;
	}
	private static void showConfValue(ConfigSettingModel cSModel) {
		System.out.println(cSModel.getNameType() + " , Start No." +cSModel.getStartNo()+ " ,Prefix Value :" + 
	                       cSModel.getPrefixStartNo());
		return;
	}
	public static JsonArray RConfigList(ConfigSettingModel cSModel, String erMsg) {
        erMsg += " 2.1: rConfig list. " ;
	     int ctr= 0;
	     JsonArray jsonArray = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<ConfigSettingModel> root = creteriaQuery.from(ConfigSettingModel.class);
	        
	        Path<Object> rwaNo = root.get("RWANO");
	        Path<Object> email = root.get("NameType");
	        Path<Object> FirstName = root.get("PrefixStartNo");
	        Path<Object> LastName = root.get("StartNo");
	        Path<Object> Mobile = root.get("LastNo");
	        System.out.println("RWA No.:"+cSModel.getRwaNo() );
	        creteriaQuery.multiselect(rwaNo, email,FirstName,LastName,Mobile);
	        creteriaQuery.where(builder.equal(root.get("RWANO"), cSModel.getRwaNo()),
	        		            builder.equal(root.get("Status"), "A"));
	        erMsg += " 2.2: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.3: Execute Query OK.:" ;
	       
	       System.out.println("\n uLarray length: "+ jsonArray.size());
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RwaNo", row[0]);
	    	   rObj.put("NameType", row[1]);
	    	   rObj.put("PrefixStartNo", row[2]);
	    	   rObj.put("StartNo", row[3]);
	    	   rObj.put("LastNo", row[4]);
	    	   jsonArray.add(rObj);
	       }
	       
	       System.out.println("KNArray :" +jsonArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return jsonArray;
	}
	public static JsonArray getRCIvItem(String name, String rwa, String erMsg) {
        erMsg += " 2.1: rConfig list. " ;
	     int ctr= 0;
	     JsonArray jsonArray = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<ConfigSettingModel> root = creteriaQuery.from(ConfigSettingModel.class);
	        
	        Path<Object> rwaNo = root.get("RWANO");
	        Path<Object> email = root.get("NameType");
	        Path<Object> FirstName = root.get("PrefixStartNo");
	        Path<Object> LastName = root.get("StartNo");
	        Path<Object> Mobile = root.get("LastNo");
	        creteriaQuery.multiselect(rwaNo, email,FirstName,LastName,Mobile);
	        creteriaQuery.where(builder.equal(root.get("RWANO")   , rwa),
	        		            builder.equal(root.get("NameType"), name),
	        		            builder.equal(root.get("Status")  , "A"));
	        erMsg += " 2.2: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.3: Execute Query OK.:" ;
	       
	       System.out.println("\n uLarray length: "+ jsonArray.size());
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RwaNo", row[0]);
	    	   rObj.put("NameType", row[1]);
	    	   rObj.put("PrefixStartNo", row[2]);
	    	   rObj.put("StartNo", row[3]);
	    	   rObj.put("LastNo", row[4]);
	    	   jsonArray.add(rObj);
	       }
	       System.out.println("KNArray :" +jsonArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return jsonArray;
	}
	
	
}
