package com.service.spring.DTO;

public class CategoryDTO {
	private int category1No;
	private int category2No;
	private int seekerId;
	
	public CategoryDTO(int category1No, int category2No) {
		super();
		this.category1No = category1No;
		this.category2No = category2No;
	}

	public CategoryDTO() {
		super();
	}

	public int getCategory1No() {
		return category1No;
	}

	public void setCategory1No(int category1No) {
		this.category1No = category1No;
	}

	public int getCategory2No() {
		return category2No;
	}

	public void setCategory2No(int category2No) {
		this.category2No = category2No;
	}

	public int getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}

	@Override
	public String toString() {
		return "CategoryDTO [category1No=" + category1No + ", category2No=" + category2No + ", seekerId=" + seekerId
				+ "]";
	}
	
	
	

}
