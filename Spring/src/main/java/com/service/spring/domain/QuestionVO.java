package com.service.spring.domain;

public class QuestionVO {
    private int questionId; //question_id(pk)
    private String field;
    private String question;
    private int length;
    private int companyId; //company_id (fk)

    public QuestionVO() {
    }

    public QuestionVO(String field, String question, int length) {
        this.field = field;
        this.question = question;
        this.length = length;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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
        return "QuestionVO{" +
                "questionId=" + questionId +
                ", field='" + field + '\'' +
                ", question='" + question + '\'' +
                ", length=" + length +
                ", companyId=" + companyId +
                '}';
    }
}
