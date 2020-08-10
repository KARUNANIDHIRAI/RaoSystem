package com.rao.System.PurchaseMaterial;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NewPurMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("Step1: Creating Model ");
		PurMatModel InvoiceDetail= new PurMatModel();
		try {
			InvoiceDetail=InvFromValUpdatePurModel(InvoiceDetail, request);
			System.out.println("Step2: Form Value update into model Sucessfully ");
			DAOFinalPurMaterial.ShowInvInfo(InvoiceDetail);
			InvoiceDetail=DAOFinalPurMaterial.NewPurMatDetail(InvoiceDetail);
			System.out.println("Step4: Execute DAO Sucessfully ");
			
			  if (InvoiceDetail.isValid()) { 
				  switch (InvoiceDetail.getSPstatus())   { 
				  case 0: // Technical Issue
						session.setAttribute("Message",  " Technical Problem Invoice not created");
						System.out.println("Technical Problem Invoice not created");
						response.sendRedirect("SuccessMsg.jsp");
						break; 
				case   1: // Invoice Created in [DB] 
					session.setAttribute("Message",  "  Invoice Created Successfully");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				case 2:
					session.setAttribute("Message",  "  Invoice already exist");
					System.out.println(" Invoice already exist");
					response.sendRedirect("SuccessMsg.jsp"); 
					break;
				default: session.setAttribute("Message",  " Technical Issue ! Please contact to System Admin ");
					response.sendRedirect("SuccessMsg.jsp");
					break;
				  }
			  } else {
			  session.setAttribute("Message",  " Technical Issue (Invoice not created )! Contact to System Admin "  ); 
			  response.sendRedirect("SuccessMsg.jsp"); }
			} catch (Exception e) {
				session.setAttribute("Message", " Technical Issue !  contact to System Admin " + e);
				System.out.println("Technical Issue ! contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
		}

	}
	public static PurMatModel InvFromValUpdatePurModel(PurMatModel InvDetail,HttpServletRequest request) {
		try {
		     InvDetail.setRwaRegNo("MK106"); 
		     InvDetail.setUserID("1"); 
		     InvDetail.setInvoiceNo(request.getParameter("InvoiceNo"));
		     InvDetail.setInvoiceDate(request.getParameter("InvoiceDate"));
		     InvDetail.setVendorName(request.getParameter("VendorName"));
		     InvDetail.setVendorAddId(request.getParameter("VAddress")); 
		     InvDetail.setCity(request.getParameter("City")); 
		     InvDetail.setState(request.getParameter("State")); 
		     InvDetail.setCountry(request.getParameter("Country")); 
		     InvDetail.setZipCode(request.getParameter("ZipCode")); 
		     InvDetail.setVMobileNo(request.getParameter("VendorMobileNo"));
		     InvDetail.setHsnNo(request.getParameter("HsnNo"));
		     InvDetail.setCustomerName(request.getParameter("CustomerName"));
		     InvDetail.setCMobileNo(request.getParameter("CMobileNo"));
		     InvDetail.setOrderNO(request.getParameter("OrderNO"));
		     InvDetail.setPaymentMode(request.getParameter("PaymentMode"));
		     InvDetail.setTotBillAmount(request.getParameter("TotBillAmount"));
		     InvDetail.setTotGSTAmount(request.getParameter("TotGSTAmt"));
		     InvDetail.setTotDisAmount(request.getParameter("TotDisAmount"));
		     InvDetail.setNetAmount(request.getParameter("TotNetAmount"));
		}catch(Exception e) {
			System.out.println("Error in Updating Form Value To Pur Model");
		}
	   return InvDetail; 
	}
	 
}
