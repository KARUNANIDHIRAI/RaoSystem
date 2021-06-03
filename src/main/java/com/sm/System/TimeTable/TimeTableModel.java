package com.sm.System.TimeTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name="SMTimeTable",
        uniqueConstraints= @UniqueConstraint(columnNames={"regNo", "classTT","section","subject"})
    )
public class TimeTableModel {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name="TTIdNo", nullable= false , updatable = false, columnDefinition
	  = "Integer") private Integer tTIdNo;
	  
	  @Column(name="RegNO", nullable= false , updatable = false, columnDefinition =
	  "nvarchar(100)") private String regNo;
	  
	  @Column(name="Subject", nullable= false ,updatable = true, columnDefinition =
	  "nvarchar(100)") private String subject;
	  
	  @Column(name="ClassTT", nullable= false, updatable = true,columnDefinition = "nvarchar(100)")
	  private String classTT;
	  
	  @Column(name="Section", nullable= false, updatable = true, columnDefinition =
	  "nvarchar(10)") private String section;
	  
	  @Column(name="TotalHours", nullable= true, updatable = true, columnDefinition
	  = "Integer") private Integer totalHours;
	  
	  @OneToMany(cascade = CascadeType.ALL,mappedBy = "timeTableModel") private
	  List<TimeTableDetailModel> TTDetailModel= new ArrayList<>();
	  
	  @Column(name= "CreatedBy", nullable= false,updatable = false,
	  columnDefinition = "nvarchar(100)") private String createdBy;
	  
	  @Column(name= "CreatedOn", nullable= false,updatable = false,
	  columnDefinition = "date")
	  
	  @Temporal(TemporalType.TIMESTAMP) private Date createdOn;
	  
	  @Column(name= "UpdatedBy", nullable= false,columnDefinition =
	  "nvarchar(100)") private String updatedBy;
	  
	  @Column(name= "UpdatedOn", nullable= false,columnDefinition = "date")
	  
	  @Temporal(TemporalType.TIMESTAMP) private Date updatedOn;
	  
	  @Column(name= "Status", nullable= false,columnDefinition = "nvarchar(100)")
	  private String status;
	  
	  public Integer gettTIdNo() { return tTIdNo; }
	  
	  public void settTIdNo(Integer tTIdNo) { this.tTIdNo = tTIdNo; }
	  
	  public String getRegNo() { return regNo; }
	  
	  public void setRegNo(String regNo) { this.regNo = regNo; }
	  
	  public String getSubject() { return subject; }
	  
	  public void setSubject(String subject) { this.subject = subject; }
	  
	  public String getClassTT() { return classTT; }
	  
	  public void setClassTT(String classTT) { this.classTT = classTT; }
	  
	  public String getSection() { return section; }
	  
	  public void setSection(String section) { this.section = section; }
	  
	  public Integer getTotalHours() { return totalHours; }
	  
	  public void setTotalHours(Integer totalHours) { this.totalHours = totalHours;
	  }
	  
	  public List<TimeTableDetailModel> getTTDetailModel() { return TTDetailModel;
	  }
	  
	  public void setTTDetailModel(List<TimeTableDetailModel> tTDetailModel) {
	  TTDetailModel = tTDetailModel; }
	  
	  public String getCreatedBy() { return createdBy; }
	  
	  public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	  
	  public Date getCreatedOn() { return createdOn; }
	  
	  public void setCreatedOn(Date createdOn) { this.createdOn = createdOn; }
	  
	  public String getUpdatedBy() { return updatedBy; }
	  
	  public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
	  
	  public Date getUpdatedOn() { return updatedOn; }
	  
	  public void setUpdatedOn(Date updatedOn) { this.updatedOn = updatedOn; }
	  
	  public String getStatus() { return status; }
	  
	  public void setStatus(String status) { this.status = status; }

	@Override
	public String toString() {
		return "TimeTableModel [tTIdNo=" + tTIdNo + ", regNo=" + regNo + ", subject=" + subject + ", classTT=" + classTT
				+ ", section=" + section + ", totalHours=" + totalHours + ", TTDetailModel=" + TTDetailModel
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + ", status=" + status + "]";
	}
	  

}
