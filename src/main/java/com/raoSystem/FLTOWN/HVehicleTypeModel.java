package com.raoSystem.FLTOWN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name= "VehicleType")

public class HVehicleTypeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VehicleCode", columnDefinition ="int", nullable =false)
	private int vehicleCode;
	
			

	@Column(name = "VehicleType", columnDefinition ="nvarchar(100)", nullable =false, updatable= true)
	private String vehicleType;
	
	@Column(name = "Status", columnDefinition ="nvarchar(1)", nullable =false, updatable= true)
	@ColumnDefault(value = "'A'")
	private String status;

	public int getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(int vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HVehicleTypeModel [vehicleCode=" + vehicleCode + ", vehicleType=" + vehicleType + ", status=" + status
				+ "]";
	}
}
