package com.rao.System.PO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOTempPO {
	
	public static JsonArray NewTPO(POModel TPOModel) {
		System.out.println("Step2: Start of the DAO Action");
	    JsonArray TempPOList=new JsonArray();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [NewTempPO](?,?,?,?,?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, (String)TPOModel.getRwaRegNO());
			ComVar.myStat.setString(2, (String)TPOModel.getUId());
			ComVar.myStat.setString(3, (String)TPOModel.getPONo());
			ComVar.myStat.setString(4, (String)TPOModel.getItemCode());
			ComVar.myStat.setString(5, (String)TPOModel.getItemName());
			ComVar.myStat.setString(6, (String)TPOModel.getBrand());
			ComVar.myStat.setString(7, (String)TPOModel.getQuantity());
			ComVar.myStat.setString(8, (String)TPOModel.getUnit());
			ComVar.myStat.setString(9, (String)TPOModel.getNote());
			
			System.out.println("Step 3.1");
			ShowTempPOListPassToSP(TPOModel);
			boolean spExecuteStatus = ComVar.myStat.execute();
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst!=null) { 
			    System.out.println("\n inner loop");
				while (ComVar.prst.next()) {
					
					JsonObject TempPo= new JsonObject();
					
					TempPo.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
					TempPo.put("Sno",ComVar.prst.getString("SNO"));
					TempPo.put("ItemCode",ComVar.prst.getString("ItemCode"));
					TempPo.put("ItemName",ComVar.prst.getString("ItemName"));
					TempPo.put("Brand",ComVar.prst.getString("Brand"));
					TempPo.put("Quantity",ComVar.prst.getString("Quantity"));
					TempPo.put("Unit",ComVar.prst.getString("Unit"));
					TempPo.put("Note",ComVar.prst.getString("Note"));
					TempPo.put("SPstatus","1");
					
					TempPOList.add(TempPo);
					System.out.println(" TEmpo OBj:"+TempPo);
					System.out.println("TempPOList :" + TempPOList);
				}
//				ShowAPTOutputInfo(InvoiceDetails);// display output	
//				ShowNewWTInfoPassToSP(user);
		    }
			System.out.print("Step 3.2:SP Status Code:(1.Success 2.Duplicate InvItem 3.Technical Issues. SP STATUS CODE:");
			TPOModel.setValid(true);
			
		}catch(Exception e) {
			System.out.println(	"Technical error: Unable to create PO Information. Please  Contact Admin :\n"	+ e);
			TPOModel.setValid(false);
			TPOModel.setSPstatus(3);
		} finally {
			if (ComVar.prst != null) {
				try {
					ComVar.prst.close();
				} catch (Exception e) {
				}
				ComVar.prst = null;
			}
			if (ComVar.myStat != null) {
				try {
					ComVar.myStat.close();
				} catch (Exception e) {
				}
				ComVar.myStat = null;
			}
			if (ComVar.Conn != null) {
				try {
					ComVar.Conn.close();
				} catch (Exception e) {
				}
				ComVar.Conn = null;
			}
		}
		return TempPOList	;
	}

	public static void ShowTempPOListPassToSP(POModel TPOModel) {
		System.out.println("\nInvoice Item-> RwaNumber :" + TPOModel.getRwaRegNO()+ ", PONo:" +TPOModel.getPONo()
		+", Item Code:" + TPOModel.getItemCode()
		+ " , Item Name :" + TPOModel.getItemName()
		+ ",Brand:" + TPOModel.getBrand() + ",Quantity: " + TPOModel.getQuantity()+" Unit :" + TPOModel.getUnit() 
		+ ",Note:" +TPOModel.getNote() );
	}
	public static JsonArray retriveTempPO(POModel TPOModel) {
		JsonArray TempPOList= new JsonArray();
		try {
			ComVar.Conn=ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");
			
			ComVar.myStat=ComVar.Conn.prepareCall("{call [RevPOItem](?,?,?,?)}");
			ComVar.myStat.setString(1, (String)TPOModel.getRwaRegNO());
			ComVar.myStat.setString(2, (String)TPOModel.getPONo());
			ComVar.myStat.setString(3, (String)TPOModel.getSNO());
			ComVar.myStat.setString(4, (String)TPOModel.getActionType());
			System.out.println("step 3.2  parameter pass to sp ");

			ComVar.myStat.execute();
			System.out.println("step 3.3 SP execute successfully.");
			ComVar.prst=ComVar.myStat.getResultSet();
			System.out.print("\nStep 3.4 SP create resultset "	);
		    if(ComVar.prst!=null) { 
			    System.out.println("\n inner loop");
				while (ComVar.prst.next()) {
					
					JsonObject TempPo= new JsonObject();
					
					TempPo.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
					TempPo.put("Sno",ComVar.prst.getString("SNO"));
					TempPo.put("ItemCode",ComVar.prst.getString("ItemCode"));
					TempPo.put("ItemName",ComVar.prst.getString("ItemName"));
					TempPo.put("Brand",ComVar.prst.getString("Brand"));
					TempPo.put("Quantity",ComVar.prst.getString("Quantity"));
					TempPo.put("Unit",ComVar.prst.getString("Unit"));
					TempPo.put("Note",ComVar.prst.getString("Note"));
					TempPo.put("SPstatus","1");
					System.out.println("inner loop 1");	
					TempPOList.add(TempPo);
				}
//				ShowAPTOutputInfo(InvoiceDetails);// display output	
//				ShowNewWTInfoPassToSP(user);
		    }
			
		}catch(SQLException e) {
			System.out.println("Technical error(SQL) in Retrieving [PO] Information!" + e);
			
		}catch(Exception e) {
			System.out.println("Technical error in Retrieving [PO] Information!" + e);
		}finally {
			if (ComVar.prst != null) {
				try {
					ComVar.prst.close();
				} catch (Exception e) {
				}
				ComVar.prst = null;
			}
			if (ComVar.myStat != null) {
				try {
					ComVar.myStat.close();
				} catch (Exception e) {
				}
				ComVar.myStat = null;
			}
			if (ComVar.Conn != null) {
				try {
					ComVar.Conn.close();
				} catch (Exception e) {
				}
				ComVar.Conn = null;
			}
		}
		
		return TempPOList ;
	}
}
