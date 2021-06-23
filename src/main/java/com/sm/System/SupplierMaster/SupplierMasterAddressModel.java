package com.sm.System.SupplierMaster;

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
@Table(name= "SMSupplierMasterAddress")
public class SupplierMasterAddressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="Address", nullable= false , updatable = false)
	private String address;
	
	@Column(name="Sector", nullable= false , updatable = true)
	private String sector;

	@Column(name="City", nullable= false , updatable = true)
	private String city;

	@Column(name="State", nullable= false , updatable = true)
	private String state;
	
	@Column(name="Country", nullable= false , updatable = true)
	private String country;
	
	@Column(name="Pincode", nullable= false , updatable = true)
	private String pincode;
	
	@Column(name="Category", nullable= false , updatable = true)
	private String category;
	
	@Column(name="Status", nullable= false , updatable = true)
	private String status;
	
	@Column(name="UpdatedBy", nullable= false , updatable = true)
	private String updatedBy;
	
	@Column(name= "UpdatedOn", nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "IDNOFK")
	private SupplierMasterModel  supAddModel;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public SupplierMasterModel getSupAddModel() {
		return supAddModel;
	}

	public void setSupAddModel(SupplierMasterModel supAddModel) {
		this.supAddModel = supAddModel;
	}

//	@Override
//	public String toString() {
//		return "SupplierMasterAddressModel [iDNO=" + iDNO + ", regNo=" + regNo + ", address=" + address + ", sector="
//				+ sector + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
//				+ ", category=" + category + ", status=" + status + ", updatedBy=" + updatedBy + ", updatedOn="
//				+ updatedOn + ", supAddModel=" + supAddModel + "]";
//	}
//
	

}
