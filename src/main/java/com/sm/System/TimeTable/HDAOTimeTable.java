package com.sm.System.TimeTable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;


public class HDAOTimeTable {
	public static int postTimeTableData(TimeTableModel timeTableModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 3.0 Start HDAO - ";
		int rwaStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			int tempTTIdNoFK= verifyTTDataExist(timeTableModel,erMsg) ;
			if(tempTTIdNoFK == 0) {
				sessionObj.save(timeTableModel); // Insert data first time in Parent And Child Table
			}else { // Insert into child table only 
				TimeTableSubModel timeTableSubModel = new TimeTableSubModel();
				List<TimeTableDetailModel> timeTableDetailInfo = new ArrayList<TimeTableDetailModel>();
				timeTableDetailInfo =  timeTableModel.getTTDetailModel();
		        for(TimeTableDetailModel row:timeTableDetailInfo) {
		        	timeTableSubModel.setRegNo(row.getRegNo());
		        	timeTableSubModel.setTeacherName(row.getTeacherName());
		        	timeTableSubModel.setClassDay(row.getClassDay());
		        	timeTableSubModel.setClassStart(row.getClassStart());
		        	timeTableSubModel.setClassEnd(row.getClassEnd());
		        	timeTableSubModel.setStatus(row.getStatus());
		        	timeTableSubModel.settTIDNOFK(tempTTIdNoFK);
		        }
				sessionObj.save(timeTableSubModel);
			}
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" Save Test Perofrmance Data.";
			rwaStatus=1;
	   }catch (Exception e) {
		   System.out.println("HDAOTestPerformance (catch):" + e);
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return rwaStatus;
	}

	public static Integer verifyTTDataExist(TimeTableModel timeTableModel, String erMsg) {
        erMsg = " start verifyTtDataExist(): " ;
        Integer TPMIDFK = 0;
        String FETCH_TTDATA = "FROM TimeTableModel "
   	 		 + " WHERE regNo=:RegNo AND subject=:Subject AND classTT=:ClassTT"
   	 		 + " AND section=:Section AND status=:Status";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			
			Query<TimeTableModel> rsQuery = sessionObj.createQuery(FETCH_TTDATA);
			rsQuery.setParameter("RegNo"    , timeTableModel.getRegNo());
			rsQuery.setParameter("Subject"  , timeTableModel.getSubject());
			rsQuery.setParameter("ClassTT"  , Integer.parseInt(timeTableModel.getClassTT().toString()));
			rsQuery.setParameter("Section"  , timeTableModel.getSection());
			rsQuery.setParameter("Status" , "A");
			erMsg += " PARAM SET ;" ;
			
	       ArrayList <TimeTableModel> rows =  (ArrayList<TimeTableModel>) rsQuery.list();
	       for(TimeTableModel row: rows) {
	              TPMIDFK = row.gettTIdNo();
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
	public static JsonArray getTimeTableData(TimeTableModel timeTableModel, int tTDataType, String erMsg) {
       erMsg += " 2.0: Time Table Data Retrieveing. " ;
	    JsonArray timeTableData = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<TimeTableModel> creteriaQuery = builder.createQuery(TimeTableModel.class);
	        Root<TimeTableModel> root = creteriaQuery.from(TimeTableModel.class);
	        root.fetch("TTDetailModel");
	        switch (tTDataType){
	        case 1: // retrive Time Table Data for a school for particual  class,subject  and section 
		        creteriaQuery.where(builder.equal(root.get("regNo"), timeTableModel.getRegNo()),
		        		builder.equal(root.get("subject"), timeTableModel.getSubject()),
		        		builder.equal(root.get("classTT"), timeTableModel.getClassTT()),
		        		builder.equal(root.get("section"), timeTableModel.getSection()),
		        		builder.equal(root.get("status"), "A"));
	        	break;
	        case 2:// retrive Time Table Data for a school for particual class and subject 
		        creteriaQuery.where(builder.equal(root.get("regNo"), timeTableModel.getRegNo()),
		        		builder.equal(root.get("subject"), timeTableModel.getSubject()),
		        		builder.equal(root.get("classTT"), timeTableModel.getClassTT()),
		        		builder.equal(root.get("status"), "A"));
	        	break;
	        case 3:// retrive Time Table Data for a school for particual class 
		        creteriaQuery.where(builder.equal(root.get("regNo"), timeTableModel.getRegNo()),
		        		builder.equal(root.get("classTT"), timeTableModel.getClassTT()),
		        		builder.equal(root.get("status"), "A"));
	        	break;
	        default:
	        	sessionObj.close();
	        	return timeTableData;
	        }
	        Query<TimeTableModel> query = sessionObj.createQuery(creteriaQuery);
		       ArrayList <TimeTableModel> rows =  (ArrayList<TimeTableModel>) query.getResultList();
	        int sNO =0;
	        for(TimeTableModel row: rows) {
		    	   List<TimeTableDetailModel> timeTableinfo = row.getTTDetailModel();
	        	
		      for ( TimeTableDetailModel data:timeTableinfo) {
		    	  if(data.getStatus().equals("A")) {
			    	  JsonObject rObj = new JsonObject();
		              rObj.put("SNO"        , Integer.toString(++ sNO)) ;
			    	  rObj.put("RegNo"      , row.getRegNo());
			    	  rObj.put("Subject"    , row.getSubject());
			    	  rObj.put("Class"      , row.getClassTT());
			    	  rObj.put("Section"    , row.getSection());
			    	  rObj.put("TTIDNOFK"   , row.gettTIdNo());
			    	  rObj.put("Teacher"    , data.getTeacherName());
			    	  rObj.put("Day"        , data.getClassDay());
			    	  rObj.put("ClassEnd"   , data.getClassEnd().toString());
			    	  rObj.put("ClassStart" , data.getClassStart().toString());
			    	  rObj.put("TTDIDNO"      , data.gettTDIdNo());
			    	  timeTableData.add(rObj);	
			    	  System.out.println("TIME TABLE : "+timeTableData);
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
		return timeTableData;
	}
}
