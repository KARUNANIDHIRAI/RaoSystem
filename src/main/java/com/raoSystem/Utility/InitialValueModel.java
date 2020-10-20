package com.raoSystem.Utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "InitialValue")
public class InitialValueModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "IDNO", nullable= false, updatable= false, columnDefinition= "int")
	private int IDNO;
	
	@Column(name = "Name",nullable= false, updatable= true, columnDefinition= "nvarchar(100)")
	private String Name;
	
	@Column(name = "Status",nullable= false, updatable= true, columnDefinition= "nvarchar(1)")
	private String Status;

	public int getIDNO() {
		return IDNO;
	}

	public void setIDNO(int iDNO) {
		IDNO = iDNO;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	@Override
	public String toString() {
		return "InitialValueModel [IDNO=" + IDNO + ", Name=" + Name + ", Status=" + Status + "]";
	}
}
