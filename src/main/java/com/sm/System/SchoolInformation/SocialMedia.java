package com.sm.System.SchoolInformation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author KN RAI
 *
 */
@Entity 
@Table(name = "SMSocialMedia")
public class SocialMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDNO")
	private Integer idNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RegNo", columnDefinition = "nvarchar(100)")
	private SchoolInfoModel sMedia;
	
	@Column(name= "Category", nullable= false,columnDefinition = "nvarchar(100)")
	private String category;
	
	@Column(name="SMediaName", nullable= false,columnDefinition = "nvarchar(200)")
	private String sMediaName;

	public Integer getIdNo() {
		return idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public SchoolInfoModel getsMedia() {
		return sMedia;
	}

	public void setsMedia(SchoolInfoModel sMedia) {
		this.sMedia = sMedia;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public String getsMediaName() {
		return sMediaName;
	}

	public void setsMediaName(String sMediaName) {
		this.sMediaName = sMediaName;
	}

	@Override
	public String toString() {
		return "SocialMedia [idNo=" + idNo + ", sMedia=" + sMedia + ", category=" + category + ", sMediaName="
				+ sMediaName + "]";
	}

	

	
}
	

