package com.raoSystem.createUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;
import com.raoSystem.userLoginRegistration.userRoleType;

public class DaoUserRole {
   public ArrayList<UserModel> userRoleCheck() {	

//	    List<UserModel> listCategory = new ArrayList<>();
	    ArrayList<UserModel> listCategory = new ArrayList<UserModel>(); 
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
	        	UserModel userCategory = new UserModel();
	        	userCategory.setUserRole(ComVar.prst.getString("roleName"));
//                String UserName = ComVar.prst.getString("roleName");
//                UserModel userCategory = new UserModel(UserName);
//                listCategory.add(userCategory);
                listCategory.add(userCategory);
//                System.out.println(UserName);
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
