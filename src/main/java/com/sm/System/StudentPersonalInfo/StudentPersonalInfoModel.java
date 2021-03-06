package com.sm.System.StudentPersonalInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="StudentInformation")
public class StudentPersonalInfoModel  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SIdNo", nullable= false , updatable = false, columnDefinition = "Integer")
	private Integer sIdNo;

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="RollNo", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String rollNo;

	@Column(name="AdmNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String admNo;
	
	@Column(name="AdmDate", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date admDate;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="studentPersonalInfoModel")
	private SParentInfo sParentInfo;
	
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;
	
	@Column(name="FName", nullable= false, columnDefinition = "nvarchar(100)")
	private String fName;
	
	@Column(name="LName", nullable= false, columnDefinition = "nvarchar(100)")
	private String lName;

	@Column(name="Gender", nullable= false, columnDefinition = "nvarchar(100)")
	private String gender;

	@Column(name="DOB", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="MobileNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String mobileNo;

	@Column(name="EmailId", nullable= true,columnDefinition = "nvarchar(100)")
	private String emailId;

	@Column(name="AdmInClass", nullable= true,columnDefinition = "nvarchar(100)")
	private String admInClass;

	@Column(name="PromotedInClass", nullable= true,columnDefinition = "nvarchar(100)")
	private String promotedInClass;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "studentPersonalInfo")
	private List<SIdProofInfo> sidProofInfo = new ArrayList<SIdProofInfo>();

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "stdAddress")
	private SAddressInfo studentdAddress ;

	@Column(name= "CreatedBy", nullable= false,updatable = false, columnDefinition = "nvarchar(100)")
	private String createdBy;

	@Column(name= "CreatedOn", nullable= false,updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name= "UpdatedBy", nullable= false,columnDefinition = "nvarchar(100)")
	private String updatedBy;

	@Column(name= "UpdatedOn", nullable= false,columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public Integer getsIdNo() {
		return sIdNo;
	}

	public void setsIdNo(Integer sIdNo) {
		this.sIdNo = sIdNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getAdmNo() {
		return admNo;
	}

	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}

	public Date getAdmDate() {
		return admDate;
	}

	public void setAdmDate(Date admDate) {
		this.admDate = admDate;
	}

	public SParentInfo getsParentInfo() {
		return sParentInfo;
	}

	public void setsParentInfo(SParentInfo sParentInfo) {
		this.sParentInfo = sParentInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdmInClass() {
		return admInClass;
	}

	public void setAdmInClass(String admInClass) {
		this.admInClass = admInClass;
	}

	public String getPromotedInClass() {
		return promotedInClass;
	}

	public void setPromotedInClass(String promotedInClass) {
		this.promotedInClass = promotedInClass;
	}

	public List<SIdProofInfo> getSidProofInfo() {
		return sidProofInfo;
	}

	public void setSidProofInfo(List<SIdProofInfo> sidProofInfo) {
		this.sidProofInfo = sidProofInfo;
	}

	public SAddressInfo getStudentdAddress() {
		return studentdAddress;
	}

	public void setStudentdAddress(SAddressInfo studentdAddress) {
		this.studentdAddress = studentdAddress;
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

	@Override
	public String toString() {
		return "StudentPersonalInfoModel [sIdNo=" + sIdNo + ", regNo=" + regNo + ", rollNo=" + rollNo + ", admNo="
				+ admNo + ", admDate=" + admDate + ", sParentInfo=" + sParentInfo + ", status=" + status + ", fName="
				+ fName + ", lName=" + lName + ", gender=" + gender + ", dob=" + dob + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", admInClass=" + admInClass + ", promotedInClass=" + promotedInClass
				+ ", sidProofInfo=" + sidProofInfo + ", studentdAddress=" + studentdAddress + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
	
}
