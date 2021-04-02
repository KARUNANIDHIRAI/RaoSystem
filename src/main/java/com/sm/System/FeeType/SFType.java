package com.sm.System.FeeType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.SubjectMaster.HDAOSubjects;
import com.sm.System.SubjectMaster.Subjects;

public class SFType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String erMsg= "Start :";
		System.out.println(erMsg);
		String valMsg=""; 
		FeeTypeModel SiModel = new FeeTypeModel();
		SiModel.setRegNo("MK12708");
		String Action = request.getParameter("Action");
		System.out.println("action :" + Action);
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		erMsg+= "Step1: Initialized. ";
		try {
			switch (Action) {
			case "SFTARInfo":	 // Create New Fee Type
				SiModel = ftToRModel(SiModel,request);
				erMsg = " Model Update OK.";
				int subStatus = HDAOFeeType.nFTInfo(SiModel,erMsg);
				erMsg = " create Status :" + Integer.toString(subStatus);
				
				String hDAOMessage= subStatus>0?"Record added successfully": "TECHNICAL ERROR! PLS TRY AFTER SOMETIME.";
				session.setAttribute("Message",hDAOMessage );
				erMsg = " create Status :" + Integer.toString(subStatus) + ":"+hDAOMessage;

				JsonArrayList = HDAOFeeType.rFTInfo(SiModel, erMsg);
				erMsg +=" Step 3: Generate vlist Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xSFTRI" :	//Retrieve informations
				
//				JsonArrayList = HDAOFeeType.rFTInfo(SiModel, erMsg);
				JsonArrayList = HDAOFeeType.vFTList(SiModel, erMsg);
				erMsg +=" Step 3: Generate vlist Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" Step 3:  vlist done";
				break; 
				
			case "xSFTVI" :	//Valid  FeeTypeCode
				System.out.println("xSFTVI case");
				SiModel.setCode(request.getParameter("code"));
				String valCode = HDAOFeeType.vFTInfo(SiModel, erMsg);
				erMsg +=" Step 3: Valide()  Ok: " + valCode;
				System.out.println("\n valCode :" + valCode);
				out.print(valCode);
				out.flush();
				erMsg +=" Step 3:  vlist done";
				break; 

			case "SFTDRInfo":	 // remove Subject Information
				SiModel = ftToRModel(SiModel,request);
				erMsg +=" 1.1: model updated";
				JsonArrayList = HDAOFeeType.remFTInfo(SiModel, erMsg);
				erMsg +=" 3: removed done.";
				JsonArrayList = HDAOFeeType.rFTInfo(SiModel, erMsg);
				erMsg +=" 4: retrieved info done.";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" Step 5:  completed";
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}

	}

	private FeeTypeModel ftToRModel(FeeTypeModel siModel, HttpServletRequest request) {
		System.out.println("action2 :" );
        try {
			siModel.setCode(request.getParameter("Code"));
			siModel.setName(request.getParameter("Name"));
			siModel.setStatus("A");
			siModel.setCreatedBy("KNRAI");
			siModel.setUpdatedBy("KNRAI");
			siModel.setCreatedOn(new Date());
			siModel.setUpdatedOn(new Date());
			System.out.println("siModel: "+siModel);
        }catch (Exception e) {
        	System.out.println("Error: update value in model");
        }
		return siModel;
	}

	
	
}
