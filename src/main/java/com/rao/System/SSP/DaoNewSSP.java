package com.rao.System.SSP;

import java.sql.Types;

import com.raoSystem.constants.ComVar;
import com.raoSystem.daoConnection.ConnectionManager;

public class DaoNewSSP {
	public static SSPModel CreateNewSSPInfo(SSPModel user) {
		System.out.println("Step2 Start DAO ACTION");

		try {
	
			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
			System.out.println("Step 4 : Store procedure Patameter setting ");
	
			System.out.println("Step 4 : Store procedure Patameter setting ");
			ComVar.myStat = ComVar.Conn.prepareCall("{call [CreateSSPInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
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
	
		    	ComVar.myStat.setString(31, (String) user.getArmsNo()); 
		    	ComVar.myStat.setString(32, (String) user.getArmsType()); 
		    	ComVar.myStat.setString(33, (String) user.getArmsMadeFromCity()); 
		    	ComVar.myStat.setString(34, (String) user.getArmsPurchaseFrom()); 
		    	ComVar.myStat.setString(35, (String) user.getArmsPurchaseYear()); 
		    	ComVar.myStat.setString(36, (String) user.getArmsIssuedInName()); 	
		    	
		        ComVar.myStat.setString(37, (String) user.getDLNO());
		        ComVar.myStat.setString(38, (String) user.getDLIssuefromCity());
		        ComVar.myStat.setString(39, (String) user.getDLIssueDate());
		        ComVar.myStat.setString(40, (String) user.getDLExpiryDate());
	
				ComVar.myStat.setString(41, (String) user.getOrgName());
				ComVar.myStat.setString(42, (String) user.getEmployeeNo());
				ComVar.myStat.setString(43, (String) user.getDesignation());
				ComVar.myStat.setString(44, (String) user.getDOJ());
				ComVar.myStat.setString(45, (String) user.getDOR());
				ComVar.myStat.setString(46, (String) user.getReportingOfficer());
				ComVar.myStat.setString(47, (String) user.getOEmailID());
				ComVar.myStat.setString(48, (String) user.getOAdress());
				ComVar.myStat.setString(49, (String) user.getOBlock());
				ComVar.myStat.setString(50, (String) user.getOSector());
				ComVar.myStat.setString(51, (String) user.getOCity());
				ComVar.myStat.setString(52, (String) user.getOState());
				ComVar.myStat.setString(53, (String) user.getOcountry());
				ComVar.myStat.setString(54, (String) user.getOPinCode());		        
				ComVar.myStat.registerOutParameter(55, Types.INTEGER);			

				/*
				 * ComVar.myStat.setString(56, (String) user.getDLIRTOAddress());
				 * ComVar.myStat.setString(57, (String) user.getDLBlockNO());
				 * ComVar.myStat.setString(58, (String) user.getDLSector());
				 * ComVar.myStat.setString(59, (String) user.getDLCity());
				 * ComVar.myStat.setString(60, (String) user.getDLState());
				 * ComVar.myStat.setString(61, (String) user.getDLCountry());
				 * ComVar.myStat.setString(62, (String) user.getDLZipCode());
				 */
				
				DaoNewSSP.ShowSSPUserInputInfo(user);

				boolean spExecuteStatus=ComVar.myStat.execute();
		        user.setSPstatus(ComVar.myStat.getInt(55));// store proceure status after sp execution
		        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
		        user.setValid(true);
	
		} catch (Exception e) {
			System.out.println("Technical error: Unable to create SSP INFO Please try after some time. Contact Admin :\n" + e);
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

	public static SSPModel UpdateSSPInfo(SSPModel user) {
		System.out.println("2.Start UpdateSSPInfo DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Step 3 : create Connection successfully");
	
			ComVar.myStat = ComVar.Conn.prepareCall("{call [UpdateSSPInfo](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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

	    	ComVar.myStat.setString(31, (String) user.getArmsNo()); 
	    	ComVar.myStat.setString(32, (String) user.getArmsType()); 
	    	ComVar.myStat.setString(33, (String) user.getArmsMadeFromCity()); 
	    	ComVar.myStat.setString(34, (String) user.getArmsPurchaseFrom()); 
	    	ComVar.myStat.setString(35, (String) user.getArmsPurchaseYear()); 
	    	ComVar.myStat.setString(36, (String) user.getArmsIssuedInName()); 	

	        ComVar.myStat.setString(37, (String) user.getDLNO());
	        ComVar.myStat.setString(38, (String) user.getDLIssuefromCity());
	        ComVar.myStat.setString(39, (String) user.getDLIssueDate());
	        ComVar.myStat.setString(40, (String) user.getDLExpiryDate());

			ComVar.myStat.setString(41, (String) user.getOrgName());
			ComVar.myStat.setString(42, (String) user.getEmployeeNo());
			ComVar.myStat.setString(43, (String) user.getDesignation());
			ComVar.myStat.setString(44, (String) user.getDOJ());
			ComVar.myStat.setString(45, (String) user.getDOR());
			ComVar.myStat.setString(46, (String) user.getReportingOfficer());
			ComVar.myStat.setString(47, (String) user.getOEmailID());
			ComVar.myStat.setString(48, (String) user.getOAdress());
			ComVar.myStat.setString(49, (String) user.getOBlock());
			ComVar.myStat.setString(50, (String) user.getOSector());
			ComVar.myStat.setString(51, (String) user.getOCity());
			ComVar.myStat.setString(52, (String) user.getOState());
			ComVar.myStat.setString(53, (String) user.getOcountry());
			ComVar.myStat.setString(54, (String) user.getOPinCode());		        
			ComVar.myStat.registerOutParameter(55, Types.INTEGER);			

			/*
			 * ComVar.myStat.setString(56, (String) user.getDLIRTOAddress());
			 * ComVar.myStat.setString(57, (String) user.getDLBlockNO());
			 * ComVar.myStat.setString(58, (String) user.getDLSector());
			 * ComVar.myStat.setString(59, (String) user.getDLCity());
			 * ComVar.myStat.setString(60, (String) user.getDLState());
			 * ComVar.myStat.setString(61, (String) user.getDLCountry());
			 * ComVar.myStat.setString(62, (String) user.getDLZipCode());
			 */
			System.out.println("Data sent for update :");
			DaoNewSSP.ShowSSPUserInputInfo(user);

			boolean spExecuteStatus=ComVar.myStat.execute();
	        user.setSPstatus(ComVar.myStat.getInt(55));// store proceure status after sp execution
	        System.out.print("Step 6.: SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
	        user.setValid(true);

		} catch (Exception e) {
			System.out.println("Technical error: Unable to create SSP INFO Please try after some time. Contact Admin :\n" + e);
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

	public static SSPModel SSPInfoRetriev(SSPModel user) {
		System.out.println("Start DAO ACTION");
		try {
			user.setValid(false);
			user.setSPstatus(0);	
			ComVar.Conn = ConnectionManager.getConnection();
			System.out.println("Created Connection successfully to Retrieve Data.");
	
			switch(user.getTranType()){
			case "VIEW" :
	
				ComVar.myStat = ComVar.Conn.prepareCall("{call [SearchSSPInfo](?,?)}");
	
				ComVar.myStat.setString(1, (String)user.getEmailId());
				ComVar.myStat.setString(2, (String)user.getRwaRegNo());
				
				System.out.println("Parameter Valuse pass to SP -->"+user.getEmailId()+" : " +user.getRwaRegNo() + ": " +user.getDLNO());
				
				ComVar.myStat.execute();
		        System.out.print("SP Execute Status Code:(1.Success 2.Duplicate User 3.Technical Issues. SP STATUS CODE : "+user.getSPstatus());
		        user.setValid(true);
		        ComVar.prst = ComVar.myStat.getResultSet();
		    	
		        while(ComVar.prst.next()){
			        user.setUserID(ComVar.prst.getString("UserID"));
			        user.setFname(ComVar.prst.getString("Fname"));
			        user.setLname(ComVar.prst.getString("Lname"));
			        user.setGender(ComVar.prst.getString("Gender"));
			        user.setDOB(ComVar.prst.getString("DOB"));
			        user.setMobileNO(ComVar.prst.getString("MobileNO"));
			        user.setEmailId(ComVar.prst.getString("EmailId"));
			        user.setAadharNO(ComVar.prst.getString("AadharNO"));
			        user.setPanCardNo(ComVar.prst.getString("PanCardNo"));
			        user.setFFName(ComVar.prst.getString("FFName"));
			        user.setFLName(ComVar.prst.getString("FLName"));
			        user.setFGender(ComVar.prst.getString("FGender"));
			        user.setFMobileNO(ComVar.prst.getString("FMobileNO"));
			        user.setFEmailId(ComVar.prst.getString("FEmailId"));
			        user.setFAadharNO(ComVar.prst.getString("FAadharNO"));
			        // permanent Address    
			        user.setPAddress(ComVar.prst.getString("PAddress"));
			    	user.setBlockNO(ComVar.prst.getString("BlockNO"));
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
			        user.setCState(ComVar.prst.getString("CState"));
			        user.setCCountry(ComVar.prst.getString("CCountry"));
			        user.setCZipCode(ComVar.prst.getString("CZipCode")); 
			        //ssp Arm Details 
	
			    	user.setArmsNo(ComVar.prst.getString("ArmsNo")); 
			    	user.setArmsType(ComVar.prst.getString("ArmsType")); 
			    	user.setArmsMadeFromCity(ComVar.prst.getString("ArmsMadeFromCity")); 
			    	user.setArmsPurchaseFrom(ComVar.prst.getString("ArmsPurchaseFrom")); 
			    	user.setArmsPurchaseYear(ComVar.prst.getString("ArmsPurchaseYear")); 
			    	user.setArmsIssuedInName(ComVar.prst.getString("ArmsIssuedInName")); 	
			    	
			    	// ssp dl details
			    	
			        user.setDLNO(ComVar.prst.getString("DLNO"));
			        user.setDLIssuefromCity(ComVar.prst.getString("DLIssuefromCity"));
			        user.setDLIssueDate(ComVar.prst.getString("DLIssueDate"));
			        user.setDLExpiryDate(ComVar.prst.getString("DLExpiryDate"));
			        user.setDLIRTOAddress(ComVar.prst.getString("DLIRTOAddress"));
			        user.setDLBlockNO(ComVar.prst.getString("DLBlockNO"));
			        user.setDLSector(ComVar.prst.getString("DLSector"));
			        user.setDLCity(ComVar.prst.getString("DLCity"));
			        user.setDLState(ComVar.prst.getString("DLState"));
			        user.setDLCountry(ComVar.prst.getString("DLCountry"));
			        user.setDLZipCode(ComVar.prst.getString("DLZipCode"));
		
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
		        	
		        	
			    } 
		        break;
			case "xp":
				break;
			default:	
		        user.setValid(true);
		        break;
			} // end of Switch Case
		} catch (Exception e) {
			System.out.println("Technical error in Retrieving SSP Information!" + e);
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
	
	
	public static void ShowSSPUserInputInfo(SSPModel user) {
		
		  System.out.println("Personal Information -RWA :" +user.getRwaRegNo()+ ", UID:" +user.getUserID() +
		  ", FNAME :" +user.getFname()+ ", LAST NAME:" +user.getLname() + ", GENDER:" +user.getGender()); System.out.println("DOB :"+user.getDOB()
		  + ", PAN CARD:"  +user.getPanCardNo()+", EMAIL:"+user.getEmailId() + ", MOBILE :"  +user.getMobileNO()+ " , AADHAR NO :" +user.getAadharNO());
		  System.out.println(" FFNAME:" +user.getFFName()+ ", FLNAME:"  +user.getFLName()+ ", FGENDER:" +user.getFGender()+ ", FEMAIL :"
		  +user.getFEmailId()+", FMOBILE:"+user.getFMobileNO()+ " :" + ", FFAADHAR NO:"	  +user.getFAadharNO());

		  System.out.println("Permanent Address -" +user.getPAddress()+ " :" +user.getBlockNO()+ " :" +user.getSector()+ " :" +user.getCity()+ " :" +user.getState()
			+ " :" +user.getCountry()+ " :" +user.getZipCode());
		

			System.out.println("Correspondance Address -"+user.getCAddress()+ " :" +user.getCBlock()+ " :" +user.getCSector()+ " :" +user.getCCity()+ " :" +user.getCState()+ " :" 
			+user.getCCountry()	+ " :" +user.getCZipCode());
		
	    	System.out.println("Arams Details - ARMS No.-"+ user.getArmsNo()+ ", Type - " +user.getArmsType()+ ", Made in -" +user.getArmsMadeFromCity()+ ", Puchase From -" 
			+user.getArmsPurchaseFrom()	+ ", purchase Year -" +user.getArmsPurchaseYear()+ " Issue In Name -" +user.getArmsIssuedInName());

			System.out.println(" License Details - DL No.-"+user.getDLNO() + ", DL Issue from -" + user.getDLIssuefromCity()+ ", Issue Date -" +user.getDLIssueDate() + " Expiray Date - " +user.getDLExpiryDate());
			

			System.out.println("Organization Detiails -  Name -" + user.getOrgName()+ ", EmpNO -" +user.getEmployeeNo() + ", Designation -" +user.getDesignation()
			+ ", joining Dt.-" +user.getDOJ() + ", Releaving Dt.- :" +user.getDOR()	+ ", Reporting to -:" +user.getReportingOfficer()+ ", Email - " 
			+user.getOEmailID() + " Address -" 	+user.getOAdress()    + ", Block :" +user.getOBlock()+ ", Sector -"	+user.getOSector()+ ", City-" 
			+user.getOCity()+ ",  State -" +user.getOState() + ",Country -" +user.getOcountry()+ ", Pin code-" +user.getOPinCode());

	};

}
