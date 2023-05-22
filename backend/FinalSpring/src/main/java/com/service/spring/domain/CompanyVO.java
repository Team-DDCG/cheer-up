package com.service.spring.domain;

import java.sql.Date;

public class CompanyVO {
    private int companyId; //company_id(pk)
    private String companyName; //company_name
    private String address;
    private Date startDate; //start_date
    private Date endDate; //end_date
    private String companyLogo; //company_logo
    private String title;
    private String content;
    private int category2Id; //category2_id (fk)

    public CompanyVO() {
    }

	public CompanyVO(String name, String address, Date startDate, Date endDate, String companyLogo,
			String title, String content) {
		super();
		this.companyName = name;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.companyLogo = companyLogo;
		this.title = title;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(int category2Id) {
		this.category2Id = category2Id;
	}

	@Override
	public String toString() {
		return "CompanyVO [companyId=" + companyId + ", name=" + companyName + ", address=" + address + ", startDate="
				+ startDate + ", endDate=" + endDate + ", companyLogo=" + companyLogo + ", title=" + title
				+ ", content=" + content + ", category2Id=" + category2Id + "]";
	}

    
}
