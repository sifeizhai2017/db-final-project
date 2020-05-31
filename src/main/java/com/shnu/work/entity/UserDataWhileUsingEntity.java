package com.shnu.work.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户数据信息表
 *
 * @author Shinomiya Kaguya
 */
@Entity
@Table(name = "user_data_while_using", schema = "final_work")
@IdClass(UserDataWhileUsingEntityPK.class)
public class UserDataWhileUsingEntity implements Serializable {
    private static final long serialVersionUID = -8291610504245525538L;

    /**
     * 设备id
     */
    @Id
    @Column(name = "device_id", nullable = false)
    private long deviceId;

    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;

    /**
     * 记录位置时间
     */
    @Basic
    @Column(name = "user_document_time", nullable = true)
    private Timestamp userDocumentTime;

    /**
     * 经度
     */
    @Basic
    @Column(name = "user_location_x", nullable = true, precision = 5)
    private BigDecimal userLocationX;

    /**
     * 纬度
     */
    @Basic
    @Column(name = "user_location_y", nullable = true, precision = 5)
    private BigDecimal userLocationY;

    /**
     * 用户名
     */
    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    private String userName;

    /**
     * 紧急联络电话
     */
    @Basic
    @Column(name = "user_emergency_contact", nullable = true, length = 255)
    private String userEmergencyContact;

    /**
     * 社保信息
     */
    @Basic
    @Column(name = "user_health_care_demo", nullable = true, length = 255)
    private String userHealthCareDemo;

    /**
     * 警告信息
     */
    @Basic
    @Column(name = "document_alert", nullable = true)
    private Integer documentAlert;

    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_time", nullable = true)
    private Date createTime;

    /**
     * 更新时间
     */
    @Basic
    @Column(name = "update_time", nullable = true)
    private Date updateTime;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Timestamp getUserDocumentTime() {
        return userDocumentTime;
    }

    public void setUserDocumentTime(Timestamp userDocumentTime) {
        this.userDocumentTime = userDocumentTime;
    }

    public BigDecimal getUserLocationX() {
        return userLocationX;
    }

    public void setUserLocationX(BigDecimal userLocationX) {
        this.userLocationX = userLocationX;
    }

    public BigDecimal getUserLocationY() {
        return userLocationY;
    }

    public void setUserLocationY(BigDecimal userLocationY) {
        this.userLocationY = userLocationY;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmergencyContact() {
        return userEmergencyContact;
    }

    public void setUserEmergencyContact(String userEmergencyContact) {
        this.userEmergencyContact = userEmergencyContact;
    }

    public String getUserHealthCareDemo() {
        return userHealthCareDemo;
    }

    public void setUserHealthCareDemo(String userHealthCareDemo) {
        this.userHealthCareDemo = userHealthCareDemo;
    }

    public Integer getDocumentAlert() {
        return documentAlert;
    }

    public void setDocumentAlert(Integer documentAlert) {
        this.documentAlert = documentAlert;
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
        return "UserDataWhileUsingEntity{" +
                "deviceId=" + deviceId +
                ", userId=" + userId +
                ", userDocumentTime=" + userDocumentTime +
                ", userLocationX=" + userLocationX +
                ", userLocationY=" + userLocationY +
                ", userName='" + userName + '\'' +
                ", userEmergencyContact='" + userEmergencyContact + '\'' +
                ", userHealthCareDemo='" + userHealthCareDemo + '\'' +
                ", documentAlert=" + documentAlert +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
