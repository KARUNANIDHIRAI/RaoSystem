package com.sm.System.SubjectMaster;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAOSubjects {

	public static int nSchInfo(Subjects siModel, String erMsg) {
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
	public static JsonArray rSchInfo(Subjects rwaModel, String erMsg) {
        erMsg += " 2.0: subjectRInfo() " ;
	    JsonArray subjectInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

			String hQLQeuryString = "FROM Subjects sub where sub.regNo=:regNo and sub.status=:status";
			Query<Subjects> rsQuery = sessionObj.createQuery(hQLQeuryString, Subjects.class);
			rsQuery.setParameter("regNo", rwaModel.getRegNo());
			rsQuery.setParameter("status","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <Subjects> rows =  (ArrayList<Subjects>) rsQuery.list();
	       int sNO =0;
	        erMsg += " Execute Query OK.:" ;
	       for(Subjects row: rows) {
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
	public static JsonArray remSchInfo(Subjects siModel, String erMsg) {
		erMsg+="Step 2.Start removing.";
	    JsonArray subjectInfo = new JsonArray();
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

	        String HQL = "Update Subjects set status =:nStatus  WHERE regNo=: RegNo AND code =:Code AND status=:oStatus";
	        Query query = sessionObj.createQuery(HQL );
	        query.setParameter("nStatus", "D");
	        query.setParameter("RegNo", siModel.getRegNo());
	        query.setParameter("Code", siModel.getCode());
	        sessionObj.beginTransaction();
	        query.setParameter("oStatus", "A");
	        int executeUpdate= query.executeUpdate();
	        if (executeUpdate>0) {
	        	erMsg+=Integer.toString(executeUpdate) + " record update Successfully";
	        	sessionObj.beginTransaction().commit();
	        }
	    	
	    	
//	    	String hQLQeuryString = "Update Subjects s set s.status=:status where s.regNo=:regNo and s.code=:code and s.status=:ostatus";
//			Query<Subjects> rsQuery = sessionObj.createQuery(hQLQeuryString, Subjects.class);
//			rsQuery.setParameter("regNo", siModel.getRegNo());
//			rsQuery.setParameter("code", siModel.getCode());
//			rsQuery.setParameter("ostatus","A");
//			rsQuery.setParameter("status","D");
	        erMsg += " Param setting done ;" ;
//	        rsQuery.list();
	        erMsg += " removal done.:" ;
	       sessionObj.close();
		}catch(Exception e) { 	erMsg += "Catch Exception: \n"+ e;
		}finally {System.out.println("\n"+erMsg );}			
		return subjectInfo;
	}	
	

}
