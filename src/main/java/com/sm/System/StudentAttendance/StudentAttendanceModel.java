package com.sm.System.StudentAttendance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;

@Entity
@Table(name = "SMStudentAttendance")
public class StudentAttendanceModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "SAIDNO", nullable = false, updatable = false)
	private long sAIDNO;

	@Column(name = "RegNO", nullable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name = "ClassTeacher", nullable = true, columnDefinition = "nvarchar(100)")
	private String classTeacher;

	@Column(name = "SClass", nullable = false, columnDefinition = "nvarchar(100)")
	private String sClass;

	@Column(name = "Section", nullable = false, columnDefinition = "nvarchar(100)")
	private String section;

	@Column(name = "SRollNo", nullable = true, columnDefinition = "nvarchar(100)")
	private String sRollNo;

	@Column(name = "Subject", nullable = true, columnDefinition = "nvarchar(100)")
	private String subject;

	@Column(name = "SPresentDate", columnDefinition = "Date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date SPresentDate;

	@Column(name = "Status", nullable = false, columnDefinition = "nvarchar(100)")
	private String status;

	@Column(name = "CreatedBy", columnDefinition = "nvarchar(100)", nullable = false)
	private String createdBy;

	@Column(name = "CreatedOn", columnDefinition = "nvarchar(100)", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdOn;

//		@OneToOne
//		@JoinColumn(name="SIdNoFK")
//		private StudentPersonalInfoModel sPInfoModel;

	public long getsAIDNO() {
		return sAIDNO;
	}

	public void setsAIDNO(long sAIDNO) {
		this.sAIDNO = sAIDNO;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getsRollNo() {
		return sRollNo;
	}

	public void setsRollNo(String sRollNo) {
		this.sRollNo = sRollNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getSPresentDate() {
		return SPresentDate;
	}

	public void setSPresentDate(Date sPresentDate) {
		SPresentDate = sPresentDate;
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

//		public StudentPersonalInfoModel getsPInfoModel() {
//			return sPInfoModel;
//		}
//
//		public void setsPInfoModel(StudentPersonalInfoModel sPInfoModel) {
//			this.sPInfoModel = sPInfoModel;
//		}

//		@Override
//		public String toString() {
//			return "StudentAttendanceModel [sAIDNO=" + sAIDNO + ", regNo=" + regNo + ", classTeacher=" + classTeacher
//					+ ", sClass=" + sClass + ", section=" + section + ", sRollNo=" + sRollNo + ", subject=" + subject
//					+ ", SPresentDate=" + SPresentDate + ", status=" + status + ", createdBy=" + createdBy
//					+ ", createdOn=" + createdOn + ", sPInfoModel=" + sPInfoModel + "]";
//		}

	@Override
	public String toString() {
		return "StudentAttendanceModel [sAIDNO=" + sAIDNO + ", regNo=" + regNo + ", classTeacher=" + classTeacher
				+ ", sClass=" + sClass + ", section=" + section + ", sRollNo=" + sRollNo + ", subject=" + subject
				+ ", SPresentDate=" + SPresentDate + ", status=" + status + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + "]";
	}

}
