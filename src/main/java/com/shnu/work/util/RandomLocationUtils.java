package com.shnu.work.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 随机经纬度生成工具类
 */
public class RandomLocationUtils {
    /**
     * 在矩形内随机生成经纬度
     * @param MinLon 最小经度
     * @param MaxLon 最大经度
     * @param MinLat 最小纬度
     * @param MaxLat 最大纬度
     * @return 经纬度Map
     */
    public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, String> map = new HashMap<>();
        map.put("J", lon);
        map.put("W", lat);
        return map;
    }
}
