package com.rao.System.ContactUs;


import java.sql.Timestamp;
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
@Table(name="DemoProductEnquiry")
public class PDEnqModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Code", nullable=false)
	private int Code;
	@Column(name="Title", nullable=false, length=100)
	private String title;
	@Column(name="FName", nullable=false, length=100)
	private String FName;
	@Column(name="LName", nullable=false, length=100)
	private String LName;
	@Column(name="EmailId", nullable=false, length=100)
	private String EmailId;
	@Column(name="CompanyName", nullable=true, length=100)
	private String CompanyName;
	@Column(name="Country", nullable=false, length=100)
	private String CountryName;
	@Column(name="City", nullable=false, length=100)
	private String City;
	@Column(name="PinCode", nullable=true, length=100)
	private String PinCode;
	@Column(name="MobileNo", nullable=true, length=100)
	private String MobileNo;
	@Column(name="PDEnquiry", nullable=false, length=100)
	private String Enquiry;
	@Column(name="EnquiryMsg", nullable=false, length=100)
	private String EnquiryMsg;
	@Column(name="CreatedOn", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedOn;
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEnquiry() {
		return Enquiry;
	}
	public void setEnquiry(String enquiry) {
		Enquiry = enquiry;
	}
	public String getEnquiryMsg() {
		return EnquiryMsg;
	}
	public void setEnquiryMsg(String enquiryMsg) {
		EnquiryMsg = enquiryMsg;
	}
	public Date getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(Date createdOn) {
		CreatedOn = createdOn;
	}
	@Override
	public String toString() {
		return "PDEnqModel [Code=" + Code + ", title=" + title + ", FName=" + FName + ", LName=" + LName + ", EmailId="
				+ EmailId + ", CompanyName=" + CompanyName + ", CountryName=" + CountryName + ", City=" + City
				+ ", PinCode=" + PinCode + ", MobileNo=" + MobileNo + ", Enquiry=" + Enquiry + ", EnquiryMsg="
				+ EnquiryMsg + ", CreatedOn=" + CreatedOn + "]";
	}
	
	

}
