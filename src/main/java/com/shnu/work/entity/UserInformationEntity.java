package com.shnu.work.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_information", schema = "final_work", catalog = "")
public class UserInformationEntity {
    private long userId;
    private String userName;
    private String userPassword;
    private String userAccount;
    private Byte userSex;
    private String userSignature;
    private short userNumOfDevice;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = true, length = 255)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_account", nullable = true, length = 255)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_sex", nullable = true)
    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_signature", nullable = true, length = -1)
    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    @Basic
    @Column(name = "user_num_of_device", nullable = false)
    public short getUserNumOfDevice() {
        return userNumOfDevice;
    }

    public void setUserNumOfDevice(short userNumOfDevice) {
        this.userNumOfDevice = userNumOfDevice;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformationEntity that = (UserInformationEntity) o;
        return userId == that.userId &&
                userNumOfDevice == that.userNumOfDevice &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userAccount, that.userAccount) &&
                Objects.equals(userSex, that.userSex) &&
                Objects.equals(userSignature, that.userSignature) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPassword, userAccount, userSex, userSignature, userNumOfDevice, createTime, updateTime);
    }
}
