package com.rao.System.RwaReg;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.ValidEmail;
import com.raoSystem.Utility.ValidRwaNo;
import com.raoSystem.daoConnection.HibernateDAO;

public class HDAORwa {

	public static int newRwa(RwaRegModel rModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(rModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" hibernate commit transaction HDAQ1";
			rwaStatus=1;
		}catch(HibernateException hibernateEx) {
			erMsg +="...HibernateException Transaction .. \n" + hibernateEx;
			
			if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
    		return rwaStatus;
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
	public static String validRwaNo(String rwaNo) {
		String rwaStaus = "New Rwa No";
		Transaction transaction = null;
		JsonArray countrylist= new JsonArray();
		String erMsg;
		erMsg = " Step 2: Validatation start " ;
		System.out.println("errMsg: "+ erMsg + "Rwa RegNO: "+ rwaNo);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
	          erMsg += " 2.1: Began Tran OK. " ;
	          ValidRwaNo rows=  (ValidRwaNo) sessionObj.get(ValidRwaNo.class,rwaNo);
	          System.out.println( "query execute successfully");
	          if (rows!=null) {
		          rwaStaus="Duplicate";
		          erMsg = " 2.3 :Validatation ok" +rows.getRegNo() ;
	          }
	          sessionObj.getTransaction().commit();
	      } catch(HibernateException hibernateEx) {
	    	  erMsg += "HibernateException: \n"+ hibernateEx;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	      }catch (Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return rwaStaus;
	}

	@SuppressWarnings("unchecked")
	public static String validEmail(String emailId) {
		String emailStatus = "New Email Id"; 
		String erMsg = "Step 2: HDAOValidEmail Star OK";
		Transaction transaction = null;
		System.out.println("EmailId :" + emailId);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			transaction = sessionObj.beginTransaction();
	        erMsg += " 2.1: Began Tran OK. " ;
	        Query query = sessionObj.createQuery("from RwaRegModel where emailId ='" +emailId+"'" );
	       ArrayList <RwaRegModel> rows =  (ArrayList<RwaRegModel>) query.list();
	        Iterator<RwaRegModel> itr = rows.iterator();
	       while(itr.hasNext()){
				 emailStatus="Duplicate";
		          erMsg = " 2.3 :Validatation ok: " + itr.next();
		          break;
	        }
           sessionObj.getTransaction().commit();
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
	    	if (transaction!=null) {
	    	  transaction.rollback();
	    	}
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return emailStatus;
	}

	@SuppressWarnings("unchecked")
	public static String validateEmail(String emailId,String rwacode) {
		String emailStatus = "New Email Id"; 
		String erMsg = "Step 2: HDAOValidEmail Star OK";
		String status = "A";
		Transaction transaction = null;
		System.out.println("EmailId :" + emailId);
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			transaction = sessionObj.beginTransaction();
	        erMsg += " 2.1: Began Tran OK. " ;
	        String HQL = "FROM RwaRegModel WHERE regNo=?0 AND emailId =?1 AND status=?2";
	        Query<RwaRegModel> query = sessionObj.createQuery(HQL, RwaRegModel.class );
	        query.setParameter(0, rwacode);
	        query.setParameter(1, emailId);
	        query.setParameter(2, status);
	       ArrayList <RwaRegModel> rows =  (ArrayList<RwaRegModel>) query.list();
	        Iterator<RwaRegModel> itr = rows.iterator();
	       while(itr.hasNext()){
				 emailStatus="Duplicate";
		          erMsg = " 2.3 :Validatation ok: " + itr.next();
		          break;
	        }
           sessionObj.getTransaction().commit();
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
	    	if (transaction!=null) {
	    	  transaction.rollback();
	    	}
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return emailStatus;
	}
	
}
