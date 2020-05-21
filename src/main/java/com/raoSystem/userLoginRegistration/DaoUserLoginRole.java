package com.raoSystem.userLoginRegistration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;


public class DaoUserLoginRole {
	   public List<userRoleType> userLoginRoleCheck() {	

		    List<userRoleType> listCategory = new ArrayList<>();

		    System.out.println("Step 3 : Call Connection Manager");
		    try {
		        ComVar.Conn= ConnectionManager.getConnection();
				System.out.println("Step 4 : store procedure Patameter setting ");

				ComVar.callableStat = ComVar.Conn.prepareCall("{call UserType()}");
				System.out.println("Step 4 : store procedure execution started ");
		        
				ComVar.callableStat.execute();
				System.out.println("Step 4 : Call : Store procedure Successfully Executed ");
		        
		        ComVar.prst = ComVar.callableStat.getResultSet();

		        
		        while (ComVar.prst.next()) {
	                String UserName = ComVar.prst.getString("roleName");
	                userRoleType userCategory = new userRoleType(UserName);
	                listCategory.add(userCategory);
	                System.out.println(UserName);
	            }          
		    
		    }catch (SQLException ex) {
			        System.out.println( "\n ERROR :" + ex);
		    }
			finally {
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
			return 	listCategory;
	   }
}

