package com.sm.System.Faculty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.raoSystem.Utility.CountryList;
@Entity 
@Table(name = "SMFacultyMemberAddress")
public class FacultyMemberAddressModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FMAIDNO")
	private Integer fMAIDNO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fMIDNOFK", columnDefinition = "nvarchar(255)")
	private FacultyMemberModel fMAddress;

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name= "StreetBlock", nullable= false,columnDefinition = "nvarchar(100)")
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
	
	@Column(name= "Category", nullable= false,columnDefinition = "nvarchar(100)")
	private String category;

	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;

	public Integer getfMAIDNO() {
		return fMAIDNO;
	}

	public void setfMAIDNO(Integer fMAIDNO) {
		this.fMAIDNO = fMAIDNO;
	}

	public FacultyMemberModel getfMAddress() {
		return fMAddress;
	}

	public void setfMAddress(FacultyMemberModel fMAddress) {
		this.fMAddress = fMAddress;
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

	@Override
	public String toString() {
		return "FacultyMemberAddressModel [fMAIDNO=" + fMAIDNO + ", fMAddress=" + fMAddress + ", regNo=" + regNo
				+ ", address=" + address + ", sector=" + sector + ", city=" + city + ", state=" + state
				+ ", countryList=" + countryList + ", pinCode=" + pinCode + ", category=" + category + ", status="
				+ status + "]";
	}

	

}
