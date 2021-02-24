package com.raoSystem.Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.daoConnection.HibernateDAO;


public class Utilities {
	public String GetOTP(int otpength) {
		String captcha ="0123456789";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<otpength) {
			int index = (int) (random.nextFloat()*captcha.length());
			captchBuffer.append(captcha.substring(index,index+1));
		}
		return captchBuffer.toString();
	}
	public static Date conDate(String DateString) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("DateString: "+ DateString);
		Date cDate = null;
		try {
			 cDate = df.parse(DateString);
		} catch (ParseException e) {
			System.out.println("ParseException: "+ e);
		}  		
		return cDate;
	}
	public static String ConvertDateToString(Date ConvDateToString) throws ParseException {
		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		  String strDate = df.format(ConvDateToString);
		  System.out.println("Date to String: " + strDate);  		
	     return strDate;
	}	

	public static Date StringToDate(String StringDate) throws ParseException {
		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		  Date strDate = df.parse(StringDate);
		  System.out.println("String to Date: " + strDate);  		
	     return strDate;
	}	
	
	public static String SQLerMsg(String erMsg) {
		return erMsg.length()>1?erMsg.substring(erMsg.indexOf("ErrMessage:")+12, erMsg.length()-2):"";
	}

	public static int SQLerNo(String erMsg) {
		switch(erMsg.length()) {
		case 0:
			return 3;
		case 1:
			return Integer.parseInt(erMsg);
		default :
			return Integer.parseInt(erMsg.substring(erMsg.indexOf("ErrNo:")+6,
					erMsg.indexOf("ErrSeverity:")-2));
		}
//		return erMsg.length()>1?Integer.parseInt(erMsg.substring(erMsg.indexOf("ErrNo:")+6,erMsg.indexOf("ErrSeverity:")-2)):Integer.parseInt(erMsg);
	}
	public static JsonArray rwaAddress(String rwaNo, String erMsg) {
        erMsg += " 2.1: utilities.rwaAddress(), " ;
		JsonArray jAaddress = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<Object[]> creteriaQuery = builder.createQuery(Object[].class);
	        Root<RwaRegModel> root = creteriaQuery.from(RwaRegModel.class);
	        erMsg += " connection Ok, " ;
	        
	        Path<Object> RwaNo       = root.get("regNo")   ;
	        Path<Object> Address     = root.get("address") ;
	        Path<Object> sector      = root.get("sector")  ;
	        Path<Object> city        = root.get("city")    ;
	        Path<Object> state       = root.get("state")   ;
	        Path<Object> country     = root.get("country") ;
	        Path<Object> pinCode     = root.get("pinCode") ;
	        creteriaQuery.multiselect(RwaNo, Address,  sector, city, state, country, pinCode);
	        creteriaQuery.where(builder.equal(root.get("regNo"), rwaNo),
	        		            builder.equal(root.get("status"), "A"));
	        erMsg += " Param & data fetch Condition OK, " ;
	        Query<Object[]> query = sessionObj.createQuery(creteriaQuery);
        
	       ArrayList <Object[]> rows =  (ArrayList<Object[]>) query.list();
	       erMsg += " Execute Query OK.:" ;
	       for(Object[] row :rows ) {
	    	   JsonObject rObj = new JsonObject();
	    	   rObj.put("RwaNo"  ,  row[0]);
	    	   rObj.put("Address",  row[1]);
	    	   rObj.put("Sector" ,  row[2]);
	    	   rObj.put("City"   ,  row[3]);
	    	   rObj.put("State"  ,  row[4]);
	    	   rObj.put("Country",  row[5]);
	    	   rObj.put("PinCode",  row[6]);
	    	   jAaddress.add(rObj);
	       }
	       sessionObj.close();
	       System.out.println("KNArray :" +jAaddress);
		}catch(HibernateException hibernateEx) {
	    	erMsg += "HibernateException: \n"+ hibernateEx;
		}catch(Exception e) {
	    	  erMsg += "Catch Exception: \n"+ e;
		}finally {
	          System.out.println("\n"+erMsg );
		}
		return jAaddress;
	}
}
