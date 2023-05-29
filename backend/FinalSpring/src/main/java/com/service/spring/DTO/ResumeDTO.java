package com.service.spring.DTO;

public class ResumeDTO {
	private int resumeId;
	private String companyName;
    private String title;
    private String startDate;
    private String endDate;
    private int postCheck;
    
	public ResumeDTO() {
		super();
	}
	public ResumeDTO(int resumeId, String name, String title, String startDate, String endDate, int postCheck) {
		super();
		this.resumeId = resumeId;
		this.companyName = name;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.postCheck = postCheck;
	}
	
	
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getPostCheck() {
		return postCheck;
	}
	public void setPostCheck(int postCheck) {
		this.postCheck = postCheck;
	}
	@Override
	public String toString() {
		return "ResumeDTO [name=" + companyName + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", postCheck=" + postCheck + "]";
	}
    
    

}
