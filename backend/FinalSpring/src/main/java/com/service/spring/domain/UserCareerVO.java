package com.service.spring.domain;

import java.sql.Date;

public class UserCareerVO {
    private int careerId; //career_id(pk)
    private String companyName; //company_name
    private String department;
    private String position;
    private Date startDate; //start_date
    private Date endDate; //end_date
    private int attendingCheck; //attending_check
    private int hireType; //hire_type
    private int seekerId; // seeker_id(fk)

    public UserCareerVO() {
    }

    public UserCareerVO(String companyName, String department, String position, Date startDate, Date endDate, int attendingCheck, int hireType) {
        this.companyName = companyName;
        this.department = department;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attendingCheck = attendingCheck;
        this.hireType = hireType;
    }

    public int getCareerId() {
        return careerId;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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

    public int getUserSeekerInfoId() {
        return seekerId;
    }

    public void setUserSeekerInfoId(int userSeekerInfoId) {
        this.seekerId = userSeekerInfoId;
    }

    @Override
    public String toString() {
        return "UserCareerVO{" +
                "careerId=" + careerId +
                ", companyName='" + companyName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", attendingCheck=" + attendingCheck +
                ", hireType=" + hireType +
                ", userSeekerInfoId='" + seekerId + '\'' +
                '}';
    }
}
