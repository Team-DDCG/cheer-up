package com.service.spring.domain;


import org.springframework.web.multipart.MultipartFile;

public class UserSeekerVO {
    private int seekerId; //user_seeker_id (pk)
    private String ename;
    private String cname;
    private int military;
    private int bohun;
    private int disabled;
    private int userId; //user_id(fk)
    private int limitId; //limit_id(fk)
    private String nation;
    private MultipartFile profile;

    public UserSeekerVO() {
    }

    public UserSeekerVO(String ename, String cname, int military, int bohun, int disabled, String nation, MultipartFile profile) {
        this.ename = ename;
        this.cname = cname;
        this.military = military;
        this.bohun = bohun;
        this.disabled = disabled;
        this.nation = nation;
        this.profile = profile;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getMilitary() {
        return military;
    }

    public void setMilitary(int military) {
        this.military = military;
    }

    public int getBohun() {
        return bohun;
    }

    public void setBohun(int bohun) {
        this.bohun = bohun;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLimitId() {
        return limitId;
    }

    public void setLimitId(int limitId) {
        this.limitId = limitId;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public MultipartFile getProfile() {
        return profile;
    }

    public void setProfile(MultipartFile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "UserSeekerVO{" +
                "seekerId=" + seekerId +
                ", ename='" + ename + '\'' +
                ", cname='" + cname + '\'' +
                ", military=" + military +
                ", bohun=" + bohun +
                ", disabled=" + disabled +
                ", userId=" + userId +
                ", limitId=" + limitId +
                ", nation='" + nation + '\'' +
                ", profile=" + profile +
                '}';
    }
}
