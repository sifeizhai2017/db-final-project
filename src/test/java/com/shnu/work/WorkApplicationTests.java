package com.shnu.work;

import com.google.gson.Gson;
import com.shnu.work.util.NewRedisUtils;
import com.shnu.work.util.RandomLocationUtils;
import com.spoon.pass.encrypt.EncryptDecrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Set;

@SpringBootTest
class WorkApplicationTests {
    Gson gson = new Gson();

    @Test
    void contextLoads() {
        System.out.println("多仓库测试");
    }

    @Test
    public void testEncrypt() {
        String ENCRYPT_KEY = "developedByTongHao";
        String encrypt = EncryptDecrypt.encrypt("123456", ENCRYPT_KEY);
        System.out.println("encrypt = " + encrypt);
        String decrypt = EncryptDecrypt.decrypt(encrypt, ENCRYPT_KEY);
        System.out.println("decrypt = " + decrypt);
    }

    @Test
    public void testRedis() {
        NewRedisUtils newRedisUtils = NewRedisUtils.getRedisUtil();
        //每隔2分钟把所有location_info开头的数据写到mysql中，并删除调这些结果
        Set<String> locationInfoCacheSet = newRedisUtils.keys(2, "location_info_*");
        System.out.println("locationInfoCacheSet = " + gson.toJson(locationInfoCacheSet));
    }

    @Test
    public void testRandomLocationUtils() {
        Map<String, String> jw = RandomLocationUtils.randomLonLat(85, 122, 29, 116);
        System.out.println("jw = " + jw);
        System.out.println("1" + null);
    }

    @Test
    public static void main(String[] args) {
        System.out.println("1" + null);
    }
}
