package com.service.spring.domain;

public class CompanyFitVO {
	private int companyFitId; //company_fit_id(pk)
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
	private int seekerId; //seeker_id(fk)
	private String position;
	
	public CompanyFitVO() {
	}

	public CompanyFitVO(String companyName, String companyNeeds1, String companyNeeds2, String companyNeeds3,
			String companyNeeds4, String companyNeeds5, float companyRate1, float companyRate2, float companyRate3,
			float companyRate4, float companyRate5, int seekerId, String position) {
		super();
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
		this.seekerId = seekerId;
		this.position = position;
	}

	public int getCompanyFitId() {
		return companyFitId;
	}

	public void setCompanyFitId(int companyFitId) {
		this.companyFitId = companyFitId;
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

	public int getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	

}
