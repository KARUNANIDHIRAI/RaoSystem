package com.raoSystem.userRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step1: model creating ");

		UserRegInit user = new UserRegInit();
		
		user.setEmailId(request.getParameter("EmailId"));
		user.setRWARegNo(request.getParameter("rwaRegNo"));
		user.setTranType("ADD");
		try {
			user = DaoSearchUser.UserCheck(user);
			if (user.isValid()) {
			    switch(user.getSPstatus()){  
			    case 0:   // Record Not Exist [DB]
			    	session.setAttribute("Message"," Invalid Email Id  / RWA Registraion No.");
		            System.out.println("Invalid Email Id  / RWA Registraion No.") ;
			    	response.sendRedirect("SearchUser.jsp");
			    	break;
			    case 1:   // Record Exist [DB]

			    	session.setAttribute("EmailID", user.getEmailId());
			    	session.setAttribute("RwaRegNo",user.getRWARegNo());
			    	session.setAttribute("Fname",user.getFname());
			    	session.setAttribute("Lname",user.getLname());
			    	session.setAttribute("UserType",user.getUserType());
			    	session.setAttribute("UserId",user.getUserID());
			    	session.setAttribute("Mobile",user.getMobileNO());

			    	session.setAttribute("Address", user.getAddress());
			    	session.setAttribute("Block",user.getBlockNO());
			    	session.setAttribute("Sector",user.getSector());
			    	session.setAttribute("City",user.getCity());
			    	session.setAttribute("State",user.getState());
			    	session.setAttribute("Country",user.getCountry());
			    	session.setAttribute("PinCode",user.getZipCode());

			    	response.sendRedirect("userInfoPreview.jsp");
			    	break;  
			    case 2:   
			    	session.setAttribute("InvalidFPWDMsg"," Invalid Email Id  / RWA Registraion No.");
		            System.out.println("Invalid Email Id  / RWA Registraion No.") ;
			    	break;  
			    default:  
			    	session.setAttribute("InvalidFPWDMsg"," Technical Issue ! Please contact to System Admin ");
			    	break;  
				}
			} else {
				if (user.getSPstatus()==2){
				} else {
				}
			}
		}catch (Exception e){
            System.out.println("Technical Issue ! Please contact to System Admin ") ;
	    	session.setAttribute("InvalidFPWDMsg"," Catch Technical Issue (User Not Created)! Please contact to System Admin ");
		}
	}

	}


