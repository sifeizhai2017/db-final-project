package com.shnu.work.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "deep_learning_data_documents", schema = "final_work", catalog = "")
public class DeepLearningDataDocumentsEntity {
    private long documentId;
    private Long userId;
    private Long deviceId;
    private String documentData;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    @Id
    @Column(name = "document_id", nullable = false)
    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "device_id", nullable = true)
    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "document_data", nullable = true, length = 255)
    public String getDocumentData() {
        return documentData;
    }

    public void setDocumentData(String documentData) {
        this.documentData = documentData;
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
        DeepLearningDataDocumentsEntity that = (DeepLearningDataDocumentsEntity) o;
        return documentId == that.documentId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(documentData, that.documentData) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, userId, deviceId, documentData, createTime, updateTime);
    }
}
