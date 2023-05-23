package com.service.spring.domain;

public class ResumeVO {
    private int resumeId; //resume_id(pk)
    private String content;
    private int postCheck; //post_check
    private String generateDate; //generate_date
    private int seekerId; //seeker_id(fk)
    private int companyId; // company_id(fk)

    public ResumeVO() {
    }

	public ResumeVO(String content, int postCheck, String generateDate, int seekerId, int companyId) {
		this.content = content;
		this.postCheck = postCheck;
		this.seekerId = seekerId;
		this.companyId = companyId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostCheck() {
		return postCheck;
	}

	public void setPostCheck(int postCheck) {
		this.postCheck = postCheck;
	}

	public String getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}

	public int getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "ResumeVO [resumeId=" + resumeId + ", content=" + content + ", postCheck=" + postCheck
				+ ", generateDate=" + generateDate + ", seekerId=" + seekerId + ", companyId=" + companyId + "]";
	}

    
}
