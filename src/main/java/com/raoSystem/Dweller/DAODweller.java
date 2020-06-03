package com.raoSystem.Dweller;

import java.sql.Types;


import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DAODweller {

	public static DwellerModel CreateNewDwellerInfo(DwellerModel user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");

			ComVar.myStat = ComVar.Conn.prepareCall(
					"{call [CreateDwellerInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4 : Store procedure Patameter setting ");

			ComVar.myStat.setString(1, (String) user.getEmailId());
			ComVar.myStat.setString(2, (String) user.getRwaRegNo());
			ComVar.myStat.setString(3, (String) user.getUserID());
			ComVar.myStat.setString(4, (String) user.getFname());
			ComVar.myStat.setString(5, (String) user.getLname());
			ComVar.myStat.setString(6, (String) user.getGender());
			ComVar.myStat.setString(7, (String) user.getMobileNO());
			ComVar.myStat.setString(8, (String) user.getFFName());
			ComVar.myStat.setString(9, (String) user.getFLName());
			ComVar.myStat.setString(10, (String) user.getFMobileNo());

			ComVar.myStat.setString(11, (String) user.getPAddress());
			ComVar.myStat.setString(12, (String) user.getBlockNO());
			ComVar.myStat.setString(13, (String) user.getSector());
			ComVar.myStat.setString(14, (String) user.getCity());
			ComVar.myStat.setString(15, (String) user.getState());
			ComVar.myStat.setString(16, (String) user.getCountry());
			ComVar.myStat.setString(17, (String) user.getZipCode());

			ComVar.myStat.setString(18, (String) user.getTAddress());
			ComVar.myStat.setString(19, (String) user.getTBlockNO());
			ComVar.myStat.setString(20, (String) user.getTSector());
			ComVar.myStat.setString(21, (String) user.getTCity());
			ComVar.myStat.setString(22, (String) user.getTState());
			ComVar.myStat.setString(23, (String) user.getTCountry());
			ComVar.myStat.setString(24, (String) user.getTZipCode());
			
			ComVar.myStat.setString(25, (String) user.getOrgName());
			ComVar.myStat.setString(26, (String) user.getEmployeeNo());
			ComVar.myStat.setString(27, (String) user.getDesignation());
			ComVar.myStat.setString(28, (String) user.getOAdress());
			ComVar.myStat.setString(29, (String) user.getOBlock());
			ComVar.myStat.setString(30, (String) user.getOSector());
			ComVar.myStat.setString(31, (String) user.getOCity());
			ComVar.myStat.setString(32, (String) user.getOState());
			ComVar.myStat.setString(33, (String) user.getOcountry());
			ComVar.myStat.setString(34, (String) user.getOPinCode());

			ComVar.myStat.setString(35, (String) user.getVehcileType1());
			ComVar.myStat.setString(36, (String) user.getVehcileManfacturer1());
			ComVar.myStat.setString(37, (String) user.getVehcileModel1());
			ComVar.myStat.setString(38, (String) user.getVehcileNo1());
			ComVar.myStat.setString(39, (String) user.getVehcileColor1());

			ComVar.myStat.setString(40, (String) user.getVehcileType2());
			ComVar.myStat.setString(41, (String) user.getVehcileManfacturer2());
			ComVar.myStat.setString(42, (String) user.getVehcileModel2());
			ComVar.myStat.setString(43, (String) user.getVehcileNo2());
			ComVar.myStat.setString(44, (String) user.getVehcileColor2());

			ComVar.myStat.setString(45, (String) user.getDrvFname());
			ComVar.myStat.setString(46, (String) user.getDrvLname());
			ComVar.myStat.setString(47, (String) user.getDrvGender());
			ComVar.myStat.setString(48, (String) user.getDrvMobileNO());
			ComVar.myStat.setString(49, (String) user.getDrvAadharNO());
			ComVar.myStat.setString(50, (String) user.getDrvDLNo());

			ComVar.myStat.setString(51, (String) user.getHKMFname());
			ComVar.myStat.setString(52, (String) user.getHKMLname());
			ComVar.myStat.setString(53, (String) user.getHKMGender());
			ComVar.myStat.setString(54, (String) user.getHKMMobileNO());
			ComVar.myStat.setString(55, (String) user.getHKMAadharNO());

			ComVar.myStat.setString(56, (String) user.getShiftIn());
			ComVar.myStat.setString(57, (String) user.getShiftOut());
//			ComVar.myStat.setString(58, (String) user.getOwnFname());
//			ComVar.myStat.setString(59, (String) user.getOwnLname());
			ComVar.myStat.setString(58, (String) user.getOwnEmail());
			ComVar.myStat.setString(59, (String) user.getOwnMobileNO());
			
			
			ComVar.myStat.registerOutParameter(60, Types.INTEGER);
			ComVar.myStat.registerOutParameter(61, Types.INTEGER);

			DAODweller.ShowDwellerUserInputInfo(user);
			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(60));// SP status after sp execution
			user.setSPInnerStatus(ComVar.myStat.getInt(61));// SP Inner status during execution

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

	public static DwellerModel UpdateDwellerInfo(DwellerModel user) {
		System.out.println("Step 6.Start UpdateDRVInfo DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 7 : create Connection successfully to update data");
			ComVar.myStat = ComVar.Conn.prepareCall(
					"{call [UpdateDwellerInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4 : Store procedure Patameter setting ");

			ComVar.myStat.setString(1, (String) user.getEmailId());
			ComVar.myStat.setString(2, (String) user.getRwaRegNo());
			ComVar.myStat.setString(3, (String) user.getUserID());
			ComVar.myStat.setString(4, (String) user.getFname());
			ComVar.myStat.setString(5, (String) user.getLname());
			ComVar.myStat.setString(6, (String) user.getGender());
			ComVar.myStat.setString(7, (String) user.getMobileNO());
			ComVar.myStat.setString(8, (String) user.getFFName());
			ComVar.myStat.setString(9, (String) user.getFLName());
			ComVar.myStat.setString(10, (String) user.getFMobileNo());

			ComVar.myStat.setString(11, (String) user.getPAddress());
			ComVar.myStat.setString(12, (String) user.getBlockNO());
			ComVar.myStat.setString(13, (String) user.getSector());
			ComVar.myStat.setString(14, (String) user.getCity());
			ComVar.myStat.setString(15, (String) user.getState());
			ComVar.myStat.setString(16, (String) user.getCountry());
			ComVar.myStat.setString(17, (String) user.getZipCode());

			ComVar.myStat.setString(18, (String) user.getTAddress());
			ComVar.myStat.setString(19, (String) user.getTBlockNO());
			ComVar.myStat.setString(20, (String) user.getTSector());
			ComVar.myStat.setString(21, (String) user.getTCity());
			ComVar.myStat.setString(22, (String) user.getTState());
			ComVar.myStat.setString(23, (String) user.getTCountry());
			ComVar.myStat.setString(24, (String) user.getTZipCode());
			
			ComVar.myStat.setString(25, (String) user.getOrgName());
			ComVar.myStat.setString(26, (String) user.getEmployeeNo());
			ComVar.myStat.setString(27, (String) user.getDesignation());
			ComVar.myStat.setString(28, (String) user.getOAdress());
			ComVar.myStat.setString(29, (String) user.getOBlock());
			ComVar.myStat.setString(30, (String) user.getOSector());
			ComVar.myStat.setString(31, (String) user.getOCity());
			ComVar.myStat.setString(32, (String) user.getOState());
			ComVar.myStat.setString(33, (String) user.getOcountry());
			ComVar.myStat.setString(34, (String) user.getOPinCode());

			ComVar.myStat.setString(35, (String) user.getVehcileType1());
			ComVar.myStat.setString(36, (String) user.getVehcileManfacturer1());
			ComVar.myStat.setString(37, (String) user.getVehcileModel1());
			ComVar.myStat.setString(38, (String) user.getVehcileNo1());
			ComVar.myStat.setString(39, (String) user.getVehcileColor1());

			ComVar.myStat.setString(40, (String) user.getVehcileType2());
			ComVar.myStat.setString(41, (String) user.getVehcileManfacturer2());
			ComVar.myStat.setString(42, (String) user.getVehcileModel2());
			ComVar.myStat.setString(43, (String) user.getVehcileNo2());
			ComVar.myStat.setString(44, (String) user.getVehcileColor2());

			ComVar.myStat.setString(45, (String) user.getDrvFname());
			ComVar.myStat.setString(46, (String) user.getDrvLname());
			ComVar.myStat.setString(47, (String) user.getDrvGender());
			ComVar.myStat.setString(48, (String) user.getDrvMobileNO());
			ComVar.myStat.setString(49, (String) user.getDrvAadharNO());
			ComVar.myStat.setString(50, (String) user.getDrvDLNo());

			ComVar.myStat.setString(51, (String) user.getHKMFname());
			ComVar.myStat.setString(52, (String) user.getHKMLname());
			ComVar.myStat.setString(53, (String) user.getHKMGender());
			ComVar.myStat.setString(54, (String) user.getHKMMobileNO());
			ComVar.myStat.setString(55, (String) user.getHKMAadharNO());
		
			ComVar.myStat.setString(56, (String) user.getShiftIn());
			ComVar.myStat.setString(57, (String) user.getShiftOut());
//			ComVar.myStat.setString(58, (String) user.getOwnFname());
//			ComVar.myStat.setString(59, (String) user.getOwnLname());
			ComVar.myStat.setString(58, (String) user.getOwnEmail());
			ComVar.myStat.setString(59, (String) user.getOwnMobileNO());
			
			
			ComVar.myStat.registerOutParameter(60, Types.INTEGER);
			ComVar.myStat.registerOutParameter(61, Types.INTEGER);

			System.out.println("Step 9 : Data sent for update :");
			ShowDwellerUserInputInfo(user);

			boolean spExecuteStatus = ComVar.myStat.execute();
			user.setSPstatus(ComVar.myStat.getInt(60));// store proceure status after sp execution
			System.out.print(
					"Step 10.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "
							+ user.getSPstatus() + " SP INNER Staus:" + ComVar.myStat.getInt(61));
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

	public static DwellerModel DwellerInfoRetriev(DwellerModel user) {
		System.out.println("STEP 3 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Created Connection successfully to Retrieve Data.");

			switch (user.getTranType()) {
			case "VIEW":

				ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchDWLLERInfo](?,?,?)}");

				ComVar.myStat.setString(1, (String) user.getEmailId());
				ComVar.myStat.setString(2, (String) user.getRwaRegNo());
				ComVar.myStat.setString(3, (String) user.getMobileNO());

				ComVar.myStat.execute();
				System.out.print("SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "
						+ user.getSPstatus());
				user.setValid(true);
				ComVar.prst = ComVar.myStat.getResultSet();
				System.out.println("start loop");
				while (ComVar.prst.next()) {
					System.out.println("start loop 1");
					// user.setUserID(ComVar.prst.getString("UserID"));
					user.setFname(ComVar.prst.getString("Fname"));
					user.setLname(ComVar.prst.getString("Lname"));
					user.setGender(ComVar.prst.getString("Gender"));
					user.setMobileNO(ComVar.prst.getString("MobileNo"));
					user.setEmailId(ComVar.prst.getString("EmailId"));
					user.setFFName(ComVar.prst.getString("FFName"));
					user.setFLName(ComVar.prst.getString("FLName"));
					user.setFMobileNo(ComVar.prst.getString("FMobileNo"));
					System.out.println("start loop 2");
					// permanent Address
					user.setPAddress(ComVar.prst.getString("PAddress"));
					user.setBlockNO(ComVar.prst.getString("Block"));
					user.setSector(ComVar.prst.getString("Sector"));
					user.setCity(ComVar.prst.getString("City"));
					user.setState(ComVar.prst.getString("State"));
					user.setCountry(ComVar.prst.getString("Country"));
					user.setZipCode(ComVar.prst.getString("ZipCode"));
					System.out.println("start loop 3");
					
					user.setTAddress(ComVar.prst.getString("TAddress"));
					user.setTBlockNO(ComVar.prst.getString("TBlock"));
					user.setTSector(ComVar.prst.getString("TSector"));
					user.setTCity(ComVar.prst.getString("TCity"));
					user.setTState(ComVar.prst.getString("TState"));
					user.setTCountry(ComVar.prst.getString("TCountry"));
					user.setTZipCode(ComVar.prst.getString("TZipCode"));
					System.out.println("start loop 4");

					user.setOrgName(ComVar.prst.getString("OrgName"));
					user.setEmployeeNo(ComVar.prst.getString("EmployeeNo"));
					user.setDesignation(ComVar.prst.getString("Designation"));
					user.setOAdress(ComVar.prst.getString("OAdress"));
					user.setOBlock(ComVar.prst.getString("OBlock"));
					user.setOSector(ComVar.prst.getString("OSector"));
					user.setOCity(ComVar.prst.getString("OCity"));
					user.setOState(ComVar.prst.getString("OState"));
					user.setOcountry(ComVar.prst.getString("Ocountry"));
					user.setOPinCode(ComVar.prst.getString("OPinCode"));
					System.out.println("start loop 5");

					user.setDrvFname(ComVar.prst.getString("drvFname"));
					user.setDrvLname(ComVar.prst.getString("drvLname"));
					user.setDrvGender(ComVar.prst.getString("drvGender"));
					user.setDrvMobileNO(ComVar.prst.getString("drvMobileNo"));
					user.setDrvAadharNO(ComVar.prst.getString("drvAadharNo"));
					user.setDrvDLNo(ComVar.prst.getString("drvDLNo"));
					System.out.println("start loop 6");
	
					user.setHKMFname(ComVar.prst.getString("mFname"));
					user.setHKMLname(ComVar.prst.getString("mLname" ));
					user.setHKMGender(ComVar.prst.getString("mGender"));
					user.setHKMMobileNO(ComVar.prst.getString("mMobileNo"));
					user.setHKMAadharNO(ComVar.prst.getString("mAadharNo"));
					System.out.println("start loop 7");

//					user.setOwnFname(ComVar.prst.getString("OwnFname"));
//					user.setOwnLname(ComVar.prst.getString("OwnLname" ));
					user.setOwnEmail(ComVar.prst.getString("OwnEmailId"));
					user.setOwnMobileNO(ComVar.prst.getString("OwnMobileNo"));
					user.setShiftIn(ComVar.prst.getString("ShiftIn"));
					user.setShiftOut(ComVar.prst.getString("ShiftOut"));
					System.out.println("start loop 8");
					
					
					user.setSPstatus(1);
				}
				System.out.println("Start filling of data for Vehicles");	
				ComVar.myStat.getMoreResults();
				ComVar.prst = ComVar.myStat.getResultSet();
				System.out.println("start loop");
				int counter=0;
				while (ComVar.prst.next()) {
					if (counter==0){
						user.setVehcileType1(ComVar.prst.getString("VehicleType"));
						user.setVehcileManfacturer1(ComVar.prst.getString("Manufacturer"));
						user.setVehcileModel1(ComVar.prst.getString("Model" ));
						user.setVehcileNo1(ComVar.prst.getString("VehicleNo"));
						user.setVehcileColor1(ComVar.prst.getString("VehicleColor"));
						counter+=1;
					}else{
						user.setVehcileType2(ComVar.prst.getString("VehicleType"));
						user.setVehcileManfacturer2(ComVar.prst.getString("Manufacturer"));
						user.setVehcileModel2(ComVar.prst.getString("Model" ));
						user.setVehcileNo2(ComVar.prst.getString("VehicleNo"));
						user.setVehcileColor2(ComVar.prst.getString("VehicleColor"));
					}
					user.setSPstatus(1);
				}
				System.out.println("end filling of data for Vehicles");	
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

	public static void ShowDwellerUserInputInfo(DwellerModel user) {

		System.out.println("Personal Information -RWA :" + user.getRwaRegNo() + ", UID:" + user.getUserID()
				+ ", FNAME :" + user.getFname() + ", LAST NAME:" + user.getLname() + ", GENDER:" + user.getGender());
		System.out.println("\n EMAIL:" + user.getEmailId() + ", MOBILE :" + user.getMobileNO());
		System.out.println("\n FFNAME:" + user.getFFName() + ", FLNAME:" + user.getFLName() + ", FMobileNo:"
				+ user.getFMobileNo() + ", ShiftIn :"+ user.getShiftIn()+ " , ShiftOut :" + user.getShiftOut());

		System.out.println("\nOwners Detiails - " + ", Email -" + user.getOwnEmail() + " , Mobile-" + user.getOwnMobileNO() );
		
		
		System.out.println("\n Address -" + user.getPAddress() + " :" + user.getBlockNO() + " :"
				+ user.getSector() + " :" + user.getCity() + " :" + user.getState() + " :" + user.getCountry() + " :"
				+ user.getZipCode());
		
		System.out.println("\n Permanent Address -" + user.getTAddress() + " :" + user.getTBlockNO() + " :"
				+ user.getTSector() + " :" + user.getTCity() + " :" + user.getTState() + " :" + user.getTCountry() + " :"
				+ user.getTZipCode());

		System.out.println("\nOrganization Detiails -  Name -" + user.getOrgName() + ", EmpNO -" + user.getEmployeeNo()
				+ ", Designation -" + user.getDesignation() + " Address -" + user.getOAdress() + ", Block :"
				+ user.getOBlock() + ", Sector -" + user.getOSector() + ", City-" + user.getOCity() + ",  State -"
				+ user.getOState() + ",Country -" + user.getOcountry() + ", Pin code-" + user.getOPinCode());
		
		System.out.println("\nDriver Detiails -  Name -" + user.getDrvFname() + " " + user.getDrvLname()
		+ ", Gender -" + user.getDrvGender() + " , Mobile No.-" + user.getDrvMobileNO() + ", Aadhar No :"
		+ user.getDrvAadharNO() + ", DLNO -" + user.getDrvDLNo() );

		System.out.println("\nMaid Detiails -  Name -" + user.getHKMFname() + " " + user.getHKMLname()
		+ ", Gender -" + user.getHKMGender() + " , Mobile No.-" + user.getHKMMobileNO() + ", Aadhar No :"
		+ user.getHKMAadharNO());

		System.out.println("\nVehicle 1 Detiails -  Type -" + user.getVehcileType1() + " Manufacture -" + user.getVehcileManfacturer1()
		+ ", Number -" + user.getVehcileNo1() + " , Model-" + user.getVehcileModel1() + ", Color :"	+user.getVehcileColor1());

		System.out.println("\nVehicle 2 Detiails -  Type -" + user.getVehcileType2() + " Manufacture -" + user.getVehcileManfacturer2()
		+ ", Number -" + user.getVehcileNo2() + " , Model-" + user.getVehcileModel2() + ", Color :"	+user.getVehcileColor2());

	
	}
		
}
