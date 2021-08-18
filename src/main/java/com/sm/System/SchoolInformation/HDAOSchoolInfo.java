package com.sm.System.SchoolInformation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.Utility.ValidRwaNo;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;
import com.sm.System.URBAccess.UserRolesModel;

public class HDAOSchoolInfo{
	public static int newSchInfo(SchoolInfoModel siModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(siModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" hibernate commit transaction HDAQ1";
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

	@SuppressWarnings("unused")
	public static String validRegNo(String registrationNo) {
		String regStaus = "";
		Transaction transaction = null;
		String erMsg;
		erMsg = SMFixedValue.EXE_VALID_MSG;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	        SchoolInfoModel rows=  (SchoolInfoModel) sessionObj.get(SchoolInfoModel.class,registrationNo);
	        erMsg += SMFixedValue.EXEC_QUERY_MSG;
	        if (rows!=null) {
		        regStaus=SMFixedValue.DUPLICATE; 
	        }
	    }catch (Exception e) {
	    	  erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return regStaus;
	}
	@SuppressWarnings("unused")
	public static String KNValidDupEmail(String emailid) {
		String regStaus = "";
		Transaction transaction = null;
		String erMsg;
		erMsg = " Step 2: Validatation start " ;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	        erMsg += " 2.1: Began Tran OK. " ;
	        Email rows=  (Email) sessionObj.get(Email.class,emailid);
	        if (rows!=null) {
	        	regStaus="Duplicate";
		        erMsg = " 2.3 :Validatation ok" +rows.getEmailID();
	        }
	    }catch (Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return regStaus;
	}
	@SuppressWarnings("unchecked")
	public static String verifyDupEmail(String emailId) {
		String emailStatus = ""; 
		String erMsg = "Step 2: HDAOValidEmail Star OK";
		System.out.println("EmailId :" + emailId);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
	        String HQL = "FROM Email WHERE emailId =?0 ";
	        Query<Email> query = sessionObj.createQuery(HQL, Email.class );
	        query.setParameter(0, emailId);
	       ArrayList <Email> rows =  (ArrayList<Email>) query.list();
	        Iterator<Email> itr = rows.iterator();
	       while(itr.hasNext()){
				 emailStatus="Duplicate";
		          erMsg = " 2.3 :Validatation ok: " + itr.next();
		          break;
	        }
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return emailStatus;
	}
	@SuppressWarnings("unchecked")
	public static String validateEmail(String emailId) {
		String emailStatus = "New Email Id"; 
		String erMsg = "Step 2: HDAOValidEmail Star OK";
		Transaction transaction = null;
		System.out.println("EmailId :" + emailId);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
	        String HQL = "FROM SchoolInfoModel WHERE regNo=?0 AND emailId =?1 ";
	        Query<SchoolInfoModel> query = sessionObj.createQuery(HQL, SchoolInfoModel.class );
	        query.setParameter(0, emailId);
	       ArrayList <SchoolInfoModel> rows =  (ArrayList<SchoolInfoModel>) query.list();
	        Iterator<SchoolInfoModel> itr = rows.iterator();
	       while(itr.hasNext()){
				 emailStatus="Duplicate";
		          erMsg = " 2.3 :Validatation ok: " + itr.next();
		          break;
	        }
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return emailStatus;
	}
	public static String getSchoolName(String SchoolRegNo) {
	    String erMsg = SMFixedValue.GENERATING + SMFixedValue.School + SMFixedValue.INFORMATION;
		String SchoolInfo = null;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<SchoolInfoModel> creteriaQuery = builder.createQuery(SchoolInfoModel.class);
	        Root<SchoolInfoModel> root = creteriaQuery.from(SchoolInfoModel.class);
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), SchoolRegNo),
 	        	                builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG +" ;";
	        Query<SchoolInfoModel> query = sessionObj.createQuery(creteriaQuery);
	        List <SchoolInfoModel> rows=(ArrayList<SchoolInfoModel>) query.getResultList();
	       for(SchoolInfoModel row: rows) {
	    	   SchoolInfo= row.getName() ;
		   }
	       sessionObj.close();
	       erMsg += SMFixedValue.EXEC_QUERY_MSG + SMFixedValue.OUTPUT + rows.size() 	+ ":" +SchoolInfo ;
		}catch(Exception e) {
			//errStatus =1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return SchoolInfo;
	}
}
