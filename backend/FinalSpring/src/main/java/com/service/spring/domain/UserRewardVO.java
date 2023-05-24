package com.service.spring.domain;

public class UserRewardVO {
	private int rewardId; //reward_id(pk)
	private String rewardName; //reward_name
	private String acquiredDate; //acquired_date
	private String host;
	private String content;
	private int seekerId; //seeker_id(fk)

	public UserRewardVO() {
	}

	public UserRewardVO(String rewardName, String acquiredDate, String host, String content, int seekerId) {
		this.rewardName = rewardName;
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

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getAcquiredDate() {
		return acquiredDate;
	}

	public void setAcquiredDate(String acquiredDate) {
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
				", name='" + rewardName + '\'' +
				", acquiredDate=" + acquiredDate +
				", host='" + host + '\'' +
				", content='" + content + '\'' +
				", seekerId=" + seekerId +
				'}';
	}
}
