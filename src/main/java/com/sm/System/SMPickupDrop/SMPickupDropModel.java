package com.sm.System.SMPickupDrop;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.sm.System.SMUtility.SMDataCreatedUpdated;
import com.sm.System.StudentPersonalInfo.StudentPersonalInfoModel;
import com.sm.System.Transport.RouteModel;
import com.sm.System.Transport.RoutePickUpDropModel;

@Entity
@Table(name ="SMPickupDrop")
public class SMPickupDropModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "PDiDNO")
		private Integer pDiDNO;
		
		@Column(name="RegNO", nullable= false , updatable = false)
		private String regNo;
		
		@Column(name="AdmNo", nullable= false, updatable = false)
		private String admNo;

		@Column(name="Section", nullable= true)
		private String section;
		
		@Column(name="SClass", nullable= true)
		private String sClass;
		
		@Column(name="PDDescription", nullable= true)
		private String PDDescription;

		@OneToOne
        @JoinColumn(name="StudentSIdNoFK")
        private StudentPersonalInfoModel StudentSIdNoFK;
        
        @OneToOne
        @JoinColumn(name="RoutePDiDNOFK")
        private RoutePickUpDropModel RoutePDiDNOFK;
        
		@Column(name="Status", nullable= false)
		@ColumnDefault("'A'") // A=Active status
		private String status;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "iDNOFK")
		private RouteModel PickUpDropModel;
		
		@Embedded
		private SMDataCreatedUpdated userRefInfo;


		public Integer getpDiDNO() {
			return pDiDNO;
		}


		public void setpDiDNO(Integer pDiDNO) {
			this.pDiDNO = pDiDNO;
		}


		public String getRegNo() {
			return regNo;
		}


		public void setRegNo(String regNo) {
			this.regNo = regNo;
		}


		public String getAdmNo() {
			return admNo;
		}


		public void setAdmNo(String admNo) {
			this.admNo = admNo;
		}


		public String getSection() {
			return section;
		}


		public void setSection(String section) {
			this.section = section;
		}


		public String getsClass() {
			return sClass;
		}


		public void setsClass(String sClass) {
			this.sClass = sClass;
		}


		public String getPDDescription() {
			return PDDescription;
		}


		public void setPDDescription(String pDDescription) {
			PDDescription = pDDescription;
		}


		public StudentPersonalInfoModel getStudentSIdNoFK() {
			return StudentSIdNoFK;
		}


		public void setStudentSIdNoFK(StudentPersonalInfoModel studentSIdNoFK) {
			StudentSIdNoFK = studentSIdNoFK;
		}


		public RoutePickUpDropModel getRoutePDiDNOFK() {
			return RoutePDiDNOFK;
		}


		public void setRoutePDiDNOFK(RoutePickUpDropModel routePDiDNOFK) {
			RoutePDiDNOFK = routePDiDNOFK;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public RouteModel getPickUpDropModel() {
			return PickUpDropModel;
		}


		public void setPickUpDropModel(RouteModel pickUpDropModel) {
			PickUpDropModel = pickUpDropModel;
		}


		public SMDataCreatedUpdated getUserRefInfo() {
			return userRefInfo;
		}


		public void setUserRefInfo(SMDataCreatedUpdated userRefInfo) {
			this.userRefInfo = userRefInfo;
		}

}
