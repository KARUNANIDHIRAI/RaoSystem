package com.sm.System.ItemLost;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.ItemBorrow.SMItemBorrowedModel;
import com.sm.System.ItemReturn.SMItemReturnModel;
import com.sm.System.ItemReturn.SMItemReturnSubModel;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOItemLost {
	public static int postItemLostNew(SMItemLostSubModel sMILModel) {

	String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.RETURN
			+ SMFixedValue.INFORMATION + ":";
	Transaction transaction = null;
	int exeStatus = 0;
	try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		transaction = sessionObj.beginTransaction();

		CriteriaBuilder cb = sessionObj.getCriteriaBuilder();
		CriteriaUpdate<SMItemBorrowedModel> updITLost = 	cb.createCriteriaUpdate(SMItemBorrowedModel.class);
		Root root = updITLost.from(SMItemBorrowedModel.class); 
		updITLost.set(SMFixedValue.MODEL_BorrowedStatus, "L");
		updITLost.where(cb.equal(root.get(SMFixedValue.MODEL_IDNO), sMILModel.getSmITBiDNOFK()),
				        cb.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
		erMsg += SMFixedValue.PARM_SET_MSG + " ;";

		exeStatus = sessionObj.createQuery(updITLost).executeUpdate();
		if (exeStatus > 0) {
			sessionObj.save(sMILModel);
			sessionObj.getTransaction().commit();
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

	public static JsonArray getTodayLostItemReported(String regNo, String admNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.LOST + SMFixedValue.TODAY+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemLostModel> creteriaQuery = builder.createQuery(SMItemLostModel.class);
			Root<SMItemLostModel> root = creteriaQuery.from(SMItemLostModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), admNo),
					builder.equal(root.get(SMFixedValue.MODEL_LOST_DATE), new Date()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemLostModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemLostModel> rows = (ArrayList<SMItemLostModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemLostModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  ,row.getSmITBiDNOFK().getBorrowFromDate()==null?"":row.getSmITBiDNOFK().getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getSmITBiDNOFK().getBorrowToDate() ==null?"":row.getSmITBiDNOFK().getBorrowToDate().toString());
				rObj.put("LostQty"       , row.getLostQty());
				rObj.put("LostDate"       , row.getLostDate()==null?"":row.getLostDate().toString());
				rObj.put("RecordedBy"      , row.getFacultyCodeFK().getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
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
	
	public static JsonArray getLostItemList(String regNo, String admNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.LOST + SMFixedValue.TODAY+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemLostModel> creteriaQuery = builder.createQuery(SMItemLostModel.class);
			Root<SMItemLostModel> root = creteriaQuery.from(SMItemLostModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), admNo),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemLostModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemLostModel> rows = (ArrayList<SMItemLostModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemLostModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  ,row.getSmITBiDNOFK().getBorrowFromDate()==null?"":row.getSmITBiDNOFK().getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getSmITBiDNOFK().getBorrowToDate() ==null?"":row.getSmITBiDNOFK().getBorrowToDate().toString());
				rObj.put("LostQty"       , row.getLostQty());
				rObj.put("LostDate"       , row.getLostDate()==null?"":row.getLostDate().toString());
				rObj.put("RecordedBy"      , row.getFacultyCodeFK().getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
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

}
