package com.sm.System.StudentPersonalInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="StudentParentInfo")
public class SParentInfo  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IdNo", nullable= false , updatable = false, columnDefinition = "Integer")
	private Integer idNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sIdNo", columnDefinition = "long")
	private StudentPersonalInfoModel studentPersonalInfoModel;

	
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name="FFName", nullable= false, columnDefinition = "nvarchar(100)")
	private String ffName;
	
	@Column(name="FLName", nullable= false, columnDefinition = "nvarchar(100)")
	private String flName;
	
	@Column(name="MFName", nullable= false, columnDefinition = "nvarchar(100)")
	private String mfName;
	
	@Column(name="MLName", nullable= false, columnDefinition = "nvarchar(100)")
	private String mlName;
	

	@Column(name="PMobileNo", nullable= true,columnDefinition = "nvarchar(200)")
	private String pMobileNo;

	@Column(name="PEmailId", nullable= true,columnDefinition = "nvarchar(200)")
	private String pEmailId;

	public Integer getIdNo() {
		return idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public StudentPersonalInfoModel getStudentPersonalInfoModel() {
		return studentPersonalInfoModel;
	}

	public void setStudentPersonalInfoModel(StudentPersonalInfoModel studentPersonalInfoModel) {
		this.studentPersonalInfoModel = studentPersonalInfoModel;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getFfName() {
		return ffName;
	}

	public void setFfName(String ffName) {
		this.ffName = ffName;
	}

	public String getFlName() {
		return flName;
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	public String getMlName() {
		return mlName;
	}

	public void setMlName(String mlName) {
		this.mlName = mlName;
	}

	public String getpMobileNo() {
		return pMobileNo;
	}

	public void setpMobileNo(String pMobileNo) {
		this.pMobileNo = pMobileNo;
	}

	public String getpEmailId() {
		return pEmailId;
	}

	public void setpEmailId(String pEmailId) {
		this.pEmailId = pEmailId;
	}

	@Override
	public String toString() {
		return "SParentInfo [idNo=" + idNo + ", studentPersonalInfoModel=" + studentPersonalInfoModel + ", regNo="
				+ regNo + ", ffName=" + ffName + ", flName=" + flName + ", mfName=" + mfName + ", mlName=" + mlName
				+ ", pMobileNo=" + pMobileNo + ", pEmailId=" + pEmailId + "]";
	}
	
	
}
