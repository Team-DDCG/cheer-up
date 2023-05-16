package com.service.spring.domain;

public class ResumeVO {
    private int resumeId; //resume_id(pk)
    private String content;
    private int postCheck; //post_check
    private String companyName; //company_name;
    private int commentId; //comment_id(fk)
    private int seekerId; //seeker_id(fk)

    public ResumeVO() {
    }

    public ResumeVO(String content, int postCheck, String companyName) {
        this.content = content;
        this.postCheck = postCheck;
        this.companyName = companyName;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostCheck() {
        return postCheck;
    }

    public void setPostCheck(int postCheck) {
        this.postCheck = postCheck;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserSeekerInfoId() {
        return seekerId;
    }

    public void setUserSeekerInfoId(int userSeekerInfoId) {
        this.seekerId = userSeekerInfoId;
    }

    @Override
    public String toString() {
        return "ResumeVO{" +
                "resumeId=" + resumeId +
                ", content='" + content + '\'' +
                ", postCheck=" + postCheck +
                ", companyName='" + companyName + '\'' +
                ", commentId=" + commentId +
                ", userSeekerInfoId=" + seekerId +
                '}';
    }
}
