package com.service.spring.domain;

import java.sql.Date;

public class UserSchoolVO {
    private int schoolId; // school_id(pk)
    private int educationType; //education_type
    private String schoolName;
    private Date entranceDate;
    private Date graduationDate;
    private String major;
    private int attendingCheck;
    private int transferCheck;
    private String gpa;
    private int highestCheck;
    private String doubleMajor;
    private int seekerId; //seeker_id(fk)

    public UserSchoolVO() {
    }

    public UserSchoolVO(int educationType, String schoolName, Date entranceDate, Date graduationDate, String major, int attendingCheck, int transferCheck, String gpa, int highestCheck, String doubleMajor) {
        this.educationType = educationType;
        this.schoolName = schoolName;
        this.entranceDate = entranceDate;
        this.graduationDate = graduationDate;
        this.major = major;
        this.attendingCheck = attendingCheck;
        this.transferCheck = transferCheck;
        this.gpa = gpa;
        this.highestCheck = highestCheck;
        this.doubleMajor = doubleMajor;
    }

    public int getSchoolInfoId() {
        return schoolId;
    }

    public void setSchoolInfoId(int schoolInfoId) {
        this.schoolId = schoolInfoId;
    }

    public int getEducationType() {
        return educationType;
    }

    public void setEducationType(int educationType) {
        this.educationType = educationType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAttendingCheck() {
        return attendingCheck;
    }

    public void setAttendingCheck(int attendingCheck) {
        this.attendingCheck = attendingCheck;
    }

    public int getTransferCheck() {
        return transferCheck;
    }

    public void setTransferCheck(int transferCheck) {
        this.transferCheck = transferCheck;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public int getHighestCheck() {
        return highestCheck;
    }

    public void setHighestCheck(int highestCheck) {
        this.highestCheck = highestCheck;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public String getDoubleMajor() {
        return doubleMajor;
    }

    public void setDoubleMajor(String doubleMajor) {
        this.doubleMajor = doubleMajor;
    }

    @Override
    public String toString() {
        return "UserSchoolVO{" +
                "schoolInfoId=" + schoolId +
                ", educationType=" + educationType +
                ", schoolName='" + schoolName + '\'' +
                ", entranceDate=" + entranceDate +
                ", graduationDate=" + graduationDate +
                ", major='" + major + '\'' +
                ", attendingCheck=" + attendingCheck +
                ", transferCheck=" + transferCheck +
                ", gpa='" + gpa + '\'' +
                ", highestCheck=" + highestCheck +
                ", seekerId=" + seekerId +
                ", doubleMajor='" + doubleMajor + '\'' +
                '}';
    }
}
