package com.shnu.work.enums;

import java.util.Arrays;

/**
 * @author Shinomiya Kaguya
 */
public enum HealthConditionEnum {
    /**
     * 健康
     */
    HEALTHY(0, "健康"),
    /**
     * 亚健康
     */
    SUB_HEALTHY(1, "亚健康"),
    /**
     * 不健康
     */
    UNHEALTHY(2, "不健康");

    HealthConditionEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static HealthConditionEnum getEmByKey(Integer key) {
        return Arrays.stream(HealthConditionEnum.values()).filter(em -> key.equals(em.getKey())).findFirst().orElse(null);
    }
}
