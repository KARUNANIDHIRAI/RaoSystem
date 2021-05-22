package com.sm.System.TimeTable;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SMTimeTableDetail")
public class TimeTableSubModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TTDIdNo", nullable= false , updatable = false, columnDefinition = "Integer")
	private Integer tTDIdNo;

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="TeacherName", nullable= false, updatable = true, columnDefinition = "nvarchar(100)")
	private String teacherName;

	@Column(name="ClassDay", nullable= false , columnDefinition = "nvarchar(20)")
	private String classDay;
	
	@Column(name = "ClassStart", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date classStart ;
	
	@Column(name = "ClassEnd", columnDefinition ="Time", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date classEnd ;

	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;

	@Column(name="TTIDNOFK")
	private Integer tTIDNOFK;

	public Integer gettTDIdNo() {
		return tTDIdNo;
	}

	public void settTDIdNo(Integer tTDIdNo) {
		this.tTDIdNo = tTDIdNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassDay() {
		return classDay;
	}

	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}

	public Date getClassStart() {
		return classStart;
	}

	public void setClassStart(Date classStart) {
		this.classStart = classStart;
	}

	public Date getClassEnd() {
		return classEnd;
	}

	public void setClassEnd(Date classEnd) {
		this.classEnd = classEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer gettTIDNOFK() {
		return tTIDNOFK;
	}

	public void settTIDNOFK(Integer tTIDNOFK) {
		this.tTIDNOFK = tTIDNOFK;
	}

	@Override
	public String toString() {
		return "TimeTableSubModel [tTDIdNo=" + tTDIdNo + ", regNo=" + regNo + ", teacherName=" + teacherName
				+ ", classDay=" + classDay + ", classStart=" + classStart + ", classEnd=" + classEnd + ", status="
				+ status + ", tTIDNOFK=" + tTIDNOFK + "]";
	}

	
}
