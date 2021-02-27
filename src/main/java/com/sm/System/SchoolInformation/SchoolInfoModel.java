package com.sm.System.SchoolInformation;

	import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

	@Entity
	@Table(name ="SMSchoolInformation")
	public class SchoolInfoModel implements Serializable{
		

		@Id
		@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
		private String regNo;
		
		@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
		private String status;
		
		@Column(name="Name", nullable= false, columnDefinition = "nvarchar(100)")
		private String name;
		
		
		@Column(name="RegDate", nullable= false, columnDefinition = "date")
		@Temporal(TemporalType.DATE)
		private Date regDate;
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "schEmail")
		private List<Email> emailId= new ArrayList<Email>();

		@Column(name="MobileNo", nullable= false,columnDefinition = "nvarchar(200)")
		private String mobileNo;

		@Column(name="PhoneNo", nullable= true,columnDefinition = "nvarchar(200)")
		private String phoneNo;

		@OneToOne(mappedBy = "schAddress")
		private Address address;


		@Column(name= "LoginID", nullable= false, columnDefinition = "nvarchar(100)")
		private String loginId;

		@Column(name= "LoginPassword", nullable= false, columnDefinition = "nvarchar(100)")
		private String loginPassword;
		

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getRegDate() {
			return regDate;
		}

		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}

		public List<Email> getEmailId() {
			return emailId;
		}

		public void setEmailId(List<Email> emailId) {
			this.emailId = emailId;
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

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}

		public String getLoginPassword() {
			return loginPassword;
		}

		public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
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
			return "SchoolInfoModel [regNo=" + regNo + ", status=" + status + ", name=" + name + ", regDate=" + regDate
					+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo + ", address="
					+ address + ", loginId=" + loginId + ", loginPassword=" + loginPassword + ", createdBy=" + createdBy
					+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
		}

		
}
