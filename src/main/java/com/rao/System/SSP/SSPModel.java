package com.rao.System.SSP;

public class SSPModel {
	String RwaRegNo;
    String UserID;
    String Fname;
    String Lname;
    String Gender;
    String DOB;
    String MobileNO;
    String EmailId;
    String AadharNO;
    String PanCardNo;
    String FFName;
    String FLName;
    String FGender;
    String FMobileNO;
    String FEmailId;
    String FAadharNO;
//sspc Address
    String CAddress;
    String CBlock;
    String CSector;
    String CCity;
    String CState;
    String CCountry;
    String CZipCode; 
// permanent Address    
    String PAddress;
	String BlockNO;
	String Sector;
	String City;
	String State;
	String Country;
	String ZipCode;
//ssp Arm Details 

	String ArmsNo; 
	String ArmsType; 
	String ArmsMadeFromCity; 
	String ArmsPurchaseFrom; 
	String ArmsPurchaseYear; 
	String ArmsIssuedInName; 	
	
// ssp dl details
	
    String DLIssuefromCity;
    String DLIssueDate;
    String DLExpiryDate;
    String DLIRTOAddress;
    String DLBlockNO;
    String DLSector;
    String DLCity;
    String DLState;
    String DLCountry;
    String DLZipCode;
    
	int SPstatus;
	Boolean valid;
	String TranType;
	int ActionType;
	String DLNO;
	
    String OrgName;
    String EmployeeNo;
    String Designation;
    String DOJ;
    String DOR;
    String ReportingOfficer;
    String OEmailID;
    String OAdress;
    String OBlock;
    String OSector;
    String OCity;
    String OState;
    String Ocountry;
    String OPinCode;
	
	public String getRwaRegNo() {
		return RwaRegNo;
	}
	public void setRwaRegNo(String rwaRegNo) {
		RwaRegNo = rwaRegNo;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getMobileNO() {
		return MobileNO;
	}
	public void setMobileNO(String mobileNO) {
		MobileNO = mobileNO;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAadharNO() {
		return AadharNO;
	}
	public void setAadharNO(String aadharNO) {
		AadharNO = aadharNO;
	}
	public String getPanCardNo() {
		return PanCardNo;
	}
	public void setPanCardNo(String panCardNo) {
		PanCardNo = panCardNo;
	}
	public String getFFName() {
		return FFName;
	}
	public void setFFName(String fFName) {
		FFName = fFName;
	}
	public String getFLName() {
		return FLName;
	}
	public void setFLName(String fLName) {
		FLName = fLName;
	}
	public String getFGender() {
		return FGender;
	}
	public void setFGender(String fGender) {
		FGender = fGender;
	}
	public String getFMobileNO() {
		return FMobileNO;
	}
	public void setFMobileNO(String fMobileNO) {
		FMobileNO = fMobileNO;
	}
	public String getFEmailId() {
		return FEmailId;
	}
	public void setFEmailId(String fEmailId) {
		FEmailId = fEmailId;
	}
	public String getFAadharNO() {
		return FAadharNO;
	}
	public void setFAadharNO(String fAadharNO) {
		FAadharNO = fAadharNO;
	}
	public String getCAddress() {
		return CAddress;
	}
	public void setCAddress(String cAddress) {
		CAddress = cAddress;
	}
	public String getCBlock() {
		return CBlock;
	}
	public void setCBlock(String cBlock) {
		CBlock = cBlock;
	}
	public String getCSector() {
		return CSector;
	}
	public void setCSector(String cSector) {
		CSector = cSector;
	}
	public String getCCity() {
		return CCity;
	}
	public void setCCity(String cCity) {
		CCity = cCity;
	}
	public String getCState() {
		return CState;
	}
	public void setCState(String cState) {
		CState = cState;
	}
	public String getCCountry() {
		return CCountry;
	}
	public void setCCountry(String cCountry) {
		CCountry = cCountry;
	}
	public String getCZipCode() {
		return CZipCode;
	}
	public void setCZipCode(String cZipCode) {
		CZipCode = cZipCode;
	}
	public String getPAddress() {
		return PAddress;
	}
	public void setPAddress(String pAddress) {
		PAddress = pAddress;
	}
	public String getBlockNO() {
		return BlockNO;
	}
	public void setBlockNO(String blockNO) {
		BlockNO = blockNO;
	}
	public String getSector() {
		return Sector;
	}
	public void setSector(String sector) {
		Sector = sector;
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
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getArmsNo() {
		return ArmsNo;
	}
	public void setArmsNo(String armsNo) {
		ArmsNo = armsNo;
	}
	public String getArmsType() {
		return ArmsType;
	}
	public void setArmsType(String armsType) {
		ArmsType = armsType;
	}
	public String getArmsMadeFromCity() {
		return ArmsMadeFromCity;
	}
	public void setArmsMadeFromCity(String armsMadeFromCity) {
		ArmsMadeFromCity = armsMadeFromCity;
	}
	public String getArmsPurchaseFrom() {
		return ArmsPurchaseFrom;
	}
	public void setArmsPurchaseFrom(String armsPurchaseFrom) {
		ArmsPurchaseFrom = armsPurchaseFrom;
	}
	public String getArmsPurchaseYear() {
		return ArmsPurchaseYear;
	}
	public void setArmsPurchaseYear(String armsPurchaseYear) {
		ArmsPurchaseYear = armsPurchaseYear;
	}
	public String getArmsIssuedInName() {
		return ArmsIssuedInName;
	}
	public void setArmsIssuedInName(String armsIssuedInName) {
		ArmsIssuedInName = armsIssuedInName;
	}
	public String getDLIssuefromCity() {
		return DLIssuefromCity;
	}
	public void setDLIssuefromCity(String dLIssuefromCity) {
		DLIssuefromCity = dLIssuefromCity;
	}
	public String getDLIssueDate() {
		return DLIssueDate;
	}
	public void setDLIssueDate(String dLIssueDate) {
		DLIssueDate = dLIssueDate;
	}
	public String getDLExpiryDate() {
		return DLExpiryDate;
	}
	public void setDLExpiryDate(String dLExpiryDate) {
		DLExpiryDate = dLExpiryDate;
	}
	public String getDLIRTOAddress() {
		return DLIRTOAddress;
	}
	public void setDLIRTOAddress(String dLIRTOAddress) {
		DLIRTOAddress = dLIRTOAddress;
	}
	public String getDLBlockNO() {
		return DLBlockNO;
	}
	public void setDLBlockNO(String dLBlockNO) {
		DLBlockNO = dLBlockNO;
	}
	public String getDLSector() {
		return DLSector;
	}
	public void setDLSector(String dLSector) {
		DLSector = dLSector;
	}
	public String getDLCity() {
		return DLCity;
	}
	public void setDLCity(String dLCity) {
		DLCity = dLCity;
	}
	public String getDLState() {
		return DLState;
	}
	public void setDLState(String dLState) {
		DLState = dLState;
	}
	public String getDLCountry() {
		return DLCountry;
	}
	public void setDLCountry(String dLCountry) {
		DLCountry = dLCountry;
	}
	public String getDLZipCode() {
		return DLZipCode;
	}
	public void setDLZipCode(String dLZipCode) {
		DLZipCode = dLZipCode;
	}
	public int getSPstatus() {
		return SPstatus;
	}
	public void setSPstatus(int sPstatus) {
		SPstatus = sPstatus;
	}
	public Boolean isValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public int getActionType() {
		return ActionType;
	}
	public void setActionType(int actionType) {
		ActionType = actionType;
	}
	public String getDLNO() {
		return DLNO;
	}
	public void setDLNO(String dLNO) {
		DLNO = dLNO;
	}
	public String getTranType() {
		return TranType;
	}
	public void setTranType(String tranType) {
		TranType = tranType;
	}
	public String getOrgName() {
		return OrgName;
	}
	public void setOrgName(String orgName) {
		OrgName = orgName;
	}
	public String getEmployeeNo() {
		return EmployeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		EmployeeNo = employeeNo;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getDOR() {
		return DOR;
	}
	public void setDOR(String dOR) {
		DOR = dOR;
	}
	public String getReportingOfficer() {
		return ReportingOfficer;
	}
	public void setReportingOfficer(String reportingOfficer) {
		ReportingOfficer = reportingOfficer;
	}

	
	public String getOEmailID() {
		return OEmailID;
	}
	public void setOEmailID(String oEmailID) {
		OEmailID = oEmailID;
	}
	public String getOAdress() {
		return OAdress;
	}
	public void setOAdress(String oAdress) {
		OAdress = oAdress;
	}
	public String getOBlock() {
		return OBlock;
	}
	public void setOBlock(String oBlock) {
		OBlock = oBlock;
	}
	public String getOSector() {
		return OSector;
	}
	public void setOSector(String oSector) {
		OSector = oSector;
	}
	public String getOCity() {
		return OCity;
	}
	public void setOCity(String oCity) {
		OCity = oCity;
	}
	public String getOState() {
		return OState;
	}
	public void setOState(String oState) {
		OState = oState;
	}
	public String getOcountry() {
		return Ocountry;
	}
	public void setOcountry(String ocountry) {
		Ocountry = ocountry;
	}
	public String getOPinCode() {
		return OPinCode;
	}
	public void setOPinCode(String oPinCode) {
		OPinCode = oPinCode;
	}

	
}
