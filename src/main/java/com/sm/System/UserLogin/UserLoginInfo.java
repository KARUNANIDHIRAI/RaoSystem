package com.sm.System.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserLoginInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg = "Step 0: ";
		String valMsg= " ";
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		try {
			String ActType = request.getParameter("Action");
			erMsg += " Action : "+ActType;
			UserLoginSMSIModel uLModel = new  UserLoginSMSIModel();
			UserSMSIAddress uLAdd = new UserSMSIAddress();
			switch (ActType) {
			case "NewUser" :
				uLModel = UpdateUserModel(uLModel,request, uLAdd);
				ShowUserModel(uLModel);
     			valMsg=ValidateRwaReg(uLModel, valMsg);
				if(valMsg.length()>1) {
					session.setAttribute("Message",valMsg );
					response.sendRedirect("UserLogin/UserLoginNew.jsp");
				}else {
					BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder(); 
				    String Password = PasswordEncoder.encode(uLModel.getLPassword());
					String hDAOMessage= "THANKS! User Registerd Submit SUCCESSFULLY.";
				    if(PasswordEncoder.matches(uLModel.getLPassword(),Password)) {
				    	uLModel.setLPassword(Password);
						String uLStatus= HDAOUserLoginSMSI.newUser(uLModel, erMsg);
				    }else  {
						 hDAOMessage=  "TECHNICAL ERROR! User Info not submitted. Pls try after sometime.";
				    }
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}   
				break;
			case "EditUser" :
				uLModel = UpdateUserModel(uLModel,request, uLAdd);
				erMsg += "Step1: UserModel OK";
				ShowUserModel(uLModel);
				erMsg += "Step2: ShowModel OK";
				 valMsg=ValidateRwaReg(uLModel, valMsg);
				 System.out.println("Valsmsg: "+ valMsg+ "Errmsg: "+ erMsg);
				if(valMsg.length()>1) {
						System.out.println("\n error: "+ "ERROR IN :" +valMsg);
						session.setAttribute("Message",valMsg );
						response.sendRedirect("UserLogin/UserLoginNew.jsp");
				}else {
					Integer uLStatus= HDAOUserLoginSMSI.userLoginInfoEdit(uLModel,erMsg);
					String hDAOMessage= uLStatus==1?"THANKS! User Information updated SUCCESSFULLY.": "TECHNICAL ERROR! User Info not submitted. Pls try after sometime.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				break; 
			case "SearchList" :
				JsonArray ulArray = new JsonArray();
				ulArray= HDAOUserLoginSMSI.userlList(ulArray, erMsg);
				out.print(ulArray.toJson());
				out.flush();
				break;
			case "UserInfo" : // User Information load on page load for edit.
				JsonArray userInfoArray = new JsonArray();
				//userInfoArray = HDAOUserLogin.userLoginInfo(userInfoArray, erMsg);
				userInfoArray= HDAOUserLoginSMSI.userInfo(userInfoArray, erMsg);
				System.out.println("Servelet: " +userInfoArray );
				out.print(userInfoArray.toJson());
				out.flush();
				break;
				
			}
		} catch (Exception e) {
			System.out.println("Catch Exception: " + erMsg + "\n" + e);
			session.setAttribute("Message",valMsg );
			response.sendRedirect("SuccessMsg.jsp");
		} 
		
	}

	private String ValidateRwaReg(UserLoginSMSIModel uLModel, String valMsg) {
		try {
			if (uLModel.getRegNo().length()<=4)    {
				valMsg += "RWA Reg No, ";
			}if(uLModel.getFirstName().length()<3 ) {
				valMsg += "FName, ";
			}if (uLModel.getLastName().length()<3)      {
				valMsg += "Reg Date,";
			}if(uLModel.getMobile().length()<10) {
				valMsg += "Mobile No , ";
			}if(uLModel.getSecurity().length()<4) {
				valMsg += " Security , ";
			}if(uLModel.getEmail().length()<5) 	  {
				valMsg += "Login ID , ";
			}if(uLModel.getLPassword().length()<8){
				valMsg += " Password , ";
			}
			ArrayList<UserSMSIAddress> showuLAdd = new ArrayList<>();
			showuLAdd = (ArrayList<UserSMSIAddress>) uLModel.getUAdd();
			for (UserSMSIAddress uadd:showuLAdd) {
				if(uadd.getAddress().length()<3) {
					valMsg += " Address , ";
				}
				if(uadd.getCity().length()<3) {
					valMsg += " City , ";
				}if(uadd.getState().length()<3) {
					valMsg += " State , ";
				}if(uadd.getCountry().length()<2) {
					valMsg += " Country , ";
				}
			}
		} catch (Exception e) {
			valMsg += e;
			return valMsg;
		} finally {
			 System.out.println("Validation Information: "+ valMsg);
		}
		return valMsg;
	}

	private void ShowUserModel(UserLoginSMSIModel uLModel) {

		try {
			System.out.println("\nReg No." +uLModel.getRegNo( ) + ", FName : " +uLModel.getFirstName() + ", LName : " +uLModel.getLastName() +
					"User "+	uLModel.getlUType()+",  Mobile :" + uLModel.getMobile()
			+ ",  SecurityNo :" +uLModel.getSecurity() + ", Email :" + uLModel.getEmail() + ", Password: "+	uLModel.getLPassword() );

			ArrayList<UserSMSIAddress> showuLAdd = new ArrayList<>();
			showuLAdd = (ArrayList<UserSMSIAddress>) uLModel.getUAdd();
			for (UserSMSIAddress uadd:showuLAdd) {
				System.out.println("\nAddress:"+ uadd.getAddress() +" Sector :"+	uadd.getSector()+ ", City:" + uadd.getCity()
				+ ", State : "+ uadd.getState()+ ", Country"+ uadd.getCountry() + ", PinCode:" +	uadd.getPinCode());
			}
			System.out.println("\nEOF Show user model information");
		} catch (Exception e) {
			System.out.println("\ne Error in Show user model information \n" + e);
		}
	}
	private UserLoginSMSIModel UpdateUserModel(UserLoginSMSIModel uLModel, HttpServletRequest request, UserSMSIAddress uLAdd ) {
		try {
			uLModel.setRegNo(request.getParameter("RwaNo"));
			uLModel.setlUType(3);
			uLModel.setFirstName(request.getParameter("Fname"));
			uLModel.setLastName(request.getParameter("Lname"));
			uLModel.setMobile(request.getParameter("mobileNo"));
			uLModel.setSecurity(request.getParameter("SecurityNo"));
			uLModel.setEmail(request.getParameter("email"));
			uLModel.setLPassword(request.getParameter("Password"));
			uLModel.setStatus("A"); 
			uLModel.setCreatedBy("KNRAI");
			uLModel.setUpdatedBy("KNRAI");
			uLModel.setCreatedOn(new Date());
			uLModel.setUpdatedOn(new Date());
			
			
			uLAdd.setAddress(request.getParameter("Address")); 
			uLAdd.setSector(request.getParameter("Sector"));
			uLAdd.setCity(request.getParameter("City"));
			uLAdd.setState(request.getParameter("State"));
			uLAdd.setCountry(request.getParameter("country"));
			uLAdd.setPinCode(request.getParameter("postalCode"));

			uLAdd.setRegNo(request.getParameter("RwaNo")); 
			uLAdd.setStatus(uLModel.getStatus()); 
			uLAdd.setCreatedBy(uLModel.getCreatedBy()); 
			uLAdd.setUpdatedBy(uLModel.getCreatedBy());
			uLAdd.setCreatedOn(new Date());
			uLAdd.setUpdatedOn(new Date());
			
			uLModel.getUAdd().add(uLAdd);
			uLAdd.setULModel(uLModel);
			System.out.println("\nEOF Update user Login information to Model");
		} catch (Exception e) {
			System.out.println("\ne Error in Updating user Login info to model\n" + e);
		}
		return uLModel;
	}

}
