package com.SLIBM.System.BooksMaster;

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
@Table(name="LBBookMasterQty")
public class BooksMasterQtyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="BookCode", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String bookCode;

	@Column(name="OpeningBooksQty", nullable= true , updatable = true)
	private int openingBooksQty;

	@Column(name="TotalBooksQty", nullable= true , updatable = true)
	private int TotalBooksQty;

	@Column(name="ClosingBooksQty", nullable= true , updatable = true)
	private int closingBooksQty;
	
	@Column(name="TmpClosingBooksQty", nullable= true , updatable = true)
	private int tmpClosingBooksQty;

	@Column(name="IssueBooksQty", nullable= true , updatable = true)
	private int issueBooksQty;
	
	@Column(name="TmpIssueBooksQty", nullable= true , updatable = true)
	private int TmpIssueBooksQty;

	@Column(name="ReturnBooksQty", nullable= true , updatable = true)
	private int returnBooksQty;
	
	@Column(name="TmpReturnBooksQty", nullable= true , updatable = true)
	private int tmpReturnBooksQty;

	@Column(name= "UpdatedBy", nullable= false,columnDefinition = "nvarchar(100)")
	private String updatedBy;

	@Column(name= "UpdatedOn", nullable= false,columnDefinition = "date")
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

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public int getOpeningBooksQty() {
		return openingBooksQty;
	}

	public void setOpeningBooksQty(int openingBooksQty) {
		this.openingBooksQty = openingBooksQty;
	}

	public int getTotalBooksQty() {
		return TotalBooksQty;
	}

	public void setTotalBooksQty(int totalBooksQty) {
		TotalBooksQty = totalBooksQty;
	}

	public int getClosingBooksQty() {
		return closingBooksQty;
	}

	public void setClosingBooksQty(int closingBooksQty) {
		this.closingBooksQty = closingBooksQty;
	}

	public int getTmpClosingBooksQty() {
		return tmpClosingBooksQty;
	}

	public void setTmpClosingBooksQty(int tmpClosingBooksQty) {
		this.tmpClosingBooksQty = tmpClosingBooksQty;
	}

	public int getIssueBooksQty() {
		return issueBooksQty;
	}

	public void setIssueBooksQty(int issueBooksQty) {
		this.issueBooksQty = issueBooksQty;
	}

	public int getTmpIssueBooksQty() {
		return TmpIssueBooksQty;
	}

	public void setTmpIssueBooksQty(int tmpIssueBooksQty) {
		TmpIssueBooksQty = tmpIssueBooksQty;
	}

	public int getReturnBooksQty() {
		return returnBooksQty;
	}

	public void setReturnBooksQty(int returnBooksQty) {
		this.returnBooksQty = returnBooksQty;
	}

	public int getTmpReturnBooksQty() {
		return tmpReturnBooksQty;
	}

	public void setTmpReturnBooksQty(int tmpReturnBooksQty) {
		this.tmpReturnBooksQty = tmpReturnBooksQty;
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
		return "BooksMasterQtyModel [iDNO=" + iDNO + ", regNo=" + regNo + ", bookCode=" + bookCode
				+ ", openingBooksQty=" + openingBooksQty + ", TotalBooksQty=" + TotalBooksQty + ", closingBooksQty="
				+ closingBooksQty + ", tmpClosingBooksQty=" + tmpClosingBooksQty + ", issueBooksQty=" + issueBooksQty
				+ ", TmpIssueBooksQty=" + TmpIssueBooksQty + ", returnBooksQty=" + returnBooksQty
				+ ", tmpReturnBooksQty=" + tmpReturnBooksQty + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}


}
