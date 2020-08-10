package com.rao.System.WaterTankerEntry;

import java.sql.Types;
import java.util.ArrayList;

import com.rao.System.Apartment.AptModel;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public  class DAOWaterTankerDetails {
	
	public static ArrayList<TankerModel> WaterTankerInfoRetriev(TankerModel user) {
		System.out.println("STEP 3 Start DAO ACTION");
		ArrayList<TankerModel> TankerList= new ArrayList<>();
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");
			System.out.println("step 3.1.1 "+ user.getTranType());
			switch (user.getTranType()) {
			case "VIEW":
				System.out.println("step 3.1.2 Created Connection successfully to Retrieve Data.");

				ComVar.myStat = ComVar.Conn.prepareCall("{call [ViewWaterTankerInfo](?,?,?)}");

			    ComVar.myStat.setString(1, (String) user.getRwaRegNo());
				ComVar.myStat.setString(2, (String) user.getTankerNo());
				ComVar.myStat.setString(3, (String) user.getTankerArrivalDateFrom());

				System.out.println("step 3.2  parameter pass to sp ");
				ViewWaterTankerInput(user);// call function to display parameter pass to sp To retrieve data from DB

				ComVar.myStat.execute(); // execute SP
				System.out.print("\nStep 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	+ user.getSPstatus());
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
			    	int counter=1;
					System.out.println("\n start loop 2");
					while (ComVar.prst.next()) {
						TankerModel TankerData= new TankerModel();
//						TankerData.setTankerId(Integer.toString(counter));
						TankerData.setTankerId(ComVar.prst.getString("IDNO"));
						System.out.println(TankerData.getTankerId());
						
						TankerData.setRwaRegNo(ComVar.prst.getString("RwaRegNo"));
						TankerData.setWaterTankNo(ComVar.prst.getString("WaterTankNo"));
						TankerData.setWaterSupplier(ComVar.prst.getString("WaterSupplier"));
						TankerData.setTankerCapacity(ComVar.prst.getString("TankerCapacity"));
						TankerData.setDriverName(ComVar.prst.getString("DriverName"));
						TankerData.setDLNO(ComVar.prst.getString("DLNO"));
						TankerData.setDrvMobilNo(ComVar.prst.getString("DrvMobilNo"));
						TankerData.setTankerArrivalDateFrom(ComVar.prst.getString("TankerArrivalOn"));
						TankerData.setVerifiedByTankerIn(ComVar.prst.getString("VerifiedByTankerIn"));
						TankerData.setTankerInTime(ComVar.prst.getString("TankerInTime"));
						TankerData.setVerifiedByTankerOut(ComVar.prst.getString("VerifiedByTankerOut"));
						TankerData.setTankerOutTime(ComVar.prst.getString("TankerOutTime"));
						TankerData.setWaterLevelIn(ComVar.prst.getString("WaterLevelIn"));
						TankerData.setWaterLevelOut(ComVar.prst.getString("WaterLevelOut"));
						TankerData.setTankerNo(ComVar.prst.getString("TankerNo"));
						TankerList.add(TankerData);
						TankerData.setSPstatus(1);
						counter+=1;
					}
			    }
			    else {
		    		System.out.println("Obtained ResultSet object is empty");
			    }
			case "xp":
				break;
			default:
				break;
			} // end of Switch Case
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving Water Tanker Info Information!" + e);
			TankerModel TankerData= new TankerModel();
			TankerData.setSPstatus(3); // no data found in the table
			TankerList.add(TankerData);
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
		return TankerList;
	}
	public static void ShowWaterTankerSearchInput(TankerModel user) {
		
		System.out.println("Paramter pass to SP: RWA No." + user.getRwaRegNo() + ", Tanker No:" +
		user.getTankerNo()+ ", Date From:" + user.getTankerArrivalDateFrom()+ ", Date To:" + user.getTankerArrivalDateTo() );
		  
	}
	public static void ViewWaterTankerInput(TankerModel user) {
		
		System.out.println("Paramter pass to SP: RWA No." + user.getRwaRegNo() + ", Tanker No:" +
		user.getTankerNo()+ ", Date From:" + user.getTankerArrivalDateFrom());
		  
	}
	
	public static TankerModel CreateWaterTankerInfo(TankerModel user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateWaterTankerInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ComVar.myStat.setString(1, (String)  user.getTankerId());
			ComVar.myStat.setString(2, (String)  user.getRwaRegNo());
			ComVar.myStat.setString(3, (String)  user.getWaterTankNo());
			ComVar.myStat.setString(4, (String)  user.getWaterSupplier());
			ComVar.myStat.setString(5, (String)  user.getTankerCapacity());
			ComVar.myStat.setString(6, (String)  user.getDriverName());
			ComVar.myStat.setString(7, (String)  user.getDLNO());
			ComVar.myStat.setString(8, (String)  user.getDrvMobilNo());
			ComVar.myStat.setString(9, (String)  user.getTankerArrivalDateFrom());
			ComVar.myStat.setString(10, (String)  user.getVerifiedByTankerIn());
			ComVar.myStat.setString(11, (String) user.getWaterLevelIn());
			ComVar.myStat.setString(12, (String) user.getTankerInTime());
			ComVar.myStat.setString(13, (String) user.getVerifiedByTankerOut());
			ComVar.myStat.setString(14, (String) user.getWaterLevelOut());
			ComVar.myStat.setString(15, (String) user.getTankerNo());
			ComVar.myStat.setString(16, (String) user.getUserId());

			
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);
			ComVar.myStat.registerOutParameter(18, Types.INTEGER);


			ShowNewWTInfoPassToSP(user);
			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(17));// SP status after sp execution
			user.setSPInnerStatus(ComVar.myStat.getInt(18));// SP Inner status during execution

			System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
							+ user.getSPstatus() + " SP INNER Staus:" + user.getSPInnerStatus());
			user.setValid(true);

		} catch (Exception e) {
			System.out.println(
					"Technical error: Unable to create Tanker Information. Please  Contact Admin :\n"	+ e);
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

	
	public static ArrayList<TankerModel> WaterTankSupplyList(TankerModel user  ) {
		ArrayList<TankerModel> WaterTanker= new ArrayList<>();
		
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("step 3.1 Created Connection successfully to Retrieve Data.");


				ComVar.myStat = ComVar.Conn.prepareCall("{call [WaterTankerInfo](?,?,?,?)}");

			    ComVar.myStat.setString(1, (String) user.getRwaRegNo());
			    ComVar.myStat.setString(2, (String) user.getTankerNo());
				ComVar.myStat.setString(3, (String) user.getTankerArrivalDateFrom());
				ComVar.myStat.setString(4, (String) user.getTankerArrivalDateTo());

				System.out.println("step 3.2  parameter pass to sp ");
				ShowWaterTankerSearchInput(user);// call function to display parameter pass to sp To retrieve data from DB

				ComVar.myStat.execute(); // execute SP
				System.out.print("\nStep 3.3 SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "	+ user.getSPstatus());
				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
			    if(ComVar.prst!=null) { 
					while (ComVar.prst.next()) {
						TankerModel TankerDetail= new TankerModel();
						
						TankerDetail.setRwaRegNo(ComVar.prst.getString("RwaRegNo"));
						TankerDetail.setWaterTankNo(ComVar.prst.getString("WaterTankNo"));
						TankerDetail.setWaterSupplier(ComVar.prst.getString("WaterSupplier"));
						TankerDetail.setTankerCapacity(ComVar.prst.getString("TankerCapacity"));
						TankerDetail.setDriverName(ComVar.prst.getString("DriverName"));
						TankerDetail.setDLNO(ComVar.prst.getString("DLNO"));
						TankerDetail.setDrvMobilNo(ComVar.prst.getString("DrvMobilNo"));
						TankerDetail.setTankerArrivalDateFrom(ComVar.prst.getString("TankerArrivalOn"));
						TankerDetail.setVerifiedByTankerIn(ComVar.prst.getString("VerifiedByTankerIn"));
						TankerDetail.setTankerInTime(ComVar.prst.getString("TankerInTime"));
						TankerDetail.setVerifiedByTankerOut(ComVar.prst.getString("VerifiedByTankerOut"));
						TankerDetail.setTankerOutTime(ComVar.prst.getString("TankerOutTime"));
						TankerDetail.setWaterLevelIn(ComVar.prst.getString("WaterLevelIn"));
						TankerDetail.setWaterLevelOut(ComVar.prst.getString("WaterLevelOut"));
						TankerDetail.setTankerNo(ComVar.prst.getString("TankerNo"));
						TankerDetail.setSPstatus(1);

						WaterTanker.add(TankerDetail);
					}
//					ShowAPTOutputInfo(user);// display output	
//					ShowNewWTInfoPassToSP(user);
			    }
			    
			    
			    else {
		    		System.out.println("Obtained ResultSet object is empty");
		    		user.setSPstatus(0);
			    }
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
		return WaterTanker;
	}
	public static void ShowNewWTInfoPassToSP(TankerModel user) {
		System.out.println("\nWater Tanker Information-> IDNO :" + user.getTankerId()+", Rwa No:" + user.getRwaRegNo() + " , Water Tank :" + user.getWaterTankNo()
		+ ",Supplier Name:" + user.getWaterSupplier() + ",Tanker Capacity: " + user.getTankerCapacity()+" Driver Name :" + user.getDriverName() 
		+ ",DLNo:" +user.getDLNO() + " ,Driver Mobile No:" + user.getDrvMobilNo() +",Arrival Date:" + user.getTankerArrivalDateFrom());
		System.out.println("Verified By Tanker In: " + user.getVerifiedByTankerIn() + " ,In Time:" + user.getTankerInTime()
		+ ", Tanker Out Time:" +user.getVerifiedByTankerOut() + ",Out Time:" + user.getTankerOutTime() +". Water Level In :" + user.getWaterLevelIn()
		+ ",Water Level Out:" + user.getWaterLevelOut() +", Tanker Number :" + user.getTankerNo());
		
	}
	public static TankerModel UpdateWaterTankerInfo(TankerModel user) {
		System.out.println("Step 4.Start  DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 4.1 : create  DB Connection successfully ");
			ComVar.myStat = ComVar.Conn.prepareCall("{call [UpdateWaterTankerInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4.2 : Store procedure Patameter setting ");
			ComVar.myStat.setString(1, (String)  user.getTankerId());
			ComVar.myStat.setString(2, (String)  user.getRwaRegNo());
			ComVar.myStat.setString(3, (String)  user.getWaterTankNo());
			ComVar.myStat.setString(4, (String)  user.getWaterSupplier());
			ComVar.myStat.setString(5, (String)  user.getTankerCapacity());
			ComVar.myStat.setString(6, (String)  user.getDriverName());
			ComVar.myStat.setString(7, (String)  user.getDLNO());
			ComVar.myStat.setString(8, (String)  user.getDrvMobilNo());
			ComVar.myStat.setString(9, (String)  user.getTankerArrivalDateFrom());
			ComVar.myStat.setString(10, (String)  user.getVerifiedByTankerIn());
			ComVar.myStat.setString(11, (String) user.getWaterLevelIn());
			ComVar.myStat.setString(12, (String) user.getTankerInTime());
			ComVar.myStat.setString(13, (String) user.getVerifiedByTankerOut());
			ComVar.myStat.setString(14, (String) user.getWaterLevelOut());
			ComVar.myStat.setString(15, (String) user.getTankerNo());
			ComVar.myStat.setString(16, (String) user.getUserId());

			
			ComVar.myStat.registerOutParameter(17, Types.INTEGER);
			ComVar.myStat.registerOutParameter(18, Types.INTEGER);

			System.out.println("Step 4.3 : Data sent to DB for update :");
			ShowNewWTInfoPassToSP(user);

			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(17));// store proceure status after sp execution
			System.out.print(
					"Step 5.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
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
	
}



