package com.raoSystem.login;
import com.raoSystem.constants.*;
import com.raoSystem.daoConnection.ConnectionManager;;

public class DaoLogin {
    public static UserLogin check(UserLogin user) {	
		try {
			String login = user.getLoginID();    
		    String password = user.getPassword(); 
			user.setValid(false);
			System.out.println("Step 3 : Call Connection Manager");
	        
	        ComVar.Conn= ConnectionManager.getConnection();
			System.out.println("Step 4 : store procedure Patameter setting ");
	        ComVar.myStat = ComVar.Conn.prepareCall("{call UserLoginCheck(?,?)}");
	        ComVar.myStat.setString(1,login);
	        ComVar.myStat.setString(2, password);
			System.out.println("Step 4 : store procedure execution started ");
	        ComVar.myStat.execute();
			System.out.println("Step 4 : Call : Store procedure Successfully Executed ");
	        
	        ComVar.prst = ComVar.myStat.getResultSet();
		    if (ComVar.prst.next()) { 	
		    	user.setValid(true);
		    	String fName = ComVar.prst.getString("FName");
		        String lName = ComVar.prst.getString("LName");
		        user.setfName(fName);
		        user.setlName(lName);
	       		System.out.print("\n login verifiedd:");
		    } else {
				user.setValid(false);
		    	System.out.print("\n login not verifiedd:");
		    }
			/*
			 * System.out.print("knrai boolean:2"); ComVar.prst.close();
			 * ComVar.Conn.close();
			 */
		 }catch (Exception e) {
		        System.out.println( "\n ERROR :" + e);
		        e.printStackTrace();
				user.setValid(false);
	    }finally {
		    	if (ComVar.prst != null) {
				try {ComVar.prst.close();} 
				catch (Exception e) {}
				ComVar.prst = null;
			}
			if (ComVar.myStat != null) {
				try {ComVar.myStat.close();} 
				catch (Exception e) {}
				ComVar.myStat = null;
			}
			if (ComVar.Conn != null) {
				try { ComVar.Conn.close();	} 
				catch (Exception e) {}
				ComVar.Conn = null;
			}
	    }
		return user;
    }
}
