package com.sm.System.ItemBorrow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.SLIBM.System.BooksBorrowedReturn.BookBorrowedReturnModel;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOItemBorrowed {

	public static int itemsBorrowedNew(SMItemBorrowedSubModel sMIBModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ITEM + SMFixedValue.BORROWED
				+ SMFixedValue.INFORMATION + ":";
		Transaction transaction = null;
		int exeStatus = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Query query = sessionObj.createQuery(SMFixedValue.UPD_ITEMMASTER_OPCLBAL_ISSUE);
			query.setParameter(SMFixedValue.PARM_REGNO, sMIBModel.getRegNo());
			query.setParameter(SMFixedValue.PARA_ITEMCODE, sMIBModel.getItemCode());
			query.setParameter(SMFixedValue.PARM_ISSUEDQTY, sMIBModel.getItemBorrowedQty());
			query.setParameter(SMFixedValue.PARM_STATUS, sMIBModel.getStatus());
			erMsg += SMFixedValue.PARM_SET_MSG + ": ";

			transaction = sessionObj.beginTransaction();
			exeStatus = query.executeUpdate(); // CHECK AND UPDATE BOOKS AVAILABLE QTY
			if (exeStatus > 0) {
				sessionObj.save(sMIBModel);
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

	public static JsonArray getTodayItemBorrowedList(SMItemBorrowedSubModel sMIBSModel) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedModel> creteriaQuery = builder.createQuery(SMItemBorrowedModel.class);
			Root<SMItemBorrowedModel> root = creteriaQuery.from(SMItemBorrowedModel.class);
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

			Query<SMItemBorrowedModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemBorrowedModel> rows = (ArrayList<SMItemBorrowedModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemBorrowedModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  , row.getBorrowFromDate()==null?"":row.getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getBorrowToDate()  ==null?"":row.getBorrowToDate().toString());
				rObj.put("IssQty"       , row.getItemBorrowedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("IssueBy"      , row.getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                        + row.getFacultyCodeFK().getlName());
				rObj.put("iDNO", row.getiDNO());
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
	public static JsonArray getItemBorrowedList(SMItemBorrowedModel sMIBSModel) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedModel> creteriaQuery = builder.createQuery(SMItemBorrowedModel.class);
			Root<SMItemBorrowedModel> root = creteriaQuery.from(SMItemBorrowedModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), sMIBSModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), sMIBSModel.getAdmNo()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemBorrowedModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemBorrowedModel> rows = (ArrayList<SMItemBorrowedModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemBorrowedModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  , row.getBorrowFromDate()==null?"":row.getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getBorrowToDate()  ==null?"":row.getBorrowToDate().toString());
				rObj.put("IssQty"       , row.getItemBorrowedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("IssueBy"      , row.getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                        + row.getFacultyCodeFK().getlName());
				rObj.put("iDNO", row.getiDNO());
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
	public static JsonArray getItemsBorrowedList(String regNo, String sAdmNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedModel> creteriaQuery = builder.createQuery(SMItemBorrowedModel.class);
			Root<SMItemBorrowedModel> root = creteriaQuery.from(SMItemBorrowedModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), sAdmNo),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
//			creteriaQuery.orderBy(builder.desc(root.get(sMIBSModel.getUserRefInfo().getCreatedOn().toString())));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemBorrowedModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemBorrowedModel> rows = (ArrayList<SMItemBorrowedModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemBorrowedModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  , row.getBorrowFromDate()==null?"":row.getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getBorrowToDate()  ==null?"":row.getBorrowToDate().toString());
				rObj.put("IssQty"       , row.getItemBorrowedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("IssueBy"      , row.getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                        + row.getFacultyCodeFK().getlName());
				rObj.put("iDNO", row.getiDNO());
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

	public static int delItemBorrowedidno(SMItemBorrowedModel sMITBModel) {
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
    //Method to retrieve item borrowed information based on idno
	public static JsonArray getItemBorrowedIdnoinfo(SMItemBorrowedModel sMITBModel) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedModel> creteriaQuery = builder.createQuery(SMItemBorrowedModel.class);
			Root<SMItemBorrowedModel> root = creteriaQuery.from(SMItemBorrowedModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_IDNO), sMITBModel.getiDNO()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemBorrowedModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemBorrowedModel> rows = (ArrayList<SMItemBorrowedModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemBorrowedModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICode"        , row.getItemCode());
				rObj.put("IName"        , row.getItemCodeFK().getName());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  , row.getBorrowFromDate()==null?"":row.getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getBorrowToDate()  ==null?"":row.getBorrowToDate().toString());
				rObj.put("IssQty"       , row.getItemBorrowedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("IssueBy"      , row.getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                        + row.getFacultyCodeFK().getlName());
				rObj.put("iDNO", row.getiDNO());
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
	public static List getBorrowedIdnoinfo(int ItemBiDNO) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		JsonArray todayItemList = new JsonArray();
		List<SMItemBorrowedSubModel> rows = new ArrayList<>();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedSubModel> creteriaQuery = builder.createQuery(SMItemBorrowedSubModel.class);
			Root<SMItemBorrowedSubModel> root = creteriaQuery.from(SMItemBorrowedSubModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_IDNO), ItemBiDNO),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemBorrowedSubModel> query = sessionObj.createQuery(creteriaQuery);
			 rows = (ArrayList<SMItemBorrowedSubModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			for (SMItemBorrowedSubModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICode"        , row.getItemCode());
				rObj.put("DueDate"    , row.getBorrowToDate()  ==null?"":row.getBorrowToDate().toString());
				rObj.put("ItemBorrowediDNO", row.getiDNO());
				rObj.put("ItemCodeFK"      , row.getItemCodeFK());
				rObj.put("ItemBorrowediDNO", row.getiDNO());
				
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
		return rows;
	}

	public static JsonArray getItemsBorrowedPendingList(String regNo, String admNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		JsonArray todayItemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedModel> creteriaQuery = builder.createQuery(SMItemBorrowedModel.class);
			Root<SMItemBorrowedModel> root = creteriaQuery.from(SMItemBorrowedModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_ADIMISSIONNO), admNo),
					builder.isNull(root.get(SMFixedValue.MODEL_RETURN_DATE)),
					builder.notEqual(root.get(SMFixedValue.MODEL_BRStatus),SMFixedValue.LOST_STATUS),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemBorrowedModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<SMItemBorrowedModel> rows = (ArrayList<SMItemBorrowedModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (SMItemBorrowedModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO"          , Integer.toString(++sNO));
				rObj.put("RegNo"        , row.getRegNo());
				rObj.put("SAdmNo"       , row.getAdmNo());
				rObj.put("ICodeAndName" , row.getItemCode() + " " + row.getItemCodeFK().getName());
				rObj.put("IssFromDate"  , row.getBorrowFromDate()==null?"":row.getBorrowFromDate().toString());
				rObj.put("IssToDate"    , row.getBorrowToDate()  ==null?"":row.getBorrowToDate().toString());
				rObj.put("IssQty"       , row.getItemBorrowedQty());
				rObj.put("RetDate"       , row.getReturnDate()==null?"":row.getReturnDate().toString());
				rObj.put("IssueBy"      , row.getFacultyCode() + " " + row.getFacultyCodeFK().getName() + " "
                                        + row.getFacultyCodeFK().getlName());
				rObj.put("iDNO", row.getiDNO());
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

	public static List<SMItemBorrowedSubModel> getItemBorrowedIdnoinfo(int ItemBiDNO) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.ITEM + SMFixedValue.BORROWED + SMFixedValue.INFORMATION+ ":";
		List<SMItemBorrowedSubModel> rows = new ArrayList<>();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemBorrowedSubModel> creteriaQuery = builder.createQuery(SMItemBorrowedSubModel.class);
			Root<SMItemBorrowedSubModel> root = creteriaQuery.from(SMItemBorrowedSubModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_IDNO), ItemBiDNO),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<SMItemBorrowedSubModel> query = sessionObj.createQuery(creteriaQuery);
			 rows = (ArrayList<SMItemBorrowedSubModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			sessionObj.close();
			erMsg +=  SMFixedValue.OUTPUT + " Rows:(" + rows.size() + ")\n" + rows;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return rows;
	}
	
}
