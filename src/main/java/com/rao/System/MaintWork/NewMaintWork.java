package com.rao.System.MaintWork;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rao.System.PO.DAOPO;
import com.rao.System.PO.POModel;

public class NewMaintWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg="Step 1: Creating Model ";
		ServWorkModel SWDetail= new ServWorkModel();
		try {
			SWDetail=FromValUpdateSOModel(SWDetail, request);
			erMsg+=" Step 2: Form Value update into model Sucessfully ";
			DAOServiceWork.ShowSWInfo(SWDetail);
			erMsg+= "Step 2.1 Show Model value ";
			SWDetail=DAOServiceWork.NewSOInfo(SWDetail, erMsg);
			erMsg+= "Step 4. Execute DAO";
			if (SWDetail.isValid()) { 
				switch (SWDetail.getSPstatus())   { 
				case   1: // Invoice Created in [DB] 
					session.setAttribute("Message",  "  [Maintenance Work] Created Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  "  SWNO: "+SWDetail.getSWNO()+ " already exist");
					response.sendRedirect("SuccessMsg.jsp"); 
					break;
				default: session.setAttribute("Message",  " Technical Issue ! Please contact to System Admin ");
					session.setAttribute("Message",  " Technical Problem [MW] not created");
					erMsg+= "Step 4.1 Technical Problem [MW] not created";
					System.out.println(erMsg);
					response.sendRedirect("SuccessMsg.jsp");
					break; 
				}
			} else {
			  session.setAttribute("Message",  " Technical Issue (PO not created )! Contact to System Admin "  ); 
			  response.sendRedirect("SuccessMsg.jsp"); }
			} catch (Exception e) {
				session.setAttribute("Message", " Technical Issue !  contact to System Admin " + e);
				System.out.println("Technical Issue ! contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
			}
	}
	public static ServWorkModel FromValUpdateSOModel(ServWorkModel SODetail,HttpServletRequest request) {
		try {
			SODetail.setRwaRegNo("MK106"); 
			SODetail.setUID("1"); 
			SODetail.setServiceType(request.getParameter("ServiceType"));
			SODetail.setSWNO(request.getParameter("SerNo"));
			SODetail.setSdate(request.getParameter("SDate"));
			SODetail.setEdate(request.getParameter("EDate"));
			SODetail.setSWStatus(request.getParameter("SerStatus"));
			SODetail.setPName(request.getParameter("SPName"));
			SODetail.setPMobileNo(request.getParameter("CMobileNo"));
			SODetail.setAddress(request.getParameter("VAddress")); 
			SODetail.setCity(request.getParameter("City")); 
			SODetail.setState(request.getParameter("State")); 
			SODetail.setCountry(request.getParameter("Country")); 
			SODetail.setPin(request.getParameter("ZipCode")); 
			SODetail.setServCharge(request.getParameter("SerCharge")); 
			
		}catch(Exception e) {
			System.out.println("Error in Updating Form Value To Pur Model");
		}
	   return SODetail; 
	}
}
