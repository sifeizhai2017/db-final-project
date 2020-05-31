package com.shnu.work.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 深度学习传感器用表
 */
@Entity
@Table(name = "deep_learning_data_documents", schema = "final_work")
public class DeepLearningDataDocumentsEntity implements Serializable {
    private static final long serialVersionUID = 5442185087549798540L;
    /**
     * 暂时未知
     */
    @Id
    @Column(name = "document_id", nullable = false)
    private long documentId;

    /**
     * 用户id
     */
    @Basic
    @Column(name = "user_id", nullable = true)
    private Long userId;

    /**
     * 设备id
     */
    @Basic
    @Column(name = "device_id", nullable = true)
    private Long deviceId;

    /**
     * 设备数据
     */
    @Basic
    @Column(name = "document_data", nullable = true, length = 255)
    private String documentData;

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

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDocumentData() {
        return documentData;
    }

    public void setDocumentData(String documentData) {
        this.documentData = documentData;
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
        return "DeepLearningDataDocumentsEntity{" +
                "documentId=" + documentId +
                ", userId=" + userId +
                ", deviceId=" + deviceId +
                ", documentData='" + documentData + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
