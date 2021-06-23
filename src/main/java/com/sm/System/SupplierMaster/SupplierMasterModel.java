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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="SMSupplierMaster")
public class SupplierMasterModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="SupCode", nullable= false , updatable = false)
	private String supCode;
	
	@Column(name="SupName", nullable= false , updatable = true)
	private String supName;


	@Column(name="Facebook", nullable= false , updatable = true)
	private String facebook;
	
	@Column(name="Linkedin", nullable= true , updatable = true)
	private String linkedin;

	@Column(name="Twitter", nullable= true , updatable = true)
	private String twitter;

	@Column(name="SupCategory", nullable= false , updatable = true)
	private String supCategory;
	
	@Column(name="Status", nullable= true)
	private String status;

	@Column(name= "CreatedBy", nullable= false,updatable = false)
	private String createdBy;

	@Column(name= "CreatedOn", nullable= false,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name= "UpdatedBy", nullable= false)
	private String updatedBy;

	@Column(name= "UpdatedOn", nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="supAddModel")
	private List<SupplierMasterAddressModel>  supMAddress= new ArrayList<>();;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="supContactModel")
	private List<SupplierMasterContact>  supMasterContact= new ArrayList<>();

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

	public String getSupCode() {
		return supCode;
	}

	public void setSupCode(String supCode) {
		this.supCode = supCode;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSupCategory() {
		return supCategory;
	}

	public void setSupCategory(String supCategory) {
		this.supCategory = supCategory;
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

	public List<SupplierMasterAddressModel> getSupMAddress() {
		return supMAddress;
	}

	public void setSupMAddress(List<SupplierMasterAddressModel> supMAddress) {
		this.supMAddress = supMAddress;
	}

	public List<SupplierMasterContact> getSupMasterContact() {
		return supMasterContact;
	}

	public void setSupMasterContact(List<SupplierMasterContact> supMasterContact) {
		this.supMasterContact = supMasterContact;
	}

	@Override
	public String toString() {
		return "SupplierMasterModel [iDNO=" + iDNO + ", regNo=" + regNo + ", supCode=" + supCode + ", supName="
				+ supName + ", facebook=" + facebook + ", linkedin=" + linkedin + ", twitter=" + twitter
				+ ", supCategory=" + supCategory + ", status=" + status + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", supMAddress=" + supMAddress
				+ ", supMasterContact=" + supMasterContact + "]";
	};

	
}
