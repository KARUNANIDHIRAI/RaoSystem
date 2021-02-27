package com.smsi.sm.SchoolInformation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.RwaReg.HDAORwa;
import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.Utilities;
import com.sm.System.SchoolInformation.Address;
import com.sm.System.SchoolInformation.Email;
import com.sm.System.SchoolInformation.HDAOSchoolInfo;
import com.sm.System.SchoolInformation.SchoolInfoModel;

/**
 * Servlet implementation class InfoSchool
 */
public class InfoSchool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String erMsg= "Step1: S.Info Start";
		String valMsg=""; 
		RwaRegModel rModel = new RwaRegModel();
		SchoolInfoModel SiModel = new SchoolInfoModel();
		String Action = request.getParameter("Action");
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "RegNo": // validate school registraion duplicate 
				String regNo= request.getParameter("RegNo");
				String VRegNo=HDAORwa.validRwaNo(regNo);
				System.out.println("step 3: HDAO OK." + VRegNo);
				out.print(VRegNo);
				out.flush();
				break;
			case "Email" : // valid email
				String emailId = request.getParameter("Email");
				String emailValid = HDAORwa.validEmail(emailId);
				System.out.println("Step 4: HDAO OK" + emailValid );
				out.print(emailValid);
				out.flush();
				break;
			case "information":	 // retrieve school information
				SiModel = UpdFormValueToRModel(SiModel,request);
				erMsg = "Step 1.1: Update Mpdel OK.";
				//ShowRegModel(rModel);
				//valMsg=ValidateRwaReg(SiModel, valMsg);
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
				erMsg +=" Update FormValue to Model Ok, ";
				System.out.println("\nform value :" +request.getParameter("RegDate"));
				
				String sDate1=request.getParameter("RegDate");
				try {
					Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
					System.out.println(sDate1+"\t"+date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("error in date conversion");
				}
				SiModel = UpdFormValueToRModel(SiModel, request);
				ShowRegModel(rModel);
				valMsg=ValidateRwaReg(rModel, valMsg);
				if(valMsg.length()>1) {
						creatSessionVal(rModel,session);
						System.out.println("\n error: "+ "ERROR IN :" +valMsg);
						session.setAttribute("Message",valMsg );
						response.sendRedirect("RwaRegistration/EditRwaReg.jsp");
				}else {
//					int rwaStatus = HDAORwa.editRwa(rModel,erMsg);
//					String hDAOMessage= rwaStatus>0?"RWA Registration Information updated SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
//					session.setAttribute("Message",hDAOMessage );
//					response.sendRedirect("SuccessMsg.jsp");
				}
				break; 
			case "SInformation":	
				rModel.setRegNo("MK103"); 
				rModel.setStatus("A");
				erMsg +=" Model Update Ok, ";
				JsonArrayList = HDAORwa.RwaRegInformation(rModel, erMsg);
			    erMsg +=  "step 3: HDAO OK."; 
			    
			    System.out.println("\n" +JsonArrayList.toString());
			    out.print(JsonArrayList.toJson());
			    out.flush();
				break; 
			}
		} catch (IOException e) {
			System.out.println("Technical Error"+ e);
			e.printStackTrace();
		}finally {
			System.out.println(erMsg);
		}
		

	}
		private void creatSessionVal(RwaRegModel rModel,HttpSession Session) {
			Session.setAttribute("RwaNo",       rModel.getRegNo());
			Session.setAttribute("RwaName ",    rModel.getRegName());
			Session.setAttribute("RegDate ",    rModel.getRegDate()); 
			Session.setAttribute("RegValidTo ", rModel.getExpDate()); 
			Session.setAttribute("email ",      rModel.getEmailId());
			Session.setAttribute("mobileNo ",   rModel.getMobileNo());
			Session.setAttribute("phoneNo ",    rModel.getPhoneNo());
			Session.setAttribute("Address",     rModel.getAddress());
			Session.setAttribute("Sector ",     rModel.getSector());
			Session.setAttribute("City ",       rModel.getCity());
			Session.setAttribute("State ",      rModel.getState());
//			Session.setAttribute("country ",    rModel.getCountry());
			Session.setAttribute(" postalCode", rModel.getPinCode());
			
			Session.setAttribute("RwaLoginId ", rModel.getRwaUserId());

			Session.setAttribute("RwaRegAut ",  rModel.getRegnAuthority());
			Session.setAttribute("RtoEmail ",   rModel.getRegnAuthEmail());

			Session.setAttribute("athAddress ", rModel.getAthAddress());
			Session.setAttribute("athSector ",  rModel.getAthSector());
			Session.setAttribute("athCity ",    rModel.getAthCity());
			Session.setAttribute("athState ",   rModel.getAthState());
			Session.setAttribute("athCountry ", rModel.getAthCountry());
			Session.setAttribute("athPostalCode ", rModel.getAthPinCode());		
	}
		private String ValidateRwaReg(RwaRegModel rModel, String valMsg) {
			CountryList country = new CountryList();
			country = rModel.getCountryList();
			System.out.println("Name :"+ country.getName());
			System.out.println("Code :"+country.getCode());
			if (rModel.getRegNo().length()<=4)    {
				valMsg += "RWA Reg No, ";
			}if(rModel.getRegName().length()<=5 ) {
				valMsg += "RWA Name, ";
			}if (rModel.getRegDate()== null)      {
				valMsg += "Reg Date,";
			}if(rModel.getExpDate()== null)    	  {
				valMsg += "Reg Expiry Date,";
			}if(rModel.getEmailId()== null) 	  {
				valMsg += "RWA Email , ";
			}if(rModel.getMobileNo().length()<10) {
				valMsg += "Mobile No , ";
			}if(rModel.getAddress().length()<=1)  {
				valMsg += "Address , ";
			} if(rModel.getSector().length()<=1)   {
				valMsg += "Sector , ";
			}if(rModel.getCity().length()<=1) 	  {
				valMsg += "City , ";
			}if(rModel.getState().length()<=1) 	  {
				valMsg += " State , ";
//			}if(rModel.getCountry().length()<2 )  { 
				valMsg += " Country , ";
			}if(rModel.getRwaUserId().length()<8) {
				valMsg += " Login ID , ";
			}if(rModel.getRwaPassword().length()<8){
				valMsg += " Password , ";
			}if(rModel.getRegnAuthority().length()<=1){
				valMsg += " Reg.Authority , ";
			}if(rModel.getAthAddress().length()<=1) {
				valMsg += " Ath. Address , ";
			}if(rModel.getAthCity().length()<=1) {
				valMsg += " Reg. City , ";
			}if(rModel.getAthState().length()<=1) {
				valMsg += " Reg.State , ";
//			}if(rModel.getAthCountry().length()<2) {
				valMsg += " Ath.Country, ";
			}
			System.out.println("Error Message: " +valMsg + "(Length)");
			 return valMsg;
	}
		

	private void ShowRegModel(RwaRegModel rModel) {
		System.out.println("\nRWA No." +rModel.getRegNo( ) + ", Name : " +rModel.getRegName( ) + "RDate "+	rModel.getRegDate() 
		+ ",  ExpDate :" +rModel.getExpDate() + ", Email :" + rModel.getEmailId() + ",  Mobile :" + rModel.getMobileNo( )
		+ ", Phone :" + rModel.getPhoneNo() );
		System.out.println("\nAddress:"+ rModel.getAddress() +" Sector :"+	rModel.getSector()+ ", City:" + rModel.getCity( )
		+ ", State : "+ rModel.getState( )+ ", Country :"+ rModel.getCountryList() + ", PinCode:" +	rModel.getPinCode( ));
		System.out.println("\nUID" +	rModel.getRwaUserId() + ", PWD: "+	rModel.getRwaPassword( ));
		System.out.println("\nAuthrity"+	rModel.getRegnAuthority() + ", Email:"+ rModel.getRegnAuthEmail()); 

		System.out.println("\nAddress:"+ rModel.getAthAddress( ) +" Sector :"+	rModel.getAthSector()+ ", City:" + rModel.getAthCity()
		+ ", State : "+ rModel.getAthState() + ", Country :"+ rModel.getAthCountry() + ", PinCode:" +	rModel.getAthPinCode());
	}
	private SchoolInfoModel UpdFormValueToRModel(SchoolInfoModel siModel, HttpServletRequest request) {
		try {
			siModel.setRegNo(request.getParameter("RwaNo"));
			siModel.setName(request.getParameter("RwaName"));
			siModel.setRegDate(Utilities.StringToDate(request.getParameter("RegDate")));
			System.out.println("Date :" + siModel.getRegDate() );

			List<Email> emailList = (List<Email>) new Email() ;

			Email email = new Email();
			email.setCategory("Main");
			email.setEmailID("kn.com");
			emailList.add(email);
			Email email1 = new Email();
			
			email1.setCategory("Main");
			email1.setEmailID("kn.com");
			emailList.add(email1);
			
			siModel.setEmailId(emailList);;

//			siModel.setEmailId(request.getParameter("email"));
			siModel.setMobileNo(request.getParameter("mobileNo"));
			siModel.setPhoneNo(request.getParameter("phoneNo"));

			Address address = new Address();
			address.setAddress(request.getParameter("Address"));
			address.setSector(request.getParameter("Sector"));
			address.setCity(request.getParameter("City"));
			address.setState(request.getParameter("State"));
			address.setPinCode(request.getParameter("postalCode"));
			address.setCategory("School");

			CountryList country = address.getCountryList();
			country.setName(request.getParameter("country"));
			country.setCode(request.getParameter("country"));
			address.setCountryList(country);
			siModel.setAddress(address);
			
			
			siModel.setLoginId(request.getParameter("RwaLoginId"));
			siModel.setLoginPassword(request.getParameter("Password"));

/*			
			siModel.setRegnAuthority(request.getParameter("RwaRegAut"));
			siModel.setRegnAuthEmail(request.getParameter("RtoEmail"));

			siModel.setAthAddress(request.getParameter("athAddress"));
			siModel.setAthSector(request.getParameter("athSector"));
			siModel.setAthCity(request.getParameter("athCity"));
			siModel.setAthState(request.getParameter("athState"));

			CountryList authcountry = new CountryList();
			authcountry.setName(request.getParameter("athCountry"));
			authcountry.setCode(request.getParameter("athCountry"));
			siModel.setAthCountry(authcountry);
			
			siModel.setAthPinCode(request.getParameter("athPostalCode"));
*/
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


}
