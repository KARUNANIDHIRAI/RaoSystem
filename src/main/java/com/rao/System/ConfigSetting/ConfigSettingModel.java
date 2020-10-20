package com.rao.System.ConfigSetting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;


@Entity
//@Table(name ="kRwaConfigSetting")
@Table(name ="RwaConfiguration" )
@DynamicInsert
public class ConfigSettingModel implements Serializable {

	@Id
	@Column(name ="RwaNo", nullable=false, columnDefinition = "nvarchar(100)", updatable = false)
	private String RWANO;
	
	@Id
	@Column(name ="NameType", nullable=false, columnDefinition = "nvarchar(100)" , updatable = false)
	private String NameType;
	
	@Column(name ="IDNO" , nullable=false)
	private int iDNO;
	
	@Column(name ="PrefixStartNo", nullable=false, columnDefinition = "nvarchar(100)")
	private String PrefixStartNo;
	
	@Column(name ="StartNo",nullable=false, columnDefinition = "int")
	private int StartNo;

	@Column(name ="LastNo",nullable=true, columnDefinition = "int")
	private int LastNo;
	
	
	@Column(name ="Status",nullable=false, columnDefinition = "nvarchar(1)")
	@ColumnDefault(value = "'A'")
	private String Status;
	
	@Column(name ="CreatedOn", nullable=false, columnDefinition = "datetime" , updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date CreatedOn;
	
	@Column(name ="CreatedBy", nullable=false, columnDefinition = "nvarchar(255)", updatable = false)
	private String CreatedBy;

	@Column(name ="UpdatedOn", nullable=false, columnDefinition = "datetime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date UpdatedOn;
	
	@Column(name ="UpdatedBy", nullable=false, columnDefinition = "nvarchar(255)")
	private String UpdatedBy;

	public String getRwaNo() {
		return RWANO;
	}

	public void setRwaNo(String rwaNo) {
		RWANO = rwaNo;
	}

	public String getNameType() {
		return NameType;
	}

	public void setNameType(String nameType) {
		NameType = nameType;
	}

	public int getiDNO() {
		return iDNO;
	}

	public void setiDNO(int iDNO) {
		this.iDNO = iDNO;
	}

	public String getPrefixStartNo() {
		return PrefixStartNo;
	}

	public void setPrefixStartNo(String prefixStartNo) {
		PrefixStartNo = prefixStartNo;
	}

	public int getStartNo() {
		return StartNo;
	}

	public void setStartNo(int startNo) {
		StartNo = startNo;
	}

	public int getLastNo() {
		return LastNo;
	}

	public void setLastNo(int lastNo) {
		LastNo = lastNo;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(Date createdOn) {
		CreatedOn = createdOn;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "ConfigSettingModel [RwaNo=" + RWANO + ", NameType=" + NameType + ", iDNO=" + iDNO + ", PrefixStartNo="
				+ PrefixStartNo + ", StartNo=" + StartNo + ", LastNo=" + LastNo + ", Status=" + Status + ", CreatedOn="
				+ CreatedOn + ", CreatedBy=" + CreatedBy + ", UpdatedOn=" + UpdatedOn + ", UpdatedBy=" + UpdatedBy
				+ "]";
	}
}
