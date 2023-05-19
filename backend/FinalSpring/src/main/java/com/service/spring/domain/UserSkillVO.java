package com.service.spring.domain;

public class UserSkillVO {
    private int skillId;
    private String skillName; //skill_name
    private int grade;
    private int seekerId; //seeker_id (fk)

    public UserSkillVO() {
    }

    public UserSkillVO(String skillName, int grade, int seekerId) {
        this.skillName = skillName;
        this.grade = grade;
        this.seekerId = seekerId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    @Override
    public String toString() {
        return "UserSkillVO{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", grade=" + grade +
                ", seekerId=" + seekerId +
                '}';
    }
}
