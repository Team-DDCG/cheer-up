package com.service.spring.domain;

public class UserMentorVO {
    private int mentorId; //mentor_id(pk)
    private String companyName; //company_name
    private String career;
    private double rating;
    private int userId; //user_id(fk)

    public UserMentorVO() {
    }

    public UserMentorVO(String companyName, String career, int id,  double rating) {
        this.companyName = companyName;
        this.career = career;
        this.rating = rating;
        this.userId = id;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "UserMentorVO{" +
                "mentorId=" + mentorId +
                ", companyName='" + companyName + '\'' +
                ", userId=" + userId +
                ", career='" + career + '\'' +
                ", rating=" + rating +
                '}';
    }
}
