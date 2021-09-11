package com.sm.System.ItemBorrow;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

import com.Sprots.System.SportItemMaster.ItemMasterModel;
import com.sm.System.Faculty.FacultyMemberModel;
import com.sm.System.SMUtility.SMDataCreatedUpdated;
@Entity
@Table(name ="SMItemMasterBorrowed")
public class SMItemBorrowedModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@Column(name="RegNO", nullable= false , updatable = false)
	private String regNo;
	
	@Column(name="AdmNo", nullable= false , updatable = false)
	private String admNo;

	@Column(name="FacultyCode", nullable= false , updatable = false)
	private String facultyCode;

	@Column(name="ItemCode", nullable= false , updatable = false)
	private String ItemCode;

	@Column(name="RollNo", nullable= true , updatable = false)
	private String rollNo;

	@Column(name="StudClass", nullable= true , updatable = false)
	private String studClass;

	@Column(name="ItemName", nullable= true , updatable = false)
	private String ItemName;

	@Column(name="BorrowFromDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date borrowFromDate;
	
	@Column(name="BorrowToDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date BorrowToDate;

	@Column(name="ReturnDate", nullable= true , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	@Column(name="ItemBorrowedQty", nullable= false , updatable = true)
	private int itemBorrowedQty;

	@Column(name="PenaltyAmount", nullable= true , updatable = true)
	private float penaltyAmount;

	@Column(name="BorrowedRetStatus", nullable= true)
	@ColumnDefault("'P'")  // Pending Status
	private String borrowedRetStatus;
	
	@Column(name="Status", nullable= false)
	@ColumnDefault("'A'") // A=Active status
	private String status;
	
	@OneToOne
	@JoinColumn(name="FacultyCodeFK", nullable= false , updatable = false)
	private FacultyMemberModel FacultyCodeFK;
	
	@OneToOne
	@JoinColumn(name="ItemCodeFK", nullable= false , updatable = false)
	private ItemMasterModel ItemCodeFK;

	@Embedded
	private SMDataCreatedUpdated userRefInfo;

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

	public String getItemCode() {
		return ItemCode;
	}

	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudClass() {
		return studClass;
	}

	public void setStudClass(String studClass) {
		this.studClass = studClass;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
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

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getItemBorrowedQty() {
		return itemBorrowedQty;
	}

	public void setItemBorrowedQty(int itemBorrowedQty) {
		this.itemBorrowedQty = itemBorrowedQty;
	}

	public float getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(float penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public String getBorrowedRetStatus() {
		return borrowedRetStatus;
	}

	public void setBorrowedRetStatus(String borrowedRetStatus) {
		this.borrowedRetStatus = borrowedRetStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FacultyMemberModel getFacultyCodeFK() {
		return FacultyCodeFK;
	}

	public void setFacultyCodeFK(FacultyMemberModel facultyCodeFK) {
		FacultyCodeFK = facultyCodeFK;
	}

	public ItemMasterModel getItemCodeFK() {
		return ItemCodeFK;
	}

	public void setItemCodeFK(ItemMasterModel itemCodeFK) {
		ItemCodeFK = itemCodeFK;
	}

	public SMDataCreatedUpdated getUserRefInfo() {
		return userRefInfo;
	}

	public void setUserRefInfo(SMDataCreatedUpdated userRefInfo) {
		this.userRefInfo = userRefInfo;
	}

	@Override
	public String toString() {
		return "SMItemBorrowedModel [iDNO=" + iDNO + ", regNo=" + regNo + ", admNo=" + admNo + ", facultyCode="
				+ facultyCode + ", ItemCode=" + ItemCode + ", rollNo=" + rollNo + ", studClass=" + studClass
				+ ", ItemName=" + ItemName + ", borrowFromDate=" + borrowFromDate + ", BorrowToDate=" + BorrowToDate
				+ ", returnDate=" + returnDate + ", itemBorrowedQty=" + itemBorrowedQty + ", penaltyAmount="
				+ penaltyAmount + ", borrowedRetStatus=" + borrowedRetStatus + ", status=" + status + ", FacultyCodeFK="
				+ FacultyCodeFK + ", ItemCodeFK=" + ItemCodeFK + ", userRefInfo=" + userRefInfo + "]";
	}

}
