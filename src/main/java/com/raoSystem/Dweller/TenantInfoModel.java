package com.raoSystem.Dweller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name= "TenantInformation")
public class TenantInfoModel implements Serializable {

	@Column(name = "IDNO", columnDefinition ="int", nullable =true)
	private int idNO;
	
	@Id
	@Column(name = "RwaRegNo", columnDefinition ="nvarchar(100)", nullable =false)
	private String rwaRegNo;

	@Id
	@Column(name = "AptNo", columnDefinition ="nvarchar(50)", nullable =false, updatable= false)
	private String aptNo;

	@Id
	@Column(name = "FlatNo", columnDefinition ="nvarchar(50)", nullable =false, updatable= false)
	private String flatNo;
	
	// Personal  Information
	
	@Column(name = "FName", columnDefinition ="nvarchar(100)", nullable =false)
	private String fName;
	
	@Column(name = "LName", columnDefinition ="nvarchar(100)", nullable =false)
	private String lName;

	@Column(name = "Gender", columnDefinition ="nvarchar(10)", nullable =false)
	private String gender;
	
	
	@Column(name = "FFName", columnDefinition ="nvarchar(100)", nullable =false)
	private String fFName;
	
	@Column(name = "FLName", columnDefinition ="nvarchar(100)", nullable =false)
	private String fLName;

	// Contact Information

	@Column(name = "MobileNo", columnDefinition ="nvarchar(50)", nullable =false)
	private String mobileNo;

	@Column(name = "PhoneNo", columnDefinition ="nvarchar(50)", nullable =true)
	private String phoneNo;
	
	@Column(name = "EmailId", columnDefinition ="nvarchar(100)", nullable =false)
	private String emailId;

	@Column(name = "ShiftedOn", columnDefinition ="date", nullable =false)
	@Temporal(value = TemporalType.DATE)
	private Date ShiftedOn;
	
	@Column(name = "ShiftedOutOn", columnDefinition ="date", nullable =true)
	@Temporal(value = TemporalType.DATE)
	private Date shiftedOutOn;

	@Column(name = "TenantStatus", columnDefinition ="nvarchar(100)", nullable =false)
	@ColumnDefault(value = "'Active'")
	private String tenantStatus;

	// Address Information
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy= "tntAddress")
	private List<TenantAddresInfoModel> addTnt = new ArrayList<>();
	
	// Admin Information

	@Column(name = "CreatedBy", columnDefinition ="nvarchar(100)", nullable =false)
	private String createdBy;
	
	@Column(name = "CreatedOn", columnDefinition ="datetime", nullable =false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "UpdatedBy", columnDefinition ="nvarchar(100)", nullable =false)
	private String updatedBy;
	
	@Column(name = "UpdatedOn", columnDefinition ="datetime", nullable =false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "Status", columnDefinition ="nvarchar(1)", nullable =true)
	@ColumnDefault(value = "'A'")
	private String status;

	
	
	/**
	 * @param idNO
	 * @param rwaRegNo
	 * @param aptNo
	 * @param flatNo
	 */
	public TenantInfoModel(int idNO, String rwaRegNo, String aptNo, String flatNo) {
		super();
		this.idNO = idNO;
		this.rwaRegNo = rwaRegNo;
		this.aptNo = aptNo;
		this.flatNo = flatNo;
	}

	/**
	 * 
	 */
	public TenantInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdNO() {
		return idNO;
	}

	public void setIdNO(int idNO) {
		this.idNO = idNO;
	}

	public String getRwaRegNo() {
		return rwaRegNo;
	}

	public void setRwaRegNo(String rwaRegNo) {
		this.rwaRegNo = rwaRegNo;
	}

	public String getAptNo() {
		return aptNo;
	}

	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getfFName() {
		return fFName;
	}

	public void setfFName(String fFName) {
		this.fFName = fFName;
	}

	public String getfLName() {
		return fLName;
	}

	public void setfLName(String fLName) {
		this.fLName = fLName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getShiftedOn() {
		return ShiftedOn;
	}

	public void setShiftedOn(Date shiftedOn) {
		ShiftedOn = shiftedOn;
	}

	public Date getShiftedOutOn() {
		return shiftedOutOn;
	}

	public void setShiftedOutOn(Date shiftedOutOn) {
		this.shiftedOutOn = shiftedOutOn;
	}

	public String getTenantStatus() {
		return tenantStatus;
	}

	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	public List<TenantAddresInfoModel> getAddTnt() {
		return addTnt;
	}

	public void setAddTnt(List<TenantAddresInfoModel> addTnt) {
		this.addTnt = addTnt;
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
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TenantInfoModel [idNO=" + idNO + ", rwaRegNo=" + rwaRegNo + ", aptNo=" + aptNo + ", flatNo=" + flatNo
				+ ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", fFName=" + fFName + ", fLName="
				+ fLName + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo + ", emailId=" + emailId + ", ShiftedOn="
				+ ShiftedOn + ", shiftedOutOn=" + shiftedOutOn + ", tenantStatus=" + tenantStatus + ", addTnt=" + addTnt
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + ", status=" + status + "]";
	}
}