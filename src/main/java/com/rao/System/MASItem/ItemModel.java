package com.rao.System.MASItem;

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
@Table(name = "MasItem")
public class ItemModel implements Serializable {
	
	@Column(name ="IDNO", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String iDNO;
	
	@Id
	@Column(name ="RwaRegNo", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String RwaRegNo;
	
	@Id
	@Column(name ="ItemCode", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String ICode;
	
	@Column(name ="ItemName", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String IName;
	
	@Column(name ="MinLevel", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private int MinLevel;
	
	@Column(name ="MaxLevel", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private int Maxlevel;
	
	@Column(name ="ReorderLevel", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private int ReOrderLevel;
	
//	@Column(name ="ActionType", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
//	private String ActionType;
	
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
	
	

	public String getiDNO() {
		return iDNO;
	}

	public void setiDNO(String iDNO) {
		this.iDNO = iDNO;
	}

	public String getRwaRegNo() {
		return RwaRegNo;
	}

	public void setRwaRegNo(String rwaRegNo) {
		RwaRegNo = rwaRegNo;
	}

	public String getICode() {
		return ICode;
	}

	public void setICode(String iCode) {
		ICode = iCode;
	}

	public String getIName() {
		return IName;
	}

	public void setIName(String iName) {
		IName = iName;
	}

	public int getMinLevel() {
		return MinLevel;
	}

	public void setMinLevel(int minLevel) {
		MinLevel = minLevel;
	}

	public int getMaxlevel() {
		return Maxlevel;
	}

	public void setMaxlevel(int maxlevel) {
		Maxlevel = maxlevel;
	}

	public int getReOrderLevel() {
		return ReOrderLevel;
	}

	public void setReOrderLevel(int reOrderLevel) {
		ReOrderLevel = reOrderLevel;
	}
/*
	public String getActionType() {
		return ActionType;
	}

	public void setActionType(String actionType) {
		ActionType = actionType;
	}
*/
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
		return "ItemModel [iDNO=" + iDNO + ", RwaRegNo=" + RwaRegNo + ", ICode=" + ICode + ", IName=" + IName
				+ ", MinLevel=" + MinLevel + ", Maxlevel=" + Maxlevel + ", ReOrderLevel=" + ReOrderLevel + ", Status="
				+ Status + ", CreatedOn=" + CreatedOn + ", CreatedBy=" + CreatedBy + ", UpdatedOn=" + UpdatedOn
				+ ", UpdatedBy=" + UpdatedBy + "]";
	}


	
}
