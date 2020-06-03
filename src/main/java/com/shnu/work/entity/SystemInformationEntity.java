package com.shnu.work.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "system_information", schema = "final_work", catalog = "")
public class SystemInformationEntity {
    private long id;
    private String noteOfDutyFree;
    private String noteOf2;
    private String noteOf3;
    private String noteOf4;
    private String noteOf5;
    private String noteOf6;
    private String noteOf7;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemInformationEntity that = (SystemInformationEntity) o;

        if (id != that.id) return false;
        if (noteOfDutyFree != null ? !noteOfDutyFree.equals(that.noteOfDutyFree) : that.noteOfDutyFree != null)
            return false;
        if (noteOf2 != null ? !noteOf2.equals(that.noteOf2) : that.noteOf2 != null) return false;
        if (noteOf3 != null ? !noteOf3.equals(that.noteOf3) : that.noteOf3 != null) return false;
        if (noteOf4 != null ? !noteOf4.equals(that.noteOf4) : that.noteOf4 != null) return false;
        if (noteOf5 != null ? !noteOf5.equals(that.noteOf5) : that.noteOf5 != null) return false;
        if (noteOf6 != null ? !noteOf6.equals(that.noteOf6) : that.noteOf6 != null) return false;
        if (noteOf7 != null ? !noteOf7.equals(that.noteOf7) : that.noteOf7 != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (noteOfDutyFree != null ? noteOfDutyFree.hashCode() : 0);
        result = 31 * result + (noteOf2 != null ? noteOf2.hashCode() : 0);
        result = 31 * result + (noteOf3 != null ? noteOf3.hashCode() : 0);
        result = 31 * result + (noteOf4 != null ? noteOf4.hashCode() : 0);
        result = 31 * result + (noteOf5 != null ? noteOf5.hashCode() : 0);
        result = 31 * result + (noteOf6 != null ? noteOf6.hashCode() : 0);
        result = 31 * result + (noteOf7 != null ? noteOf7.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
