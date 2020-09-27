package com.rao.System.MaintWork;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.PO.POModel;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOTempServWork {
	public static JsonArray NewTSW(TmpSWModel tempServWorkModel) {
		String erMsg=" Step2: DAO Action";
	    JsonArray TempPOList=new JsonArray();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg += "Step 3 : Connection successfully";
            switch (tempServWorkModel.getActionType()){
            case "NEW" :
    			ComVar.myStat = ComVar.Conn.prepareCall("{call [ServWorkNewTemp](?,?,?,?,?,?,?)}");
    			
    			ComVar.myStat.setString(1, (String)tempServWorkModel.getRwaRegNo());
    			ComVar.myStat.setString(2, (String)tempServWorkModel.getUID());
    			ComVar.myStat.setString(3, (String)tempServWorkModel.getSWNO());
    			ComVar.myStat.setString(4, (String)tempServWorkModel.getName());
    			ComVar.myStat.setString(5, (String)tempServWorkModel.getMobileNo());
    			ComVar.myStat.setString(6, (String)tempServWorkModel.getDate());
    			ComVar.myStat.setString(7, (String)tempServWorkModel.getWages());
            	break;
           	case "DELETE":
        			ComVar.myStat=ComVar.Conn.prepareCall("{call [ServWorkDelTemp](?,?,?,?)}");
        			ComVar.myStat.setString(1, (String)tempServWorkModel.getRwaRegNo());
        			ComVar.myStat.setString(2, (String)tempServWorkModel.getSWNO());
        			ComVar.myStat.setString(3, (String)tempServWorkModel.getSNo());
        			ComVar.myStat.setString(4, (String)tempServWorkModel.getActionType());
            	break;	
            default:
        		return TempPOList	;
            }
			erMsg += " Step 3.1 : SP Param successfully";
			ShowTempSWParamToSP(tempServWorkModel);
			erMsg += " Step 3.2 : SP Param show successfully";
			boolean spExecuteStatus = ComVar.myStat.execute();
			erMsg += "Step 3.3 : SP Execute successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
				System.out.println(erMsg);
		    	return TempPOList	;
		    }	
			erMsg += " Step 3.3 : SP Data populate";
			while (ComVar.prst.next()) {
				
				JsonObject TempPo= new JsonObject();
				
				TempPo.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
				TempPo.put("SNo",ComVar.prst.getString("SNo"));
				TempPo.put("Name",ComVar.prst.getString("WorkerName"));
				TempPo.put("MobileNo",ComVar.prst.getString("MobileNo"));
				TempPo.put("Date",ComVar.prst.getString("WorkedOn"));
				TempPo.put("Wages",ComVar.prst.getString("LabourCharge"));
				TempPo.put("SPstatus","1");
				
				TempPOList.add(TempPo);
			}
//				ShowAPTOutputInfo(InvoiceDetails);// display output	
			System.out.println("Temp SW List :" + TempPOList);
			tempServWorkModel.setValid(true);
			
		}catch(Exception e) {
			erMsg += "Step 3.4 : catch Exception : Unable to create Service Information";
			System.out.println(erMsg);
			tempServWorkModel.setValid(false);
			tempServWorkModel.setSPstatus(3);
		} finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
			}
		return TempPOList	;
	}

	public static void ShowTempSWParamToSP(TmpSWModel TPOModel) {
		System.out.println("\n RwaNo :" + TPOModel.getRwaRegNo()+ ", UID:" +TPOModel.getUID()+ ", ServWrok :" + TPOModel.getSWNO() 
		+", Name : " + TPOModel.getName() + " , Mobile No :" + TPOModel.getMobileNo()+ ", Date: " + TPOModel.getDate() + ", Wages: " + TPOModel.getWages() );
	}
	public  JsonArray retriveTempSW(TmpSWModel TSWModel) {
		JsonArray TempPOList= new JsonArray();
		String erMsg="";
		try {
			ComVar.Conn=ConnectionManager.getConnection();
			erMsg="step 3.1 Connection successfully";
			
			ComVar.myStat=ComVar.Conn.prepareCall("{call [RevPOItem](?,?,?,?)}");
			ComVar.myStat.setString(1, (String)TSWModel.getRwaRegNo());
			ComVar.myStat.setString(2, (String)TSWModel.getSWNO());
			ComVar.myStat.setString(3, (String)TSWModel.getSNo());
			ComVar.myStat.setString(4, (String)TSWModel.getActionType());
			System.out.println("step 3.2  parameter pass to sp ");
			erMsg+="step 3.2 SP Param successfully";

			boolean spExecuteStatus = ComVar.myStat.execute();
			erMsg += "Step 3.3 : SP Execute successfully";
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst == null) {
				System.out.println(erMsg);
		    	return TempPOList	;
		    }	
		    System.out.println("\n inner loop");
			erMsg += "Step 3.4 : SP Data populating";
			while (ComVar.prst.next()) {
				
				JsonObject TempPo= new JsonObject();
				
				TempPo.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
				TempPo.put("SNo",ComVar.prst.getString("SNo"));
				TempPo.put("Name",ComVar.prst.getString("WorkerName"));
				TempPo.put("MobileNo",ComVar.prst.getString("MobileNo"));
				TempPo.put("Date",ComVar.prst.getString("WorkedOn"));
				TempPo.put("Wages",ComVar.prst.getString("LabourCharge"));
				TempPo.put("SPstatus","1");
				
				TempPOList.add(TempPo);
			}
//				ShowAPTOutputInfo(InvoiceDetails);// display output	
			System.out.println("TempPOList :" + TempPOList);
			System.out.println(erMsg);
			TSWModel.setValid(true);
		}catch(SQLException e) {
			erMsg += "Step 3.5 : catch Sql Exception retriving [sp data]";
			System.out.println("\nerMsg \n" + e);
			
		}catch(Exception e) {
			erMsg += "Step 3.5 : catch Exception " + e;
			System.out.println("\nerMsg \n" + e);
		}finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return TempPOList ;
	}
}	