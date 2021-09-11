package com.sm.System.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sm.System.Faculty.FacultyMemberModel;
import com.sm.System.Faculty.HDAOFaculty;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SchoolInformation.HDAOSchoolInfo;
import com.sm.System.UserLogin.HDAOUserLoginSMSI;
import com.rao.System.UserLogin.UserLoginModel;
import com.raoSystem.password.SendOTP;

/**
 * Servlet implementation class UserLoginSMSI
 */
public class UserLoginSMSI extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String erMsg= "Step1: Start";
		String Action = request.getParameter("Action");
		erMsg += " Action: ";
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
				HashMap<String, String> userLogin  = new HashMap<>();
				userLogin = UpdateLoginSMSIPageVal(userLogin, request, session);
				showLoginPageVal(userLogin);
				String Captcha = (String) userLogin.get("Captcha");	
				String lableCaptcha = userLogin.get("LblCaptcha").toString();
				userLogin = HDAOUserLoginSMSI.getLoginPasswordValidate(userLogin);
				String schName = HDAOSchoolInfo.getSchoolName(userLogin.get("RegNo"));
				List<String> sMFCMemberInfo=new ArrayList<>() ;
				sMFCMemberInfo= HDAOFaculty.getFMInformation(userLogin.get("RegNo"),userLogin.get("OutputLoginID"));
				//|| !PasswordEncoder.matches(loginObj1.get("PWD"),loginObj1.get("password"))
				if (!Captcha.equals(lableCaptcha) || !userLogin.get("InputPWD").equals(userLogin.get("OutputPWD"))) {	
					String hDAOMessage= "Invalid Login Credential ! ";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SMSISystem/SMSIUserLogin/UserLoginSMSI.jsp");
				}else {
					initSessionval( session);
					session.setAttribute("RegNo"    , userLogin.get("RegNo"));
					session.setAttribute("UserID"   , userLogin.get("UserID"));
					session.setAttribute("UserName" , userLogin.get("UserName"));
					session.setAttribute("School"   , schName);
					session.setAttribute("FMCode"   , ((String)sMFCMemberInfo.get(0)));
					session.setAttribute("FMName"   , ((String)sMFCMemberInfo.get(1)));
					response.sendRedirect("SMSISystem/SMSIMainPage.jsp");
				}
				erMsg += "Step 4. HDOA OK: ,";
				break;
			case "sentEmail":
				HashMap<String, String> loginObj = new HashMap<>(); 
				loginObj = UpdatePWDRestPageVal(loginObj, request, session);
				
				//loginObj1 = UpdatePWDRestPageVal(loginObj, request, session);
				erMsg += "Step 1.1 sent email Form value Get OK: ,";
				showLoginPageVal(loginObj);
				
				erMsg += "Step 2 Show value OK: ,";
				String Captcha1 = loginObj.get("LblCaptcha");//(String) loginObj.get("Captcha");	
				String valpwd="Invalid";
				if(!Captcha1.equals(loginObj.get("LblCaptcha"))) {
					out.print(valpwd);
					out.flush();
				}else {
					boolean valEmail = HDAOUserLoginSMSI.validEmail(loginObj.get("email"), erMsg);
					if(valEmail) {
						SendOTP mail = new SendOTP();	
						String otp=mail.emailsend(loginObj.get("email")); // call method to send OTP
						if(otp.length()>=4){  
							erMsg += "OTP sent ";
							loginObj.put("OTP", otp);
							boolean valOTP = HDAOUserLoginSMSI.UpdateULOTP(loginObj, erMsg); //updage OPT in loginUser for validate OTP
							if(valOTP) {
								out.print("Valid");
								out.flush();
							}else {
								out.print(valpwd);
								out.flush();
							}	
						}else{  
							erMsg += "OTP Not sent Technical Error ";
							out.print(valpwd);
							out.flush();
				        }  
					}else {
						erMsg += "Invalid User ID ";
						out.print(valpwd);
						out.flush();
					}
				}
				erMsg += "Step 4. HDOA OK:,";
				break;
			case "chkOT":
				erMsg += "Step 1.1 Validate OTP Start: ,";
				UserLoginSMSIModel ULOTP = new UserLoginSMSIModel(request.getParameter("email"),request.getParameter("otpNo") , "");
				System.out.println(" pkotpval: " + ULOTP.getOtp()+ " , email : " + ULOTP.getEmail());
				boolean valOTP = HDAOUserLoginSMSI.ValidateOTP(ULOTP, erMsg);
			    System.out.println("valOTP: "+ valOTP);
				erMsg += "Step 4 HDAO OK: ,";
				String OPTValid = valOTP?"Valid OTP" :"Invalid OTP" ;	
				erMsg += " 4.1 " +OPTValid + " OK:,";
				out.print(OPTValid);
				out.flush();
				break;
			case "chkValidity":
				System.out.println("Step 1.1 : chkValidity start");
				HashMap<String, String> pwdObj = new HashMap<>();
				pwdObj = UpdatePWDObj(pwdObj, request, session);
				erMsg += "Step 1.2 update form Value OK: ,";
				showPwdObj(pwdObj);
				erMsg += "Step 2. Show Object value OK: ,";
		    	String pwdMessage = "Tehnical Problem ! Passwoed Security Mismatch.";
		    	String password = pwdObj.get("password");
				if(password.equals(pwdObj.get("cPassword"))) {
					BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder(); 
				    String pwdBcrypt = pwdEncoder.encode(pwdObj.get("password"));
				    if(pwdEncoder.matches(pwdObj.get("password"),pwdBcrypt) ) {
				    	pwdObj.put("password",pwdBcrypt);
						erMsg += "Step 2.1 PWD Encrption OK: ,";
						boolean validEmail = HDAOUserLoginSMSI.UpdatePassword(pwdObj, erMsg);
						
						erMsg += "Step 4. execute HDOA PWD OK:" +validEmail + " , ";
						if(validEmail) {
					    	pwdMessage = "Thanks! password reset Successfully.";
						}
				    }
				}    
				session.setAttribute("Message",pwdMessage);
		        RequestDispatcher rd=request.getRequestDispatcher("SuccessMsg.jsp");  
		        rd.forward(request, response);  

				break;
			case "uLRD" :
				erMsg += "Step 1.1 Validate OTP Start: ,";
				String UIDR = request.getParameter("ulRID");
				String uStatus = "Invalid";
				String otpSent = "Otp Sent Fail";
				System.out.println(" ulRID: "+UIDR);
				String valEmail = HDAOUserLoginSMSI.ValidateUIDR(UIDR, erMsg);
				erMsg += " HDAO OK " + valEmail ;
				if(valEmail.length()>=1) {
					SendOTP mail = new SendOTP();	
					String otp=mail.emailsend(valEmail); // call method to send OTP
					if(otp.length()>=4){  
						otpSent = "OTP sent ";
						uStatus = "Valid";
			        } 
				}
				erMsg += otpSent;
				out.print(uStatus);
				out.flush();
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

	private void initSessionval(HttpSession session) {
		session.removeAttribute("RegNo");
		session.removeAttribute("UserID");
		session.removeAttribute("UserName");
		session.removeAttribute("School");
		session.removeAttribute("FMCode");
		session.removeAttribute("FMName");
		session.removeAttribute("KNRAI");
		System.out.println("RegNo, UserID, UserName, School, FMCode, FMName");
		// TODO Auto-generated method stub
	}


	private void showPwdObj(HashMap<String, String> pwdObj) {
		System.out.println("Show Change Password"+ pwdObj);
	}

	private HashMap<String, String> UpdatePWDObj(HashMap<String, String> pwdObj, HttpServletRequest request,HttpSession session) {
		pwdObj.put("password" , request.getParameter("Pwd"));
		pwdObj.put("cPassword", request.getParameter("CPwd"));
		pwdObj.put("UID"      , request.getParameter("email"));
		pwdObj.put("OTP"      , request.getParameter("optNo"));
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
		String msg = SMFixedValue.USER + SMFixedValue.LOGIN + SMFixedValue.ACTION_CRITERIA + SMFixedValue.INPUT_VALUES;
		try {
			for (HashMap.Entry<String, String> e : loginObj.entrySet()) {
	            System.out.println(e.getKey() + " " + e.getValue());
		 }       
			msg += SMFixedValue.END +  SMFixedValue.USER + SMFixedValue.LOGIN + SMFixedValue.ACTION_CRITERIA;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg );
		}
	} 

	private HashMap<String, String> UpdateLoginSMSIPageVal(HashMap<String, String> loginObj, HttpServletRequest request, HttpSession session) {
		String msg = SMFixedValue.ACTION_UPDATING + SMFixedValue.USER + SMFixedValue.LOGIN + SMFixedValue.ACTION_CRITERIA;
		try {
			loginObj.put("Captcha", (String) request.getParameter("Captcha"));
			loginObj.put("LblCaptcha",(String) session.getAttribute("ucpname"));
			loginObj.put("InputUID", request.getParameter("email"));
			loginObj.put("InputPWD", request.getParameter("Pwd"));
			msg += SMFixedValue.ACTION_UPDATING +  SMFixedValue.ACTION_CRITERIA+  SMFixedValue.COMPLETED;
		} catch (Exception e) {
			msg += SMFixedValue.EXEC_CATCH_MSG +  e;			
		}finally  {
			System.out.println("\n"+ msg );
		}
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
		
		//String captcha ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer captchBuffer = new StringBuffer();
		Random random = new Random();
		while (captchBuffer.length()<captchalength) {
			int index = (int) (random.nextFloat()*SMFixedValue.CAPTCHA.length());
			captchBuffer.append(SMFixedValue.CAPTCHA.substring(index,index+1));
		}
		return captchBuffer.toString();
	}
}
