package com.sm.System.TimeTable;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;



public class TimeTableInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Time Table");
		HttpSession session = request.getSession(true);
		TimeTableModel  SiModel = new TimeTableModel();
		SiModel.setRegNo("MK308");

		String Action = request.getParameter("Action");
		String erMsg = "Step 1 : Start " +Action;
		int pSTDStatus = 0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		try {
			switch (Action) {
			case "xTTNDATA":	 // sTUDNENT LIST FOR MARKING ATTENDANCE
				SiModel = UpdateTimeTableDataToModel(SiModel,request);
				erMsg = " : Time Table Model Updated.";
				pSTDStatus = HDAOTimeTable.postTimeTableData(SiModel, erMsg);
				erMsg = " : TT Data Added .";
				JsonArrayList = HDAOTimeTable.getTimeTableData(SiModel,1, erMsg);
				erMsg +="\n Time Table List :"+ JsonArrayList ;
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "StdPresent" :	//Student Attendance update in db
				break; 
			case "xTTRDATA" :	//Retrieve Student Test Performance Da	
				SiModel = UpdateTTDRetrieveCQueryToModel(SiModel,request);
				erMsg = " : TPM Model Updated.";
				JsonArrayList = HDAOTimeTable.getTimeTableData(SiModel, 1, erMsg);
				erMsg +="\n Test Performance List :"+ JsonArrayList ;
				out.print(JsonArrayList.toJson());
				out.flush();
				break; 
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}
	}
	private TimeTableModel UpdateTTDRetrieveCQueryToModel(TimeTableModel siModel, HttpServletRequest request) {
		System.out.println("\nUpdateTTDRetrieveCQueryToModel()");
		Object []inputValues = request.getParameterValues("InputTTRData[]");
		siModel.setSubject((String)inputValues[0]);
		siModel.setClassTT(Integer.parseInt((String)inputValues[1]));
		siModel.setSection((String)inputValues[2]);
		siModel.setStatus("A"); 
		System.out.println("siModel: " + siModel);
		return siModel;
	}

	private TimeTableModel UpdateTimeTableDataToModel(TimeTableModel siModel, HttpServletRequest request) throws ParseException {
		System.out.println("\nUpdateTimeTableDataToModel()");
		Object []inputValues = request.getParameterValues("InputTTValues[]");

		siModel.setSubject(inputValues[0].toString());
		siModel.setClassTT(Integer.parseInt((String)inputValues[1]));
		siModel.setSection(inputValues[2].toString());;
		siModel.setTotalHours(Integer.parseInt(inputValues[3].toString()));
		siModel.setStatus("A"); 
		siModel.setCreatedBy("KNRAI");
		siModel.setCreatedOn(new Date());
		siModel.setUpdatedBy("KNRAI");
		siModel.setUpdatedOn(new Date());
		System.out.println(": siModel ->" +  siModel );

		TimeTableDetailModel timeTableDetailModel = new TimeTableDetailModel();
		timeTableDetailModel.setTeacherName(inputValues[4].toString());
		timeTableDetailModel.setClassDay(inputValues[5].toString());
		timeTableDetailModel.setClassStart(new SimpleDateFormat("HH:mm").parse(inputValues[6].toString()));
		timeTableDetailModel.setClassEnd(new SimpleDateFormat("HH:mm").parse(inputValues[7].toString()));
		timeTableDetailModel.setRegNo(siModel.getRegNo());
		timeTableDetailModel.setStatus(siModel.getStatus());

		siModel.getTTDetailModel().add(timeTableDetailModel);
		timeTableDetailModel.setTimeTableModel(siModel);
		System.out.println("\nUpdation completed: UpdateTimeTableDataToModel()" );
		
		return siModel;
	}
}
