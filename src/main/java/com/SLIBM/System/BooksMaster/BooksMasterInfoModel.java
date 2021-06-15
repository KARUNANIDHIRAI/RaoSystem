package com.SLIBM.System.BooksMaster;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LBBookMaster")
public class BooksMasterInfoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer iDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="BookCode", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String bookCode;
	
	@Column(name="BookkTitle", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String bookTitle;

	@Column(name="Author", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String author;

	@Column(name="Edition", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String edition;

	@Column(name="Publisher", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String publisher;
	
	@Column(name="BooksISBN", nullable= false , updatable = true, columnDefinition = "nvarchar(100)")
	private String booksISBN;

	@Column(name="Category", nullable= false , updatable = true)
	private String category;
	
	@Column(name="Price", nullable= true , updatable = true)
	private int price;
	
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "BKMastQtyIDNOFK")
	private BooksMasterQtyModel bksMasterQtyIDNO;

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

	public String getBooksISBN() {
		return booksISBN;
	}

	public void setBooksISBN(String booksISBN) {
		this.booksISBN = booksISBN;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public BooksMasterQtyModel getBksMasterQtyIDNO() {
		return bksMasterQtyIDNO;
	}

	public void setBksMasterQtyIDNO(BooksMasterQtyModel bksMasterQtyIDNO) {
		this.bksMasterQtyIDNO = bksMasterQtyIDNO;
	}

	@Override
	public String toString() {
		return "BooksMasterInfoModel [iDNO=" + iDNO + ", regNo=" + regNo + ", bookCode=" + bookCode + ", bookTitle="
				+ bookTitle + ", author=" + author + ", edition=" + edition + ", publisher=" + publisher
				+ ", booksISBN=" + booksISBN + ", category=" + category + ", price=" + price + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + ", bksMasterQtyIDNO=" + bksMasterQtyIDNO + "]";
	}
	

	
}
