package com.service.spring.domain;

public class Category2VO {
    private int category2Id; //category2_id (pk)
    private String c2Name; //name
    private int category1Id; //category1_id(fk)'
    private String c1Name; //name ->category1

    public Category2VO() {
    }

	public Category2VO(String c2Name, int category1Id, String c1Name) {
		this.c2Name = c2Name;
		this.category1Id = category1Id;
		this.c1Name = c1Name;
	}

	public int getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(int category2Id) {
		this.category2Id = category2Id;
	}

	public String getC2Name() {
		return c2Name;
	}

	public void setC2Name(String c2Name) {
		this.c2Name = c2Name;
	}

	public int getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(int category1Id) {
		this.category1Id = category1Id;
	}

	public String getC1Name() {
		return c1Name;
	}

	public void setC1Name(String c1Name) {
		this.c1Name = c1Name;
	}

	@Override
	public String toString() {
		return "Category2VO [category2Id=" + category2Id + ", c2Name=" + c2Name + ", category1Id=" + category1Id
				+ ", c1Name=" + c1Name + "]";
	}

    
}
