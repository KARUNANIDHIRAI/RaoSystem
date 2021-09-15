package com.sm.System.SMPickupDrop;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.sm.System.SMUtility.SMDataCreatedUpdated;

@Entity
@Table(name ="SMStudentPickupDrop")
public class SMPickupDropSubModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PDiDNO")
	private Integer pDiDNO;
	
	@Column(name="RegNO", nullable= false , updatable = false)
	private String regNo;
	
	@Column(name="AdmNo", nullable= false, updatable = false)
	private String admNo;

	@Column(name="Section", nullable= true)
	private String section;
	
	@Column(name="SClass", nullable= true)
	private String sClass;
	
    @Column(name="StudentSIdNoFK") // Strudent information primary key
    private Integer StudentSIdNoFK;
    
    @Column(name="RoutePPiDNOFK") // Route pickup drop primary key
    private Integer RoutePPiDNOFK;
    
    @Column(name="RoutePDiDNOFK") // Route pickup drop primary key
    private Integer RoutePDiDNOFK;

	@Column(name = "RouteiDNOFK")
	private Integer routeiDNOFK;

	@Column(name="Status", nullable= false)
	@ColumnDefault("'A'") // A=Active status
	private String status;

	
	@Embedded
	private SMDataCreatedUpdated userRefInfo;

	public Integer getpDiDNO() {
		return pDiDNO;
	}

	public void setpDiDNO(Integer pDiDNO) {
		this.pDiDNO = pDiDNO;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getAdmNo() {
		return admNo;
	}

	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public Integer getStudentSIdNoFK() {
		return StudentSIdNoFK;
	}

	public void setStudentSIdNoFK(Integer studentSIdNoFK) {
		StudentSIdNoFK = studentSIdNoFK;
	}

	public Integer getRoutePPiDNOFK() {
		return RoutePPiDNOFK;
	}

	public void setRoutePPiDNOFK(Integer routePPiDNOFK) {
		RoutePPiDNOFK = routePPiDNOFK;
	}

	public Integer getRoutePDiDNOFK() {
		return RoutePDiDNOFK;
	}

	public void setRoutePDiDNOFK(Integer routePDiDNOFK) {
		RoutePDiDNOFK = routePDiDNOFK;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getRouteiDNOFK() {
		return routeiDNOFK;
	}

	public void setRouteiDNOFK(Integer routeiDNOFK) {
		this.routeiDNOFK = routeiDNOFK;
	}

	public SMDataCreatedUpdated getUserRefInfo() {
		return userRefInfo;
	}

	public void setUserRefInfo(SMDataCreatedUpdated userRefInfo) {
		this.userRefInfo = userRefInfo;
	}

	@Override
	public String toString() {
		return "SMPickupDropSubModel [pDiDNO=" + pDiDNO + ", regNo=" + regNo + ", admNo=" + admNo + ", section="
				+ section + ", sClass=" + sClass + ", StudentSIdNoFK=" + StudentSIdNoFK + ", RoutePPiDNOFK="
				+ RoutePPiDNOFK + ", RoutePDiDNOFK=" + RoutePDiDNOFK + ", status=" + status + ", routeiDNOFK="
				+ routeiDNOFK + ", userRefInfo=" + userRefInfo + "]";
	}




}
