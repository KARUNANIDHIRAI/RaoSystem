package com.sm.System.URBAccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "SMUserRolesDetail")
public class UserRolesDetailsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserRoleDetailId")
	private Integer iDDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name ="FName", nullable= false, updatable = true)
	private String fName;
	
	@Column(name ="LName", nullable= false, updatable = true)
	private String lName;

	@Column(name ="EmailID", nullable= false, updatable = true)
	private String emailID;
	
	@Column(name ="MobileNo", nullable= false, updatable = true)
	private String mobileNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "UserRoleIdFK")
	private UserRolesModel URolesModel;
	
	@Column(name= "Status", nullable= false, updatable = true)
	private String status;
	
	@Column(name= "CreatedBy", nullable= false, updatable = false)
	private String createdBy;
	
	@Column(name= "CreatedOn", nullable= false, updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name= "UpdatedBy", nullable= false, updatable = true)
	private String updatedBy;
	
	@Column(name= "UpdatedOn", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdatedOn;

	public Integer getiDDNO() {
		return iDDNO;
	}

	public void setiDDNO(Integer iDDNO) {
		this.iDDNO = iDDNO;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public UserRolesModel getURolesModel() {
		return URolesModel;
	}

	public void setURolesModel(UserRolesModel uRolesModel) {
		URolesModel = uRolesModel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "UserRolesDetailsModel [iDDNO=" + iDDNO + ", regNo=" + regNo + ", fName=" + fName + ", lName=" + lName
				+ ", emailID=" + emailID + ", mobileNo=" + mobileNo + ", URolesModel=" + URolesModel + ", status="
				+ status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", UpdatedOn=" + UpdatedOn + "]";
	}
	

}
