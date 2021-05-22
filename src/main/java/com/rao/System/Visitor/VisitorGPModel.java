package com.rao.System.Visitor;

import java.math.BigInteger;
import java.sql.Time;
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

import org.hibernate.type.TimeType;

import com.rao.System.UserLogin.UserAddress;

@Entity
@Table(name ="VisitorGatePass")
public class VisitorGPModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "IDNO", columnDefinition ="int", nullable =false)
	private int iDNO;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy= "VGPModel")
	private List<VisitorAddressModel> VAdd = new ArrayList<>();

	
	@Column(name = "RwaRegNo", columnDefinition ="nvarchar(100)", nullable =false)
	private String rwaRegNo;
	
	@Column(name = "VFName", columnDefinition ="nvarchar(100)", nullable =false)
	private String vFName;
	
	@Column(name = "VLName", columnDefinition ="nvarchar(100)", nullable =false)
	private String vLname;
	
	@Column(name = "VMobileNo", columnDefinition ="nvarchar(100)", nullable =false)
	private String vMobileNo;
	
	@Column(name = "VInTime", columnDefinition ="Time", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date vInTime ;
	
	@Column(name = "VOutTime", columnDefinition ="Time", nullable =false)
	@Temporal(value = TemporalType.TIME)
	private Date vOutTime ;
	
	@Column(name = "VisitDate", columnDefinition ="Date", nullable =false)
	@Temporal(value = TemporalType.DATE) 
	private Date visitDate ;

	@Column(name = "IDProof", columnDefinition ="nvarchar(100)", nullable =false)
	private String idProof;
	
	@Column(name = "IDDocName", columnDefinition ="nvarchar(100)", nullable =false)
	private String idDocName;
	
	@Column(name = "VehicleNo", columnDefinition ="nvarchar(100)", nullable =true)
	private String vehicleNo;
	
	@Column(name = "VehicleName", columnDefinition ="nvarchar(100)", nullable =true)
	private String vehicleName;
	
	@Column(name = "ResFName", columnDefinition ="nvarchar(100)", nullable =false)
	private String resFName;
	
	@Column(name = "ResLName", columnDefinition ="nvarchar(100)", nullable =false)
	private String resLName;
	
	@Column(name = "ResAptNo", columnDefinition ="nvarchar(100)", nullable =false)
	private String resAptNo;

	@Column(name = "ResFltNo", columnDefinition ="nvarchar(100)", nullable =false)
	private String resFltNo;
	
	@Column(name = "CreatedBy", columnDefinition ="nvarchar(100)", nullable =false)
	private String createdBy;
	
	@Column(name = "CreatedOn", columnDefinition ="nvarchar(100)", nullable =false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "VPurpose", columnDefinition ="nvarchar(100)", nullable =true)
	private String vPurpose;

	public int getiDNO() {
		return iDNO;
	}

	public void setiDNO(int iDNO) {
		this.iDNO = iDNO;
	}

	public List<VisitorAddressModel> getVAdd() {
		return VAdd;
	}

	public void setVAdd(List<VisitorAddressModel> vAdd) {
		VAdd = vAdd;
	}

	public String getRwaRegNo() {
		return rwaRegNo;
	}

	public void setRwaRegNo(String rwaRegNo) {
		this.rwaRegNo = rwaRegNo;
	}

	public String getvFName() {
		return vFName;
	}

	public void setvFName(String vFName) {
		this.vFName = vFName;
	}

	public String getvLname() {
		return vLname;
	}

	public void setvLname(String vLname) {
		this.vLname = vLname;
	}

	public String getvMobileNo() {
		return vMobileNo;
	}

	public void setvMobileNo(String vMobileNo) {
		this.vMobileNo = vMobileNo;
	}

	public Date getvInTime() {
		return vInTime;
	}

	public void setvInTime(Date vInTime) {
		this.vInTime = vInTime;
	}

	public Date getvOutTime() {
		return vOutTime;
	}

	public void setvOutTime(Date vOutTime) {
		this.vOutTime = vOutTime;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdDocName() {
		return idDocName;
	}

	public void setIdDocName(String idDocName) {
		this.idDocName = idDocName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getResFName() {
		return resFName;
	}

	public void setResFName(String resFName) {
		this.resFName = resFName;
	}

	public String getResLName() {
		return resLName;
	}

	public void setResLName(String resLName) {
		this.resLName = resLName;
	}

	public String getResAptNo() {
		return resAptNo;
	}

	public void setResAptNo(String resAptNo) {
		this.resAptNo = resAptNo;
	}

	public String getResFltNo() {
		return resFltNo;
	}

	public void setResFltNo(String resFltNo) {
		this.resFltNo = resFltNo;
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

	public String getvPurpose() {
		return vPurpose;
	}

	public void setvPurpose(String vPurpose) {
		this.vPurpose = vPurpose;
	}

	@Override
	public String toString() {
		return "VisitorGPModel [iDNO=" + iDNO + ", VAdd=" + VAdd + ", rwaRegNo=" + rwaRegNo + ", vFName=" + vFName
				+ ", vLname=" + vLname + ", vMobileNo=" + vMobileNo + ", vInTime=" + vInTime + ", vOutTime=" + vOutTime
				+ ", visitDate=" + visitDate + ", idProof=" + idProof + ", idDocName=" + idDocName + ", vehicleNo="
				+ vehicleNo + ", vehicleName=" + vehicleName + ", resFName=" + resFName + ", resLName=" + resLName
				+ ", resAptNo=" + resAptNo + ", resFltNo=" + resFltNo + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", vPurpose=" + vPurpose + "]";
	}


}
