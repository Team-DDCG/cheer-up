package com.service.spring.domain;

import java.sql.Date;

public class UserLicenseVO {
    private int licenseId; //license_id
    private String name;
    private String grade;
    private Date acquiredDate; //acquired_date
    private String licenseNumber; //license_number
    private String agency;
    private int seekerId; //seeker_id(fk)

    public UserLicenseVO() {
    }

    public UserLicenseVO(String name, String grade, Date acquiredDate, String licenseNumber, String agency) {
        this.name = name;
        this.grade = grade;
        this.acquiredDate = acquiredDate;
        this.licenseNumber = licenseNumber;
        this.agency = agency;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public int getUserSeekerInfoId() {
        return seekerId;
    }

    public void setUserSeekerInfoId(int userSeekerInfoId) {
        this.seekerId = userSeekerInfoId;
    }

    @Override
    public String toString() {
        return "UserLicenseVO{" +
                "licenseId=" + licenseId +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", acquiredDate=" + acquiredDate +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", agency='" + agency + '\'' +
                ", userSeekerInfoId=" + seekerId +
                '}';
    }
}
