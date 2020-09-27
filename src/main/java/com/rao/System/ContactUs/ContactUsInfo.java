package com.rao.System.ContactUs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

public class ContactUsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		JsonArray JsonArrayList= new JsonArray();
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		String erMsg = " Step1: Start, ";
		String hDAOMessage="TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
		HttpSession session = request.getSession(true);
		int hDAOStatus=0;
		try {
			switch(request.getParameter("Action")){
			case "ContactUs":
				GenEnqModel cUModel = new GenEnqModel();
				cUModel = UpdateJspValInModel(cUModel,request);
				erMsg += " Step2: Update GEModel OK, " ;
				showModelValue(cUModel);
				System.out.println("LEN"+ cUModel.getEnquiryMsg().length());
				erMsg += " Step2.1: show Model OK, " ;
				if(cUModel.getTitle()     == "Title" || cUModel.getFName().length()<=1   || cUModel.getLName().length()<=1 
					|| cUModel.getEmailId().length()<=1     || cUModel.getMobileNo().length()<=1   || cUModel.getCity().length()<=1 
					|| cUModel.getCountryName()=="Country Name*" || cUModel.getEnquiryMsg().length()<=1  ) {

					hDAOMessage= "Title, FName, LName, Email, Mobile, city, Country and Request Msg can't be Blank.";
					System.out.println(hDAOMessage);
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("ContactUs/ContactUsMainPage.jsp");
 				}else {
					hDAOStatus=HDAOGenEnquiry.gENewInfo(cUModel, erMsg);
					hDAOMessage= hDAOStatus>0?"ENQUIRY SUBMITED SUCCESSFULLY.":"TECHNICAL ERROR!PLS TRY AFTER SOMETIME.";
					System.out.println("step 4:"+ hDAOMessage);
					System.out.println();
					out.print(hDAOMessage);
					out.flush();
					break;
				}
				break;
			case "GenEnquiry":
				GenEnqModel gEModel = new GenEnqModel();
				UpdateJspValInModel(gEModel,request);
				erMsg += " Step2: Update GEModel OK, " ;
				showModelValue(gEModel);
				hDAOStatus=HDAOGenEnquiry.gENewInfo(gEModel, erMsg);
				hDAOMessage= hDAOStatus>0?"THANKS!ENQUIRY SUBMITED SUCCESSFULLY.":"TECHNICAL ERROR!PLS TRY AFTER SOMETIME.";
				session.setAttribute("Message",hDAOMessage );
				response.sendRedirect("SuccessMsg.jsp");
				break;
			case "ProductEnquiry" :
			case "BusEnquiry"	:
				BusEnqModel bEModel = new BusEnqModel();
				bEModel = UpdateJspValInBusEnqModel(bEModel,request);
				erMsg += " Step2: Update GEModel OK, " ;
				showBusEnqModelValue(bEModel);
				erMsg += " Step2.1: Show Model Value OK, " ;
				if(bEModel.getTitle()== "Title" || bEModel.getFName()=="" || bEModel.getLName()== "" 
					|| bEModel.getEmailId() ==""     || bEModel.getMobileNo()==""   || bEModel.getCity()=="" 
					|| bEModel.getCountryName()=="0" || bEModel.getEnquiryMsg()=="" ||bEModel.getCompanyName()=="" ) {
					System.out.println("company name is blank");

					hDAOMessage= "Title, FName, LName, Email, Mobile, city, Country and Request Msg can't be Blank.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("ContactUs/BusinessEnquiry.jsp");
 				}else {
					hDAOStatus=HDAOGenEnquiry.BusEnqInfo(bEModel, erMsg);
					hDAOMessage= hDAOStatus>0?"THANKS! ENQUIRY SUBMITED SUCCESSFULLY.":"TECHNICAL ERROR!PLS TRY AFTER SOMETIME.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				break;
			case "CLBEnquiry"	:
				ClbEnqModel clbEModel = new ClbEnqModel();
				clbEModel = UpdateJspValInClbEnqModel(clbEModel,request);
				erMsg += " Step2: Update GEModel OK, " ;
				showClbEnqModelValue(clbEModel);
				erMsg += " Step2.1: Show Model Value OK, " ;
				if(clbEModel.getTitle()== "Title" || clbEModel.getFName()=="" || clbEModel.getLName()== "" 
		 			|| clbEModel.getEmailId() ==""     || clbEModel.getMobileNo()==""   || clbEModel.getCity()=="" 
					|| clbEModel.getCountryName()=="0" || clbEModel.getEnquiryMsg()=="" ||clbEModel.getCompanyName()=="" ) {

					hDAOMessage= "Title, FName, LName, Email, Mobile, city, Country and Request Msg can't be Blank.";
					System.out.println("\n"+hDAOMessage);
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("ContactUs/CollaborationEnquiry.jsp");
 				}else {
 					System.out.println("before HDAQ");
					hDAOStatus=HDAOGenEnquiry.clbEnqInfo(clbEModel, erMsg);
					hDAOMessage= hDAOStatus>0?"THANKS! ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! PLS TRY AFTER SOMETIME.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				break;
			case "PFDEnquiry"	:
				PDEnqModel pfdEModel = new PDEnqModel();
				pfdEModel = UpdateJspValInPfdEnqModel(pfdEModel,request);
				erMsg += " Step2: Update GEModel OK, " ;
				showPfdEnqModelValue(pfdEModel);
				erMsg += " Step2.1: Show Model Value OK, " ;
				if(pfdEModel.getTitle()== "Title" || pfdEModel.getFName()=="" || pfdEModel.getLName()== "" 
					|| pfdEModel.getEmailId() ==""     || pfdEModel.getMobileNo()==""   || pfdEModel.getCity()=="" 
					|| pfdEModel.getCountryName()=="0" || pfdEModel.getEnquiryMsg()=="" ||pfdEModel.getCompanyName()=="" ) {
 
					hDAOMessage= "Title, FName, LName, Email, Mobile, city, Country and Request Msg can't be Blank.";
					System.out.println("\n"+hDAOMessage);
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("ContactUs/CollaborationEnquiry.jsp");
 				}else {
 					System.out.println("before HDAQ");
					hDAOStatus=HDAOGenEnquiry.pfdEnqInfo(pfdEModel, erMsg);
					hDAOMessage= hDAOStatus>0?"THANKS! YOUR ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				break;

			case "CountryList":
				JsonArrayList=HDAOGenEnquiry.getAllcountryList();
				System.out.println("step 2: HDAO OK.");
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "colbList":
				JsonArrayList=HDAOGenEnquiry.getCollaborationList(erMsg );
				System.out.println("step 3: HDAO OK." + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "ProductList":
				JsonArrayList=HDAOGenEnquiry.getProductList(erMsg );
				System.out.println("step 3: HDAO OK.");
				System.out.println(JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			}
			System.out.println(erMsg);
		}catch(Exception e) {
			System.out.println(erMsg + "\n" + e);
			session.setAttribute("Message",hDAOMessage );
			response.sendRedirect("SuccessMsg.jsp"); 
		}
	}

	private void showPfdEnqModelValue(PDEnqModel pfdEModel) {
		System.out.println("Title :" +pfdEModel.getTitle() +", FName :" +pfdEModel.getFName()
		+ " , Lname :" +pfdEModel.getLName() + " , Phone :" +pfdEModel.getMobileNo()
		+ ", Email" +pfdEModel.getEmailId()+", CompanyName: " + pfdEModel.getCompanyName()
		+" , Country: " + pfdEModel.getCountryName() +",City: "+pfdEModel.getCity()
		+ ",Postal Code: " +pfdEModel.getPinCode()+", Collboration Request: " 
		+pfdEModel.getEnquiry()+ ", Enquiry Msg:" +pfdEModel.getEnquiryMsg());
	}

	private PDEnqModel UpdateJspValInPfdEnqModel(PDEnqModel pfdEModel, HttpServletRequest request) {
		pfdEModel.setTitle(request.getParameter("title"));
		pfdEModel.setFName(request.getParameter("fName"));
		pfdEModel.setLName(request.getParameter("lName")); 
		pfdEModel.setEmailId(request.getParameter("email")); 
		pfdEModel.setCompanyName(request.getParameter("companyName"));
		pfdEModel.setCountryName(request.getParameter("country"));
		pfdEModel.setCity(request.getParameter("city"));
		pfdEModel.setPinCode(request.getParameter("postalCode"));
		pfdEModel.setMobileNo(request.getParameter("phoneNo"));
		pfdEModel.setEnquiry(request.getParameter("prodDemo"));
		pfdEModel.setEnquiryMsg(request.getParameter("textareaMsg"));
		Date crDate = new Date();
		pfdEModel.setCreatedOn(crDate);
		
		return pfdEModel;
	}

	private void showClbEnqModelValue(ClbEnqModel cLEModel) {
		System.out.println("Title :" +cLEModel.getTitle() +", FName :" +cLEModel.getFName() 
		+ " , Lname :" +cLEModel.getLName() +" , Phone :" +cLEModel.getMobileNo()
		+ ", Email" +cLEModel.getEmailId()+", CompanyName: " + cLEModel.getCompanyName()
		+ " , Country: " + cLEModel.getCountryName() +",City: "+cLEModel.getCity()
		+ ",Postal Code: " +cLEModel.getPinCode()+", Collboration Request: " +cLEModel.getEnquiry()
		+ ", Enquiry Msg:" +cLEModel.getEnquiryMsg());
	}

	private ClbEnqModel UpdateJspValInClbEnqModel(ClbEnqModel cLEModel, HttpServletRequest request) {
		cLEModel.setTitle(request.getParameter("title"));
		cLEModel.setFName(request.getParameter("fName"));
		cLEModel.setLName(request.getParameter("lName"));
		cLEModel.setEmailId(request.getParameter("email"));
		cLEModel.setCompanyName(request.getParameter("companyName"));
		cLEModel.setCountryName(request.getParameter("country"));
		cLEModel.setCity(request.getParameter("city"));
		cLEModel.setPinCode(request.getParameter("postalCode"));
		cLEModel.setMobileNo(request.getParameter("phoneNo"));
		cLEModel.setEnquiry(request.getParameter("Collaboration"));
		cLEModel.setEnquiryMsg(request.getParameter("textareaMsg"));
		return cLEModel;
	}

	private void showBusEnqModelValue(BusEnqModel bEModel) {
		System.out.println("Title :" +bEModel.getTitle() +", FName :" +bEModel.getFName() + " , Lname :" 
			    +bEModel.getLName() + " , Phone :" +bEModel.getMobileNo()+ ", Email" +bEModel.getEmailId()+
			    ", CompanyName: " + bEModel.getCompanyName()+" , Country: " + bEModel.getCountryName() 
			    +",City: "+bEModel.getCity()+ ",Postal Code: " +bEModel.getPinCode()
			    + ",\nEnquiry Msg:" +bEModel.getEnquiryMsg());
		System.out.println("\nConsumer Product :" +bEModel.getConsumerProduct() 
		+", Business Solution :" +bEModel.getBusinessSolution() + " , Drive Technology :" 
		+bEModel.getDrivingTechnlogy() + " , Industrial Training :" +bEModel.getIndustryTraining()
		+ ", Technical Expert :" +bEModel.getTechnologyExpert());
	}

	private BusEnqModel UpdateJspValInBusEnqModel(BusEnqModel bEModel, HttpServletRequest request) {
		bEModel.setTitle(request.getParameter("title"));
		bEModel.setFName(request.getParameter("fName"));
		bEModel.setLName(request.getParameter("lName"));
		bEModel.setEmailId(request.getParameter("email"));
		bEModel.setCompanyName(request.getParameter("companyName"));
		bEModel.setCountryName(request.getParameter("country"));
		bEModel.setCity(request.getParameter("city"));
		bEModel.setPinCode(request.getParameter("postalCode"));
		bEModel.setMobileNo(request.getParameter("phoneNo"));

		bEModel.setConsumerProduct(request.getParameter("consumerProd"));
		bEModel.setBusinessSolution(request.getParameter("busSolution"));
		bEModel.setDrivingTechnlogy(request.getParameter("driveTech"));
		bEModel.setIndustryTraining(request.getParameter("indTraining"));
		bEModel.setTechnologyExpert(request.getParameter("techExpert"));
		bEModel.setEnquiryMsg(request.getParameter("textareaMsg"));
		return bEModel;
	}

	private static GenEnqModel UpdateJspValInModel(GenEnqModel gEModel, HttpServletRequest request) {
		System.out.println("JSp value");
		gEModel.setTitle(request.getParameter("title"));
		gEModel.setFName(request.getParameter("fName"));
		gEModel.setLName(request.getParameter("lName"));
		gEModel.setMobileNo(request.getParameter("phoneNo"));
		gEModel.setEmailId(request.getParameter("email"));
		gEModel.setCompanyName(request.getParameter("companyName"));
		gEModel.setCountryName(request.getParameter("country"));
		gEModel.setCity(request.getParameter("city"));
		gEModel.setPinCode(request.getParameter("postalCode"));
		gEModel.setEnquiryMsg(request.getParameter("enquiryMsg"));
	return gEModel;	
	}
	private static void showModelValue(GenEnqModel gEModel) {
		System.out.println("Title :" +gEModel.getTitle() +", FName :" +gEModel.getFName() + " , Lname :" 
	    +gEModel.getLName() + " , Phone :" +gEModel.getMobileNo()+ ", Email" +gEModel.getEmailId()+
	    ", CompanyName: " + gEModel.getCompanyName()+" , Country: " + gEModel.getCountryName() 
	    +",City: "+gEModel.getCity()+",Postal Code: " +gEModel.getPinCode()+ ",\nEnquiry Msg:" 
	    +gEModel.getEnquiryMsg());
	}

}
