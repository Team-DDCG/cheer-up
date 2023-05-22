package com.service.spring.domain;

public class ResumeCommentVO {
    private int commentId; //comment_id(pk)
    private String content;
    private double rate;
    private int mentorId; //mentor_id(fk)
    private int resumeId; //resume_id(fk)

    public ResumeCommentVO() {
    }

	public ResumeCommentVO(String content, double rate, int mentorId, int resumeId) {
		this.content = content;
		this.rate = rate;
		this.mentorId = mentorId;
		this.resumeId = resumeId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	@Override
	public String toString() {
		return "ResumeCommentVO [commentId=" + commentId + ", content=" + content + ", rate=" + rate + ", mentorId="
				+ mentorId + ", resumeId=" + resumeId + "]";
	}

    
}
