package com.sm.System.FeeDefine;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.Utility.ValidRwaNo;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.FeeType.FeeTypeModel;

public class HDAOFeeDefine {

	public static int createFee(FeeDefineModel feeDefineModel, String erMsg) {
		Transaction transaction = null;
		erMsg+=" Step 2.0 Start HDAO - ";
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			transaction = sessionObj.beginTransaction();
			sessionObj.save(feeDefineModel);
            sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg +=" hibernate commit transaction HDAQ1";
			exeStatus=1;
	   }catch (Exception e) {
			erMsg +="......Catch exception .. \n" + e;
	  		return exeStatus;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}

	public static JsonArray rFeeInfo(FeeDefineModel feeDefineModel, String erMsg) {
        erMsg += " 2.0: start rFeeInfo() " ;
	    JsonArray feeInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
//			String hQLQeuryString = "FROM FeeDefineModel a LEFT JOIN FETCH a.feePrgrammeModels  where a.regNo=:regNo and a.status=:status";
			String hQLQeuryString = "FROM FeeDefineModel  where regNo=:regNo and status=:Fstatus";
			Query<FeeDefineModel> rsQuery = sessionObj.createQuery(hQLQeuryString, FeeDefineModel.class);
			rsQuery.setParameter("regNo", feeDefineModel.getRegNo());
			rsQuery.setParameter("Fstatus","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <FeeDefineModel> rows =  (ArrayList<FeeDefineModel>) rsQuery.list();
	       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
	       int sNO =0;
	        erMsg += " Execute Query OK.:" ;
	       for(FeeDefineModel row: rows) {
	          JsonObject rObj = new JsonObject();
              rObj.put("SNO"        ,Integer.toString(++ sNO)) ;
		      rObj.put("RegNo"      ,row.getRegNo())           ;
		      rObj.put("fGrade"     ,row.getFeeCategory())     ;
		      rObj.put("fClass"     ,row.getStudentClass())    ;
		      rObj.put("fType"      ,row.getFeeType())         ;
		      rObj.put("fTennure"   ,row.getFeeTenure())       ;
		      rObj.put("fIdno"      ,row.getFeeidNo())         ;
			      
//			      List<FeePrgrammeModel> feeSubData = row.getFeePrgrammeModels();
//				    JsonArray feeInfo1 = new JsonArray();
//			      for ( FeePrgrammeModel data:feeSubData) {
//			            JsonObject rObj1 = new JsonObject();
//			    	  rObj1.put("Stream"   , data.getStream());
//			    	  rObj1.put("FeeAmount"   , data.getFeeAmt());
//			    	  rObj1.put("FeeDisocunt"   , data.getFeeDiscount());
//				      feeInfo1.add(rObj1);	
//			    	  
//			      }
//		    	  rObj.put("Fee", feeInfo1);
			      feeInfo.add(rObj);	
	       }
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return feeInfo;
	}

	public static JsonArray rFeeInformation(FeeDefineModel feeDefineModel, String erMsg) {
        erMsg += " 2.0: start rFeeInfo() " ;
	    JsonArray feeInfo = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
//			String hQLQeuryString= "select a.RegNO RegNO,FeeCategory, StudentClass, FeeTenure, FeeType, FeeAmount," 
//			+" FeeDiscount, Stream from FeeMaster a	left join  FeeProgrammeModel b on FeeIdnoFK=FeeIDNO" 
//			+ "where a.RegNO=:regNo and a.status=:status and  b.status=:status";
			String hQLQeuryString = "FROM FeeDefineModel a LEFT JOIN FETCH a.feePrgrammeModels  where a.regNo=:regNo and a.status=:status";

			Query<FeeDefineModel> rsQuery = sessionObj.createQuery(hQLQeuryString, FeeDefineModel.class);
			rsQuery.setParameter("regNo", feeDefineModel.getRegNo());
			rsQuery.setParameter("status","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <FeeDefineModel> rows =  (ArrayList<FeeDefineModel>) rsQuery.list();
	       System.out.println("\nTotal No of Row retrieved:  "+rows.size());
	       int sNO =0;
	        erMsg += " Execute Query OK.:" ;
	       for(FeeDefineModel row: rows) {
			      List<FeePrgrammeModel> feeSubData = row.getFeePrgrammeModels();
			      for ( FeePrgrammeModel data:feeSubData) {
		              JsonObject rObj = new JsonObject();
		              rObj.put("SNO"        ,Integer.toString(++ sNO)) ;
				      rObj.put("RegNo"      ,row.getRegNo())           ;
				      rObj.put("fGrade"     ,row.getFeeCategory())     ;
				      rObj.put("fClass"     ,row.getStudentClass())    ;
				      rObj.put("fType"      ,row.getFeeType())         ;
				      rObj.put("fTennure"   ,row.getFeeTenure())       ;
				      rObj.put("fIdno"      ,row.getFeeidNo())         ;
			          rObj.put("Stream"        , data.getStream());
			    	  rObj.put("FeeAmount"     , data.getFeeAmt());
			    	  rObj.put("FeeDisocunt"   , data.getFeeDiscount()==null?"0":data.getFeeDiscount());
			    	  rObj.put("FPIDNO"   , data.getFpidNo());
				      feeInfo.add(rObj);	
			      }
	       }
	        erMsg += " Update JsonArray OK.:" ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return feeInfo;
	}


	public static JsonArray rFeeSubInfo(FeeDefineModel feeDefineModel, String fIdNo, String erMsg) {
	       erMsg += " 2.0: start rSubInfo() " ;
		    JsonArray feeInfo = new JsonArray();

			System.out.println("\n pkfIdNo :" +fIdNo);
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
				String hQLQeuryString = "FROM FeeDefineModel a LEFT JOIN FETCH a.feePrgrammeModels b where FeeIDNO=:feeIdNo and a.regNo=:regNo and a.status=:status ";

				Query<FeeDefineModel> rsQuery = sessionObj.createQuery(hQLQeuryString, FeeDefineModel.class);
				rsQuery.setParameter("regNo", feeDefineModel.getRegNo());
				rsQuery.setParameter("status","A");
				rsQuery.setParameter("feeIdNo", fIdNo);
				erMsg += " PARAM SET ;" ;
		       ArrayList <FeeDefineModel> rows =  (ArrayList<FeeDefineModel>) rsQuery.list();
		        System.out.println("\nTotal No of Row retrieved:  "+rows.size());
		        int sNO =0;
		        for(FeeDefineModel row: rows) {
			      List<FeePrgrammeModel> feeSubData = row.getFeePrgrammeModels();
			      for ( FeePrgrammeModel data:feeSubData) {
			    	  if(data.getStatus().equals("A")) {
				    	  JsonObject rObj = new JsonObject();
			              rObj.put("SNO"         , Integer.toString(++ sNO)) ;
				    	  rObj.put("Stream"      , data.getStream());
				    	  rObj.put("FeeAmount"   , data.getFeeAmt());
				    	  rObj.put("FeeDisocunt" , data.getFeeDiscount());
				    	  rObj.put("FPIdNo"      , data.getFpidNo());
				    	  rObj.put("FeeIdnoFK"   , row.getFeeidNo());
					      feeInfo.add(rObj);	
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
			return feeInfo;
	}
	
	public static JsonArray removeFeeSubInfo(FeeDefineModel feeDefineModel, String feeSubIDNO, String erMsg) {
		erMsg+="Step 2.Start removing.";
	    JsonArray subjectInfo = new JsonArray();
    	Transaction tr = null; 
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        String HQLString = "Update FeePrgrammeModel set status =:nStatus where FPIDNO =:fPIdNo AND regNo=: RegNo AND  status=:oStatus";
	        Query query = sessionObj.createQuery(HQLString );
	        query.setParameter("nStatus", "D");
	        query.setParameter("RegNo", feeDefineModel.getRegNo());
	        query.setParameter("fPIdNo", feeSubIDNO);
	        query.setParameter("oStatus", "A");
	        tr = sessionObj.beginTransaction();
	        erMsg += " Param setting done ;" ;
	        int executeUpdate= query.executeUpdate();
	        if (executeUpdate>0) {
	        	erMsg+=Integer.toString(executeUpdate) + " record update Successfully";
	        	System.out.println("checking");
	        }
	        erMsg += " removal done.:" ;
	       sessionObj.close();
		}catch(Exception e) { 
			tr.rollback();
			erMsg += "Catch Exception: \n"+ e;
		}finally {System.out.println("\n"+erMsg );}			
		return subjectInfo;
	}
	public static JsonArray removeFeeInfo(FeeDefineModel feeDefineModel, String feeSubIDNO, String erMsg) {
		erMsg+="Step 2.Start removing.";
	    JsonArray subjectInfo = new JsonArray();
    	Transaction tr = null; 
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

	        String HQLString = "Update FeeDefineModel set status =:nStatus where FeeIDNO =:fPIdNo AND regNo=: RegNo AND  status=:oStatus";
	        Query query = sessionObj.createQuery(HQLString );
	        query.setParameter("nStatus", "D");
	        query.setParameter("RegNo", feeDefineModel.getRegNo());
	        query.setParameter("fPIdNo", feeSubIDNO);
	        query.setParameter("oStatus", "A");
	        tr = sessionObj.beginTransaction();
	        erMsg += " Param setting done ;" ;
	        int executeUpdate= query.executeUpdate();
	        if (executeUpdate>0) {
	        	erMsg+=Integer.toString(executeUpdate) + " record update Successfully";
	        	System.out.println("checking");
	        }
	        erMsg += " removal done.:" ;
	       sessionObj.close();
		}catch(Exception e) { 	
			tr.rollback();
			erMsg += "Catch Exception: \n"+ e;

		}finally {System.out.println("\n"+erMsg );}			
		return subjectInfo;
	}	
	public static String getFeeIDNO( FeeDefineModel feeDefineModel,String feeIDNO) {
        String erMsg = " start getFeeIDNO() " ;
        FeeDefineModel feeIDFK ;
        String FPIDNO="";
        String regNum= feeDefineModel.getRegNo();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			String hQLQeury= "from FeePrgrammeModel where FPIDNO=:fPIDNO and RegNO=:regNo and status=:FSstatus";
			Query<FeePrgrammeModel> rsQuery = sessionObj.createQuery(hQLQeury, FeePrgrammeModel.class);
			rsQuery.setParameter("regNo", regNum );
			rsQuery.setParameter("fPIDNO", feeIDNO);
			rsQuery.setParameter("FSstatus","A");
	        erMsg += " PARAM SET ;" ;
	       ArrayList <FeePrgrammeModel> rows =  (ArrayList<FeePrgrammeModel>) rsQuery.list();
	        erMsg += " Execute Query OK.:Records -->" +rows.size();
	       for(FeePrgrammeModel row: rows) {
              feeIDFK = row.getFeeDefineModel();
             FPIDNO= Integer.toString(feeIDFK.getFeeidNo());
	       }
	       erMsg += " GetFeeIDNO : "+ FPIDNO ;
	       sessionObj.close();
		}catch(Exception e) {
	    	erMsg += "Catch Exception: \n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return FPIDNO;
	}
	
}
