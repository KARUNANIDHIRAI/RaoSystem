package com.sm.System.StudentPersonalInfo;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.ItemBorrow.SMItemBorrowedModel;
import com.sm.System.SMInformation.SMFixedValue;

import net.sf.ehcache.CacheOperationOutcomes.GetAllOutcome;

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
		      rObj.put("FProfession" , (String) row[16]) ;
		      rObj.put("PEmailId"    , (String) row[17]) ;
		      rObj.put("PMobileNo"   , (String) row[18]) ;
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
	public static JsonArray StudentListForAttendance(StudentPersonalInfoModel siModel, String erMsg) {
        erMsg += " 2.0: rStudentListClassSectionWise() :Generating Student list class and Section wise " ;
	    JsonArray StudentList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			String hql_StudentCSList  = siModel.getRollNo()==""?SMFixedValue.HQL_STUDENTLIST_CS:SMFixedValue.HQL_STUDENTLIST_CSR;
			System.out.println("\n hql_StudentCSList: " +hql_StudentCSList);
			Query<Object[]> rsQuery = sessionObj.createQuery(hql_StudentCSList);
			rsQuery.setParameter("regNO", siModel.getRegNo());
			rsQuery.setParameter("studentClass", siModel.getPromotedInClass());
			rsQuery.setParameter("studentClassSection", siModel.getSection());
			rsQuery.setParameter("Fstatus","A");
			if(!siModel.getRollNo().isEmpty()) {
				rsQuery.setParameter("studentRollNo", siModel.getRollNo());
			}
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

	public static JsonArray getStudentPInfo(StudentPersonalInfoModel siModel) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.STUDENT + SMFixedValue.PERSONAL + SMFixedValue.INFORMATION+ ":";
		JsonArray studentPerInfo = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<StudentPersonalInfoModel> creteriaQuery = builder.createQuery(StudentPersonalInfoModel.class);
			Root<StudentPersonalInfoModel> root = creteriaQuery.from(StudentPersonalInfoModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), siModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_STUDENT_EMAIL), siModel.getEmailId()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<StudentPersonalInfoModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<StudentPersonalInfoModel> rows = (ArrayList<StudentPersonalInfoModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (StudentPersonalInfoModel row : rows) {
				JsonObject rObj = new JsonObject();
		          rObj.put("RegNo"       , row.getRegNo());
			      rObj.put("AdmNo"       , row.getAdmNo());
			      rObj.put("Course"      , row.getCourse());
			      rObj.put("Class"       , row.getPromotedInClass()) ;
			      rObj.put("RollNo"      , row.getRollNo()) ;
			      rObj.put("Section"     , row.getSection()) ;
			      rObj.put("SName"       , row.getfName()  + " "+row.getlName()) ;
			      rObj.put("Gender"      , row.getGender())  ;
			      rObj.put("MobileNo"    , row.getMobileNo()) ;
			      rObj.put("EmailId"     , row.getEmailId()) ;
			      rObj.put("FName"       , row.getFfName() + " "+row.getFlName()) ;
			      rObj.put("MName"       , row.getMfName() + " "+row.getMlName()) ;
			      rObj.put("FProfession" , row.getFprofession()) ;
			      rObj.put("PEmailId"    , row.getpEmailId()) ;
			      rObj.put("PMobileNo"   , row.getpMobileNo()) ;
			      studentPerInfo.add(rObj);
			} // EOF outer for loop
			sessionObj.close();
			erMsg += SMFixedValue.OUTPUT + " Total Rows:(" + rows.size() +") :" + studentPerInfo;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return studentPerInfo;
	}

	public static JsonArray getStudentInformationList(String RegNo, String sClass, String sSection) {
		String erMsg= SMFixedValue.GENERATING + SMFixedValue.STUDENT + SMFixedValue.INFORMATION + SMFixedValue.ACTION_LIST ;
	    JsonArray StudentList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Query<Object[]> rsQuery = sessionObj.createQuery(SMFixedValue.STUDENT_CLASS_SECTION_LIST);
			rsQuery.setParameter(SMFixedValue.PARM_REGNO, RegNo);
			rsQuery.setParameter(SMFixedValue.PARM_CLASS, sClass);
			rsQuery.setParameter(SMFixedValue.PARM_SECTION, sSection);
			rsQuery.setParameter(SMFixedValue.PARM_STATUS,SMFixedValue.STATUS);
			erMsg += SMFixedValue.PARM_SET_MSG + " ," ;
	       ArrayList <Object[]> results = (ArrayList <Object[]>)  rsQuery.list();
	       int sNO =0;
	       for(Object[] row: results) {
	          JsonObject rObj = new JsonObject(); 
              rObj.put("SNO"        , Integer.toString(++ sNO)) ;
		      rObj.put("RegNo"      , (String) row[0]) ;
		      rObj.put("AdmNo"      , (String) row[1]) ;
		      rObj.put("FName"      , (String) row[2]) ;
		      rObj.put("LName"      , (String) row[3]) ;
		      rObj.put("Name"       , (String) row[2] + " "+(String) row[3]) ;
		      rObj.put("RollNo"     , (String) row[4]) ;
		      rObj.put("Class"      , (String) row[5]) ;
		      rObj.put("Section"    , (String) row[6]) ;
		      rObj.put("SIDNO"      , (Integer.toString((Integer)row[7]))) ;
		      StudentList.add(rObj);	
	       }
	       erMsg += SMFixedValue.OUTPUT + ":(" +Integer.toString(results.size()) + ") " + StudentList;
	       sessionObj.close();
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return StudentList;
	}
}
