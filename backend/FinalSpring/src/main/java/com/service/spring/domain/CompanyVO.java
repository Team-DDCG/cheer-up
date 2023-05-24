package com.service.spring.domain;

public class CompanyVO {
    private int companyId; //company_id(pk)
    private String companyName; //company_name
    private String startDate; //start_date
    private String endDate; //end_date
    private String companyLogo; //company_logo
    private String title;
    private String companyUrl;//company_url
    private String content;

    public CompanyVO() {
    }

	public CompanyVO(String companyName, String startDate, String endDate, String companyLogo, String title,
			String companyUrl, String content) {
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

	public String getName() {
		return companyName;
	}

	public void setName(String name) {
		this.companyName = name;
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

	@Override
	public String toString() {
		return "CompanyVO [companyId=" + companyId + ", companyName=" + companyName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", companyLogo=" + companyLogo + ", title=" + title + ", companyUrl="
				+ companyUrl + ", content=" + content + "]";
	}
    
}
