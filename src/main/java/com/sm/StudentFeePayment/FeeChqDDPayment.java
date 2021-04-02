package com.sm.StudentFeePayment;

import java.util.Date;

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
@Table(name = "SMFeePaymentChqDD")
public class FeeChqDDPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNO")
	private Integer idNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIDNO")
	private SFeePayment SFeePay;
	
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="ChqDDNo", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String chqDDNo;

	@Column(name="IssueDate", nullable= false , updatable = false, columnDefinition = "Date")
	@Temporal(TemporalType.DATE)
	private Date issueDate;

	@Column(name="Amount", nullable= false , updatable = false, columnDefinition = "float")
	private float amount;
	
	@Column(name="Category", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String category;

	@Column(name="BankName", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String bankName;

	@Column(name="BranchName", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String branchName;

	@Column(name="IFSCode", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String iFSCode;

	@Column(name="City", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String city;
	
	@Column(name="Status", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String status;

	public Integer getIdNo() {
		return idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public SFeePayment getSFeePay() {
		return SFeePay;
	}

	public void setSFeePay(SFeePayment sFeePay) {
		SFeePay = sFeePay;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getChqDDNo() {
		return chqDDNo;
	}

	public void setChqDDNo(String chqDDNo) {
		this.chqDDNo = chqDDNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getiFSCode() {
		return iFSCode;
	}

	public void setiFSCode(String iFSCode) {
		this.iFSCode = iFSCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
