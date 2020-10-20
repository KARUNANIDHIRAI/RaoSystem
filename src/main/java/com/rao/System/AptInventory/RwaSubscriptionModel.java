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
@Table(name= "kRWASubscription")
public class RwaSubscriptionModel implements Serializable {
	
	@Column(name ="IDNO", nullable=false, columnDefinition = "int", updatable = false)
	private int iDNO;
				 
	@Id
	@Column(name ="RwaRegNo", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String rwaRegNo;
	
	@Id
	@Column(name ="SubscriptionType", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String subscriptionType;
	@Id
	@Column(name ="EffectiveDate", nullable=false, columnDefinition = "date", updatable = false)
	@Temporal(value = TemporalType.DATE)
	private Date effectiveDate;
	
	@Id
	@Column(name ="Subscription", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String subscription;
	
	@Column(name ="SubscriptionAmt", nullable=false, columnDefinition = "integer", updatable = false)
	private int subscriptionAmt;
	
	@Column(name ="ExpenseType", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String expenseType;
	
	
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
	
	

	/**
	 * 
	 */
	public RwaSubscriptionModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param iDNO
	 * @param rwaRegNo
	 * @param createdBy
	 */
	public RwaSubscriptionModel(int iDNO, String rwaRegNo, String createdBy) {
		super();
		this.iDNO = iDNO;
		this.rwaRegNo = rwaRegNo;
		CreatedBy = createdBy;
	}


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

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public int getSubscriptionAmt() {
		return subscriptionAmt;
	}

	public void setSubscriptionAmt(int subscriptionAmt) {
		this.subscriptionAmt = subscriptionAmt;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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
		return "RwaSubscriptionModel [iDNO=" + iDNO + ", rwaRegNo=" + rwaRegNo + ", subscriptionType="
				+ subscriptionType + ", effectiveDate=" + effectiveDate + ", subscription=" + subscription
				+ ", subscriptionAmt=" + subscriptionAmt + ", expenseType=" + expenseType + ", Status=" + Status
				+ ", CreatedOn=" + CreatedOn + ", CreatedBy=" + CreatedBy + ", UpdatedOn=" + UpdatedOn + ", UpdatedBy="
				+ UpdatedBy + "]";
	}
}
