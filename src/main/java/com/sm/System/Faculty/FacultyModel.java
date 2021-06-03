package com.sm.System.Faculty;
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
@Table(name ="SMFaculty")
public class FacultyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FIDNO")
	private Integer fIDNO;


	@Column(name="RegNo", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="Code", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String code;

	@Column(name="Name", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String name;

	@Column(name="Status", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
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

	public Integer getfIDNO() {
		return fIDNO;
	}

	public void setfIDNO(Integer fIDNO) {
		this.fIDNO = fIDNO;
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
		return "FacultyModel [fIDNO=" + fIDNO + ", regNo=" + regNo + ", code=" + code + ", name=" + name + ", status="
				+ status + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}

	
}
