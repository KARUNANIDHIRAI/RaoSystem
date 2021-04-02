package com.sm.System.FeeDefine;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FeeSubMaster")
public class FeePrgrammeModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FPIDNO", nullable= false , updatable = false)
	private Integer fpidNo;
	
	@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
	private String regNo;
	
	@Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	private String status;
	
	@Column(name="Stream", nullable= false,columnDefinition = "nvarchar(200)")
	private String stream;

	@Column(name="FeeAmount", nullable= false,columnDefinition = "nvarchar(200)")
	private String feeAmt;

	@Column(name="FeeDiscount", nullable= true,columnDefinition = "nvarchar(200)")
	private String feeDiscount;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="FeeIdnoFK")
	private FeeDefineModel feeDefineModel ;

	public Integer getFpidNo() {
		return fpidNo;
	}

	public void setFpidNo(Integer fpidNo) {
		this.fpidNo = fpidNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt;
	}

	public String getFeeDiscount() {
		return feeDiscount;
	}

	public void setFeeDiscount(String feeDiscount) {
		this.feeDiscount = feeDiscount;
	}


	public FeeDefineModel getFeeDefineModel() {
		return feeDefineModel;
	}

	public void setFeeDefineModel(FeeDefineModel feeDefineModel) {
		this.feeDefineModel = feeDefineModel;
	}

//	@Override
//	public String toString() {
//		return "FeePrgrammeModel [fpidNo=" + fpidNo + ", regNo=" + regNo + ", status=" + status + ", stream=" + stream
//				+ ", feeAmt=" + feeAmt + ", feeDiscount=" + feeDiscount + ", feePercentage=" + feePercentage
//				+ ", feeDefineModel=" + feeDefineModel + "]";
//	}
	
	

}
