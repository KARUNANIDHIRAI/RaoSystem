package com.raoSystem.password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GenOTPmailOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String emailid = request.getParameter("inputEmailID");
		String rwaReg = (String) request.getParameter("inputRwaRegNo");
		request.getSession(false).setAttribute("mailId", emailid);
		request.getSession(false).setAttribute("RwaReg", rwaReg);
		
		System.out.println("Step 1: UserLogin");
		System.out.println("========start sending email===========");
		try {
			SendOTP mail = new SendOTP();	
			System.out.println(emailid);
			String otp=mail.emailsend(emailid);
			request.getSession(false).setAttribute("OTP", otp);
			System.out.println("OTP Generated Successfully and page forward to OTPReceipt.jsp");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("OTPReceipt.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error in Generate OTP :" + e);
			request.getSession(false).setAttribute("InvalidFPWDMsg", "Error in Generate OTP :");
			response.sendRedirect("PasswordMsg.jsp");
		}
	
	
	}

}


