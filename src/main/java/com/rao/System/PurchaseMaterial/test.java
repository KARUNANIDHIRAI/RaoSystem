package com.rao.System.PurchaseMaterial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.rao.System.WaterTankerEntry.DAOWaterTankerDetails;

public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		response.setContentType("text/plain");

		System.out.println("Step1: creating Model Object  ");
		MatModel PurModel = new MatModel();
		JsonArray invoiceItems = new JsonArray();

		String Action = request.getParameter("Action");
		System.out.println("Action:" + Action);	
		PrintWriter out = response.getWriter(); // using becaz of json in javascript

		try {
			switch (Action){
			case "NEW" :
				PurModel = PurMatFormValueToObj(PurModel, request, response);
				System.out.println("\nStep2: Update JSP Page value to  Model Object  ");
				PurModel = DAOPurMaterial.CreateInvoiceItem(PurModel);
				System.out.println("\nStep3: return create InvoiceItem  ");
				if (PurModel.isValid()) {
					System.out.println("\nStep4: Valid SP staus :  " + PurModel.getSPstatus());
					switch  (PurModel.getSPstatus()) {
					case 1: // Record create [DB] JsonArray
						invoiceItems=DAOPurMaterial.retriveInvoiceItems(invoiceItems,PurModel);
						out.print(invoiceItems.toJson());
						out.flush();
						break;
					default:
						session.setAttribute("Message", " Technical Issue ! Please contact to System Admin ");
						response.sendRedirect("SuccessMsg.jsp"); 
						break;
					} 
				} else {
				  out.print("Error in creating Invoice item Please try after some time");
				  out.print(invoiceItems.toJson());
				  out.flush();
				}
				break;
			case "DELETE":
				PurModel = RemoveInvItemToObj(PurModel, request, response);
				System.out.println("Step2: Update JSP Page Remove value to  Model Object  ");
				invoiceItems = DAOPurMaterial.retriveInvoiceItems(invoiceItems, PurModel);
				System.out.println("Step4: retrive updated value after delete item   ");
						out.print(invoiceItems.toJson());
						out.flush();
						break;
			case "EXIST":
				PurModel = RemoveInvItemToObj(PurModel, request, response);
				System.out.println("Step2: Update JSP Page Invoice NO  to  Model Object  ");
				invoiceItems = DAOPurMaterial.retriveInvoiceItems(invoiceItems, PurModel);
				System.out.println("Step4: retrive Invoice items information   ");
						out.print(invoiceItems.toJson());
						out.flush();
						break;
			default:
				out.print(invoiceItems.toJson());
				out.flush();
				break;
			}

			if (Action == "NEW") {
			} else {
			}
			/*
			 * PurModel = DAOPurMaterial.CreateInvoiceItem(PurModel); PrintWriter out =
			 * response.getWriter(); if (PurModel.isValid()) { switch
			 * (PurModel.getSPstatus()) { case 1: // Record Exist [DB] JsonArray
			 * invoiceItems = new JsonArray();
			 * invoiceItems=DAOPurMaterial.retriveInvoiceItems(invoiceItems,PurModel);
			 * 
			 * 
			 * out.print("itemName : " + PurModel.getItemName() +" Quantity :" +
			 * PurModel.getQuantity()); out.print(" Price: " +PurModel.getPrice()
			 * +" Amount :" +PurModel.getAmount()); out.print(" Discount: "
			 * +PurModel.getDisAmount() +" Gst Amount: " + PurModel.getGSTAmount());
			 * out.print(" NetAmount :" + PurModel.getNetAmount());
			 * 
			 * //response.sendRedirect("SuccessMsg.jsp"); out.print(invoiceItems.toJson());
			 * out.flush(); break; default: session.setAttribute("Message",
			 * " Technical Issue ! Please contact to System Admin ");
			 * response.sendRedirect("SuccessMsg.jsp"); break; } } else {
			 * out.print("Error in creating Invoice item Please try after some time"); }
			 */ 
			} catch (Exception e) {
				session.setAttribute("Message", " Technical Issue ! Please contact to System Admin " + e);
				System.out.println("Technical Issue ! Please contact to System Admin " + e);
				response.sendRedirect("SuccessMsg.jsp");
		}

	}

	public static MatModel PurMatFormValueToObj(MatModel PurModel, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			PurModel.setRwaRegNo("MK106");
			PurModel.setUserID("1");
			PurModel.setActionType((String) request.getParameter("Action"));
			PurModel.setInvoiceNo((String) request.getParameter("InvoiceNo"));
			PurModel.setItemName((String) request.getParameter("ItemName"));
			PurModel.setQuantity((String) request.getParameter("Quantity"));
			PurModel.setUnit((String) request.getParameter("Unit"));
			System.out.println("\nUnit: " + PurModel.getUnit());
			PurModel.setPrice((String) request.getParameter("Price"));
			PurModel.setDisRate((String) request.getParameter("DisRate"));
			PurModel.setGSTRate((String) request.getParameter("GSTRate"));
//			float Amt = Integer.parseInt(PurModel.getQuantity()) * Integer.parseInt(PurModel.getPrice());
			float Amt=Float.parseFloat( PurModel.getQuantity()) * Float.parseFloat( PurModel.getPrice()); 
			float DisAmt = (Float.parseFloat( PurModel.getDisRate()) > 0)? ((Amt * Float.parseFloat( PurModel.getDisRate()) / 100))	: 0;
			float GstAmt = (Float.parseFloat( PurModel.getGSTRate()) > 0)? (((Amt - DisAmt) * Float.parseFloat( PurModel.getGSTRate()) / 100)): 0;

			PurModel.setAmount(Float.toString(Amt));
			PurModel.setDisAmount(Float.toString(DisAmt));
			PurModel.setGSTAmount(Float.toString(GstAmt));
			PurModel.setNetAmount(Float.toString(Amt - (GstAmt + DisAmt)));
			

			System.out.print("amt:" + PurModel.getAmount() + " Discount:" + PurModel.getDisAmount() + " GST amount:"
					+ PurModel.getGSTAmount() + "Net Amount :" + PurModel.getNetAmount());
		} catch (Exception e) {
			System.out.println("Error in update From Value to Object: " + e);
		}
		return PurModel;
	}

	public static MatModel RemoveInvItemToObj(MatModel PurModel, HttpServletRequest request,HttpServletResponse response) {

		try {
			PurModel.setRwaRegNo("MK106");
			PurModel.setUserID("1");
			PurModel.setSno((String) request.getParameter("SerialNo"));
			PurModel.setInvoiceNo((String) request.getParameter("InvoiceNo"));
			PurModel.setActionType((String) request.getParameter("Action"));

			System.out.print("RWA No:" + PurModel.getRwaRegNo() + " user ID:" + PurModel.getUserID() + " SNo:"
					+ PurModel.getSno() + "Invoice No :" + PurModel.getInvoiceNo() + PurModel.getActionType());
		} catch (Exception e) {
			System.out.println("Error in update From Value to Object: " + e);
		}
		return PurModel;

	}

}
