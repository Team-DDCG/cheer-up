package com.service.spring.domain;

public class UserCareerVO {
    private int carrerId;
    private String companyName;
    private String department;
    private String position;
    private String startDate;
    private String endDate;
    private int attendingCheck;
    private int hireType;
    private int seekerId;

    public UserCareerVO() {
    }

    public UserCareerVO(String companyName, String department, String position, String startDate, String endDate, int attendingCheck, int hireType, int seekerId) {
        this.companyName = companyName;
        this.department = department;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attendingCheck = attendingCheck;
        this.hireType = hireType;
        this.seekerId = seekerId;
    }

    public int getCarrerId() {
        return carrerId;
    }

    public void setCareerId(int carrerId) {
        this.carrerId = carrerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getAttendingCheck() {
        return attendingCheck;
    }

    public void setAttendingCheck(int attendingCheck) {
        this.attendingCheck = attendingCheck;
    }

    public int getHireType() {
        return hireType;
    }

    public void setHireType(int hireType) {
        this.hireType = hireType;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public String toString() {
        return "UserCareerVO{" +
                "carrerId=" + carrerId +
                ", companyName='" + companyName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", attendingCheck=" + attendingCheck +
                ", hireType=" + hireType +
                ", seekerId=" + seekerId +
                '}';
    }
}
