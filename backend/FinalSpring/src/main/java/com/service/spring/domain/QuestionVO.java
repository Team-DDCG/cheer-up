package com.service.spring.domain;

public class QuestionVO {
    private int questionId; //question_id(pk)
    private String position;
    private String question;
    private String length;
    private int companyId; //company_id (fk)

    public QuestionVO() {
    }

	public QuestionVO( String position, String question, String length, int companyId) {
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
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
