package com.sm.System.SchoolInformation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AdminInfo {

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
		return "AdminInfo [createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}	
	

}
