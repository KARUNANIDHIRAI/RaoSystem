package com.SLIBM.System.BooksBorrowedReturn;

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

import com.SLIBM.System.BooksIssue.BooksBorrowModel;

@Entity
@Table(name ="LBBooksBorrowedReturn")

public class BookBorrowedReturnModel extends UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@Column(name="RegNO", nullable= false )
	private String regNo;
	
	@Column(name="AdmNo", nullable= false )
	private String admNo;

	@Column(name="FacultyCode", nullable= false )
	private String facultyCode;
	
	@Column(name="BookTakenBy", nullable= false)
	private String bookTakenBy;

	@Column(name="BookCode", nullable= false )
	private String bookCode;
	
//	@Column(name="BookName", nullable= false )
//	private String bookName;

	@Column(name="BorrowRetrunDate", nullable= false )
	@Temporal(TemporalType.DATE)
	private Date borrowRetrunDate;

	@Column(name="NoOfCopyReturn", nullable= false )
	private int noOfCopyReturn;

	@Column(name="LateFee", nullable= false )
	private float lateFee;

	@Column(name="Status", nullable= true,columnDefinition = "nvarchar(100)")
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

	@OneToOne
	@JoinColumn(name="BKBRIDNOFK")
	private BooksBorrowModel  booksBorrowModel;

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

	public String getBookTakenBy() {
		return bookTakenBy;
	}

	public void setBookTakenBy(String bookTakenBy) {
		this.bookTakenBy = bookTakenBy;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public Date getBorrowRetrunDate() {
		return borrowRetrunDate;
	}

	public void setBorrowRetrunDate(Date borrowRetrunDate) {
		this.borrowRetrunDate = borrowRetrunDate;
	}

	public int getNoOfCopyReturn() {
		return noOfCopyReturn;
	}

	public void setNoOfCopyReturn(int noOfCopyReturn) {
		this.noOfCopyReturn = noOfCopyReturn;
	}

	public float getLateFee() {
		return lateFee;
	}

	public void setLateFee(float lateFee) {
		this.lateFee = lateFee;
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

	public BooksBorrowModel getBooksBorrowModel() {
		return booksBorrowModel;
	}

	public void setBooksBorrowModel(BooksBorrowModel booksBorrowModel) {
		this.booksBorrowModel = booksBorrowModel;
	}

	@Override
	public String toString() {
		return "BookBorrowedReturnModel [iDNO=" + iDNO + ", regNo=" + regNo + ", admNo=" + admNo + ", facultyCode="
				+ facultyCode + ", bookTakenBy=" + bookTakenBy + ", bookCode=" + bookCode + ", borrowRetrunDate="
				+ borrowRetrunDate + ", noOfCopyReturn=" + noOfCopyReturn + ", lateFee=" + lateFee + ", status="
				+ status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + ", booksBorrowModel=" + booksBorrowModel + "]";
	}



}
