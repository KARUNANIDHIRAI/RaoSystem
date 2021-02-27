package com.sm.System.SchoolInformation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.raoSystem.Utility.CountryList;

	/**
	 * @author KN RAI
	 *
	 */
	@Entity 
	@Table(name = "SMAddress")
	public class Address implements Serializable {
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name = "IDNO")
			private Integer idno;
			
			@OneToOne
			@JoinColumn(name = "RegNO")
			private SchoolInfoModel schAddress;
			
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

			public Integer getIdno() {
				return idno;
			}

			public void setIdno(Integer idno) {
				this.idno = idno;
			}

			public SchoolInfoModel getSchAddress() {
				return schAddress;
			}

			public void setSchAddress(SchoolInfoModel schAddress) {
				this.schAddress = schAddress;
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

			@Override
			public String toString() {
				return "Address [idno=" + idno + ", schAddress=" + schAddress + ", address=" + address + ", sector="
						+ sector + ", city=" + city + ", state=" + state + ", countryList=" + countryList + ", pinCode="
						+ pinCode + ", category=" + category + "]";
			}


	}	

