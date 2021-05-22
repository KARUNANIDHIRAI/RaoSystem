package com.sm.System.StudentAttendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JsonArray;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.FeeDefine.FeeDefineModel;
import com.sm.System.FeeDefine.FeePrgrammeModel;
import com.sm.System.FeeDefine.HDAOFeeDefine;
import com.sm.System.StudentPersonalInfo.HDAOSpInformation;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;

public class StudentAttendanceInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		StudentPersonalInfoModel SiModel = new StudentPersonalInfoModel();
		SiModel.setRegNo("MK308");

		String Action = request.getParameter("Action");
		String erMsg = "Step 1 : Start " +Action;
		JsonArray JsonArrayList = new JsonArray();
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter(); // using becaz of json in javascript
		String FeeIDNO="";
		System.out.println("\n " + erMsg);
		try {
			switch (Action) {
			case "SAtdInfo":	 // sTUDNENT LIST FOR MARKING ATTENDANCE
				SiModel = sSearchInfoToSPIModel(SiModel,request);
				erMsg = " : Attendance Model Updated.";
				JsonArrayList = HDAOSpInformation.rStudentListClassSectionWise(SiModel, erMsg);
				erMsg +="\n Student List Class and Section wise :"+ JsonArrayList ;
				out.print(JsonArrayList.toJson());
				out.flush();
				break;
			case "StdPresent" :	//Student Attendance update in db
				erMsg +=" : Mark Student Attendance Model : ";
				Object []sAttendanceValue = request.getParameterValues("attendance[]");
				System.out.println("inputItems:" + sAttendanceValue.length);
				StudentAttendanceModel sAModel = new StudentAttendanceModel();
				sAModel.setRegNo("MK308");
				sAModel = sAttendnceToSPIModel(sAModel,request);
				erMsg = " Updated.";
				int CreateStatus = HDAOStudentAttendance.StundentAttendanceMark(sAModel, sAttendanceValue, erMsg);
				System.out.println("\nCreateStatus" + CreateStatus);

				out.print(JsonArrayList.toJson());
				out.flush();
				
				break; 
				
			case "XFeeVr" :	//Retrieve Fee sub Record
				break; 
	
			}
		} catch (Exception e) {
			System.out.println("Technical Error"+ e);
		}
		finally {
			System.out.println(erMsg);
		}

	}

	private StudentPersonalInfoModel sSearchInfoToSPIModel(StudentPersonalInfoModel siModel,	HttpServletRequest request) {
		System.out.println("\nsSearchInfoToSPIModel()");
		Object []items = request.getParameterValues("InputValues[]");
		siModel.setAdmInClass(items[1].toString());;
		siModel.setRollNo(items[3].toString());
		siModel.setStatus("A"); 
		System.out.println(": siModel ->" +  siModel );
		return siModel;
	}
	private StudentAttendanceModel sAttendnceToSPIModel(StudentAttendanceModel sAModel,	HttpServletRequest request) {
		System.out.println("\nsAttendnceToSPIModel()");
		Object []inputValues = request.getParameterValues("InputValues[]");
		System.out.println("AttendanceInfo:" + inputValues.length);

		sAModel.setClassTeacher(inputValues[0].toString());;
		sAModel.setsClass(inputValues[1].toString());
		sAModel.setSection(inputValues[2].toString());;
		sAModel.setsRollNo(inputValues[3].toString());
		sAModel.setSubject(inputValues[4].toString());
		sAModel.setSPresentDate(new Date());
		sAModel.setStatus("A"); 
		sAModel.setCreatedBy("KNRAI");
		sAModel.setCreatedOn(new Date());
		System.out.println(": sAModel ->" +  sAModel );
		return sAModel;
	}

}
