package com.service.spring.domain;

import java.sql.Date;

public class UserLicenseVO {
    private int licenseId; //license_id(pk)
    private String licenseName; //license_name
    private String grade;
    private Date acquiredDate; //acquired_date
    private String licenseNumber; //license_number
    private String agency;
    private int seekerId; //seeker_id(fk)

    public UserLicenseVO() {
    }

    public UserLicenseVO(String licenseName, String grade, Date acquiredDate, String licenseNumber, String agency, int seekerId) {
        this.licenseName = licenseName;
        this.grade = grade;
        this.acquiredDate = acquiredDate;
        this.licenseNumber = licenseNumber;
        this.agency = agency;
        this.seekerId = seekerId;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
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

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public String toString() {
        return "UserLicenseVO{" +
                "licenseId=" + licenseId +
                ", licenseName='" + licenseName + '\'' +
                ", grade='" + grade + '\'' +
                ", acquiredDate=" + acquiredDate +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", agency='" + agency + '\'' +
                ", seekerId=" + seekerId +
                '}';
    }
}
