package com.sm.StudentFeePayment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;
import com.raoSystem.Utility.Utilities;



/**
 * Servlet implementation class SFeePaymentInfo
 */
public class SFeePaymentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg= "Step1:";
		SFeePayment SiModel = new SFeePayment();
		String Action = request.getParameter("Action");
		System.out.println(Action);
//		JsonArray JsonArrayList = new JsonArray();
//		response.setContentType("text/plain");
//		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		System.out.println("Processing.");

		try {
			switch (Action) {
			case "sFPInfo":	
				System.out.println("Processing..");
				SiModel.setRegNo("MK308");
				SiModel = sFeePaymentToModel(SiModel,request);
				System.out.println("Processing...");
				erMsg = " form value Updated.";
				int rwaStatus = HDAOSFeePayment.sFeePayment(SiModel,erMsg);
				String hDAOMessage= rwaStatus>0?"THANKS! YOUR ENQUIRY SUBMITED SUCCESSFULLY.": "TECHNICAL ERROR! YOUR ENQUIRY NOT SUBMITED. PLS TRY AFTER SOMETIME.";
				session.setAttribute("Message",hDAOMessage );
				response.sendRedirect("SuccessMsg.jsp");
				break;
			case "rInformation" :	//edit informations
				break; 
			case "RWAInformation":	
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}
	}

	private SFeePayment sFeePaymentToModel(SFeePayment siModel, HttpServletRequest request) {
		try {
			siModel.setAdmNo(request.getParameter("sAdmNo"));
			siModel.setsClass(request.getParameter("sClass"));
			siModel.setRollNo(request.getParameter("sRollNo"));
			siModel.setFeePayDate(new Date());
			siModel.setDepositorName(request.getParameter("feeDepName"));
			siModel.setDepositorIdNo(request.getParameter("dIdno"));
			siModel.setDepositorPanNo(request.getParameter("DepPanNo"));
			siModel.setDepositorMobileNo(request.getParameter("DepMobileNo"));
			System.out.println("MOP:"+request.getParameter("paymode"));
			siModel.setmOP(request.getParameter("paymode"));
			siModel.setFeePaid(Integer.parseInt(request.getParameter("sFeeAmt")));
			siModel.setStatus("A");
			siModel.setCreatedBy("KNRAI");
			siModel.setUpdatedBy("KNRAI");
			siModel.setCreatedOn(new Date());
			siModel.setUpdatedOn(new Date());

			FeeChqDDPayment feeChqDDPayment = new FeeChqDDPayment();

			feeChqDDPayment.setRegNo(siModel.getRegNo());
			feeChqDDPayment.setChqDDNo(request.getParameter("ChqNo"));
			feeChqDDPayment.setIssueDate(Utilities.StringToDate(request.getParameter("ChqDate")));
			feeChqDDPayment.setAmount(siModel.getFeePaid());
			feeChqDDPayment.setCategory(request.getParameter("paymode"));
			feeChqDDPayment.setBankName(request.getParameter("BankName"));
			feeChqDDPayment.setBranchName(request.getParameter("BranchName"));
			feeChqDDPayment.setiFSCode(request.getParameter("IFSCode"));
			feeChqDDPayment.setCity(request.getParameter("City"));
			feeChqDDPayment.setStatus("A");
			System.out.println("siModel:"+ feeChqDDPayment);
			
			siModel.getFChqDDPayment().add(feeChqDDPayment);
			feeChqDDPayment.setSFeePay(siModel);

			System.out.println("\nSP Information: " + siModel);
			
			
		} catch (Exception e) {
			System.out.println("\nError in UpdFormValueToRModel: \n" + e);
		}
		return siModel;
	}

}
