package com.raoSystem.password;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class verifyUserLoginID
 */
public class verifyUserLoginID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	@override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("");

		System.out.println("Step 1: User Email ID or Mobile No.");
		VerifyUserID user = new VerifyUserID();
		user.setUserId(request.getParameter("inputEmailID"));
		user.setRwaRegNo(request.getParameter("inputRwaRegNo"));
		user.setPwd(request.getParameter("inputPassword"));
		user.setConfPwd(request.getParameter("inputconfPassword"));
		
		 if(user.getPwd()!= user.getConfPwd()) {
			session.setAttribute("InvalidFPWDMsg","Password and Confirmed Password Mismatched");
			response.sendRedirect("ForgetPassword.jsp");
		 }
		System.out.println("Step 2 : Call DAOVerifyUserID");
		try {
			user= DAOVerifyUserID.check(user);
			System.out.println(user.isValid());
			if(user.isValid()==true){
				System.out.println("knrai");
				session.removeAttribute("InvalidFPWDMsg");
				response.sendRedirect("PasswordMsg.jsp");
			}else {
	            System.out.println("Invalid Email ID / Mobile No.") ;
				session.setAttribute("InvalidFPWDMsg","Invalid Email ID / Registraion No");
				response.sendRedirect("ForgetPassword.jsp");
			}
		} catch(Exception e){
			System.out.println("Error in Check function data store procedure");
			session.setAttribute("ErrMsg","Execution issues  ");
		}

	}

}
