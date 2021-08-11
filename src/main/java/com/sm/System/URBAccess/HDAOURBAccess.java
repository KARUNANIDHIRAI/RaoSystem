package com.sm.System.URBAccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOURBAccess {
	public static int UserRoles(UserRolesModel userRolesModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.INFORMATION; 
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int uroleID= verifyUserRoleExist(userRolesModel) ;
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
		        	URDSubModel.setStatus(row.getStatus());
		        	URDSubModel.setCreatedBy(row.getCreatedBy());
		        	URDSubModel.setCreatedOn(new Date());
		        	URDSubModel.setUpdatedBy(row.getUpdatedBy());
		        	URDSubModel.setUpdatedOn(new Date());
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
	        Query query = sessionObj.createQuery(SMFixedValue.HQL_VERIFY_INVOICE_NO);
	        query.setParameter(SMFixedValue.PARM_REGNO     ,  userRolesModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_USER_ROLE,  userRolesModel.getUserRole());
	        query.setParameter(SMFixedValue.PARM_OSTATUS   ,  SMFixedValue.STATUS);
	        erMsg+= SMFixedValue.PARM_SET_MSG;
			
	       ArrayList <UserRolesModel> rows =  (ArrayList<UserRolesModel>) query.list();
	       for(UserRolesModel row: rows) {
	    	   IDNOFK = row.getiDNO();
              break;
		   }
	       sessionObj.close();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	    	erMsg += SMFixedValue.OUTPUT + rows.size() 	+SMFixedValue.INVNO +" IDNO :"+ IDNOFK;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return IDNOFK;
	}
}
