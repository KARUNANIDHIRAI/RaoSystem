package com.sm.System.StudentPersonalInfo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.FeeDefine.FeeDefineModel;

public class HDAOSpInformation {

	public static int SpInformation(StudentPersonalInfoModel siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(siModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" Save SpInformation.";
			rwaStatus=1;
	   }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return rwaStatus;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return rwaStatus;
	}

	public static JsonArray rStudentListClassSectionWise(StudentPersonalInfoModel siModel, String erMsg) {
        erMsg += " 2.0: rStudentListClassSectionWise() :Generating Student list class and Section wise " ;
	    JsonArray StudentList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			String hQLQeuryString = "SELECT regNo,	fName, lName, promotedInClass, rollNo, sIdNo " 
		                          + " FROM  StudentPersonalInfoModel"
		                          + " where regNo=:regNo and status=:Fstatus";
			Query<Object[]> rsQuery = sessionObj.createQuery(hQLQeuryString);
			rsQuery.setParameter("regNo", siModel.getRegNo());
			rsQuery.setParameter("Fstatus","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <Object[]> rows = (ArrayList <Object[]>)  rsQuery.list();
	       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
	       int sNO =0;
	        erMsg += " Execute Query OK.:" ;
	       for(Object[] row: rows) {
	          JsonObject rObj = new JsonObject();
              rObj.put("SNO"        , Integer.toString(++ sNO)) ;
		      rObj.put("RegNo"      , (String) row[0]) ;
		      rObj.put("FName"      , (String) row[1]) ;
		      rObj.put("LName"      , (String) row[2]) ;
		      rObj.put("Name"       , (String) row[1] + " "+(String) row[2]) ;
		      rObj.put("Class"      , (String) row[3]) ;
		      rObj.put("RollNo"     , (String) row[4]) ;
		      rObj.put("SIDNO"      , (Integer) row[5]) ;
		      
		      StudentList.add(rObj);	
	       }
			System.out.println("\n"+StudentList );
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return StudentList;
	}


}
