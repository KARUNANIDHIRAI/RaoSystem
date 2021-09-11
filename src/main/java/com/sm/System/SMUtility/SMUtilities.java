package com.sm.System.SMUtility;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.sm.System.SMInformation.SMFixedValue;

public class SMUtilities {

	public static SMDataCreatedUpdated getUserInfo(HttpSession session) {
		String erMsg = SMFixedValue.USER + SMFixedValue.INFORMATION;
		SMDataCreatedUpdated userInfo = new SMDataCreatedUpdated();
		try {
			userInfo.setCreatedBy("KBS TECHNOLGOY");
//			userInfo.setCreatedBy(session.getAttribute("UserID").toString());
			userInfo.setCreatedOn(new Date());
			userInfo.setUpdatedBy(userInfo.getCreatedBy());
			userInfo.setUpdatedOn(userInfo.getCreatedOn());
			erMsg += userInfo;
		} catch (Exception e) {
			erMsg += "\n" + SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {System.out.println(erMsg);}
		return userInfo;
	}
	public static SMDataCreatedUpdated getUserInfo(String useer, HttpSession session) {
		String erMsg = SMFixedValue.USER + SMFixedValue.INFORMATION;
		SMDataCreatedUpdated userInfo = new SMDataCreatedUpdated();
		try {
			userInfo.setCreatedBy("KBS TECHNOLGOY");
//			userInfo.setCreatedBy(session.getAttribute("UserID").toString());
			userInfo.setCreatedOn(new Date());
			userInfo.setUpdatedBy(userInfo.getCreatedBy());
			userInfo.setUpdatedOn(userInfo.getCreatedOn());
			erMsg += userInfo;
		} catch (Exception e) {
			erMsg += "\n" + SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {System.out.println(erMsg);}
		return userInfo;
	}
	public static int subtractNumber(String numString, int id) {
		int pos = numString.indexOf("/");
		int uRID=0;  
		try {
			uRID = id==2?Integer.parseInt(numString.substring(pos+1)) :Integer.parseInt(numString.substring(0,pos));
		} catch (NumberFormatException e) {
			System.out.println(SMFixedValue.EXEC_CATCH_MSG +"\n" +  e);			
		}
		return uRID;
	}	
	public static String subtractStringAndNumber(String numString, int id) {
		int pos = numString.indexOf("/");
		String InputXValue = null;
		if(pos<=0) {return InputXValue;}
		try {
			InputXValue = id==2?numString.substring(pos+1) :numString.substring(0,pos);
		} catch (NumberFormatException e) {
			System.out.println(SMFixedValue.EXEC_CATCH_MSG +"\n" +  e);			
		}
		return InputXValue;
	}
	public static int subtractIntAndInt(String numString, int id) {
		int pos = numString.indexOf("/");
		int uRID=0;  
		try {
			uRID = id==2?Integer.parseInt(numString.substring(pos+1)) :Integer.parseInt(numString.substring(0,pos));
		} catch (NumberFormatException e) {
			System.out.println(SMFixedValue.EXEC_CATCH_MSG +"\n" +  e);			
		}
		return uRID;
	}	

}
