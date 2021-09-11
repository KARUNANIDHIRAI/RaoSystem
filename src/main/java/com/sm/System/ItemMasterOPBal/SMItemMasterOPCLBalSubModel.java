package com.sm.System.ItemMasterOPBal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Sprots.System.SportItemMaster.ItemMasterModel;
import com.sm.System.SMUtility.SMDataCreatedUpdated;

@Entity
@Table(name = "SMItemMasterOPCLBalQty")
public class SMItemMasterOPCLBalSubModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "SAIDNO", nullable = false, updatable = false)
		private long IDNO;

		@Column(name = "RegNO", nullable = false)
		private String regNo;

		@Column(name = "ItemCode", nullable = false)
		private String itemCode;

		@Column(name = "OpBalQty", nullable = true)
		private int opBalQty;

		@Column(name = "ClBalQty", nullable = true)
		private int clBalQty;

		@Column(name = "IssuedQty", nullable = true)
		private int issueQty;

		@Column(name = "ReturnedQty", nullable = true)
		private int returnQty;

		@Column(name = "Status", nullable = false)
		private String status;

		@Embedded
		private SMDataCreatedUpdated userRefInfo;

		@Column(name = "ItemMasterIdNoFK", nullable = false)
		private int itemMasterModelFK;

		public long getIDNO() {
			return IDNO;
		}

		public void setIDNO(long iDNO) {
			IDNO = iDNO;
		}

		public String getRegNo() {
			return regNo;
		}

		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}

		public String getItemCode() {
			return itemCode;
		}

		public void setItemCode(String itemCode) {
			this.itemCode = itemCode;
		}

		public int getOpBalQty() {
			return opBalQty;
		}

		public void setOpBalQty(int opBalQty) {
			this.opBalQty = opBalQty;
		}

		public int getClBalQty() {
			return clBalQty;
		}

		public void setClBalQty(int clBalQty) {
			this.clBalQty = clBalQty;
		}

		public int getIssueQty() {
			return issueQty;
		}

		public void setIssueQty(int issueQty) {
			this.issueQty = issueQty;
		}

		public int getReturnQty() {
			return returnQty;
		}

		public void setReturnQty(int returnQty) {
			this.returnQty = returnQty;
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
			return "SMItemMasterOPCLBalSubModel [IDNO=" + IDNO + ", regNo=" + regNo + ", itemCode=" + itemCode
					+ ", opBalQty=" + opBalQty + ", clBalQty=" + clBalQty + ", issueQty=" + issueQty + ", returnQty="
					+ returnQty + ", status=" + status + ", userRefInfo=" + userRefInfo + ", itemMasterModelFK="
					+ itemMasterModelFK + "]";
		}


}
