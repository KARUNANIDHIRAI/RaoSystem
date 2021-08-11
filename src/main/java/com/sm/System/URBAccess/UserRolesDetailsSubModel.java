package com.sm.System.URBAccess;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SMUserRolesDetail")
public class UserRolesDetailsSubModel{
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

		@Column(name="UserRoleIdFK", nullable= false , updatable = false)
		private int userRoleIdFK;
		
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

		public int getUserRoleIdFK() {
			return userRoleIdFK;
		}

		public void setUserRoleIdFK(int userRoleIdFK) {
			this.userRoleIdFK = userRoleIdFK;
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
			return "UserRolesDetailsSubModel [iDDNO=" + iDDNO + ", regNo=" + regNo + ", fName=" + fName + ", lName="
					+ lName + ", emailID=" + emailID + ", mobileNo=" + mobileNo + ", userRoleIdFK=" + userRoleIdFK
					+ ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
					+ updatedBy + ", UpdatedOn=" + UpdatedOn + "]";
		}


	}
