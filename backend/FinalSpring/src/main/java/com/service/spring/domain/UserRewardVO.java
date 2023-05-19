package com.service.spring.domain;

import java.sql.Date;

public class UserRewardVO {
	private int rewardId; //reward_id(pk)
	private String name;
	private Date acquiredDate; //acquired_date
	private String host;
	private String content;
	private int seekerId; //seeker_id(fk)

	public UserRewardVO() {
	}

	public UserRewardVO(String name, Date acquiredDate, String host, String content, int seekerId) {
		this.name = name;
		this.acquiredDate = acquiredDate;
		this.host = host;
		this.content = content;
		this.seekerId = seekerId;
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

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
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
		return "UserRewardVO{" +
				"rewardId=" + rewardId +
				", name='" + name + '\'' +
				", acquiredDate=" + acquiredDate +
				", host='" + host + '\'' +
				", content='" + content + '\'' +
				", seekerId=" + seekerId +
				'}';
	}
}
