package com.sm.System.SchoolInformation;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.raoSystem.Utility.CountryList;

	/**
	 * @author KN RAI
	 *
	 */
	@Entity 
	@Table(name = "SMEmail")
	public class Email implements Serializable{
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name = "IDNO")
			private Integer idNo;
			
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "RegNo", columnDefinition = "nvarchar(100)")
			private SchoolInfoModel schEmail;
			
			@Column(name= "EmailID", nullable= false,columnDefinition = "nvarchar(100)", unique=true)
			private String emailID;

			
			@Column(name= "Category", nullable= false,columnDefinition = "nvarchar(100)")
			private String category;


			public Integer getIdNo() {
				return idNo;
			}
			public void setIdNo(Integer idNo) {
				this.idNo = idNo;
			}
			public SchoolInfoModel getSchEmail() {
				return schEmail;
			}
			public void setSchEmail(SchoolInfoModel schEmail) {
				this.schEmail = schEmail;
			}
			public String getEmailID() {
				return emailID;
			}
			public void setEmailID(String emailID) {
				this.emailID = emailID;
			}
			public String getCategory() {
				return category;
			}
			public void setCategory(String category) {
				this.category = category;
			}
			@Override
			public String toString() {
				return "Email [idNo=" + idNo + ", schEmail=" + schEmail + ", emailID=" + emailID + ", category="
						+ category + "]";
			}
	}	

