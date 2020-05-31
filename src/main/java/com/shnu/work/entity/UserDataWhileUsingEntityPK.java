package com.shnu.work.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Shinomiya Kaguya
 */
public class UserDataWhileUsingEntityPK implements Serializable {
    private static final long serialVersionUID = 5765653977651853097L;

    @Column(name = "device_id", nullable = false)
    @Id
    private long deviceId;

    @Column(name = "user_id", nullable = false)
    @Id
    private long userId;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDataWhileUsingEntityPK that = (UserDataWhileUsingEntityPK) o;
        return deviceId == that.deviceId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, userId);
    }
}
