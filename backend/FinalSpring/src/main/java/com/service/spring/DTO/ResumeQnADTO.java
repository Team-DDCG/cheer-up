package com.service.spring.DTO;

public class ResumeQnADTO {
	private String title;
	private String question;
	private String content;
	
	public ResumeQnADTO() {
		super();
	}

	public ResumeQnADTO(String title, String question, String content) {
		super();
		this.title = title;
		this.question = question;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResumeQnADTO [title=" + title + ", question=" + question + ", content=" + content + "]";
	}
	
	
}
