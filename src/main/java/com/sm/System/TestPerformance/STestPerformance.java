package com.sm.System.TestPerformance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JsonArray;

import com.sm.System.StudentAttendance.HDAOStudentAttendance;
import com.sm.System.TimeTable.TimeTableModel;

public class STestPerformance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test performance");
		HttpSession session = request.getSession(true);
		TestPerformanceModel  SiModel = new TestPerformanceModel();
		SiModel.setRegNo("MK308");

		String Action = request.getParameter("Action");
		String erMsg = "Step 1 : Start " +Action;
		System.out.println(erMsg);
		int pSTDStatus = 0;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		System.out.println("\n " + erMsg);
		try {
			switch (Action) {
			case "XSTPDATA":	 // sTUDNENT LIST FOR MARKING ATTENDANCE
				
				SiModel = UpdSTPDataToModel(SiModel,request);
				erMsg = " : TPM Model Updated.";
				pSTDStatus = HDAOTestPerformance.postSudentTPMData(SiModel, erMsg);
				erMsg = " : STPM Added .";
				JsonArrayList = HDAOTestPerformance.getSudentTestData(SiModel, erMsg);
				erMsg +="\n Test Performance List :"+ JsonArrayList ;
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "xTPerfromanceSummary" :	//Retrieve Student Test performance Information
				SiModel = testPerfromanceQueryCriteria(SiModel,request);
				erMsg = " : Time Tabel Model Updated.";
				
				JsonArrayList = HDAOTestPerformance.getTestPerformanceDetail(SiModel, erMsg);
//				JsonArrayList = HDAOTestPerformance.getTestPerformanceData(SiModel, erMsg);
				erMsg +="\n Student List Class and Section wise :"+ JsonArrayList ;
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "XSTPRDATA" :	//Retrieve Student Test Performance Da	
				SiModel = UpdSTPRetrieveDataToModel(SiModel,request);
				erMsg = " : TPM Model Updated.";
				JsonArrayList = HDAOTestPerformance.getSudentTestData(SiModel, erMsg);
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

	private TestPerformanceModel testPerfromanceQueryCriteria(TestPerformanceModel siModel,
			HttpServletRequest request) {
		System.out.println("\n Update testPerfromanceQueryCriteria into timeTableModel.");
		siModel.setRegNo("MK308");
		siModel.setsClass("11");
		siModel.setSection("A");
		siModel.setAdmNo("RA19002030525");
		siModel.setStatus("A"); 
		System.out.println(": timeTableModel ->" +  siModel.getRegNo() + " ," + siModel.getsClass()+ 
				" ," +siModel.getSection() + " ," + siModel.getStatus() + " ," + siModel.getAdmNo());

		return siModel;
	}

	private TestPerformanceModel UpdSTPRetrieveDataToModel(TestPerformanceModel siModel, HttpServletRequest request) {
		System.out.println("\nUpdSTPDataToModel()");
		Object []inputValues = request.getParameterValues("InputSTPRetvData[]");
		siModel.setAdmNo((String)inputValues[0]);
		siModel.setTestType((String)inputValues[1]);
		siModel.setTestCycle((String)inputValues[2]);
		siModel.setTestCategory((String)inputValues[3]);
		siModel.setStatus("A"); 
		System.out.println("siModel: " + siModel);
		return siModel;
	}

	private TestPerformanceModel UpdSTPDataToModel(TestPerformanceModel siModel, HttpServletRequest request) {
		System.out.println("\nUpdSTPDataToModel()");
		Object []inputValues = request.getParameterValues("InputMarksValues[]");
		Object []inputSPInfo = request.getParameterValues("SPInfo[]");

		siModel.setAdmNo(request.getParameter("SAdmNo"));
		siModel.setsClass(inputSPInfo[0].toString());
		siModel.setSection(inputSPInfo[1].toString());;
		siModel.setRollNo(inputSPInfo[2].toString());
		siModel.setTestType((String)inputValues[0]);
		siModel.setTestCycle((String)inputValues[1]);
		siModel.setTestCategory((String)inputValues[2]);
		siModel.setStatus("A"); 
		siModel.setCreatedBy("KNRAI");
		siModel.setCreatedOn(new Date());
		siModel.setUpdatedBy("KNRAI");
		siModel.setUpdatedOn(new Date());
		System.out.println(": siModel ->" +  siModel );

		MarksDetialModel marksDetialModel = new MarksDetialModel();
		marksDetialModel.setRegNo(siModel.getRegNo());
		marksDetialModel.setAdmNo(siModel.getAdmNo());
		marksDetialModel.setSubject((String)inputValues[3]);
		marksDetialModel.setMarksObtained(Integer.parseInt((String)inputValues[4]));
		marksDetialModel.setMaxMarks(Integer.parseInt((String)inputValues[5]));
		marksDetialModel.setStatus(siModel.getStatus());

		siModel.getMarksDetialModel().add(marksDetialModel);
		marksDetialModel.setTestPerformanceModel(siModel);
		System.out.println("\nUpdSTPDataToModel:" + marksDetialModel);
		
		return siModel;
	}


}
