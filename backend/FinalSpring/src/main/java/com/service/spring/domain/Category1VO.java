package com.service.spring.domain;

public class Category1VO {
	private int category1Id; // category1_id(pk)
    private String name; // c1_name

    public Category1VO() {
    }

    public Category1VO(String c1Name) {
        this.name = c1Name;
    }

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