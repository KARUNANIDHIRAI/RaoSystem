package com.sm.StudentFeePayment;

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



@Entity
@Table(name ="SMFeePayment")
public class SFeePayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SFIDNO", nullable= false , updatable = false)
	private Integer sFIDNO;

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="AdmNo", nullable= false)
	private String admNo;
	
	@Column(name="SClass", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String sClass;

	@Column(name="RollNo", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String rollNo;

	@Column(name="FeePayDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date feePayDate;
	
	@Column(name="DepositorName", nullable= false, columnDefinition = "nvarchar(100)")
	private String depositorName;
	
	@Column(name="DepositorIdNo", nullable= false, columnDefinition = "nvarchar(100)")
	private String depositorIdNo;

	@Column(name="DepositorPanNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String depositorPanNo;

	@Column(name="DepositorMobileNo", nullable= false,columnDefinition = "nvarchar(100)")
	private String depositorMobileNo;


	@Column(name="MOP", nullable= false,columnDefinition = "nvarchar(100)")
	private String mOP;

	@Column(name="FeePaid", nullable= false,columnDefinition = "Integer")
	private Integer feePaid;
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "SFeePay")
	private List<FeeChqDDPayment> FChqDDPayment= new ArrayList<>();	
	
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

	public Integer getsFIDNO() {
		return sFIDNO;
	}

	public void setsFIDNO(Integer sFIDNO) {
		this.sFIDNO = sFIDNO;
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

	public Date getFeePayDate() {
		return feePayDate;
	}

	public void setFeePayDate(Date feePayDate) {
		this.feePayDate = feePayDate;
	}

	public String getDepositorName() {
		return depositorName;
	}

	public void setDepositorName(String depositorName) {
		this.depositorName = depositorName;
	}

	public String getDepositorIdNo() {
		return depositorIdNo;
	}

	public void setDepositorIdNo(String depositorIdNo) {
		this.depositorIdNo = depositorIdNo;
	}

	public String getDepositorPanNo() {
		return depositorPanNo;
	}

	public void setDepositorPanNo(String depositorPanNo) {
		this.depositorPanNo = depositorPanNo;
	}

	public String getDepositorMobileNo() {
		return depositorMobileNo;
	}

	public void setDepositorMobileNo(String depositorMobileNo) {
		this.depositorMobileNo = depositorMobileNo;
	}

	public String getmOP() {
		return mOP;
	}

	public void setmOP(String mOP) {
		this.mOP = mOP;
	}

	public Integer getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(Integer feePaid) {
		this.feePaid = feePaid;
	}

	public List<FeeChqDDPayment> getFChqDDPayment() {
		return FChqDDPayment;
	}

	public void setFChqDDPayment(List<FeeChqDDPayment> fChqDDPayment) {
		FChqDDPayment = fChqDDPayment;
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


}
