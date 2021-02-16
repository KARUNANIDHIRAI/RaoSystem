package com.raoSystem.FLTOWN;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name= "VehicleInformation")
public class HVehicleInfoModel implements Serializable{

	@Column(name = "IDNO", columnDefinition ="int", nullable =true)
	private int iDNO;
	
	@Id
	@Column(name = "RwaRegNo", columnDefinition ="nvarchar(100)", nullable =false)
	private String rwaRegNo;

	@Id
	@Column(name = "VehicleNo", columnDefinition ="nvarchar(50)", nullable =false, updatable= false)
	private String VehicleNo;

	@Column(name = "AptNo", columnDefinition ="nvarchar(50)", nullable =false, updatable= false)
	private String aptNo;

	@Column(name = "FlatNo", columnDefinition ="nvarchar(50)", nullable =false, updatable= false)
	private String flatNo;
	
	@Column(name = "VehicleType", columnDefinition ="nvarchar(100)", nullable =false)
	private String vehicleType;
	
	@Column(name = "Manufacturer", columnDefinition ="nvarchar(100)", nullable =false)
	private String manufacturer;

	@Column(name = "VehicleName", columnDefinition ="nvarchar(100)", nullable =false)
	private String vehicleName;

	@Column(name = "VehicleColor", columnDefinition ="nvarchar(100)", nullable =false)
	private String vehicleColor;
	
	@Column(name = "CreatedBy", columnDefinition ="nvarchar(100)", nullable =false)
	private String createdBy;
	
	@Column(name = "CreatedOn", columnDefinition ="datetime", nullable =false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UpdatedBy", columnDefinition ="nvarchar(100)", nullable =false)
	private String UpdatedBy;
	
	@Column(name = "UpdatedOn", columnDefinition ="datetime", nullable =false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date UpdatedOn;

	public int getiDNO() {
		return iDNO;
	}

	public void setiDNO(int iDNO) {
		this.iDNO = iDNO;
	}

	public String getRwaRegNo() {
		return rwaRegNo;
	}

	public void setRwaRegNo(String rwaRegNo) {
		this.rwaRegNo = rwaRegNo;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public String getAptNo() {
		return aptNo;
	}

	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
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
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "HVehicleInfoModel [iDNO=" + iDNO + ", rwaRegNo=" + rwaRegNo + ", VehicleNo=" + VehicleNo + ", aptNo="
				+ aptNo + ", flatNo=" + flatNo + ", vehicleType=" + vehicleType + ", manufacturer=" + manufacturer
				+ ", vehicleName=" + vehicleName + ", vehicleColor=" + vehicleColor + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", UpdatedBy=" + UpdatedBy + ", UpdatedOn=" + UpdatedOn + "]";
	}

	
	


	
}
