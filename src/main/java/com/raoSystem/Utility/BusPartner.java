package com.raoSystem.Utility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Collaboration")
public class BusPartner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Code")
	private int Code;
	private String Name;

	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "BusPartner [Code=" + Code + ", Name=" + Name + "]";
	}

}
