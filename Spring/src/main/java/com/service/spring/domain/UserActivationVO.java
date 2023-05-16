package com.service.spring.domain;

import java.sql.Date;

public class UserActivationVO {
    private int activationId; //activation_id(pk)
    private String name;
    private Date startDate; //start_date
    private Date endDate; //end_date
    private String content;
    private int seekerId; //seeker_id(fk)

    public UserActivationVO() {
    }

    public UserActivationVO(String name, Date startDate, Date endDate, String content) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
    }

    public int getActivationId() {
        return activationId;
    }

    public void setActivationId(int activationId) {
        this.activationId = activationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserSeekerInfoId() {
        return seekerId;
    }

    public void setUserSeekerInfoId(int userSeekerInfoId) {
        this.seekerId = userSeekerInfoId;
    }

    @Override
    public String toString() {
        return "UserActivationVO{" +
                "activationId=" + activationId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", content='" + content + '\'' +
                ", userSeekerInfoId=" + seekerId +
                '}';
    }
}
