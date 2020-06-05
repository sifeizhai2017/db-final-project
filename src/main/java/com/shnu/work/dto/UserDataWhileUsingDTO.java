package com.shnu.work.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserDataWhileUsingDTO implements Serializable {
    private static final long serialVersionUID = 1560998452892921443L;
    private Long deviceId;
    private String userDocumentTime;
    private BigDecimal userLocationX;
    private BigDecimal userLocationY;
    private String userEmergencyContact;
    private String userHealthCareDemo;
    private Integer documentAlert;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserDocumentTime() {
        return userDocumentTime;
    }

    public void setUserDocumentTime(String userDocumentTime) {
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

    @Override
    public String toString() {
        return "UserDataWhileUsingDTO{" +
                "deviceId=" + deviceId +
                ", userDocumentTime='" + userDocumentTime + '\'' +
                ", userLocationX=" + userLocationX +
                ", userLocationY=" + userLocationY +
                ", userEmergencyContact='" + userEmergencyContact + '\'' +
                ", userHealthCareDemo='" + userHealthCareDemo + '\'' +
                ", documentAlert=" + documentAlert +
                '}';
    }
}
