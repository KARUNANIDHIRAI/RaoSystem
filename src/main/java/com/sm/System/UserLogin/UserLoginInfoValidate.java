package com.sm.System.UserLogin;

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

import com.raoSystem.password.SendOTP;

public class UserLoginInfoValidate extends HttpServlet {
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
				String Captcha1 = loginObj.get("LblCaptcha");//(String) loginObj.get("Captcha");	
				String valpwd="Invalid";
				if(!Captcha1.equals(loginObj.get("LblCaptcha"))) {
					boolean valEmail = HDAOUserLogin.validEmail(loginObj.get("email"), erMsg);
					if(valEmail) {
						SendOTP mail = new SendOTP();	
						String otp=mail.emailsend(loginObj.get("email")); // call method to send OTP
						if(otp.length()>=4){  
							erMsg += "OTP sent ";
							loginObj.put("OTP", otp);
							boolean valOTP = HDAOUserLogin.UpdateULOTP(loginObj, erMsg); //updage OPT in loginUser for validate OTP
							if(valOTP) {
								valpwd="Valid";
							}
						}  
					}
				}
				out.print(valpwd);
				out.flush();
				erMsg += "Step 4. HDOA OK:,";
				break;
			case "chkOT":
				erMsg += "Step 1.1 Validate OTP Start: ,";
				UserLoginModel ULOTP = new UserLoginModel(request.getParameter("email"),request.getParameter("otpNo") , "");
				System.out.println(" pkotpval: " + ULOTP.getOtp()+ " , email : " + ULOTP.getEmail());
				boolean valOTP = HDAOUserLogin.ValidateOTP(ULOTP, erMsg);
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
						boolean validEmail = HDAOUserLogin.UpdatePassword(pwdObj, erMsg);
						
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
				erMsg += "; 1.1 Validation Start: ";
				String UIDR = request.getParameter("userID");
				HashMap<String, String> uRIDObj = new HashMap<>();  
				uRIDObj.put("email", UIDR);
				erMsg +=  UIDR+ " ," ;
				String uStatus = "Invalid";
				String otpSent = "Otp Sent Fail";
				String valEmail = HDAOUserLogin.ValidateUIDR(UIDR, erMsg);
				
				erMsg += " HDAO OK " + valEmail ;
				if(valEmail!= null) { // email not null
					uRIDObj.put("email", valEmail);
					System.out.println("pkrEmail: " + uRIDObj.get("email"));
					SendOTP mail = new SendOTP();	
					String otp=mail.emailsend(valEmail); // call method to send OTP
					
					if(otp.length()>=1){  // opt not null
						otpSent = "OTP sent ";
						uRIDObj.put("OTP", otp);
						System.out.println("pk Otp: " + uRIDObj.get("OTP"));
						boolean uIRDOTP = HDAOUserLogin.UpdateULOTP(uRIDObj, erMsg); //updage OPT in loginUser for validate OTP
						if(uIRDOTP) {
							uStatus = "Valid";
						}
			        } 
				}
				erMsg += otpSent + "OTP Update" +uStatus ;
				out.print(uStatus);
				out.flush();
 				break; 
			case "VUIRD" :
				erMsg += "; 1.1 Validation Start: ";
				boolean uidstat = false;
			    UserLoginModel uIRDObj = new UserLoginModel();
			    uIRDObj = updateUidValue(uIRDObj, request);
				erMsg +=  " pkotpval: " + uIRDObj.getOtp()+ " , email : " + uIRDObj.getEmail()+ " ,";
				UserLoginModel valOTP1 = HDAOUserLogin.sentUIRD(uIRDObj, erMsg);
				System.out.println("pkotp: "+ valOTP1.getEmail());
				if(valOTP1.getEmail().length()>=5) {
					SendOTP mail = new SendOTP();	
						uidstat=mail.uidSend((String)valOTP1.getEmail(),(String)valOTP1.getEmail()); // call method to send OTP
				}
				String uirdMessage =uidstat?"Thanks your user login ID sent to your registered email Successfully.":
					                "Technical Error: User Login fail to recover, contact Technical Team";
				erMsg += " UIRD sent Status : " + uidstat;
				session.setAttribute("Message",uirdMessage);
		        RequestDispatcher rd1=request.getRequestDispatcher("SuccessMsg.jsp");  
		        rd1.forward(request, response);  
 				break;     
			}
		} catch (IOException e) {
			System.out.println("Technical Error: \n"+ e);
		} catch (EmailException e) {
			System.out.println("Email Exception: \n"+ e);
		}finally {
			session.setAttribute("Message","Technical Error");
			System.out.println(erMsg);
		}
	}

	private UserLoginModel updateUidValue(UserLoginModel uIRDObj, HttpServletRequest request) {
		uIRDObj.setEmail(request.getParameter("ulRID"));
		uIRDObj.setOtp(request.getParameter("uoptNo"));
		return uIRDObj;
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
