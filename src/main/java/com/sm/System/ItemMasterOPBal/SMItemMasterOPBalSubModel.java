package com.sm.System.ItemMasterOPBal;

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

import com.sm.System.SMUtility.SMDataCreatedUpdated;
@Entity
@Table(name = "SMItemMasterOPBalQty")
public class SMItemMasterOPBalSubModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "SAIDNO", nullable = false, updatable = false)
		private long OPBQIDNO;

		@Column(name = "RegNO", nullable = false)
		private String regNo;

		@Column(name = "ItemCategory", nullable = false)
		private String itemCategory;

		@Column(name = "ItemCode", nullable = false)
		private String ItemCode;

		@Column(name = "Make", nullable = true)
		private String make;

		@Column(name = "ManufYear", nullable = true)
		private String manufYear;

		@Column(name = "Expirydate", nullable = true)
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date expirydate;

		@Column(name = "OpBalQty", nullable = false)
		private int opBalQty;

		@Column(name = "Unit", nullable = true)
		private String Unit;

		@Column(name = "Price", nullable = true)
		private float price;

		@Column(name = "Status", nullable = false)
		private String status;
		
		@Embedded
		private SMDataCreatedUpdated userRefInfo;

		@Column(name = "ItemMasterIdNoFK", nullable = true)
		private int itemMasterModelFK;

		public long getOPBQIDNO() {
			return OPBQIDNO;
		}

		public void setOPBQIDNO(long oPBQIDNO) {
			OPBQIDNO = oPBQIDNO;
		}

		public String getRegNo() {
			return regNo;
		}

		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}

		public String getItemCategory() {
			return itemCategory;
		}

		public void setItemCategory(String itemCategory) {
			this.itemCategory = itemCategory;
		}

		public String getItemCode() {
			return ItemCode;
		}

		public void setItemCode(String itemCode) {
			ItemCode = itemCode;
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getManufYear() {
			return manufYear;
		}

		public void setManufYear(String manufYear) {
			this.manufYear = manufYear;
		}

		public Date getExpirydate() {
			return expirydate;
		}

		public void setExpirydate(Date expirydate) {
			this.expirydate = expirydate;
		}

		public int getOpBalQty() {
			return opBalQty;
		}

		public void setOpBalQty(int opBalQty) {
			this.opBalQty = opBalQty;
		}

		public String getUnit() {
			return Unit;
		}

		public void setUnit(String unit) {
			Unit = unit;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}


		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public SMDataCreatedUpdated getUserRefInfo() {
			return userRefInfo;
		}

		public void setUserRefInfo(SMDataCreatedUpdated userRefInfo) {
			this.userRefInfo = userRefInfo;
		}



		public int getItemMasterModelFK() {
			return itemMasterModelFK;
		}

		public void setItemMasterModelFK(int itemMasterModelFK) {
			this.itemMasterModelFK = itemMasterModelFK;
		}

		@Override
		public String toString() {
			return "SMItemMasterOPBalSubModel [OPBQIDNO=" + OPBQIDNO + ", regNo=" + regNo + ", itemCategory="
					+ itemCategory + ", ItemCode=" + ItemCode + ", make=" + make + ", manufYear=" + manufYear
					+ ", expirydate=" + expirydate + ", opBalQty=" + opBalQty + ", Unit=" + Unit + ", price=" + price
					+ ", status=" + status + ", userRefInfo=" + userRefInfo + ", itemMasterModelFK=" + itemMasterModelFK
					+ "]";
		}



}
