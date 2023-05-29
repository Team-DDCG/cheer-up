package com.service.spring.DTO;

public class PositionDTO {
	private int companyId;
	private int seekerId;
	private String position;
	
	
	public PositionDTO(int companyId, int seekerId, String position) {
		super();
		this.companyId = companyId;
		this.seekerId = seekerId;
		this.position = position;
	}
	public PositionDTO() {
		super();
	}
	
	
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getSeekerId() {
		return seekerId;
	}
	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
