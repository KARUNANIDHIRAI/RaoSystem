package com.raoSystem.Utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Country")
public class CountryList {
		
		@Id
		@GeneratedValue
		@Column(name = "Code")
		private String Code;
		private String Name;
		public String getCode() {
			return Code;
		}
		public void setCode(String code) {
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
			return "CountryList [Code=" + Code + ", Name=" + Name + "]";
		}

}
