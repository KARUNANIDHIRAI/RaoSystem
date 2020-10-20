package com.rao.System.MASItem;

import java.sql.SQLException;
import java.sql.Types;
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

import com.rao.System.ConfigSetting.ConfigSettingModel;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;
import com.raoSystem.daoConnection.HibernateDAO;

public class DAOItem {
	
	public static JsonArray ItemSearch(ItemModel ItModel)  {
		JsonArray workType= new JsonArray();
		String erMsg= "Step 3 DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ItemInfoSearch](?,?,?,?)}");
			ComVar.myStat.setString(1,  ItModel.getRwaRegNo());
			ComVar.myStat.setString(2,  ItModel.getICode());
			ComVar.myStat.setString(3,  ItModel.getIName());
			ComVar.myStat.registerOutParameter(4, Types.NVARCHAR);
			erMsg+=" 3.2  SP Param OK";
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute Successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
				System.out.println(erMsg + " " + "No Recod Found [db]");
		    	return workType	;
		    }	
			erMsg += " 3.4 : SP Data ArrayList";
			while (ComVar.prst.next()) {
				JsonObject ItemList= new JsonObject();
				ItemList.put("Code",ComVar.prst.getString("ItemCode"));
				ItemList.put("Name",ComVar.prst.getString("ItemName"));
				ItemList.put("MinLevel",ComVar.prst.getString("MinLevel"));
				ItemList.put("MaxLevel",ComVar.prst.getString("MaxLevel"));
				ItemList.put("ReOrderLevel",ComVar.prst.getString("ReorderLevel"));
				workType.add(ItemList);
			}
			System.out.println("Item ArrayList :" + workType);
			System.out.println("\n"+erMsg);
			
		}catch(SQLException e) {
			erMsg += "Step 3.5 : catch Sql Exception retriving [sp data]";
			System.out.println("\nerMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.5 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return workType;
	}

	public static JsonArray ViewItem(ItemModel itmModel, String erMsg) {
        erMsg += " 2.1: Item List. " ;
	     int ctr= 0;
	     JsonArray itmListArray = new JsonArray();
	       erMsg += " 2.2 JsonArrayList. " ;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<ItemModel> root = creteriaQuery.from(ItemModel.class);
	        erMsg += " 2.3: Root. " ;
	        
	        Path<Object> rwaNo = root.get("RwaRegNo");
	        Path<Object> ItemCode = root.get("ICode");
	        Path<Object> ItemName = root.get("IName");
	        Path<Object> MinLevel = root.get("MinLevel");
	        Path<Object> MaxLevel = root.get("Maxlevel");
	        Path<Object> ReorderLevel = root.get("ReOrderLevel");
	        System.out.println("RWA No.:"+itmModel.getRwaRegNo() );
	        creteriaQuery.multiselect(rwaNo, ItemCode,ItemName,MinLevel,MaxLevel, ReorderLevel);
	        creteriaQuery.where(builder.equal(root.get("RwaRegNo"), itmModel.getRwaRegNo()),
	        		            builder.equal(root.get("Status"), "A"));
	        erMsg += " 2.4: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;
	       
	       System.out.println("\n uLarray length: "+ itmListArray.size());
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RwaNo", row[0]);
	    	   rObj.put("ItemCode", row[1]);
	    	   rObj.put("ItemName", row[2]);
	    	   rObj.put("MinimumLevel", row[3]);
	    	   rObj.put("MaxLevel", row[4]);
	    	   rObj.put("ReorderLevel", row[5]);
	    	   itmListArray.add(rObj);
	       }
	       
	       System.out.println("KNArray :" +itmListArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return itmListArray;
	}

	public static int newItem(ItemModel itmModel, String erMsg) {
        erMsg += " 2.1: Began Tran OK. " ;
        Integer  spStatus=0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("NewItemInfo");

	        sPQuery.registerStoredProcedureParameter("RwaRegNo", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("ICode",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("IName",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("MinLevel",   Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("MaxLevel",      Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("ROrderLevel",      Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UID",      String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SPStatus", Integer.class, ParameterMode.OUT);
	        erMsg += " 2.2: Began Tran OK. " ;
	        
	        sPQuery.setParameter("RwaRegNo", itmModel.getRwaRegNo());
	        sPQuery.setParameter("ICode",    itmModel.getICode());
	        sPQuery.setParameter("IName",    itmModel.getIName());
	        sPQuery.setParameter("MinLevel", itmModel.getMinLevel());
	        sPQuery.setParameter("MaxLevel", itmModel.getMaxlevel());
	        sPQuery.setParameter("ROrderLevel", itmModel.getReOrderLevel());
	        sPQuery.setParameter("UID", itmModel.getCreatedBy());
	        erMsg += " 2.3: SET PARAMETER  OK. " ;
	        
	        sPQuery.execute();
	        erMsg += " 2.4: Execute OK. " ;
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

	public static JsonArray getItemList(String ItCode, String rwa, String erMsg) {
        erMsg += " 2.1: rConfig list. " ;
	     int ctr= 0;
	     JsonArray jsonArray = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<ItemModel> root = creteriaQuery.from(ItemModel.class);
	        
	        Path<Object> rwaNo = root.get("RwaRegNo");
	        Path<Object> ItemCode = root.get("ICode");
	        Path<Object> ItemName = root.get("IName");
	        Path<Object> MinLevel = root.get("MinLevel");
	        Path<Object> MaxLevel = root.get("Maxlevel");
	        Path<Object> ReorderLevel = root.get("ReOrderLevel");
	        creteriaQuery.multiselect(rwaNo, ItemCode,ItemName,MinLevel,MaxLevel,ReorderLevel);
	        creteriaQuery.where(builder.equal(root.get("RwaRegNo")   , rwa),
	        		            builder.equal(root.get("ICode"), ItCode),
	        		            builder.equal(root.get("Status")  , "A"));
	        erMsg += " 2.2: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.3: pkExecute Query OK.:" ;
	       
	       System.out.println("\n uLarray length: "+ jsonArray.size());
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RwaNo", row[0]);
	    	   rObj.put("ItemCode", row[1]);
	    	   rObj.put("ItemName", row[2]);
	    	   rObj.put("MinimumLevel", row[3]);
	    	   rObj.put("MaxLevel", row[4]);
	    	   rObj.put("ReorderLevel", row[5]);
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
