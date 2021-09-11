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
		        		builder.equal(root.get("status"), SMFixedValue.STATUS));

	        Query<FacultyMemberModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <FacultyMemberModel> rows =  (ArrayList<FacultyMemberModel>) query.getResultList();
	        int sNo=0;
	        for(FacultyMemberModel row: rows) {
    		  JsonObject rObj = new JsonObject();
	    	  rObj.put("SNo"         ,  Integer.toString(++ sNo)) ;
	    	  rObj.put("RegNo"       , row.getRegNo());
	    	  rObj.put("Code"        , row.getFacultyCode());
	    	  rObj.put("Faculty"     , row.getFaculty());
	    	  rObj.put("Designation" , row.getDesignation());
	    	  rObj.put("Name"        , row.getName());
	    	  rObj.put("MobileNo"   , row.getMobileNo());
	    	  rObj.put("Phone"       , row.getPhoneNo());
	    	  rObj.put("Qualification", row.getQualification());
	    	  rObj.put("DOJ"          , row.getdOJ().toString());
	    	  rObj.put("EmailID"      , row.getEmailID());
	    	  rObj.put("Expertise"    , row.getSkillArea());
	    	  rObj.put("fMIDNO"       , row.getfMIDNO());
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

	public static int facultyMemberUpdateInfo(FacultyMemberModel ufacultyMemberModel, String erMsg) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int facultyMemberRemoveInfo(FacultyMemberModel rfacultyMemberModel, String erMsg) {
		erMsg+=SMFixedValue.ACTION_STEP +SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING;
        int executeUpdate = 0;
    	Transaction transaction = null; 
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.HQL_FACULTY_MEMBER);
	        query.setParameter(SMFixedValue.PARM_NSTATUS, rfacultyMemberModel.getStatus());
	        query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);
	        query.setParameter(SMFixedValue.PARM_REGNO, rfacultyMemberModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_IDNO, rfacultyMemberModel.getfMIDNO());
		
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
        	sessionObj.beginTransaction().commit();
	        erMsg += Integer.toString(executeUpdate) +" "+SMFixedValue.EXEC_REMOVE_MSG + " :" + SMFixedValue.ACTION_OK ;
 	        sessionObj.close();
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
	}

		
	public static JsonArray facultyMemberInformation(FacultyMemberModel facultyMemberModel) {
        String erMsg = SMFixedValue.START + SMFixedValue.ACTION_GENERATE +SMFixedValue.FACULTY 
        		+ SMFixedValue.MEMBER + SMFixedValue.INFORMATION +": " ;
        
		JsonArray facultyInformation = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        
	        CriteriaQuery<FacultyMemberModel> creteriaQuery = builder.createQuery(FacultyMemberModel.class);
	        Root<FacultyMemberModel> root = creteriaQuery.from(FacultyMemberModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_FACULTYREGNO), facultyMemberModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYCODE), facultyMemberModel.getFacultyCode()),
	        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYSTATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<FacultyMemberModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <FacultyMemberModel> rows=(ArrayList<FacultyMemberModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        for ( FacultyMemberModel data:rows) {
	    	  if(data.getStatus().equals(SMFixedValue.STATUS)) {
		    	  JsonObject rObj = new JsonObject();
		    	  rObj.put("RegNo"       , data.getRegNo());
		    	  rObj.put("EmpCode"     , data.getFacultyCode());
		    	  rObj.put("Name"        , data.getName() + " "+ data.getlName());
		    	  rObj.put("Designation" , data.getDesignation());
		    	  facultyInformation.add(rObj);
		    	  break;
	    	  }
	       }
	       sessionObj.close();
	       erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
	    	+SMFixedValue.FACULTY +SMFixedValue.INFORMATION +"\n" +facultyInformation;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return facultyInformation;
	}

	public static JsonArray getfacultyMemberInfo(FacultyMemberModel xfacultyMemberModel) {
			String erMsg= SMFixedValue.USER + SMFixedValue.INFORMATION + SMFixedValue.GENERATING ;
		    JsonArray facultyMemberInfo = new JsonArray();
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<FacultyMemberModel> creteriaQuery = builder.createQuery(FacultyMemberModel.class);
		        Root<FacultyMemberModel> root = creteriaQuery.from(FacultyMemberModel.class);
		        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_FACULTYREGNO), xfacultyMemberModel.getRegNo()),
			        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYCODE), xfacultyMemberModel.getFacultyCode()),
			        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYSTATUS), SMFixedValue.STATUS));
			        erMsg += SMFixedValue.PARM_SET_MSG + "; ";

		        Query<FacultyMemberModel> query = sessionObj.createQuery(creteriaQuery);
		        ArrayList <FacultyMemberModel> rows =  (ArrayList<FacultyMemberModel>) query.getResultList();
		        int sNo=0;
		        for(FacultyMemberModel row: rows) {
	    		  JsonObject rObj = new JsonObject();
		    	  rObj.put("SNo"         ,  Integer.toString(++ sNo)) ;
		    	  rObj.put("RegNo"       , row.getRegNo());
		    	  rObj.put("Code"        , row.getFacultyCode());
		    	  rObj.put("Faculty"     , row.getFaculty());
		    	  rObj.put("Designation" , row.getDesignation());
		    	  rObj.put("Name"        , row.getName() );
		    	  rObj.put("LName"        , row.getlName() );
		    	  rObj.put("MobileNo"   , row.getMobileNo());
		    	  rObj.put("Phone"       , row.getPhoneNo());
		    	  rObj.put("Qualification", row.getQualification());
		    	  rObj.put("DOJ"          , row.getdOJ().toString());
		    	  rObj.put("EmailID"      , row.getEmailID());
		    	  rObj.put("Expertise"    , row.getSkillArea());
		    	  rObj.put("fMIDNO"       , row.getfMIDNO());
		    	  facultyMemberInfo.add(rObj);	
			    }
		        erMsg += "\n"+  SMFixedValue.FACULTY + SMFixedValue.MEMBER + ": "+facultyMemberInfo;
		        sessionObj.close();
			}catch(Exception e) {
				erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
		return facultyMemberInfo;
	}	
	public static List<String> getFMInformation(String SMRegNo, String emailId) {
        String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.FACULTY 
        		+ SMFixedValue.MEMBER + SMFixedValue.INFORMATION +": " ;
        List<String> sMFMInfo = new ArrayList<String>() ; 
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<FacultyMemberModel> creteriaQuery = builder.createQuery(FacultyMemberModel.class);
	        Root<FacultyMemberModel> root = creteriaQuery.from(FacultyMemberModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_FACULTYREGNO), SMRegNo),
	        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYEMAIL), emailId),
	        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYSTATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<FacultyMemberModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <FacultyMemberModel> rows=(ArrayList<FacultyMemberModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        for ( FacultyMemberModel data:rows) {
	    	  if(data.getStatus().equals(SMFixedValue.STATUS)) {
		    	  sMFMInfo.add(data.getFacultyCode());
		    	  String fMname = data.getName().concat(" ").concat(data.getlName());
		    	  sMFMInfo.add(fMname);
		    	  sMFMInfo.add(data.getDesignation());
		    	  break;
	    	  }
	       }
	       sessionObj.close();
	       erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows: " + rows.size()+SMFixedValue.FACULTY + " "+SMFixedValue.MEMBER + " " ;
	       for(String fMInfo:sMFMInfo)    
	    	   erMsg += fMInfo; 
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return sMFMInfo;
	}
	public static int getfacultyMemberPK(String RegNo, String fMCode) {
        String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.FACULTY 
        		+ SMFixedValue.MEMBER + SMFixedValue.ID +": " ;
        int fMiDNO = 0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        
	        CriteriaQuery<FacultyMemberModel> creteriaQuery = builder.createQuery(FacultyMemberModel.class);
	        Root<FacultyMemberModel> root = creteriaQuery.from(FacultyMemberModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_FACULTYREGNO), RegNo),
	        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYCODE), fMCode),
	        	builder.equal(root.get(SMFixedValue.MODEL_FACULTYSTATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<FacultyMemberModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <FacultyMemberModel> rows=(ArrayList<FacultyMemberModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        for ( FacultyMemberModel data:rows) {
		    	  fMiDNO = data.getfMIDNO();
		    	  break;
	       }
	       sessionObj.close();
	       erMsg += SMFixedValue.OUTPUT +SMFixedValue.FACULTY +SMFixedValue.MEMBER  + SMFixedValue.ID+":" +Integer.toString(fMiDNO);
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return fMiDNO;
	}
	

}
