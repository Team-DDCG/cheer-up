package com.service.spring.domain;

import java.sql.Date;

public class UserOverseasVO {
    private int overseasId; //overseas_id(pk)
    private String purpose;
    private String nation;
    private Date startDate; //start_date
    private Date endDate; //end_date
    private String agency;
    private String reason;
    private int seekerId; //seeker_id(fk)

    public UserOverseasVO() {
    }

    public UserOverseasVO(String purpose, String nation, Date startDate, Date endDate, String agency, String reason) {
        this.purpose = purpose;
        this.nation = nation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.agency = agency;
        this.reason = reason;
    }

    public int getOverseasId() {
        return overseasId;
    }

    public void setOverseasId(int overseasId) {
        this.overseasId = overseasId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public String toString() {
        return "UserOverseasVO{" +
                "overseasId=" + overseasId +
                ", purpose='" + purpose + '\'' +
                ", nation='" + nation + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", agency='" + agency + '\'' +
                ", reason='" + reason + '\'' +
                ", seekerId=" + seekerId +
                '}';
    }
}
