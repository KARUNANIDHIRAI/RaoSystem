package com.rao.System.UserLogin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "knUserLogin")
public class UserLoginModel {

										
	@Id
	@Column(name ="emailId", columnDefinition = "nvarchar(255)")
	private String email;

	@OneToMany(cascade = CascadeType.ALL , mappedBy= "ULModel")
	private List<UserAddress> UAdd = new ArrayList<>();

 
	
	@Column(name="RwaNO", nullable= false, updatable = false, columnDefinition = "nvarchar(255)")
	private String regNo;
	
	@Column(name ="userType", nullable= false, updatable = false, columnDefinition = "int")
	private int lUType;
	
	@Column(name ="fName", nullable= false, updatable = true, columnDefinition = "nvarchar(255)")
	private String FirstName;
	
	@Column(name ="lName", nullable= false, updatable = true, columnDefinition = "nvarchar(255)")
	private String LastName;
		
	@Column(name ="mobileNo", nullable= false, updatable = true, columnDefinition = "nvarchar(255)")
	private String Mobile;
	
	@Column(name ="securityCode", nullable= false, updatable = true, columnDefinition = "nvarchar(255)")
	private String Security;

	@Column(name ="loginPassword", nullable= false, updatable = true, columnDefinition = "nvarchar(255)")
	private String LPassword;
	
	@Column(name= "Status", nullable= false, columnDefinition = "nvarchar(255)")
	private String status;

	@Column(name= "CreatedBy", nullable= false, updatable = false, columnDefinition = "nvarchar(255)")
	private String createdBy;
	
	@Column(name= "CreatedOn", nullable= false, updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name= "UpdatedBy", nullable= false, columnDefinition = "nvarchar(255)")
	private String updatedBy;
	
	@Column(name= "UpdatedOn", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdatedOn;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public int getlUType() {
		return lUType;
	}

	public void setlUType(int lUType) {
		this.lUType = lUType;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getSecurity() {
		return Security;
	}

	public void setSecurity(String security) {
		Security = security;
	}

	public String getLPassword() {
		return LPassword;
	}

	public void setLPassword(String lPassword) {
		LPassword = lPassword;
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
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	public List<UserAddress> getUAdd() {
		return UAdd;
	}

	public void setUAdd(List<UserAddress> uAdd) {
		UAdd = uAdd;
	}

	@Override
	public String toString() {
		return "UserLoginModel [email=" + email + ", UAdd=" + UAdd + ", regNo=" + regNo + ", lUType=" + lUType
				+ ", FirstName=" + FirstName + ", LastName=" + LastName + ", Mobile=" + Mobile + ", Security="
				+ Security + ", LPassword=" + LPassword + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", UpdatedOn=" + UpdatedOn + "]";
	}

	
}
