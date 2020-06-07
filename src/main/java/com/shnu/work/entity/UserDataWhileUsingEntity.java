package com.shnu.work.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "user_data_while_using", schema = "final_work", catalog = "")
public class UserDataWhileUsingEntity {
    private long id;
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
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
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

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (userId != that.userId) return false;
        if (userDocumentTime != null ? !userDocumentTime.equals(that.userDocumentTime) : that.userDocumentTime != null)
            return false;
        if (userLocationX != null ? !userLocationX.equals(that.userLocationX) : that.userLocationX != null)
            return false;
        if (userLocationY != null ? !userLocationY.equals(that.userLocationY) : that.userLocationY != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userEmergencyContact != null ? !userEmergencyContact.equals(that.userEmergencyContact) : that.userEmergencyContact != null)
            return false;
        if (userHealthCareDemo != null ? !userHealthCareDemo.equals(that.userHealthCareDemo) : that.userHealthCareDemo != null)
            return false;
        if (documentAlert != null ? !documentAlert.equals(that.documentAlert) : that.documentAlert != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userDocumentTime != null ? userDocumentTime.hashCode() : 0);
        result = 31 * result + (userLocationX != null ? userLocationX.hashCode() : 0);
        result = 31 * result + (userLocationY != null ? userLocationY.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userEmergencyContact != null ? userEmergencyContact.hashCode() : 0);
        result = 31 * result + (userHealthCareDemo != null ? userHealthCareDemo.hashCode() : 0);
        result = 31 * result + (documentAlert != null ? documentAlert.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
