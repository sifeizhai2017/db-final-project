package com.shnu.work.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_information", schema = "final_work", catalog = "")
public class SystemInformationEntity {
    private long versionId;
    private String noteOfDutyFree;
    private String noteOf2;
    private String noteOf3;
    private String noteOf4;
    private String noteOf5;
    private String noteOf6;
    private String noteOf7;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    @Id
    @Column(name = "version_id", nullable = false)
    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    @Basic
    @Column(name = "note_of_duty_free", nullable = true, length = 255)
    public String getNoteOfDutyFree() {
        return noteOfDutyFree;
    }

    public void setNoteOfDutyFree(String noteOfDutyFree) {
        this.noteOfDutyFree = noteOfDutyFree;
    }

    @Basic
    @Column(name = "note_of_2", nullable = true, length = 255)
    public String getNoteOf2() {
        return noteOf2;
    }

    public void setNoteOf2(String noteOf2) {
        this.noteOf2 = noteOf2;
    }

    @Basic
    @Column(name = "note_of_3", nullable = true, length = 255)
    public String getNoteOf3() {
        return noteOf3;
    }

    public void setNoteOf3(String noteOf3) {
        this.noteOf3 = noteOf3;
    }

    @Basic
    @Column(name = "note_of_4", nullable = true, length = 255)
    public String getNoteOf4() {
        return noteOf4;
    }

    public void setNoteOf4(String noteOf4) {
        this.noteOf4 = noteOf4;
    }

    @Basic
    @Column(name = "note_of_5", nullable = true, length = 255)
    public String getNoteOf5() {
        return noteOf5;
    }

    public void setNoteOf5(String noteOf5) {
        this.noteOf5 = noteOf5;
    }

    @Basic
    @Column(name = "note_of_6", nullable = true, length = 255)
    public String getNoteOf6() {
        return noteOf6;
    }

    public void setNoteOf6(String noteOf6) {
        this.noteOf6 = noteOf6;
    }

    @Basic
    @Column(name = "note_of_7", nullable = true, length = 255)
    public String getNoteOf7() {
        return noteOf7;
    }

    public void setNoteOf7(String noteOf7) {
        this.noteOf7 = noteOf7;
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
        SystemInformationEntity that = (SystemInformationEntity) o;
        return versionId == that.versionId &&
                Objects.equals(noteOfDutyFree, that.noteOfDutyFree) &&
                Objects.equals(noteOf2, that.noteOf2) &&
                Objects.equals(noteOf3, that.noteOf3) &&
                Objects.equals(noteOf4, that.noteOf4) &&
                Objects.equals(noteOf5, that.noteOf5) &&
                Objects.equals(noteOf6, that.noteOf6) &&
                Objects.equals(noteOf7, that.noteOf7) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionId, noteOfDutyFree, noteOf2, noteOf3, noteOf4, noteOf5, noteOf6, noteOf7, createTime, updateTime);
    }
}
