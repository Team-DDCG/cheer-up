package com.service.spring.domain;


import org.springframework.web.multipart.MultipartFile;

public class UserSeekerVO {
    private int seekerId; //user_seeker_id (pk)
    private String ename;
    private String cname;
    private int military;
    private int bohun;
    private int disabled;
    private int userId; //user_id(fk)
    private int limitId; //limit_id(fk)
    private String nation;
    private MultipartFile profile;
    private int category1No; //category1_no
    private int category2No; //category2_no
    

    public UserSeekerVO() {
    }



	public UserSeekerVO(int seekerId, String ename, String cname, int military, int bohun, int disabled, int userId,
			int limitId, String nation, MultipartFile profile, int category1No, int category2No) {
		super();
		this.seekerId = seekerId;
		this.ename = ename;
		this.cname = cname;
		this.military = military;
		this.bohun = bohun;
		this.disabled = disabled;
		this.userId = userId;
		this.limitId = limitId;
		this.nation = nation;
		this.profile = profile;
		this.category1No = category1No;
		this.category2No = category2No;
	}



	public int getSeekerId() {
		return seekerId;
	}



	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public int getMilitary() {
		return military;
	}



	public void setMilitary(int military) {
		this.military = military;
	}



	public int getBohun() {
		return bohun;
	}



	public void setBohun(int bohun) {
		this.bohun = bohun;
	}



	public int getDisabled() {
		return disabled;
	}



	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getLimitId() {
		return limitId;
	}



	public void setLimitId(int limitId) {
		this.limitId = limitId;
	}



	public String getNation() {
		return nation;
	}



	public void setNation(String nation) {
		this.nation = nation;
	}



	public MultipartFile getProfile() {
		return profile;
	}



	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}



	public int getCategory1No() {
		return category1No;
	}



	public void setCategory1No(int category1No) {
		this.category1No = category1No;
	}



	public int getCategory2No() {
		return category2No;
	}



	public void setCategory2No(int category2No) {
		this.category2No = category2No;
	}



	@Override
	public String toString() {
		return "UserSeekerVO [seekerId=" + seekerId + ", ename=" + ename + ", cname=" + cname + ", military=" + military
				+ ", bohun=" + bohun + ", disabled=" + disabled + ", userId=" + userId + ", limitId=" + limitId
				+ ", nation=" + nation + ", profile=" + profile + ", category1No=" + category1No + ", category2No="
				+ category2No + "]";
	}
	
}
