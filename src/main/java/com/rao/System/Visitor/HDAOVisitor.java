package com.rao.System.Visitor;

import java.util.ArrayList;

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

import com.rao.System.AptInventory.AptInventoryModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOVisitor {

	public static int visitorNew(VisitorGPModel vGPModel, String erMsg) {
		int spStatus= 0;
		Transaction transaction = null;
		erMsg+=" Step 3.0 visitorNew- Start HDAO - ";
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(vGPModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" hibernate commit transaction HDAQ1";
			spStatus=1;
		}catch(HibernateException hibernateEx) {
			erMsg +="...HibernateException Transaction .. \n" + hibernateEx;
			
			if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
    		return spStatus;
	   }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return spStatus;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return spStatus;
	}

	public static JsonArray vVInfoList(VisitorGPModel vGPModel, String erMsg) {
		JsonArray vVList = new JsonArray();
		erMsg += "Start 3.1 vVInfoList(): ";
		Integer ctr = 0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<VisitorGPModel> root = creteriaQuery.from(VisitorGPModel.class);
	        erMsg += " 3.1: knRoot. " ;
	        System.out.println("knri :" +vGPModel.getVisitDate().toString());
	        Path<Object> IDNO        = root.get("iDNO")      ;
	        Path<Object> rwaRegNo    = root.get("rwaRegNo")  ;
	        Path<Object> vFName      = root.get("vFName")    ;
	        Path<Object> vLname      = root.get("vLname")    ;
	        Path<Object> vMobileNo   = root.get("vMobileNo") ;
	        Path<Object> vInTime     = root.get("vInTime")   ;
	        Path<Object> vOutTime    = root.get("vOutTime")  ;
	        Path<Object> visitDate   = root.get("visitDate") ;
	        Path<Object> idProof     = root.get("idProof")   ;
	        Path<Object> idDocName   = root.get("idDocName") ;
	        Path<Object> vehicleNo   = root.get("vehicleNo") ;
	        Path<Object> vehicleName = root.get("vehicleName");
	        Path<Object> resFName    = root.get("resFName")  ;
	        Path<Object> resLName    = root.get("resLName")  ;
	        Path<Object> resAptNo    = root.get("resAptNo")  ;
	        Path<Object> resFltNo    = root.get("resFltNo")  ;
	        Path<Object> vPurpose    = root.get("vPurpose")  ;
	        creteriaQuery.multiselect(IDNO,rwaRegNo, vFName, vLname, vMobileNo, vInTime, vOutTime, visitDate, idProof,
	        						  idDocName, vehicleNo, vehicleName, resFName, resLName, resAptNo, resFltNo, vPurpose);
	        
	        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), vGPModel.getRwaRegNo()),
	        		            builder.equal(root.get("vMobileNo"), vGPModel.getvMobileNo()),
	        				    builder.equal(root.get("resAptNo"), vGPModel.getResAptNo()),	        				
	        		            builder.equal(root.get("visitDate"), vGPModel.getVisitDate()));
	        erMsg += " 3.2: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("iDNO",         row[0]);
	    	   rObj.put("RwaNo",        row[1]);
	    	   rObj.put("vFName",   	row[2] + " "+ row[3]);
	    	   rObj.put("vLname", 	    row[3]);
	    	   rObj.put("vMobileNo",    row[4]);
	    	   rObj.put("vInTime",      row[5].toString());
	    	   rObj.put("vOutTime",     row[6].toString());
	    	   rObj.put("visitDate",    row[7].toString());
	    	   rObj.put("idProof",     	row[8] + " " + row[9]);
	    	   rObj.put("idDocName",   	row[9]);
	    	   rObj.put("vehicleNo", 	row[10]);
	    	   rObj.put("vehicleName",  row[11]);
	    	   rObj.put("resFName",     row[12] + " " +row[13]);
	    	   rObj.put("resLName",     row[13]);
	    	   rObj.put("resAptNo",     row[14]);
	    	   rObj.put("resFltNo",     row[15]);
	    	   rObj.put("vPurpose",     row[16]);
	    	   vVList.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("KNArray :" +vVList);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return vVList;
	}
}
