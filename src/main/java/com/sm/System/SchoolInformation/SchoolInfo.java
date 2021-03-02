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
				erMsg+= "step 3: HDAO OK." + rwaValid;
				System.out.println("step 3: HDAO OK." + rwaValid);
				out.print(rwaValid);
				out.flush();
				break;
			case "Email" :// check LogiID exist or not
				String LoginId= request.getParameter("EmailId");
				System.out.println(" KNRAI :"+LoginId);
				String emailValid = HDAOSchoolInfo.verifyDupEmail(LoginId);
				System.out.println("Step 4: HDAO OK" + emailValid );
				out.print(emailValid);
				out.flush();
				break;
			case "information":	
				System.out.println("information");
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
			case "rInformation":	//edit informations
				break; 
			case "RWAInformation":	
				break; 
			}
		} catch (IOException e) {
			System.out.println("Technical Error"+ e);
			e.printStackTrace();
		}
		finally {
			System.out.println(erMsg);
		}
	}
	
		

	private void ShowRegModel(SchoolInfoModel siModel) {
//		Address address = siModel.getAddress();
//		CountryList country = address.getCountryList();
		System.out.println("\nReg No." +siModel.getRegNo( ) + ", Name : " +siModel.getName() + " ,RDate "
	    +siModel.getRegDate() + ",  Mobile :" + siModel.getMobileNo( )	+ ", Phone :" + siModel.getPhoneNo()
		+ "Login ID :"+ siModel.getLoginId() + ", PWD: "+	siModel.getLoginPassword());

		List<Email> emailid = siModel.getEmailId();
		System.out.println(siModel.getEmailId());
		String emlid = null ;
		for (Email eml:emailid) {
			emlid += eml.getEmailID() + " ," +eml.getCategory() + " ;";
		}
		System.out.println("\nEmail :" + emlid);
//		System.out.println("\nAddress:"+ address.getAddress() +" Sector :"+	address.getSector()
//		+ ", City:" + address.getCity()	+ ", State : "+ address.getState()+ ", Country :"+ country.getName()
//		+ ", PinCode:" +	address.getPinCode() + "Category :"+ address.getCategory() );
	}
	private SchoolInfoModel UpdFormValueToRModel(SchoolInfoModel siModel, HttpServletRequest request) {
		try {
			siModel.setRegNo(request.getParameter("RegNo"));
			siModel.setRegDate(Utilities.StringToDate((String) request.getParameter("RegDate")));
			System.out.println("Date knr:" + siModel.getRegDate() );
			siModel.setName(request.getParameter("SchName"));
			siModel.setMobileNo(request.getParameter("mobileNo"));
			siModel.setPhoneNo(request.getParameter("phoneNo"));
			siModel.setLoginId(request.getParameter("LoginId"));
			siModel.setLoginPassword(request.getParameter("Password"));

			List<Email> emailList =  new ArrayList<Email>()  ;
			Email email = new Email();
			email.setCategory("SC");
			email.setEmailID(request.getParameter("email"));
			emailList.add(email);

//			Email email1 = new Email();
//			email1.setCategory("HO");
//			email1.setEmailID(request.getParameter("HoEmail"));
//			emailList.add(email1);
			
			siModel.setEmailId(emailList);;
//
//			Address address = siModel.getAddress();
//			address.setAddress(request.getParameter("Address"));
//			address.setSector(request.getParameter("Sector"));
//			address.setCity(request.getParameter("City"));
//			address.setState(request.getParameter("State"));
//			address.setPinCode(request.getParameter("postalCode"));
//			address.setCategory("SC");
//
//			CountryList country = address.getCountryList();
//			country.setName(request.getParameter("country"));
//			country.setCode(request.getParameter("country"));
//			address.setCountryList(country);
//			siModel.setAddress(address);

			siModel.setStatus("A");
			siModel.setCreatedBy("KNRAI");
			siModel.setUpdatedBy("KNRAI");
			siModel.setCreatedOn(new Date());
			siModel.setUpdatedOn(new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return siModel;
	}


}// SERVELET EOF
