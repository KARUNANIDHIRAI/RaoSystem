package com.raoSystem.Dweller;

import java.text.SimpleDateFormat;
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

import com.raoSystem.FLTOWN.HVehicleInfoModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOTenantInfo {

	public static String createTnt(TenantInfoModel tntInfo, String erMsg) {
		String erMsgSql ="3";
		erMsg += " Step 3.1 Start createTnt() ok : ";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
		StoredProcedureQuery spQuery =  sessionObj.createStoredProcedureQuery("TenantCreate");
		spQuery.registerStoredProcedureParameter("UID",      String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("RwaRegNo", String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("AptNo",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FlatNo",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FName",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("LName",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("Gender",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("MobileNo", String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("PhoneNo",  String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("EmailID",  String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FFName",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FLName",   String.class , ParameterMode.IN);

		spQuery.registerStoredProcedureParameter("ShiftedOutOn",Date.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("ShiftedOn",   Date.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("TenantStatus",String.class , ParameterMode.IN);

		spQuery.registerStoredProcedureParameter("Status",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("erMsgSQL", String.class , ParameterMode.OUT);

		erMsg += " Parm Reg OK : ";

		spQuery.setParameter("UID",     tntInfo.getCreatedBy());
		spQuery.setParameter("RwaRegNo",tntInfo.getRwaRegNo());
		spQuery.setParameter("AptNo",   tntInfo.getAptNo());
		spQuery.setParameter("FlatNo",  tntInfo.getFlatNo());
		spQuery.setParameter("FName",   tntInfo.getfName());
		spQuery.setParameter("LName",   tntInfo.getlName());
		spQuery.setParameter("Gender",  tntInfo.getGender());
		spQuery.setParameter("MobileNo",tntInfo.getMobileNo());
		spQuery.setParameter("PhoneNo", tntInfo.getPhoneNo());
		spQuery.setParameter("EmailID", tntInfo.getEmailId());
		spQuery.setParameter("FFName",  tntInfo.getfFName());
		spQuery.setParameter("FLName",  tntInfo.getfLName());
		spQuery.setParameter("ShiftedOutOn",  tntInfo.getShiftedOutOn());
		
		System.out.println("prashant : "+ tntInfo.getShiftedOutOn());
		
		spQuery.setParameter("ShiftedOn",  tntInfo.getShiftedOn());
		spQuery.setParameter("TenantStatus",  tntInfo.getTenantStatus());
		spQuery.setParameter("Status",  tntInfo.getStatus());

		erMsg += " Parm Set OK : ";
		spQuery.execute();
		erMsg += "Execute OK ";
		erMsgSql = (String)spQuery.getOutputParameterValue("erMsgSQL");
		sessionObj.close();	
		erMsg += "\n erMsgSql : "+ erMsgSql;
		}catch(HibernateException HBE) {
			erMsgSql="3";
			System.out.println(" createTnt Hibernate Exception :"+ HBE);
			
		}catch(Exception e) {
			erMsgSql="3";
 			System.out.println(" createTnt Technical Error :"+ e);
		}
		finally {
			System.out.println("erMsg: " + erMsg+ "sp" );
		}
		return erMsgSql;
	}

	public static JsonArray tntInfoList(TenantInfoModel tntInfo, String listType,String erMsg) {
        erMsg += " 2.0: flatResVehicleList() " ;
	    int ctr= 0;
	    JsonArray tntInfoArray = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<TenantInfoModel> root = creteriaQuery.from(TenantInfoModel.class);
	        erMsg += " 2.3: Connection & Session Object Ok." ;
	        
	        Path<Object> rwaNo          = root.get("rwaRegNo");
	        Path<Object> aptNo          = root.get("aptNo");
	        Path<Object> flatNo         = root.get("flatNo");
	        Path<Object> fName          = root.get("fName");
	        Path<Object> lName          = root.get("lName");
	        Path<Object> mobileNo       = root.get("mobileNo");
	        Path<Object> phoneNo        = root.get("phoneNo");
	        Path<Object> emailId        = root.get("emailId");
	        Path<Object> ShiftedOn      = root.get("ShiftedOn");
	        Path<Object> shiftedOutOn   = root.get("shiftedOutOn");
	        Path<Object> iDNO           = root.get("idNO");

	        
	        creteriaQuery.multiselect(rwaNo, aptNo, flatNo, fName, lName, mobileNo,
	        		phoneNo, emailId , ShiftedOn,shiftedOutOn, iDNO);
	        
	        switch (listType) {
	        case "flatwise":
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), tntInfo.getRwaRegNo()),
			            builder.equal(root.get("aptNo"), tntInfo.getAptNo()),
					    builder.equal(root.get("flatNo"), tntInfo.getFlatNo()));
	        	break;
	        case "aptwise":
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), tntInfo.getRwaRegNo()),
			            builder.equal(root.get("aptNo"), tntInfo.getAptNo()));
	        	break;
	        case "rwaWise" :	
		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), tntInfo.getRwaRegNo()));
	        	break;
	        case "TNTInfoIdWise" :	
				  creteriaQuery.where(builder.equal(root.get("rwaRegNo"),
				  tntInfo.getRwaRegNo()), builder.equal(root.get("idNO"), tntInfo.getIdNO()));
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
	    	   rObj.put("Name",         row[3] + " " + row[4]); // concatenate fname and lname
	    	   rObj.put("MobileNo",     row[5]);
	    	   rObj.put("Phone",        row[6]);
	    	   rObj.put("EmailID",      row[7]);
	    	   rObj.put("ShiftOn",      row[8].toString());
	    	   rObj.put("ShiftOutOn",   row[9]==null?"":row[9].toString());
	    	   rObj.put("iDNO",         row[10]);
	    	   tntInfoArray.add(rObj);
	       }
	        erMsg += " 2.6: Prashant.:" ;
	       sessionObj.close();
	       System.out.println("Tenant List :" +tntInfoArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}
		return tntInfoArray;
	}
	public static JsonArray tntInfoEdit(TenantInfoModel tntInfo, String listType,String erMsg) {
        erMsg += " 2.0: tntInfoEdit() " ;
	    JsonArray tntInfoArray = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<TenantInfoModel> root = creteriaQuery.from(TenantInfoModel.class);
	        erMsg += " 2.3: Connection & Session Object Ok." ;
	        
	        Path<Object> rwaNo          = root.get("rwaRegNo");
	        Path<Object> aptNo          = root.get("aptNo");
	        Path<Object> flatNo         = root.get("flatNo");
	        Path<Object> fName          = root.get("fName");
	        Path<Object> lName          = root.get("lName");
	        Path<Object> gender         = root.get("gender");
	        Path<Object> fFName         = root.get("fFName");
	        Path<Object> fLName         = root.get("fLName");
	        Path<Object> mobileNo       = root.get("mobileNo");
	        Path<Object> phoneNo        = root.get("phoneNo");
	        Path<Object> emailId        = root.get("emailId");
	        Path<Object> ShiftedOn      = root.get("ShiftedOn");
	        Path<Object> shiftedOutOn   = root.get("shiftedOutOn");
	        Path<Object> TNTStatus      = root.get("tenantStatus");
	        
	        creteriaQuery.multiselect(rwaNo, aptNo, flatNo, fName, lName, gender, fFName, fLName, mobileNo,
	        		phoneNo, emailId , ShiftedOn,shiftedOutOn, TNTStatus );
	        
			creteriaQuery.where(builder.equal(root.get("rwaRegNo"),  tntInfo.getRwaRegNo()), 
						              builder.equal(root.get("idNO"), tntInfo.getIdNO()));
	        erMsg += " 2.4: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.5: Execute Query OK.:" ;

	        for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("RwaNo",     	row[0])  ;
	    	   rObj.put("AptartmentNo", row[1])  ;
	    	   rObj.put("FlatNo", 	    row[2])  ;
	    	   rObj.put("FName",        row[3])  ;
	    	   rObj.put("LName",        row[4])  ; 
	    	   rObj.put("Gender",       row[5])  ;
	    	   rObj.put("FFName",       row[6])  ; 
	    	   rObj.put("FFLName",      row[7])  ; 
	    	   rObj.put("MobileNo",     row[8])  ;
	    	   rObj.put("Phone",        row[9])  ;
	    	   rObj.put("EmailID",      row[10]) ;
	    	   rObj.put("ShiftOn",      row[11].toString());
	    	   rObj.put("ShiftOutOn",   row[12].toString());
	    	   rObj.put("TNTStatus",    row[13]) ;
	    	   tntInfoArray.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("Tenant List :" +tntInfoArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}
		return tntInfoArray;
	}

	public static String UpdateTNTInfo(TenantInfoModel tntInfo, String erMsg) {
		String erMsgSql ="3";
		erMsg += " Step 3.1 Start createTnt() ok : ";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
		StoredProcedureQuery spQuery =  sessionObj.createStoredProcedureQuery("TenantUpdate");
		spQuery.registerStoredProcedureParameter("UID",      String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("RwaRegNo", String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("AptNo",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FlatNo",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FName",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("LName",    String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("Gender",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("MobileNo", String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("PhoneNo",  String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("EmailID",  String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FFName",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("FLName",   String.class , ParameterMode.IN);

		spQuery.registerStoredProcedureParameter("ShiftedOutOn",Date.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("ShiftedOn",   Date.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("TenantStatus",String.class, ParameterMode.IN);

		spQuery.registerStoredProcedureParameter("Status",   String.class , ParameterMode.IN);
		spQuery.registerStoredProcedureParameter("erMsgSQL", String.class , ParameterMode.OUT);

		erMsg += " Parm Reg OK : ";

		spQuery.setParameter("UID",     tntInfo.getCreatedBy());
		spQuery.setParameter("RwaRegNo",tntInfo.getRwaRegNo());
		spQuery.setParameter("AptNo",   tntInfo.getAptNo());
		spQuery.setParameter("FlatNo",  tntInfo.getFlatNo());
		spQuery.setParameter("FName",   tntInfo.getfName());
		spQuery.setParameter("LName",   tntInfo.getlName());
		spQuery.setParameter("Gender",  tntInfo.getGender());
		spQuery.setParameter("MobileNo",tntInfo.getMobileNo());
		spQuery.setParameter("PhoneNo", tntInfo.getPhoneNo());
		spQuery.setParameter("EmailID", tntInfo.getEmailId());
		spQuery.setParameter("FFName",  tntInfo.getfFName());
		spQuery.setParameter("FLName",  tntInfo.getfLName());
		spQuery.setParameter("ShiftedOutOn",  tntInfo.getShiftedOutOn());
		spQuery.setParameter("ShiftedOn",  tntInfo.getShiftedOn());
		spQuery.setParameter("TenantStatus",  tntInfo.getTenantStatus());
		spQuery.setParameter("Status",  tntInfo.getStatus());

		erMsg += " Parm Set OK : ";
		spQuery.execute();
		erMsg += "Execute OK ";
		erMsgSql = (String)spQuery.getOutputParameterValue("erMsgSQL");
		sessionObj.close();	
		erMsg += "\n erMsgSql : "+ erMsgSql;
		}catch(HibernateException HBE) {
			erMsgSql="3";
			System.out.println(" createTnt Hibernate Exception :"+ HBE);
			
		}catch(Exception e) {
			erMsgSql="3";
 			System.out.println(" createTnt Technical Error :"+ e);
		}
		finally {
			System.out.println("erMsg: " + erMsg+ "sp" );
		}
		return erMsgSql;
	}

	public static String TNTInfoDElId(TenantInfoModel tntInfoDelID, String erMsg) {
       erMsg += " 2.1: TNTInfoIddel()" ;
        String  spStatus="";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("TenantDelete");

	        sPQuery.registerStoredProcedureParameter("iDNO",      Integer.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UserID",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("erMsgSQL",  String.class, ParameterMode.OUT);

	        erMsg += " para list "+ tntInfoDelID.getRwaRegNo()+ ",CreatedBy " 
		    		   	+ tntInfoDelID.getCreatedBy() + ",IDNO "+tntInfoDelID.getIdNO();
		
	        sPQuery.setParameter("iDNO", tntInfoDelID.getIdNO());
	        sPQuery.setParameter("RwaRegNo", tntInfoDelID.getRwaRegNo());
	        sPQuery.setParameter("UserID", tntInfoDelID.getCreatedBy());

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

}
