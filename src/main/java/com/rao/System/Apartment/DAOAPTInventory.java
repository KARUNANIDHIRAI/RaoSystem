package com.rao.System.Apartment;

import java.sql.Types;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOAPTInventory {

	public static AptModel CreateNewAPTInfo(AptModel user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateAPTInventory](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4 : Store procedure Patameter setting ");
		
			ComVar.myStat.setString(1, (String) user.getRwaRegNo());
			ComVar.myStat.setString(2, (String) user.getUserID());
			
			ComVar.myStat.setString(3, (String) user.getSubscriptionType());
			ComVar.myStat.setString(4, (String) user.getFlatFixCharge());
			ComVar.myStat.setString(5, (String) user.getAmcCharge());
			ComVar.myStat.setString(6, (String) user.getAuditCharge());
			ComVar.myStat.setString(7, (String) user.getGymCharge());
			ComVar.myStat.setString(8, (String) user.getSwmPoolCharge());
			ComVar.myStat.setString(9, (String) user.getMiscCharge());

			ComVar.myStat.setString(10, (String) user.getValidFrom());
			ComVar.myStat.setString(11, (String) user.getValidTo());

			ComVar.myStat.setString(12, (String) user.getTowerNo());
			ComVar.myStat.setString(13, (String) user.getFlatCategory());
			ComVar.myStat.setString(14, (String) user.getFlatSize());
			ComVar.myStat.setString(15, (String) user.getFlatNoFrom());
			ComVar.myStat.setString(16, (String) user.getFlatNoTo());

			
			
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);
			ComVar.myStat.registerOutParameter(18, Types.INTEGER);
			

			ShowAPTInputInfo(user);
			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(17));// SP status after sp execution
			user.setSPInnerStatus(ComVar.myStat.getInt(18));// SP Inner status during execution

			System.out.print(
					"Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
							+ user.getSPstatus() + " SP INNER Staus:" + user.getSPInnerStatus());
			user.setValid(true);

		} catch (Exception e) {
			System.out.println(
					"Technical error: Unable to create House Keeping Information. Please try after some time. Contact Admin :\n"
							+ e);
			user.setValid(false);
			user.setSPstatus(3);
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
		return user;
	}

	public static AptModel UpdateDwellerInfo(AptModel user) {
		System.out.println("Step 6.Start UpdateDRVInfo DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 7 : create Connection successfully to update data");
			ComVar.myStat = ComVar.Conn.prepareCall(
					"{call [UpdateDwellerInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4 : Store procedure Patameter setting ");

			ComVar.myStat.setString(1, (String) user.getRwaRegNo());
			ComVar.myStat.setString(2, (String) user.getUserID());
			
			ComVar.myStat.setString(3, (String) user.getSubscriptionType());
			ComVar.myStat.setString(4, (String) user.getFlatFixCharge());
			ComVar.myStat.setString(5, (String) user.getAmcCharge());
			ComVar.myStat.setString(6, (String) user.getAuditCharge());
			ComVar.myStat.setString(7, (String) user.getGymCharge());
			ComVar.myStat.setString(8, (String) user.getSwmPoolCharge());
			ComVar.myStat.setString(9, (String) user.getMiscCharge());

			ComVar.myStat.setString(10, (String) user.getValidFrom());
			ComVar.myStat.setString(11, (String) user.getValidTo());

			ComVar.myStat.setString(12, (String) user.getTowerNo());
			ComVar.myStat.setString(13, (String) user.getFlatCategory());
			ComVar.myStat.setString(14, (String) user.getFlatSize());
			ComVar.myStat.setString(15, (String) user.getFlatNoFrom());
			ComVar.myStat.setString(16, (String) user.getFlatNoTo());

			
			
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);
			ComVar.myStat.registerOutParameter(18, Types.INTEGER);

			System.out.println("Step 9 : Data sent for update :");
			ShowAPTInputInfo(user);

			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(17));// store proceure status after sp execution
			System.out.print(
					"Step 10.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
							+ user.getSPstatus() + " SP INNER Staus:" + ComVar.myStat.getInt(18));
			user.setValid(true);

		} catch (Exception e) {
			System.out.println(
					"Technical error: Unable to create OWN INFO Please try after some time. Contact Admin :\n" + e);
			user.setValid(false);
			user.setSPstatus(3);
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
		return user;
	}

	public static AptModel DwellerInfoRetriev(AptModel user) {
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Created Connection successfully to Retrieve Data.");

			switch (user.getTranType()) {
			case "VIEW":

				ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchDWLLERInfo](?,?,?)}");

//				ComVar.myStat.setString(1, (String) user.getEmailId());
				ComVar.myStat.setString(2, (String) user.getRwaRegNo());
//				ComVar.myStat.setString(3, (String) user.getMobileNO());

				ComVar.myStat.execute();
				System.out.print("SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "
						+ user.getSPstatus());
				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
				System.out.println("start loop");
				while (ComVar.prst.next()) {
					System.out.println("start loop 1");
					// user.setUserID(ComVar.prst.getString("UserID"));
					user.setRwaRegNo(ComVar.prst.getString("RwaRegNo"));
					user.setUserID(ComVar.prst.getString("userId"));

					user.setSubscriptionType( ComVar.prst.getString("SubscriptionType"));
					user.setValidFrom(ComVar.prst.getString("ValidFrom"));
					user.setValidTo(ComVar.prst.getString("ValidTo"));
					user.setAuditCharge(ComVar.prst.getString("AuditCharge"));

					if (user.getSubscriptionType().equals("Fixed")) {
						user.setFlatFixCharge(ComVar.prst.getString("inputFlatCharge"));
						user.setAmcCharge(ComVar.prst.getString("inputAMCCharge"));
						user.setMiscCharge(ComVar.prst.getString("inputMiscCharge"));
						user.setGymCharge(ComVar.prst.getString("inputGymCharge"));
						user.setSwmPoolCharge(ComVar.prst.getString("inputSwmPoolCharge"));
					}
					else {
						user.setFlatFixCharge(ComVar.prst.getString("inputFloatCharge"));
						user.setAmcCharge(ComVar.prst.getString("inputAMCFloatCharge"));
						user.setMiscCharge(ComVar.prst.getString("inputMiscFloatCharge"));
						user.setGymCharge(ComVar.prst.getString("inputGymFloatCharge"));
						user.setSwmPoolCharge(ComVar.prst.getString("inputSwmPoolFloatCharge"));

						user.setTowerNo(ComVar.prst.getString("inputTowerNo"));
						user.setFlatCategory(ComVar.prst.getString("inputFlatCategoryNo"));
						user.setFlatSize(ComVar.prst.getString("inputSizeOfFlat"));
						user.setFlatNoFrom(ComVar.prst.getString("inputFltStartNo"));
						user.setFlatNoTo(ComVar.prst.getString("inputFltEndNo"));

					}	
					System.out.println("start loop 8");
					
					
					user.setSPstatus(1);
				}
			case "xp":
				break;
			default:
				user.setValid(true);
				break;
			} // end of Switch Case
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving Owner Information!" + e);
			user.setSPstatus(3);
			user.setValid(false);
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
		return user;
	}

	public static void ShowAPTInputInfo(AptModel user) {
		
		System.out.println("Apartment Inventory Information :" + user.getRwaRegNo() + ", UID:" + user.getUserID()+ ", Apt/Flat Category:" + user.getSubscriptionType());

		System.out.println("RWA Charges:" + user.getFlatFixCharge() + ", AMC Charges:" + user.getAmcCharge()+ ", Audit Charges :" +user.getAuditCharge() 
		+", Gym Charges :" + user.getGymCharge() + ", Swimming Pool Charges:" + user.getSwmPoolCharge() +  ", Miscellaneous :" 	+ user.getMiscCharge() );

		System.out.println("\n Charges Valid From -" + user.getValidFrom() + ", Valid To :" + user.getValidTo() );

		System.out.println("Apartment / Tower No.:" + user.getTowerNo() + ", Flat Category :"+ user.getFlatCategory());

		System.out.println("\nFlat Details - " + " Apartment / Flat Size :" + user.getFlatSize()+ ", Flat No From -" + user.getFlatNoFrom() 
		+ " , Flat No To -" + user.getFlatNoTo() );
	
	}



}
