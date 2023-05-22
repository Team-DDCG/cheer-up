package com.service.spring.domain;

import java.sql.Date;

public class CompanyVO {
    private int companyId; //company_id(pk)
    private String companyName; //company_name
<<<<<<< HEAD
    private String address;
=======
>>>>>>> f3e91eabad5a549a3856991f0b18f91630cdd3f5
    private Date startDate; //start_date
    private Date endDate; //end_date
    private String companyLogo; //company_logo
    private String title;
    private String companyUrl;//company_url
    private String content;

    public CompanyVO() {
    }

<<<<<<< HEAD
	public CompanyVO(String name, String address, Date startDate, Date endDate, String companyLogo,
			String title, String content) {
		super();
		this.companyName = name;
		this.address = address;
=======
	public CompanyVO(String companyName, Date startDate, Date endDate, String companyLogo, String title,
			String companyUrl, String content) {
		this.companyName = companyName;
>>>>>>> f3e91eabad5a549a3856991f0b18f91630cdd3f5
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

<<<<<<< HEAD
	public String getName() {
		return companyName;
	}

	public void setName(String name) {
		this.companyName = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
=======
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
>>>>>>> f3e91eabad5a549a3856991f0b18f91630cdd3f5
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
<<<<<<< HEAD
		return "CompanyVO [companyId=" + companyId + ", name=" + companyName + ", address=" + address + ", startDate="
				+ startDate + ", endDate=" + endDate + ", companyLogo=" + companyLogo + ", title=" + title
				+ ", content=" + content + ", category2Id=" + category2Id + "]";
=======
		return "CompanyVO [companyId=" + companyId + ", companyName=" + companyName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", companyLogo=" + companyLogo + ", title=" + title + ", companyUrl="
				+ companyUrl + ", content=" + content + "]";
>>>>>>> f3e91eabad5a549a3856991f0b18f91630cdd3f5
	}
    
}
