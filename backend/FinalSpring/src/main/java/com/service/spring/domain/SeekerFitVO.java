package com.service.spring.domain;

public class SeekerFitVO {
	private int seekerFitId; //seeker_fit_id(pk)
	private String tendency1;
	private String tendency2; 
	private String tendency3; 
	private String tendency4; 
	private String tendency5; 
	private int rate1; 
	private int rate2; 
	private int rate3; 
	private int rate4; 
	private int rate5;
	private int seekerId; //seeker_id(fk)
	private int resumeId;
	private String position;
	
	public SeekerFitVO() {
	}

	public SeekerFitVO(String tendency1, String tendency2, String tendency3, String tendency4, String tendency5,
			int rate1, int rate2, int rate3, int rate4, int rate5, int seekerId, int resumeId, String position) {
		super();
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
		this.seekerId = seekerId;
		this.resumeId = resumeId;
		this.position = position;
	}

	public int getSeekerFitId() {
		return seekerFitId;
	}

	public void setSeekerFitId(int seekerFitId) {
		this.seekerFitId = seekerFitId;
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

	public int getRate1() {
		return rate1;
	}

	public void setRate1(int rate1) {
		this.rate1 = rate1;
	}

	public int getRate2() {
		return rate2;
	}

	public void setRate2(int rate2) {
		this.rate2 = rate2;
	}

	public int getRate3() {
		return rate3;
	}

	public void setRate3(int rate3) {
		this.rate3 = rate3;
	}

	public int getRate4() {
		return rate4;
	}

	public void setRate4(int rate4) {
		this.rate4 = rate4;
	}

	public int getRate5() {
		return rate5;
	}

	public void setRate5(int rate5) {
		this.rate5 = rate5;
	}

	public int getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
	
	
}
