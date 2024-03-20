package com.ljh.dto;

public class MainDTO {
	private String id = null;
	private String pwd = null;
	
	public MainDTO(String id,String pwd) {
		this.id=id;
		this.pwd=pwd;
	}
	
	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
