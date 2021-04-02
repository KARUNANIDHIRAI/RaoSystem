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

import com.sm.System.SchoolInformation.Email;

@Entity
@Table(name ="SMStudentInfo")
public class StudentPersonalInfoModel  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SIdNo", nullable= false , updatable = false)
	private Integer sIdNo;

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="RollNo", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String rollNo;

	@Column(name="AdmNo", nullable= false)
	private String admNo;
	
	@Column(name="AdmDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date admDate;
	

	@Column(name="FName", nullable= false, columnDefinition = "nvarchar(100)")
	private String fName;
	
	@Column(name="LName", nullable= false, columnDefinition = "nvarchar(100)")
	private String lName;

	@Column(name="Gender", nullable= false, columnDefinition = "nvarchar(100)")
	private String gender;

	@Column(name="DOB", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="AdmInClass", nullable= true,columnDefinition = "nvarchar(100)")
	private String admInClass;

	@Column(name="PromotedInClass", nullable= true,columnDefinition = "nvarchar(100)")
	private String promotedInClass;

	@Column(name="MobileNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String mobileNo;

	@Column(name="EmailId", nullable= true,columnDefinition = "nvarchar(100)")
	private String emailId;

	@Column(name="Sibling", nullable= true,columnDefinition = "nvarchar(100)")
	private String sibling;
	

	@Column(name="FFName", nullable= false, columnDefinition = "nvarchar(100)")
	private String ffName;
	
	@Column(name="FLName", nullable= false, columnDefinition = "nvarchar(100)")
	private String flName;

	@Column(name="FProfession", nullable= false, columnDefinition = "nvarchar(100)")
	private String fprofession;


	@Column(name="MFName", nullable= false, columnDefinition = "nvarchar(100)")
	private String mfName;
	
	@Column(name="MLName", nullable= false, columnDefinition = "nvarchar(100)")
	private String mlName;
	
	@Column(name="MProfession", nullable= false, columnDefinition = "nvarchar(100)")
	private String mprofession;
	
	@Column(name="PMobileNo", nullable= true,columnDefinition = "nvarchar(200)")
	private String pMobileNo;

	@Column(name="PEmailId", nullable= true,columnDefinition = "nvarchar(200)")
	private String pEmailId;
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "SidProof")
	private List<SIdProof> sidProofInfo= new ArrayList<>();	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "stdAddress" )
	private List<StudentAddress> studentdAddress = new ArrayList<>();
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="studentBankDetails")
	private List<SBankDetailInfo> sBankDtl = new ArrayList<>();	
	
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;

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

	public String getSibling() {
		return sibling;
	}

	public void setSibling(String sibling) {
		this.sibling = sibling;
	}

	public String getFfName() {
		return ffName;
	}

	public void setFfName(String ffName) {
		this.ffName = ffName;
	}

	public String getFlName() {
		return flName;
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public String getFprofession() {
		return fprofession;
	}

	public void setFprofession(String fprofession) {
		this.fprofession = fprofession;
	}

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	public String getMlName() {
		return mlName;
	}

	public void setMlName(String mlName) {
		this.mlName = mlName;
	}

	public String getMprofession() {
		return mprofession;
	}

	public void setMprofession(String mprofession) {
		this.mprofession = mprofession;
	}

	public String getpMobileNo() {
		return pMobileNo;
	}

	public void setpMobileNo(String pMobileNo) {
		this.pMobileNo = pMobileNo;
	}

	public String getpEmailId() {
		return pEmailId;
	}

	public void setpEmailId(String pEmailId) {
		this.pEmailId = pEmailId;
	}

	public List<SIdProof> getSidProofInfo() {
		return sidProofInfo;
	}

	public void setSidProofInfo(List<SIdProof> sidProofInfo) {
		this.sidProofInfo = sidProofInfo;
	}

	public List<StudentAddress> getStudentdAddress() {
		return studentdAddress;
	}

	public void setStudentdAddress(List<StudentAddress> studentdAddress) {
		this.studentdAddress = studentdAddress;
	}


	public List<SBankDetailInfo> getsBankDtl() {
		return sBankDtl;
	}

	public void setsBankDtl(List<SBankDetailInfo> sBankDtl) {
		this.sBankDtl = sBankDtl;
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
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

//	@Override
//	public String toString() {
//		return "StudentPersonalInfoModel [sIdNo=" + sIdNo + ", regNo=" + regNo + ", rollNo=" + rollNo + ", admNo="
//				+ admNo + ", admDate=" + admDate + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender
//				+ ", dob=" + dob + ", admInClass=" + admInClass + ", promotedInClass=" + promotedInClass + ", mobileNo="
//				+ mobileNo + ", emailId=" + emailId + ", sibling=" + sibling + ", ffName=" + ffName + ", flName="
//				+ flName + ", fprofession=" + fprofession + ", mfName=" + mfName + ", mlName=" + mlName
//				+ ", mprofession=" + mprofession + ", pMobileNo=" + pMobileNo + ", pEmailId=" + pEmailId
//				+ ", sidProofInfo=" + sidProofInfo + ", studentdAddress=" + studentdAddress + ", sBankDtl=" + sBankDtl
//				+ ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
//				+ updatedBy + ", updatedOn=" + updatedOn + "]";
//	}
//


	
}
