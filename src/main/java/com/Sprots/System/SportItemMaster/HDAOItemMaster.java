package com.Sprots.System.SportItemMaster;

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

import com.Sprots.System.SportItemsPurchase.SportItemPurchaseModel;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.ItemMasterOPBal.SMItemMasterOPBalSubModel;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOItemMaster {
	public static int ItemMasterNew(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_CREATING;
		Transaction transaction = null;
		int exeStatus = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			transaction = sessionObj.beginTransaction();
			String itemName = verifyDuplicateItemCode(itemMasterModel);
			if (itemName == "" || itemName == null) {
				sessionObj.save(itemMasterModel);
				sessionObj.getTransaction().commit();
				exeStatus = 1;
			}
			sessionObj.close();
			erMsg += "(" + Integer.toString(exeStatus) + ") " + SMFixedValue.EXEC_CREATE_MSG;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			System.out.println(erMsg);
		}
		return exeStatus;
	}

	public static String verifyDuplicateItemCode(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_VERIFY_ITEMCODE;
		String ItemName = null;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<ItemMasterModel> creteriaQuery = builder.createQuery(ItemMasterModel.class);
			Root<ItemMasterModel> root = creteriaQuery.from(ItemMasterModel.class);
//	        root.fetch(SMFixedValue.MODEL_ITEMMASTER);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), itemMasterModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_CODE), itemMasterModel.getCode()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;
			Query<ItemMasterModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<ItemMasterModel> rows = (ArrayList<ItemMasterModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			ItemName = rows.size() > 0 ? "Code Already Exist" : ItemName;
			sessionObj.close();
			erMsg += "\n" + SMFixedValue.ITEM + SMFixedValue.Name + " :" + ItemName;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return ItemName;
	}

	public static int ItemMasterRemove(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING + SMFixedValue.ITEM
				+ SMFixedValue.information;
		int executeUpdate = 0;
		Transaction transaction = null;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Query query = sessionObj.createQuery(SMFixedValue.HQL_REM_ITEM_INFO);
			query.setParameter(SMFixedValue.PARM_IDNO, itemMasterModel.getiDNO());
			query.setParameter(SMFixedValue.PARM_REGNO, itemMasterModel.getRegNo());
			query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
			query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);
			erMsg += SMFixedValue.PARM_SET_MSG;
			sessionObj.beginTransaction();
			executeUpdate = query.executeUpdate();
			sessionObj.close();
			erMsg += Integer.toString(executeUpdate) + " " + SMFixedValue.EXEC_REMOVE_MSG;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return executeUpdate;
	}

	public static JsonArray getItemMasterList(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_GENERATE + SMFixedValue.ITEM + SMFixedValue.ACTION_LIST;
		JsonArray itemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<ItemMasterModel> creteriaQuery = builder.createQuery(ItemMasterModel.class);
			Root<ItemMasterModel> root = creteriaQuery.from(ItemMasterModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), itemMasterModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<ItemMasterModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<ItemMasterModel> rows = (ArrayList<ItemMasterModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (ItemMasterModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO", Integer.toString(++sNO));
				rObj.put("sCode", row.getRegNo());
				rObj.put("itemCode", row.getCode());
				rObj.put("itemName", row.getName());
				rObj.put("Category", row.getItemCategory());
				rObj.put("Id", row.getiDNO());
				itemList.add(rObj);
			}
			sessionObj.close();
			erMsg += "\n" + SMFixedValue.OUTPUT + " Rows:(" + rows.size() + ")" + itemList;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return itemList;
	}

	public static JsonArray getTodayItemList(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_GENERATE + SMFixedValue.ITEM + SMFixedValue.ACTION_LIST;
		JsonArray itemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<ItemMasterModel> creteriaQuery = builder.createQuery(ItemMasterModel.class);
			Root<ItemMasterModel> root = creteriaQuery.from(ItemMasterModel.class);
			root.fetch(SMFixedValue.MODEL_ITEMMASTER);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), itemMasterModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_CREATEDON), itemMasterModel.getCreatedOn()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<ItemMasterModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<ItemMasterModel> rows = (ArrayList<ItemMasterModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			int sNO = 0;
			for (ItemMasterModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("SNO", Integer.toString(++sNO));
				rObj.put("sCode", row.getRegNo());
				rObj.put("itemCode", row.getCode());
				rObj.put("itemName", row.getName());
				rObj.put("Category", row.getItemCategory());
				rObj.put("Id", row.getiDNO());
				itemList.add(rObj);
			}
			sessionObj.close();
			erMsg += "\n" + SMFixedValue.OUTPUT + " Rows:(" + rows.size() + ")" + itemList;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return itemList;
	}

	public static int sportItemsPurchaseNew(SportItemPurchaseModel spItemPurModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int sprotItemMasterRemove(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_START + SMFixedValue.ACTION_REMOVING + SMFixedValue.SPORTS
				+ SMFixedValue.ITEM + SMFixedValue.information;
		int executeUpdate = 0;
		Transaction transaction = null;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Query query = sessionObj.createQuery(SMFixedValue.REM_SPORTITEM_INFO);
			query.setParameter(SMFixedValue.PARM_IDNO, itemMasterModel.getiDNO());
			query.setParameter(SMFixedValue.PARM_REGNO, itemMasterModel.getRegNo());
			query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
			query.setParameter(SMFixedValue.PARM_OSTATUS, "A");
			erMsg += SMFixedValue.PARM_SET_MSG;
			sessionObj.beginTransaction();
			executeUpdate = query.executeUpdate();
			sessionObj.close();
			erMsg += Integer.toString(executeUpdate) + " " + SMFixedValue.EXEC_REMOVE_MSG;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return executeUpdate;
	}

	public static JsonArray getItemMasterCategoryList(ItemMasterModel itemMasterModel) {
		String erMsg = SMFixedValue.ACTION_GENERATE + SMFixedValue.ITEM + SMFixedValue.ACTION_LIST;
		JsonArray itemList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {

			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<ItemMasterModel> creteriaQuery = builder.createQuery(ItemMasterModel.class);
			Root<ItemMasterModel> root = creteriaQuery.from(ItemMasterModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), itemMasterModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.SPORT_ITEMCATEGORY), itemMasterModel.getItemCategory()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;

			Query<ItemMasterModel> query = sessionObj.createQuery(creteriaQuery);
			List<ItemMasterModel> rows = (ArrayList<ItemMasterModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			for (ItemMasterModel row : rows) {
				JsonObject rObj = new JsonObject();
				rObj.put("itemCode", row.getCode() );
				rObj.put("itemCode1", row.getCode() + "/" + row.getiDNO().toString());
				rObj.put("itemName", row.getName());
				rObj.put("Id", row.getiDNO());
				itemList.add(rObj);
			}
			sessionObj.close();
			erMsg += "\n" + SMFixedValue.ITEM + SMFixedValue.ACTION_LIST + " Rows:(" + rows.size() + ")" + itemList;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return itemList;
	}

	public static int getItemCodePK(SMItemMasterOPBalSubModel ITMOpenBalModel) {
		String erMsg = SMFixedValue.ACTION_ITEMCODE_PK;
		int itemCodePK = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<ItemMasterModel> creteriaQuery = builder.createQuery(ItemMasterModel.class);
			Root<ItemMasterModel> root = creteriaQuery.from(ItemMasterModel.class);
			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), ITMOpenBalModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_CODE), ITMOpenBalModel.getItemCode()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG;
			Query<ItemMasterModel> query = sessionObj.createQuery(creteriaQuery);
			ArrayList<ItemMasterModel> rows = (ArrayList<ItemMasterModel>) query.getResultList();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			for (ItemMasterModel row : rows) {
				itemCodePK= row.getiDNO();
			}
			sessionObj.close();
			erMsg += "\n" + SMFixedValue.ITEM + SMFixedValue.Code + " PK:" + itemCodePK;
		} catch (Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return itemCodePK;
	}

}
