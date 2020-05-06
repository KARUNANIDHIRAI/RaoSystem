package com.raoSystem.login;


public class UserLogin {
	private String loginID="";
	private String RwaRegNo="";
	private String password ="";
	private String fName;
    private String lName;
    public boolean valid;

    public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getRwaRegNo() {
		return RwaRegNo;
	}
	public void setRwaRegNo(String rwaRegNo) {
		RwaRegNo = rwaRegNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

   
	

}
