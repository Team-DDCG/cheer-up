package com.service.spring.domain;

import java.sql.Date;

public class UserRewardVO {
	private int rewardId; //reward_id(pk)
	private String name;
	private Date acquiredDate; //acquired_date
	private String agency;
	private String content;
	private int seekerId; //seeker_id(fk)
	public UserRewardVO() {
		super();
	}
	public UserRewardVO(String name, Date acquiredDate, String agency, String content) {
		super();
		this.name = name;
		this.acquiredDate = acquiredDate;
		this.agency = agency;
		this.content = content;
	}
	public int getRewardId() {
		return rewardId;
	}
	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAcquiredDate() {
		return acquiredDate;
	}
	public void setAcquiredDate(Date acquiredDate) {
		this.acquiredDate = acquiredDate;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSeekerId() {
		return seekerId;
	}
	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}
	@Override
	public String toString() {
		return "UserRewardVO [rewardId=" + rewardId + ", name=" + name + ", acquiredDate=" + acquiredDate + ", agency="
				+ agency + ", content=" + content + ", seekerId=" + seekerId + "]";
	}
	
	
}
