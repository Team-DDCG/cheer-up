package com.service.spring.DTO;

import java.sql.Date;

public class ResumeDTO {
	private String name;
    private String title;
    private Date startDate;
    private Date endDate;
    private int postCheck;
    
	public ResumeDTO() {
		super();
	}
	public ResumeDTO(String name, String title, Date startDate, Date endDate, int postCheck) {
		super();
		this.name = name;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.postCheck = postCheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getPostCheck() {
		return postCheck;
	}
	public void setPostCheck(int postCheck) {
		this.postCheck = postCheck;
	}
	@Override
	public String toString() {
		return "ResumeDTO [name=" + name + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", postCheck=" + postCheck + "]";
	}
    
    

}
