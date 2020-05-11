package com.raoSystem.createUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class testarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DaoUserRole UserRoleDao = new DaoUserRole();
	   	ArrayList<UserModel>  listCatagory = UserRoleDao.userRoleCheck();
        
	    System.out.println(listCatagory.size());
	
	  //Getting Iterator  
	    Iterator itr=listCatagory.iterator();  
	    //traversing elements of ArrayList object  
	    while(itr.hasNext()){  
	    	UserModel st=(UserModel)itr.next();  
	      System.out.println(st.getUserRole());  
	    }  
	
	}	
	}

