package com.sm.System.StudentAttendance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;

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

}
