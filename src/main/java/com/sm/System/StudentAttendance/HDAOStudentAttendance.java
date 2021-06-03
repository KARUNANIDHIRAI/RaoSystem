package com.sm.System.StudentAttendance;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;
import com.sm.System.TimeTable.TimeTableModel;

public class HDAOStudentAttendance {
	public static int StundentAttendanceMark( StudentAttendanceModel siModel, Object []inputItems,String erMsg) {
		Transaction transaction = null;
		erMsg+=" Start HDAO StundentAttendanceMark()- ";
		int CreateStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			for(int loopIndex = 0; loopIndex < inputItems.length; loopIndex++){
				StudentAttendanceModel tempSAModel = new StudentAttendanceModel();
				tempSAModel.setRegNo(siModel.getRegNo());
				tempSAModel.setClassTeacher(siModel.getClassTeacher());
				tempSAModel.setsClass(siModel.getsClass());
				tempSAModel.setSection(siModel.getSection());
				tempSAModel.setSPresentDate(siModel.getSPresentDate());
				tempSAModel.setSubject(siModel.getSubject());
				tempSAModel.setStatus(siModel.getStatus());
				tempSAModel.setCreatedBy(siModel.getCreatedBy());
				tempSAModel.setCreatedOn(siModel.getCreatedOn());
				tempSAModel.setsRollNo((String)inputItems[loopIndex]);
				sessionObj.persist(tempSAModel);
		    }
			transaction.commit();
			erMsg +=" insert attendance done.";
			CreateStatus=1;
	   }catch (Exception e) {
		   if(transaction!=null && transaction.isActive()) {
			   transaction.rollback(); 
		   }
			erMsg +="......Catch exception .. \n" + e;
		   	throw e;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return CreateStatus;
	}

	public static JsonArray attendanceSummary(TimeTableModel timeTableModel, String erMsg) {
	       erMsg += " 2.0: attendanceSummary() :Generating Student list class and Section wise " ;
		    JsonArray attendanceSummary = new JsonArray();
			try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
				Query<Object[]> rsQuery = sessionObj.createQuery(SMFixedValue.HQL_STUDENT_ATTENDANCE_SUMMARY);
				rsQuery.setParameter("regNO", timeTableModel.getRegNo());
				rsQuery.setParameter("studentClass",timeTableModel.getClassTT() );
				rsQuery.setParameter("studentClassSection", timeTableModel.getSection());
				rsQuery.setParameter("Fstatus","A");
				System.out.println("Parameter Value: " +timeTableModel.getRegNo()+": "+ timeTableModel.getClassTT()+": "+timeTableModel.getSection() );
				erMsg += " PARAM SET ;" ;
		       ArrayList <Object[]> rows = (ArrayList <Object[]>)  rsQuery.list();
		       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
		       int sNO =0;
		        erMsg += " Execute Query OK.:" ;
		       for(Object[] row: rows) {
		          JsonObject rObj = new JsonObject();
			      Long lcount = (Long) row[3];
				  int atdsHours = lcount.intValue();
				  float atdsAverage = (atdsHours / (Integer) row[2]);
				  System.out.println("pk: "+ atdsAverage);
	              rObj.put("SNo"             , Integer.toString(++ sNO)) ;
			      rObj.put("RegNo"           , (String) row[0]) ;
			      rObj.put("Subject"         , (String) row[1]) ;
			      rObj.put("MaxHours"        , row[2]) ;
			      rObj.put("AttendedHours"   , row[3]) ;
			      rObj.put("AbsentHours"     , ((Integer) row[2]) - atdsHours) ;
			      rObj.put("Average"         , String.format("%.2f",atdsAverage)) ;
			      rObj.put("TotalPercentage" , String.format("%.2f", (float)((atdsHours / (Integer) row[2]) * 100))) ;
			      attendanceSummary.add(rObj);	
		       }
				System.out.println("\n"+attendanceSummary );
		        erMsg += " Update JsonArray OK.:" ;
		       sessionObj.close();
			}catch(Exception e) {
		    	erMsg += "Catch Exception: \n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return attendanceSummary;
		}	

}
