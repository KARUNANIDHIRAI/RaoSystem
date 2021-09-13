package com.sm.System.Transport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;
import com.sm.System.SMUtility.SMUtilities;

public class HDAOTransport {
	public static int routePickupDropNew(RouteModel routeModel , HttpSession session) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ROUTE + SMFixedValue.PICKUP_DROP_POINT+ ":";
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			int iDNOFK= VerifyPickupDropDataDuplicate(routeModel.getRegNo(), routeModel.getRouteName()) ;
			transaction = sessionObj.beginTransaction();
			if(iDNOFK == 0) {
				sessionObj.save(routeModel); // Insert data first time in Parent And Child Table
			}else { // Insert into child table only 
				RoutePickUpDropSubModel rPDSubModel = new RoutePickUpDropSubModel();
				List<RoutePickUpDropModel> rPDModel = new ArrayList<RoutePickUpDropModel>();
				rPDModel =  routeModel.getRoutePickUpDropModel();
		        for(RoutePickUpDropModel row:rPDModel) {
		        	rPDSubModel.setRegNo(row.getRegNo())                        ;
		        	rPDSubModel.setPickDropSNo(row.getPickDropSNo())            ;
		        	rPDSubModel.setPickupDropPoint(row.getPickupDropPoint())    ;
		        	rPDSubModel.setPickupDropTime(row.getPickupDropTime())      ;
		        	rPDSubModel.setPickupDropType(row.getPickupDropType())      ;
		        	rPDSubModel.setStatus(row.getStatus())                      ;
		        	rPDSubModel.setUserRefInfo(SMUtilities.getUserInfo(session));
		        	rPDSubModel.setiDNOFK(iDNOFK)                               ;
		        }
				sessionObj.save(rPDSubModel);
			}
			sessionObj.getTransaction().commit();
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_CREATE_MSG;
			exeStatus = 1;
	   }catch (Exception e) {
			erMsg += "\n"+SMFixedValue.EXEC_CATCH_MSG + e;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}

	private static int VerifyPickupDropDataDuplicate(String RegNo, String RouteName) {
	        String erMsg = SMFixedValue.ACTION_GENERATE +SMFixedValue.ROUTE  + SMFixedValue.ID +": " ;
	        int tempiDNO = 0;
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
				Criteria criteria=  sessionObj.createCriteria(RouteModel.class);
				criteria.add(Restrictions.eq(SMFixedValue.MODEL_REGNO, RegNo));
				criteria.add(Restrictions.eq(SMFixedValue.MODEL_ROUTE_NAME,RouteName));
				criteria.add(Restrictions.eq(SMFixedValue.MODEL_STATUS,SMFixedValue.STATUS));
				List<RouteModel> results =(ArrayList<RouteModel>) criteria.list();			
				for (RouteModel row:results) {
					tempiDNO=row.getiDNO();
					break;
				}
		       sessionObj.close();
		       erMsg += SMFixedValue.OUTPUT + SMFixedValue.ID+":" +Integer.toString(tempiDNO);
			}catch(Exception e) {
				erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return tempiDNO;
		}

	public static int getRouteNew(RouteSubModel routeModel) {
		String erMsg = SMFixedValue.ACTION_CREATING + SMFixedValue.ROUTE + SMFixedValue.PICKUP_DROP_POINT+ ":";
		Transaction transaction = null;
		int exeStatus=0;
		try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			int iDNOFK= VerifyPickupDropDataDuplicate(routeModel.getRegNo(), routeModel.getRouteName()) ;
			transaction = sessionObj.beginTransaction();
			if(iDNOFK == 0) {
				sessionObj.save(routeModel); // Insert data first time in Parent And Child Table
				sessionObj.getTransaction().commit();
			}
			sessionObj.close();
			erMsg += SMFixedValue.EXEC_CREATE_MSG;
			exeStatus = 1;
	   }catch (Exception e) {
			erMsg += "\n"+SMFixedValue.EXEC_CATCH_MSG + e;
 	   }finally {
 		   System.out.println(erMsg);
 	   }
		return exeStatus;
	}

	public static JsonArray getRouteList(String RegNo) {
		String erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ROUTE + SMFixedValue.INFORMATION ;
        int tempiDNO = 0;
        JsonArray routList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Criteria criteria=  sessionObj.createCriteria(RouteSubModel.class);
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_REGNO, RegNo));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_STATUS,SMFixedValue.STATUS));
			List<RouteSubModel> results =(ArrayList<RouteSubModel>) criteria.list();			
			int sNo=0;
			for (RouteSubModel row:results) {
				JsonObject rObj = new JsonObject()                ;
				rObj.put("RegNo"      , row.getRegNo())           ;
				rObj.put("SNO"        , Integer.toString(++sNo))  ;
				rObj.put("RegNo"      , row.getRegNo().toString());
				rObj.put("Code"       , row.getRouteName())       ;
				rObj.put("Name"       , row.getRouteDescription());
				rObj.put("CodeAndName", row.getRouteName() + "/ "+row.getRouteDescription());
				rObj.put("RTD", row.getiDNO())                   ;
				routList.add(rObj)                                ;
			}
	       sessionObj.close();
	       erMsg += SMFixedValue.OUTPUT + SMFixedValue.ID+":" +Integer.toString(tempiDNO);
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return routList;
	}
	public static JsonArray delRouteiDNO(String RegNo, int RrouteIdNo) {
		String erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ROUTE + SMFixedValue.INFORMATION ;
        int tempiDNO = 0;
        JsonArray routList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Criteria criteria=  sessionObj.createCriteria(RouteSubModel.class);
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_REGNO, RegNo));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_IDNO, RrouteIdNo));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_STATUS,SMFixedValue.STATUS));
			List<RouteSubModel> results =(ArrayList<RouteSubModel>) criteria.list();			
			int sNo=0;
			for (RouteSubModel row:results) {
				JsonObject rObj = new JsonObject()           ;
				rObj.put("RegNo" , row.getRegNo())           ;
				rObj.put("SNO"   , Integer.toString(++sNo))  ;
				rObj.put("RegNo" , row.getRegNo().toString());
				rObj.put("Code"  , row.getRouteName())       ;
				rObj.put("Name"  , row.getRouteDescription());
				rObj.put("iDNO"  , row.getiDNO())            ;
				routList.add(rObj)                           ;
			}
	       sessionObj.close();
	       erMsg += SMFixedValue.OUTPUT + SMFixedValue.ID+":" +Integer.toString(tempiDNO);
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return routList;
	}

	public static boolean delPhyRouteByiDNO(int id) { // delete data permanentaly from both tabel.
		String erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ROUTE + SMFixedValue.INFORMATION ;
		boolean result  = false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			 Object persistentInstance = sessionObj.load(RouteModel.class, id);
			 if (persistentInstance != null) {
			   	sessionObj.delete(persistentInstance);
			   	sessionObj.beginTransaction().commit();
			    result= true;
			    erMsg+= SMFixedValue.EXEC_REMOVE_MSG;
			 }
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return result;

	}	
	public static boolean delRouteByiDNO(int id) { // update status of deleted record
		String erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.ROUTE + SMFixedValue.INFORMATION ;
		Transaction tx=null;
		boolean result  = false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			 tx = sessionObj.beginTransaction();
			 RouteModel routeMode = sessionObj.load(RouteModel.class, id);
			 routeMode.setStatus(SMFixedValue.DELETE_STATUS);
			 sessionObj.update(routeMode);
			 tx.commit();
		     sessionObj.close();			 
     		 erMsg+= SMFixedValue.EXEC_REMOVE_MSG;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return result;

	}

	public static JsonArray getRoutePickUPDropList(String regNo, String routeName) {
		String erMsg= SMFixedValue.ACTION_GENERATE + SMFixedValue.ROUTE + SMFixedValue.PICKUP_DROP_POINT ;
        JsonArray routList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Criteria criteria=  sessionObj.createCriteria(RouteModel.class);
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_REGNO, regNo));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_ROUTE_NAME, routeName));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_STATUS,SMFixedValue.STATUS));
			List<RouteModel> results =(ArrayList<RouteModel>) criteria.list();			
			int sNo=0;
			for (RouteModel row:results) {
				List<RoutePickUpDropModel> routePDPModel = row.getRoutePickUpDropModel();				
				for(RoutePickUpDropModel pDProw:routePDPModel) {
					if(pDProw.getStatus().equals("D")) {continue;}
					JsonObject rObj = new JsonObject()                          ;
					rObj.put("SNO"      , Integer.toString(++sNo))              ;
					rObj.put("RegNo"    , row.getRegNo())                       ;
					rObj.put("Route"    , row.getRouteName())                   ;
					rObj.put("RouteDesc", row.getRouteDescription())            ;
					rObj.put("PDPSNO"   , pDProw.getPickDropSNo())              ;
					rObj.put("PDPoint"  , pDProw.getPickupDropPoint())          ;
					rObj.put("PDType"   , pDProw.getPickupDropType())           ;
					rObj.put("PDTime"   , pDProw.getPickupDropTime().toString());
					rObj.put("RTPD"     , Integer.toString(pDProw.getiDNO()) + "/" + Integer.toString(row.getiDNO()))      ;
					routList.add(rObj);
				}
			}
	       sessionObj.close();
	       erMsg += SMFixedValue.OUTPUT + ":(" +Integer.toString(results.size()) + ") " + routList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return routList;
	}
	public static JsonArray getRoutePickUPDropList(int routid) {
		String erMsg= SMFixedValue.ACTION_GENERATE + SMFixedValue.ROUTE + SMFixedValue.PICKUP_DROP_POINT ;
        JsonArray routList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Criteria criteria=  sessionObj.createCriteria(RouteModel.class);
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_IDNO, routid));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_STATUS,SMFixedValue.STATUS));
			List<RouteModel> results =(ArrayList<RouteModel>) criteria.list();			
			for (RouteModel row:results) {
				List<RoutePickUpDropModel> routePDPModel = row.getRoutePickUpDropModel();				
				for(RoutePickUpDropModel pDProw:routePDPModel) {
					if(pDProw.getStatus().equals("D")) {continue;}
					JsonObject rObj = new JsonObject()                          ;
					rObj.put("PDPSNO"   , pDProw.getPickDropSNo())              ;
					rObj.put("PDPoint"  , pDProw.getPickupDropPoint())          ;
					rObj.put("PDType"   , pDProw.getPickupDropType())           ;
					rObj.put("PDTime"   , pDProw.getPickupDropTime().toString());
					rObj.put("RTPD"     , Integer.toString(pDProw.getiDNO()) + "/" + Integer.toString(row.getiDNO()))      ;
					routList.add(rObj);
				}
			}
	       sessionObj.close();
	       erMsg += SMFixedValue.OUTPUT + ":(" +Integer.toString(results.size()) + ") " + routList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return routList;
	}
	public static JsonArray getRoutePickUPDropList(String RegNo, String rName, String pDPType) {
		String erMsg= SMFixedValue.ACTION_GENERATE + SMFixedValue.ROUTE + SMFixedValue.PICKUP_DROP_POINT ;
        JsonArray routList = new JsonArray();
		String pdType = "";
		String status ="";
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			Criteria criteria=  sessionObj.createCriteria(RouteModel.class);
			
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_REGNO, RegNo));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_ROUTE_NAME, rName));
			criteria.add(Restrictions.eq(SMFixedValue.MODEL_STATUS,SMFixedValue.STATUS));
			List<RouteModel> results =(ArrayList<RouteModel>) criteria.list();			
			for (RouteModel row:results) {
				List<RoutePickUpDropModel> routePDPModel = row.getRoutePickUpDropModel();				
				for(RoutePickUpDropModel pDProw:routePDPModel) {
					pdType = pDProw.getPickupDropType();
					status =pDProw.getStatus();
					if (status.equals(SMFixedValue.DELETE_STATUS) || (!pdType.equals(pDPType) ) /* || pDProw.getStatus().equals("D") */ ) {continue;}
					JsonObject rObj = new JsonObject()                          ;
					rObj.put("PDPoint"  , pDProw.getPickupDropPoint())          ;
					rObj.put("PDTime"   , pDProw.getPickupDropTime().toString());
					rObj.put("PDPT"     , pDProw.getPickupDropPoint() + "---->   " + pDProw.getPickupDropTime().toString());
					rObj.put("RTPD"     , Integer.toString(pDProw.getiDNO()) + "/" + Integer.toString(row.getiDNO()))      ;
					routList.add(rObj);
				}
			}
	       sessionObj.close();
	       erMsg += SMFixedValue.OUTPUT + ":(" +Integer.toString(results.size()) + ") " + routList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return routList;
	}
	public static Boolean delPDPByiDNO(int pDPiDNO) {
		String erMsg= SMFixedValue.ACTION_REMOVING + SMFixedValue.PICKUP_DROP_POINT + SMFixedValue.INFORMATION ;
		Transaction tx=null;
		boolean result  = false;
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
			 tx = sessionObj.beginTransaction();
			 RoutePickUpDropModel routePDPMode = sessionObj.load(RoutePickUpDropModel.class, pDPiDNO);
			 routePDPMode.setStatus(SMFixedValue.DELETE_STATUS);
			 sessionObj.update(routePDPMode);
			 tx.commit();
		     sessionObj.close();			 
			 result  = true;
     		 erMsg+= SMFixedValue.EXEC_REMOVE_MSG;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return result;
	}
}
