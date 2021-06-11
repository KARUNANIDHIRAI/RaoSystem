package com.SLIBM.System.BooksPurchase;

/*BooksPurchaseDetailSubModel is exactly same as BooksPurchaseDetailModel only difference is this model is not connected
with Book purchaseModel. in this modely only one colum add iDNOFK  in place for join column 
*/
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

@Entity
@Table(name ="LBBooksInformationDetail")
public class BooksPurchaseDetailSubModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDDNO")
	private Integer iDDNO;

	@Column(name = "IDNOFK", nullable= false , updatable = false)
	private Integer iDNOFK;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "iDNOFK") private BooksPurchaseModel BKPurchase;
	 */
	
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="BooksISBN", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String booksISBN;

	@Column(name="BookCode", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String bookCode;

	@Column(name="BookTitle", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String bookTitle;

	@Column(name="Author", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String author;

	@Column(name="Edition", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String edition;

	@Column(name="Publisher", nullable= false, updatable = true, columnDefinition = "nvarchar(100)")
	private String publisher;
	
	@Column(name="BooKSource", nullable= true, updatable = true,columnDefinition = "nvarchar(100)")
	private String booKSource;

	@Column(name="BookPONO", nullable= false, updatable = true, columnDefinition = "nvarchar(100)")
	private String bOOKPONO;

	@Column(name="BookCopies", nullable= false, updatable = true, columnDefinition = "Integer")
	private Integer bookCopiesNos;

	@Column(name="Price", nullable= true, updatable = true)
	private float price  ;

	@Column(name="Tax", nullable= true, updatable = true)
	private float tax;

	@Column(name="Discount", nullable= true, updatable = true)
	private float discount;

	@Column(name="NetAmount", nullable= true, updatable = true)
	private float netAmount;


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

	public Integer getiDDNO() {
		return iDDNO;
	}

	public void setiDDNO(Integer iDDNO) {
		this.iDDNO = iDDNO;
	}

	public Integer getiDNOFK() {
		return iDNOFK;
	}

	public void setiDNOFK(Integer iDNOFK) {
		this.iDNOFK = iDNOFK;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getBooksISBN() {
		return booksISBN;
	}

	public void setBooksISBN(String booksISBN) {
		this.booksISBN = booksISBN;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBooKSource() {
		return booKSource;
	}

	public void setBooKSource(String booKSource) {
		this.booKSource = booKSource;
	}

	public String getbOOKPONO() {
		return bOOKPONO;
	}

	public void setbOOKPONO(String bOOKPONO) {
		this.bOOKPONO = bOOKPONO;
	}

	public Integer getBookCopiesNos() {
		return bookCopiesNos;
	}

	public void setBookCopiesNos(Integer bookCopiesNos) {
		this.bookCopiesNos = bookCopiesNos;
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
		return "BooksPurchaseDetailSubModel [iDDNO=" + iDDNO + ", iDNOFK=" + iDNOFK + ", regNo=" + regNo
				+ ", booksISBN=" + booksISBN + ", bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", author="
				+ author + ", edition=" + edition + ", publisher=" + publisher + ", booKSource=" + booKSource
				+ ", bOOKPONO=" + bOOKPONO + ", bookCopiesNos=" + bookCopiesNos + ", price=" + price + ", tax=" + tax
				+ ", discount=" + discount + ", netAmount=" + netAmount + ", status=" + status + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn
				+ "]";
	}



}
