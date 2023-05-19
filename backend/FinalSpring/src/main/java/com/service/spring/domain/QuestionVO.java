package com.service.spring.domain;

public class QuestionVO {
    private int questionId; //question_id(pk)
    private String position;
    private String question;
    private int length;
    private int companyId; //company_id (fk)

    public QuestionVO() {
    }

	public QuestionVO(int questionId, String position, String question, int length, int companyId) {
		super();
		this.questionId = questionId;
		this.position = position;
		this.question = question;
		this.length = length;
		this.companyId = companyId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "QuestionVO [questionId=" + questionId + ", position=" + position + ", question=" + question
				+ ", length=" + length + ", companyId=" + companyId + "]";
	}

    
}
