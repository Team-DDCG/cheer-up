package com.service.spring.domain;

import java.sql.Date;


public class UserInfoVO {
    private int userId; //user_id(pk)
    private String id;
    private String password;
    private String userName; //user_name
    private Date birthdate;
    private int sex;
    private String email;
    private String phone;
    private int userStatus; //user_status
    private Date tstamp;
    private int mailCheck; //mail_check
    private String address;

    public UserInfoVO() {
    }

    public UserInfoVO(String id, String password, String userName, Date birthdate, int sex, String email, String phone, int userStatus,int mailCheck, String address) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.birthdate = birthdate;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.userStatus = userStatus;
        this.mailCheck = mailCheck;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public Date getTstamp() {
        return tstamp;
    }

    public void setTstamp(Date tstamp) {
        this.tstamp = tstamp;
    }

    public int getMailCheck() {
        return mailCheck;
    }

    public void setMailCheck(int mailCheck) {
        this.mailCheck = mailCheck;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "userId=" + userId +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", birthdate=" + birthdate +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                ", tstamp=" + tstamp +
                ", mailCheck=" + mailCheck +
                ", address='" + address + '\'' +
                '}';
    }
}
