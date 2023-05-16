package com.service.spring.domain;

public class UserProjectVO {
    private int projectId; //project_id(pk)
    private String name;
    private String hostName; //host_name
    private String contet;
    private String skill;
    private String agency;
    private int seekerId; //seeker_id(fk)

    public UserProjectVO() {
    }

    public UserProjectVO(String name, String hostName, String contet, String skill, String agency) {
        this.name = name;
        this.hostName = hostName;
        this.contet = contet;
        this.skill = skill;
        this.agency = agency;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getContet() {
        return contet;
    }

    public void setContet(String contet) {
        this.contet = contet;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "UserProjectVO{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", hostName='" + hostName + '\'' +
                ", contet='" + contet + '\'' +
                ", skill='" + skill + '\'' +
                ", seekerId=" + seekerId +
                ", agency='" + agency + '\'' +
                '}';
    }
}
