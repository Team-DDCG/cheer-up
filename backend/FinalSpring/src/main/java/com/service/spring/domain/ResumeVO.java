package com.service.spring.domain;

public class ResumeVO {
    private int resumeId; //resume_id(pk)
    private String content;
    private int postCheck; //post_check
    private String generateDate; //generate_date
    private int seekerId; //seeker_id(fk)
    private int companyId; // company_id(fk)
    private String position;
    private int questionId;
    
    public ResumeVO() {
    }

	public ResumeVO(String content, int postCheck, String generateDate, int seekerId, int companyId, String position,
			int questionId) {
		super();
		this.content = content;
		this.postCheck = postCheck;
		this.generateDate = generateDate;
		this.seekerId = seekerId;
		this.companyId = companyId;
		this.position = position;
		this.questionId = questionId;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	
	
}
