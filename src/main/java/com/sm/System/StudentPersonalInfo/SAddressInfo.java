package com.sm.System.StudentPersonalInfo;

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
import com.sm.System.SchoolInformation.SchoolInfoModel;

@Entity 
@Table(name = "Studentddress")
public class SAddressInfo implements Serializable {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "IDNO")
		private Integer idno;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "sIdNo", columnDefinition = "long")
		private StudentPersonalInfo stdAddress;
		
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
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Country")
		private CountryList countryList;

		@Column(name= "PinCode", nullable= true,columnDefinition = "nvarchar(100)")
		private String pinCode;

		@Column(name= "Status", nullable= true,columnDefinition = "nvarchar(100)")
		private String status;

		public Integer getIdno() {
			return idno;
		}

		public void setIdno(Integer idno) {
			this.idno = idno;
		}

		public StudentPersonalInfo getStdAddress() {
			return stdAddress;
		}

		public void setStdAddress(StudentPersonalInfo stdAddress) {
			this.stdAddress = stdAddress;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "SAddressInfo [idno=" + idno + ", stdAddress=" + stdAddress + ", regNo=" + regNo + ", address="
					+ address + ", sector=" + sector + ", city=" + city + ", state=" + state + ", countryList="
					+ countryList + ", pinCode=" + pinCode + ", status=" + status + "]";
		}

		
}