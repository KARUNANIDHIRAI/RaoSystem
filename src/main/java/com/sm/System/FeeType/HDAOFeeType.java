package com.sm.System.FeeType;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.Utility.ValidRwaNo;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SubjectMaster.Subjects;

public class HDAOFeeType {
	public static int nFTInfo(FeeTypeModel siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 2.0 Start HDAO - ";
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(siModel);
	 		   System.out.println("SAVE SIMODEL");
	 		   sessionObj.getTransaction().commit();
	 		   System.out.println("COMMIT");
			sessionObj.close();
			erMsg +=" hibernate commit transaction HDAQ1";
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	  		return exeStatus;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}
	public static JsonArray rFTInfo(FeeTypeModel rwaModel, String erMsg) {
        erMsg += " 2.0: subjectRInfo() " ;
	    JsonArray subjectInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

			String hQLQeuryString = "FROM FeeTypeModel ft where ft.regNo=:regNo and ft.status=:status";
			Query<FeeTypeModel> rsQuery = sessionObj.createQuery(hQLQeuryString, FeeTypeModel.class);
			rsQuery.setParameter("regNo", rwaModel.getRegNo());
			rsQuery.setParameter("status","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <FeeTypeModel> rows =  (ArrayList<FeeTypeModel>) rsQuery.list();
	       int sNO =0;
	        erMsg += " Execute Query OK.:" ;
	       for(FeeTypeModel row: rows) {
	            JsonObject rObj = new JsonObject();
	              rObj.put("SNO"        , Integer.toString(++ sNO));
			      rObj.put("RegNo"      ,row.getRegNo())     ;
			      rObj.put("Code"       ,row.getCode())      ;
			      rObj.put("Name"       ,row.getName())      ;
			      subjectInfo.add(rObj);	
	       }
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return subjectInfo;
	}
	public static JsonArray remFTInfo(FeeTypeModel siModel, String erMsg) {
		erMsg+="Step 2.Start removing.";
	    JsonArray subjectInfo = new JsonArray();
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

	        String HQL = "Update FeeTypeModel set status =:nStatus  WHERE regNo=: RegNo AND code =:Code AND status=:oStatus";
	        Query query = sessionObj.createQuery(HQL );
	        query.setParameter("nStatus", "D");
	        query.setParameter("RegNo", siModel.getRegNo());
	        query.setParameter("Code", siModel.getCode());
	        query.setParameter("oStatus", "A");
	        erMsg += " Param setting done ;" ;
	        sessionObj.beginTransaction();
	        int executeUpdate= query.executeUpdate();
	        if (executeUpdate>0) {
	        	erMsg+=Integer.toString(executeUpdate) + " record update Successfully";
	        	sessionObj.beginTransaction().commit();
	        }
	        erMsg += " removal done.:" ;
	       sessionObj.close();
		}catch(Exception e) { 	erMsg += "Catch Exception: \n"+ e;
		}finally {System.out.println("\n"+erMsg );}			
		return subjectInfo;
	}

	public static String vFTInfo(FeeTypeModel siModel, String erMsg) {
        erMsg += " 2.0: subjectRInfo() " ;
        String FeeCodeStatus="";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        String HQL = "FROM FeeTypeModel  WHERE regNo=: RegNo AND code =:Code AND status=:oStatus";
			Query<FeeTypeModel> rsQuery = sessionObj.createQuery(HQL, FeeTypeModel.class);
			rsQuery.setParameter("RegNo", siModel.getRegNo());
			rsQuery.setParameter("Code", siModel.getCode());
			rsQuery.setParameter("oStatus", "A");
	        erMsg += " Param setting done ;" ;
	       ArrayList <FeeTypeModel> rows =  (ArrayList<FeeTypeModel>) rsQuery.list();
	        erMsg += " Execute Query OK.:" ;
	       for(FeeTypeModel row: rows) {
	    	   FeeCodeStatus="Code Already Exist.";
	       }
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return FeeCodeStatus;
	}
	
	public static JsonArray vFTList(FeeTypeModel siModel, String erMsg) {
        erMsg += " 2.0: vFTList() " ;
	    JsonArray subjectInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

			String hQLQeuryString = "FROM FeeTypeModel ft where ft.regNo=:regNo and ft.status=:status";
			Query<FeeTypeModel> rsQuery = sessionObj.createQuery(hQLQeuryString, FeeTypeModel.class);
			rsQuery.setParameter("regNo", siModel.getRegNo());
			rsQuery.setParameter("status","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <FeeTypeModel> rows =  (ArrayList<FeeTypeModel>) rsQuery.list();
	        erMsg += " Execute Query OK.:" ;
	       for(FeeTypeModel row: rows) {
	            JsonObject rObj = new JsonObject();
			      rObj.put("Code"       ,row.getCode())      ;
			      rObj.put("Name"       ,row.getName())      ;
			      subjectInfo.add(rObj);	
	       }
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return subjectInfo;
	}


}
