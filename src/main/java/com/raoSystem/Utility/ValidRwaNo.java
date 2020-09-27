package com.raoSystem.Utility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "RwaRegistration")
public class ValidRwaNo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "RegNo")
	private String RegNo;

	public String getRegNo() {
		return RegNo;
	}

	public void setRegNo(String regNo) {
		RegNo = regNo;
	}

	@Override
	public String toString() {
		return "ValidRwaNo [RegNo=" + RegNo + "]";
	}
	

}
