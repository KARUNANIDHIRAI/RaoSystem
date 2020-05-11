package com.raoSystem.userRegistration;

import java.sql.Types;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;
import com.raoSystem.login.UserLogin;

public class DaoUserRegistration {
	public static UserRegInit UserCheck(UserRegInit user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			String Fname = user.getFname();
			String Lname = user.getLname();
			String MobileNO = user.getMobileNO();
			String EmailId = user.getEmailId();
			String Address = user.getAddress();
			String BlockNO = user.getBlockNO();
			String Sector = user.getSector();
			String city = user.getCity();
			String State = user.getState();
			String Country = user.getCountry();
			String ZipCode = user.getZipCode();
			String UserID = user.getUserID();
			String Password = user.getPassword();
			String SecurityCode = user.getSecurityCode();
			String RWARegNo = user.getRWARegNo();
			int userType = user.getUserType();

			user.setValid(false);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");

			System.out.println("Step 4 : store procedure Patameter setting ");
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateLoginUser](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ComVar.myStat.setString(1, Fname);
			ComVar.myStat.setString(2, Lname);
			ComVar.myStat.setString(3, MobileNO);
			ComVar.myStat.setString(4, EmailId);
			ComVar.myStat.setString(5, Address);
			ComVar.myStat.setString(6, BlockNO);
			ComVar.myStat.setString(7, Sector);
			ComVar.myStat.setString(8, city);
			ComVar.myStat.setString(9, State);
			ComVar.myStat.setString(10, Country);
			ComVar.myStat.setString(11, ZipCode);
			ComVar.myStat.setString(12, UserID);
			ComVar.myStat.setString(13, Password);
			ComVar.myStat.setString(14, SecurityCode);
			ComVar.myStat.setString(15, RWARegNo);
			ComVar.myStat.setInt(16, userType);
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);

			System.out.println("Step 5 : store procedure execution started ");
			System.out.println("userType:" + userType);

			boolean spExecuteStatus = ComVar.myStat.execute();

			
			System.out.println(ComVar.myStat.execute());
			if (spExecuteStatus) {
				System.out.println("Error in Execution of Strore procedure[VerifyUserEmailID]");
				user.setValid(false);
				return user;
			}
			System.out.println("Step 5 : Call : Store procedure Successfully Executed ");
			
			int SPStatus = ComVar.myStat.getInt(17);
			System.out.println("boolean spExecuteStatus :" + spExecuteStatus + " SPStatus :" + SPStatus);
			if (SPStatus == 1) {
				user.setValid(true);
				System.out.println("User Created Successfully:");
			} else {
				System.out.println("Fail to Create User:");
			}
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