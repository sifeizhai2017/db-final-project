package com.shnu.work.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * 随机经纬度生成工具类
 *
 * @author Shinomiya Kaguya
 */
public class RandomLocationUtils {
    /**
     * 在矩形内随机生成经纬度
     *
     * @param minLon 最小经度
     * @param maxLon 最大经度
     * @param minLat 最小纬度
     * @param maxLat 最大纬度
     * @return 经纬度Map
     */
    public static Map<String, String> randomLonLat(double minLon, double maxLon, double minLat, double maxLat) {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            BigDecimal db = new BigDecimal(Math.abs(random.nextGaussian())* (maxLon - minLon) + minLon);
            String lon = db.setScale(6, RoundingMode.HALF_UP).toString();
            db = new BigDecimal(Math.abs(random.nextGaussian()) * (maxLat - minLat) + minLat);
            String lat = db.setScale(6, RoundingMode.HALF_UP).toString();
            Map<String, String> map = new HashMap<>();
            map.put("J", lon);
            map.put("W", lat);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
