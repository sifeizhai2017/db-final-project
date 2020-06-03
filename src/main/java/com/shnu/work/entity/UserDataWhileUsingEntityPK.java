package com.shnu.work.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserDataWhileUsingEntityPK implements Serializable {
    private long id;
    private long deviceId;
    private long userId;

    @Column(name = "id", nullable = false)
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "device_id", nullable = false)
    @Id
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Column(name = "user_id", nullable = false)
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDataWhileUsingEntityPK that = (UserDataWhileUsingEntityPK) o;

        if (id != that.id) return false;
        if (deviceId != that.deviceId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }
}
