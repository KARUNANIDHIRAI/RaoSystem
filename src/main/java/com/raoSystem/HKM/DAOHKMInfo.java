package com.raoSystem.HKM;

import java.sql.Types;
import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;
public class DAOHKMInfo {

	public static HKMModel CreateNewHKMInfo(HKMModel user) {
		System.out.println("Step2 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
	
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateHKMInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 4 : Store procedure Patameter setting ");
					
				ComVar.myStat.setString(1, (String) user.getEmailId());
				ComVar.myStat.setString(2, (String) user.getRwaRegNo());
		        ComVar.myStat.setString(3, (String) user.getUserID());
		        ComVar.myStat.setString(4, (String) user.getFname());
		        ComVar.myStat.setString(5, (String) user.getLname());
		        ComVar.myStat.setString(6, (String) user.getGender());
		        ComVar.myStat.setString(7, (String) user.getDOB());
		        ComVar.myStat.setString(8, (String) user.getMobileNO());
		        ComVar.myStat.setString(9, (String) user.getAadharNO());
		        ComVar.myStat.setString(10, (String) user.getPanCardNo());
		        ComVar.myStat.setString(11, (String) user.getFFName());
		        ComVar.myStat.setString(12, (String) user.getFLName());
		        ComVar.myStat.setString(13, (String) user.getFGender());
		        ComVar.myStat.setString(14, (String) user.getFMobileNO());
		        ComVar.myStat.setString(15, (String) user.getFEmailId());
		        ComVar.myStat.setString(16, (String) user.getFAadharNO());
	
		        ComVar.myStat.setString(17, (String) user.getPAddress());
		    	ComVar.myStat.setString(18, (String) user.getBlockNO());
		    	ComVar.myStat.setString(19, (String) user.getSector());
		    	ComVar.myStat.setString(20, (String) user.getCity());
		    	ComVar.myStat.setString(21, (String) user.getState());
		    	ComVar.myStat.setString(22, (String) user.getCountry());
		    	ComVar.myStat.setString(23, (String) user.getZipCode());
	
		    	ComVar.myStat.setString(24, (String) user.getCAddress());
		        ComVar.myStat.setString(25, (String) user.getCBlock());
		        ComVar.myStat.setString(26, (String) user.getCSector());
		        ComVar.myStat.setString(27, (String) user.getCCity());
		        ComVar.myStat.setString(28, (String) user.getCState());
		        ComVar.myStat.setString(29, (String) user.getCCountry());
		        ComVar.myStat.setString(30, (String) user.getCZipCode()); 
	
				ComVar.myStat.setString(31, (String) user.getOrgName());
				ComVar.myStat.setString(32, (String) user.getEmployeeNo());
				ComVar.myStat.setString(33, (String) user.getDesignation());
				ComVar.myStat.setString(34, (String) user.getDOJ());
				ComVar.myStat.setString(35, (String) user.getDOR());
				ComVar.myStat.setString(36, (String) user.getReportingOfficer());
				ComVar.myStat.setString(37, (String) user.getOEmailID());
				ComVar.myStat.setString(38, (String) user.getOAdress());
				ComVar.myStat.setString(39, (String) user.getOBlock());
				ComVar.myStat.setString(40, (String) user.getOSector());
				ComVar.myStat.setString(41, (String) user.getOCity());
				ComVar.myStat.setString(42, (String) user.getOState());
				ComVar.myStat.setString(43, (String) user.getOcountry());
				ComVar.myStat.setString(44, (String) user.getOPinCode());		        
				ComVar.myStat.registerOutParameter(45, Types.INTEGER);
				ComVar.myStat.registerOutParameter(46, Types.INTEGER);

				DAOHKMInfo.ShowHKMUserInputInfo(user);
				boolean spExecuteStatus=ComVar.myStat.execute();
		        user.setSPstatus(ComVar.myStat.getInt(45));// SP status after sp execution
		        user.setSPInnerStatus(ComVar.myStat.getInt(46));// SP Inner status during execution 
		        
		        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus() +" SP INNER Staus:"+user.getSPInnerStatus());
		        user.setValid(true);
	
		} catch (Exception e) {
			System.out.println("Technical error: Unable to create House Keeping Information. Please try after some time. Contact Admin :\n" + e);
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

	public static HKMModel UpdateHKMInfo(HKMModel user) {
		System.out.println("Step 6.Start UpdateDRVInfo DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 7 : create Connection successfully to update data");
			ComVar.myStat = ComVar.Conn.prepareCall("{call [UpdateHKMInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Step 8 : Store procedure Patameter setting ");
					
			ComVar.myStat.setString(1, (String) user.getEmailId());
			ComVar.myStat.setString(2, (String) user.getRwaRegNo());
	        ComVar.myStat.setString(3, (String) user.getUserID());
	        ComVar.myStat.setString(4, (String) user.getFname());
	        ComVar.myStat.setString(5, (String) user.getLname());
	        ComVar.myStat.setString(6, (String) user.getGender());
	        ComVar.myStat.setString(7, (String) user.getDOB());
	        ComVar.myStat.setString(8, (String) user.getMobileNO());
	        ComVar.myStat.setString(9, (String) user.getAadharNO());
	        ComVar.myStat.setString(10, (String) user.getPanCardNo());
	        ComVar.myStat.setString(11, (String) user.getFFName());
	        ComVar.myStat.setString(12, (String) user.getFLName());
	        ComVar.myStat.setString(13, (String) user.getFGender());
	        ComVar.myStat.setString(14, (String) user.getFMobileNO());
	        ComVar.myStat.setString(15, (String) user.getFEmailId());
	        ComVar.myStat.setString(16, (String) user.getFAadharNO());
	        
	        ComVar.myStat.setString(17, (String) user.getPAddress());
	    	ComVar.myStat.setString(18, (String) user.getBlockNO());
	    	ComVar.myStat.setString(19, (String) user.getSector());
	    	ComVar.myStat.setString(20, (String) user.getCity());
	    	ComVar.myStat.setString(21, (String) user.getState());
	    	ComVar.myStat.setString(22, (String) user.getCountry());
	    	ComVar.myStat.setString(23, (String) user.getZipCode());

	    	ComVar.myStat.setString(24, (String) user.getCAddress());
	        ComVar.myStat.setString(25, (String) user.getCBlock());
	        ComVar.myStat.setString(26, (String) user.getCSector());
	        ComVar.myStat.setString(27, (String) user.getCCity());
	        ComVar.myStat.setString(28, (String) user.getCState());
	        ComVar.myStat.setString(29, (String) user.getCCountry());
	        ComVar.myStat.setString(30, (String) user.getCZipCode()); 

			ComVar.myStat.setString(31, (String) user.getOrgName());
			ComVar.myStat.setString(32, (String) user.getEmployeeNo());
			ComVar.myStat.setString(33, (String) user.getDesignation());
			ComVar.myStat.setString(34, (String) user.getDOJ());
			ComVar.myStat.setString(35, (String) user.getDOR());
			ComVar.myStat.setString(36, (String) user.getReportingOfficer());
			ComVar.myStat.setString(37, (String) user.getOEmailID());
			ComVar.myStat.setString(38, (String) user.getOAdress());
			ComVar.myStat.setString(39, (String) user.getOBlock());
			ComVar.myStat.setString(40, (String) user.getOSector());
			ComVar.myStat.setString(41, (String) user.getOCity());
			ComVar.myStat.setString(42, (String) user.getOState());
			ComVar.myStat.setString(43, (String) user.getOcountry());
			ComVar.myStat.setString(44, (String) user.getOPinCode());		        
			ComVar.myStat.registerOutParameter(45, Types.INTEGER);
			ComVar.myStat.registerOutParameter(46, Types.INTEGER);
			
			
			System.out.println("Step 9 : Data sent for update :");
			ShowHKMUserInputInfo(user);

			boolean spExecuteStatus=ComVar.myStat.execute();
	        user.setSPstatus(ComVar.myStat.getInt(45));// store proceure status after sp execution
	        System.out.print("Step 10.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus() +" SP INNER Staus:"+ComVar.myStat.getInt(46));
	        user.setValid(true);

		} catch (Exception e) {
			System.out.println("Technical error: Unable to create HKM INFO Please try after some time. Contact Admin :\n" + e);
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

	public static HKMModel HKMInfoRetriev(HKMModel user) {
		System.out.println("STEP 2 Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Created Connection successfully to Retrieve Data.");
	
			switch(user.getTranType()){
			case "VIEW" :
	
				ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchHKMInfo](?,?,?,?)}");
	
				ComVar.myStat.setString(1, (String)user.getEmailId());
				ComVar.myStat.setString(2, (String)user.getRwaRegNo());
				ComVar.myStat.setString(3, (String)user.getAadharNO());	
				ComVar.myStat.setString(4, (String)user.getMobileNO());	
				
				
				ComVar.myStat.execute();
		        System.out.print("SP Status Code:(1.Success 2.Duplicate  3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
		        user.setValid(true);
		        ComVar.prst = ComVar.myStat.getResultSet();
		    	
		        while(ComVar.prst.next()){
		        	//user.setUserID(ComVar.prst.getString("UserID"));
			        user.setFname(ComVar.prst.getString("Fname"));
			        user.setLname(ComVar.prst.getString("Lname"));
			        user.setGender(ComVar.prst.getString("Gender"));
			        user.setDOB(ComVar.prst.getString("DOB"));
			        user.setMobileNO(ComVar.prst.getString("MobileNo"));
			        user.setEmailId(ComVar.prst.getString("EmailId"));
			        user.setAadharNO(ComVar.prst.getString("AadharNo"));
			        user.setPanCardNo(ComVar.prst.getString("PanCardNo"));
			        user.setFFName(ComVar.prst.getString("FFName"));
			        user.setFLName(ComVar.prst.getString("FLName"));
			        user.setFGender(ComVar.prst.getString("FGender"));
			        user.setFMobileNO(ComVar.prst.getString("FMobileNo"));
			        user.setFEmailId(ComVar.prst.getString("FEmailId"));
			        user.setFAadharNO(ComVar.prst.getString("FAadharNo"));
			        // permanent Address    
			        user.setPAddress(ComVar.prst.getString("PAddress"));
			    	user.setBlockNO(ComVar.prst.getString("Block"));
			    	user.setSector(ComVar.prst.getString("Sector"));
			    	user.setCity(ComVar.prst.getString("City"));
			    	user.setState(ComVar.prst.getString("State"));
			    	user.setCountry(ComVar.prst.getString("Country"));
			    	user.setZipCode(ComVar.prst.getString("ZipCode"));
			    	//sspc Address
			        user.setCAddress(ComVar.prst.getString("CAddress"));
			        user.setCBlock(ComVar.prst.getString("CBlock"));
			        user.setCSector(ComVar.prst.getString("CSector"));
			        user.setCCity(ComVar.prst.getString("CCity"));
			        System.out.println("\n CCity ;"+user.getCCity());
			        user.setCState(ComVar.prst.getString("CState"));
			        user.setCCountry(ComVar.prst.getString("CCountry"));
			        user.setCZipCode(ComVar.prst.getString("CZipCode")); 
			    	// ssp dl details
			    	
					user.setOrgName(ComVar.prst.getString("OrgName"));
					user.setEmployeeNo(ComVar.prst.getString("EmployeeNo"));
					user.setDesignation(ComVar.prst.getString("Designation"));
					user.setDOJ(ComVar.prst.getString("DOJ"));
					user.setDOR(ComVar.prst.getString("DOR"));
					user.setReportingOfficer(ComVar.prst.getString("ReportingOfficer"));
					user.setOEmailID(ComVar.prst.getString("OEmailID"));
					user.setOAdress(ComVar.prst.getString("OAdress"));
					user.setOBlock(ComVar.prst.getString("OBlock"));
					user.setOSector(ComVar.prst.getString("OSector"));
					user.setOCity(ComVar.prst.getString("OCity"));
					user.setOState(ComVar.prst.getString("OState"));
					user.setOcountry(ComVar.prst.getString("Ocountry"));
					user.setOPinCode(ComVar.prst.getString("OPinCode"));		        
		        	user.setSPstatus(1);
		        	System.out.println("\nSP Status: inner loop "+user.getSPstatus() );
			    } 
		        break;
			case "xp":
				break;
			default:	
		        user.setValid(true);
		        break;
			} // end of Switch Case
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving HKM Information!" + e);
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
	
	
	public static void ShowHKMUserInputInfo(HKMModel user) {
		
		  System.out.println("Personal Information -RWA :" +user.getRwaRegNo()+ ", UID:" +user.getUserID() +
		  ", FNAME :" +user.getFname()+ ", LAST NAME:" +user.getLname() + ", GENDER:" +user.getGender()); System.out.println("DOB :"+user.getDOB()
		  + ", PAN CARD:"  +user.getPanCardNo()+", EMAIL:"+user.getEmailId() + ", MOBILE :"  +user.getMobileNO()+ " , AADHAR NO :" +user.getAadharNO());
		  System.out.println(" FFNAME:" +user.getFFName()+ ", FLNAME:"  +user.getFLName()+ ", FGENDER:" +user.getFGender()+ ", FEMAIL :"
		  +user.getFEmailId()+", FMOBILE:"+user.getFMobileNO()+ " :" + ", FFAADHAR NO:"	  +user.getFAadharNO());

		  System.out.println("Permanent Address -" +user.getPAddress()+ " :" +user.getBlockNO()+ " :" +user.getSector()+ " :" +user.getCity()+ " :" +user.getState()
			+ " :" +user.getCountry()+ " :" +user.getZipCode());
		

			System.out.println("Correspondance Address -"+user.getCAddress()+ " :" +user.getCBlock()+ " :" +user.getCSector()+ " :" +user.getCCity()+ " :" +user.getCState()+ " :" 
			+user.getCCountry()	+ " :" +user.getCZipCode());
		
			System.out.println("Organization Detiails -  Name -" + user.getOrgName()+ ", EmpNO -" +user.getEmployeeNo() + ", Designation -" +user.getDesignation()
			+ ", joining Dt.-" +user.getDOJ() + ", Releaving Dt.- :" +user.getDOR()	+ ", Reporting to -:" +user.getReportingOfficer()+ ", Email - " 
			+user.getOEmailID() + " Address -" 	+user.getOAdress()    + ", Block :" +user.getOBlock()+ ", Sector -"	+user.getOSector()+ ", City-" 
			+user.getOCity()+ ",  State -" +user.getOState() + ",Country -" +user.getOcountry()+ ", Pin code-" +user.getOPinCode());

	}

}

