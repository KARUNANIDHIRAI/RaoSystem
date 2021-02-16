package com.rao.System.RwaReg;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.FLTOWN.HVehicleInfoModel;
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
	public static JsonArray RwaRegInformation(RwaRegModel rwaModel, String erMsg) {
        erMsg += " 2.0: RwaRegInformation() " ;
	    JsonArray rwaRegInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<RwaRegModel> root = creteriaQuery.from(RwaRegModel.class);
	        erMsg += " 2.1: Connection & Session Object Ok." ;
	        
	        Path<Object> rwaNo          = root.get("regNo")        ;
	        Path<Object> regName        = root.get("regName")      ;
	        Path<Object> regDate        = root.get("regDate")      ;
	        Path<Object> expDate        = root.get("expDate")      ;
	        Path<Object> emailId        = root.get("emailId")      ;
	        Path<Object> mobileNo       = root.get("mobileNo")     ;
	        Path<Object> phoneNo        = root.get("phoneNo")      ;
	        Path<Object> address        = root.get("address")      ;
	        Path<Object> sector         = root.get("sector")       ;
	        Path<Object> city           = root.get("city")         ;
	        Path<Object> state          = root.get("state")        ;
	        Path<Object> country        = root.get("country")      ;
	        Path<Object> pinCode        = root.get("pinCode")      ;
	        Path<Object> rwaUserId      = root.get("rwaUserId")    ;
	        Path<Object> rwaPassword    = root.get("rwaPassword")  ;
	        Path<Object> regnAuthority  = root.get("regnAuthority");
	        Path<Object> regnAuthEmail  = root.get("regnAuthEmail");
	        Path<Object> athAddress     = root.get("athAddress")   ;
	        Path<Object> athSector      = root.get("athSector")    ;
	        Path<Object> athCity        = root.get("athCity")      ;
	        Path<Object> athState       = root.get("athState")     ;
	        Path<Object> athCountry     = root.get("athCountry")   ;
	        Path<Object> athPinCode     = root.get("athPinCode")   ;
	        Path<Object> status         = root.get("status")       ;
	        erMsg += " 2.2: Connection & Session Object Ok." ;

	        creteriaQuery.multiselect(rwaNo,regName,regDate,expDate,emailId,mobileNo,phoneNo,address,sector,city,state,
	        		country,pinCode, rwaUserId, rwaPassword, regnAuthority, regnAuthEmail, athAddress, athSector, athCity,
	        		athState,athCountry, athPinCode, status  );

		        creteriaQuery.where(builder.equal(root.get("rwaRegNo"), rwaModel.getRegNo()),
			            builder.equal(root.get("Status"), rwaModel.getStatus()));

		    erMsg += " 2.2: Param & fetch Condition OK.:" ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	        erMsg += " 2.3: Execute Query OK.:" ;

	        for(Object[] row :rows ) {
              JsonObject rObj = new JsonObject();
		      rObj.put("RegNO" ,        row[0])  ;
		      rObj.put("RegName" ,      row[1])  ;
		      rObj.put("RegDate" ,      row[2])  ;
		      rObj.put("RegExpDate" ,   row[3])  ;
		      rObj.put("EmailId" ,      row[4])  ;
		      rObj.put("MobileNo" ,     row[5])  ;
		      rObj.put("PhoneNo" ,      row[6])  ;
		      rObj.put("Address" ,      row[7])  ;
		      rObj.put("Sector" ,       row[8])  ;
		      rObj.put("City" ,         row[9])  ;
		      rObj.put("State" ,        row[10]) ;
		      rObj.put("Country" ,      row[11]) ;
		      rObj.put("PinCode" ,      row[12]) ;
		      rObj.put("RWAUserId" ,    row[13]) ;
		      rObj.put("RWAPassword" ,  row[14]) ;
		      rObj.put("RegnAuthority" ,row[15]) ;
		      rObj.put("RegnAuthEmail" ,row[16]) ;
		      rObj.put("AthAddress" ,   row[17]) ;
		      rObj.put("AthSector" ,    row[18]) ;
		      rObj.put("AthCity" ,      row[19]) ;
		      rObj.put("AthState" ,     row[20]) ;
		      rObj.put("AthCountry" ,   row[21]) ;
		      rObj.put("AthPinCode" ,   row[22]) ;
		      rwaRegInfo.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("RWA Reg Information :" +rwaRegInfo);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}
		return rwaRegInfo;
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
