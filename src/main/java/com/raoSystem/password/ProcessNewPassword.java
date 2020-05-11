package com.raoSystem.password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ProcessNewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step 1: UserLogin");
		SetGetUserID user = new SetGetUserID();
		user.setUserId((String)request.getSession(false).getAttribute("mailId"));
		user.setRwaRegNo((String)request.getSession(false).getAttribute("RwaReg"));
		user.setPwd( (String)request.getParameter("inputPassword"));
		user.setConfPwd((String)request.getParameter("inputconfPassword"));

		request.getSession(false).removeAttribute("mailId");
		request.getSession(false).removeAttribute("rwaReg");
		request.getSession(false).removeAttribute("OTP");

		if( (user.getPwd()==null) || (user.getRwaRegNo()==null) || (user.getUserId()==null)) {
			session.setAttribute("InvalidFPWDMsg","Invalid Email ID / Registraion No");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordUpdateFail.jsp");
			requestDispatcher.forward(request, response);
		}
		try {
			if (user.getPwd().equals(user.getConfPwd())){
				request.getSession(false).removeAttribute("InvalidFPWDMsg");
			}else {
				System.out.println("MisMatchPwd:"+ session.getAttribute("MisMatchPwd"));
				session.setAttribute("InvalidFPWDMsg", "Mismatch Password and Confirm Password");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordMsg.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error in Password process step1");
			session.setAttribute("InvalidFPWDMsg", "Error in Password process step1");
			response.sendRedirect("PasswordMsg.jsp");
		}
		
		try {
			
			BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder(); 
		    String Password = PasswordEncoder.encode(user.getPwd());
		    System.out.println("Compare 2:"+ PasswordEncoder.matches(user.getPwd(),Password));
			System.out.println("Step 2 : Call DAOVerifyUserID");

			user= DAOVerifyUserID.check(user);
			if (user.isValid()) {	
				System.out.println("user.isValid() :" + user.isValid());	
				request.getSession(false).setAttribute("InvalidFPWDMsg", "Congratulation! Your Password Reset Successfully");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordMsg.jsp");
				requestDispatcher.forward(request, response);
				System.out.println("user.isValid() :" + user.isValid());	
			} else {
				System.out.println(" else user.isValid() :" + user.isValid());	
				request.getSession(false).setAttribute("InvalidFPWDMsg", "Invalid Password Credential Entered Email / RWA Reistration No.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordMsg.jsp");
				requestDispatcher.forward(request, response);
				System.out.println(" else user.isValid() :" + user.isValid());	
			}
			System.out.println(" if else end user.isValid() :" + user.isValid());	
	
		} catch(Exception e){
			System.out.println("Error in Check function data store procedure");
			request.getSession(false).setAttribute("InvalidFPWDMsg", "Technical issues! Please contact System Admin  ");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordMsg.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
