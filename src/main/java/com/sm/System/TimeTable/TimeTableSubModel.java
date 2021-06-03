package com.sm.System.TimeTable;

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
/*
@Entity
@Table(name="SMTimeTableDetail")
public class TimeTableSubModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TTDIdNo", nullable= false , updatable = false, columnDefinition = "Integer")
	private Integer tTDIdNo;

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="Class", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String sClass;

	@Column(name="Section", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String Section;

	@Column(name="Sbject", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String subject;

	@Column(name="TeacherName", nullable= true, updatable = true, columnDefinition = "nvarchar(100)")
	private String teacherName;

	@Column(name="Monday", nullable= false , columnDefinition = "nvarchar(20)")
	private String monday;
	
	@Column(name = "MCSTime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date mCSTime ;
	
	@Column(name = "MCETime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date mCETime ;


	@Column(name="Tueday", nullable= false , columnDefinition = "nvarchar(20)")
	private String tueday;
	
	@Column(name = "TCSTime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date tCSTime ;
	
	@Column(name = "TCETime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date tCETime ;
	
	@Column(name="Wednessday", nullable= false , columnDefinition = "nvarchar(20)")
	private String wednessday;
	
	@Column(name = "WCSTime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date wCSTime ;
	
	@Column(name = "WCETime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date wCETime ;
	
	@Column(name="Thursday", nullable= false , columnDefinition = "nvarchar(20)")
	private String thursday;
	
	@Column(name = "THCSTime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date thCSTime ;
	
	@Column(name = "THCETime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date thCETime ;

	@Column(name="Friday", nullable= false , columnDefinition = "nvarchar(20)")
	private String friday;
	
	@Column(name = "FCSTime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date fCSTime ;
	
	@Column(name = "FCETime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date fCETime ;

	@Column(name="Saturday", columnDefinition = "nvarchar(20)", nullable= true )
	private String Saturday;
	
	@Column(name = "SSTime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date sCSTime ;
	
	@Column(name = "SCETime", columnDefinition ="tTime", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date sCETime ;
	
	@Column(name= "Status", columnDefinition = "nvarchar(100)", nullable= false )
	private String status;

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

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public Date getmCSTime() {
		return mCSTime;
	}

	public void setmCSTime(Date mCSTime) {
		this.mCSTime = mCSTime;
	}

	public Date getmCETime() {
		return mCETime;
	}

	public void setmCETime(Date mCETime) {
		this.mCETime = mCETime;
	}

	public String getTueday() {
		return tueday;
	}

	public void setTueday(String tueday) {
		this.tueday = tueday;
	}

	public Date gettCSTime() {
		return tCSTime;
	}

	public void settCSTime(Date tCSTime) {
		this.tCSTime = tCSTime;
	}

	public Date gettCETime() {
		return tCETime;
	}

	public void settCETime(Date tCETime) {
		this.tCETime = tCETime;
	}

	public String getWednessday() {
		return wednessday;
	}

	public void setWednessday(String wednessday) {
		this.wednessday = wednessday;
	}

	public Date getwCSTime() {
		return wCSTime;
	}

	public void setwCSTime(Date wCSTime) {
		this.wCSTime = wCSTime;
	}

	public Date getwCETime() {
		return wCETime;
	}

	public void setwCETime(Date wCETime) {
		this.wCETime = wCETime;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public Date getThCSTime() {
		return thCSTime;
	}

	public void setThCSTime(Date thCSTime) {
		this.thCSTime = thCSTime;
	}

	public Date getThCETime() {
		return thCETime;
	}

	public void setThCETime(Date thCETime) {
		this.thCETime = thCETime;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public Date getfCSTime() {
		return fCSTime;
	}

	public void setfCSTime(Date fCSTime) {
		this.fCSTime = fCSTime;
	}

	public Date getfCETime() {
		return fCETime;
	}

	public void setfCETime(Date fCETime) {
		this.fCETime = fCETime;
	}

	public String getSaturday() {
		return Saturday;
	}

	public void setSaturday(String saturday) {
		Saturday = saturday;
	}

	public Date getsCSTime() {
		return sCSTime;
	}

	public void setsCSTime(Date sCSTime) {
		this.sCSTime = sCSTime;
	}

	public Date getsCETime() {
		return sCETime;
	}

	public void setsCETime(Date sCETime) {
		this.sCETime = sCETime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TimeTableSubModel [tTDIdNo=" + tTDIdNo + ", regNo=" + regNo + ", sClass=" + sClass + ", Section="
				+ Section + ", subject=" + subject + ", teacherName=" + teacherName + ", monday=" + monday
				+ ", mCSTime=" + mCSTime + ", mCETime=" + mCETime + ", tueday=" + tueday + ", tCSTime=" + tCSTime
				+ ", tCETime=" + tCETime + ", wednessday=" + wednessday + ", wCSTime=" + wCSTime + ", wCETime="
				+ wCETime + ", thursday=" + thursday + ", thCSTime=" + thCSTime + ", thCETime=" + thCETime + ", friday="
				+ friday + ", fCSTime=" + fCSTime + ", fCETime=" + fCETime + ", Saturday=" + Saturday + ", sCSTime="
				+ sCSTime + ", sCETime=" + sCETime + ", status=" + status + "]";
	}


	*/

