package com.rao.System.ContactUs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;



@Entity
@Table(name="BusinessEnquiry")
public class BusEnqModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UID")
	private int UID; 
	@Column(nullable = false)
	private String Title   = null;
	private String FName   = null;
	private String LName   = null;
	private String EmailId = null;
	private String CompanyName = null;
	@Column(nullable = false)
	private String CountryName = null;
	@Column(nullable = false)
	private String City    = null;
	private String PinCode = null;
	@Column(nullable = false)
	private String MobileNo= null;
	private String IndustryTraining = null;
	private String ConsumerProduct = null;
	private String BusinessSolution = null;
	private String DrivingTechnlogy = null;
	private String TechnologyExpert = null;
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
	public String getIndustryTraining() {
		return IndustryTraining;
	}
	public void setIndustryTraining(String industryTraining) {
		IndustryTraining = industryTraining;
	}
	public String getConsumerProduct() {
		return ConsumerProduct;
	}
	public void setConsumerProduct(String consumerProduct) {
		ConsumerProduct = consumerProduct;
	}
	public String getBusinessSolution() {
		return BusinessSolution;
	}
	public void setBusinessSolution(String businessSolution) {
		BusinessSolution = businessSolution;
	}
	public String getDrivingTechnlogy() {
		return DrivingTechnlogy;
	}
	public void setDrivingTechnlogy(String drivingTechnlogy) {
		DrivingTechnlogy = drivingTechnlogy;
	}
	public String getTechnologyExpert() {
		return TechnologyExpert;
	}
	public void setTechnologyExpert(String technologyExpert) {
		TechnologyExpert = technologyExpert;
	}
	public String getEnquiryMsg() {
		return EnquiryMsg;
	}
	public void setEnquiryMsg(String enquiryMsg) {
		EnquiryMsg = enquiryMsg;
	}
	@Override
	public String toString() {
		return "BusEnqModel [Title=" + Title + ", FName=" + FName + ", LName=" + LName + ", EmailId=" + EmailId
				+ ", CompanyName=" + CompanyName + ", CountryName=" + CountryName + ", City=" + City + ", PinCode="
				+ PinCode + ", MobileNo=" + MobileNo + ", IndustryTraining=" + IndustryTraining + ", ConsumerProduct="
				+ ConsumerProduct + ", BusinessSolution=" + BusinessSolution + ", DrivingTechnlogy=" + DrivingTechnlogy
				+ ", TechnologyExpert=" + TechnologyExpert + ", EnquiryMsg=" + EnquiryMsg + "]";
	}
	
}
