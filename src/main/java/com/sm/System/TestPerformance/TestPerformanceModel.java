package com.sm.System.TestPerformance;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.UniqueConstraint;

import org.hibernate.type.BigIntegerType;

import com.sm.System.StudentPersonalInfo.SBankDetailInfo;
import com.sm.System.StudentPersonalInfo.SIdProof;
import com.sm.System.StudentPersonalInfo.StudentAddress;


	@Entity
//	@Table(name ="SMTestPerforamce")
    @Table(name="SMTestPerforamce",
            uniqueConstraints= @UniqueConstraint(columnNames={"admNo", "testType","testCycle","testCategory"})
        )
	public class TestPerformanceModel  implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="TIdNo", nullable= false , updatable = false, columnDefinition = "Integer" )
		private Integer tIdNo;

		@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
		private String regNo;

		@Column(name="AdmNo", nullable= false , columnDefinition = "nvarchar(225)")
		private String admNo;
		
		@Column(name="SClass", nullable= true,columnDefinition = "nvarchar(100)")
		private String sClass;

		@Column(name="RollNo", nullable= true , columnDefinition = "nvarchar(100)")
		private String rollNo;

		@Column(name="Section", nullable= true , columnDefinition = "nvarchar(100)")
		private String section;
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "testPerformanceModel")
		private List<MarksDetialModel> marksDetialModel= new ArrayList<>();	
		
		@Column(name="TestType", nullable= false, columnDefinition = "nvarchar(100)")
		private String testType;
		
		@Column(name="TestCycle", nullable= false, columnDefinition = "nvarchar(100)")
		private String testCycle;

		@Column(name="TestCategory", nullable= false, columnDefinition = "nvarchar(100)")
		private String testCategory;

		@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
		private String status;

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

		public Integer gettIdNo() {
			return tIdNo;
		}

		public void settIdNo(Integer tIdNo) {
			this.tIdNo = tIdNo;
		}

		public String getRegNo() {
			return regNo;
		}

		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}

		public String getAdmNo() {
			return admNo;
		}

		public void setAdmNo(String admNo) {
			this.admNo = admNo;
		}

		public String getsClass() {
			return sClass;
		}

		public void setsClass(String sClass) {
			this.sClass = sClass;
		}

		public String getRollNo() {
			return rollNo;
		}

		public void setRollNo(String rollNo) {
			this.rollNo = rollNo;
		}

		public String getSection() {
			return section;
		}

		public void setSection(String section) {
			this.section = section;
		}

		public List<MarksDetialModel> getMarksDetialModel() {
			return marksDetialModel;
		}

		public void setMarksDetialModel(List<MarksDetialModel> marksDetialModel) {
			this.marksDetialModel = marksDetialModel;
		}

		public String getTestType() {
			return testType;
		}

		public void setTestType(String testType) {
			this.testType = testType;
		}

		public String getTestCycle() {
			return testCycle;
		}

		public void setTestCycle(String testCycle) {
			this.testCycle = testCycle;
		}

		public String getTestCategory() {
			return testCategory;
		}

		public void setTestCategory(String testCategory) {
			this.testCategory = testCategory;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		@Override
		public String toString() {
			return "TestPerformanceModel [tIdNo=" + tIdNo + ", regNo=" + regNo + ", admNo=" + admNo + ", sClass="
					+ sClass + ", rollNo=" + rollNo + ", section=" + section + ", marksDetialModel=" + marksDetialModel
					+ ", testType=" + testType + ", testCycle=" + testCycle + ", testCategory=" + testCategory
					+ ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
					+ updatedBy + ", updatedOn=" + updatedOn + "]";
		}

}
