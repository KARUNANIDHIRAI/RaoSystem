package com.sm.System.Faculty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name ="SMFacultyMember")
public class FacultyMemberModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FMIDNO")
	private Integer fMIDNO;


	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="FacultyCode", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String facultyCode;

	@Column(name="Faculty", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String faculty;

	@Column(name="Designation", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String designation;


	@Column(name="DOJ", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date dOJ;

	@Column(name="DOR", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date dOR;

	@Column(name="Name", nullable= false, columnDefinition = "nvarchar(100)")
	private String name;
	
	@Column(name="LName", nullable= false, columnDefinition = "nvarchar(100)")
	private String lName;
	
	@Column(name="Gender", nullable= false, columnDefinition = "nvarchar(100)")
	private String gender;

	@Column(name="DOB", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date dOB;

	@Column(name="Qualification", nullable= false, columnDefinition = "nvarchar(100)")
	private String qualification;

	@Column(name="SkillArea", nullable= true, columnDefinition = "nvarchar(100)")
	private String skillArea;
	
	@Column(name="EmailID", nullable= false,columnDefinition = "nvarchar(100)")
	private String emailID;

	@Column(name="MobileNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String mobileNo;

	@Column(name="PhoneNo", nullable= true,columnDefinition = "nvarchar(100)")
	private String phoneNo;

	@Column(name="FMStatus", nullable= true,columnDefinition = "nvarchar(100)")
	private String status;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "fMAddress")
	private List<FacultyMemberAddressModel> address = new ArrayList<FacultyMemberAddressModel>();

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

	public Integer getfMIDNO() {
		return fMIDNO;
	}

	public void setfMIDNO(Integer fMIDNO) {
		this.fMIDNO = fMIDNO;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public Date getdOJ() {
		return dOJ;
	}

	public void setdOJ(Date dOJ) {
		this.dOJ = dOJ;
	}

	public Date getdOR() {
		return dOR;
	}

	public void setdOR(Date dOR) {
		this.dOR = dOR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSkillArea() {
		return skillArea;
	}

	public void setSkillArea(String skillArea) {
		this.skillArea = skillArea;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FacultyMemberAddressModel> getAddress() {
		return address;
	}

	public void setAddress(List<FacultyMemberAddressModel> address) {
		this.address = address;
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
		return "FacultyMemberModel [fMIDNO=" + fMIDNO + ", regNo=" + regNo + ", facultyCode=" + facultyCode
				+ ", faculty=" + faculty + ", designation=" + designation + ", dOJ=" + dOJ + ", dOR=" + dOR + ", name="
				+ name + ", lName=" + lName + ", gender=" + gender + ", dOB=" + dOB + ", qualification=" + qualification
				+ ", skillArea=" + skillArea + ", emailID=" + emailID + ", mobileNo=" + mobileNo + ", phoneNo="
				+ phoneNo + ", status=" + status + ", address=" + address + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}



	
}
