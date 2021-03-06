package com.rao.System.RwaReg;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.Utility.CountryList;
import com.raoSystem.Utility.Utilities;

import org.json.simple.JsonArray;
public class RwaInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RwaInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String erMsg= "Step1: KNRAI Start";
		String valMsg=""; 
		RwaRegModel rModel = new RwaRegModel();
		String Action = request.getParameter("Action");
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "ValidRwaNo":
				String rwaNo= request.getParameter("RwaNo");
				String rwaValid=HDAORwa.validRwaNo(rwaNo);
				System.out.println("step 3: HDAO OK." + rwaValid);
				out.print(rwaValid);
				out.flush();
				break;
			case "ValidEmail" :
				String emailId = request.getParameter("Email");
				String emailValid = HDAORwa.validEmail(emailId);
				System.out.println("Step 4: HDAO OK" + emailValid );
				out.print(emailValid);
				out.flush();
				break;
			case "NewRwa":	
				rModel = UpdFormValueToRModel(rModel,request);
				erMsg = "Step 1.1: Update Mpdel OK.";
				ShowRegModel(rModel);
				valMsg=ValidateRwaReg(rModel, valMsg);
				if(valMsg.length()>1) {
						creatSessionVal(rModel,session);
						System.out.println("\n error: "+ "ERROR IN :" +valMsg);
						session.setAttribute("Message",valMsg );
						response.sendRedirect("RwaRegistration/NewRwaReg.jsp");
				}else {
					int rwaStatus = HDAORwa.newRwa(rModel,erMsg);
					String hDAOMessage= rwaStatus>0?"THANKS! YOUR ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
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
				rModel = UpdFormValueToRModel(rModel, request);
				ShowRegModel(rModel);
				valMsg=ValidateRwaReg(rModel, valMsg);
				if(valMsg.length()>1) {
						creatSessionVal(rModel,session);
						System.out.println("\n error: "+ "ERROR IN :" +valMsg);
						session.setAttribute("Message",valMsg );
						response.sendRedirect("RwaRegistration/EditRwaReg.jsp");
				}else {
					int rwaStatus = HDAORwa.editRwa(rModel,erMsg);
					String hDAOMessage= rwaStatus>0?"RWA Registration Information updated SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				break; 
			case "RWAInformation":	
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
		/*
		 * return rModel.getRegNo().length()>=10 && rModel.getRegName().length()>=5 &&
		 * rModel.getRegDate()!= null && rModel.getExpDate()!= null &&
		 * rModel.getEmailId()!= null && rModel.getMobileNo().length()>=10 &&
		 * rModel.getAddress()!= null && rModel.getSector()!= null && rModel.getCity()!=
		 * null && rModel.getState()!= null && rModel.getCountry()!= null &&
		 * rModel.getRwaUserId().length()>=8 && rModel.getRwaPassword().length()>=8 &&
		 * rModel.getRegnAuthority()!= null && rModel.getAthAddress()!= null &&
		 * rModel.getAthSector()!= null && rModel.getAthCity()!= null &&
		 * rModel.getAthState()!= null && rModel.getAthCountry()!= null ? true: false;
		 */	
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
	private RwaRegModel UpdFormValueToRModel(RwaRegModel rModel, HttpServletRequest request) {
		try {
			rModel.setRegNo(request.getParameter("RwaNo"));
			rModel.setRegName(request.getParameter("RwaName"));
//			rModel.setRegDate(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("RegDate")));
			rModel.setRegDate(Utilities.StringToDate(request.getParameter("RegDate")));
			rModel.setExpDate(Utilities.StringToDate(request.getParameter("RegValidTo")));
			System.out.println("Date :" + rModel.getRegDate() + " exp date :" + rModel.getExpDate());
			rModel.setEmailId(request.getParameter("email"));
			rModel.setMobileNo(request.getParameter("mobileNo"));
			rModel.setPhoneNo(request.getParameter("phoneNo"));
			rModel.setAddress(request.getParameter("Address"));
			rModel.setSector(request.getParameter("Sector"));
			rModel.setCity(request.getParameter("City"));
			rModel.setState(request.getParameter("State"));

			CountryList country = new CountryList();
			country.setName(request.getParameter("country"));
			country.setCode(request.getParameter("country"));
			rModel.setCountryList(country);
			
			rModel.setPinCode(request.getParameter("postalCode"));
			
			rModel.setRwaUserId(request.getParameter("RwaLoginId"));
			rModel.setRwaPassword(request.getParameter("Password"));

			rModel.setRegnAuthority(request.getParameter("RwaRegAut"));
			rModel.setRegnAuthEmail(request.getParameter("RtoEmail"));

			rModel.setAthAddress(request.getParameter("athAddress"));
			rModel.setAthSector(request.getParameter("athSector"));
			rModel.setAthCity(request.getParameter("athCity"));
			rModel.setAthState(request.getParameter("athState"));

			CountryList authcountry = new CountryList();
			authcountry.setName(request.getParameter("athCountry"));
			authcountry.setCode(request.getParameter("athCountry"));
			rModel.setAthCountry(authcountry);
			
			rModel.setAthPinCode(request.getParameter("athPostalCode"));
			rModel.setStatus("A");
			rModel.setCreatedBy("KNRAI");
			rModel.setUpdatedBy("KNRAI");
			rModel.setCreatedOn(new Date());
			rModel.setUpdatedOn(new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rModel;
	}
	/*
	 * private static Date conDate(String convDate) {
	 * System.out.println("form Date:" + convDate); DateFormat DF = new
	 * SimpleDateFormat("dd/MM/yyyy"); Date cDate = null; try { cDate =
	 * DF.parse(convDate); System.out.println("converted date  : " + cDate); } catch
	 * (ParseException e) { e.printStackTrace(); } return cDate; }
	 */	

}
