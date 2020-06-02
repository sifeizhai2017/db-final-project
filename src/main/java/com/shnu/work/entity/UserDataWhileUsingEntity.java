package com.shnu.work.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_data_while_using", schema = "final_work", catalog = "")
@IdClass(UserDataWhileUsingEntityPK.class)
public class UserDataWhileUsingEntity {
    private long deviceId;
    private long userId;
    private Date userDocumentTime;
    private BigDecimal userLocationX;
    private BigDecimal userLocationY;
    private String userName;
    private String userEmergencyContact;
    private String userHealthCareDemo;
    private Integer documentAlert;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    @Id
    @Column(name = "device_id", nullable = false)
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_document_time", nullable = true)
    public Date getUserDocumentTime() {
        return userDocumentTime;
    }

    public void setUserDocumentTime(Date userDocumentTime) {
        this.userDocumentTime = userDocumentTime;
    }

    @Basic
    @Column(name = "user_location_x", nullable = true, precision = 5)
    public BigDecimal getUserLocationX() {
        return userLocationX;
    }

    public void setUserLocationX(BigDecimal userLocationX) {
        this.userLocationX = userLocationX;
    }

    @Basic
    @Column(name = "user_location_y", nullable = true, precision = 5)
    public BigDecimal getUserLocationY() {
        return userLocationY;
    }

    public void setUserLocationY(BigDecimal userLocationY) {
        this.userLocationY = userLocationY;
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
    @Column(name = "user_emergency_contact", nullable = true, length = 255)
    public String getUserEmergencyContact() {
        return userEmergencyContact;
    }

    public void setUserEmergencyContact(String userEmergencyContact) {
        this.userEmergencyContact = userEmergencyContact;
    }

    @Basic
    @Column(name = "user_health_care_demo", nullable = true, length = 255)
    public String getUserHealthCareDemo() {
        return userHealthCareDemo;
    }

    public void setUserHealthCareDemo(String userHealthCareDemo) {
        this.userHealthCareDemo = userHealthCareDemo;
    }

    @Basic
    @Column(name = "document_alert", nullable = true)
    public Integer getDocumentAlert() {
        return documentAlert;
    }

    public void setDocumentAlert(Integer documentAlert) {
        this.documentAlert = documentAlert;
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
        UserDataWhileUsingEntity that = (UserDataWhileUsingEntity) o;
        return deviceId == that.deviceId &&
                userId == that.userId &&
                Objects.equals(userDocumentTime, that.userDocumentTime) &&
                Objects.equals(userLocationX, that.userLocationX) &&
                Objects.equals(userLocationY, that.userLocationY) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userEmergencyContact, that.userEmergencyContact) &&
                Objects.equals(userHealthCareDemo, that.userHealthCareDemo) &&
                Objects.equals(documentAlert, that.documentAlert) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, userId, userDocumentTime, userLocationX, userLocationY, userName, userEmergencyContact, userHealthCareDemo, documentAlert, createTime, updateTime);
    }
}
