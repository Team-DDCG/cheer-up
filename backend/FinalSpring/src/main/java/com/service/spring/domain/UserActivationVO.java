package com.service.spring.domain;

public class UserActivationVO {
    private int activationId; //activation_id(pk)
    private String activationName; //activation_name
    private String startDate; //start_date
    private String endDate; //end_date
    private String content;
    private int seekerId; //seeker_id(fk)

    public UserActivationVO() {
    }

    public UserActivationVO(String activationName, String startDate, String endDate, String content, int seekerId) {
        this.activationName = activationName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
        this.seekerId = seekerId;
    }

    public int getActivationId() {
        return activationId;
    }

    public void setActivationId(int activationId) {
        this.activationId = activationId;
    }

    public String getActivationName() {
        return activationName;
    }

    public void setActivationName(String activationName) {
        this.activationName = activationName;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public String toString() {
        return "UserActivationVO{" +
                "activationId=" + activationId +
                ", activationName='" + activationName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", content='" + content + '\'' +
                ", seekerId=" + seekerId +
                '}';
    }
}
