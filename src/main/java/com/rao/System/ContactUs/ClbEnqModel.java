package com.rao.System.ContactUs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="CollaborationEnquiry")
public class ClbEnqModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="UID")
		private int UID; 
		@Column(nullable = false)
		private String Title       ;
		@Column(nullable = false)
		private String FName       ;
		@Column(nullable = false)
		private String LName       ;
		@Column(nullable = false)
		private String EmailId     ;
		private String CompanyName ;
		@Column(nullable = false)
		private String CountryName ;
		@Column(nullable = false)
		private String City        ;
		private String PinCode     ;
		@Column(nullable = false)
		private String MobileNo    ;
		private String Enquiry     ; 
		@Column(nullable = false)
		private String EnquiryMsg;
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
		@Override
		public String toString() {
			return "ClbEnqModel [UID=" + UID + ", Title=" + Title + ", FName=" + FName + ", LName=" + LName
					+ ", EmailId=" + EmailId + ", CompanyName=" + CompanyName + ", CountryName=" + CountryName
					+ ", City=" + City + ", PinCode=" + PinCode + ", MobileNo=" + MobileNo + ", Enquiry=" + Enquiry
					+ ", EnquiryMsg=" + EnquiryMsg + "]";
		}
		
}
