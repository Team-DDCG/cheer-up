package com.service.spring.domain;

public class UserProjectVO {
    private int projectId; //project_id(pk)
    private String projectName; //project_name
    private String hostName; //host_name
    private String content;
    private String skill;
    private String institution;
    private int seekerId; //seeker_id(fk)

    public UserProjectVO() {
    }

    public UserProjectVO(String projectName, String hostName, String content, String skill, String institution, int seekerId) {
        this.projectName = projectName;
        this.hostName = hostName;
        this.content = content;
        this.skill = skill;
        this.institution = institution;
        this.seekerId = seekerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public String toString() {
        return "UserProjectVO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", hostName='" + hostName + '\'' +
                ", content='" + content + '\'' +
                ", skill='" + skill + '\'' +
                ", institution='" + institution + '\'' +
                ", seekerId=" + seekerId +
                '}';
    }
}
