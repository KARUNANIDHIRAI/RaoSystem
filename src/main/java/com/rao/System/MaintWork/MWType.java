package com.rao.System.MaintWork;

public class MWType {
	String id;
	String name;

	public MWType(String MaintWorkTypeCode, String MaintWorkTypeName) {
		super();
		this.id= MaintWorkTypeCode;
		this.name=MaintWorkTypeName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
