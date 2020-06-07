package com.shnu.work.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "administration_information", schema = "final_work", catalog = "")
public class AdministrationInformationEntity {
    private long id;
    private String administrationName;
    private String administrationPassword;
    private String administrationAccount;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;
    private Integer isDeleted;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministrationInformationEntity that = (AdministrationInformationEntity) o;

        if (id != that.id) return false;
        if (administrationName != null ? !administrationName.equals(that.administrationName) : that.administrationName != null)
            return false;
        if (administrationPassword != null ? !administrationPassword.equals(that.administrationPassword) : that.administrationPassword != null)
            return false;
        if (administrationAccount != null ? !administrationAccount.equals(that.administrationAccount) : that.administrationAccount != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (administrationName != null ? administrationName.hashCode() : 0);
        result = 31 * result + (administrationPassword != null ? administrationPassword.hashCode() : 0);
        result = 31 * result + (administrationAccount != null ? administrationAccount.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
