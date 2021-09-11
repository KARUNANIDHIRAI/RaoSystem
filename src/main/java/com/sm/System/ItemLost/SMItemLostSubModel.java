package com.sm.System.ItemLost;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ColumnDefault;
import com.sm.System.SMUtility.SMDataCreatedUpdated;

@Entity
@Table(name ="SMItemLost")
public class SMItemLostSubModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@Column(name="RegNO", nullable= false , updatable = false)
	private String regNo;
	
	@Column(name="AdmNo", nullable= false , updatable = false)
	private String admNo;

	@Column(name="ItemCode", nullable= false , updatable = false)
	private String ItemCode;

	@Column(name="LostDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date lostDate;

	@Column(name="LostQty", nullable= false , updatable = true)
	private int lostQty;

	@Column(name="ItemAmount", nullable= true , updatable = true)
	private int itemAmount;

	@Column(name="PenaltyAmount", nullable= true , updatable = true)
	private float penaltyAmount;
	
	@Column(name="Status", nullable= false)
	@ColumnDefault(value= "'A'") // A=Active status
	private String status;
	
	@Column(name = "FacultyCodeFK", nullable = false, updatable = true)
	private int FacultyCodeFK;

	@Column(name = "SMITBiDNOFK", nullable = false, updatable = true)
	private int smITBiDNOFK;

	@Column(name = "ItemCodeFK", nullable = false, updatable = true)
	private int ItemCodeFK;

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

	public String getItemCode() {
		return ItemCode;
	}

	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}

	public int getLostQty() {
		return lostQty;
	}

	public void setLostQty(int lostQty) {
		this.lostQty = lostQty;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
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

	public int getFacultyCodeFK() {
		return FacultyCodeFK;
	}

	public void setFacultyCodeFK(int facultyCodeFK) {
		FacultyCodeFK = facultyCodeFK;
	}

	public int getSmITBiDNOFK() {
		return smITBiDNOFK;
	}

	public void setSmITBiDNOFK(int smITBiDNOFK) {
		this.smITBiDNOFK = smITBiDNOFK;
	}

	public int getItemCodeFK() {
		return ItemCodeFK;
	}

	public void setItemCodeFK(int itemCodeFK) {
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
		return "SMItemLostSubModel [iDNO=" + iDNO + ", regNo=" + regNo + ", admNo=" + admNo + ", ItemCode=" + ItemCode
				+ ", lostDate=" + lostDate + ", lostQty=" + lostQty + ", itemAmount=" + itemAmount + ", penaltyAmount="
				+ penaltyAmount + ", status=" + status + ", FacultyCodeFK=" + FacultyCodeFK + ", smITBiDNOFK="
				+ smITBiDNOFK + ", ItemCodeFK=" + ItemCodeFK + ", userRefInfo=" + userRefInfo + "]";
	}


}
