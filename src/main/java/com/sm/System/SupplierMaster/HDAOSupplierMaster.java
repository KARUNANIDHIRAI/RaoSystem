package com.sm.System.SupplierMaster;

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

import com.SLIBM.System.BooksMaster.BooksMasterInfoModel;
import com.raoSystem.daoConnection.HibernateDAO;
import com.sm.System.SMInformation.SMFixedValue;

public class HDAOSupplierMaster {
	
	public static int SupplierMasterNew(SupplierMasterModel supplierMasterModel) {
		  String erMsg =SMFixedValue.ACTION_START +
		  SMFixedValue.CREATING_INFO_INTOTABLE + SMFixedValue.SUPPLIER_MASTER ;
		  Transaction transaction = null;
		  int exeStatus=0;
		  try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
			  transaction =	  sessionObj.beginTransaction(); 
			  sessionObj.save(supplierMasterModel);
			  sessionObj.getTransaction().commit();
			  sessionObj.close();
		  erMsg += "\n" +SMFixedValue.SUPPLIER_MASTER  + SMFixedValue.EXEC_CREATE_MSG ;
		  exeStatus=1;
		  }catch (Exception e) {
			   if(transaction!=null ) {
				   transaction.rollback(); 
				  erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
  		   }
		  }finally {
			  System.out.println("\n"+erMsg);
		  }
		  return exeStatus;
	}

	public static JsonArray getSupplierMasterList(SupplierMasterModel supplierMasterModel) {
       String erMsg = SMFixedValue.SUPPLIER_MASTER + SMFixedValue.LIST_GENERATING;
		JsonArray supplierList = new JsonArray();
		try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
	        CriteriaQuery<SupplierMasterModel> creteriaQuery = builder.createQuery(SupplierMasterModel.class);
	        Root<SupplierMasterModel> root = creteriaQuery.from(SupplierMasterModel.class);
	        
	        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), supplierMasterModel.getRegNo()),
	        	builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
	        erMsg += SMFixedValue.PARM_SET_MSG;

	        Query<SupplierMasterModel> query = sessionObj.createQuery(creteriaQuery);
	        ArrayList <SupplierMasterModel> rows=(ArrayList<SupplierMasterModel>) query.getResultList();
	    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
	        int sNO =0;
	        for(SupplierMasterModel row: rows) {
		    	  JsonObject rObj = new JsonObject();
	              rObj.put("SNO"          , Integer.toString(++ sNO)) ;
		    	  rObj.put("RegNo"        , row.getRegNo());
		    	  rObj.put("Code"         , row.getSupCode());
		    	  rObj.put("Name"         , row.getSupName());
		    	  rObj.put("Category"     , row.getSupCategory());
		    	  rObj.put("iDNO"         , row.getiDNO());
		    	  List<SupplierMasterAddressModel> SupMasterAddress = row.getSupMAddress();
		    	 for( SupplierMasterAddressModel supAddress: SupMasterAddress) {
		    		 if(!supAddress.getStatus().equals("A")) {
		    			 continue;
		    		 }
		    		 if(supAddress.getCategory().equals(SMFixedValue.ADDRESS_CATEGORY_HO)) {
			              rObj.put("HOAddress"          ,supAddress.getAddress()) ;
				    	  rObj.put("HOSector"        , supAddress.getSector());
				    	  rObj.put("HOCity"         , supAddress.getCity());
				    	  rObj.put("HOState"         , supAddress.getState());
				    	  rObj.put("HOCountry"     , supAddress.getCountry());
				    	  rObj.put("HOPincode"         , supAddress.getPincode());
		    		 }else {
			              rObj.put("Address"          ,supAddress.getAddress()) ;
				    	  rObj.put("Sector"        , supAddress.getSector());
				    	  rObj.put("City"         , supAddress.getCity());
				    	  rObj.put("State"         , supAddress.getState());
				    	  rObj.put("Country"     , supAddress.getCountry());
				    	  rObj.put("Pincode"         , supAddress.getPincode());
		    		 }
		    	 }
		    	  List<SupplierMasterContact> supContact = row.getSupMasterContact();
		    	 for( SupplierMasterContact spContact: supContact) {
		    		 if(!spContact.getStatus().equals("A")) {
		    			 continue;
		    		 }
		    		 if(spContact.getContactRef().equals(SMFixedValue.CONTACT_REF_HO)) {
			              rObj.put("HOEmail"          ,spContact.getEmailID()) ;
				    	  rObj.put("HOMobile"        , spContact.getMobileNo());
				    	  rObj.put("HOPhone"         , spContact.getPhoneNo());
		    		 }else {
			              rObj.put("Email"          ,spContact.getEmailID()) ;
				    	  rObj.put("Mobile"        , spContact.getMobileNo());
				    	  rObj.put("Phone"         , spContact.getPhoneNo());
		    		 }
		    	 }
		    	  supplierList.add(rObj);	
		    }// EOF outer for loop
	       sessionObj.close();
	    	erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
	    	       + SMFixedValue.SUPPLIER_MASTER + SMFixedValue.ACTION_LIST + SMFixedValue.ACTION_GENERATE 
	    	       +"\n" +supplierList;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return supplierList;
	}
	
	public static JsonArray updSupplierMasterInfo(SupplierMasterModel supplierMasterModel) {
	       String erMsg = SMFixedValue.SUPPLIER_MASTER + SMFixedValue.LIST_GENERATING;
			JsonArray supplierList = new JsonArray();
			try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
		        CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		        CriteriaQuery<SupplierMasterModel> creteriaQuery = builder.createQuery(SupplierMasterModel.class);
		        Root<SupplierMasterModel> root = creteriaQuery.from(SupplierMasterModel.class);
		        
		        creteriaQuery.where(builder.equal(root.get(SMFixedValue.MODEL_REGNO), supplierMasterModel.getRegNo()),
		        		builder.equal(root.get(SMFixedValue.MODEL_IDNO), supplierMasterModel.getiDNO()),
		        	builder.equal(root.get(SMFixedValue.MODEL_STATUS), SMFixedValue.LIST_STATUS));
		        erMsg += SMFixedValue.PARM_SET_MSG;

		        Query<SupplierMasterModel> query = sessionObj.createQuery(creteriaQuery);
		        ArrayList <SupplierMasterModel> rows=(ArrayList<SupplierMasterModel>) query.getResultList();
		    	erMsg += SMFixedValue.EXEC_QUERY_MSG; 
		        int sNO =0;
		        for(SupplierMasterModel row: rows) {
			    	  JsonObject rObj = new JsonObject();
		              rObj.put("SNO"          , Integer.toString(++ sNO)) ;
			    	  rObj.put("RegNo"        , row.getRegNo());
			    	  rObj.put("Code"         , row.getSupCode());
			    	  rObj.put("Name"         , row.getSupName());
			    	  rObj.put("Category"     , row.getSupCategory());
			    	  rObj.put("Facebook"         , row.getFacebook());
			    	  rObj.put("Linkdin"     , row.getLinkedin());
			    	  rObj.put("Twitter"         , row.getTwitter());
			    	  rObj.put("iDNO"         , row.getiDNO());
			    	  
			    	  List<SupplierMasterAddressModel> SupMasterAddress = row.getSupMAddress();
			    	 for( SupplierMasterAddressModel supAddress: SupMasterAddress) {
			    		 if(!supAddress.getStatus().equals("A")) {
			    			 continue;
			    		 }
			    		 if(supAddress.getCategory().equals(SMFixedValue.ADDRESS_CATEGORY_HO)) {
				              rObj.put("HOAddress"          ,supAddress.getAddress()) ;
					    	  rObj.put("HOSector"        , supAddress.getSector());
					    	  rObj.put("HOCity"         , supAddress.getCity());
					    	  rObj.put("HOState"         , supAddress.getState());
					    	  rObj.put("HOCountry"     , supAddress.getCountry());
					    	  rObj.put("HOPincode"         , supAddress.getPincode());
			    		 }else {
				              rObj.put("Address"          ,supAddress.getAddress()) ;
					    	  rObj.put("Sector"        , supAddress.getSector());
					    	  rObj.put("City"         , supAddress.getCity());
					    	  rObj.put("State"         , supAddress.getState());
					    	  rObj.put("Country"     , supAddress.getCountry());
					    	  rObj.put("Pincode"         , supAddress.getPincode());
			    		 }
			    	 }
			    	 
			    	  List<SupplierMasterContact> supContact = row.getSupMasterContact();
			    	 for( SupplierMasterContact spContact: supContact) {
			    		 if(!spContact.getStatus().equals("A")) {
			    			 continue;
			    		 }
			    		 if(spContact.getContactRef().equals(SMFixedValue.CONTACT_REF_HO)) {
				              rObj.put("HOEmail"          ,spContact.getEmailID()) ;
					    	  rObj.put("HOMobile"        , spContact.getMobileNo());
					    	  rObj.put("HOPhone"         , spContact.getPhoneNo());
			    		 }else {
				              rObj.put("Email"          ,spContact.getEmailID()) ;
					    	  rObj.put("Mobile"        , spContact.getMobileNo());
					    	  rObj.put("Phone"         , spContact.getPhoneNo());
			    		 }
			    	 }
			    	  supplierList.add(rObj);	
			    }// EOF outer for loop
		       sessionObj.close();
		    	erMsg += "\n"+ SMFixedValue.OUTPUT +" Rows:" + rows.size() 
		    	       + SMFixedValue.SUPPLIER_MASTER + SMFixedValue.ACTION_LIST + SMFixedValue.ACTION_GENERATE 
		    	       +"\n" +supplierList;
			}catch(Exception e) {
				erMsg += SMFixedValue.EXEC_CATCH_MSG + "\n"+ e;
			}finally {
				System.out.println("\n"+erMsg );
			}			
			return supplierList;
	}
	public static int remSupplierMasteriDNO(SupplierMasterModel supplierMasterModel) {
		String erMsg = SMFixedValue.ACTION_REMOVING + SMFixedValue.SUPPLIER_MASTER 
				     + SMFixedValue.information + SMFixedValue.MODEL_IDNO+ ":"+ Integer.toString(supplierMasterModel.getiDNO());
        int executeUpdate = 0;
	    try(Session sessionObj = HibernateDAO.getSessionFactory().openSession()) {
	        Query query = sessionObj.createQuery(SMFixedValue.HQL_REM_SUPPLIER_IDNO);
	        query.setParameter(SMFixedValue.PARM_IDNO   , supplierMasterModel.getiDNO());
	        query.setParameter(SMFixedValue.PARM_REGNO  , supplierMasterModel.getRegNo());
	        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
	        query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);

	        erMsg += SMFixedValue.PARM_SET_MSG;  
	        sessionObj.beginTransaction();
	        executeUpdate= query.executeUpdate();
 	        sessionObj.close();
	        erMsg += Integer.toString(executeUpdate) +" "+SMFixedValue.EXEC_REMOVE_MSG ;
		}catch(Exception e) {
			erMsg += SMFixedValue.EXEC_CATCH_MSG + e;
		}finally {
			System.out.println("\n"+erMsg );
		}			
		return executeUpdate;
		}
	public static int SupplierMasterUpdateInformation(SupplierMasterModel supplierMasterModel) {
		  String erMsg =SMFixedValue.ACTION_START +
		  SMFixedValue.update + SMFixedValue.SUPPLIER_MASTER ;
		  Transaction transaction = null;
		  int exeStatus=0;
		  try ( Session sessionObj = HibernateDAO.getSessionFactory().openSession()){
		        Query query = sessionObj.createQuery(SMFixedValue.HQL_REM_SUPPLIER_IDNO);
		        query.setParameter(SMFixedValue.PARM_IDNO   , supplierMasterModel.getiDNO());
		        query.setParameter(SMFixedValue.PARM_REGNO  , supplierMasterModel.getRegNo());
		        query.setParameter(SMFixedValue.PARM_NSTATUS, SMFixedValue.REMOVE_STATUS);
		        query.setParameter(SMFixedValue.PARM_OSTATUS, SMFixedValue.STATUS);
		        transaction =	  sessionObj.beginTransaction(); 
		        exeStatus= query.executeUpdate(); // UPDATE STATUS AS 'D' FOR DEACTIVATE RECORD
			  sessionObj.save(supplierMasterModel);
			  sessionObj.getTransaction().commit();
			  sessionObj.close();
		  erMsg += "\n" +SMFixedValue.SUPPLIER_MASTER  + SMFixedValue.EXEC_CREATE_MSG ;
		  exeStatus=1;
		  }catch (Exception e) {
			   if(transaction!=null ) {
				   transaction.rollback(); 
				  erMsg +=SMFixedValue.EXEC_CATCH_MSG + e;
		   }
		  }finally {
			  System.out.println("\n"+erMsg);
		  }
		  return exeStatus;
	}
	
}
