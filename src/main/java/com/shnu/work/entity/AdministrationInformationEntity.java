package com.shnu.work.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "administration_information", schema = "final_work", catalog = "")
public class AdministrationInformationEntity {
    private long administrationId;
    private String administrationName;
    private String administrationPassword;
    private String administrationAccount;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    @Id
    @Column(name = "administration_id", nullable = false)
    public long getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(long administrationId) {
        this.administrationId = administrationId;
    }

    @Basic
    @Column(name = "administration_name", nullable = true, length = 255)
    public String getAdministrationName() {
        return administrationName;
    }

    public void setAdministrationName(String administrationName) {
        this.administrationName = administrationName;
    }

    @Basic
    @Column(name = "administration_password", nullable = true, length = 255)
    public String getAdministrationPassword() {
        return administrationPassword;
    }

    public void setAdministrationPassword(String administrationPassword) {
        this.administrationPassword = administrationPassword;
    }

    @Basic
    @Column(name = "administration_account", nullable = true, length = 255)
    public String getAdministrationAccount() {
        return administrationAccount;
    }

    public void setAdministrationAccount(String administrationAccount) {
        this.administrationAccount = administrationAccount;
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
        AdministrationInformationEntity that = (AdministrationInformationEntity) o;
        return administrationId == that.administrationId &&
                Objects.equals(administrationName, that.administrationName) &&
                Objects.equals(administrationPassword, that.administrationPassword) &&
                Objects.equals(administrationAccount, that.administrationAccount) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(administrationId, administrationName, administrationPassword, administrationAccount, createTime, updateTime);
    }
}
