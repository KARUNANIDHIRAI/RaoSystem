package com.raoSystem.FLTOWN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.raoSystem.Utility.Utilities;

public class HFlatOwnerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String erMsg = "Step 1: Start OK";
		HFlatOwnerModel hFOInfo = new HFlatOwnerModel();
		String action = request.getParameter("Action");
		String spStatus = "";
		try {
			switch (action) {
			case "fONew" :
				hFOInfo = updateFOjspValue(hFOInfo,request);
				erMsg += "updateFOjspValue OK: ";
				showFOValue(hFOInfo);
				erMsg += "showFOValue OK: ";
				spStatus = HDAOFlatOwner.FOInfoCreate(hFOInfo, erMsg);
				System.out.println("spStatus :"+spStatus+ "length"+spStatus.length());
				if(Utilities.SQLerNo(spStatus)==2) {
					session.setAttribute("Message","Record Already exist" );
					response.sendRedirect("OwnerInformation/OwnerInfoNew.jsp");
				}else {
					String hDAOMessage= spStatus.length()==1?"Record Created Successfully.":"Record not created. Technical Error.";
					session.setAttribute("Message",hDAOMessage );
					response.sendRedirect("SuccessMsg.jsp");
				}
				break;
			}
		} catch (Exception e) {
			System.out.println(" Techincal Error "+ e);
		}finally {
			System.out.println("  Error: "+erMsg);
		}
	}
	private void showFOValue(HFlatOwnerModel hFOInfo) {
		System.out.println(" RwaNo: "+ hFOInfo.getRwaRegNo()+ " AptNo : "+ hFOInfo.getAptNo()+ " FltNo: "+ hFOInfo.getFlatNo()+ 
				" Fname: "+ hFOInfo.getfName()+ " Lname: "+ hFOInfo.getlName()+ " Gender: "+ hFOInfo.getGender()+ " fFName: "+ hFOInfo.getfFName()+
				" fFlName: "+ hFOInfo.getfLName());
		System.out.println(" Mobile: "+ hFOInfo.getMobileNo()+ " phoneNo: "+ hFOInfo.getPhoneNo()
				+ " email: "+ hFOInfo.getEmailId());
		
		ArrayList<HFlatOwnerAddress> showFOAdd = new ArrayList<>();
		showFOAdd = (ArrayList<HFlatOwnerAddress>) hFOInfo.getAddRegNo();
		for (HFlatOwnerAddress uadd:showFOAdd) {
			System.out.println(" Sector :"+	uadd.getSector()+ ", City:" + uadd.getCity()
			+ ", State : "+ uadd.getState()+ ", Country"+ uadd.getCountry() + ", PinCode:" +	uadd.getPinCode());
		}
		
		
	}
	private HFlatOwnerModel updateFOjspValue(HFlatOwnerModel hFOInfo, HttpServletRequest request) {
		hFOInfo.setRwaRegNo("MK106");
		hFOInfo.setAptNo(request.getParameter("aptNo"));
		hFOInfo.setFlatNo(request.getParameter("flatNo"));
		hFOInfo.setfName(request.getParameter("fName"));
		hFOInfo.setlName(request.getParameter("lName"));
		hFOInfo.setGender(request.getParameter("gender"));
		hFOInfo.setfFName(request.getParameter("fFName"));
		hFOInfo.setfLName(request.getParameter("fFLname"));
		hFOInfo.setMobileNo(request.getParameter("MobileNo"));
		hFOInfo.setPhoneNo(request.getParameter("phoneNo"));
		hFOInfo.setEmailId(request.getParameter("email"));
		hFOInfo.setCreatedBy("KNRAI");
		hFOInfo.setCreatedOn(new Date());
		hFOInfo.setUpdatedBy("KNRAI");
		hFOInfo.setUpdatedOn(new Date());
		hFOInfo.setStatus("A");
		
		HFlatOwnerAddress hFOAddress = new HFlatOwnerAddress();
		hFOAddress.setSector(request.getParameter("sector"));;
		hFOAddress.setCity(request.getParameter("city"));
		hFOAddress.setCountry(request.getParameter("country"));
		hFOAddress.setState(request.getParameter("state"));
		hFOAddress.setPinCode(request.getParameter("pinCode"));
		hFOAddress.setCreatedBy("KNRAI");
		hFOAddress.setCreatedOn(new Date());
		System.out.println("Address: "+ hFOAddress.getSector() );
		
		hFOInfo.getAddRegNo().add(hFOAddress);
		hFOAddress.setFoAddress(hFOInfo);
	
		return hFOInfo;
	}

}
