package com.sm.System.UserLogin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import com.raoSystem.daoConnection.HibernateDAO;
//import com.rao.System.UserLogin.UserLoginModel;
//import com.rao.System.UserLogin.UserAddress;
public class HDAOUserLoginSMSI {
	public static String newUser(UserLoginSMSIModel uLModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.persist(uLModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg ="";
	    }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	    	  if (transaction!=null) {
	    		  transaction.rollback();
	    	  }
	  		return erMsg;
 	   }finally {
 		   System.out.println("HDAO : " +erMsg);
 	   }
		return erMsg;
	}

	public static JsonArray userlList(JsonArray ulArray, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
		     int ctr= 0;
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
	        
	        Path<Object> rwaNo = root.get("regNo");
	        Path<Object> email = root.get("email");
	        Path<Object> FirstName = root.get("FirstName");
	        Path<Object> LastName = root.get("LastName");
	        Path<Object> Mobile = root.get("Mobile");
	        creteriaQuery.multiselect(rwaNo, email,FirstName,LastName,Mobile);
	        creteriaQuery.where(builder.equal(root.get("regNo"), "MK103"),
	        		            builder.equal(root.get("status"), "A"));
        
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
		        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	       
	       System.out.println("\n uLarray length: "+ ulArray.size());
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("SNO", ++ctr);
	    	   rObj.put("RWA", row[0]);
	    	   rObj.put("ULID", row[1]);
	    	   rObj.put("FName", row[2]);
	    	   rObj.put("LName", row[3]);
	    	   rObj.put("Mobile", row[4]);
	    	   ulArray.add(rObj);
	       }
	       
	       System.out.println("Array :" +ulArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return ulArray;
	}

	public static JsonArray userInfo(JsonArray userInfoArray, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
	        int ctr = 0;
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<UserLoginSMSIModel> creteriaQuery = builder.createQuery(UserLoginSMSIModel.class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
//	        root.join("UAdd");
	        root.fetch("UAdd");

	        creteriaQuery.where(builder.equal(root.get("regNo"), "MK103"),
		                        builder.equal(root.get("status"), "A"));
	        
	        Query<UserLoginSMSIModel> query = sessionObj.createQuery(creteriaQuery);
		       ArrayList <UserLoginSMSIModel> rows =  (ArrayList<UserLoginSMSIModel>) query.getResultList();

		       for(UserLoginSMSIModel row : rows) {
		    	   JsonObject rObj = new JsonObject();
		    	   rObj.put("SNO", ++ctr);
		    	   rObj.put("RWA", row.getRegNo());
		    	   rObj.put("ULID", row.getEmail());
		    	   rObj.put("FName", row.getFirstName());
		    	   rObj.put("LName", row.getLastName());
		    	   rObj.put("Mobile", row.getMobile());
		    	   List<UserSMSIAddress> uAddress = row.getUAdd();
		    	   for( UserSMSIAddress uarow :uAddress ) {
		    		   rObj.put("Address", uarow.getAddress());
		    		   rObj.put("Sector", uarow.getSector());
		    		   rObj.put("City", uarow.getCity());
		    		   rObj.put("State", uarow.getState());
		    		   rObj.put("Country", uarow.getCountry());
		    		   rObj.put("PinCode", uarow.getPinCode());
		    	   }
			    	   userInfoArray.add(rObj);
		    	   }
		       System.out.println(userInfoArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return userInfoArray;
	}

	public static JsonArray userLoginInfo(JsonArray userInfoArray, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        erMsg += " 2.1: Began Tran OK. " ;
	        int ctr = 0;
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginInfo");
	        sPQuery.registerStoredProcedureParameter("Emailid", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo", String.class, ParameterMode.IN);
	        sPQuery.setParameter("Emailid", "RAMA@GMAIL.COM");
	        sPQuery.setParameter("RwaRegNo", "MK103");
        
	        sPQuery.execute();
	        List<Object[]> rows =  sPQuery.getResultList();
	        System.out.println(rows.size());
	        for(Object[] row : rows) {
	    	   JsonObject krObj = new JsonObject();
	    	   krObj.put("SNO",     ++ctr);
	    	   krObj.put("ULID",    row[0]);
	    	   krObj.put("RWA",     row[1]);
	    	   krObj.put("FName",   row[2]);
	    	   krObj.put("LName",   row[3]);
	    	   krObj.put("Security",row[4]);
	    	   krObj.put("Mobile",  row[5]);
	    	   krObj.put("Address", row[6]);
	    	   krObj.put("Sector",  row[7]);
	    	   krObj.put("City",    row[8]);
	    	   krObj.put("State",   row[9]);
	    	   krObj.put("Country", row[10]);
	    	   krObj.put("PinCode", row[11]);
		        userInfoArray.add(krObj);
    	    }
	        System.out.println(userInfoArray);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return userInfoArray;
	}
	public static Integer  userLoginInfoEdit(UserLoginSMSIModel uLModel, String erMsg) {
        erMsg += " 2.1: Began Tran OK. " ;
        Integer  spStatus=0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginInfoUpdate");
	        sPQuery.registerStoredProcedureParameter("Emailid",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo", String.class, ParameterMode.IN);

	        sPQuery.registerStoredProcedureParameter("FName",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("LName",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Mobile",   String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Security", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("UID",      String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Password", String.class, ParameterMode.IN);

	        sPQuery.registerStoredProcedureParameter("Address",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Sector",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("City",     String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("State",    String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("Country",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("PinCode",  String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("SPStatus", Integer.class, ParameterMode.OUT);
	        
	        sPQuery.setParameter("Emailid",  uLModel.getEmail());
	        sPQuery.setParameter("RwaRegNo", uLModel.getRegNo());
	        sPQuery.setParameter("FName",    uLModel.getFirstName());
	        sPQuery.setParameter("LName",    uLModel.getLastName());
	        sPQuery.setParameter("Mobile",   uLModel.getMobile());
	        sPQuery.setParameter("Security", uLModel.getSecurity());
	        sPQuery.setParameter("UID",      uLModel.getCreatedBy());
	        sPQuery.setParameter("Password", uLModel.getLPassword());
	        
	    	   List<UserSMSIAddress> uAddress =  uLModel.getUAdd();
	    	   for( UserSMSIAddress uarow :uAddress ) {
		         sPQuery.setParameter("Address", uarow.getAddress());
		         sPQuery.setParameter("Sector", uarow.getSector());
		         sPQuery.setParameter("City",    uarow.getCity());
		         sPQuery.setParameter("State",   uarow.getState());
		         sPQuery.setParameter("Country", uarow.getCountry());
		         sPQuery.setParameter("PinCode", uarow.getPinCode());
	    	   }
	        sPQuery.execute();
	        spStatus = (Integer) sPQuery.getOutputParameterValue("SPStatus");
	        System.out.println("spStatus:" + spStatus);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return spStatus;
	}

	public static HashMap<String, String> validPassword(HashMap<String, String> loginObj, String erMsg) {
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			erMsg += "Step 3: validPassword ";
			
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
	        
	        Path<Object> rwaNo = root.get("regNo");
	        Path<Object> lgpwd = root.get("LPassword");
	        Path<Object> FirstName = root.get("FirstName");
			erMsg += "Step 3.1: Parameter OK ";
	        creteriaQuery.multiselect(rwaNo, lgpwd,FirstName);
	        creteriaQuery.where(builder.equal(root.get("email"),loginObj.get("UID")),
	        		            builder.equal(root.get("status"), "A"));
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
			erMsg += "Step 3.2: execute OK ";
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	       
	       System.out.println("\n uLarray length: "+ rows.size());
	       for(Object[] row :rows ) {
	    	   loginObj.put("RwaNo",   (String) row[0]);
	    	   loginObj.put("password", (String)row[1]);
	    	   loginObj.put("fName",    (String)row[2]);
	       }
//	       for (HashMap.Entry<String, String> e : loginObj.entrySet()) {
//	            System.out.println(e.getKey() + " " + e.getValue()); 
//	       }     
		}catch(HibernateException hibernateEx) {
			
		}catch(Exception e) {
				
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return loginObj;
	}
	public static boolean validEmail(String emailID, String erMsg) {
		erMsg += "Step 3: validPassword ";
		boolean valEmail=false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
	        
	        Path<Object> uid = root.get("email");
	        Path<Object> mobile = root.get("Mobile");
			erMsg += "Step 3.1: Parameter OK ";
	        creteriaQuery.multiselect(uid,mobile );
			erMsg += "Step 3.1.1: query Select OK ";
	        creteriaQuery.where(builder.equal(root.get("email"),emailID), builder.equal(root.get("status"), "A"));
			erMsg += "Step 3.2: where OK ";
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
			erMsg += "Step 3.3: execute OK ";
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	       valEmail = rows.size()>=1?true:false;
	       for(Object[] row: rows) {
	    	   System.out.println("Rows: "+ row[0]+ " : "+row[1]);
	       }
			erMsg += "Step 3.4: Row Size OK "+ rows.size();
			       
		}catch(HibernateException hibernateEx) {
			
		}catch(Exception e) {
				
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return valEmail;
	}
	public static boolean UpdateOTP(String otp, String  email, String rwaNo, String erMsg) {
        erMsg += " 2.1: Began Update OTP . " ;
        boolean OTPUpdStatus = false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginOTPUpdate");
	        sPQuery.registerStoredProcedureParameter("Emailid", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("RwaRegNo", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("OTP", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("OTPStatus", Integer.class, ParameterMode.OUT);
	        sPQuery.setParameter("Emailid", email);
	        sPQuery.setParameter("RwaRegNo", rwaNo);
	        sPQuery.setParameter("OTP", otp);
	        erMsg += " 2.1: set Parameter OK. " ;
	        sPQuery.execute();
	        erMsg += " 2.1: Execute Query OK. " ;
	        int OTPStatus = (int) sPQuery.getOutputParameterValue("OTPStatus");
	        System.out.println("Out msg= " + OTPStatus);	        
	        OTPUpdStatus= OTPStatus==1?true:false;
	        erMsg += " 2.1: OTPUpdStatus : " + OTPUpdStatus +" , " ;
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
			return OTPUpdStatus;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
	  		return OTPUpdStatus;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return OTPUpdStatus;
	}
	public static boolean UpdatePassword(HashMap<String, String> pwdObj, String erMsg) {
        erMsg += " 2.1: Began Update password . " ;
        boolean OTPUpdStatus = false;
        int PWDStatus=0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginPWDUpdate");

	        sPQuery.registerStoredProcedureParameter("Emailid", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("PWD", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("OTP", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("PWDStatus", Integer.class, ParameterMode.OUT);

	        sPQuery.setParameter("Emailid"  , pwdObj.get("UID"));
	        sPQuery.setParameter("PWD"      , pwdObj.get("password"));
	        sPQuery.setParameter("OTP"      , pwdObj.get("OTP"));
	        
	        erMsg += " 2.1: set Parameter OK. " ;
	        sPQuery.execute();
	        erMsg += " 2.1: Execute Query OK. " ;
	        PWDStatus = (int) sPQuery.getOutputParameterValue("PWDStatus");
	        System.out.println("Out msg= " + PWDStatus);	        
	        OTPUpdStatus= PWDStatus==1?true:false;
	        erMsg += " 2.1: OTPUpdStatus : " + OTPUpdStatus +" , " ;
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
			return OTPUpdStatus;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
	  		return OTPUpdStatus;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return OTPUpdStatus;
	}

	public static boolean UpdateULOTP(HashMap<String, String> otpObj, String erMsg) {
	    erMsg += " 2.1: Began Update OTP . " ;
        boolean OTPUpdStatus = false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        StoredProcedureQuery sPQuery = sessionObj.createStoredProcedureQuery("UserLoginOTPUpdate");
	        sPQuery.registerStoredProcedureParameter("Emailid", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("OTP", String.class, ParameterMode.IN);
	        sPQuery.registerStoredProcedureParameter("OTPStatus", Integer.class, ParameterMode.OUT);
	        sPQuery.setParameter("Emailid", otpObj.get("email"));
	        sPQuery.setParameter("OTP", otpObj.get("OTP"));
	        
	        erMsg += " 2.1 set Parameter OK. " ;
	        sPQuery.execute();
	        erMsg += " 2.2: Execute Query OK. " ;
	        int OTPStatus = (int) sPQuery.getOutputParameterValue("OTPStatus");
	        System.out.println("Out msg= " + OTPStatus);	        
	        OTPUpdStatus= OTPStatus==1?true:false;
	        erMsg += " 2.3: OTPUpdStatus : " + OTPUpdStatus +" , " ;
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
			return OTPUpdStatus;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
	  		return OTPUpdStatus;
		}finally {
	          System.out.println("\n"+erMsg );
		}
			return OTPUpdStatus;
	}

	public static boolean ValidateOTP(UserLoginSMSIModel uLOTP, String erMsg) {
		erMsg += "Step 3: validate OTP ";
		boolean valOTPStatus=false;
		String dbOTP=null;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
	        
	        Path<Object> otp = root.get("otp");
	        creteriaQuery.multiselect(otp );
	        creteriaQuery.where(builder.equal(root.get("email"),uLOTP.getEmail()), 
	        		            builder.equal(root.get("otp"),uLOTP.getOtp()),
	        		            builder.equal(root.get("status"), "A"));
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
			erMsg += "Step 3.3: execute OK ";
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	       valOTPStatus = rows.size()>=1?true:false;
			erMsg += "Step 3.4: Row Size OK "+ rows.size();	
			
		}catch(HibernateException hibernateEx) {
			System.out.println("\n HibernateException: " + hibernateEx);
			
		}catch(Exception e) {
			System.out.println("\n Catch Exception:"  + e);
				
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return valOTPStatus;		
	}

	public static String ValidateUIDR(String emailID, String erMsg) {
		System.out.println("email id hdao :" + emailID);
		erMsg += "Step 3:  ";
		String valEmail=null;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
	        
	        Path<Object> uid = root.get("email");
	        Path<Object> mobile = root.get("Mobile");
			erMsg += "Step 3.1: Parameter OK ";
	        creteriaQuery.multiselect(uid,mobile );
			erMsg += "Step 3.2: query Select OK ";

			creteriaQuery.where(
	        		builder.or(builder.equal(root.get("email"), emailID), 
	        				    builder.equal(root.get("Mobile"), emailID)),
	        		builder.and(builder.equal(root.get("status"), "A"))
        	);	        
	        erMsg += "Step 3.3: where OK ";
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
			erMsg += "Step 3.4: execute OK ";
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
//	       valEmail = rows.size()>=1?true:false;
	       for(Object[] row: rows) {
	    	   System.out.println("Rows: "+ row[0]+ " : "+row[1]);
	    	   valEmail = (String) row[0];
	       }
			erMsg += "Step 3.4: Row Size OK "+ rows.size();
		}catch(HibernateException hibernateEx) {
	          System.out.println("\n"+hibernateEx );
			
		}catch(Exception e) { 
	          System.out.println("\n"+e );
				
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return valEmail;
	}
	public static UserLoginSMSIModel sentUIRD(UserLoginSMSIModel uIRDObj, String erMsg) {
		erMsg += "Step 3: validPassword ";
//		boolean valEmail=false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<UserLoginSMSIModel> root = creteriaQuery.from(UserLoginSMSIModel.class);
	        Path<Object> uid = root.get("email");
	        Path<Object> Name = root.get("FirstName");
	        
			erMsg += " 3.1: Parameter OK ";
	        creteriaQuery.multiselect(uid, Name);
			erMsg += "Step 3.1.1: query Select OK ";
			creteriaQuery.where(
	        		builder.or(builder.equal(root.get("email"), uIRDObj.getEmail()), 
	        				    builder.equal(root.get("Mobile"), uIRDObj.getEmail())),
	        		builder.and(builder.equal(root.get("otp"), uIRDObj.getOtp()),
	        				    builder.equal(root.get("status"), "A"))
        	);	        
			erMsg += " 3.2: where OK ";
			erMsg += " para :" + uIRDObj.getEmail() + " , " + uIRDObj.getOtp();
	        
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
			erMsg += "Step 3.3: execute OK ";
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
//	       valEmail = rows.size()>=1?true:false;
	       for(Object[] row: rows) {
	    	   uIRDObj.setEmail((String)row[0]);
	       }
			erMsg += "Step 3.4: Row Size: " + rows.size();
		}catch(HibernateException hibernateEx) {
			
		}catch(Exception e) {
				
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return uIRDObj;
	}	
}
