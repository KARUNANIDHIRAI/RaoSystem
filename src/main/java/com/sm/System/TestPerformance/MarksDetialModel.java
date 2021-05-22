package com.sm.System.TestPerformance;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.type.BigIntegerType;

import com.sm.System.StudentPersonalInfo.SIdProof;


	@Entity
    @Table(name="SMTestMarksDetail",
            uniqueConstraints=@UniqueConstraint(columnNames={"subject", "TPIDNOFK"})
        )
	
	public class MarksDetialModel  implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="MIdNo", nullable= false , updatable = false, columnDefinition = "Integer")
		private Integer mIdNo;

		@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
		private String regNo;

		@Column(name="AdmNo", nullable= false)
		private String admNo;
		
		@Column(name="Subject", nullable= true , columnDefinition = "nvarchar(100)")
		private String subject;
		
		@Column(name="MarksObtained", nullable= false, columnDefinition = "Integer")
		private Integer marksObtained;

		@Column(name="MaxMarks", nullable= false, columnDefinition = "Integer")
		private Integer maxMarks;



		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name="TPIDNOFK")
		private TestPerformanceModel testPerformanceModel;	
		
		@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
		private String status;

		public Integer getmIdNo() {
			return mIdNo;
		}

		public void setmIdNo(Integer mIdNo) {
			this.mIdNo = mIdNo;
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

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

	/*
	 * public String getTestType() { return testType; }
	 * 
	 * public void setTestType(String testType) { this.testType = testType; }
	 * 
	 * public String getTestCycle() { return testCycle; }
	 * 
	 * public void setTestCycle(String testCycle) { this.testCycle = testCycle; }
	 */

		public Integer getMarksObtained() {
			return marksObtained;
		}

		public void setMarksObtained(Integer marksObtained) {
			this.marksObtained = marksObtained;
		}

		public Integer getMaxMarks() {
			return maxMarks;
		}

		public void setMaxMarks(Integer maxMarks) {
			this.maxMarks = maxMarks;
		}

	/*
	 * public String getTestCategory() { return testCategory; }
	 * 
	 * public void setTestCategory(String testCategory) { this.testCategory =
	 * testCategory; }
	 */

		public TestPerformanceModel getTestPerformanceModel() {
			return testPerformanceModel;
		}

		public void setTestPerformanceModel(TestPerformanceModel testPerformanceModel) {
			this.testPerformanceModel = testPerformanceModel;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		
}
