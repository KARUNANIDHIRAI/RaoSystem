package com.sm.System.FeeDefine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;


public class FeeDefineInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		FeeDefineModel feeDefineModel = new FeeDefineModel();
		feeDefineModel.setRegNo("MK107");

		String erMsg = "Step 1 : Start ";
		String Action = request.getParameter("Action");
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		erMsg+= "Step1: DF Initialized. ";
		String FeeIDNO="";
	
		try {
			switch (Action) {
			case "SFDInfo":	 // Create New Fee Type
				feeDefineModel = feeToRModel(feeDefineModel,request);
				erMsg = " DFModel Update OK.";
				int subStatus = HDAOFeeDefine.createFee(feeDefineModel,erMsg);
				erMsg += " create NF Status :" + Integer.toString(subStatus);
				String hDAOMessage= subStatus>0?"Record added successfully": "TECHNICAL ERROR! PLS TRY AFTER SOMETIME.";
				session.setAttribute("Message",hDAOMessage );
				erMsg  +=  ", "+hDAOMessage;
				JsonArrayList = HDAOFeeDefine.rFeeInfo(feeDefineModel, erMsg);
//				JsonArrayList = HDAOFeeDefine.rFeeInformation(feeDefineModel, erMsg);
				erMsg +="\n Fee Summary after Addition :"+ JsonArrayList ;
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xSFIR1" :	//Retrieve informations
				erMsg +=" Retrive Fee Information :";
				
				JsonArrayList = HDAOFeeDefine.rFeeInfo(feeDefineModel, erMsg);
				erMsg +=" Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" : Retrieve info done";
				break; 
				
			case "XFeeDr" :	//Remove Fee information Record
				erMsg +=" Remove SubFee IDNO: " + request.getParameter("Code");
				FeeIDNO =request.getParameter("Code");
				JsonArrayList = HDAOFeeDefine.removeFeeInfo(feeDefineModel, FeeIDNO, erMsg);
				erMsg +=" completed, Retrieve fee info after removed";
				JsonArrayList = HDAOFeeDefine.rFeeInfo(feeDefineModel, erMsg);
				erMsg +=" Ok";
				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 
			case "XFeeVr" :	//Retrieve Fee sub Record
				FeeIDNO =request.getParameter("Code");
				erMsg +="\nRetrive Fee Information:";
				JsonArrayList = HDAOFeeDefine.rFeeSubInfo(feeDefineModel, FeeIDNO, erMsg);
				erMsg +="  completed:"+ JsonArrayList ;

				System.out.println("\n" + JsonArrayList);
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 
			case "XFeeSubDLR" :	//Remove Fee sub Record
				erMsg +="XFeeSubDLR(): Retrieve FPIDNO ";
				String FeeSubIDNO =request.getParameter("Code");
				String SFeeIDNO= HDAOFeeDefine.getFeeIDNO(feeDefineModel,FeeSubIDNO);
				erMsg +=" completed: "+ SFeeIDNO ;

				erMsg +=" removeFeeSubInfo(): Remove SubFee Information ";
				JsonArrayList = HDAOFeeDefine.removeFeeSubInfo(feeDefineModel, FeeSubIDNO, erMsg);
				erMsg +="  completed, rFeeSubInfo() : Retrieve Fee sub info ";

				JsonArrayList = HDAOFeeDefine.rFeeSubInfo(feeDefineModel, SFeeIDNO, erMsg);
				out.print(JsonArrayList.toJson());
				out.flush();
				erMsg +=" completed: ";
				break; 
	
			case "SFTDRInfo":	 // remove Subject Information
//				SiModel = ftToRModel(SiModel,request);
//				erMsg +=" 1.1: model updated";
//				JsonArrayList = HDAOFeeType.remFTInfo(SiModel, erMsg);
//				erMsg +=" 3: removed done.";
//				JsonArrayList = HDAOFeeType.rFTInfo(SiModel, erMsg);
//				erMsg +=" 4: retrieved info done.";
//				System.out.println("\n" + JsonArrayList);
//				out.print(JsonArrayList.toJson());
//				out.flush();
//				erMsg +=" Step 5:  completed";
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}
	
		
	}

	private FeeDefineModel feeToRModel(FeeDefineModel feeDefineModel, HttpServletRequest request) {
		feeDefineModel.setFeeCategory(request.getParameter("fGrade"));
		feeDefineModel.setFeeType(request.getParameter("fType"));
		feeDefineModel.setFeeTenure(request.getParameter("fSlab"));
		feeDefineModel.setStudentClass(request.getParameter("feeApl"));
		feeDefineModel.setStatus("A"); 
//		feeDefineModel.setCreatedBy("KNRAI");
//		feeDefineModel.setUpdatedBy("KNRAI");
//		feeDefineModel.setCreatedOn(new Date());
//		feeDefineModel.setUpdatedOn(new Date());

		String [] items = request.getParameterValues("selec[]");

        for(int loopIndex = 0; loopIndex < items.length; loopIndex++){
        	FeePrgrammeModel feePrgrammeModel = new FeePrgrammeModel();
        	feePrgrammeModel.setRegNo(feeDefineModel.getRegNo());
        	feePrgrammeModel.setStatus("A");
        	feePrgrammeModel.setStream(items[loopIndex]);
        	feePrgrammeModel.setFeeAmt(request.getParameter("feeAmount"));
        	feePrgrammeModel.setFeeDiscount(request.getParameter("DAmt"));
        	System.out.println("pk: feeAmt"+ feePrgrammeModel.getFeeAmt() + " disAmt :" + feePrgrammeModel.getFeeDiscount() 
        	                         +  "school:"+ feePrgrammeModel.getRegNo()
        	                         + "Status:" + feePrgrammeModel.getStatus()+ "Stream:"+ feePrgrammeModel.getStream());

        	System.out.println("pk: "+ feePrgrammeModel);
        	System.out.println("\n "+items[loopIndex] );
        	feeDefineModel.getFeePrgrammeModels().add(feePrgrammeModel);

        	feePrgrammeModel.setFeeDefineModel(feeDefineModel);
        }
		return feeDefineModel;
	}
	private void viewfeeToRModel(FeeDefineModel feeDefineModel) {
		System.out.println("School:"  +feeDefineModel.getRegNo()   + ", FeeGrade:" + feeDefineModel.getFeeCategory()
				        +", FeeType:" +feeDefineModel.getFeeType() + ", school:" + feeDefineModel.getStudentClass()
				        +", FeeTennure :" + feeDefineModel.getFeeTenure());
		feeDefineModel.setStatus("A"); 
//		feeDefineModel.setCreatedBy("KNRAI");
//		feeDefineModel.setUpdatedBy("KNRAI");
//		feeDefineModel.setCreatedOn(new Date());
//		feeDefineModel.setUpdatedOn(new Date());

		return ;
	}

	
}
