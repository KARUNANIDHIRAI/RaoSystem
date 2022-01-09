package com.sm.System.TransportVehicle;
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
	@Table(name ="SMRouteVehicles")
	public class RouteVehicleSubModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "RVIDNO")
		private Integer rVIDNO;
		
		@Column(name="RegNO")
		private String regNo;
		
		@Column(name="VehicleNo")
		private String vehicleNo;

		@Column(name="VehicleType")
		private String vehicleType;

		@Column(name="Make")
		private String make;

		@Column(name="Model")
		private String model;
		
		@Column(name="ManufactureYear")
		private String manufactureYear;

		@Column(name="RouteIDFK")
		private int routeIDFK;
		
		@Column(name="Status")
		@ColumnDefault("'A'") // A=Active status
		private String status;
		
		@Embedded
		private SMDataCreatedUpdated smDataCreatedUpdated;

		public Integer getrVIDNO() {
			return rVIDNO;
		}

		public void setrVIDNO(Integer rVIDNO) {
			this.rVIDNO = rVIDNO;
		}

		public String getRegNo() {
			return regNo;
		}

		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}

		public String getVehicleNo() {
			return vehicleNo;
		}

		public void setVehicleNo(String vehicleNo) {
			this.vehicleNo = vehicleNo;
		}

		public String getVehicleType() {
			return vehicleType;
		}

		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getManufactureYear() {
			return manufactureYear;
		}

		public void setManufactureYear(String manufactureYear) {
			this.manufactureYear = manufactureYear;
		}

		public int getRouteIDFK() {
			return routeIDFK;
		}

		public void setRouteIDFK(int routeIDFK) {
			this.routeIDFK = routeIDFK;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public SMDataCreatedUpdated getSmDataCreatedUpdated() {
			return smDataCreatedUpdated;
		}

		public void setSmDataCreatedUpdated(SMDataCreatedUpdated smDataCreatedUpdated) {
			this.smDataCreatedUpdated = smDataCreatedUpdated;
		}

		@Override
		public String toString() {
			return "RouteVehicleSubModel [rVIDNO=" + rVIDNO + ", regNo=" + regNo + ", vehicleNo=" + vehicleNo
					+ ", vehicleType=" + vehicleType + ", make=" + make + ", model=" + model + ", manufactureYear="
					+ manufactureYear + ", routeIDFK=" + routeIDFK + ", status=" + status + ", smDataCreatedUpdated="
					+ smDataCreatedUpdated + "]";
		}
		
	}
