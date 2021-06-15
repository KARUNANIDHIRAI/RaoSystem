package com.SLIBM.System.BooksIssue;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name ="LBBooksBorrow")
public class BooksBorrowModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@Column(name="RegNO", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="AdmNo", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String admNo;

	@Column(name="FacultyCode", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String facultyCode;
	
	@Column(name="IssuedBy", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String issuedBy;

	@Column(name="BookCode", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String bookCode;
	
	@Column(name="BookName", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String bookName;

	@Column(name="BorrowFromDate", nullable= true , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date borrowFromDate;
	
	@Column(name="BorrowToDate", nullable= true , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date BorrowToDate;

	@Column(name="ActualReturnDate", nullable= true , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date actualReturnDate;

	@Column(name="NoOfCopyIssued", nullable= true , updatable = true, columnDefinition = "Integer")
	private int noOfCopyIssued;

	@Column(name="PenaltyAmount", nullable= true , updatable = true)
	private float penaltyAmount;

	@Column(name="Status", nullable= true,columnDefinition = "nvarchar(100) ")
	@ColumnDefault(value="P")
	private String status;
	
	@Column(name="BorrowedRetStatus", nullable= true,columnDefinition = "nvarchar(100) ")
	@ColumnDefault(value="P")
	private String borrowedRetStatus;
	
	@Column(name= "CreatedBy", nullable= true,updatable = false, columnDefinition = "nvarchar(100)")
	private String createdBy;

	@Column(name= "CreatedOn", nullable= true,updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name= "UpdatedBy", nullable= true,columnDefinition = "nvarchar(100)")
	private String updatedBy;

	@Column(name= "UpdatedOn", nullable= true,columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public Integer getiDNO() {
		return iDNO;
	}

	public void setiDNO(Integer iDNO) {
		this.iDNO = iDNO;
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

	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getBorrowFromDate() {
		return borrowFromDate;
	}

	public void setBorrowFromDate(Date borrowFromDate) {
		this.borrowFromDate = borrowFromDate;
	}

	public Date getBorrowToDate() {
		return BorrowToDate;
	}

	public void setBorrowToDate(Date borrowToDate) {
		BorrowToDate = borrowToDate;
	}

	public Date getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public int getNoOfCopyIssued() {
		return noOfCopyIssued;
	}

	public void setNoOfCopyIssued(int noOfCopyIssued) {
		this.noOfCopyIssued = noOfCopyIssued;
	}

	public float getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(float penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	


	public String getBorrowedRetStatus() {
		return borrowedRetStatus;
	}

	public void setBorrowedRetStatus(String borrowedRetStatus) {
		this.borrowedRetStatus = borrowedRetStatus;
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
		return "BooksBorrowModel [iDNO=" + iDNO + ", regNo=" + regNo + ", admNo=" + admNo + ", facultyCode="
				+ facultyCode + ", issuedBy=" + issuedBy + ", bookCode=" + bookCode + ", bookName=" + bookName
				+ ", borrowFromDate=" + borrowFromDate + ", BorrowToDate=" + BorrowToDate + ", actualReturnDate="
				+ actualReturnDate + ", noOfCopyIssued=" + noOfCopyIssued + ", penaltyAmount=" + penaltyAmount
				+ ", status=" + status + ", borrowedStatus=" + borrowedRetStatus + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}


}	