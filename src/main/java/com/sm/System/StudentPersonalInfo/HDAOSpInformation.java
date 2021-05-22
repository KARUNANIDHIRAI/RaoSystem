package com.sm.System.StudentPersonalInfo;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;

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
	public static JsonArray rStudentAdimmissionInfo(StudentPersonalInfoModel siModel, String erMsg) {
        erMsg += " 2.0: rStudentListClassSectionWise() :Generating Student list class and Section wise " ;
	    JsonArray StudentAdmInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			String hQLQeuryString = "SELECT regNo,	fName, lName, promotedInClass, rollNo, course, section " 
		                          + " FROM  StudentPersonalInfoModel"
		                          + " WHERE regNo=:regNo AND AdmNo=:admNo AND status=:Fstatus";
	        System.out.println("admin no : " + siModel.getAdmNo());
			Query<Object[]> rsQuery = sessionObj.createQuery(SMFixedValue.HQL_RSPINFO);
//			Query<Object[]> rsQuery = sessionObj.createQuery(hQLQeuryString);
			rsQuery.setParameter("regNo", siModel.getRegNo());
			rsQuery.setParameter("admNo", siModel.getAdmNo());
			rsQuery.setParameter("Fstatus","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <Object[]> rows = (ArrayList <Object[]>)  rsQuery.list();
	       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
	        erMsg += " Execute Query OK.:" ;
	       for(Object[] row: rows) {
	          JsonObject rObj = new JsonObject();
		      rObj.put("RegNo"      , (String) row[0]) ;
		      rObj.put("Name"       , (String) row[1] + " "+(String) row[2]) ;
		      rObj.put("Class"      , (String) row[3]) ;
		      rObj.put("RollNo"     , (String) row[4]) ;
		      rObj.put("Course"     ,(String) row[5]) ;
		      rObj.put("Section"    ,(String) row[6]) ;
		      
		      StudentAdmInfo.add(rObj);	
		      break;
	       }
			System.out.println("\n"+StudentAdmInfo );
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return StudentAdmInfo;
	}

	public static JsonArray rStudentPersonalInfo(StudentPersonalInfoModel siModel, String erMsg) {
        erMsg += " 2.0: rStudentPersonalInfo() :Student Personal Info " ;
	    JsonArray StudentAdmInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Query<Object[]> rsQuery = sessionObj.createQuery(SMFixedValue.HQL_RSPROFILEINFO);
			rsQuery.setParameter("studentRegNo", siModel.getRegNo());
			rsQuery.setParameter("studentEmailId", siModel.getEmailId());
			rsQuery.setParameter("Fstatus","A");
	        erMsg += " PARAM SET done ;" ;
	       ArrayList <Object[]> rows = (ArrayList <Object[]>)  rsQuery.list();
	        erMsg += " Execute Query OK.:" ;
	        for(Object[] row: rows) {
	          JsonObject rObj = new JsonObject();
	          
	          rObj.put("RegNo"       , (String) row[0]) ;
		      rObj.put("AdmNo"       , (String) row[1]) ;
		      rObj.put("Course"      , (String) row[2]) ;
		      rObj.put("Class"       , (String) row[3]) ;
		      rObj.put("RollNo"      , (String) row[4]) ;
		      rObj.put("Section"     , (String) row[5]) ;
		      rObj.put("SName"       , (String) row[7]  + " "+(String) row[8]) ;
		      rObj.put("Gender"      , (String) row[9])  ;
		      rObj.put("MobileNo"    , (String) row[10]) ;
		      rObj.put("EmailId"     , (String) row[11]) ;
		      rObj.put("FName"       , (String) row[12] + " "+(String) row[13]) ;
		      rObj.put("MName"       , (String) row[14] + " "+(String) row[15]) ;
		      rObj.put("FProfession"   , (String) row[16]) ;
		      rObj.put("PEmailId"    , (String) row[17]) ;
		      rObj.put("PMobileNo" , (String) row[18]) ;
		      StudentAdmInfo.add(rObj);	
		      break;
	       }
			System.out.println("\nStudent Personal Information : "+StudentAdmInfo );
	        erMsg += " Update JsonArray OK.:" ;
	        sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return StudentAdmInfo;
	}
	
}
