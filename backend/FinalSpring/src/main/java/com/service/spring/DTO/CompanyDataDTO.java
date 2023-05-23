package com.service.spring.DTO;

import java.time.LocalDate;

public class CompanyDataDTO {
    private String companyName;
    private String startDate;
    private String endDate;
    private String companyLogo;
    private String title;
    private String companyUrl;
    private String content;
    private String position;

    // Constructors, getters, and setters
    
    public CompanyDataDTO(String companyName, String startDate, String endDate, String companyLogo, String title, String companyUrl, String content, String position) {
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyLogo = companyLogo;
        this.title = title;
        this.companyUrl = companyUrl;
        this.content = content;
        this.position = position;
    }

    public CompanyDataDTO() {
		super();
	}

	public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

	@Override
	public String toString() {
		return "CompanyDataDTO [companyName=" + companyName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", companyLogo=" + companyLogo + ", title=" + title + ", companyUrl=" + companyUrl + ", content="
				+ content + ", position=" + position + "]";
	}
    
    
}