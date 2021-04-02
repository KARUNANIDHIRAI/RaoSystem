package com.sm.System.StudentPersonalInfo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sm.System.SchoolInformation.SchoolInfoModel;


	@Entity 
	@Table(name = "SMStudentIdDetail")
	public class SIdProof implements Serializable{
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name = "IDNO")
			private Integer idNo;
			
			
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "sIdNo")
			private StudentPersonalInfoModel SidProof;
			
			@Column(name="RegNO", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
			private String regNo;

			@Column(name="IdProof", nullable= true , updatable = false, columnDefinition = "nvarchar(100)")
			private String idProof;
			
			@Column(name="IDDocType", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
			private String idDocType;

			@Column(name="IdHolder", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
			private String idHolder;
			
			@Column(name="Status", nullable= false , updatable = false, columnDefinition = "nvarchar(100)")
			private String status;

			public Integer getIdNo() {
				return idNo;
			}

			public void setIdNo(Integer idNo) {
				this.idNo = idNo;
			}

			public StudentPersonalInfoModel getSidProof() {
				return SidProof;
			}

			public void setSidProof(StudentPersonalInfoModel sidProof) {
				SidProof = sidProof;
			}

			public String getRegNo() {
				return regNo;
			}

			public void setRegNo(String regNo) {
				this.regNo = regNo;
			}

			public String getIdProof() {
				return idProof;
			}

			public void setIdProof(String idProof) {
				this.idProof = idProof;
			}

			public String getIdDocType() {
				return idDocType;
			}

			public void setIdDocType(String idDocType) {
				this.idDocType = idDocType;
			}

			public String getIdHolder() {
				return idHolder;
			}

			public void setIdHolder(String idHolder) {
				this.idHolder = idHolder;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

//			@Override
//			public String toString() {
//				return "SIdProof [idNo=" + idNo + ", SidProof=" + SidProof + ", regNo=" + regNo + ", idProof=" + idProof
//						+ ", idDocType=" + idDocType + ", idHolder=" + idHolder + ", status=" + status + "]";
//			}

			
}
