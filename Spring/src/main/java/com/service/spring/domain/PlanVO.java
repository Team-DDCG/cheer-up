package com.service.spring.domain;

public class PlanVO {
    private int planId; //plan_id(pk)
    private String name;
    private int price;

    public PlanVO() {
    }

    public PlanVO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PlanVO{" +
                "planId=" + planId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
