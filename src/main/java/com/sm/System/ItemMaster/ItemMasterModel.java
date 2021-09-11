package com.sm.System.ItemMaster;

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
@Table(name = "SMItemMaster")
public class ItemMasterModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO", nullable = false, updatable = false)
	private Integer iDNO;

	@Column(name = "RegNO", nullable = false, updatable = false)
	private String regNo;

	@Column(name = "Code", nullable = false, updatable = false)
	private String code;

	@Column(name = "Name", nullable = false, updatable = true)
	private String name;

	@Column(name = "ItemCategory", nullable = false, updatable = true)
	private String itemCategory;

	@Column(name = "Status", nullable = false, updatable = false)
	private String status;

	@Column(name = "CreatedBy", nullable = false, updatable = false, columnDefinition = "nvarchar(100)")
	private String createdBy;

	@Column(name = "CreatedOn", nullable = false, updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UpdatedBy", nullable = false, columnDefinition = "nvarchar(100)")
	private String updatedBy;

	@Column(name = "UpdatedOn", nullable = false, columnDefinition = "date")
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
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

	@Override
	public String toString() {
		return "ItemMasterModel [iDNO=" + iDNO + ", regNo=" + regNo + ", code=" + code + ", name=" + name
				+ ", itemCategory=" + itemCategory + ", status=" + status + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", getiDNO()=" + getiDNO()
				+ ", getRegNo()=" + getRegNo() + ", getCode()=" + getCode() + ", getName()=" + getName()
				+ ", getItemCategory()=" + getItemCategory() + ", getStatus()=" + getStatus() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCreatedOn()=" + getCreatedOn() + ", getUpdatedBy()=" + getUpdatedBy()
				+ ", getUpdatedOn()=" + getUpdatedOn() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
