	package com.service.spring.domain;

import java.sql.Date;

public class CompanyVO {
    private int companyId; //company_id(pk)
    private String companyName; //company_name
    private Date startDate; //start_date
    private Date endDate; //end_date
    private String companyLogo; //company_logo
    private String title;
    private String companyUrl;//company_url
    private String content;

    public CompanyVO() {
    }

	public CompanyVO(int companyId, String companyName, Date startDate, Date endDate, String companyLogo, String title,
			String companyUrl, String content) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.companyLogo = companyLogo;
		this.title = title;
		this.companyUrl = companyUrl;
		this.content = content;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	@Override
	public String toString() {
		return "CompanyVO [companyId=" + companyId + ", companyName=" + companyName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", companyLogo=" + companyLogo + ", title=" + title + ", companyUrl="
				+ companyUrl + ", content=" + content + "]";
	}
    
}
