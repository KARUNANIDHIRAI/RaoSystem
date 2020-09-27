package com.raoSystem.Utility;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RwaRegistration")
public class ValidEmail implements Serializable{
	@Id
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Id
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;
	
	@Column(name="EmailId", nullable= false, columnDefinition = "nvarchar(100)", updatable= false)
	private String emailId;

	

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "ValidEmail [regNo=" + regNo + ", status=" + status + ", emailId=" + emailId + "]";
	}

}
