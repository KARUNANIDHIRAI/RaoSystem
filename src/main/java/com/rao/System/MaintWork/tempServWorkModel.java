package com.rao.System.MaintWork;

public class tempServWorkModel {
	String RwaRegNo;
	String UID;
	String SNo;
	String SWNO;
	String Name;
	String MobileNo;
	String Wages;	
	String Date;
	String ActionType;
	Boolean valid;
	int SPstatus;
	public String getRwaRegNo() {
		return RwaRegNo;
	}
	public void setRwaRegNo(String rwaRegNo) {
		RwaRegNo = rwaRegNo;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getSNo() {
		return SNo;
	}
	public void setSNo(String sNo) {
		SNo = sNo;
	}
	public String getSWNO() {
		return SWNO;
	}
	public void setSWNO(String sWNO) {
		SWNO = sWNO;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getWages() {
		return Wages;
	}
	public void setWages(String wages) {
		Wages = wages;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getActionType() {
		return ActionType;
	}
	public void setActionType(String actionType) {
		ActionType = actionType;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public int getSPstatus() {
		return SPstatus;
	}
	public void setSPstatus(int sPstatus) {
		SPstatus = sPstatus;
	}	
	
}
class ServWorkModel{
	String RwaRegNo;
	String UID;
	String ServiceType;
	String ServCharge;
	String Sdate;
	String Edate;
	String SWStatus;
	String SWNO;
	String PName;
	String PMobileNo;
	String Address;	
	String City;
	String State;
	String Country;
	String Pin;	
	int SPstatus;
	int SPInnerStatus;
	Boolean valid;
	String TranType;
	String ActionType;
	
	public String getRwaRegNo() {
		return RwaRegNo;
	}
	public void setRwaRegNo(String rwaRegNo) {
		RwaRegNo = rwaRegNo;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	
	public String getServiceType() {
		return ServiceType;
	}
	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
	
	public String getServCharge() {
		return ServCharge;
	}
	public void setServCharge(String servCharge) {
		ServCharge = servCharge;
	}
	public String getSdate() {
		return Sdate;
	}
	public void setSdate(String sdate) {
		Sdate = sdate;
	}
	public String getEdate() {
		return Edate;
	}
	public void setEdate(String edate) {
		Edate = edate;
	}
	public String getSWStatus() {
		return SWStatus;
	}
	public void setSWStatus(String sWStatus) {
		SWStatus = sWStatus;
	}
	public String getSWNO() {
		return SWNO;
	}
	public void setSWNO(String sWNO) {
		SWNO = sWNO;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public String getPMobileNo() {
		return PMobileNo;
	}
	public void setPMobileNo(String pMobileNo) {
		PMobileNo = pMobileNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public int getSPstatus() {
		return SPstatus;
	}
	public void setSPstatus(int sPstatus) {
		SPstatus = sPstatus;
	}
	public int getSPInnerStatus() {
		return SPInnerStatus;
	}
	public void setSPInnerStatus(int sPInnerStatus) {
		SPInnerStatus = sPInnerStatus;
	}
	public Boolean isValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getTranType() {
		return TranType;
	}
	public void setTranType(String tranType) {
		TranType = tranType;
	}
	public String getActionType() {
		return ActionType;
	}
	public void setActionType(String actionType) {
		ActionType = actionType;
	}
}	
	class MWSearch {
		String MWType;
		String Action;
		String MWNO;
		String SPName;
		String FDate;
		String TDate;
		String RwaRegNo;
		String delMWNO;
		public String getMWType() {
			return MWType;
		}
		public void setMWType(String mWType) {
			MWType = mWType;
		}
		public String getAction() {
			return Action;
		}
		public void setAction(String action) {
			Action = action;
		}
		public String getMWNO() {
			return MWNO;
		}
		public void setMWNO(String mWNO) {
			MWNO = mWNO;
		}
		public String getSPName() {
			return SPName;
		}
		public void setSPName(String sPName) {
			SPName = sPName;
		}
		public String getFDate() {
			return FDate;
		}
		public void setFDate(String fDate) {
			FDate = fDate;
		}
		public String getTDate() {
			return TDate;
		}
		public void setTDate(String tDate) {
			TDate = tDate;
		}
		public String getRwaRegNo() {
			return RwaRegNo;
		}
		public void setRwaRegNo(String rwaRegNo) {
			RwaRegNo = rwaRegNo;
		}
		public String getDelMWNO() {
			return delMWNO;
		}
		public void setDelMWNO(String delMWNO) {
			this.delMWNO = delMWNO;
		}
		
}

	class MWEdit {
		String RwaRegNo;
		String MWNO;
		MWEdit(String rwaRegNo, String soNo){
			RwaRegNo=rwaRegNo;
			MWNO=soNo;
		}
		public String getMWNO() {
			return MWNO;
		}
		public void setMWNO(String mWNO) {
			MWNO = mWNO;
		}
		public String getRwaRegNo() {
			return RwaRegNo;
		}
		public void setRwaRegNo(String rwaRegNo) {
			RwaRegNo = rwaRegNo;
		}
}
	