package com.sm.System.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class ValidateULPasswordOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= "Step1: Start";
		String Action = request.getParameter("Action");
		System.out.println("Action :" + Action);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "chkOT":
				System.out.println("checking opt");
				String OTP = request.getParameter("optNo");
				String email = "prashantrai1208@gmail.com";
				String rwaNo = "MK103";
				erMsg += "Step 1.1 chk otp Form value Get OK: ,";
				boolean valEmail = HDAOUserLoginSMSI.UpdateOTP(OTP, email,rwaNo, erMsg);
				if(valEmail) {
					erMsg += "Step 4. Update OTP OK:" +valEmail + " , ";
			        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/Watchword.jsp");  
			        rd.forward(request, response);  
				}else {
					erMsg += "Step 4. Error in Update OTP:";
					out.print("Invalid OTP ! Please Enter Valid OTP ");  
			        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/OTPValidate.jsp");  
			        rd.forward(request, response);  
				}
				break;
			case "chkP":
				HashMap<String, String> pwdObj = new HashMap<>();
				pwdObj = UpdatePWDObj(pwdObj, request, session);
				erMsg += "Step 1.1 chk passwrod update JSP Value OK: ,";
				showPwdObj(pwdObj);
		    	String hDAOMessage= "Thanks! password reset Successfully.";
		    	String misMatchPwd = "Tehnical Problem ! Passwoed Security Mismatch.";
		    	String password = pwdObj.get("password");
				erMsg += "Step 2. Show Object value OK: ,";
				if(password.equals(pwdObj.get("cPassword"))) {
					BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder(); 
				    String pwdBcrypt = pwdEncoder.encode(pwdObj.get("password"));
				    if(pwdEncoder.matches(pwdObj.get("password"),pwdBcrypt) ) {
				    	pwdObj.put("password",pwdBcrypt);
						erMsg += "Step 2.1 PWD Encrption OK: ,";

						boolean validEmail = HDAOUserLoginSMSI.UpdatePassword(pwdObj, erMsg);
						erMsg += "Step 4. Update PWD OK:" +validEmail + " , ";
						if(validEmail) {
							session.setAttribute("Message",hDAOMessage );
					        RequestDispatcher rd=request.getRequestDispatcher("SuccessMsg.jsp");  
					        rd.forward(request, response);  
						}else {
							out.print(misMatchPwd);  
					        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/Watchword.jsp");  
					        rd.forward(request, response);  
						}
				    }else {
						erMsg += "Step 2.1 PWD Encrption Issue: ,";
						out.print(misMatchPwd);  
				        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/Watchword.jsp");  
				        rd.forward(request, response);  
				    }
				}else{
					erMsg += "Step 2.1 PWD Mistach: ,";
					out.print(misMatchPwd);  
			        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/Watchword.jsp");  
			        rd.forward(request, response);  
			    }
				break;
			}
		} catch (IOException e) {
			System.out.println("Technical Error: \n"+ e);
		}finally {
			System.out.println(erMsg);
		}
	}

	private void showPwdObj(HashMap<String, String> pwdObj) {
		System.out.println("Show Change Password"+ pwdObj);
	}

	private HashMap<String, String> UpdatePWDObj(HashMap<String, String> pwdObj, HttpServletRequest request,HttpSession session) {
		pwdObj.put("password" , request.getParameter("Pwd"));
		pwdObj.put("cPassword", request.getParameter("CPwd"));
		pwdObj.put("RWA"      , "MK103");
		pwdObj.put("UID"      , "RAMA@GMAIL.COM");
		return pwdObj;
	}


}
