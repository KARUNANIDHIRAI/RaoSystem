package com.sm.System.FeeDefine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sm.System.SchoolInformation.Address;
import com.sm.System.SchoolInformation.Email;
import com.sm.System.SchoolInformation.SocialMedia;

	@Entity
	@Table(name ="FeeMaster")
	public class FeeDefineModel extends CreateUpdate implements Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="FeeIDNO", nullable= false , updatable = false)
		private Integer feeidNo;
		
		@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
		private String regNo;
		
		@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
		private String status;
		
		@Column(name="FeeCategory", nullable= false, columnDefinition = "nvarchar(100)")
		private String feeCategory;
		
		@Column(name="FeeType", nullable= false,columnDefinition = "nvarchar(200)")
		private String feeType;
		
		@Column(name="FeeTenure", nullable= false,columnDefinition = "nvarchar(200)")
		private String feeTenure;
		
		@Column(name="StudentClass", nullable= false,columnDefinition = "nvarchar(200)")
		private String studentClass;


		@OneToMany(cascade = CascadeType.ALL, mappedBy="feeDefineModel")
		private List<FeePrgrammeModel> feePrgrammeModels = new ArrayList<>();


		public Integer getFeeidNo() {
			return feeidNo;
		}


		public void setFeeidNo(Integer feeidNo) {
			this.feeidNo = feeidNo;
		}


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


		public String getFeeCategory() {
			return feeCategory;
		}


		public void setFeeCategory(String feeCategory) {
			this.feeCategory = feeCategory;
		}


		public String getFeeType() {
			return feeType;
		}


		public void setFeeType(String feeType) {
			this.feeType = feeType;
		}


		public List<FeePrgrammeModel> getFeePrgrammeModels() {
			return feePrgrammeModels;
		}


		public void setFeePrgrammeModels(List<FeePrgrammeModel> feePrgrammeModels) {
			this.feePrgrammeModels = feePrgrammeModels;
		}


		public String getFeeTenure() {
			return feeTenure;
		}


		public void setFeeTenure(String feeTenure) {
			this.feeTenure = feeTenure;
		}


		public String getStudentClass() {
			return studentClass;
		}


		public void setStudentClass(String studentClass) {
			this.studentClass = studentClass;
		}


//		@Override
//		public String toString() {
//			return "FeeDefineModel [feeidNo=" + feeidNo + ", regNo=" + regNo + ", status=" + status + ", feeCategory="
//					+ feeCategory + ", feeType=" + feeType + ", feeTenure=" + feeTenure + ", studentClass="
//					+ studentClass + ", feePrgrammeModels=" + feePrgrammeModels + "]";
//		}

		
}
