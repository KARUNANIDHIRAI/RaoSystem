package com.sm.System.URBAccess;

import java.util.ArrayList;
import java.util.Date;
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

public class HDAOURBAccess {
	private static int errStatus=0;
	public static int sMUserRoles(UserRolesModel userRolesModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.INFORMATION; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int uroleID= verifyUserRoleExist(userRolesModel);
			if (errStatus==1) {	return 3;} // return if error in verifyUserRoleExist(userRolesModel)
			if(uroleID == 0) {
				sessionObj.save(userRolesModel); // Insert data first time in Parent And Child Table
			}else { // Insert data into child table only 
				UserRolesDetailsSubModel URDSubModel = new UserRolesDetailsSubModel();
				List<UserRolesDetailsModel> URDModel = new ArrayList<UserRolesDetailsModel>();
				URDModel =  userRolesModel.getURDetailModel();
		        for(UserRolesDetailsModel row:URDModel) {
		        	URDSubModel.setRegNo(userRolesModel.getRegNo());
		        	URDSubModel.setfName(row.getfName());
		        	URDSubModel.setlName(row.getlName());
		        	URDSubModel.setEmailID(row.getEmailID());
		        	URDSubModel.setMobileNo(row.getMobileNo());
		        	URDSubModel.setuLPWD(row.getuLPWD());
		        	URDSubModel.setOtp(row.getOtp());
		        	URDSubModel.setUserCategory(row.getUserCategory());
		        	URDSubModel.setUserCode(row.getUserCode());
		        	URDSubModel.setStatus(row.getStatus());
		        	URDSubModel.setCreatedBy(row.getCreatedBy());
		        	URDSubModel.setCreatedOn(row.getCreatedOn());
		        	URDSubModel.setUpdatedBy(row.getUpdatedBy());
		        	URDSubModel.setUpdatedOn(row.getUpdatedOn());
		        	URDSubModel.setUserRoleIdFK(uroleID);
					System.out.println("Input values user roles Details:" + URDSubModel);		        	
		        }
				sessionObj.save(URDSubModel);
			}
 		    sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=SMFixedValue.EXEC_CREATE_MSG ;
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()){
				transaction.rollback();
			}
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	
	}

	public static int sMUserLoginCreate(UserRolesModel userRolesModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.INFORMATION; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int uroleID= verifyUserRoleExist(userRolesModel);
			if (errStatus==1) {	return 3;} // return if error in verifyUserRoleExist(userRolesModel)
			if(uroleID == 0) {
				sessionObj.save(userRolesModel); // Insert data first time in Parent And Child Table
			}else { // Insert data into child table only 
				UserRolesDetailsSubModel URDSubModel = new UserRolesDetailsSubModel();
				List<UserRolesDetailsModel> URDModel = new ArrayList<UserRolesDetailsModel>();
				URDModel =  userRolesModel.getURDetailModel();
		        for(UserRolesDetailsModel row:URDModel) {
		        	URDSubModel.setRegNo(userRolesModel.getRegNo());
		        	URDSubModel.setfName(row.getfName());
		        	URDSubModel.setlName(row.getlName());
		        	URDSubModel.setEmailID(row.getEmailID());
		        	URDSubModel.setMobileNo(row.getMobileNo());
		        	URDSubModel.setuLPWD(row.getuLPWD());
		        	URDSubModel.setOtp(row.getOtp());
		        	URDSubModel.setUserCategory(row.getUserCategory());
		        	URDSubModel.setUserCode(row.getUserCode());
		        	URDSubModel.setStatus(row.getStatus());
		        	URDSubModel.setCreatedBy(row.getCreatedBy());
		        	URDSubModel.setCreatedOn(row.getCreatedOn());
		        	URDSubModel.setUpdatedBy(row.getUpdatedBy());
		        	URDSubModel.setUpdatedOn(row.getUpdatedOn());
		        	URDSubModel.setUserRoleIdFK(uroleID);
					System.out.println("Input values user roles Details:" + URDSubModel);		        	
		        }
				sessionObj.save(URDSubModel);
			}
 		    sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=SMFixedValue.EXEC_CREATE_MSG ;
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()){
				transaction.rollback();
			}
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	
	}

	private static int verifyUserRoleExist(UserRolesModel userRolesModel) {
        String erMsg = SMFixedValue.VERIFY +SMFixedValue.USER + SMFixedValue.ROLE + ": " ;
        Integer IDNOFK = 0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        
	        CriteriaQuery<UserRolesModel> creteriaQuery = builder.createQuery(UserRolesModel.class);
	        Root<UserRolesModel> root = creteriaQuery.from(UserRolesModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), userRolesModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_USERROLE), userRolesModel.getUserRole()),
	        	builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";

	        Query<UserRolesModel> query = sessionObj.createQuery(creteriaQuery);
	        List <UserRolesModel> rows=(ArrayList<UserRolesModel>) query.getResultList();
	       for(UserRolesModel row: rows) {
	    	   IDNOFK = row.getiDNO();
              break;
		   }
	       sessionObj.close();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	    	erMsg += SMFixedValue.OUTPUT + rows.size() 	+SMFixedValue.USER  +SMFixedValue.ROLE +" IDNO :"+ IDNOFK;
		}catch(Exception e) {
			errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return IDNOFK;
	}


	public static JsonArray sMUserRolesList(UserRolesModel userRolesModel) {
	    String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.USER +SMFixedValue.ROLE + SMFixedValue.ACTION_LIST  ;
		JsonArray userRoleList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserRolesModel> creteriaQuery = builder.createQuery(UserRolesModel.class);
	        Root<UserRolesModel> root = creteriaQuery.from(UserRolesModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), userRolesModel.getRegNo()),
 	        	                builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";
	        Query<UserRolesModel> query = sessionObj.createQuery(creteriaQuery);
	        List <UserRolesModel> rows=(ArrayList<UserRolesModel>) query.getResultList();
	        int sNO =0;
	       for(UserRolesModel row: rows) {
	    	  JsonObject rObj = new JsonObject();
	    	  rObj.put("SNO"           , Integer.toString(++ sNO)) ;
		      rObj.put("Registration"  , row.getRegNo())           ;
		      rObj.put("Role"          , row.getUserRole())        ;
		      rObj.put("uRoleId"       , row.getiDNO())            ;
		      userRoleList.add(rObj);	
		   }
	       sessionObj.close();
	       erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	       erMsg += SMFixedValue.OUTPUT + rows.size() 	+userRoleList ;
		}catch(Exception e) {
			errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return userRoleList;
	}

	public static JsonArray sMUserRolesListWithDetails(UserRolesModel userRolesModel) { // Method working perfect
	    String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.USER +SMFixedValue.ROLE + SMFixedValue.ACTION_LIST  ;
		JsonArray userRoleList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserRolesModel> creteriaQuery = builder.createQuery(UserRolesModel.class);
	        Root<UserRolesModel> root = creteriaQuery.from(UserRolesModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), userRolesModel.getRegNo()),
 	        	                builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";
	        Query<UserRolesModel> query = sessionObj.createQuery(creteriaQuery);
	        List <UserRolesModel> rows=(ArrayList<UserRolesModel>) query.getResultList();
	        int sNO =0;
	       for(UserRolesModel row: rows) {
	    	  List<UserRolesDetailsModel> userRoleDetails = row.getURDetailModel();
		       for(UserRolesDetailsModel urdRow: userRoleDetails) {
                  if(urdRow.getStatus().equals(SMFixedValue.STATUS)) {
    		    	  JsonObject rObj = new JsonObject();
    	              rObj.put("SNO"           , Integer.toString(++ sNO)) ;
    		    	  rObj.put("Registration"  , row.getRegNo())           ;
    		    	  rObj.put("Role"          , row.getUserRole())        ;
    		    	  rObj.put("UserName"      , urdRow.getfName() + " " + urdRow.getlName() );
    		    	  rObj.put("Email"         , urdRow.getEmailID())      ;
    		    	  rObj.put("Mobile"        , urdRow.getMobileNo())     ;
    		    	  rObj.put("uRoleId"       , row.getiDNO())            ;
    		    	  rObj.put("uRoleDetailId" , urdRow.getiDDNO() )        ;
    		    	  userRoleList.add(rObj);	
                  }
		       }
		   }
	       sessionObj.close();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	    	erMsg += SMFixedValue.OUTPUT + rows.size() 	+userRoleList ;
		}catch(Exception e) {
			errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return userRoleList;
	}

	/* Generate user login details based on user role id */
	public static JsonArray sMUserRolesListID(UserRolesModel userRolesModel) {
	    String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.USER +SMFixedValue.ROLE + SMFixedValue.ACTION_LIST  ;
		JsonArray userRoleList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserRolesModel> creteriaQuery = builder.createQuery(UserRolesModel.class);
	        Root<UserRolesModel> root = creteriaQuery.from(UserRolesModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), userRolesModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_USERROLE_ID), userRolesModel.getiDNO()),
	        	builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";
	        Query<UserRolesModel> query = sessionObj.createQuery(creteriaQuery);
	        List <UserRolesModel> rows=(ArrayList<UserRolesModel>) query.getResultList();
	        int sNO =0;
	       for(UserRolesModel row: rows) {
	    	  List<UserRolesDetailsModel> userRoleDetails = row.getURDetailModel();
		      for(UserRolesDetailsModel urdRow: userRoleDetails) {
                 if(urdRow.getStatus().equals(SMFixedValue.STATUS)) {
                	 JsonObject rObj = new JsonObject();
		             rObj.put("SNO"           , Integer.toString(++ sNO)) ;
			    	 rObj.put("Registration"  , row.getRegNo())           ;
			    	 rObj.put("Role"          , row.getUserRole())        ;
			    	 rObj.put("UserName"      , urdRow.getfName() + " " + urdRow.getlName() );
			    	 rObj.put("Email"         , urdRow.getEmailID())      ;
			    	 rObj.put("Mobile"        , urdRow.getMobileNo())     ;
			    	 rObj.put("uRoleId"       , row.getiDNO())            ;
			    	 rObj.put("uRoleDetailId" , urdRow.getiDDNO()+ "/" +row.getiDNO())        ;
			    	 userRoleList.add(rObj);	
                 }
		      }
		   }
	       sessionObj.close();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	    	erMsg += SMFixedValue.OUTPUT + rows.size() 	+userRoleList ;
		}catch(Exception e) {
			errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return userRoleList;
	}


	public static int sMUserRolesRemIDD(UserRolesModel userRolesModel) {
		String erMsg = SMFixedValue.ACTION_REMOVING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.DETAILS +  SMFixedValue.information;
        int executeUpdate = 0;
 	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.REMOVE_USERROLE_DETAIL);
	        query.setParameter(SMFixedValue.PARM_IDNO, userRolesModel.getiDNO());
	        query.setParameter(SMFixedValue.PARM_REGNO, userRolesModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
 	        sessionObj.close();
	        erMsg += Integer.toString(executeUpdate) +" "+SMFixedValue.EXEC_REMOVE_MSG  ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
	}

	/** Remove User Role Group */
	public static int sMUserRolesDelIDNO(UserRolesModel userRolesModel) {
		String erMsg = SMFixedValue.ACTION_REMOVING + SMFixedValue.USER + SMFixedValue.ROLE +  SMFixedValue.INFORMATION;
        int executeUpdate = 0;
 	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.REMOVE_USERROLE_GROUP);
	        query.setParameter(SMFixedValue.PARM_IDNO, userRolesModel.getiDNO());
	        query.setParameter(SMFixedValue.PARM_REGNO, userRolesModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
 	        sessionObj.close();
	        erMsg += Integer.toString(executeUpdate) +" "+SMFixedValue.EXEC_REMOVE_MSG  ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
	}

	/** Create New User Role Group */

	public static int sMUserRolesGroup(UserRolesModel userRolesModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.INFORMATION; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int uroleID= verifyUserRoleExist(userRolesModel);
			if (errStatus==1) {	return 3;} // return if error in verifyUserRoleExist(userRolesModel)
			if(uroleID == 0) {
				sessionObj.save(userRolesModel); // Insert data first time in Parent And Child Table
	 		    sessionObj.getTransaction().commit();
				exeStatus=1;
			}else { // User Role Group Already Exist 
				exeStatus=2; 
			}
			sessionObj.close();
			erMsg +=SMFixedValue.DATA_ALREADY_EXIST ;
	   }catch (Exception e) {
			erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()){
				transaction.rollback();
			}
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	
	}		
	public static JsonArray getDuplicateMsg() {
		JsonArray userRoleList = new JsonArray();
		JsonObject rObj = new JsonObject();
        rObj.put("SNO"           , "Duplicate") ;
   	 	userRoleList.add(rObj);	
		return userRoleList;
	}

	public static JsonArray getSMUserRoles(UserRolesModel userRolesModel) {
	    String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.USER +SMFixedValue.ROLE + SMFixedValue.ACTION_LIST  ;
		JsonArray userRoleList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserRolesModel> creteriaQuery = builder.createQuery(UserRolesModel.class);
	        Root<UserRolesModel> root = creteriaQuery.from(UserRolesModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), userRolesModel.getRegNo()),
 	        	                builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";
	        Query<UserRolesModel> query = sessionObj.createQuery(creteriaQuery);
	        List <UserRolesModel> rows=(ArrayList<UserRolesModel>) query.getResultList();
	        int sNO =0;
	       for(UserRolesModel row: rows) {
	    	  JsonObject rObj = new JsonObject();
		      rObj.put("userRole"          , row.getUserRole())        ;
		      rObj.put("userRoleId"       , row.getiDNO().toString())  ;
		      userRoleList.add(rObj);	
		   }
	       sessionObj.close();
	       erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	       erMsg += SMFixedValue.OUTPUT + rows.size() 	+userRoleList ;
		}catch(Exception e) {
			errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return userRoleList;
	}

	/* Generate user login details based on user role name */
	public static JsonArray getSMUserRoleLoginInfo(UserRolesModel userRolesModel) {
	    String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.USER +SMFixedValue.ROLE + SMFixedValue.ACTION_LIST  ;
		JsonArray userRoleList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserRolesModel> creteriaQuery = builder.createQuery(UserRolesModel.class);
	        Root<UserRolesModel> root = creteriaQuery.from(UserRolesModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), userRolesModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_USERROLE), userRolesModel.getUserRole()),
	        	builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";
	        Query<UserRolesModel> query = sessionObj.createQuery(creteriaQuery);
	        List <UserRolesModel> rows=(ArrayList<UserRolesModel>) query.getResultList();
	        int sNO =0;
	       for(UserRolesModel row: rows) {
	    	  List<UserRolesDetailsModel> userRoleDetails = row.getURDetailModel();
		      for(UserRolesDetailsModel urdRow: userRoleDetails) {
                 if(urdRow.getStatus().equals(SMFixedValue.STATUS)) {
                	 JsonObject rObj = new JsonObject();
		             rObj.put("SNO"           , Integer.toString(++ sNO)) ;
			    	 rObj.put("Registration"  , row.getRegNo())           ;
			    	 rObj.put("Role"          , row.getUserRole())        ;
			    	 rObj.put("UserName"      , urdRow.getfName() + " " + urdRow.getlName() );
			    	 rObj.put("Email"         , urdRow.getEmailID())      ;
			    	 rObj.put("Mobile"        , urdRow.getMobileNo())     ;
			    	 rObj.put("uRoleId"       , row.getiDNO())            ;
			    	 rObj.put("uRoleDetailId" , urdRow.getiDDNO()+ "/" +row.getiDNO())        ;
			    	 userRoleList.add(rObj);	
                 }
		      }
		   }
	       sessionObj.close();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	    	erMsg += SMFixedValue.OUTPUT + rows.size() 	+userRoleList ;
		}catch(Exception e) {
			errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return userRoleList;
	}
	

}
