package com.service.spring.DTO;

public class ResultDTO {
	private String content;
	private int postCheck;
	private String tendency1;
	private String tendency2;
	private String tendency3;
	private String tendency4;
	private String tendency5;
	private float rate1;
	private float rate2;
	private float rate3;
	private float rate4;
	private float rate5;
	private String companyName; //company_name
	private String companyNeeds1; //company_needs1
	private String companyNeeds2; //company_needs2
	private String companyNeeds3; //company_needs3
	private String companyNeeds4; //company_needs4
	private String companyNeeds5; //company_needs5
	private float companyRate1; //company_rate1
	private float companyRate2; //company_rate2
	private float companyRate3; //company_rate3
	private float companyRate4; //company_rate4
	private float companyRate5; //company_rate5
	private String position;
    private String question;
    private String length;
	
	public ResultDTO(String content, int postCheck, String tendency1, String tendency2, String tendency3,
			String tendency4, String tendency5, float rate1, float rate2, float rate3, float rate4, float rate5,
			String companyName, String companyNeeds1, String companyNeeds2, String companyNeeds3, String companyNeeds4,
			String companyNeeds5, float companyRate1, float companyRate2, float companyRate3, float companyRate4,
			float companyRate5, String position, String question, String length) {
		super();
		this.content = content;
		this.postCheck = postCheck;
		this.tendency1 = tendency1;
		this.tendency2 = tendency2;
		this.tendency3 = tendency3;
		this.tendency4 = tendency4;
		this.tendency5 = tendency5;
		this.rate1 = rate1;
		this.rate2 = rate2;
		this.rate3 = rate3;
		this.rate4 = rate4;
		this.rate5 = rate5;
		this.companyName = companyName;
		this.companyNeeds1 = companyNeeds1;
		this.companyNeeds2 = companyNeeds2;
		this.companyNeeds3 = companyNeeds3;
		this.companyNeeds4 = companyNeeds4;
		this.companyNeeds5 = companyNeeds5;
		this.companyRate1 = companyRate1;
		this.companyRate2 = companyRate2;
		this.companyRate3 = companyRate3;
		this.companyRate4 = companyRate4;
		this.companyRate5 = companyRate5;
		this.position = position;
		this.question = question;
		this.length = length;
	}
	public ResultDTO() {
		super();
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
	public String getTendency1() {
		return tendency1;
	}
	public void setTendency1(String tendency1) {
		this.tendency1 = tendency1;
	}
	public String getTendency2() {
		return tendency2;
	}
	public void setTendency2(String tendency2) {
		this.tendency2 = tendency2;
	}
	public String getTendency3() {
		return tendency3;
	}
	public void setTendency3(String tendency3) {
		this.tendency3 = tendency3;
	}
	public String getTendency4() {
		return tendency4;
	}
	public void setTendency4(String tendency4) {
		this.tendency4 = tendency4;
	}
	public String getTendency5() {
		return tendency5;
	}
	public void setTendency5(String tendency5) {
		this.tendency5 = tendency5;
	}
	public float getRate1() {
		return rate1;
	}
	public void setRate1(float rate1) {
		this.rate1 = rate1;
	}
	public float getRate2() {
		return rate2;
	}
	public void setRate2(float rate2) {
		this.rate2 = rate2;
	}
	public float getRate3() {
		return rate3;
	}
	public void setRate3(float rate3) {
		this.rate3 = rate3;
	}
	public float getRate4() {
		return rate4;
	}
	public void setRate4(float rate4) {
		this.rate4 = rate4;
	}
	public float getRate5() {
		return rate5;
	}
	public void setRate5(float rate5) {
		this.rate5 = rate5;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNeeds1() {
		return companyNeeds1;
	}
	public void setCompanyNeeds1(String companyNeeds1) {
		this.companyNeeds1 = companyNeeds1;
	}
	public String getCompanyNeeds2() {
		return companyNeeds2;
	}
	public void setCompanyNeeds2(String companyNeeds2) {
		this.companyNeeds2 = companyNeeds2;
	}
	public String getCompanyNeeds3() {
		return companyNeeds3;
	}
	public void setCompanyNeeds3(String companyNeeds3) {
		this.companyNeeds3 = companyNeeds3;
	}
	public String getCompanyNeeds4() {
		return companyNeeds4;
	}
	public void setCompanyNeeds4(String companyNeeds4) {
		this.companyNeeds4 = companyNeeds4;
	}
	public String getCompanyNeeds5() {
		return companyNeeds5;
	}
	public void setCompanyNeeds5(String companyNeeds5) {
		this.companyNeeds5 = companyNeeds5;
	}
	public float getCompanyRate1() {
		return companyRate1;
	}
	public void setCompanyRate1(float companyRate1) {
		this.companyRate1 = companyRate1;
	}
	public float getCompanyRate2() {
		return companyRate2;
	}
	public void setCompanyRate2(float companyRate2) {
		this.companyRate2 = companyRate2;
	}
	public float getCompanyRate3() {
		return companyRate3;
	}
	public void setCompanyRate3(float companyRate3) {
		this.companyRate3 = companyRate3;
	}
	public float getCompanyRate4() {
		return companyRate4;
	}
	public void setCompanyRate4(float companyRate4) {
		this.companyRate4 = companyRate4;
	}
	public float getCompanyRate5() {
		return companyRate5;
	}
	public void setCompanyRate5(float companyRate5) {
		this.companyRate5 = companyRate5;
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
    
    
	
}
