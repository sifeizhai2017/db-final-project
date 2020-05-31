package com.shnu.work;

import com.google.gson.Gson;
import com.shnu.work.util.RandomLocationUtils;
import com.shnu.work.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class WorkApplicationTests {

    @Autowired
    RedisUtils redisUtils;

    Gson gson = new Gson();

    @Test
    void contextLoads() {

    }

    @Test
    public void testJPA() {
//        Student student = new Student();
//        student.setStuAddress("sh");
//        student.setStuAge("23");
//        student.setStuSex("male");
//        student.setStuName("zs");
//        student.setGmtModified(new Date());
//        Student save = studentRepository.save(student);
//        System.out.println("save = " + save);
//        Iterable<Student> all = studentRepository.findAll();
//        System.out.println("all = " + gson.toJson(all));
    }

    @Test
    public void testRedis() {
        boolean set = redisUtils.set("kkk", "vvv");
        System.out.println("set = " + set);
    }

    @Test
    public void testRandomLocationUtils() {
        Map<String, String> jw = RandomLocationUtils.randomLonLat(85, 122, 29, 116);
        System.out.println("jw = " + jw);
    }
}
