package com.service.spring.DTO;

public class ResumeCommentDTO {
	private String content;
    private double rate;
    private String userId;
    private String companyName;
    
	public ResumeCommentDTO() {
		super();
	}

	public ResumeCommentDTO(String content, double rate, String userId, String companyName) {
		super();
		this.content = content;
		this.rate = rate;
		this.userId = userId;
		this.companyName = companyName;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "ResumeCommentDTO [content=" + content + ", rate=" + rate + ", userId=" + userId + ", companyName="
				+ companyName + "]";
	}
    
	
    
}
