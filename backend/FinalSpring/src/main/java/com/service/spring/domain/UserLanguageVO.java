package com.service.spring.domain;

public class UserLanguageVO {
    private int languageId; //language_id(pk)
    private String language;
    private String type;
    private String grade;
    private String acquiredDate; //acquired_date;
    private String licenseNumber; //license_number;
    private int seekerId; //seeker_id(fk)
    private String agency;

    public UserLanguageVO() {
    }

    public UserLanguageVO(String language, String type, String grade, String acquiredDate, String licenseNumber, String agency, int seekerId) {
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

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(String acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
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
