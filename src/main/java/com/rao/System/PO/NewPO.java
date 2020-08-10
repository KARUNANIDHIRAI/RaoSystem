package com.rao.System.PO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rao.System.PurchaseMaterial.DAOFinalPurMaterial;
import com.rao.System.PurchaseMaterial.PurMatModel;

public class NewPO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			System.out.println("Step1: Creating Model ");
			POModel PODetail= new POModel();
			try {
				PODetail=FromValUpdatePOModel(PODetail, request);
				System.out.println("Step2: Form Value update into model Sucessfully ");
				DAOPO.ShowPOInfo(PODetail);
				PODetail=DAOPO.NewPOInfo(PODetail);
				System.out.println("Step4: Execute DAO Sucessfully ");
				
				  if (PODetail.isValid()) { 
					  switch (PODetail.getSPstatus())   { 
					  case 0: // Technical Issue
							session.setAttribute("Message",  " Technical Problem [PO] not created");
							System.out.println("Technical Problem [PO] not created");
							response.sendRedirect("SuccessMsg.jsp");
							break; 
					case   1: // Invoice Created in [DB] 
						session.setAttribute("Message",  "  PO Created Successfully");
						response.sendRedirect("SuccessMsg.jsp");
						break;
					case 2:
						session.setAttribute("Message",  "  PO: "+PODetail.getPONo()+ " already exist");
						System.out.println(" PO already exist");
						response.sendRedirect("SuccessMsg.jsp"); 
						break;
					default: session.setAttribute("Message",  " Technical Issue ! Please contact to System Admin ");
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
		public static POModel FromValUpdatePOModel(POModel PODetail,HttpServletRequest request) {
			try {
				PODetail.setRwaRegNO("MK106"); 
				PODetail.setUId("1"); 
				PODetail.setPONo(request.getParameter("PONo"));
				PODetail.setPODate(request.getParameter("PODate"));
				PODetail.setCustomerName(request.getParameter("CustomerName"));
				PODetail.setMobileNo(request.getParameter("CMobileNo"));
				PODetail.setAddress(request.getParameter("VAddress")); 
				PODetail.setCity(request.getParameter("City")); 
				PODetail.setState(request.getParameter("State")); 
				PODetail.setCountry(request.getParameter("Country")); 
				PODetail.setPinCode(request.getParameter("ZipCode")); 
				
			}catch(Exception e) {
				System.out.println("Error in Updating Form Value To Pur Model");
			}
		   return PODetail; 
		}

}
