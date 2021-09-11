package com.sm.System.Transport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.sm.System.SMUtility.SMDataCreatedUpdated;

@Entity
@Table(name ="SMTransportRoute")
public class RouteSubModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@Column(name="RegNO", nullable= false , updatable = false)
	private String regNo;
	
	@Column(name="RouteName", nullable= false , updatable = false)
	private String routeName;

	@Column(name="RouteDescription", nullable= false , updatable = false)
	private String routeDescription;

	@Column(name="Status", nullable= false)
	@ColumnDefault("'A'") // A=Active status
	private String status;
	
	@Embedded
	private SMDataCreatedUpdated userRefInfo;

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

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteDescription() {
		return routeDescription;
	}

	public void setRouteDescription(String routeDescription) {
		this.routeDescription = routeDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SMDataCreatedUpdated getUserRefInfo() {
		return userRefInfo;
	}

	public void setUserRefInfo(SMDataCreatedUpdated userRefInfo) {
		this.userRefInfo = userRefInfo;
	}

	@Override
	public String toString() {
		return "RouteSubModel [iDNO=" + iDNO + ", regNo=" + regNo + ", routeName=" + routeName + ", routeDescription="
				+ routeDescription + ", status=" + status + ", userRefInfo=" + userRefInfo + "]";
	}



}
