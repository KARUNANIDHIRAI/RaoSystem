package com.sm.System.SchoolInformation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.json.simple.JsonArray;

import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.Utilities;

/**
 * Servlet implementation class SchoolInfo
 */
public class SchoolInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String erMsg= "Step1:";
		String valMsg=""; 
		SchoolInfoModel SiModel = new SchoolInfoModel();
		String Action = request.getParameter("Action");
		System.out.println(Action);
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "RegNo": // check regNo exist or not
				String regNo= request.getParameter("RegNo");
				String rwaValid=HDAOSchoolInfo.validRegNo(regNo);
				out.print(rwaValid);
				out.flush();
				break;
			case "Email" :// check LogiID exist or not
				String LoginId= request.getParameter("EmailId");
				String emailValid = HDAOSchoolInfo.verifyDupEmail(LoginId);
				System.out.println("Step 4: HDAO OK" + emailValid );
				out.print(emailValid);
				out.flush();
				break;
			case "information":	 // CREATE NEW USER LOGIN
				SiModel = UpdFormValueToRModel(SiModel,request);
				erMsg = " form value Update OK.";
				ShowRegModel(SiModel);
				erMsg = "showvalue  OK.";
//				valMsg=ValidateRwaReg(SiModel, valMsg);
				int rwaStatus = HDAOSchoolInfo.newSchInfo(SiModel,erMsg);
				String hDAOMessage= rwaStatus>0?"THANKS! YOUR ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
				session.setAttribute("Message",hDAOMessage );
				response.sendRedirect("SuccessMsg.jsp");

//				
//				if(valMsg.length()>1) {
//					//	creatSessionVal(SiModel,session);
//						System.out.println("\n error: "+ "ERROR IN :" +valMsg);
//						session.setAttribute("Message",valMsg );
//						response.sendRedirect("RwaRegistration/NewRwaReg.jsp");
//				}else {
//					int rwaStatus = HDAORwa.newRwa(rModel,erMsg);
//					String hDAOMessage= rwaStatus>0?"THANKS! YOUR ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
//					session.setAttribute("Message",hDAOMessage );
//					response.sendRedirect("SuccessMsg.jsp");
//				}
				break;
			case "rInformation" :	//edit informations
				System.out.println("\nknrai");
				System.out.println(request.getParameter("RegDate"));
				try {
					System.out.println("String to date Reg :" +Utilities.StringToDate(request.getParameter("RegDate")));
				} catch (ParseException e) {
					System.out.println("Error in RegDate Convert:\n" + e);
				}
				SchoolInfoModel siModel = new SchoolInfoModel();
				try {
					siModel.setRegDate(Utilities.StringToDate(request.getParameter("RegDate")));
					System.out.println("RegDate Convert:\n" + siModel.getRegDate());
				} catch (ParseException e) {
					System.out.println("Error in RegDate Convert:\n" + e);
				}
				break; 
			case "RWAInformation":	
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}
	}
	
		

	private void ShowRegModel(SchoolInfoModel siModel) {
		System.out.println("\n siModel: "+siModel);

		//		CountryList country = address.getCountryList();
//		System.out.println("\nReg No." +siModel.getRegNo( ) + ", Name : " +siModel.getName()
//		+ ",  Mobile :" + siModel.getMobileNo( )	+ ", Phone :" + siModel.getPhoneNo()
//		+ "Login ID :"+ siModel.getLoginId() + ", PWD: "+	siModel.getLoginPassword());
//
//		System.out.println("\n Address: "+siModel.getAddress());
//		System.out.println("\n email : "+siModel.getEmailId());
//		List<Email> emailid = siModel.getEmailId();
//		String emlid = null ;
//		for (Email eml:emailid) {
//			emlid += eml.getEmailID() + " ," +eml.getCategory() + " ;";
//		}
		
	}
	private SchoolInfoModel UpdFormValueToRModel(SchoolInfoModel siModel, HttpServletRequest request) {
		try {
			siModel.setRegNo(request.getParameter("RegNo"));
			siModel.setRegDate(Utilities.StringToDate(request.getParameter("RegDate")));

			siModel.setName(request.getParameter("SchName"));
			siModel.setLoginId(request.getParameter("LoginId"));
			siModel.setLoginPassword(request.getParameter("Password"));
			siModel.setMobileNo(request.getParameter("mobileNo"));
			siModel.setPhoneNo(request.getParameter("phoneNo"));
			siModel.setHoMobileNo(request.getParameter("HoMobileNo"));
			siModel.setHoPhoneNo(request.getParameter("HoPhoneNo"));

			
			Email email = new Email();
			email.setCategory("SC");
			email.setEmailID(request.getParameter("email"));
			siModel.getEmailId().add(email);
			email.setSchEmail(siModel);

			Email HoEmail = new Email();
			HoEmail.setCategory("HO");
			HoEmail.setEmailID(request.getParameter("HoEmail"));
			siModel.getEmailId().add(HoEmail);
			HoEmail.setSchEmail(siModel);
			
			
			Address address = new Address();
			address.setAddress(request.getParameter("Address"));
			address.setSector(request.getParameter("Sector"));
			address.setCity(request.getParameter("City"));
			address.setState(request.getParameter("State"));
			address.setPinCode(request.getParameter("postalCode"));
			address.setCategory("SC");
			
			CountryList country = new CountryList();
			country.setName(request.getParameter("country"));
			country.setCode(request.getParameter("country"));
			address.setCountryList(country);
			
			siModel.getAddress().add(address);
			address.setSchAddress(siModel);
			
			Address HoAddress = new Address();
			HoAddress.setAddress(request.getParameter("HoAddress"));
			HoAddress.setSector(request.getParameter("HoSector"));
			HoAddress.setCity(request.getParameter("HoCity"));
			HoAddress.setState(request.getParameter("HoState"));
			HoAddress.setPinCode(request.getParameter("HOPostalCode"));
			HoAddress.setCategory("HO");
			
			CountryList HoCountry = new CountryList();
			HoCountry.setName(request.getParameter("athCountry"));
			HoCountry.setCode(request.getParameter("athCountry"));
			HoAddress.setCountryList(HoCountry);

			siModel.getAddress().add(HoAddress);
			HoAddress.setSchAddress(siModel);

			SocialMedia socialMediaF = new SocialMedia();
			socialMediaF.setCategory("FB");
			socialMediaF.setsMediaName(request.getParameter("Facebook"));
			siModel.getSocialMedia().add(socialMediaF);
			socialMediaF.setsMedia(siModel);
			
			SocialMedia socialMediaL = new SocialMedia();
			socialMediaL.setCategory("LD");
			socialMediaL.setsMediaName(request.getParameter("Linkdin"));
			siModel.getSocialMedia().add(socialMediaL);
			socialMediaL.setsMedia(siModel);

			SocialMedia socialMediaT = new SocialMedia();
			socialMediaT.setCategory("TW");
			socialMediaT.setsMediaName(request.getParameter("Twitter"));
			siModel.getSocialMedia().add(socialMediaT);
			socialMediaT.setsMedia(siModel);

			
			siModel.setStatus("A");
			siModel.setCreatedBy("KNRAI");
			siModel.setUpdatedBy("KNRAI");
			siModel.setCreatedOn(new Date());
			siModel.setUpdatedOn(new Date());
			System.out.println("\nKNRAI Address :8");
			
		} catch (Exception e) {
			System.out.println("\nError in UpdFormValueToRModel: \n" + e);
		}
		return siModel;
	}


}// SERVELET EOF
