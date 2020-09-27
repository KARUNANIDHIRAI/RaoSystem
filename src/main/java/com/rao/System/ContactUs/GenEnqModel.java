package com.rao.System.ContactUs;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;;

@Entity 
@Table(name = "GeneralEnquiry")
public class GenEnqModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "UID")
	private int UID;
	String	Title;
	String	FName;
	String	LName;
	String	EmailId;
	String	CompanyName;
	String	CountryName;
	String	City;
	String	PinCode;
	String	MobileNo;
	String	EnquiryMsg;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
	public String getEnquiryMsg() {
		return EnquiryMsg;
	}
	public void setEnquiryMsg(String enquiryMsg) {
		EnquiryMsg = enquiryMsg;
	}
	@Override
	public String toString() {
		return "GenEnqModel [Title=" + Title + ", FName=" + FName + ", LName=" + LName + ", EmailId=" + EmailId
				+ ", CompanyName=" + CompanyName + ", CountryName=" + CountryName + ", City=" + City + ", PinCode="
				+ PinCode + ", MobileNo=" + MobileNo + ", EnquiryMsg=" + EnquiryMsg + "]";
	}
	
	
}
