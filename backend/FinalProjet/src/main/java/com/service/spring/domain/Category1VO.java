package com.service.spring.domain;

public class Category1VO {
    private int category1Id; //category1_id(pk)
    private String name;

    public Category1VO() {
    }

    public Category1VO(int category1Id, String name) {
        this.category1Id = category1Id;
        this.name = name;
    }

    public int getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(int category1Id) {
        this.category1Id = category1Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category1VO{" +
                "category1Id=" + category1Id +
                ", name='" + name + '\'' +
                '}';
    }
}
