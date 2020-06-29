package com.rao.System.Apartment;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAOAPTInventory {

	public static AptModel CreateNewAPTInfo(AptModel user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateAPTInventory](?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4 : Store procedure Patameter setting ");
		
			ComVar.myStat.setString(1, (String) user.getRwaRegNo());
			ComVar.myStat.setString(2, (String) user.getUserID());
			
			ComVar.myStat.setString(3, (String) user.getTowerNo());
			ComVar.myStat.setString(4, (String) user.getFlatCategory());
			ComVar.myStat.setString(5, (String) user.getFlatSize());
			ComVar.myStat.setString(6, (String) user.getFlatNoFrom());
			ComVar.myStat.setString(7, (String) user.getFlatNoTo());

			ComVar.myStat.registerOutParameter(8, Types.INTEGER);
			ComVar.myStat.registerOutParameter(9, Types.INTEGER);
			

			ShowAPTInputInfo(user);
			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(8));// SP status after sp execution
			user.setSPInnerStatus(ComVar.myStat.getInt(9));// SP Inner status during execution

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

	public static AptModel CreateNewRWASubscription(AptModel user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateRWASubscription](?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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

			ComVar.myStat.registerOutParameter(12, Types.INTEGER);
			ComVar.myStat.registerOutParameter(13, Types.INTEGER);
			

			ShowRWASubscriptionInputInfo(user);
			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(12));// SP status after sp execution
			user.setSPInnerStatus(ComVar.myStat.getInt(13));// SP Inner status during execution

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

	
	public static AptModel UpdateAPTInventory(AptModel user) {
		System.out.println("Step 4.Start  DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 4.1 : create  DB Connection successfully ");
			ComVar.myStat = ComVar.Conn.prepareCall(
					"{call [UpdateAptInventory](?,?,?,?,?,?,?,?,?)}");

			ComVar.myStat.setString(1, (String) user.getRwaRegNo());
			ComVar.myStat.setString(2, (String) user.getUserID());
			ComVar.myStat.setString(3, (String) user.getTowerNo());
			ComVar.myStat.setString(4, (String) user.getFlatCategory());
			ComVar.myStat.setString(5, (String) user.getFlatSize());
			ComVar.myStat.setString(6, (String) user.getFlatNoFrom());
			ComVar.myStat.setString(7, (String) user.getFlatNoTo());
			ComVar.myStat.registerOutParameter(8, Types.INTEGER);
			ComVar.myStat.registerOutParameter(9, Types.INTEGER);

			System.out.println("Step 4.2 : Data sent to DB for update :");
			ShowAPTInputInfo(user);

			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(8));// store proceure status after sp execution
			System.out.print(
					"Step 5.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
							+ user.getSPstatus() + " SP INNER Staus:" + ComVar.myStat.getInt(9));
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
	public static AptModel UpdateRWASubscription(AptModel user) {
		try {
			System.out.println("Step 3.Start Update RWA Subscription DAO ACTION");
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3.1 : create Connection successfully to update data");
			ComVar.myStat = ComVar.Conn.prepareCall(
					"{call [UpdateRWASubscription](?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ShowRWASubscriptionInputInfo(user);
			System.out.println("Step 3.2 : parameter value pass to [DB] to Update");

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

			
			ComVar.myStat.registerOutParameter(12, Types.INTEGER);
			ComVar.myStat.registerOutParameter(13, Types.INTEGER);
			System.out.println("Step 3.3: SP Patameter setting Successfully");

			ShowAPTInputInfo(user);

			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(12));// store proceure status after sp execution
			System.out.print("Step 3.4: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
							+ user.getSPstatus() + " SP INNER Staus:" + ComVar.myStat.getInt(13));
			user.setValid(true);

		} catch (Exception e) {
			System.out.println("\nStep 3: Technical error: Unable to Update RWA Subscription. Contact to Admin :\n" + e);
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

	public static AptModel  RWASubscriptionRetriev(AptModel user) {
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3.1 Created Connection successfully to Retrieve Data.");

			switch (user.getTranType()) {
			case "VIEW":

				ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchRWASubscription](?,?,?,?)}");

			    ComVar.myStat.setString(1, (String) user.getRwaRegNo());
				ComVar.myStat.setString(2, (String) user.getSubscriptionType());
				ComVar.myStat.setString(3, (String) user.getValidFrom());
				ComVar.myStat.setString(4, (String) user.getValidTo());
				System.out.print("Step 3.2 parameter pass to [SP] - RWA No: "	+ user.getRwaRegNo()+ "Type :"+user.getSubscriptionType() +" ,Valid From : "+user.getValidFrom() + " , Valid To :" +user.getValidTo());

				ComVar.myStat.execute();
				System.out.println("\n Step 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	+ user.getSPstatus());
				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
					while (ComVar.prst.next()) {
						user.setFlatFixCharge(ComVar.prst.getString("FlatFixCharge"));
						user.setAmcCharge(ComVar.prst.getString("AmcCharge"));
						user.setMiscCharge(ComVar.prst.getString("MiscCharge"));
						user.setGymCharge(ComVar.prst.getString("GymCharge"));
						user.setSwmPoolCharge(ComVar.prst.getString("SwmPoolCharge"));
						user.setAuditCharge(ComVar.prst.getString("AuditCharge"));
						user.setSPstatus(1);
					}
			    }
			    else {
		    		System.out.println("\nStep 3.4 Obtained ResultSet object is empty");
		    		user.setSPstatus(0);
			    }
			case "xp":
				break;
			default:
				user.setValid(true);
				break;
			} // end of Switch Case
		} catch (Exception e) {
			System.out.println("\nStep 3.5 Technical error in Retrieving Owner Information!" + e);
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
	
	public static AptModel APTInfoRetriev(AptModel user) {
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");

			switch (user.getTranType()) {
			case "VIEW":

				ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchAPTInfo](?,?,?)}");

			    ComVar.myStat.setString(1, (String) user.getRwaRegNo());
				ComVar.myStat.setString(2, (String) user.getFlatCategory());
				ComVar.myStat.setString(3, (String) user.getTowerNo());

				System.out.println("step 3.2  parameter pass to sp ");
				ShowAPTInputInfo(user);// call function to display parameter pass to sp To retrieve data from DB

				ComVar.myStat.execute(); // execute SP
				System.out.print("\nStep 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	+ user.getSPstatus());

				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
					while (ComVar.prst.next()) {
						System.out.println("start loop 2");
						user.setFlatSize(ComVar.prst.getString("FlatSize"));
						user.setFlatNoFrom(ComVar.prst.getString("FlatNoFrom"));
						user.setFlatNoTo(ComVar.prst.getString("FlatNoTo"));
						user.setSPstatus(1);
						break;
					}
					ShowAPTOutputInfo(user);// display output	
			    }
			    else {
		    		System.out.println("Obtained ResultSet object is empty");
		    		user.setSPstatus(0);
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
		
		System.out.println("APT Inventory Paramter pass to SP: Rwa Reg No." + user.getRwaRegNo() + ", Apt, Category:" 
		+ user.getFlatCategory()+ ", Apt./Tower No.:" + user.getTowerNo() );
		  
	}
	private static void ShowAPTOutputInfo(AptModel user) {
		
		System.out.println("APT Inventory input parameter:  Rwa Reg No." + user.getRwaRegNo() + ", Apt. Category:" 
		+ user.getFlatCategory()+ ", Apt / Tower No.:" + user.getTowerNo() );
	
		System.out.println("APT Inventory Output Paramter:" + user.getFlatSize() + ", Flat No From:" 
		+ user.getFlatNoFrom()+ ", Flat No To :" + user.getFlatNoTo() );

	}

	public static void ShowRWASubscriptionInputInfo(AptModel user) {
		
		System.out.println("APT Inventory:" + user.getRwaRegNo() + ", UID:" + user.getUserID()+ ", Apt/Flat Category:" + user.getSubscriptionType());

		System.out.println("RWA Charges:" + user.getFlatFixCharge() + ", AMC Charges:" + user.getAmcCharge()+ ", Audit Charges :" +user.getAuditCharge() 
		+", Gym Charges :" + user.getGymCharge() + ", Swimming Pool Charges:" + user.getSwmPoolCharge() +  ", Misc. Chrarges :" 	+ user.getMiscCharge() );

		System.out.println("\n Charges Valid From -" + user.getValidFrom() + ", Valid To :" + user.getValidTo() );

	}
	public static void DisplayRWASubscription(DaoRWASubscriptionList user) {
		
		System.out.println("APT Inventory:" + user.getRwaRegNo() + ", UID:" + user.getUserID()+ ", Apt/Flat Category:" + user.getSubscriptionType());

		System.out.println("RWA Charges:" + user.getFlatFixCharge() + ", AMC Charges:" + user.getAmcCharge()+ ", Audit Charges :" +user.getAuditCharge() 
		+", Gym Charges :" + user.getGymCharge() + ", Swimming Pool Charges:" + user.getSwmPoolCharge() +  ", Misc. Chrarges :" 	+ user.getMiscCharge() );

		System.out.println("\n Charges Valid From -" + user.getValidFrom() + ", Valid To :" + user.getValidTo() );

	}

	
	public static ArrayList<AptModel> RwaSubscriptionList() {
		ArrayList<AptModel> RwaSubsList = new ArrayList<AptModel>();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			ComVar.callableStat = ComVar.Conn.prepareCall("{call SearchRWASubscriptionList()}");
			ComVar.callableStat.execute();
			ComVar.prst = ComVar.callableStat.getResultSet();
			if (ComVar.prst != null) {
				while (ComVar.prst.next()) {
					System.out.println("start loop 1");
					AptModel user = new AptModel();
					user.setRwaRegNo(ComVar.prst.getString("RwaRegNo"));
					if(ComVar.prst.getString("SubscriptionType").equals("1")) {
						user.setSubscriptionType("Fixed Charge");
					}else {
						user.setSubscriptionType("Floating Charge (SQFT");
					}
					user.setFlatFixCharge(ComVar.prst.getString("FlatFixCharge"));
					user.setAmcCharge(ComVar.prst.getString("AmcCharge"));
					user.setMiscCharge(ComVar.prst.getString("MiscCharge"));
					user.setGymCharge(ComVar.prst.getString("GymCharge"));
					user.setSwmPoolCharge(ComVar.prst.getString("SwmPoolCharge"));
					user.setAuditCharge(ComVar.prst.getString("AuditCharge"));
					user.setValidFrom(ComVar.prst.getString("ValidFrom"));
					user.setValidTo(ComVar.prst.getString("ValidTo"));
					RwaSubsList.add(user);
				}
				for (AptModel s : RwaSubsList) {
					// Iterates as long as there are elements in the list.
					ShowRWASubscriptionInputInfo(s);
				}
			} else {
				System.out.println("Obtained ResultSet object is empty");
			}
		} catch (SQLException ex) {
			System.out.println("\n ERROR :" + ex);
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
		return RwaSubsList;
	}
	 	
	
	  public static ArrayList<DaoRWASubscriptionList> knRwaSubscriptionList() {
		ArrayList<DaoRWASubscriptionList> RwaSubsList = new ArrayList<DaoRWASubscriptionList>();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			ComVar.callableStat = ComVar.Conn.prepareCall("{call SearchRWASubscriptionList()}");
			ComVar.callableStat.execute();
			ComVar.prst = ComVar.callableStat.getResultSet();
			int count = 0;
			if (ComVar.prst != null) {
				while (ComVar.prst.next()) {
					System.out.println("start loop 1");
					DaoRWASubscriptionList user = new DaoRWASubscriptionList();

					user.setRwaRegNo(ComVar.prst.getString("RwaRegNo"));
					user.setSubscriptionType(ComVar.prst.getString("SubscriptionType"));
					user.setFlatFixCharge(ComVar.prst.getString("FlatFixCharge"));
					user.setAmcCharge(ComVar.prst.getString("AmcCharge"));
					user.setMiscCharge(ComVar.prst.getString("MiscCharge"));
					user.setGymCharge(ComVar.prst.getString("GymCharge"));
					user.setSwmPoolCharge(ComVar.prst.getString("SwmPoolCharge"));
					user.setAuditCharge(ComVar.prst.getString("AuditCharge"));
					user.setValidFrom(ComVar.prst.getString("ValidFrom"));
					user.setValidTo(ComVar.prst.getString("ValidTo"));

					RwaSubsList.add(user);
				}
				for (DaoRWASubscriptionList s : RwaSubsList) {
					// Iterates as long as there are elements in the list.
					DisplayRWASubscription(s);
				}
			} else {
				System.out.println("Obtained ResultSet object is empty");
			}
		} catch (SQLException ex) {
			System.out.println("\n ERROR :" + ex);
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
		return RwaSubsList;
	}
	 
}
