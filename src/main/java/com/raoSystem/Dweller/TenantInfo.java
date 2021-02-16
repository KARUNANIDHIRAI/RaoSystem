package com.raoSystem.Dweller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.AptInventory.HDAOAptInventory;
import com.rao.System.RwaReg.HDAORwa;
import com.rao.System.RwaReg.RwaRegModel;
import com.raoSystem.FLTOWN.HFlatOwnerModel;
import com.raoSystem.Utility.Utilities;

public class TenantInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String erMsg = "Step 1: Start OK";
		String valMsg = "";
		TenantInfoModel tntInfo = new TenantInfoModel();
		String action = request.getParameter("Action");
		JsonArray tntJArray = new JsonArray();
		PrintWriter out = response.getWriter();
		String listType="", spStatus="", hDAOMessage="";
//		String spStatus = "";
		try {
			switch(action) {
			case "tntNew":
				tntInfo= updateTntInfotoJsp(tntInfo,request);
				erMsg += " Step 1.1 : updateTntInfotoJsp OK ";
				showTntInfo(tntInfo);
				erMsg += "Step 1.2 :showTntInfo Ok ";
				valMsg = ValidTntInfo(tntInfo, valMsg);
				if(valMsg.length()>1) {
					System.out.println("\n error: "+ "ERROR IN :" +valMsg);
					session.setAttribute("Message",valMsg );
					response.sendRedirect("TenantInformation/TenantInfoNew.jsp");
				}else {
					spStatus= HDAOTenantInfo.createTnt(tntInfo,erMsg);
					System.out.println("spStatus :"+spStatus+ "length"+spStatus.length());
					switch (spStatus) {
					case "1":
						session.setAttribute("Message","Record Created Successfully.");
						response.sendRedirect("SuccessMsg.jsp");
						break;
					case "2":
						session.setAttribute("Message","Record Already exist" );
						response.sendRedirect("TenantInformation/TenantInfoNew.jsp");
						break;
					default : 
						session.setAttribute("Message","Record not created. Technical Error." );
						response.sendRedirect("SuccessMsg.jsp");
						break;
					}
				}
				break;
			case "rwaAddress":
				erMsg +="Get RwaAddress :";
				String rwaNo="MK106";
				tntJArray=Utilities.rwaAddress(rwaNo, erMsg);
				erMsg += "step 3: HDAO OK. \n" + tntJArray;
				out.print(tntJArray.toJson());
				out.flush();
				break;
			case "TNTInfoList":
				TenantInfoModel tntList = new TenantInfoModel(1, "MK106", request.getParameter("apartment"), request.getParameter("flatInfo")); 
				System.out.println("pkAPtNo: " +tntList.getAptNo()+ " pkFlatNo: " + tntList.getFlatNo());
				tntJArray= HDAOTenantInfo.tntInfoList(tntList,"flatwise",erMsg);
				erMsg += "step 3: HDAO OK. \n" + tntJArray;
				out.print(tntJArray.toJson());
				out.flush();
				break;
			case "TNTInfoSummary":
				TenantInfoModel pktntList = new TenantInfoModel(1, "MK106", request.getParameter("apartment"), request.getParameter("flatInfo")); 
				System.out.println("kAPtNo: " +pktntList.getAptNo()+ " kFlatNo: " + pktntList.getFlatNo());
				tntJArray= HDAOTenantInfo.tntInfoList(pktntList,"aptwise",erMsg);
				System.out.println("tntJArray: "+ tntJArray);
				erMsg += "step 3: HDAO OK. \n" + tntJArray;
				out.print(tntJArray.toJson());
				out.flush();
				break;
			case "TNTInfoEDit":
				TenantInfoModel tntinfoID = new TenantInfoModel(Integer.parseInt(request.getParameter("TNTIDNO")), "MK106", "", ""); 
				tntJArray= HDAOTenantInfo.tntInfoEdit(tntinfoID,"TNTInfoIdWise",erMsg);
				erMsg += "step 3: HDAO OK. knria \n" + tntJArray;
//			    RequestDispatcher rd=request.getRequestDispatcher("TenantInformation/TenantInfoEdit.jsp");  
//			    rd.include(request, response);
				out.print(tntJArray.toJson());
				out.flush();
				break;
			case "TNTNewI":
				tntInfo= updateTntInfotoJsp(tntInfo,request);
				erMsg += " Step 1.1 : updateTntInfotoJsp OK ";
				showTntInfo(tntInfo);
				erMsg += "Step 1.2 :showTntInfo Ok ";
				spStatus= HDAOTenantInfo.UpdateTNTInfo(tntInfo,erMsg);
				System.out.println("spStatus :"+spStatus+ "length"+spStatus.length());
				hDAOMessage= spStatus.length()==1?"Record Updated Successfully.":"Record not Updated. Technical Error.";
				session.setAttribute("Message",hDAOMessage );
				response.sendRedirect("SuccessMsg.jsp");
				break;
			case "TNTInfoDelII":
				TenantInfoModel tntInfoDelID = new TenantInfoModel(Integer.parseInt(request.getParameter("TNTIDNO")), "MK106", "", ""); 
				erMsg += " Step 1.1 : tntInfoDelID OK ";
				spStatus= HDAOTenantInfo.TNTInfoDElId(tntInfoDelID,erMsg);
				System.out.println("spStatus :"+spStatus+ "length"+spStatus.length());
				hDAOMessage= spStatus.length()==1?"Record Updated Successfully.":"Record not Updated. Technical Error.";
				out.print(tntJArray.toJson());
				out.flush();
				break;
			}
		} catch (Exception e) {
			System.out.println("Technical Error:"+ e);
		}finally {
			System.out.println("Message:"+ erMsg);
		}
	}

	private void showTntInfo(TenantInfoModel tntInfo) {
		System.out.println(" RwaNo: "+ tntInfo.getRwaRegNo()+ " AptNo : "+ tntInfo.getAptNo()+ " FltNo: "+ tntInfo.getFlatNo()+ 
				" Fname: "+ tntInfo.getfName()+ " Lname: "+ tntInfo.getlName()+ " Gender: "+ tntInfo.getGender()+ " fFName: "+ tntInfo.getfFName()+
				" fFlName: "+ tntInfo.getfLName());
		System.out.println(" Mobile: "+ tntInfo.getMobileNo()+ " phoneNo: "+ tntInfo.getPhoneNo()
				+ " email: "+ tntInfo.getEmailId()+ "ShiftedOn :"+ tntInfo.getShiftedOn()+
				"ShiftedOutOn: "+ tntInfo.getShiftedOutOn());

		ArrayList<TenantAddresInfoModel> tntAddr = new ArrayList<>();
		tntAddr = (ArrayList<TenantAddresInfoModel>) tntInfo.getAddTnt();
		for(TenantAddresInfoModel tAdd:tntAddr) {
			System.out.println(" Sector :"+	tAdd.getSector()+ ", City:" + tAdd.getCity()
			+ ", State : "+ tAdd.getState()+ ", Country"+ tAdd.getCountry() + ", PinCode:" +	tAdd.getPinCode());
		}
	}

	private TenantInfoModel updateTntInfotoJsp(TenantInfoModel tntInfo, HttpServletRequest request) {
		tntInfo.setRwaRegNo("MK106");
		tntInfo.setAptNo(request.getParameter("apartment"));
		tntInfo.setFlatNo(request.getParameter("flatInfo"));
		tntInfo.setfName(request.getParameter("fName"));
		tntInfo.setlName(request.getParameter("lName"));
		tntInfo.setGender(request.getParameter("gender"));
		tntInfo.setfFName(request.getParameter("fFName"));
		tntInfo.setfLName(request.getParameter("fFLname"));
		tntInfo.setMobileNo(request.getParameter("MobileNo"));
		tntInfo.setPhoneNo(request.getParameter("phoneNo"));
		tntInfo.setEmailId(request.getParameter("email"));
		
		try {
			tntInfo.setShiftedOn(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("shiftInOn")));	
			String sDateOut =(String)request.getParameter("shiftOutOn");
			System.out.println("shiftOutOn:"+ sDateOut);
			if(sDateOut != "") {
				System.out.println("PK shiftOutOn:"+sDateOut);
			 tntInfo.setShiftedOutOn(new SimpleDateFormat("dd-mm-yyyy").parse((String)request.getParameter("shiftOutOn")));
			}	
		} catch (ParseException e) {
			System.out.println("Wrong Date Format : "+ e);
		}
		tntInfo.setTenantStatus("Active");
		tntInfo.setCreatedBy("KNRAI");
		tntInfo.setCreatedOn(new Date()); 
		tntInfo.setUpdatedBy("KNRAI");
		tntInfo.setUpdatedOn(new Date());
		tntInfo.setStatus("A");
		
		TenantAddresInfoModel tntAddInfo = new TenantAddresInfoModel();
		tntAddInfo.setSector(request.getParameter("sector"));;
		tntAddInfo.setCity(request.getParameter("city"));
		tntAddInfo.setCountry(request.getParameter("country"));
		tntAddInfo.setState(request.getParameter("state"));
		tntAddInfo.setPinCode(request.getParameter("pinCode"));
		tntAddInfo.setCreatedBy("KNRAI");
		tntAddInfo.setCreatedOn(new Date());
		
		tntInfo.getAddTnt().add(tntAddInfo);
		tntAddInfo.setTntAddress(tntInfo);
		return tntInfo;
	}
	
	private String ValidTntInfo(TenantInfoModel tntInfo, String valMsg) {
		if (tntInfo.getfName().length()<=3){
			valMsg += "FName, ";
		}if(tntInfo.getlName().length()<=3 ){
			valMsg += "LName, ";
		}if (tntInfo.getGender()== null){
			valMsg += "Gender,";
		}if(tntInfo.getfFName().length()<=3){
			valMsg += "FFName,";
		}if(tntInfo.getfLName().length()<=3){
			valMsg += "FLName , ";
		}if(tntInfo.getTenantStatus()== null){
			valMsg += "Tnt Status , ";
		}if(tntInfo.getAptNo() == null){
			valMsg += "AptNo , ";
		} if(tntInfo.getFlatNo() == null){
			valMsg += "Flat No , ";
		}if(tntInfo.getEmailId().length()<5 ){ 
			valMsg += " EmailId , ";
		}if(tntInfo.getShiftedOn() == null){
			valMsg += " Shifted On , ";
		}if(tntInfo.getShiftedOutOn()!=null){
			valMsg += " Shifted Out On Not null , ";
		}
		System.out.println("Validation Error : " +valMsg + "(Length)");
		 return valMsg;
	}
}
