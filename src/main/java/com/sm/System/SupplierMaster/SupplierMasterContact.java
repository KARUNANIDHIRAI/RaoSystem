package com.sm.System.SupplierMaster;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "SMSupplierMasterContact")
public class SupplierMasterContact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	

	@Column(name="EmailID", nullable= false , updatable = true)
	private String emailID;

	@Column(name="MobileNo", nullable= false , updatable = true)
	private String mobileNo;
	
	@Column(name="PhoneNo", nullable= false , updatable = true)
	private String phoneNo;
	

	@Column(name="ContactRef", nullable= false , updatable = true)
	private String contactRef;
	
	@Column(name="Status", nullable= true)
	private String status;

	@Column(name= "UpdatedBy", nullable= false)
	private String updatedBy;

	@Column(name= "UpdatedOn", nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "IDNOFK")
	private SupplierMasterModel  supContactModel;

	public Integer getiDNO() {
		return iDNO;
	}

	public void setiDNO(Integer iDNO) {
		this.iDNO = iDNO;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	public SupplierMasterModel getSupContactModel() {
		return supContactModel;
	}

	public void setSupContactModel(SupplierMasterModel supContactModel) {
		this.supContactModel = supContactModel;
	}

	
	public String getContactRef() {
		return contactRef;
	}

	public void setContactRef(String contactRef) {
		this.contactRef = contactRef;
	}

//	@Override
//	public String toString() {
//		return "SupplierMasterContact [iDNO=" + iDNO + ", regNo=" + regNo + ", emailID=" + emailID + ", mobileNo="
//				+ mobileNo + ", phoneNo=" + phoneNo + ", contactRef=" + contactRef + ", status=" + status
//				+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", supContactModel=" + supContactModel
//				+ "]";
//	}
//
	

}
