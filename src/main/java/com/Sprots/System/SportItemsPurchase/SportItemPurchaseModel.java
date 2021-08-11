package com.Sprots.System.SportItemsPurchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.SLIBM.System.BooksPurchase.BooksPurchaseDetailModel;

@Entity
@Table(name ="SportItemsPurchase")
public class SportItemPurchaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "BKPurchase" )
	private List<BooksPurchaseDetailModel> BKPurchaseDetail = new ArrayList<>();
	
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="InvocieNo", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String invocieNo;

	@Column(name="InvoiceDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date invoiceDate;
	
	@Column(name="InvoiceAmount", nullable= false , updatable = true)
	private float invoiceAmount;

	@Column(name="TotalQty", nullable= false , updatable = true)
	private int TotalQty;

	@Column(name="Supplier", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String supplier;
	

	@Column(name="Status", nullable= true,columnDefinition = "nvarchar(100)")
	private String status;

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

	public Integer getiDNO() {
		return iDNO;
	}

	public void setiDNO(Integer iDNO) {
		this.iDNO = iDNO;
	}

	public List<BooksPurchaseDetailModel> getBKPurchaseDetail() {
		return BKPurchaseDetail;
	}

	public void setBKPurchaseDetail(List<BooksPurchaseDetailModel> bKPurchaseDetail) {
		BKPurchaseDetail = bKPurchaseDetail;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getInvocieNo() {
		return invocieNo;
	}

	public void setInvocieNo(String invocieNo) {
		this.invocieNo = invocieNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public float getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(float invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public int getTotalQty() {
		return TotalQty;
	}

	public void setTotalQty(int totalQty) {
		TotalQty = totalQty;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
		return "SportItemPurchaseModel [iDNO=" + iDNO + ", BKPurchaseDetail=" + BKPurchaseDetail + ", regNo=" + regNo
				+ ", invocieNo=" + invocieNo + ", invoiceDate=" + invoiceDate + ", invoiceAmount=" + invoiceAmount
				+ ", TotalQty=" + TotalQty + ", supplier=" + supplier + ", status=" + status + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}

}
