package com.raoSystem.password;

public class SetGetUserID {
	private String userId="";
	private String rwaRegNo="";
	public boolean valid;
	private String Pwd="";
	private String ConfPwd="";
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		this.Pwd = pwd;
	}

	public String getRwaRegNo() {
		return rwaRegNo;
	}

	public void setRwaRegNo(String rwaRegNo) {
		this.rwaRegNo = rwaRegNo;
	}

	public String getConfPwd() {
		return ConfPwd;
	}

	public void setConfPwd(String confPwd) {
		ConfPwd = confPwd;
	}

	
}
