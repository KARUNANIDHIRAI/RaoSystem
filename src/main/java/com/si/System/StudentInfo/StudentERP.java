package com.si.System.StudentInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.StudentPersonalInfo.HDAOSpInformation;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;


public class StudentERP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_STEP +"1" ;

		StudentPersonalInfoModel  SiModel = new StudentPersonalInfoModel();
		SiModel.setRegNo("MK308");
		SiModel.setEmailId("KARUNANIDHIRAI@YAHOO.COM");

		String Action = request.getParameter(SMFixedValue.ACTION);
		erMsg += Action;

		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "XSTProfile":	 // sTUDNENT LIST FOR MARKING ATTENDANCE
				erMsg +=" Retrive Student Information :";
//				JsonArrayList = HDAOSpInformation.rStudentPersonalInfo(SiModel, erMsg);
				JsonArrayList = HDAOSpInformation.getStudentPInfo(SiModel);
				erMsg +=" done ";
				System.out.println("\nJsonArrayList.toJson()" + JsonArrayList.toJson());
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 
			case "StdPresent" :	//Student Attendance update in db
				break; 
			case "XSTPRDATA" :	//Retrieve Student Test Performance Da	
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}

	}

}
