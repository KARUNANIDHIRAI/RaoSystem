package com.sm.System.StudentPersonalInfo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sm.System.SchoolInformation.SchoolInfoModel;

@Entity 
@Table(name = "StudentIdProof")

public class SIdProofInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IdNo", nullable= false , updatable = false, columnDefinition = "Integer")
	private Integer idNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sIdNo", columnDefinition = "long")
	private StudentPersonalInfo studentPersonalInfo;
	
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;

	@Column(name="IdProof", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
	private String idProof;
	
	@Column(name="IDDocType", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String idDocType;

	public Integer getIdNo() {
		return idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public StudentPersonalInfo getStudentPersonalInfo() {
		return studentPersonalInfo;
	}

	public void setStudentPersonalInfo(StudentPersonalInfo studentPersonalInfo) {
		this.studentPersonalInfo = studentPersonalInfo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdDocType() {
		return idDocType;
	}

	public void setIdDocType(String idDocType) {
		this.idDocType = idDocType;
	}

	@Override
	public String toString() {
		return "SIdProofInfo [idNo=" + idNo + ", studentPersonalInfo=" + studentPersonalInfo + ", regNo=" + regNo
				+ ", idProof=" + idProof + ", idDocType=" + idDocType + "]";
	}

	
}
