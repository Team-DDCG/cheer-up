package com.service.spring.domain;

public class UserSkillVO {
    private int skillId;
    private String name;
    private int grade;
    private int seekerId; //seeker_id (fk)

    public UserSkillVO() {
    }

    public UserSkillVO(String name,int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UserSkillVO{" +
                "skillId=" + skillId +
                ", name='" + name + '\'' +
                ", seekerId=" + seekerId +
                ", grade=" + grade +
                '}';
    }
}
