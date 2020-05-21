package com.raoSystem.userRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditLoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		System.out.println("Step1: model creating ");

		UserRegInit user = new UserRegInit();
		
		user.setEmailId(request.getParameter("email"));
		user.setRWARegNo(request.getParameter("rwaRegNo"));
		user.setAddress(request.getParameter("paddress"));
		user.setBlockNO(request.getParameter("pblock"));
		user.setSector(request.getParameter("psector"));
		user.setCity(request.getParameter("pcity"));
		user.setState(request.getParameter("pstate"));
		user.setCountry(request.getParameter("pcountry"));
		user.setZipCode(request.getParameter("ppincode"));
		
		user.setTranType("EDIT");
		try {
			user = DaoSearchUser.UserCheck(user);
			System.out.println("check 1");	
			if (user.isValid()) {
				System.out.println("check 2");	
			    switch(user.getSPstatus()){  
			    case 0:   
			    	session.setAttribute("Message"," User Information Not Exist. ");
			    	response.sendRedirect("SuccessMsg.jsp");
			    	break;  
			    case 1:   
			    	session.setAttribute("Message"," User Information Updated Successfully");
			    	response.sendRedirect("SuccessMsg.jsp");
			    	break;  
			    case 2:   
			    	session.setAttribute("Message"," Invalid Email Id  / RWA Registraion No.");
			    	response.sendRedirect("WebPages/SuccessMsg.jsp");
			    	break;  
			    default:  
			    	session.setAttribute("Message"," Technical Issue ! Please contact to System Admin ");
			    	response.sendRedirect("WebPages/SuccessMsg.jsp");
			    	break;  
				}
			} else {
				System.out.println("check 3");	
				if (user.getSPstatus()==2){
				} else {
				}
			}
		}catch (Exception e){
			System.out.println("knrai 3 return from DaoSearchUser");
            System.out.println("Technical Issue ! Please contact to System Admin ") ;
	    	session.setAttribute("InvalidFPWDMsg"," Catch Technical Issue (User Not Created)! Please contact to System Admin ");
		}
	
	}

}
