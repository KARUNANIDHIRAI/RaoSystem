package com.sm.System.ItemMasterOPBal;

import java.util.ArrayList;
import java.util.List;

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
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.URBAccess.UserRolesModel;

public class HDAOSMItemMasterOPBal {
	private static int errStatus = 0;

	public static int postItemMasterOpenBalQty(SMItemMasterOPBalSubModel opBalSubModel, 
			SMItemMasterOPCLBalSubModel oPClBalModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.USER + SMFixedValue.ROLE + SMFixedValue.INFORMATION;
		Transaction transaction = null;
		int exeStatus = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			transaction = sessionObj.beginTransaction();
			int recFound = verifyOpeningBalQTY(opBalSubModel);
			int dupOpBal = verifyOpeningClosingBalQTY(opBalSubModel);
			if (errStatus == 1) {return 3;} // return if error in verifyUserRoleExist(userRolesModel)
			if (recFound==0 && dupOpBal==0) { // No data in OPCLBal Table
				sessionObj.save(opBalSubModel);
				sessionObj.save(oPClBalModel);
				exeStatus = 1;
			} else if (recFound==0 && dupOpBal>0) { // Insert data into opening bal table and update into opCLBal Table
				sessionObj.save(opBalSubModel);
				// todo 
				
				
				erMsg += SMFixedValue.EXEC_DUPLICATE_MSG + SMFixedValue.EXEC_NODATAINSERT_MSG;
				exeStatus = 2;
			}
			sessionObj.save(opBalSubModel);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_CREATE_MSG;
		} catch (Exception e) {
			exeStatus = 2;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			System.out.println(erMsg);
		}
		return exeStatus;
	}


	private static int verifyOpeningClosingBalQTY(SMItemMasterOPBalSubModel opBalSubModel) {
		String erMsg = SMFixedValue.VERIFY + SMFixedValue.OPENBAL + ": ";
		int IDNOFK = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();

			CriteriaQuery<SMItemMasterOPCLBalModel> creteriaQuery = builder.createQuery(SMItemMasterOPCLBalModel.class);
			Root<SMItemMasterOPCLBalModel> root = creteriaQuery.from(SMItemMasterOPCLBalModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), opBalSubModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_iTEMCODE), opBalSubModel.getItemCode()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG + " ;";
			Query<SMItemMasterOPCLBalModel> query = sessionObj.createQuery(creteriaQuery);
			List<SMItemMasterOPCLBalModel> rows = (ArrayList<SMItemMasterOPCLBalModel>) query.getResultList();
			IDNOFK = rows.size();
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			erMsg += SMFixedValue.OUTPUT + rows.size() + SMFixedValue.USER + SMFixedValue.ROLE + " IDNO :" + IDNOFK;
		} catch (Exception e) {
			errStatus = 1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return IDNOFK;
	}
	private static int verifyOpeningBalQTY(SMItemMasterOPBalSubModel opBalSubModel) {
		String erMsg = SMFixedValue.VERIFY + SMFixedValue.OPENBAL + ": ";
		int recFound = 0;
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
			CriteriaQuery<SMItemMasterOPBalModel> creteriaQuery = builder.createQuery(SMItemMasterOPBalModel.class);
			Root<SMItemMasterOPBalModel> root = creteriaQuery.from(SMItemMasterOPBalModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), opBalSubModel.getRegNo()),
					builder.equal(root.get(SMFixedValue.MODEL_ITEMCODE), opBalSubModel.getItemCode()),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG + " ;";
			Query<SMItemMasterOPBalModel> query = sessionObj.createQuery(creteriaQuery);
			List<SMItemMasterOPBalModel> rows = (ArrayList<SMItemMasterOPBalModel>) query.getResultList();
			recFound = 	rows.size();
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			erMsg += SMFixedValue.OUTPUT + rows.size() + SMFixedValue.USER + SMFixedValue.ROLE + " IDNO :" + recFound;
		} catch (Exception e) {
			errStatus = 1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return recFound;
	}


	public static JsonArray getItemMasterOPCLBalList(String regNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.OPENBAL + SMFixedValue.ACTION_LIST+ ": ";
		JsonArray itemOpBalList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();

			CriteriaQuery<SMItemMasterOPCLBalModel> creteriaQuery = builder.createQuery(SMItemMasterOPCLBalModel.class);
			Root<SMItemMasterOPCLBalModel> root = creteriaQuery.from(SMItemMasterOPCLBalModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG + " ;";
			Query<SMItemMasterOPCLBalModel> query = sessionObj.createQuery(creteriaQuery);
			List<SMItemMasterOPCLBalModel> rows = (ArrayList<SMItemMasterOPCLBalModel>) query.getResultList();
	        int sNO =0;
	       for(SMItemMasterOPCLBalModel row: rows) {
	    	  JsonObject rObj = new JsonObject();
	    	  rObj.put("SNO"     , Integer.toString(++ sNO)) ;
		      rObj.put("RegNo"   , row.getRegNo())           ;
		      rObj.put("Code"    , row.getItemCode())        ;
		      rObj.put("ItemName", row.getItemMasterModelFK().getName()) ;
		      rObj.put("OpBal"   , row.getOpBalQty())        ;
		      rObj.put("CLBal"   , row.getClBalQty())        ;
		      rObj.put("iDNO"    , row.getIDNO())            ;
		      itemOpBalList.add(rObj);	
	      
		   }
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			erMsg += SMFixedValue.OUTPUT + rows.size() +  SMFixedValue.OPENBAL + SMFixedValue.ACTION_LIST+ ": "+ itemOpBalList;
		} catch (Exception e) {
			errStatus = 1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return itemOpBalList;
	}

	public static JsonArray getItemsOPBalList(String regNo) {
		String erMsg = SMFixedValue.GENERATING + SMFixedValue.OPENBAL + SMFixedValue.ACTION_LIST+ ": ";
		JsonArray itemOpBalList = new JsonArray();
		try (Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			CriteriaBuilder builder = sessionObj.getCriteriaBuilder();

			CriteriaQuery<SMItemMasterOPBalModel> creteriaQuery = builder.createQuery(SMItemMasterOPBalModel.class);
			Root<SMItemMasterOPBalModel> root = creteriaQuery.from(SMItemMasterOPBalModel.class);

			creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));
			erMsg += SMFixedValue.PARM_SET_MSG + " ;";
			Query<SMItemMasterOPBalModel> query = sessionObj.createQuery(creteriaQuery);
			List<SMItemMasterOPBalModel> rows = (ArrayList<SMItemMasterOPBalModel>) query.getResultList();
	        int sNO =0;
	       for(SMItemMasterOPBalModel row: rows) {
	    	  JsonObject rObj = new JsonObject();
	    	  rObj.put("SNO"        , Integer.toString(++ sNO)) ;
		      rObj.put("RegNo"      , row.getRegNo())           ;
		      rObj.put("Category"    , row.getItemCategory())   ;
		      rObj.put("CodeAndName", row.getItemCode()  + " " + row.getItemMasterModelFK().getName())    ;
		      rObj.put("Name"       , row.getItemMasterModelFK().getName()) ;
		      rObj.put("OpBal"      , row.getOpBalQty())        ;
		      rObj.put("MfgYear"   , row.getManufYear())       ;
		      rObj.put("Make"       , row.getMake())            ;
		      rObj.put("ExpDate"   , row.getExpirydate().toString())      ;
		      rObj.put("Price"      , row.getPrice())           ;
		      rObj.put("Unit"       , row.getUnit())            ;
		      rObj.put("iDNO"       , row.getOPBQIDNO() + "/" + row.getItemCode());
		      itemOpBalList.add(rObj);	
		   }
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_QUERY_MSG;
			erMsg += SMFixedValue.OUTPUT + rows.size() +  SMFixedValue.OPENBAL + SMFixedValue.ACTION_LIST+ ": "+ itemOpBalList;
		} catch (Exception e) {
			errStatus = 1;
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n" + e;
		} finally {
			System.out.println("\n" + erMsg);
		}
		return itemOpBalList;
	}

	@SuppressWarnings("unchecked")
	public static int delItemOpeningBalQty(String regNo, long opBalIdNo, String itcode) {
		String erMsg = SMFixedValue.ACTION_REMOVING  + SMFixedValue.ITEM + SMFixedValue.OPENBAL + ":";
	    int execUpdate = 1;
		Transaction transaction = null;
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			transaction = sessionObj.beginTransaction();
/*
	    	SMItemMasterOPCLBalSubModel oPclSubModel = new SMItemMasterOPCLBalSubModel();
			CriteriaBuilder cb = sessionObj.getCriteriaBuilder();
			CriteriaUpdate<SMItemMasterOPCLBalSubModel> updateOPCLBal = 
					cb.createCriteriaUpdate(SMItemMasterOPCLBalSubModel.class);
			Root root = updateOPCLBal.from(SMItemMasterOPCLBalSubModel.class); 
			updateOPCLBal.set(SMFixedValue.MODEL_OPBALQTY, 0);
			updateOPCLBal.set(SMFixedValue.MODEL_CLBALQTY,
					cb.<Integer>diff(root.<Integer>get(SMFixedValue.MODEL_CLBALQTY), root.<Integer>get(SMFixedValue.MODEL_OPBALQTY )));
	
			updateOPCLBal.where(cb.equal(root.get(SMFixedValue.MODEL_REGNO), regNo),
					cb.equal(root.get(SMFixedValue.MODEL_iTEMCODE), itcode),
					cb.lessThanOrEqualTo(root.get(SMFixedValue.MODEL_OPBALQTY ), root.get(SMFixedValue.MODEL_CLBALQTY ) ),
					cb.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.STATUS));

			erMsg += SMFixedValue.PARM_SET_MSG + " ;";
			 execUpdate = sessionObj.createQuery(updateOPCLBal).executeUpdate();
*/

	        Query opclBalQuery = sessionObj.createQuery(SMFixedValue.REM_ITEM_OPCLBAL);
	        opclBalQuery.setParameter(SMFixedValue.PARM_CODE, itcode);
	        opclBalQuery.setParameter(SMFixedValue.PARM_REGNO, regNo);
	        opclBalQuery.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);

	        Query opBalQuery = sessionObj.createQuery(SMFixedValue.REM_ITEM_OPBAL);
	        opBalQuery.setParameter(SMFixedValue.PARM_IDNO, opBalIdNo);
	        opBalQuery.setParameter(SMFixedValue.PARM_REGNO, regNo);
	        opBalQuery.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        opBalQuery.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);
	        erMsg += SMFixedValue.PARM_SET_MSG;
	        if(opBalQuery.executeUpdate()>0 && opclBalQuery.executeUpdate()==0) {
		        	transaction.rollback();
		        	execUpdate=0;	
	        }
	        sessionObj.close();
	        erMsg += Integer.toString(execUpdate) + SMFixedValue.REMOVED + SMFixedValue.EXEC_REMOVE_MSG ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return execUpdate;		
	}
}
