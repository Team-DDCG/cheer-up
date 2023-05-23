package com.service.spring.DTO;

public class ResumeCommentDTO {
	private String content;
    private double rate;
    private String id;
    private String companyName;
    
	public ResumeCommentDTO() {
		super();
	}

	public ResumeCommentDTO(String content, double rate, String userId, String companyName) {
		super();
		this.content = content;
		this.rate = rate;
		this.id = userId;
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
		return id;
	}

	public void setUserId(String userId) {
		this.id = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "ResumeCommentDTO [content=" + content + ", rate=" + rate + ", userId=" + id + ", companyName="
				+ companyName + "]";
	}
    
	
    
}
