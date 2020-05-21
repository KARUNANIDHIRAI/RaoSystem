package com.raoSystem.userRegistration;

import java.sql.Types;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DaoSearchUser {
	public static UserRegInit UserCheck(UserRegInit user) {
		System.out.println("Step2 Start DAO ACTION");

	System.out.println("Step2 Start DAO ACTION");
	try {

		user.setValid(false);
		user.setSPstatus(0);	
		ComVar.Conn = ConnectionManager.getConnection();
		System.out.println("Step 3 : create Connection successfully");
		System.out.println("Step 4 : Store procedure Patameter setting ");
		
		switch(user.getTranType()){
		case "ADD" :
			ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchUser](?,?)}");

			ComVar.myStat.setString(1, (String)user.getEmailId());
			ComVar.myStat.setString(2, (String)user.getRWARegNo());
			System.out.println("Parameter Valuse pass to SP -->"+user.getEmailId()+" : " +user.getRWARegNo());
			
			ComVar.myStat.execute();
	        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
	        user.setValid(true);
	        
	        ComVar.prst = ComVar.myStat.getResultSet();
	    	
	        while(ComVar.prst.next()){
	        	user.setSPstatus(1);
	        	user.setFname(ComVar.prst.getString("FName"));
		        user.setLname(ComVar.prst.getString("LName"));
		        user.setUserType(Integer.parseInt(ComVar.prst.getString("userType")));
		        user.setPassword(ComVar.prst.getString("loginPassword"));
		        user.setMobileNO(ComVar.prst.getString("mobileNo"));
		        user.setSecurityCode(ComVar.prst.getString("securityCode"));
		        user.setAddress(ComVar.prst.getString("Address"));
		        user.setBlockNO(ComVar.prst.getString("Block"));
		        user.setSector(ComVar.prst.getString("Sector"));
		        user.setCity(ComVar.prst.getString("City"));
		        user.setState(ComVar.prst.getString("State"));
		        user.setCountry(ComVar.prst.getString("Country"));
		        user.setZipCode(ComVar.prst.getString("Pincode")); 
		    } 
			break;
		case "EDIT":
			ComVar.myStat = ComVar.Conn.prepareCall("{call [EditUser](?,?,?,?,?,?,?,?,?,?)}");
			System.out.println(" kn rai edit start");
			ComVar.myStat.setString(1, (String)user.getEmailId());
			ComVar.myStat.setString(2, (String)user.getRWARegNo());
			ComVar.myStat.setString(3, (String)user.getAddress());
			ComVar.myStat.setString(4, (String)user.getBlockNO());
			ComVar.myStat.setString(5, (String)user.getSector());
			ComVar.myStat.setString(6, (String)user.getCity());
			ComVar.myStat.setString(7, (String)user.getState());
			ComVar.myStat.setString(8, (String)user.getCountry());
			ComVar.myStat.setString(9, (String)user.getZipCode());
			ComVar.myStat.registerOutParameter(10, Types.INTEGER);
			
			boolean spExecuteStatus=ComVar.myStat.execute();
	        user.setSPstatus(ComVar.myStat.getInt(10));// store proceure status after sp execution
	        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
	        user.setValid(true);
	        System.out.println("checking test : 0");
	        break;
	   		
		case "DELETE":
			ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchUser](?,?,?)}");
			ComVar.myStat.setString(1, user.getEmailId());
			ComVar.myStat.setString(2, user.getRWARegNo());
			ComVar.myStat.registerOutParameter(3, Types.INTEGER);
			
			ComVar.myStat.execute();
	        user.setSPstatus(ComVar.myStat.getInt(3));// store proceure status after sp execution
	        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
	        user.setValid(true);
	        break;
		case "VIEW":
			break;
		default:	
	        user.setValid(true);
	        break;
		}

	} catch (Exception e) {
		System.out.println("KN ERROR : Technical error in Createing user" + e);
		user.setValid(false);
		e.printStackTrace();
		user.setSPstatus(3);
	} finally {
		if (ComVar.prst != null) {
			try {
				ComVar.prst.close();
			} catch (Exception e) {
			}
			ComVar.prst = null;
		}
		if (ComVar.myStat != null) {
			try {
				ComVar.myStat.close();
			} catch (Exception e) {
			}
			ComVar.myStat = null;
		}
		if (ComVar.Conn != null) {
			try {
				ComVar.Conn.close();
			} catch (Exception e) {
			}
			ComVar.Conn = null;
		}
	}
	return user;
	}	
	
}
