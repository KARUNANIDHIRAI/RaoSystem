package com.sm.System.TestPerformance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.TestPerformance.MarksDetailSubModel;
import com.sm.System.TestPerformance.MarksDetialModel;
import com.sm.System.SMInformation.SMFixedValue;

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
	public static JsonArray getTestPerformanceData(TestPerformanceModel SiModel, String erMsg) {
	       erMsg += " 2.0: attendanceSummary() :Generating Student list class and Section wise " ;
		    JsonArray testPerformanceData = new JsonArray();
			try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
				Query<Object[]> rsQuery = sessionObj.createQuery(SMFixedValue.HQL_STUDENT_TEST_PERFORMANCE);
				rsQuery.setParameter("regNO"              , SiModel.getRegNo());
				rsQuery.setParameter("studentClass"       ,SiModel.getsClass());
				rsQuery.setParameter("studentClassSection", SiModel.getSection());
				rsQuery.setParameter("studentClassSection", SiModel.getAdmNo());
				rsQuery.setParameter("Fstatus"            ,SiModel.getStatus());
				System.out.println("Parameter Value: " +SiModel.getRegNo()+": "+ SiModel.getsClass()+": "+SiModel.getSection()+": "+SiModel.getAdmNo() );
				erMsg += " PARAM SET ;" ;
		       ArrayList <Object[]> rows = (ArrayList <Object[]>)  rsQuery.list();
		       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
		       int sNO =0;
		        erMsg += " Execute Query OK.:" ;
		       for(Object[] row: rows) {
		          JsonObject rObj = new JsonObject();
		          rObj.put("SNo"            , Integer.toString(++ sNO)) ;
			      rObj.put("RollNo"         , (String) row[0]) ;
			      rObj.put("TestType"       , (String) row[1]) ;
			      rObj.put("TestCycle"      , (String) row[2]) ;
			      rObj.put("TestCategory"   , (String) row[3]) ;
			      rObj.put("Subject"        , (String) row[4]) ;
			      rObj.put("MarksObtained"  , (Integer)row[5]) ;
			      rObj.put("MaxMarks"       , (Integer)row[6]) ;
			      testPerformanceData.add(rObj);	
		       }
		        erMsg += " Update JsonArray OK.:" ;
		       sessionObj.close();
			}catch(Exception e) {
		    	erMsg += "Catch Exception: \n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return testPerformanceData;		
	}
	public static JsonArray getTestPerformanceDetail(TestPerformanceModel testPerformanceModel, String erMsg) {
	       erMsg += " 2.0: student Test Data Retrieveing. " ;
		    JsonArray studentTestPerformance = new JsonArray();
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<TestPerformanceModel> creteriaQuery = builder.createQuery(TestPerformanceModel.class);
		        Root<TestPerformanceModel> root = creteriaQuery.from(TestPerformanceModel.class);
		        root.fetch("marksDetialModel");

		        creteriaQuery.where(builder.equal(root.get("regNo"), testPerformanceModel.getRegNo()),
		           builder.equal(root.get("admNo"), testPerformanceModel.getAdmNo()),
	        	   builder.equal(root.get("sClass"), testPerformanceModel.getsClass()),
	        	   builder.equal(root.get("section"),testPerformanceModel.getSection()),
		           builder.equal(root.get("status"), testPerformanceModel.getStatus()));
//		        creteriaQuery.orderBy(builder.asc(root.get("tIdNo"))); // using order by on single col
		           List<Order> orderList = new ArrayList<>();
		            orderList.add(builder.asc(root.get("testCycle")));
		            orderList.add(builder.desc(root.get("testType")));
		            orderList.add(builder.desc(root.get("testCategory")));
		            creteriaQuery.orderBy(orderList);
		        
		        
		        Query<TestPerformanceModel> query = sessionObj.createQuery(creteriaQuery);
			       ArrayList <TestPerformanceModel> rows =  (ArrayList<TestPerformanceModel>) query.getResultList();
		        int sNO =0;
		        int id = 0;
			     System.out.println("\nTotal No of Row retrieved:  "+rows.size());
		        for(TestPerformanceModel row: rows) {
		        	if(id==row.gettIdNo()) {
		        		continue;
		        	}
		        	id = row.gettIdNo();	
			    	  JsonObject rObj1 = new JsonObject();
		        	List<MarksDetialModel> marksData = row.getMarksDetialModel();
		        	int counter =0;
			      for ( MarksDetialModel data:marksData) {
			    	  if(data.getStatus().equals("A")) {
				    	  JsonObject rObj = new JsonObject();
//				    	  rObj.put("SNo"           , Integer.toString(++ sNO)) ;
				    	  rObj.put("TestType"      , (String)row.getTestType() +" "+(String)row.getTestCycle());
//				    	  rObj.put("TestCycle"     , (String)row.getTestCycle() );
				    	  rObj.put("TestCategory"  , (String)row.getTestCategory());
				    	  rObj.put("Subject"       , (String)data.getSubject());
				    	  rObj.put("MarksObtained" , (Integer)data.getMarksObtained());
				    	  rObj.put("MaxMarks"      , (Integer)data.getMaxMarks());
				    	  studentTestPerformance.add(rObj);	
			    	  }
			      }
			    }
   	    	  System.out.println("studentTestPerformance : "+studentTestPerformance);
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
