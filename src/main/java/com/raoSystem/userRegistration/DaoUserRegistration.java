package com.raoSystem.userRegistration;

import java.sql.Types;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;
import com.raoSystem.login.UserLogin;

public class DaoUserRegistration {
	public static UserRegInit UserCheck(UserRegInit user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
/*
			String Fname    = user.getFname();
			String Lname    = user.getLname();
			String MobileNO = user.getMobileNO();
			String EmailId  = user.getEmailId();
			String Address  = user.getAddress();
			String BlockNO  = user.getBlockNO();
			String Sector   = user.getSector();
			String city     = user.getCity();
			String State    = user.getState();
			String Country  = user.getCountry();
			String ZipCode  = user.getZipCode();
			String UserID   = user.getUserID();
			String Password = user.getPassword();
			String SecurityCode = user.getSecurityCode();
			String RWARegNo = user.getRWARegNo();
			int userType = user.getUserType();

			user.setValid(false);

			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			System.out.println("Step 4 : Store procedure Patameter setting ");
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateUserLogin](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, EmailId);
			ComVar.myStat.setString(2, RWARegNo);
			ComVar.myStat.setString(3, Fname);
			ComVar.myStat.setString(4, Lname);
			ComVar.myStat.setInt(5, userType);
			ComVar.myStat.setString(6, Password);
			ComVar.myStat.setString(7, MobileNO);
			ComVar.myStat.setString(8, SecurityCode);

			ComVar.myStat.setString(9, Address);
			ComVar.myStat.setString(10, BlockNO);
			ComVar.myStat.setString(11, Sector);
			ComVar.myStat.setString(12, city);
			ComVar.myStat.setString(13, State);
			ComVar.myStat.setString(14, Country);
			ComVar.myStat.setString(15, ZipCode);
			ComVar.myStat.setString(16, UserID);
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);
			
			System.out.println(EmailId+": "+RWARegNo+": "+ Fname + ": "+Lname+ ": "+userType+": "+Password+": "+MobileNO+": "+SecurityCode+": "+
			                   Address+": "+BlockNO+": "+Sector+": "+city+": "+State+": "+Country+": "+	ZipCode+": "+UserID);
			System.out.println("Step 5 : store procedure execution started ");
*/

			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			System.out.println("Step 4 : Store procedure Patameter setting ");
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateUserLogin](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, user.getEmailId());
			ComVar.myStat.setString(2, user.getRWARegNo());
			ComVar.myStat.setString(3, user.getFname());
			ComVar.myStat.setString(4, user.getLname());
			ComVar.myStat.setInt(5,    user.getUserType());
			ComVar.myStat.setString(6, user.getPassword());
			ComVar.myStat.setString(7, user.getMobileNO());
			ComVar.myStat.setString(8, user.getSecurityCode());

			ComVar.myStat.setString(9, user.getAddress());
			ComVar.myStat.setString(10, user.getBlockNO());
			ComVar.myStat.setString(11, user.getSector());
			ComVar.myStat.setString(12, user.getCity());
			ComVar.myStat.setString(13, user.getState());
			ComVar.myStat.setString(14, user.getCountry());
			ComVar.myStat.setString(15, user.getZipCode());
			ComVar.myStat.setString(16, user.getUserID());
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);


			System.out.println("Parameter Valuse pass to SP -->"+user.getEmailId()+" : " +user.getRWARegNo()+" : " + user.getFname() +" : " +user.getFname() +" : " +user.getLname()+" : " 
			+ user.getUserType()+" : "  + user.getPassword()+" : "+user.getMobileNO()+ " : "  +user.getSecurityCode()+" : "  +user.getAddress()+" : " 
			+ user.getBlockNO()+" : "   + user.getSector() + " : " + user.getCity()+  " : " +user.getState()+ " : " + user.getCountry()+" : " 
			+ user.getZipCode() + user.getUserID()	);
			
			boolean spExecuteStatus=ComVar.myStat.execute();
	        int SPStatus= ComVar.myStat.getInt(17);
	        user.setSPstatus(SPStatus);// store proceure status after sp execution
	        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+SPStatus);
	        user.setValid(true);

/*	        if (user.getSPstatus() == 1  ) {
				user.setValid(true);
				System.out.println("User Created Successfully:");
			} else {
				user.setValid(false); System.out.println("Fail to Create User:");  
			}
*/	        
		} catch (Exception e) {
			System.out.println("ERROR : Technical error in Createing user" + e);
			user.setValid(false);
			e.printStackTrace();

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