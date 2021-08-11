package com.Sprots.System.SportItemsPurchase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.SLIBM.System.BooksPurchase.BooksPurchaseModel;

@Entity
@Table(name ="SportItemsPurchaseDetails")
public class SportItemPurchaseDetailModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDDNO")
	private Integer iDDNO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDNOFK")
	private BooksPurchaseModel BKPurchase;
	
	@Column(name="RegNO", nullable= false , updatable = false)
	private String regNo;
	
	@Column(name="ItemCode", nullable= false , updatable = false)
	private String ItemCode;

	@Column(name="ItemName", nullable= false , updatable = false)
	private String itemName;

	@Column(name="ItemSource", nullable= true, updatable = true)
	private String ItemSource;

	@Column(name="PONO", nullable= true, updatable = true)
	private String pONO;
	
	@Column(name="ExpiryDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@Column(name="ManufactureDate", nullable= false , columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date manufactureDate;

	@Column(name="ItemQty", nullable= false, updatable = true)
	private Integer itemQty;

	@Column(name="Unit", nullable= false, updatable = true)
	private String unit;

	@Column(name="Price", nullable= true, updatable = true)
	private float price  ;

	@Column(name="Tax", nullable= true, updatable = true)
	private float tax;

	@Column(name="Discount", nullable= true, updatable = true)
	private float discount;

	@Column(name="NetAmount", nullable= true, updatable = true)
	private float netAmount;


	@Column(name="Status", nullable= false, updatable = true)
	private String status;

	@Column(name= "CreatedBy", nullable= false,updatable = false)
	private String createdBy;

	@Column(name= "CreatedOn", nullable= false,updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name= "UpdatedBy", nullable= false,updatable = true)
	private String updatedBy;

	@Column(name= "UpdatedOn", nullable= false,columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public Integer getiDDNO() {
		return iDDNO;
	}

	public void setiDDNO(Integer iDDNO) {
		this.iDDNO = iDDNO;
	}

	public BooksPurchaseModel getBKPurchase() {
		return BKPurchase;
	}

	public void setBKPurchase(BooksPurchaseModel bKPurchase) {
		BKPurchase = bKPurchase;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSource() {
		return ItemSource;
	}

	public void setItemSource(String itemSource) {
		ItemSource = itemSource;
	}

	public String getpONO() {
		return pONO;
	}

	public void setpONO(String pONO) {
		this.pONO = pONO;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
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
		return "SportItemPurchaseDetailModel [iDDNO=" + iDDNO + ", BKPurchase=" + BKPurchase + ", regNo=" + regNo
				+ ", ItemCode=" + ItemCode + ", itemName=" + itemName + ", ItemSource=" + ItemSource + ", pONO=" + pONO
				+ ", expiryDate=" + expiryDate + ", manufactureDate=" + manufactureDate + ", itemQty=" + itemQty
				+ ", unit=" + unit + ", price=" + price + ", tax=" + tax + ", discount=" + discount + ", netAmount="
				+ netAmount + ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", getiDDNO()=" + getiDDNO()
				+ ", getBKPurchase()=" + getBKPurchase() + ", getRegNo()=" + getRegNo() + ", getItemCode()="
				+ getItemCode() + ", getItemName()=" + getItemName() + ", getItemSource()=" + getItemSource()
				+ ", getpONO()=" + getpONO() + ", getExpiryDate()=" + getExpiryDate() + ", getManufactureDate()="
				+ getManufactureDate() + ", getItemQty()=" + getItemQty() + ", getUnit()=" + getUnit() + ", getPrice()="
				+ getPrice() + ", getTax()=" + getTax() + ", getDiscount()=" + getDiscount() + ", getNetAmount()="
				+ getNetAmount() + ", getStatus()=" + getStatus() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getCreatedOn()=" + getCreatedOn() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdatedOn()="
				+ getUpdatedOn() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
