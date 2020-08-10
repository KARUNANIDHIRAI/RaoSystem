package com.rao.System.PurchaseMaterial;

import java.sql.Types;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOFinalPurMaterial {
	
	public static PurMatModel NewPurMatDetail(PurMatModel InvoiceDetail) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [NewInvoiceItem](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, (String) InvoiceDetail.getRwaRegNo());
			ComVar.myStat.setString(2, (String) InvoiceDetail.getUserID());

			ComVar.myStat.setString(3, (String)  InvoiceDetail.getInvoiceNo());
			ComVar.myStat.setString(4, (String)  InvoiceDetail.getInvoiceDate());
			ComVar.myStat.setString(5, (String)  InvoiceDetail.getVendorName());
			ComVar.myStat.setString(6, (String)  InvoiceDetail.getVendorAddId());
			ComVar.myStat.setString(7, (String)  InvoiceDetail.getCity());
			ComVar.myStat.setString(8, (String)  InvoiceDetail.getState());
			ComVar.myStat.setString(9, (String)  InvoiceDetail.getCountry());
			ComVar.myStat.setString(10, (String)  InvoiceDetail.getZipCode());
			ComVar.myStat.setString(11, (String)  InvoiceDetail.getVMobileNo());
			ComVar.myStat.setString(12, (String)  InvoiceDetail.getHsnNo());
			ComVar.myStat.setString(13, (String)  InvoiceDetail.getCustomerName());
			ComVar.myStat.setString(14, (String)  InvoiceDetail.getCMobileNo());
			ComVar.myStat.setString(15, (String)  InvoiceDetail.getOrderNO());
			ComVar.myStat.setString(16, (String)  InvoiceDetail.getPaymentMode());
			ComVar.myStat.setString(17, (String)  InvoiceDetail.getTotBillAmount());
			ComVar.myStat.setString(18, (String)  InvoiceDetail.getTotGSTAmount());
			ComVar.myStat.setString(19, (String)  InvoiceDetail.getTotDisAmount());
			ComVar.myStat.setString(20, (String)  InvoiceDetail.getNetAmount());
			
			ComVar.myStat.registerOutParameter(21, Types.INTEGER);
			ComVar.myStat.registerOutParameter(22, Types.INTEGER);

			System.out.println("Step 3.1 Create SP Parameter Sucessfully");
			ShowInvInfo(InvoiceDetail);
			boolean spExecuteStatus = ComVar.myStat.execute();
			InvoiceDetail.setSPstatus(ComVar.myStat.getInt(21));// SP status after sp execution
			InvoiceDetail.setSPInnerStatus(ComVar.myStat.getInt(22));// SP Inner status during execution

			System.out.print("Step 3.2.: SP Execute Status Code:(1.Success 2.Duplicate InvItem 3.Technical Issues. SP STATUS CODE : "
							+ InvoiceDetail.getSPstatus() + " SP INNER Staus:" + InvoiceDetail.getSPInnerStatus());
			InvoiceDetail.setValid(true);
			
		}catch (Exception e) {
			System.out.println(	"Technical error: Unable to create Tanker Information. Please  Contact Admin :\n"	+ e);
			InvoiceDetail.setValid(false);
			InvoiceDetail.setSPstatus(3);
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
		
		return InvoiceDetail;
	}

	public static void ShowInvInfo(PurMatModel user) {
		System.out.println("\nInvoice Item-> RwaNumber :" + user.getRwaRegNo()+ ", User Id:" +user.getUserID()+", Invoice No:" + user.getInvoiceNo()
		+ " ,Date:" + user.getInvoiceDate()
		+ ",Total Amt" + user.getTotBillAmount() + ",TDisc: " + user.getTotDisAmount()+" TGST :" + user.getTotGSTAmount() + "NetAmt:" +user.getNetAmount() );
		System.out.println("\n ,CName:" + user.getCustomerName() +",CMObile" + user.getCMobileNo());
		System.out.println("VName " + user.getVendorName() + " ,VMobile" + user.getVMobileNo()+" ,VAddress" + user.getVendorAddId()+
				" ,City:" + user.getCity()+" ,State:" + user.getState()+" ,Country:" + user.getCountry()+" ,Pin:" + user.getZipCode());
		
	}
	
}
