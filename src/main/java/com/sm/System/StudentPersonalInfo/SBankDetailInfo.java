package com.sm.System.StudentPersonalInfo;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
	@Table(name ="SMStudentBankDetail")
	public class SBankDetailInfo  implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="IdNo", nullable= false , updatable = false)
		private Integer idNo;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="sIdNo")
		private StudentPersonalInfoModel studentBankDetails;
		
		@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
		private String regNo;
		
		@Column(name="ACHolderName", nullable= false, columnDefinition = "nvarchar(100)")
		private String aCHolderName;

		@Column(name="AcNo", nullable= false, columnDefinition = "nvarchar(100)")
		private String acNo;

		@Column(name="Actype", nullable= false, columnDefinition = "nvarchar(100)")
		private String actype;
		
		@Column(name="BankName", nullable= false, columnDefinition = "nvarchar(100)")
		private String bankName;
		
		@Column(name="BranchName", nullable= false, columnDefinition = "nvarchar(100)")
		private String branchName;
		
		@Column(name="IFSC", nullable= true,columnDefinition = "nvarchar(100)")
		private String iFSC;

		@Column(name="City", nullable= true,columnDefinition = "nvarchar(100)")
		private String city;

		@Column(name="Country", nullable= true,columnDefinition = "nvarchar(100)")
		private String country;

		public Integer getIdNo() {
			return idNo;
		}

		public void setIdNo(Integer idNo) {
			this.idNo = idNo;
		}

		public StudentPersonalInfoModel getStudentBankDetails() {
			return studentBankDetails;
		}

		public void setStudentBankDetails(StudentPersonalInfoModel studentBankDetails) {
			this.studentBankDetails = studentBankDetails;
		}

		public String getRegNo() {
			return regNo;
		}

		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}

		public String getaCHolderName() {
			return aCHolderName;
		}

		public void setaCHolderName(String aCHolderName) {
			this.aCHolderName = aCHolderName;
		}

		public String getAcNo() {
			return acNo;
		}

		public void setAcNo(String acNo) {
			this.acNo = acNo;
		}

		public String getActype() {
			return actype;
		}

		public void setActype(String actype) {
			this.actype = actype;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public String getiFSC() {
			return iFSC;
		}

		public void setiFSC(String iFSC) {
			this.iFSC = iFSC;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}


	}
