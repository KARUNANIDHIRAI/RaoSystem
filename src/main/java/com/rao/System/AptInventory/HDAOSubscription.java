package com.rao.System.AptInventory;

import java.util.ArrayList;
import java.util.Date;

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

import com.rao.System.ConfigSetting.HDAOConfigSetting;
import com.raoSystem.Utility.HDAOUtility;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOSubscription {

	public static int SubscriptionNew(RwaSubscriptionModel subscriptionModel, String erMsg) {
        int spStatus = 0;

		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("SubscriptionCreate");

	        sPQuery.registerStoredProcedureParameter("RwaNo",       String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SubType",     String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("EffDate",     Date.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Subscription",String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SubAmt",      Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("ExpType",     String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UID",         String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("sPStatus",    Integer.class, ParameterMode.OUT);
	        
	        sPQuery.setParameter("RwaNo",         subscriptionModel.getRwaRegNo());
	        sPQuery.setParameter("SubType",    	  subscriptionModel.getSubscriptionType());
	        sPQuery.setParameter("EffDate",       subscriptionModel.getEffectiveDate());
	        sPQuery.setParameter("Subscription",  subscriptionModel.getSubscription());
	        sPQuery.setParameter("SubAmt",        subscriptionModel.getSubscriptionAmt());
	        sPQuery.setParameter("ExpType",       subscriptionModel.getExpenseType());
	        sPQuery.setParameter("UID",           subscriptionModel.getCreatedBy());
	        
	        sPQuery.execute();
	        spStatus = (int) sPQuery.getOutputParameterValue("sPStatus"); 
	        System.out.println("spStatus:" + spStatus);
	        sessionObj.close();
			
			
		}catch(HibernateException Hbe){
			System.out.println("Hibernate Exception: "+ Hbe);
			
		}catch(Exception e) {
			System.out.println("Error in HDAO"+ e);
			
		}finally {
			System.out.println("Program Status : "+ erMsg);
			
		}
		
		return spStatus;
	}

	public static JsonArray subscriptionList(RwaSubscriptionModel subscriptionModel, String erMsg) {
		
		JsonArray jArray = new JsonArray();
		Integer ctr = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteieaQuery = builder.createQuery(Object[].class);
			Root<RwaSubscriptionModel> root = criteieaQuery.from(RwaSubscriptionModel.class);
			
			Path<Object[]> rwaNo = root.get("rwaRegNo");
			Path<Object[]> subType = root.get("subscriptionType");
			Path<Object[]> eDate = root.get("effectiveDate");
			Path<Object[]> subscription = root.get("subscription");
			Path<Object[]> subAmt = root.get("subscriptionAmt");
			Path<Object[]> expType = root.get("expenseType");
			Path<Object[]> iDNO = root.get("iDNO");
			
			criteieaQuery.multiselect(rwaNo,subType, eDate, subscription, subAmt, expType, iDNO);
			criteieaQuery.where(builder.equal(root.get("rwaRegNo"), subscriptionModel.getRwaRegNo()),
								builder.equal(root.get("Status"), "A"));
			
	        Query<Object[]> query = sessionObj.createQuery(criteieaQuery);
	        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;
	        for(Object[] row: rows) {
	        	JsonObject jObj = new JsonObject();
	        	jObj.put("SNO",          ++ctr);
	        	jObj.put("rwaNo",row[0] );
	        	jObj.put("subType",row[1] );
	        	jObj.put("efDate",row[2].toString() );
	        	jObj.put("subscription",row[3] );
	        	jObj.put("amount",row[4] );
	        	jObj.put("expType",row[5] );
	        	jObj.put("iDNO",row[6] );
	        	
	        	jArray.add(jObj);
	        }
	        System.out.println("jARRAY: "+jArray );
	        sessionObj.close();
	        erMsg += "2.6 Create subList OK:";
		}catch(HibernateException Hbe) {
			System.out.println("Hibernate Exception"+ Hbe);
		}catch(Exception e) {
			System.out.println("Error in subscriptionList"+ e);
		}finally {
			
		}
		return jArray;
	}

	public static Integer subscriptionDel(RwaSubscriptionModel subsModel, String erMsg) {
	       erMsg += " 2.1: aptInventorydel()" ;
	        Integer  spStatus=0;
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("SubscriptionDelete");

		        sPQuery.registerStoredProcedureParameter("iDNO",      Integer.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("RwaRegNo",  String.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("UserID",    String.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("spStatus",  Integer.class, ParameterMode.OUT);

		        erMsg += " 2.2: aptInventorydelId() "+ subsModel.getRwaRegNo()+ ",CreatedBy " 
			    		   	+ subsModel.getCreatedBy() + ",IDNO "+subsModel.getiDNO();
			
			   sPQuery.setParameter("iDNO", subsModel.getiDNO());
			   sPQuery.setParameter("RwaRegNo", subsModel.getRwaRegNo());
			   sPQuery.setParameter("UserID", subsModel.getCreatedBy());

			    erMsg += " 2.3: aptInventorydelId() " ;

			    sPQuery.execute();
		        spStatus = (Integer) sPQuery.getOutputParameterValue("spStatus");
		        erMsg += " 2.4: Execute SP Ok. " + spStatus.toString();
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
