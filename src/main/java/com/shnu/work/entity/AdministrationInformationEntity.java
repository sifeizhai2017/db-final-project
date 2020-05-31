package com.shnu.work.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "administration_information", schema = "final_work")
public class AdministrationInformationEntity implements Serializable {
    private static final long serialVersionUID = -862196286696782038L;

    @Id
    @Column(name = "administration_id", nullable = false)
    private long administrationId;

    @Basic
    @Column(name = "administration_name", nullable = true, length = 255)
    private String administrationName;

    @Basic
    @Column(name = "administration_password", nullable = true, length = 255)
    private String administrationPassword;

    @Basic
    @Column(name = "administration_account", nullable = true, length = 255)
    private String administrationAccount;

    @Basic
    @Column(name = "create_time", nullable = true)
    private Date updateTime;

    @Basic
    @Column(name = "update_time", nullable = true)
    private Date createTime;

    public long getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(long administrationId) {
        this.administrationId = administrationId;
    }

    public String getAdministrationName() {
        return administrationName;
    }

    public void setAdministrationName(String administrationName) {
        this.administrationName = administrationName;
    }

    public String getAdministrationPassword() {
        return administrationPassword;
    }

    public void setAdministrationPassword(String administrationPassword) {
        this.administrationPassword = administrationPassword;
    }

    public String getAdministrationAccount() {
        return administrationAccount;
    }

    public void setAdministrationAccount(String administrationAccount) {
        this.administrationAccount = administrationAccount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AdministrationInformationEntity{" +
                "administrationId=" + administrationId +
                ", administrationName='" + administrationName + '\'' +
                ", administrationPassword='" + administrationPassword + '\'' +
                ", administrationAccount='" + administrationAccount + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
