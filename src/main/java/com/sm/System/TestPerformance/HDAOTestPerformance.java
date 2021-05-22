package com.sm.System.TestPerformance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.UserLogin.UserAddress;
import com.rao.System.UserLogin.UserLoginModel;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.FeeDefine.FeeDefineModel;
import com.sm.System.FeeDefine.FeePrgrammeModel;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;

public class HDAOTestPerformance {

	public static int postSudentTPMData(TestPerformanceModel TPMModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int TPMIdNo= verifyTPMDataExist(TPMModel,erMsg) ;
			if(TPMIdNo == 0) {
				sessionObj.save(TPMModel); // Insert data first time in Parent And Child Table
			}else { // Insert into child table only 
				MarksDetailSubModel TMPDetail = new MarksDetailSubModel();
				List<MarksDetialModel> marksInfo = new ArrayList<MarksDetialModel>();
		        
				marksInfo =  TPMModel.getMarksDetialModel();
		        for(MarksDetialModel row:marksInfo) {
		        	TMPDetail.setAdmNo(row.getAdmNo());
		        	TMPDetail.setRegNo(row.getRegNo());
		        	TMPDetail.setMarksObtained(row.getMarksObtained());
		        	TMPDetail.setMaxMarks(row.getMaxMarks());
		        	TMPDetail.setStatus(row.getStatus());
		        	TMPDetail.setSubject(row.getSubject());
		        	TMPDetail.settPIDNOFk(TPMIdNo);
		        }
				sessionObj.save(TMPDetail);
			}
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" Save Test Perofrmance Data.";
			rwaStatus=1;
	   }catch (Exception e) {
		   System.out.println("HDAOTestPerformance (catch):" + e);
//		   if(transaction!=null ) {
//			   transaction.rollback(); 
//			   System.out.println("HDAOTestPerformance (catch):" + e);
//   		   }
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return rwaStatus;
	}

	public static Integer verifyTPMDataExist(TestPerformanceModel testPerformanceModel, String erMsg) {
        erMsg = " start verifyTPMDataExist(): " ;
        Integer TPMIDFK = 0;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			String hQLQeury= "from TestPerformanceModel "
					 		 +" where regNo=:regNo AND admNo=:sAdmNo AND testType=:TestType"
					 		 +" AND testCycle=:TestCycle AND testCategory =:TestCategory"
					 		 +" AND status=:TPIStatus";
			Query<TestPerformanceModel> rsQuery = sessionObj.createQuery(hQLQeury,TestPerformanceModel.class);
			rsQuery.setParameter("regNo"        , testPerformanceModel.getRegNo());
			rsQuery.setParameter("sAdmNo"       , testPerformanceModel.getAdmNo());
			rsQuery.setParameter("TPIStatus"    , "A");
			rsQuery.setParameter("TestType"     , testPerformanceModel.getTestType());
			rsQuery.setParameter("TestCycle"    , testPerformanceModel.getTestCycle());
			rsQuery.setParameter("TestCategory" , testPerformanceModel.getTestCategory());
			erMsg += " PARAM SET ;" ;
			
	       ArrayList <TestPerformanceModel> rows =  (ArrayList<TestPerformanceModel>) rsQuery.list();
	       for(TestPerformanceModel row: rows) {
	              TPMIDFK = row.gettIdNo();
	              break;
		       }
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return TPMIDFK;
	}
	
	
	
	public static JsonArray KNgetSudentTestData(TestPerformanceModel testPerformanceModel, String erMsg) {
       erMsg += " 2.0: student Test Data Retrieveing. " ;
	    JsonArray studentTestPerformance = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			String fetchTPInfo = "select a.admNo, a.regNo, testCategory, testType,testCycle, "
  								 +" marksObtained, maxMarks, subject, tIdNo , testPerformanceModel " 
 								 +" from TestPerformanceModel a"
 								 +" left join FETCH MarksDetialModel"
 								 +" where a.regNo=:regNo AND a.admNo=:sAdmNo AND testType=:TestType"
 								 +" AND testCycle=:TestCycle AND testCategory =:TestCategory"
 						 		 +" AND a.status=:TPIStatus";
			
			Query<Object[]> rsQuery = sessionObj.createQuery(fetchTPInfo);
			rsQuery.setParameter("regNo"        , testPerformanceModel.getRegNo());
			rsQuery.setParameter("sAdmNo"       , testPerformanceModel.getAdmNo());
			rsQuery.setParameter("TPIStatus"    , "A");
			rsQuery.setParameter("TestType"     , testPerformanceModel.getTestType());
			rsQuery.setParameter("TestCycle"    , testPerformanceModel.getTestCycle());
			rsQuery.setParameter("TestCategory" , testPerformanceModel.getTestCategory());
			erMsg += " PARAM SET ;" ;
	       ArrayList <Object[]> rows = (ArrayList <Object[]>)  rsQuery.list();
	       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
	       int sNO =0;
	        erMsg += " Execute Query OK.:" ;
	       for(Object[] row: rows) {
	          JsonObject rObj = new JsonObject();
              rObj.put("SNO"             , Integer.toString(++ sNO)) ;
              
	    	  rObj.put("AdmNo"         , (String) row[0]);
	    	  rObj.put("RegNo"         , (String) row[1]);
	    	  rObj.put("TCategory"     , (String) row[2]);
	    	  rObj.put("TType"         , (String) row[3]);
	    	  rObj.put("TCycle"        , (String) row[4]);
	    	  rObj.put("MarksObtained" , (String) row[5]);
	    	  rObj.put("MaxMark"       , (String) row[6]);
	    	  rObj.put("Subject"       , (String) row[7]);
	    	  rObj.put("MIDNO"         , (String) row[8]);
	    	  rObj.put("TPIDNOFK"      , (String) row[9]);

	    	  studentTestPerformance.add(rObj);	
	    	  System.out.println("studentTestPerformance : "+studentTestPerformance);
	       }
			System.out.println("\n"+studentTestPerformance );
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return studentTestPerformance;
	}

	public static JsonArray getSudentTestData(TestPerformanceModel testPerformanceModel, String erMsg) {
       erMsg += " 2.0: student Test Data Retrieveing. " ;
	    JsonArray studentTestPerformance = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

//			String fetchTPInfo = "FROM TestPerformanceModel a LEFT JOIN FETCH a.marksDetialModel  where a.regNo=:regNo and  a.admNo=:sAdmNo and a.testType=:TestType and a.testCycle=:TestCycle and a.testCategory=:TestCategory and a.status=:TPIStatus ";
//			Query<TestPerformanceModel> rsQuery = sessionObj.createQuery(fetchTPInfo, TestPerformanceModel.class);
//			rsQuery.setParameter("regNo"        , testPerformanceModel.getRegNo());
//			rsQuery.setParameter("sAdmNo"       , testPerformanceModel.getAdmNo());
//			rsQuery.setParameter("TPIStatus"    , "A");
//			rsQuery.setParameter("TestType"     , testPerformanceModel.getTestType());
//			rsQuery.setParameter("TestCycle"    , testPerformanceModel.getTestCycle());
//			rsQuery.setParameter("TestCategory" , testPerformanceModel.getTestCategory());
//			erMsg += " PARAM SET ;" ;
//	       ArrayList <TestPerformanceModel> rows =  (ArrayList<TestPerformanceModel>) rsQuery.list();
//	        System.out.println("\nPKTotal No of Row retrieved:  "+rows.size());
			
			
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<TestPerformanceModel> creteriaQuery = builder.createQuery(TestPerformanceModel.class);
	        Root<TestPerformanceModel> root = creteriaQuery.from(TestPerformanceModel.class);
//	        root.join("UAdd");
	        root.fetch("marksDetialModel");

	        creteriaQuery.where(builder.equal(root.get("regNo"), testPerformanceModel.getRegNo()),
	        		builder.equal(root.get("admNo"), testPerformanceModel.getAdmNo()),
	        		builder.equal(root.get("status"), "A"),
	        		builder.equal(root.get("testType"), testPerformanceModel.getTestType()),
	        		builder.equal(root.get("testCycle"), testPerformanceModel.getTestCycle()),
		                        builder.equal(root.get("testCategory"),testPerformanceModel.getTestCategory()));
	        
	        Query<TestPerformanceModel> query = sessionObj.createQuery(creteriaQuery);
		       ArrayList <TestPerformanceModel> rows =  (ArrayList<TestPerformanceModel>) query.getResultList();
	        int sNO =0;
	        for(TestPerformanceModel row: rows) {
		    	   List<MarksDetialModel> marksData = row.getMarksDetialModel();
	        	
//		      List<MarksDetialModel> feeSubData = new ArrayList<MarksDetialModel>();
//		      feeSubData= row.getMarksDetialModel();
		      for ( MarksDetialModel data:marksData) {
		    	  if(data.getStatus().equals("A")) {
			    	  JsonObject rObj = new JsonObject();
		              rObj.put("SNO"             , Integer.toString(++ sNO)) ;
			    	  rObj.put("RegNo"         , data.getRegNo());
			    	  rObj.put("Subject"         , data.getSubject());
			    	  rObj.put("MarksObtained"   , data.getMarksObtained());
			    	  rObj.put("MaxMark"         , data.getMaxMarks());
			    	  rObj.put("MIDNO"           , data.getmIdNo());
			    	  rObj.put("TPIDNOFK"        , row.gettIdNo());
			    	  rObj.put("TType", row.getTestType());
			    	  rObj.put("TCycle", row.getTestCycle());
			    	  rObj.put("TCategory", row.getTestCategory());
			    	  studentTestPerformance.add(rObj);	
			    	  System.out.println("studentTestPerformance : "+studentTestPerformance);
		    	  }
		      }
		      break;
		    }
	        erMsg += " Update JsonArray OK.:" ;
	        sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return studentTestPerformance;
	}

}
