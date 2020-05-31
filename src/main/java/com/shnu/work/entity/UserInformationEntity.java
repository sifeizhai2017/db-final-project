package com.shnu.work.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_information", schema = "final_work")
public class UserInformationEntity implements Serializable {
    private static final long serialVersionUID = -157252971123766076L;

    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    private String userName;

    @Basic
    @Column(name = "user_password", nullable = true, length = 255)
    private String userPassword;

    @Basic
    @Column(name = "user_account", nullable = true, length = 255)
    private String userAccount;

    @Basic
    @Column(name = "user_sex", nullable = true)
    private Byte userSex;

    @Basic
    @Column(name = "user_signature", nullable = true, length = -1)
    private Object userSignature;

    @Basic
    @Column(name = "user_num_of_device", nullable = false)
    private short userNumOfDevice;

    @Basic
    @Column(name = "create_time", nullable = true)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = true)
    private Date updateTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Object getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(Object userSignature) {
        this.userSignature = userSignature;
    }

    public short getUserNumOfDevice() {
        return userNumOfDevice;
    }

    public void setUserNumOfDevice(short userNumOfDevice) {
        this.userNumOfDevice = userNumOfDevice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInformationEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userSex=" + userSex +
                ", userSignature=" + userSignature +
                ", userNumOfDevice=" + userNumOfDevice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
