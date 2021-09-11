package com.sm.System.Transport;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import com.sm.System.SMUtility.SMDataCreatedUpdated;

@Entity
@Table(name ="SMTransportRoutePickupDrop")
public class RoutePickUpDropSubModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNO")
	private Integer iDNO;
	
	@Column(name="RegNO", nullable= true , updatable = false)
	private String regNo;
	
	@Column(name="PickDropSNo", nullable= true , updatable = false)
	private String pickDropSNo;

	@Column(name="PickupDropPoint", nullable= true , updatable = false)
	private String pickupDropPoint;

	@Column(name="PickupDropTime", nullable= true , updatable = false)
	private String pickupDropTime;

	@Column(name="PickupDropType", nullable= true , updatable = false)
	private String pickupDropType;

	@Column(name="Status", nullable= true)
	@ColumnDefault("'A'") // A=Active status
	private String status;

	@Column(name="iDNOFK", nullable= true , updatable = false)
	private int iDNOFK;
	
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

	public String getPickDropSNo() {
		return pickDropSNo;
	}

	public void setPickDropSNo(String pickDropSNo) {
		this.pickDropSNo = pickDropSNo;
	}

	public String getPickupDropPoint() {
		return pickupDropPoint;
	}

	public void setPickupDropPoint(String pickupDropPoint) {
		this.pickupDropPoint = pickupDropPoint;
	}

	public String getPickupDropTime() {
		return pickupDropTime;
	}

	public void setPickupDropTime(String pickupDropTime) {
		this.pickupDropTime = pickupDropTime;
	}

	public String getPickupDropType() {
		return pickupDropType;
	}

	public void setPickupDropType(String pickupDropType) {
		this.pickupDropType = pickupDropType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getiDNOFK() {
		return iDNOFK;
	}

	public void setiDNOFK(int iDNOFK) {
		this.iDNOFK = iDNOFK;
	}

	public SMDataCreatedUpdated getUserRefInfo() {
		return userRefInfo;
	}

	public void setUserRefInfo(SMDataCreatedUpdated userRefInfo) {
		this.userRefInfo = userRefInfo;
	}

	@Override
	public String toString() {
		return "RoutePickUpDropSubModel [iDNO=" + iDNO + ", regNo=" + regNo + ", pickDropSNo=" + pickDropSNo
				+ ", pickupDropPoint=" + pickupDropPoint + ", pickupDropTime=" + pickupDropTime + ", pickupDropType="
				+ pickupDropType + ", status=" + status + ", iDNOFK=" + iDNOFK + ", userRefInfo=" + userRefInfo + "]";
	}


	

}
