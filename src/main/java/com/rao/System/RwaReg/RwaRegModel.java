package com.rao.System.RwaReg;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.raoSystem.Utility.CountryList;
@Entity
@Table(name ="RwaRegistration")
public class RwaRegModel implements Serializable{
	
	@Id
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Id
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;
	
	@Column(name="RegName", nullable= false, columnDefinition = "nvarchar(100)")
	private String regName;
	
	
	@Column(name="RegDate", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date regDate;

	@Column(name="RegExpDate", nullable= false,columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date expDate;

	@Column(name="EmailId", nullable= false, columnDefinition = "nvarchar(100)")
	private String emailId;

	@Column(name="MobileNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String mobileNo;

	@Column(name="PhoneNo", nullable= true,columnDefinition = "nvarchar(100)")
	private String phoneNo;

	@Column(name= "Address", nullable= false,columnDefinition = "nvarchar(100)")
	private String address;

	@Column(name= "Sector", nullable= true, columnDefinition = "nvarchar(100)")
	private String sector;

	@Column(name= "City", nullable= false,columnDefinition = "nvarchar(100)")
	private String city;

	@Column(name= "State", nullable= false,columnDefinition = "nvarchar(100)")
	private String state;
	
	@OneToOne
	@JoinColumn(name = "Country")
	private CountryList countryList;

	@Column(name= "PinCode", nullable= true,columnDefinition = "nvarchar(100)")
	private String pinCode;

	@Column(name= "RWAUserId", nullable= false, columnDefinition = "nvarchar(100)")
	private String rwaUserId;

	@Column(name= "RWAPassword", nullable= false, columnDefinition = "nvarchar(100)")
	private String rwaPassword;
	
	@Column(name= "RegnAuthority", nullable= false, columnDefinition = "nvarchar(100)")
	private String regnAuthority;

	@Column(name= "RegnAuthEmail", nullable= true, columnDefinition = "nvarchar(100)")
	private String regnAuthEmail;

	@Column(name= "AthAddress", nullable= false,columnDefinition = "nvarchar(100)")
	private String athAddress;

	@Column(name= "AthSector", nullable= true, columnDefinition = "nvarchar(100)")
	private String athSector;

	@Column(name= "AthCity", nullable= false,columnDefinition = "nvarchar(100)")
	private String athCity;

	@Column(name= "AthState", nullable= false,columnDefinition = "nvarchar(100)")
	private String athState;

	@OneToOne
	@JoinColumn(name = "AthCountry")
	private CountryList athCountry;
	
	@Column(name= "AthPinCode", nullable= true,columnDefinition = "nvarchar(100)")
	private String athPinCode;

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
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public CountryList getCountryList() {
		return countryList;
	}
	public void setCountryList(CountryList countryList) {
		this.countryList = countryList;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getAthAddress() {
		return athAddress;
	}
	public void setAthAddress(String athAddress) {
		this.athAddress = athAddress;
	}
	public String getAthCity() {
		return athCity;
	}
	public void setAthCity(String athCity) {
		this.athCity = athCity;
	}
	public String getAthState() {
		return athState;
	}
	public void setAthState(String athState) {
		this.athState = athState;
	}

	public CountryList getAthCountry() {
		return athCountry;
	}
	public void setAthCountry(CountryList athCountry) {
		this.athCountry = athCountry;
	}
	public String getAthPinCode() {
		return athPinCode;
	}
	public void setAthPinCode(String athPinCode) {
		this.athPinCode = athPinCode;
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
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getAthSector() {
		return athSector;
	}
	public void setAthSector(String athSector) {
		this.athSector = athSector;
	}
	public String getRwaUserId() {
		return rwaUserId;
	}
	public void setRwaUserId(String rwaUserId) {
		this.rwaUserId = rwaUserId;
	}
	public String getRwaPassword() {
		return rwaPassword;
	}
	public void setRwaPassword(String rwaPassword) {
		this.rwaPassword = rwaPassword;
	}
	public String getRegnAuthority() {
		return regnAuthority;
	}
	public void setRegnAuthority(String regnAuthority) {
		this.regnAuthority = regnAuthority;
	}
	public String getRegnAuthEmail() {
		return regnAuthEmail;
	}
	public void setRegnAuthEmail(String regnAuthEmail) {
		this.regnAuthEmail = regnAuthEmail;
	}
	@Override
	public String toString() {
		return "RwaRegModel [regNo=" + regNo + ", status=" + status + ", regName=" + regName + ", regDate=" + regDate
				+ ", expDate=" + expDate + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", sector=" + sector + ", city=" + city + ", state=" + state
				+ ", countryList=" + countryList + ", pinCode=" + pinCode + ", rwaUserId=" + rwaUserId
				+ ", rwaPassword=" + rwaPassword + ", regnAuthority=" + regnAuthority + ", regnAuthEmail="
				+ regnAuthEmail + ", athAddress=" + athAddress + ", athSector=" + athSector + ", athCity=" + athCity
				+ ", athState=" + athState + ", athCountry=" + athCountry + ", athPinCode=" + athPinCode
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
	}
	


	
	
}




/* 
package com.rao.System.RwaReg;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.raoSystem.Utility.CountryList;
@Entity
@Table(name ="RwaRegistration")
public class RwaRegModel implements Serializable{
	
	@Id
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Id
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;
	
	@Column(name="RegName", nullable= false, columnDefinition = "nvarchar(100)")
	private String regName;
	
	
	@Column(name="RegDate", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date regDate;

	@Column(name="RegExpDate", nullable= false,columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date expDate;

	@Column(name="EmailId", nullable= false, columnDefinition = "nvarchar(100)")
	private String emailId;

	@Column(name="MobileNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String mobileNo;

	@Column(name="PhoneNo", nullable= true,columnDefinition = "nvarchar(100)")
	private String phoneNo;

	@Column(name= "Address", nullable= false,columnDefinition = "nvarchar(100)")
	private String address;

	@Column(name= "Sector", nullable= true, columnDefinition = "nvarchar(100)")
	private String sector;

	@Column(name= "City", nullable= false,columnDefinition = "nvarchar(100)")
	private String city;

	@Column(name= "State", nullable= false,columnDefinition = "nvarchar(100)")
	private String state;
	
	@OneToOne
	@JoinColumn(name = "Country")
	private CountryList countryList;

//	@Column(name= "Country", nullable= false,columnDefinition = "nvarchar(100)")
//	private String country;

	@Column(name= "PinCode", nullable= true,columnDefinition = "nvarchar(100)")
	private String pinCode;

	@Column(name= "RWAUserId", nullable= false, columnDefinition = "nvarchar(100)")
	private String rwaUserId;

	@Column(name= "RWAPassword", nullable= false, columnDefinition = "nvarchar(100)")
	private String rwaPassword;
	
	@Column(name= "RegnAuthority", nullable= false, columnDefinition = "nvarchar(100)")
	private String regnAuthority;

	@Column(name= "RegnAuthEmail", nullable= true, columnDefinition = "nvarchar(100)")
	private String regnAuthEmail;

	@Column(name= "AthAddress", nullable= false,columnDefinition = "nvarchar(100)")
	private String athAddress;

	@Column(name= "AthSector", nullable= true, columnDefinition = "nvarchar(100)")
	private String athSector;

	@Column(name= "AthCity", nullable= false,columnDefinition = "nvarchar(100)")
	private String athCity;

	@Column(name= "AthState", nullable= false,columnDefinition = "nvarchar(100)")
	private String athState;

	@Column(name= "AthCountry", nullable= false,columnDefinition = "nvarchar(100)")
	private String athCountry;

	@Column(name= "AthPinCode", nullable= true,columnDefinition = "nvarchar(100)")
	private String athPinCode;

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
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getAthAddress() {
		return athAddress;
	}
	public void setAthAddress(String athAddress) {
		this.athAddress = athAddress;
	}
	public String getAthCity() {
		return athCity;
	}
	public void setAthCity(String athCity) {
		this.athCity = athCity;
	}
	public String getAthState() {
		return athState;
	}
	public void setAthState(String athState) {
		this.athState = athState;
	}
	public String getAthCountry() {
		return athCountry;
	}
	public void setAthCountry(String athCountry) {
		this.athCountry = athCountry;
	}
	public String getAthPinCode() {
		return athPinCode;
	}
	public void setAthPinCode(String athPinCode) {
		this.athPinCode = athPinCode;
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
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getAthSector() {
		return athSector;
	}
	public void setAthSector(String athSector) {
		this.athSector = athSector;
	}
	public String getRwaUserId() {
		return rwaUserId;
	}
	public void setRwaUserId(String rwaUserId) {
		this.rwaUserId = rwaUserId;
	}
	public String getRwaPassword() {
		return rwaPassword;
	}
	public void setRwaPassword(String rwaPassword) {
		this.rwaPassword = rwaPassword;
	}
	public String getRegnAuthority() {
		return regnAuthority;
	}
	public void setRegnAuthority(String regnAuthority) {
		this.regnAuthority = regnAuthority;
	}
	public String getRegnAuthEmail() {
		return regnAuthEmail;
	}
	public void setRegnAuthEmail(String regnAuthEmail) {
		this.regnAuthEmail = regnAuthEmail;
	}
	
	public CountryList getCountryList() {
		return countryList;
	}
	public void setCountryList(CountryList countryList) {
		this.countryList = countryList;
	}

	
	@Override
	public String toString() {
		return "RwaRegModel [regNo=" + regNo + ", status=" + status + ", regName=" + regName + ", regDate=" + regDate
				+ ", expDate=" + expDate + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", sector=" + sector + ", city=" + city + ", state=" + state
				+ ", countryList=" + countryList + ", pinCode=" + pinCode + ", rwaUserId=" + rwaUserId
				+ ", rwaPassword=" + rwaPassword + ", regnAuthority=" + regnAuthority + ", regnAuthEmail="
				+ regnAuthEmail + ", athAddress=" + athAddress + ", athSector=" + athSector + ", athCity=" + athCity
				+ ", athState=" + athState + ", athCountry=" + athCountry + ", athPinCode=" + athPinCode
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + "]";
	}
	
//	@Override
//	public String toString() {
//		return "RwaRegModel [regNo=" + regNo + ", status=" + status + ", regName=" + regName + ", regDate=" + regDate
//				+ ", expDate=" + expDate + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", phoneNo=" + phoneNo
//				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", pinCode="
//				+ pinCode + ", athAddress=" + athAddress + ", athCity=" + athCity + ", athState=" + athState
//				+ ", athCountry=" + athCountry + ", athPinCode=" + athPinCode + ", createdBy=" + createdBy
//				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", sector="
//				+ sector + ", athSector=" + athSector + ", rwaUserId=" + rwaUserId + ", rwaPassword=" + rwaPassword
//				+ ", regnAuthority=" + regnAuthority + ", regnAuthEmail=" + regnAuthEmail + "]";
//	}
	
	
}
*/