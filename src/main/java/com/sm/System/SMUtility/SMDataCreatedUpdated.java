package com.sm.System.SMUtility;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SMDataCreatedUpdated {
	
	
	@Column(name = "CreatedBy", nullable = false)
	private String createdBy;

	@Column(name = "CreatedOn", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UpdatedBy", nullable = false)
	private String updatedBy;

	@Column(name = "UpdatedOn", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
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
		return "SMDataCreatedUpdated [createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}



}
