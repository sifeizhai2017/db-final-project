package com.shnu.work;

import com.google.gson.Gson;
import com.shnu.work.util.NewRedisUtils;
import com.shnu.work.util.RandomLocationUtils;
import com.shnu.work.util.RedisUtils;
import com.spoon.pass.encrypt.EncryptDecrypt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
//        String s = newRedisUtils.switchDB(1);
//        System.out.println("s = " + s);
        String set = newRedisUtils.set("kkk1", "vvv1");
        System.out.println("set = " + set);
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
