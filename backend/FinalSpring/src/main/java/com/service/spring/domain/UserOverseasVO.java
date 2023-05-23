package com.service.spring.domain;

public class UserOverseasVO {
    private int overseasId; //overseas_id(pk)
    private String purpose;
    private String nation;
    private String startDate; //start_date
    private String endDate; //end_date
    private String institution;
    private String reason;
    private int seekerId; //seeker_id(fk)

    public UserOverseasVO() {
    }

    public UserOverseasVO(String purpose, String nation, String startDate, String endDate, String institution, String reason, int seekerId) {
        this.purpose = purpose;
        this.nation = nation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.institution = institution;
        this.reason = reason;
        this.seekerId = seekerId;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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
                ", institution='" + institution + '\'' +
                ", reason='" + reason + '\'' +
                ", seekerId=" + seekerId +
                '}';
    }
}
