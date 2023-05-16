package com.service.spring.domain;

public class Category2VO {
    private int category2Id; //category2_id (pk)
    private String name;
    private int category1Id; //category1_id(fk)

    public Category2VO() {
    }

    public Category2VO(String name) {
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

    public int getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(int category1Id) {
        this.category1Id = category1Id;
    }

    @Override
    public String toString() {
        return "Category2VO{" +
                "category2Id=" + category2Id +
                ", name='" + name + '\'' +
                ", category1Id=" + category1Id +
                '}';
    }
}
