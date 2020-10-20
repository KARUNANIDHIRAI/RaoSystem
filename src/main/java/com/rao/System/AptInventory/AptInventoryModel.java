package com.rao.System.AptInventory;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "APTSummary")
public class AptInventoryModel implements Serializable {
	

		@Column(name ="IDNO", nullable=false, columnDefinition = "int", updatable = false)
		private int iDNO;
					 
		@Id
		@Column(name ="RwaRegNo", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private String rwaRegNo;
		
		@Id
		@Column(name ="TowerNo", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private String towerNo;
		@Id
		@Column(name ="FlatCategory", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private String flatCategory;
		
		@Column(name ="TotalFaltInCategory", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private int tFlatInCategory;
		
		@Column(name ="FlatNoFrom", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private String flatNoFrom;
		
		@Column(name ="FlatNoTo", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private String flatNoTo;
		
		@Column(name ="FlatSize", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
		private int flatSize;
		
		@Column(name ="Status",nullable=false, columnDefinition = "nvarchar(1)")
		@ColumnDefault(value = "'A'")
		private String Status;
		
		@Column(name ="CreatedOn", nullable=false, columnDefinition = "datetime" , updatable = false)
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date CreatedOn;
		
		@Column(name ="CreatedBy", nullable=false, columnDefinition = "nvarchar(255)", updatable = false)
		private String CreatedBy;

		@Column(name ="UpdatedOn", nullable=false, columnDefinition = "datetime")
		@Temporal(value = TemporalType.TIMESTAMP)
		private Date UpdatedOn;
		
		@Column(name ="UpdatedBy", nullable=false, columnDefinition = "nvarchar(255)")
		private String UpdatedBy;

		public int getiDNO() {
			return iDNO;
		}

		public void setiDNO(int iDNO) {
			this.iDNO = iDNO;
		}



		public String getRwaRegNo() {
			return rwaRegNo;
		}

		public void setRwaRegNo(String rwaRegNo) {
			this.rwaRegNo = rwaRegNo;
		}

		public String getTowerNo() {
			return towerNo;
		}

		public void setTowerNo(String towerNo) {
			this.towerNo = towerNo;
		}

		public String getFlatCategory() {
			return flatCategory;
		}

		public void setFlatCategory(String flatCategory) {
			this.flatCategory = flatCategory;
		}

		public int gettFlatInCategory() {
			return tFlatInCategory;
		}

		public void settFlatInCategory(int tFlatInCategory) {
			this.tFlatInCategory = tFlatInCategory;
		}

		public String getFlatNoFrom() {
			return flatNoFrom;
		}

		public void setFlatNoFrom(String flatNoFrom) {
			this.flatNoFrom = flatNoFrom;
		}

		public String getFlatNoTo() {
			return flatNoTo;
		}

		public void setFlatNoTo(String flatNoTo) {
			this.flatNoTo = flatNoTo;
		}

		public int getFlatSize() {
			return flatSize;
		}

		public void setFlatSize(int flatSize) {
			this.flatSize = flatSize;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

		public Date getCreatedOn() {
			return CreatedOn;
		}

		public void setCreatedOn(Date createdOn) {
			CreatedOn = createdOn;
		}

		public String getCreatedBy() {
			return CreatedBy;
		}

		public void setCreatedBy(String createdBy) {
			CreatedBy = createdBy;
		}

		public Date getUpdatedOn() {
			return UpdatedOn;
		}

		public void setUpdatedOn(Date updatedOn) {
			UpdatedOn = updatedOn;
		}

		public String getUpdatedBy() {
			return UpdatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			UpdatedBy = updatedBy;
		}

		@Override
		public String toString() {
			return "AptInventoryModel [iDNO=" + iDNO + ", rwaRegNo=" + rwaRegNo + ", towerNo=" + towerNo
					+ ", flatCategory=" + flatCategory + ", tFlatInCategory=" + tFlatInCategory + ", flatNoFrom="
					+ flatNoFrom + ", flatNoTo=" + flatNoTo + ", flatSize=" + flatSize + ", Status=" + Status
					+ ", CreatedOn=" + CreatedOn + ", CreatedBy=" + CreatedBy + ", UpdatedOn=" + UpdatedOn
					+ ", UpdatedBy=" + UpdatedBy + "]";
		}
}
