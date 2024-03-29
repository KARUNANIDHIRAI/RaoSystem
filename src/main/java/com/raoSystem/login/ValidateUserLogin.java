package com.raoSystem.login;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rao.System.UserLogin.HDAOUserLogin;
import com.raoSystem.password.SendOTP;


public class ValidateUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//processRequest( request, response);
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
			case "refreshCaptcha":
				String captcha = processRequest(request, response);
				session.setAttribute("ucpname", captcha);
				System.out.println("step 2: Refresh Captcha OK." + captcha);
				out.print(captcha);
				out.flush();
				break;
			case "Action" :
				BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder(); 
				HashMap<String, String> loginObj1 = new HashMap<>();
				loginObj1 = UpdateLoginPageVal(loginObj1, request, session);
				erMsg += "Step 1.1 Form value Get OK: ,";
				showLoginPageVal(loginObj1);
				
				erMsg += "Step 2 Show value OK: ,";
				String Captcha = loginObj1.get("Captcha");//(String) loginObj.get("Captcha");	
				String lableCaptcha = loginObj1.get("LblCaptcha");
				loginObj1 = HDAOUserLogin.validPassword(loginObj1, erMsg);
				if(!Captcha.equals(lableCaptcha)|| !loginObj1.containsKey("password") || !PasswordEncoder.matches(loginObj1.get("PWD"),loginObj1.get("password"))) {
					String hDAOMessage= "Invalid User id / Password ! ";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("UserLogin/UserLogin.jsp");
				}else {
					session.setAttribute("UID", loginObj1.get("UID"));
					session.setAttribute("RwaNo", loginObj1.get("RwaNo"));
					response.sendRedirect("RwaHomePage.jsp");
				}
				erMsg += "Step 4. HDOA OK: ,";
				break;
			case "sentEmail":
				HashMap<String, String> loginObj = new HashMap<>();     
				loginObj1 = UpdatePWDRestPageVal(loginObj, request, session);
				erMsg += "Step 1.1 sent email Form value Get OK: ,";
				showLoginPageVal(loginObj);
				
				erMsg += "Step 2 Show value OK: ,";
				String Captcha1 = loginObj.get("Captcha");//(String) loginObj.get("Captcha");	
				
				if(!Captcha1.equals(loginObj.get("LblCaptcha"))) {
					String hDAOMessage= "Invalid Captcha entered !";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("UserLogin/OTPValidate.jsp");
				}else {
					boolean valEmail = HDAOUserLogin.validEmail(loginObj.get("email"), erMsg);
					if(valEmail) {
						SendOTP mail = new SendOTP();	
						String otp=mail.emailsend(loginObj.get("email"));
						erMsg += "OTP sent";
						if(otp.length()>=4){  
//					        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/OTPValidate.jsp");  
					        RequestDispatcher rd=request.getRequestDispatcher("UserLogin/Watchword.jsp");  
					        rd.forward(request, response);  
						}else{  
							out.print("Sorry UserName or Password Error!");  
						    RequestDispatcher rd=request.getRequestDispatcher("UserLogin/UserLoginPwdReset.jsp");  
						    rd.include(request, response);  
				        }  
					}else {
						erMsg += "Error in sending OTP! Check email/Mobile";
						out.print("Sorry UserName or Password Error!");  
					    RequestDispatcher rd=request.getRequestDispatcher("UserLogin/UserLoginPwdReset.jsp");  
					    rd.include(request, response);  
					}
				}
				erMsg += "Step 4. HDOA OK:,";
				break;
			case "chkOT":
				System.out.println("checking opt");
				String OTP = request.getParameter("optNo");
				String email = "prashantrai1208@gmail.com";
				String rwaNo = "MK103";
				erMsg += "Step 1.1 chk otp Form value Get OK: ,";
				boolean valEmail = HDAOUserLogin.UpdateOTP(OTP, email,rwaNo, erMsg);
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

						boolean validEmail = HDAOUserLogin.UpdatePassword(pwdObj, erMsg);
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
		} catch (EmailException e) {
			System.out.println("Email Exception: \n"+ e);
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

	private HashMap<String, String> UpdatePWDRestPageVal(HashMap<String, String> loginObj, HttpServletRequest request,
		HttpSession session) {
		loginObj.put("Captcha", request.getParameter("ulCaptcha"));
		loginObj.put("LblCaptcha",request.getParameter("refreshCaptcha"));
		loginObj.put("email", request.getParameter("email"));
		return loginObj;
	}

	private void showLoginPageVal(HashMap<String, String> loginObj) {
		 for (HashMap.Entry<String, String> e : loginObj.entrySet()) {
	            System.out.println(e.getKey() + " " + e.getValue());
		 }       
	} 

	private HashMap<String, String> UpdateLoginPageVal(HashMap<String, String> loginObj, HttpServletRequest request, HttpSession session) {
		loginObj.put("Captcha", request.getParameter("Captcha"));
		loginObj.put("LblCaptcha",(String) session.getAttribute("ucpname"));
		loginObj.put("UID", request.getParameter("email"));
		loginObj.put("PWD", request.getParameter("Pwd"));
		return loginObj;
	}

	protected String  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Porgma", "No-Cache");
		response.setDateHeader("Max-Age", 0);
		String captcha = generateCapcha(5);
		return captcha;
	}
	private String generateCapcha(int captchalength) {
		String captcha ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<captchalength) {
			int index = (int) (random.nextFloat()*captcha.length());
			captchBuffer.append(captcha.substring(index,index+1));
		}
		return captchBuffer.toString();
	}
}
