package com.rao.System.PurchaseMaterial;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.rao.System.Apartment.AptModel;
import com.rao.System.WaterTankerEntry.TankerModel;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOPurMaterial {
	
	public static MatModel CreateInvoiceItem(MatModel InvItem) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [NewTempInvoiceItem](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			/*
			 * ComVar.myStat.setString(1, (String) InvItem.getUserID());
			 * ComVar.myStat.setString(2, (String) InvItem.getRwaRegNo());
			 * ComVar.myStat.setString(4, (String) InvItem.getVendorName());
			 * ComVar.myStat.setString(5, (String) InvItem.getVendorAddId());
			 * ComVar.myStat.setString(6, (String) InvItem.getVMobileNo());
			 * ComVar.myStat.setString(7, (String) InvItem.getTinNo());
			 * ComVar.myStat.setString(8, (String) InvItem.getCustomerName());
			 * ComVar.myStat.setString(9, (String) InvItem.getCMobileNo());
			 * ComVar.myStat.setString(10, (String) InvItem.getInvoiceDate());
			 * ComVar.myStat.setString(11, (String) InvItem.getOrderNO());
			 * ComVar.myStat.setString(12, (String) InvItem.getPaymentMode());
			 * ComVar.myStat.setString(13, (String) InvItem.getPayID());
			 */
			ComVar.myStat.setString(1, (String) InvItem.getRwaRegNo());
			ComVar.myStat.setString(2, (String) InvItem.getUserID());

			ComVar.myStat.setString(3, (String)  InvItem.getInvoiceNo());
			ComVar.myStat.setString(4, (String)  InvItem.getItemName());
			ComVar.myStat.setString(5, (String)  InvItem.getQuantity());
			ComVar.myStat.setString(6, (String)  InvItem.getUnit());
			ComVar.myStat.setString(7, (String)  InvItem.getPrice());
			ComVar.myStat.setString(8, (String)  InvItem.getAmount());
			ComVar.myStat.setString(9, (String)  InvItem.getDisRate());
			ComVar.myStat.setString(10, (String)  InvItem.getDisAmount());
			ComVar.myStat.setString(11, (String)  InvItem.getGSTRate());
			ComVar.myStat.setString(12, (String)  InvItem.getGSTAmount());
			ComVar.myStat.setString(13, (String)  InvItem.getNetAmount());
			ComVar.myStat.registerOutParameter(14, Types.INTEGER);
			ComVar.myStat.registerOutParameter(15, Types.INTEGER);

			System.out.println("Step 3.1");
			ShowNewWTInfoPassToSP(InvItem);
			boolean spExecuteStatus = ComVar.myStat.execute();
			InvItem.setSPstatus(ComVar.myStat.getInt(14));// SP status after sp execution
			InvItem.setSPInnerStatus(ComVar.myStat.getInt(15));// SP Inner status during execution

			System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate InvItem 3.Technical Issues. SP STATUS CODE : "
							+ InvItem.getSPstatus() + " SP INNER Staus:" + InvItem.getSPInnerStatus());
			InvItem.setValid(true);

		} catch (Exception e) {
			System.out.println(
					"Technical error: Unable to create Tanker Information. Please  Contact Admin :\n"	+ e);
			InvItem.setValid(false);
			InvItem.setSPstatus(3);
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
		return InvItem;
	}

	public static void ShowNewWTInfoPassToSP(MatModel user) {
		System.out.println("\nInvoice Item-> RwaNumber :" + user.getRwaRegNo()+ ", User Id:" +user.getUserID()+", Item Name:" + user.getItemName()
		+ " , Price :" + user.getPrice()
		+ ",quantity:" + user.getQuantity() + ",Unit: " + user.getUnit()+" Amount :" + user.getAmount() 
		+ ",Disc Rate:" +user.getDisRate() + " ,Disc Amount:" + user.getDisAmount() +",Gst Rate:" + user.getGSTRate());
		System.out.println("Gst amount: " + user.getGSTAmount() + " ,Net Amount:" + user.getNetAmount()
		);
		
	}

	public static JsonArray retriveInvoiceItems(JsonArray user, MatModel PurMat  ) {
		JsonArray InvoiceDetails= new JsonArray();
		
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");

				switch (PurMat.ActionType) {
				case "NEW":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [InvoiceItemTempList](?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getInvoiceNo());
				    break;
				case "DELETE":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [InvoiceItemTempListUpdated](?,?,?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getUserID());
				    ComVar.myStat.setString(3, (String) PurMat.getInvoiceNo());
				    ComVar.myStat.setString(4, (String) PurMat.getSno());
				    break;	
				case "EXIST":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [InvoiceItemTempList](?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getInvoiceNo());
				    break;	
				}

				System.out.println("step 3.2  parameter pass to sp ");
				ComVar.myStat.execute(); // execute SP
				System.out.print("\nStep 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	);
//				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
				    System.out.println("\n inner loop");
					while (ComVar.prst.next()) {
						JsonObject InvItem= new JsonObject();
						
						InvItem.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
						InvItem.put("InvoiceNo",ComVar.prst.getString("InvoiceNo"));
						InvItem.put("Sno",ComVar.prst.getString("Sno"));
						InvItem.put("ItemName",ComVar.prst.getString("ItemName"));
						InvItem.put("Quantity",ComVar.prst.getString("Quantity"));
						InvItem.put("Unit",ComVar.prst.getString("Unit"));
						InvItem.put("Price",ComVar.prst.getString("Price"));
						InvItem.put("Amount",ComVar.prst.getString("Amount"));
						InvItem.put("DisRate",ComVar.prst.getString("DisRate"));
						InvItem.put("DisAmount",ComVar.prst.getString("DisAmount"));
						InvItem.put("GSTRate",ComVar.prst.getString("GSTRate"));
						InvItem.put("GSTAmount",ComVar.prst.getString("GSTAmount"));
						InvItem.put("NetAmount",ComVar.prst.getString("NetAmount"));
						InvItem.put("SPstatus","1");

			
						
						InvoiceDetails.add(InvItem);
					}
//					ShowAPTOutputInfo(InvoiceDetails);// display output	
//					ShowNewWTInfoPassToSP(user);
			    }
			    
			    
			    else {
//		    		System.out.println("Obtained ResultSet object is empty");
//		    		user.setSPstatus(0);
			    }
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving Owner Information!" + e);
//			user.setSPstatus(3);
//			user.setValid(false);
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
		return InvoiceDetails;
	}

	
}
