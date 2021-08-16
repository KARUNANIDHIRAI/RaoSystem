package com.sm.System.URBAccess;

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

@Entity
@Table(name = "SMUserRoles")
public class UserRolesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserRoleId")
	private Integer iDNO;	

	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name ="UserRole", nullable= false, updatable = true)
	private String userRole;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy= "URolesModel")
	private List<UserRolesDetailsModel> URDetailModel = new ArrayList<>();
	
	@Column(name= "Status", nullable= false, updatable = true)
	private String status;
	
	@Column(name= "CreatedBy", nullable= false, updatable = false)
	private String createdBy;
	
	@Column(name= "CreatedOn", nullable= false, updatable = false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name= "UpdatedBy", nullable= false, updatable = true)
	private String updatedBy;
	
	@Column(name= "UpdatedOn", nullable= false, columnDefinition = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdatedOn;

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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public List<UserRolesDetailsModel> getURDetailModel() {
		return URDetailModel;
	}

	public void setURDetailModel(List<UserRolesDetailsModel> uRDetailModel) {
		URDetailModel = uRDetailModel;
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

	@Override
	public String toString() {
		return "UserRolesModel [iDNO=" + iDNO + ", regNo=" + regNo + ", userRole=" + userRole + ", URDetailModel="
				+ URDetailModel + ", status=" + status + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", updatedBy=" + updatedBy + ", UpdatedOn=" + UpdatedOn + "]";
	}

}
