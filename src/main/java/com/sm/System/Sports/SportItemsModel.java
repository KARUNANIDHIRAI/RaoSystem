package com.sm.System.Sports;
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

import com.Sprots.System.SportItemMaster.ItemMasterModel;

@Entity
@Table(name = "SMSportItemMasterOPCLQty")
public class SportItemsModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "SAIDNO", nullable = false, updatable = false)
		private long IDNO;

		@Column(name = "RegNO", nullable = false)
		private String regNo;

		@Column(name = "ItemCode", nullable = false)
		private String ItemCode;

		@Column(name = "OpBalQty", nullable = true)
		private int opBalQty;

		@Column(name = "ClBalQty", nullable = true)
		private int clBalQty;

		@Column(name = "IssueQty", nullable = true)
		private int issueQty;

		@Column(name = "ReturnQty", nullable = true)
		private int returnQty;

		@Column(name = "Status", nullable = false)
		private String status;

		@Column(name = "CreatedBy", nullable = false)
		private String createdBy;

		@Column(name = "CreatedOn", nullable = false)
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date createdOn;

		@Column(name = "UpdatedBy", nullable = false)
		private String updatedBy;

		@Column(name = "UpdatededOn", nullable = false)
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date updatedOn;

		@OneToOne
		@JoinColumn(name = "IdNoFK")
		private ItemMasterModel itemMasterModelFK;

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
			return ItemCode;
		}

		public void setItemCode(String itemCode) {
			ItemCode = itemCode;
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

		public ItemMasterModel getItemMasterModelFK() {
			return itemMasterModelFK;
		}

		public void setItemMasterModelFK(ItemMasterModel itemMasterModelFK) {
			this.itemMasterModelFK = itemMasterModelFK;
		}

		@Override
		public String toString() {
			return "SportItemsModel [IDNO=" + IDNO + ", regNo=" + regNo + ", ItemCode=" + ItemCode + ", opBalQty="
					+ opBalQty + ", clBalQty=" + clBalQty + ", issueQty=" + issueQty + ", returnQty=" + returnQty
					+ ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
					+ updatedBy + ", updatedOn=" + updatedOn + ", itemMasterModelFK=" + itemMasterModelFK + "]";
		}

	}

	@Entity
	@Table(name = "SMSportItemMasterOPCLQty")
	class SportItemsSubModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "SAIDNO", nullable = false, updatable = false)
		private long IDNO;

		@Column(name = "RegNO", nullable = false)
		private String regNo;

		@Column(name = "ItemCode", nullable = false)
		private String ItemCode;

		@Column(name = "OpBalQty", nullable = true)
		private int opBalQty;

		@Column(name = "ClBalQty", nullable = true)
		private int clBalQty;

		@Column(name = "IssueQty", nullable = true)
		private int issueQty;

		@Column(name = "ReturnQty", nullable = true)
		private int returnQty;

		@Column(name = "Status", nullable = false)
		private String status;

		@Column(name = "CreatedBy", nullable = false)
		private String createdBy;

		@Column(name = "CreatedOn", nullable = false)
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date createdOn;

		@Column(name = "UpdatedBy", nullable = false)
		private String updatedBy;

		@Column(name = "UpdatededOn", nullable = false)
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date updatedOn;

		@Column(name = "IdNoFK", nullable = false)
		private int IdNoFK;

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
			return ItemCode;
		}

		public void setItemCode(String itemCode) {
			ItemCode = itemCode;
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

		public int getIdNoFK() {
			return IdNoFK;
		}

		public void setIdNoFK(int idNoFK) {
			IdNoFK = idNoFK;
		}

		@Override
		public String toString() {
			return "SportItemsSubModel [IDNO=" + IDNO + ", regNo=" + regNo + ", ItemCode=" + ItemCode + ", opBalQty="
					+ opBalQty + ", clBalQty=" + clBalQty + ", issueQty=" + issueQty + ", returnQty=" + returnQty
					+ ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
					+ updatedBy + ", updatedOn=" + updatedOn + ", IdNoFK=" + IdNoFK + "]";
		}

	

}
