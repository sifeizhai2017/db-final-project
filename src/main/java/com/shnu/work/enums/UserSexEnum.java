package com.shnu.work.enums;

import java.util.Arrays;

/**
 * 性别枚举类
 *
 * @author Shinomiya Kaguya
 */
public enum UserSexEnum {
    /**
     * 男性
     */
    MALE(0, "男"),
    /**
     * 女性
     */
    FEMALE(1, "女");

    UserSexEnum(int key, String value) {
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

    public static UserSexEnum getEmByKey(Integer key) {
        return Arrays.stream(UserSexEnum.values()).filter(em -> key.equals(em.getKey())).findFirst().orElse(null);
    }
}
