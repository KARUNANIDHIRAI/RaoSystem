package com.rao.System.Visitor;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "VisitorAddress")
public class VisitorAddressModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "IDNOFK", nullable= false,columnDefinition = "int" ,updatable= false, insertable = false)
	private int iDNO;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "IDNO", columnDefinition = "int")
	private VisitorGPModel VGPModel;
	
	
	@Column(name= "RwaRegNo", nullable= false,columnDefinition = "nvarchar(255)")
	private String rwaRegNo;
	
	
	@Column(name= "VAddress", nullable= false,columnDefinition = "nvarchar(255)")
	private String vAddress;
	
	@Column(name= "City", nullable= false,columnDefinition = "nvarchar(255)")
	private String vCity;
	
	@Column(name= "State", nullable= false,columnDefinition = "nvarchar(255)")
	private String vState;
	
	@Column(name= "Country", nullable= false,columnDefinition = "nvarchar(255)")
	private String vCountry;
	
	@Column(name= "PinCode", nullable= true,columnDefinition = "nvarchar(255)")
	private String vPinCode;

	public int getiDNO() {
		return iDNO;
	}

	public void setiDNO(int iDNO) {
		this.iDNO = iDNO;
	}

	public VisitorGPModel getVGPModel() {
		return VGPModel;
	}

	public void setVGPModel(VisitorGPModel vGPModel) {
		VGPModel = vGPModel;
	}

	public String getRwaRegNo() {
		return rwaRegNo;
	}

	public void setRwaRegNo(String rwaRegNo) {
		this.rwaRegNo = rwaRegNo;
	}

	public String getvAddress() {
		return vAddress;
	}

	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}

	public String getvCity() {
		return vCity;
	}

	public void setvCity(String vCity) {
		this.vCity = vCity;
	}

	public String getvState() {
		return vState;
	}

	public void setvState(String vState) {
		this.vState = vState;
	}

	public String getvCountry() {
		return vCountry;
	}

	public void setvCountry(String vCountry) {
		this.vCountry = vCountry;
	}

	public String getvPinCode() {
		return vPinCode;
	}

	public void setvPinCode(String vPinCode) {
		this.vPinCode = vPinCode;
	}

	@Override
	public String toString() {
		return "VisitorAddressModel [iDNO=" + iDNO + ", VGPModel=" + VGPModel + ", rwaRegNo=" + rwaRegNo + ", vAddress="
				+ vAddress + ", vCity=" + vCity + ", vState=" + vState + ", vCountry=" + vCountry + ", vPinCode="
				+ vPinCode + "]";
	}
	

}
