package com.sm.System.Faculty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.TimeTable.TimeTableDetailModel;
import com.sm.System.TimeTable.TimeTableModel;


public class HDAOFaculty {
	
	public static int facultyNew(FacultyModel siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 2.0 Start HDAO - ";
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(siModel);
 		    sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=SMFixedValue.COMMIT + SMFixedValue.TRANSACTION;
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}	

	public static int facultyMemberNew(FacultyMemberModel siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 2.0 Start HDAO -creating new member ";
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			System.out.println("FACULTY MEMBER MODEL");
			sessionObj.save(siModel);
 		    sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=SMFixedValue.COMMIT + SMFixedValue.TRANSACTION;
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}	
	
	public static JsonArray facultyList(FacultyModel facultyModel, String erMsg) {
	       erMsg += " 2.0: getAllClassTimeTableData :Time Table Data Retrieveing. " ;
		    JsonArray facultyList = new JsonArray();
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<FacultyModel> creteriaQuery = builder.createQuery(FacultyModel.class);
		        Root<FacultyModel> root = creteriaQuery.from(FacultyModel.class);
			        creteriaQuery.where(builder.equal(root.get("regNo"), facultyModel.getRegNo()),
			        		       		builder.equal(root.get("status"), "A"));
			        Query<FacultyModel> query = sessionObj.createQuery(creteriaQuery);
			       ArrayList <FacultyModel> rows =  (ArrayList<FacultyModel>) query.getResultList();
		        int sNO =0;
		        for(FacultyModel row: rows) {
		        	JsonObject rObj = new JsonObject();
		        	rObj.put("SNO"        , Integer.toString(++ sNO)) ;
		        	rObj.put("RegNo"      , row.getRegNo());
			        rObj.put("Code"       ,row.getCode())      ;
				    rObj.put("Name"       ,row.getName())      ;
			        rObj.put("FIDNO"      , row.getfIDNO());
			        facultyList.add(rObj);	
			    }
		    	System.out.println("Faculty : "+facultyList);
		        erMsg += " Update JsonArray OK.:" ;
		        sessionObj.close();
			}catch(Exception e) {
		    	erMsg += "Catch Exception: \n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return facultyList;
		}	
	
	public static JsonArray facultyNameList(FacultyModel facultyModel, String erMsg) {
	       erMsg += " 2.0: get Faculty Name List :facultyNameList" ;
		    JsonArray facultyList = new JsonArray();
			try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<FacultyModel> creteriaQuery = builder.createQuery(FacultyModel.class);
		        Root<FacultyModel> root = creteriaQuery.from(FacultyModel.class);
			        creteriaQuery.where(builder.equal(root.get("regNo"), facultyModel.getRegNo()),
			        		       		builder.equal(root.get("status"), "A"));
			        Query<FacultyModel> query = sessionObj.createQuery(creteriaQuery);
			       ArrayList <FacultyModel> rows =  (ArrayList<FacultyModel>) query.getResultList();
		        for(FacultyModel row: rows) {
		        	JsonObject rObj = new JsonObject();
			        rObj.put("Code"       ,row.getCode())      ;
				    rObj.put("Name"       ,row.getName())      ;
			        facultyList.add(rObj);	
			    }
		    	System.out.println(SMFixedValue.FACULTY + ": "+facultyList);
		        erMsg += " Update JsonArray OK.:" ;
		        sessionObj.close();
			}catch(Exception e) {
		    	erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return facultyList;
		}	

	public static int facultyRemove(FacultyModel facultyModel, String erMsg) {
		erMsg+=SMFixedValue.ACTION_STEP +SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING;
		int executeUpdate = 0;
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.HQL_FACULTY_REMOVE);
	        query.setParameter(SMFixedValue.PARM_NSTATUS, "D");
	        query.setParameter(SMFixedValue.PARM_OSTATUS, "A");
	        query.setParameter(SMFixedValue.PARM_REGNO, facultyModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_IDNO, facultyModel.getfIDNO());
	    	erMsg += SMFixedValue.PARM_SET_MSG;
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
	        if (executeUpdate>0) {
	        	erMsg+=Integer.toString(executeUpdate) + SMFixedValue.EXEC_REMOVE_MSG;
	        	sessionObj.beginTransaction().commit();
	        }
	        erMsg += SMFixedValue.EXEC_REMOVE_MSG ;
	       sessionObj.close();
		}catch(Exception e) { 
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
	}

	public static JsonArray facultyMemberList(FacultyMemberModel xfacultyMemberModel, String erMsg) {
       erMsg += " 2.0: Faculty Member List :Generating. " ;
	    JsonArray facultyMemberList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<FacultyMemberModel> creteriaQuery = builder.createQuery(FacultyMemberModel.class);
	        Root<FacultyMemberModel> root = creteriaQuery.from(FacultyMemberModel.class);
	        creteriaQuery.where(builder.equal(root.get("regNo"), xfacultyMemberModel.getRegNo()),
		        		builder.equal(root.get("status"), "A"));

	        Query<FacultyMemberModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <FacultyMemberModel> rows =  (ArrayList<FacultyMemberModel>) query.getResultList();
	        String TeacherName ="";
	        int id=0;
	        int sNo=0;
	        for(FacultyMemberModel row: rows) {
    		  JsonObject rObj = new JsonObject();
	    	  rObj.put("SNo"         ,  Integer.toString(++ sNo)) ;
	    	  rObj.put("RegNo"       , row.getRegNo());
	    	  rObj.put("Code"        , row.getFacultyCode());
	    	  rObj.put("Faculty"     , row.getFaculty());
	    	  rObj.put("Designation" , row.getDesignation());
	    	  rObj.put("Name"        , row.getName());
	    	  rObj.put("Mobile No"   , row.getMobileNo());
	    	  rObj.put("Phone"       , row.getPhoneNo());
	    	  rObj.put("Qualification", row.getQualification());
	    	  rObj.put("DOJ"          , row.getdOJ());
	    	  rObj.put("EmailID"      , row.getEmailID());
	    	  rObj.put("Expertise"    , row.getSkillArea());
	    	  rObj.put("fMIDNO"    , row.getfMIDNO());
	    	  facultyMemberList.add(rObj);	
		    }
	        erMsg += "\n"+  SMFixedValue.FACULTY + SMFixedValue.MEMBER + ": "+facultyMemberList;
	        sessionObj.close();
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return facultyMemberList;
	}	
}
