package com.raoSystem.Dweller;

import java.util.Date;

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

import com.raoSystem.FLTOWN.HFlatOwnerModel;

@Entity
@Table(name= "TenantAddress")
public class TenantAddresInfoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDNO", nullable= false)
	private int iDNO;
	
	@Column(name= "Sector", nullable= true, columnDefinition = "nvarchar(255)")
	private String sector;
	
	@Column(name= "City", nullable= false,columnDefinition = "nvarchar(255)")
	private String city;
	
	@Column(name= "State", nullable= false,columnDefinition = "nvarchar(255)")
	private String state;
	
	@Column(name= "Country", nullable= false,columnDefinition = "nvarchar(255)")
	private String country;
	
	@Column(name= "PinCode", nullable= true,columnDefinition = "nvarchar(255)")
	private String pinCode;
	
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(255)")
	private String status;

	@Column(name= "CreatedBy", nullable= false,updatable = false, columnDefinition = "nvarchar(255)")
	private String createdBy;
	
	@Column(name= "CreatedOn", nullable= false,updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name= "UpdatedBy", nullable= false,columnDefinition = "nvarchar(255)")
	private String updatedBy;
	
	@Column(name= "UpdatedOn", nullable= false,columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "RwaRegNo", columnDefinition = "nvarchar(100)")
	@JoinColumn( name = "AptNo", columnDefinition = "nvarchar(50)")
	@JoinColumn( name = "FlatNo", columnDefinition = "nvarchar(50)")
	private TenantInfoModel tntAddress;

	public int getiDNO() {
		return iDNO;
	}

	public void setiDNO(int iDNO) {
		this.iDNO = iDNO;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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

	public TenantInfoModel getTntAddress() {
		return tntAddress;
	}

	public void setTntAddress(TenantInfoModel tntAddress) {
		this.tntAddress = tntAddress;
	}

	@Override
	public String toString() {
		return "TenantAddresInfoModel [iDNO=" + iDNO + ", sector=" + sector + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pinCode=" + pinCode + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", tntAddress="
				+ tntAddress + "]";
	}
}
