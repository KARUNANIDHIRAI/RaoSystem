package com.raoSystem.userRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserRegCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		UserRegInit user = new UserRegInit();
		
		user.setFname(request.getParameter("Fname"));
		user.setLname(request.getParameter("Lname"));
		user.setEmailId(request.getParameter("email"));
		user.setMobileNO(request.getParameter("Mobile"));
		user.setRWARegNo(request.getParameter("rwaRegNo"));
		user.setUserType(Integer.parseInt(request.getParameter("UserType")));
		user.setUserID(request.getParameter("userLogInId"));
		user.setPassword(request.getParameter("UserLoginPassword"));
		user.setSecurityCode(request.getParameter("LoginSecurityCode"));
		user.setAddress(request.getParameter("paddress"));
		user.setBlockNO(request.getParameter("pblock"));
		user.setSector(request.getParameter("psector"));
		user.setCity(request.getParameter("pcity"));
		user.setState(request.getParameter("pstate"));
		user.setCountry(request.getParameter("pcountry"));
		user.setZipCode(request.getParameter("ppincode"));
		System.out.println("Step1: model create successfully");
		try {
		DaoUserRegistration userReg = new DaoUserRegistration();

		user = userReg.UserCheck(user);
		}catch (Exception e){
			
		}
		
	}

}
