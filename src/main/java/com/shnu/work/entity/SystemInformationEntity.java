package com.shnu.work.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 文档表
 */
@Entity
@Table(name = "system_information", schema = "final_work")
public class SystemInformationEntity implements Serializable {
    private static final long serialVersionUID = -7481496331560022948L;

    /**
     * 版本号
     */
    @Id
    @Column(name = "version_id", nullable = false)
    private long versionId;

    /**
     * 免责声明
     */
    @Basic
    @Column(name = "note_of_duty_free", nullable = true, length = 255)
    private String noteOfDutyFree;

    /**
     * 备用信息2
     */
    @Basic
    @Column(name = "note_of_2", nullable = true, length = 255)
    private String noteOf2;

    /**
     * 备用信息3
     */
    @Basic
    @Column(name = "note_of_3", nullable = true, length = 255)
    private String noteOf3;

    /**
     * 备用信息4
     */
    @Basic
    @Column(name = "note_of_4", nullable = true, length = 255)
    private String noteOf4;

    /**
     * 备用信息5
     */
    @Basic
    @Column(name = "note_of_5", nullable = true, length = 255)
    private String noteOf5;

    /**
     * 备用信息6
     */
    @Basic
    @Column(name = "note_of_6", nullable = true, length = 255)
    private String noteOf6;

    /**
     * 备用信息7
     */
    @Basic
    @Column(name = "note_of_7", nullable = true, length = 255)
    private String noteOf7;

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

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public String getNoteOfDutyFree() {
        return noteOfDutyFree;
    }

    public void setNoteOfDutyFree(String noteOfDutyFree) {
        this.noteOfDutyFree = noteOfDutyFree;
    }

    public String getNoteOf2() {
        return noteOf2;
    }

    public void setNoteOf2(String noteOf2) {
        this.noteOf2 = noteOf2;
    }

    public String getNoteOf3() {
        return noteOf3;
    }

    public void setNoteOf3(String noteOf3) {
        this.noteOf3 = noteOf3;
    }

    public String getNoteOf4() {
        return noteOf4;
    }

    public void setNoteOf4(String noteOf4) {
        this.noteOf4 = noteOf4;
    }

    public String getNoteOf5() {
        return noteOf5;
    }

    public void setNoteOf5(String noteOf5) {
        this.noteOf5 = noteOf5;
    }

    public String getNoteOf6() {
        return noteOf6;
    }

    public void setNoteOf6(String noteOf6) {
        this.noteOf6 = noteOf6;
    }

    public String getNoteOf7() {
        return noteOf7;
    }

    public void setNoteOf7(String noteOf7) {
        this.noteOf7 = noteOf7;
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
        return "SystemInformationEntity{" +
                "versionId=" + versionId +
                ", noteOfDutyFree='" + noteOfDutyFree + '\'' +
                ", noteOf2='" + noteOf2 + '\'' +
                ", noteOf3='" + noteOf3 + '\'' +
                ", noteOf4='" + noteOf4 + '\'' +
                ", noteOf5='" + noteOf5 + '\'' +
                ", noteOf6='" + noteOf6 + '\'' +
                ", noteOf7='" + noteOf7 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
