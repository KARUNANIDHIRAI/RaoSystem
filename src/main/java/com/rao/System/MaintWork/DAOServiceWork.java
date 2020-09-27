package com.rao.System.MaintWork;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.PO.POModel;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOServiceWork {
	public static ServWorkModel NewSOInfo(ServWorkModel SWModel, String erMsg) {
		 erMsg+=" Step 3. DAO ";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" Step 3.1  Connection successfully";
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServWorkNew](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, (String) SWModel.getRwaRegNo());
			ComVar.myStat.setString(2, (String) SWModel.getUID());
			ComVar.myStat.setString(3, (String) SWModel.getServiceType());
			ComVar.myStat.setString(4, (String) SWModel.getServCharge());
			ComVar.myStat.setString(5, (String) SWModel.getSWStatus());
			ComVar.myStat.setString(6, (String) SWModel.getSWNO());
			ComVar.myStat.setString(7, (String) SWModel.getSdate());
			ComVar.myStat.setString(8, (String) SWModel.getEdate());
			ComVar.myStat.setString(9, (String) SWModel.getPName());
			ComVar.myStat.setString(10,(String) SWModel.getPMobileNo());
			ComVar.myStat.setString(11,(String) SWModel.getAddress());
			ComVar.myStat.setString(12,(String) SWModel.getCity());
			ComVar.myStat.setString(13,(String) SWModel.getState());
			ComVar.myStat.setString(14,(String) SWModel.getCountry());
			ComVar.myStat.setString(15,(String) SWModel.getPin());
			ComVar.myStat.registerOutParameter(16, Types.INTEGER);
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);
			ComVar.myStat.registerOutParameter(18, Types.NVARCHAR);

			erMsg+=" Step 3.2  SP Param Created";
			ShowSWInfo(SWModel);
			erMsg+=" Step 3.3  SP Param Shown";
			ComVar.myStat.execute();
  		    erMsg+=" Step 3.4  SP Execute Successfully";
			SWModel.setSPstatus(ComVar.myStat.getInt(16));// SP status after sp execution
			SWModel.setSPInnerStatus(ComVar.myStat.getInt(17));// SP Inner status during execution
			SWModel.setValid(true);
			System.out.println("sp error :" + ComVar.myStat.getNString(18) );
  		    erMsg+=" Step 3.5  SP Status Code:(1.Success 2.Duplicate  3.Technical Issues.:, SPC :" +
  		    		SWModel.getSPstatus() + " SPIC:" + SWModel.getSPInnerStatus();
		}catch (SQLException e) {
			System.out.println(erMsg +"\n" + e);
			SWModel.setValid(false);
			SWModel.setSPstatus(3);
		}catch (Exception e) {
			System.out.println(erMsg +"\n" + e);
			SWModel.setValid(false);
			SWModel.setSPstatus(3);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return SWModel ;
	}

	public static void ShowSWInfo(ServWorkModel user) {
		System.out.println("\nRwaNo :" + user.getRwaRegNo()+ ", UID:" +user.getUID()
		+", SType:" + user.getServiceType()+ ",Scharge:" + user.getServCharge() +", MWNo:" + user.getSWNO()
		+ " MW Status :" + user.getSWStatus() + " ,SDate:" + user.getSdate()	+  " ,EDate:" + user.getSdate()	
		+ " ,Name :" + user.getPName() + " ,Mobile: " + user.getPMobileNo());
		System.out.println(" Address :" + user.getAddress() + ", City:" +user.getCity() 
		+ " State: " + user.getState() + " ,Country :" + user.getCountry()+" ,Pin Code :" + user.getPin());
		return ;
	}

	public static JsonArray MaintWorkType(String rwaRegNo)  {
		JsonArray workType= new JsonArray();
		String erMsg= "Step 3 DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServiceTypeList](?,?)}");
			ComVar.myStat.setString(1,  rwaRegNo);
			ComVar.myStat.registerOutParameter(2, Types.NVARCHAR);
			erMsg+=" 3.2  SP Param OK";
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute OK";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
				System.out.println(erMsg + " No Recod Found [db]");
		    	return workType	;
		    }	
			erMsg += " 3.4 : SP Data ArrayList";
			int ctr=0;
			JsonObject mwType1= new JsonObject();
			mwType1.put("id","0");
			mwType1.put("name","Choose Maintenance Work Type");
			workType.add(mwType1);
			while (ComVar.prst.next()) {
				JsonObject mwType= new JsonObject();
				mwType.put("id",ComVar.prst.getString("SCODE"));
				mwType.put("name",ComVar.prst.getString("SName"));
				workType.add(mwType);
			}
			System.out.println(" Service Type List :" + workType);
		}catch(SQLException e) {
			erMsg += "Step 3.5 : catch Sql Exception retriving [sp data]";
			System.out.println("\nerMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.5 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return workType;
	}
	public static JsonArray MaintWorkView(MWSearch mwSearch)  {
		JsonArray MWSearchReslt= new JsonArray();
		String erMsg= "Step 3 DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServWorkSearch](?,?,?,?,?,?,?)}");
			ComVar.myStat.setString(1,  mwSearch.getRwaRegNo());
			ComVar.myStat.setString(2,  mwSearch.getMWNO());
			ComVar.myStat.setString(3,  mwSearch.getSPName());
			ComVar.myStat.setString(4,  mwSearch.getFDate());
			ComVar.myStat.setString(5,  mwSearch.getTDate());
			ComVar.myStat.setString(6,  mwSearch.getMWType());
			ComVar.myStat.registerOutParameter(7, Types.NVARCHAR);
			erMsg+="3.2 sp param :" + mwSearch.getRwaRegNo() +" " + mwSearch.getMWNO() + " " + mwSearch.getSPName() + "" 
					+  mwSearch.getFDate()+" " + mwSearch.getTDate() + " "+mwSearch.getMWType();
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute Successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
		    	erMsg += " No Recod Found [db]";
		    	System.out.println(erMsg);
		    	return MWSearchReslt	;
		    }	
			while (ComVar.prst.next()) {
				JsonObject mwSResult= new JsonObject();
				mwSResult.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
				mwSResult.put("SONO",ComVar.prst.getString("ServiceNo"));
				mwSResult.put("SName",ComVar.prst.getString("SName"));
				mwSResult.put("SDate",ComVar.prst.getString("SDate"));
				mwSResult.put("EDate",ComVar.prst.getString("SEDate"));
				mwSResult.put("Status",ComVar.prst.getString("Status"));
				mwSResult.put("Charge",ComVar.prst.getString("Charge"));
				mwSResult.put("SPName",ComVar.prst.getString("SPName"));
				mwSResult.put("MobileNo",ComVar.prst.getString("MobileNo"));
				mwSResult.put("City",ComVar.prst.getString("City"));
				MWSearchReslt.add(mwSResult);
			}
//			System.out.println(" MW Search List :" + MWSearchReslt);
		}catch(SQLException e) {
			erMsg += "Step 3.5 : catch Sql Exception retriving [sp data]";
			System.out.println("\n erMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.5 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return MWSearchReslt;
	}

	public static JsonArray MaintWorkDel(MWSearch mwSearch)  {
		JsonArray MWSearchReslt= new JsonArray();
		String erMsg= "Step 3 DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServWorkDel](?,?,?,?,?,?,?,?)}");
			ComVar.myStat.setString(1,  mwSearch.getRwaRegNo());
			ComVar.myStat.setString(2,  mwSearch.getMWNO());
			ComVar.myStat.setString(3,  mwSearch.getSPName());
			ComVar.myStat.setString(4,  mwSearch.getFDate());
			ComVar.myStat.setString(5,  mwSearch.getTDate());
			ComVar.myStat.setString(6,  mwSearch.getMWType());
			ComVar.myStat.setString(7, mwSearch.getDelMWNO());
			ComVar.myStat.registerOutParameter(8, Types.NVARCHAR);

			System.out.println("s.2.1 sp param :" + mwSearch.getRwaRegNo() +" " + mwSearch.getMWNO() + " " + mwSearch.getSPName() + "" 
					+  mwSearch.getFDate()+" " + mwSearch.getTDate() + " "+mwSearch.getMWType() + " " + mwSearch.getDelMWNO() );
			erMsg+=" 3.2  SP Param OK";
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute Successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
		    	erMsg += " No Recod Found [db]";
		    	System.out.println(erMsg);
		    	return MWSearchReslt	;
		    }	
			while (ComVar.prst.next()) {
				JsonObject mwSResult= new JsonObject();
				mwSResult.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
				mwSResult.put("SONO",ComVar.prst.getString("ServiceNo"));
				mwSResult.put("SName",ComVar.prst.getString("SName"));
				mwSResult.put("SDate",ComVar.prst.getString("SDate"));
				mwSResult.put("EDate",ComVar.prst.getString("SEDate"));
				mwSResult.put("Status",ComVar.prst.getString("Status"));
				mwSResult.put("Charge",ComVar.prst.getString("Charge"));
				mwSResult.put("SPName",ComVar.prst.getString("SPName"));
				mwSResult.put("MobileNo",ComVar.prst.getString("MobileNo"));
				mwSResult.put("City",ComVar.prst.getString("City"));
				MWSearchReslt.add(mwSResult);
			}
//			System.out.println(" MW Del List :" + MWSearchReslt);
		}catch(SQLException e) {
			erMsg += "Step 3.5 : catch Sql Exception retriving [sp data]";
			System.out.println("\n erMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.5 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return MWSearchReslt;
	}

	public static JsonArray MaintWorkEdit(MWEdit mwEdit)  {
		JsonArray MWSearchReslt= new JsonArray();
		String erMsg= "Step 3 kn MW Edit DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServWorkForEdit](?,?,?)}");
			ComVar.myStat.setString(1,  mwEdit.getRwaRegNo());
			ComVar.myStat.setString(2,  mwEdit.getMWNO());
			ComVar.myStat.registerOutParameter(3, Types.NVARCHAR);
				
			
			erMsg+="3.2 sp param :" + mwEdit.getRwaRegNo() +" " + mwEdit.getMWNO() ;
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute Successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
		    	erMsg += " No Recod Found [db]";
		    	System.out.println(erMsg) ;
		    	return MWSearchReslt	;
		    }	
			while (ComVar.prst.next()) {
				JsonObject mwSResult= new JsonObject();
				mwSResult.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
				mwSResult.put("SONO",ComVar.prst.getString("ServiceNo"));
				mwSResult.put("SCode",ComVar.prst.getString("SCode"));
				mwSResult.put("SDate",ComVar.prst.getString("ServSDate"));
				mwSResult.put("EDate",ComVar.prst.getString("ServEDate"));
				mwSResult.put("SPName",ComVar.prst.getString("SPName"));
				mwSResult.put("MobileNo",ComVar.prst.getString("MobileNo"));
				mwSResult.put("Address",ComVar.prst.getString("Address"));
				mwSResult.put("City",ComVar.prst.getString("City"));
				mwSResult.put("State",ComVar.prst.getString("State"));
				mwSResult.put("Country",ComVar.prst.getString("Country"));
				mwSResult.put("PinCode",ComVar.prst.getString("PinCode"));
				mwSResult.put("ServicStatus",ComVar.prst.getString("ServStatus"));
				mwSResult.put("Charges",ComVar.prst.getString("TotalCharge"));

				MWSearchReslt.add(mwSResult);
			
			}
//			System.out.println(" MW Edit List :" + MWSearchReslt);
		}catch(SQLException e) {
			erMsg += "Step 3.4 : catch Sql Exception retriving [sp data]";
			System.out.println("\n erMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.4 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return MWSearchReslt;
	}
	public static JsonArray mwWokerInfoRetrieve(MWEdit mwEdit)  {
		JsonArray MWSearchReslt= new JsonArray();
		String erMsg= "Step 3 kn MW Edit DAO Start";
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+=" 3.1  Connection OK";
			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServWorkerForEdit](?,?,?)}");
			ComVar.myStat.setString(1,  mwEdit.getRwaRegNo());
			ComVar.myStat.setString(2,  mwEdit.getMWNO());
			ComVar.myStat.registerOutParameter(3, Types.NVARCHAR);
			erMsg+="3.2 sp param :" + mwEdit.getRwaRegNo() +" " + mwEdit.getMWNO() ;
			ComVar.myStat.execute();
  		    erMsg+=" 3.3  SP Execute Successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
		    	erMsg += " No Recod Found [db]";
		    	System.out.println(erMsg) ;
		    	return MWSearchReslt	;
		    }	

		    while (ComVar.prst.next()) {
				JsonObject mwSResult= new JsonObject();
				mwSResult.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
				mwSResult.put("SONO",ComVar.prst.getString("ServiceNo"));
				mwSResult.put("SNo",ComVar.prst.getString("SNo"));
				mwSResult.put("Name",ComVar.prst.getString("WorkerName"));
				mwSResult.put("MobileNo",ComVar.prst.getString("MobileNo"));
				mwSResult.put("Wages",ComVar.prst.getString("LabourCharge"));
				mwSResult.put("Date",ComVar.prst.getString("WorkedOn"));
				MWSearchReslt.add(mwSResult);
			}
//			System.out.println(" MW Edit List :" + MWSearchReslt);
		}catch(SQLException e) {
			erMsg += "Step 3.4 : catch Sql Exception retriving [sp data]";
			System.out.println("\n erMsg \n" + e);
		}catch(Exception e) {
			erMsg += "Step 3.4 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return MWSearchReslt;
	}
	
	
}
