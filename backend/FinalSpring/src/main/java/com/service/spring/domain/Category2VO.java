package com.service.spring.domain;

public class Category2VO {
    private int category2Id; //category2_id (pk)
    private String name; //name

    public Category2VO() {
    }

	public Category2VO(int category2Id, String name) {
		super();
		this.category2Id = category2Id;
		this.name = name;
	}

	public int getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(int category2Id) {
		this.category2Id = category2Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category2VO [category2Id=" + category2Id + ", name=" + name + "]";
	}

	
	
    
}
