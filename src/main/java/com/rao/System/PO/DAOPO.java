package com.rao.System.PO;

import java.sql.Types;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOPO {
	public static POModel NewPOInfo(POModel POInfo) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [PONew](?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, (String) POInfo.getRwaRegNO());
			ComVar.myStat.setString(2, (String) POInfo.getUId());
			ComVar.myStat.setString(3, (String)  POInfo.getPONo());
			ComVar.myStat.setString(4, (String)  POInfo.getPODate());
			ComVar.myStat.setString(5, (String)  POInfo.getCustomerName());
			ComVar.myStat.setString(6, (String)  POInfo.getMobileNo());
			ComVar.myStat.setString(7, (String)  POInfo.getAddress());
			
			ComVar.myStat.setString(8, (String)  POInfo.getCity());
			ComVar.myStat.setString(9, (String)  POInfo.getState());
			ComVar.myStat.setString(10, (String)  POInfo.getCountry());
			ComVar.myStat.setString(11, (String)  POInfo.getPinCode());
			ComVar.myStat.registerOutParameter(12, Types.INTEGER);
			ComVar.myStat.registerOutParameter(13, Types.INTEGER);

			System.out.println("Step 3.1 Create SP Parameter Sucessfully");
			ShowPOInfo(POInfo);
			ComVar.myStat.execute();
			POInfo.setSPstatus(ComVar.myStat.getInt(12));// SP status after sp execution
			POInfo.setSPInnerStatus(ComVar.myStat.getInt(13));// SP Inner status during execution

			System.out.print("Step 3.2.: SP Execute Status Code:(1.Success 2.Duplicate InvItem 3.Technical Issues. SP STATUS CODE : "
							+ POInfo.getSPstatus() + " SP INNER Staus:" + POInfo.getSPInnerStatus());
			POInfo.setValid(true);
			
		}catch (Exception e) {
			System.out.println(	"Technical error: Unable to create Tanker Information. Please  Contact Admin :\n"	+ e);
			POInfo.setValid(false);
			POInfo.setSPstatus(3);
		} finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		
		return POInfo;
	}

	public static void ShowPOInfo(POModel user) {
		System.out.println("\nRwaNumber :" + user.getRwaRegNO()+ ", User Id:" +user.getUId()+", PO No:" + user.getPONo()
		+ " ,Date:" + user.getPODate()	+ ",Name :" + user.getCustomerName() + " ,Mobile: " + user.getMobileNo());
		System.out.println(" Address :" + user.getAddress() + ", City:" +user.getCity() 
		+ " State: " + user.getState() + " ,Country :" + user.getCountry()+" ,Pin Code :" + user.getPinCode());
	}
		
	public static JsonArray retrivePOList(JsonArray user, POMISModel PurMat  ) {
		JsonArray InvoiceDetails= new JsonArray();
		
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");

				switch (PurMat.ActionType) {
				case "POList":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [POList](?,?,?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getPONO());
				    ComVar.myStat.setString(3, (String) PurMat.getFromDate());
				    ComVar.myStat.setString(4, (String) PurMat.getToDate());
				    ShowParameter(PurMat);
				    break;

				case "POItemList":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [POItemList](?,?,?,?,?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getPONO());
				    ComVar.myStat.setString(3, (String) PurMat.getFromDate());
				    ComVar.myStat.setString(4, (String) PurMat.getToDate());
				    ComVar.myStat.setString(5, (String) PurMat.getSNo());
				    ComVar.myStat.setString(6, (String) "POItemList");
				    break;	
				case "PODEL":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [PODel](?,?,?,?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getPONO());
				    ComVar.myStat.setString(5, (String) PurMat.getSNo());
				    break;	
				case "PODELITEM":
					ComVar.myStat = ComVar.Conn.prepareCall("{call [PoDelItem](?,?,?)}");
				    ComVar.myStat.setString(1, (String) PurMat.getRwaRegNo());
				    ComVar.myStat.setString(2, (String) PurMat.getPONO());
				    ComVar.myStat.setString(5, (String) PurMat.getSNo());
				    break;	
				}
				System.out.println("step 3.2  parameter pass to sp ");
				ComVar.myStat.execute(); // execute SP
				System.out.print("\nStep 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	);
//				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
				    System.out.println("\n inner loop");
				    int ctr=0;
					while (ComVar.prst.next()) {
						JsonObject InvItem= new JsonObject();
						InvItem.put("PONO",ComVar.prst.getString("PONo"));
						switch (PurMat.ActionType) {
						case "POItemList" :
							InvItem.put("SNo",ComVar.prst.getString("SNO"));
							InvItem.put("ItemCode",ComVar.prst.getString("ItemCode"));
							InvItem.put("ItemName",ComVar.prst.getString("ItemName"));
							InvItem.put("Brand",ComVar.prst.getString("Brand"));
							InvItem.put("Quantity",ComVar.prst.getString("Quantity"));
							InvItem.put("Unit",ComVar.prst.getString("Unit"));
							InvItem.put("Note",ComVar.prst.getString("Note"));

							break;
						default :
							ctr+=1;
							InvItem.put("SNo",Integer.toString(ctr));
							InvItem.put("PODate",ComVar.prst.getString("PODate"));
							InvItem.put("CustomerName",ComVar.prst.getString("CustomerName"));
							InvItem.put("MobileNo",ComVar.prst.getString("MobileNo"));
							InvItem.put("Address",ComVar.prst.getString("Address"));
							InvItem.put("City",ComVar.prst.getString("City"));
							break;
						}
						InvItem.put("SPstatus","1");
						InvoiceDetails.add(InvItem);
					}
					System.out.println("1."+InvoiceDetails);
//					ShowNewWTInfoPassToSP(user);
			    }
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving Owner Information!" + e);
//			user.setSPstatus(3);
//			user.setValid(false);
		} finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return InvoiceDetails;
	}
	public static void ShowParameter(POMISModel POParm) {
		System.out.println("\nRwaNo:" + POParm.getRwaRegNo()+ ", PONo:" + POParm.getPONO()
		+ " ,FDate:" + POParm.getFromDate()+ " ,TDate:" + POParm.getToDate());
	}
	public static JsonArray editPO(POModel TPOModel) {
		System.out.println("Step2: Start of the DAO Action");
	    JsonArray TempPOList=new JsonArray();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [EditPO](?,?,?,?,?,?,?,?,?)}");
			
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
			ShowPOListPassToSP(TPOModel);
			boolean spExecuteStatus = ComVar.myStat.execute();
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst!=null) { 
			    System.out.println("\n inner loop");
				while (ComVar.prst.next()) {
					
					JsonObject TempPo= new JsonObject();
					
					TempPo.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
					TempPo.put("SNo",ComVar.prst.getString("SNO"));
					TempPo.put("PONO",ComVar.prst.getString("PONo"));
					TempPo.put("ItemCode",ComVar.prst.getString("ItemCode"));
					TempPo.put("ItemName",ComVar.prst.getString("ItemName"));
					TempPo.put("Brand",ComVar.prst.getString("Brand"));
					TempPo.put("Quantity",ComVar.prst.getString("Quantity"));
					TempPo.put("Unit",ComVar.prst.getString("Unit"));
					TempPo.put("Note",ComVar.prst.getString("Note"));
					TempPo.put("SPstatus","1");
					
					TempPOList.add(TempPo);
					System.out.println("KN TEmpo OBj:"+TempPo);
					System.out.println("KNR TempPOList :" + TempPOList);
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
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return TempPOList	;
	}
	public static JsonArray poDel(POMISModel POModel  ) {
		JsonArray InvoiceDetails= new JsonArray();
		
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");
				ComVar.myStat = ComVar.Conn.prepareCall("{call [PODel](?,?,?,?,?)}");
				
				ComVar.myStat.setString(1, (String)POModel.getRwaRegNo());
				ComVar.myStat.setString(2, (String)POModel.getUID());
				ComVar.myStat.setString(3, (String)POModel.getPONO());
			    ComVar.myStat.setString(4, (String)POModel.getFromDate());
			    ComVar.myStat.setString(5, (String)POModel.getToDate());
			    ShowPOdelParmPassToSP(POModel);
				System.out.println("step 3.2  parameter pass to sp ");
				ComVar.myStat.execute(); // execute SP
				System.out.print("\nStep 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	);
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
				    System.out.println("\n inner loop");
				    int ctr=0;
					while (ComVar.prst.next()) {
						JsonObject poList= new JsonObject();
						ctr+=1;
						poList.put("PONO",ComVar.prst.getString("PONo"));
						poList.put("SNo",Integer.toString(ctr));
						poList.put("PODate",ComVar.prst.getString("PODate"));
						poList.put("CustomerName",ComVar.prst.getString("CustomerName"));
						poList.put("MobileNo",ComVar.prst.getString("MobileNo"));
						poList.put("Address",ComVar.prst.getString("Address"));
						poList.put("City",ComVar.prst.getString("City"));
						poList.put("SPstatus","1");
						InvoiceDetails.add(poList);
					}
					System.out.println("1."+InvoiceDetails);
			    }
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving Owner Information!" + e);
//			user.setSPstatus(3);
//			user.setValid(false);
		} finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return InvoiceDetails;
	}

	public static JsonArray PODelItem(POMISModel TPOModel) {
		String erMsg="";
		erMsg+="Step2: DAO Action , ";
	    JsonArray TempPOList=new JsonArray();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			erMsg+="Step3: Connection successfully, ";
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [PODelItem](?,?,?,?,?)}");
			
			ComVar.myStat.setString(1, (String)TPOModel.getRwaRegNo());
			ComVar.myStat.setString(2, (String)TPOModel.getUID());
			ComVar.myStat.setString(3, (String)TPOModel.getPONO());
			ComVar.myStat.setString(4, (String)TPOModel.getSNo());
			ComVar.myStat.setString(5, (String)TPOModel.getActionType());
			
			erMsg+="Step3.1: SP PARAM ADDED,";

			erMsg+= "("+TPOModel.getSNo() + " ," +TPOModel.getPONO() + " ," + TPOModel.getUID() + " ," + TPOModel.getRwaRegNo() +")" ;
			ShowPOdelParmPassToSP(TPOModel);
			erMsg+="Step3.2: Dis. param , ";
			boolean spExecuteStatus = ComVar.myStat.execute();
			ComVar.prst=ComVar.myStat.getResultSet();
		    if(ComVar.prst!=null) { 
				erMsg+="Step3.3: RS NOT NULL , ";
				while (ComVar.prst.next()) {
					JsonObject TempPo= new JsonObject();
					
					TempPo.put("RwaRegNo",ComVar.prst.getString("RwaRegNo"));
					TempPo.put("PONO",ComVar.prst.getString("PONo"));
					TempPo.put("SNo",ComVar.prst.getString("SNO"));
					TempPo.put("ItemCode",ComVar.prst.getString("ItemCode"));
					TempPo.put("ItemName",ComVar.prst.getString("ItemName"));
					TempPo.put("Brand",ComVar.prst.getString("Brand"));
					TempPo.put("Quantity",ComVar.prst.getString("Quantity"));
					TempPo.put("Unit",ComVar.prst.getString("Unit"));
					TempPo.put("Note",ComVar.prst.getString("Note"));
					TempPo.put("SPstatus","1");
					
					TempPOList.add(TempPo);
				}
//				ShowAPTOutputInfo(InvoiceDetails);// display output	
//				ShowNewWTInfoPassToSP(user);
		    }
		    erMsg+="Step 3.2:SP Status:(1.Success 2.Duplicate 3.Technical Issues.";
			System.out.println(	erMsg +" \n"	);			
		}catch(Exception e) {
			System.out.println(	erMsg +" \n"	+ e);
		} finally {
			ComVar.disposeConnection(ComVar.Conn,ComVar.myStat,ComVar.prst );
		}
		return TempPOList	;
	}

	
	
	public static void ShowPOListPassToSP(POModel TPOModel) {
		System.out.println("\n-> RwaNo :" + TPOModel.getRwaRegNO()+ ", PONo:" +TPOModel.getPONo()
		+", Item Code:" + TPOModel.getItemCode()	+ " , Item Name :" + TPOModel.getItemName()
		+ ",Brand:" + TPOModel.getBrand() + ",Quantity: " + TPOModel.getQuantity()+" Unit :" + TPOModel.getUnit()	+ ",Note:" +TPOModel.getNote() );
	}
	private static void ShowPOdelParmPassToSP(POMISModel TPOModel) {
		System.out.println("\n-> RwaNo :" + TPOModel.getRwaRegNo()+ ", PONo:" +TPOModel.getPONO()
		+", SNo:" + TPOModel.getSNo()	+ " , Action :" + TPOModel.getActionType()
		+ ",FDate:" + TPOModel.getFromDate() + ", TDate: " + TPOModel.getToDate()+" UID :" + TPOModel.getUID() );
	}
}
