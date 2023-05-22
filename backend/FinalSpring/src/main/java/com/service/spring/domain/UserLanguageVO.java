package com.service.spring.domain;

import java.sql.Date;

public class UserLanguageVO {
    private int languageId; //language_id(pk)
    private String language;
    private String type;
    private String grade;
    private Date acquiredDate; //acquired_date;
    private String licenseNumber; //license_number;
    private String agency;
    private int seekerId; //seeker_id(fk)

    public UserLanguageVO() {
    }

    public UserLanguageVO(String language, String type, String grade, Date acquiredDate, String licenseNumber, String agency, int seekerId) {
        this.language = language;
        this.type = type;
        this.grade = grade;
        this.acquiredDate = acquiredDate;
        this.licenseNumber = licenseNumber;
        this.agency = agency;
        this.seekerId = seekerId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getUserSeekerInfoId() {
        return seekerId;
    }

    public void setUserSeekerInfoId(int userSeekerInfoId) {
        this.seekerId = userSeekerInfoId;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "UserLanguageVO{" +
                "languageId=" + languageId +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                ", acquiredDate=" + acquiredDate +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", userSeekerInfoId=" + seekerId +
                ", agency='" + agency + '\'' +
                '}';
    }
}
