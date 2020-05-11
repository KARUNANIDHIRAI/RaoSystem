package com.raoSystem.password;

import java.sql.Types;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOVerifyUserID {
    public static SetGetUserID check(SetGetUserID user) {	
		  String emailID = user.getUserId(); 
		  String rwaRegno = user.getRwaRegNo();
		  String Pwd = user.getPwd();

		  user.setValid(false);
		  System.out.println("Step 3 : Call Connection Manager " +Pwd );
		  try {
	        ComVar.Conn= ConnectionManager.getConnection();
			System.out.println("Step 4 : store procedure Patameter setting ");
	        ComVar.myStat = ComVar.Conn.prepareCall("{call UpdatePassword(?,?,?,?)}");
	        ComVar.myStat.setString(1,emailID);
	        ComVar.myStat.setString(2,rwaRegno);
	        ComVar.myStat.setString(3,Pwd);
	    	ComVar.myStat.registerOutParameter(4,Types.INTEGER);
	        System.out.println("Step 4 : store procedure execution started ");
	        
	        boolean spExecuteStatus=ComVar.myStat.execute();
	        System.out.println(ComVar.myStat.execute());
			if(spExecuteStatus) { 
				System.out.println("Error in Execution of Strore procedure[VerifyUserEmailID]");
			  return  user;
			}
			System.out.println("Step 5 : Call : Store procedure Successfully Executed ");
	        int SPStatus= ComVar.myStat.getInt(4);
	        System.out.println("boolean spExecuteStatus :" +spExecuteStatus + " SPStatus :" + SPStatus );
	    	if(SPStatus==1) {	    		
	    		user.setValid(true);
	    		System.out.println("login verified:");
	    	} else {
	    		System.out.println("login not verified:");
	    	}
		 }catch (Exception e) {
		        System.out.println( "ERROR :" + e);
				user.setValid(false);
				e.printStackTrace();

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
