package com.raoSystem.FLTOWN;

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

import com.rao.System.AptInventory.AptInventoryModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOVehicleInfo {
	public static JsonArray VehicleList(HVehicleInfoModel vehModel, String listType,String erMsg) {
        erMsg += " 2.0: flatResVehicleList() " ;
	    int ctr= 0;
	    JsonArray aptInventory = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<HVehicleInfoModel> root = creteriaQuery.from(HVehicleInfoModel.class);
	        erMsg += " 2.3: Connection & Session Object Ok." ;
	        
	        Path<Object> rwaNo          = root.get("rwaRegNo");
	        Path<Object> aptNo          = root.get("aptNo");
	        Path<Object> flatNo         = root.get("flatNo");
	        Path<Object> vehicleType    = root.get("vehicleType");
	        Path<Object> manufacturer   = root.get("manufacturer");
	        Path<Object> vehicleName    = root.get("vehicleName");
	        Path<Object> VehicleNo      = root.get("VehicleNo");
	        Path<Object> vehicleColor   = root.get("vehicleColor");
	        Path<Object> iDNO           = root.get("iDNO");

	        creteriaQuery.multiselect(rwaNo, aptNo, flatNo, vehicleType, manufacturer, vehicleName,
	                  VehicleNo, vehicleColor , iDNO);

	        switch (listType) {
	        case "flatwise":
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), vehModel.getRwaRegNo()),
			            builder.equal(root.get("aptNo"), vehModel.getAptNo()),
					    builder.equal(root.get("flatNo"), vehModel.getFlatNo()));
	        	break;
	        case "aptwise":
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), vehModel.getRwaRegNo()),
			            builder.equal(root.get("aptNo"), vehModel.getAptNo()));
	        	break;
	        case "rwaWise" :	
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), vehModel.getRwaRegNo()));
	        	break;
	        case "getAPTAndFlatNo" :	
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), vehModel.getRwaRegNo()),
			            builder.equal(root.get("iDNO"), vehModel.getiDNO()));
	        	break;
	        }
	        erMsg += " 2.4: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;

	        for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO",          ++ctr);
	    	   rObj.put("RwaNo",     	row[0]);
	    	   rObj.put("AptartmentNo", row[1]);
	    	   rObj.put("FlatNo", 	    row[2]);
	    	   rObj.put("VehicleType",  row[3]);
	    	   rObj.put("VehicleNo",    row[4]);
	    	   rObj.put("VehicleName",  row[5]);
	    	   rObj.put("VehicleColor", row[6]);
	    	   rObj.put("Manufacturer", row[7]);
	    	   rObj.put("iDNO",         row[8]);
	    	   aptInventory.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("Falt Resident Vehicle List :" +aptInventory);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}
		return aptInventory;
	}

	public static String VehicleNew(HVehicleInfoModel vehModel, String erMsg) {
        erMsg += " 2.1: Start VehicleNew() " ;
        String  spStatus="";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("VehicleCreate");

	        sPQuery.registerStoredProcedureParameter("UID"         ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo"    ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("AptNo"       ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("FlatNo"      ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("VehicleType" ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Manufacturer",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("VehicleName" ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("VehicleNo"   ,  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("VehicleColor",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("erMsgSQL"    ,  String.class, ParameterMode.OUT);
	        erMsg += " Register Param OK. " ;
	        
	        sPQuery.setParameter("UID",          vehModel.getCreatedBy())    ;
	        sPQuery.setParameter("RwaRegNo",     vehModel.getRwaRegNo())     ;
	        sPQuery.setParameter("AptNo",        vehModel.getAptNo())        ;
	        sPQuery.setParameter("FlatNo",       vehModel.getFlatNo())       ; 
	        sPQuery.setParameter("VehicleType",  vehModel.getVehicleType())  ;
	        sPQuery.setParameter("Manufacturer", vehModel.getManufacturer()) ;
	        sPQuery.setParameter("VehicleName",  vehModel.getVehicleName())  ;
	        sPQuery.setParameter("VehicleNo",    vehModel.getVehicleNo())    ;
	        sPQuery.setParameter("VehicleColor", vehModel.getVehicleColor()) ;
	        erMsg += " 2.3: SET Param OK. " ;

	        sPQuery.execute();
	        erMsg += " 2.4: Execute OK. " ;
	        spStatus =  (String) sPQuery.getOutputParameterValue("erMsgSQL");
	        System.out.println("spStatus:" + spStatus);
	        sessionObj.close();
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return spStatus;
	}
	public static String vehInfoIdDel(HVehicleInfoModel vehModel, String erMsg) {
		
	       erMsg += " 2.1: vehInfoIddel()" ;
	        String  spStatus="";
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("VehicleDelete");

		        sPQuery.registerStoredProcedureParameter("iDNO",      Integer.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("RwaRegNo",  String.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("UserID",    String.class, ParameterMode.IN);
		        sPQuery.registerStoredProcedureParameter("erMsgSQL",  String.class, ParameterMode.OUT);

		        erMsg += " para list "+ vehModel.getRwaRegNo()+ ",CreatedBy " 
			    		   	+ vehModel.getCreatedBy() + ",IDNO "+vehModel.getiDNO();
			
		        sPQuery.setParameter("iDNO", vehModel.getiDNO());
		        sPQuery.setParameter("RwaRegNo", vehModel.getRwaRegNo());
		        sPQuery.setParameter("UserID", vehModel.getCreatedBy());

			    boolean sp =sPQuery.execute();
		        erMsg += " 2.4: Execute SP Ok. " ;
		        spStatus = (String) sPQuery.getOutputParameterValue("erMsgSQL");
		        System.out.println("spStatus:" + spStatus);
		        sessionObj.close();
			}catch(HibernateException hibernateEx) {
		    	erMsg += "HibernateException: \n"+ hibernateEx;
			}catch(Exception e) {
		    	  erMsg += "Catch Exception: \n"+ e;
			}finally {
		          System.out.println("\n"+erMsg );
			}
			return spStatus;
	}

	public static JsonArray VehicleTypeList(String erMsg) {
        erMsg += " 2.0: VehicleTypeList() " ;
	    JsonArray vehJArray = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<HVehicleTypeModel> root = creteriaQuery.from(HVehicleTypeModel.class);
	        erMsg += " 2.3: Conn & Session  Ok." ;
	        
	        Path<Object> vehicleCode          = root.get("vehicleCode");
	        Path<Object> vehicleType    = root.get("vehicleType");

	        creteriaQuery.multiselect(vehicleCode,  vehicleType);

	        creteriaQuery.where(builder.equal(root.get("status"), "A"));
	
		    erMsg += " 2.4: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;

	        for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("VehicleCode", row[0]);
	    	   rObj.put("VehicleType", row[1]);
	    	   vehJArray.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("Falt Resident Vehicle List :" +vehJArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}
		return vehJArray;
	}

}
