package com.rao.System.AptInventory;

import java.util.ArrayList;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOAptInventory {

	public static JsonArray aptInventoryCateList(AptInventoryModel aptInvModel, String erMsg) {
        erMsg += " 2.1: Item List. " ;
	     int ctr= 0;
	     JsonArray aptInventory = new JsonArray();
	       erMsg += " 2.2 JsonArrayList. " ;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<AptInventoryModel> root = creteriaQuery.from(AptInventoryModel.class);
	        erMsg += " 2.3: knRoot. " ;
	        
	        Path<Object> rwaNo = root.get("RwaRegNo");
	        Path<Object> TowerNo = root.get("towerNo");
	        Path<Object> FlatCatg = root.get("flatCategory");
	        Path<Object> FSize = root.get("flatSize");
	        Path<Object> TFInCategory= root.get("tFlatInCategory");
	        Path<Object> FSNo = root.get("flatNoFrom");
	        Path<Object> FENo = root.get("flatNoTo");
	        creteriaQuery.multiselect(rwaNo, TowerNo, FlatCatg, TFInCategory, FSNo, FENo, FSize);
	        creteriaQuery.where(builder.equal(root.get("RwaRegNo"), aptInvModel.getRwaRegNo()),
	        		            builder.equal(root.get("towerNo"), aptInvModel.getTowerNo()),
	        				    builder.equal(root.get("flatCategory"), aptInvModel.getFlatCategory()),	        				
	        		            builder.equal(root.get("Status"), "A"));
	        erMsg += " 2.4: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RwaNo",     	row[0]);
	    	   rObj.put("TowerNo",   	row[1]);
	    	   rObj.put("FCategory", 	row[2]);
	    	   rObj.put("FSize",    	row[3]);
	    	   rObj.put("TFinCategory", row[4]);
	    	   rObj.put("FSNo",         row[5]);
	    	   rObj.put("FENO",         row[6]);
	    	   aptInventory.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("KNArray :" +aptInventory);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return aptInventory;
	}
	public static JsonArray aptInventoryList(AptInventoryModel aptInvModel, String erMsg) {
        erMsg += " 2.1: APT Inventory List. " ;
	     int ctr= 0;
	     JsonArray aptInventory = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<AptInventoryModel> root = creteriaQuery.from(AptInventoryModel.class);
	        erMsg += " 2.3: knRoot. " ;
	        
	        Path<Object> rwaNo       = root.get("rwaRegNo");
	        Path<Object> TowerNo     = root.get("towerNo");
	        Path<Object> FlatCatg    = root.get("flatCategory");
	        Path<Object> FSize       = root.get("flatSize");
	        Path<Object> TFInCategory= root.get("tFlatInCategory");
	        Path<Object> FSNo        = root.get("flatNoFrom");
	        Path<Object> FENo        = root.get("flatNoTo");
	        Path<Object> iDNO        = root.get("iDNO");
	        creteriaQuery.multiselect(rwaNo, TowerNo, FlatCatg, TFInCategory, FSNo, FENo, FSize, iDNO);
	        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), aptInvModel.getRwaRegNo()),
	        		            builder.equal(root.get("Status"), "A"));
	        erMsg += " 2.4: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO",          ++ctr);
	    	   rObj.put("RwaNo",     	row[0]);
	    	   rObj.put("TowerNo",   	row[1]);
	    	   rObj.put("FCategory", 	row[2]);
	    	   rObj.put("FSize",        row[3]);
	    	   rObj.put("TFinCategory", row[4]);
	    	   rObj.put("FSNo",         row[5]);
	    	   rObj.put("FENO",         row[6]);
	    	   rObj.put("iDNO",         row[7]);
	    	   aptInventory.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("KNArray :" +aptInventory);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return aptInventory;
	}

	public static int newAptInvtory(AptInventoryModel aptInvModel, String erMsg) {
        erMsg += " 2.1: Began Tran OK. " ;
        Integer  spStatus=0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("CreateAptInventory");

	        sPQuery.registerStoredProcedureParameter("RwaRegNo",        	   String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UserID",                   String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("TowerNo",    			   String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("FlatCategory",    	  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SizeOfFalt",            Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("FlatNoFrom",      	  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("FlatNoTo",      		  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("spStatus",              Integer.class, ParameterMode.OUT);
	        sPQuery.registerStoredProcedureParameter("spInnerStatus",         Integer.class, ParameterMode.OUT);
	        erMsg += " 2.2: Began Tran OK. " ;
	        
	        sPQuery.setParameter("RwaRegNo", aptInvModel.getRwaRegNo());
	        sPQuery.setParameter("UserID", aptInvModel.getCreatedBy());
	        sPQuery.setParameter("TowerNo",    aptInvModel.getTowerNo());
	        sPQuery.setParameter("FlatCategory",    aptInvModel.getFlatCategory()); 
	        sPQuery.setParameter("SizeOfFalt", aptInvModel.getFlatSize());
	        sPQuery.setParameter("FlatNoFrom", aptInvModel.getFlatNoFrom());
	        sPQuery.setParameter("FlatNoTo", aptInvModel.getFlatNoTo());
	        erMsg += " 2.3: SET PARAMETER  OK. " ;
	        
	        sPQuery.execute();
	        erMsg += " 2.4: Execute OK. " ;
	        spStatus = (Integer) sPQuery.getOutputParameterValue("spStatus");
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
	public static int aptInventorydel(AptInventoryModel aptInvModel, String erMsg) {
		
	       erMsg += " 2.1: aptInventorydel()" ;
	        Integer  spStatus=0;
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("AptInventoryDelete");

		        sPQuery.registerStoredProcedureParameter("iDNO",      Integer.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("RwaRegNo",  String.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("UserID",    String.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("spStatus",  Integer.class, ParameterMode.OUT);

		        erMsg += " 2.2: aptInventorydelId() "+ aptInvModel.getRwaRegNo()+ ",CreatedBy " 
			    		   	+ aptInvModel.getCreatedBy() + ",IDNO "+aptInvModel.getiDNO();
			
			  sPQuery.setParameter("iDNO", aptInvModel.getiDNO());
			  sPQuery.setParameter("RwaRegNo", aptInvModel.getRwaRegNo());
			  sPQuery.setParameter("UserID", aptInvModel.getCreatedBy());

			    erMsg += " 2.3: aptInventorydelId() " ;

			    sPQuery.execute();
		        erMsg += " 2.4: Execute SP Ok. " ;
		        spStatus = (Integer) sPQuery.getOutputParameterValue("spStatus");
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

}
