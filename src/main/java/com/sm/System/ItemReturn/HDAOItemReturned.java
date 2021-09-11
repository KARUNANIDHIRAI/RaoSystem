package com.sm.System.ItemReturn;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.ItemBorrow.SMItemBorrowedModel;
import com.sm.System.ItemBorrow.SMItemBorrowedSubModel;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOItemReturned {
	public static int postItemReturnedNew(SMItemReturnSubModel sMIBModel) {

	String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.RETURN
			+ SMFixedValue.INFORMATION + ":";
	Transaction transaction = null;
	int exeStatus = 0;
	try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		Query query = sessionObj.createQuery(SMFixedValue.UPD_ITEMMASTER_OPCLBAL_RETURN);
		query.setParameter(SMFixedValue.PARM_REGNO, sMIBModel.getRegNo());
		query.setParameter(SMFixedValue.PARA_ITEMCODE, sMIBModel.getItemCode());
		query.setParameter(SMFixedValue.PARM_RETURNEDQTY, sMIBModel.getReturnedQty());
		query.setParameter(SMFixedValue.PARM_STATUS, SMFixedValue.STATUS);

		Query query1 = sessionObj.createQuery(SMFixedValue.UPD_ITEM_BORROWED);
		query1.setParameter(SMFixedValue.PARM_IDNO, sMIBModel.getSmITBiDNOFK());
		query1.setParameter(SMFixedValue.PARA_RETURNDATE, sMIBModel.getReturnDate());
		query1.setParameter(SMFixedValue.PARM_STATUS, SMFixedValue.STATUS);
		
		erMsg += SMFixedValue.PARM_SET_MSG + ": ";
		
		transaction = sessionObj.beginTransaction();
		exeStatus = query.executeUpdate(); 
		if (exeStatus > 0) {
			if(query1.executeUpdate()>0) {
				sessionObj.save(sMIBModel);
				sessionObj.getTransaction().commit();
			}; 
		}
		sessionObj.close();
		erMsg += SMFixedValue.EXEC_CREATE_MSG;
		exeStatus = 1;
	} catch (Exception e) {
		erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		if (transaction.isActive()) {
			transaction.rollback();
		}
	} finally {
		System.out.println("\n" + erMsg);
	}
	return exeStatus;
}

public static JsonArray getTodayItemReturnedList(SMItemReturnSubModel sMIBSModel) {
	String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN + SMFixedValue.INFORMATION+ ":";
	JsonArray todayItemList = new JsonArray();
	try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		CriteriaQuery<SMItemReturnModel> creteriaQuery = builder.createQuery(SMItemReturnModel.class);
		Root<SMItemReturnModel> root = creteriaQuery.from(SMItemReturnModel.class);
/*
		creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), sMIBSModel.getRegNo()),
				builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), sMIBSModel.getAdmNo()),
				builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS),
				builder.equal(root.get(SMFixedValue.MODEL_BORROWED_DATE), new Date()));
*/
		creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), sMIBSModel.getRegNo()),
				builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), sMIBSModel.getAdmNo()),
				builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
		erMsg += SMFixedValue.PARM_SET_MSG;

		Query<SMItemReturnModel> query = sessionObj.createQuery(creteriaQuery);
		ArrayList<SMItemReturnModel> rows = (ArrayList<SMItemReturnModel>) query.getResultList();
		erMsg += SMFixedValue.EXEC_QUERY_MSG;
		int sNO = 0;
		for (SMItemReturnModel row : rows) {
			JsonObject rObj = new JsonObject();
			rObj.put("SNO"          , Integer.toString(++sNO));
			rObj.put("RegNo"        , row.getRegNo());
			rObj.put("SAdmNo"       , row.getAdmNo());
			rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
			rObj.put("IssFromDate"  ,row.getSmITBiDNOFK().getBorrowFromDate()==null?"":row.getSmITBiDNOFK().getBorrowFromDate().toString());
			rObj.put("IssToDate"    , row.getSmITBiDNOFK().getBorrowToDate() ==null?"":row.getSmITBiDNOFK().getBorrowToDate().toString());
			rObj.put("RetQty"       , row.getSmITBiDNOFK().getItemBorrowedQty());
			rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
			rObj.put("TakenBy"      , row.getFacultyCodeFK().getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                    + row.getFacultyCodeFK().getlName());
			rObj.put("iDNO", row.getiDNO() + "/" + row.getSmITBiDNOFK().getiDNO() );
			
			
			todayItemList.add(rObj);
		} // EOF outer for loop
		sessionObj.close();
		erMsg += SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.OUTPUT + " Total Rows:" + rows.size()
				+ "\n" + todayItemList;
	} catch (Exception e) {
		erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
	} finally {
		System.out.println("\n" + erMsg);
	}
	return todayItemList;
}
public static JsonArray getItemReturnedList(SMItemReturnModel sMIBSModel) {
	String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN + SMFixedValue.INFORMATION+ ":";
	JsonArray todayItemList = new JsonArray();
	try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		CriteriaQuery<SMItemReturnModel> creteriaQuery = builder.createQuery(SMItemReturnModel.class);
		Root<SMItemReturnModel> root = creteriaQuery.from(SMItemReturnModel.class);

		creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), sMIBSModel.getRegNo()),
				builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), sMIBSModel.getAdmNo()),
				builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
		erMsg += SMFixedValue.PARM_SET_MSG;

		Query<SMItemReturnModel> query = sessionObj.createQuery(creteriaQuery);
		ArrayList<SMItemReturnModel> rows = (ArrayList<SMItemReturnModel>) query.getResultList();
		erMsg += SMFixedValue.EXEC_QUERY_MSG;
		int sNO = 0;
		for (SMItemReturnModel row : rows) {
			JsonObject rObj = new JsonObject();
			rObj.put("SNO"          , Integer.toString(++sNO));
			rObj.put("RegNo"        , row.getRegNo());
			rObj.put("SAdmNo"       , row.getAdmNo());
			rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
			rObj.put("IssFromDate"  ,row.getSmITBiDNOFK().getBorrowFromDate()==null?"":row.getSmITBiDNOFK().getBorrowFromDate().toString());
			rObj.put("IssToDate"    , row.getSmITBiDNOFK().getBorrowToDate() ==null?"":row.getSmITBiDNOFK().getBorrowToDate().toString());
			rObj.put("RetQty"       , row.getSmITBiDNOFK().getItemBorrowedQty());
			rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
			rObj.put("TakenBy"      , row.getFacultyCodeFK().getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                    + row.getFacultyCodeFK().getlName());
			rObj.put("iDNO", row.getiDNO() + "/" + row.getSmITBiDNOFK().getiDNO() );
			
			
			todayItemList.add(rObj);
		} // EOF outer for loop
		sessionObj.close();
		erMsg += SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.OUTPUT + " Total Rows:" + rows.size()
				+ "\n" + todayItemList;
	} catch (Exception e) {
		erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
	} finally {
		System.out.println("\n" + erMsg);
	}
	return todayItemList;
}

	public static int delItemBorrowedidno(SMItemReturnModel sMITBModel) {
		String erMsg = SMFixedValue.ACTION_REMOVING  + SMFixedValue.BORROWED  + SMFixedValue.ITEM + ":";
	    int executeUpdate = 0;
		    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.REM_ITEMISSUE_INFO);
	        query.setParameter(SMFixedValue.PARM_IDNO, sMITBModel.getiDNO());
	        query.setParameter(SMFixedValue.PARM_REGNO, sMITBModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        query.setParameter(SMFixedValue.PARM_OSTATUS, "A");
	
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
		        sessionObj.close();
	        erMsg += Integer.toString(executeUpdate) +" Removed "+SMFixedValue.EXEC_REMOVE_MSG ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;		
	}
	public static JsonArray getTodayItemReturnedList(String regNo, String admNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN + SMFixedValue.TODAY+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemReturnModel> creteriaQuery = builder.createQuery(SMItemReturnModel.class);
			Root<SMItemReturnModel> root = creteriaQuery.from(SMItemReturnModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), admNo),
					builder.equal(root.get(SMFixedValue.MODEL_RETURN_DATE), new Date()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemReturnModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemReturnModel> rows = (ArrayList<SMItemReturnModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemReturnModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  ,row.getSmITBiDNOFK().getBorrowFromDate()==null?"":row.getSmITBiDNOFK().getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getSmITBiDNOFK().getBorrowToDate() ==null?"":row.getSmITBiDNOFK().getBorrowToDate().toString());
				rObj.put("RetQty"       , row.getReturnedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("TakenBy"      , row.getFacultyCodeFK().getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
	                                    + row.getFacultyCodeFK().getlName());
				todayItemList.add(rObj);
			} // EOF outer for loop
			sessionObj.close();
			erMsg += SMFixedValue.OUTPUT + " Total Rows:(" + rows.size() +")" + todayItemList;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return todayItemList;
	}

	public static JsonArray getItemReturnedList(String regNo, String admNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.RETURN + SMFixedValue.TODAY+ ":";
		JsonArray ItemReturnedList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemReturnModel> creteriaQuery = builder.createQuery(SMItemReturnModel.class);
			Root<SMItemReturnModel> root = creteriaQuery.from(SMItemReturnModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), admNo),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemReturnModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemReturnModel> rows = (ArrayList<SMItemReturnModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemReturnModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  ,row.getSmITBiDNOFK().getBorrowFromDate()==null?"":row.getSmITBiDNOFK().getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getSmITBiDNOFK().getBorrowToDate() ==null?"":row.getSmITBiDNOFK().getBorrowToDate().toString());
				rObj.put("RetQty"       , row.getReturnedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("TakenBy"      , row.getFacultyCodeFK().getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
	                                    + row.getFacultyCodeFK().getlName());
				ItemReturnedList.add(rObj);
			} // EOF outer for loop
			sessionObj.close();
			erMsg += SMFixedValue.OUTPUT + " Total Rows:(" + rows.size() +")" + ItemReturnedList;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return ItemReturnedList;
	}

}
