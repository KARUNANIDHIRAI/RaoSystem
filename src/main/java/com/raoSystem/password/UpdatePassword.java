package com.raoSystem.password;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.raoSystem.login.DaoLogin;
import com.raoSystem.login.UserLogin;
import com.raoSystem.mails.Sendmail;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//checkPassword(request, response);    	
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step 1: UserLogin");
		
		try {
			String code= request.getParameter("inputPassword");
			String code1= request.getParameter("inputconfPassword");
			if (code.equals(code1)){
				request.getSession(false).removeAttribute("InvalidFPWDMsg");
			}else {
				System.out.println("MisMatchPwd:"+ session.getAttribute("MisMatchPwd"));
				session.setAttribute("InvalidFPWDMsg", "Mismatch Password and Confirm Password");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("NewPassword.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			response.sendRedirect("raoSystemErrorPage.jsp");
		}

		try {
			SetGetUserID user = new SetGetUserID();
			user.setUserId(request.getParameter("inputEmailID"));
			user.setRwaRegNo(request.getParameter("inputRwaRegNo"));
			user.setPwd(request.getParameter("inputPassword"));
			user.setConfPwd(request.getParameter("inputconfPassword"));
		    BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder(); 
		    String Password = PasswordEncoder.encode(user.getPwd());
		    System.out.println("Compare 2:"+ PasswordEncoder.matches(user.getPwd(),Password));
			System.out.println("Step 2 : Call DAOVerifyUserID");
			user= DAOVerifyUserID.check(user);
			if (user.isValid()) {	
				request.getSession(false).removeAttribute("InvalidFPWDMsg");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordMsg.jsp");
				requestDispatcher.forward(request, response);
			} else {
				session.setAttribute("InvalidFPWDMsg","Invalid Email ID / Registraion No");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch(Exception e){
			System.out.println("Error in Check function data store procedure");
			session.setAttribute("InvalidUserId","Technical issues! Please contact System Admin  ");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
			requestDispatcher.forward(request, response);
		}
	}
    
	protected void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Porgma", "No-Cache");
		response.setDateHeader("Max-Age", 0);
		HttpSession session = request.getSession(true);
		try {
			String code= request.getParameter("inputPassword");
			String code1= request.getParameter("inputconfPassword");
			if (code.equals(code1)){
				request.getSession(false).removeAttribute("MisMatchPwd");
			}else {
				session.setAttribute("MisMatchPwd", "Mismatch Password and Confirm Password");
			}
		} catch (Exception e) {
			session.setAttribute("MisMatchPwd", "Technical Issues ! Please Contact to Sysem Admin");
			System.out.println("Error in process Password :" + e);
		}
		
		
	}
   
}
