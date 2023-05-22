package com.service.spring.domain;

public class Category1VO {
	private int category1Id; // category1_id(pk)
    private String name; // c1_name

    public Category1VO() {
    }

<<<<<<< HEAD
    public Category1VO(int category1Id, String c1Name) {
        this.category1Id = category1Id;
        this.name = c1Name;
    }
=======
	public Category1VO(String c1Name) {
		this.c1Name = c1Name;
	}
>>>>>>> f3e91eabad5a549a3856991f0b18f91630cdd3f5

    public int getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(int category1Id) {
        this.category1Id = category1Id;
    }

    public String getC1Name() {
        return name;
    }

    public void setC1Name(String c1Name) {
        this.name = c1Name;
    }

    @Override
    public String toString() {
        return "Category1VO [category1Id=" + category1Id + ", c1Name=" + name + "]";
    }
}