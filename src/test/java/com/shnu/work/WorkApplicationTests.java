package com.shnu.work;

import com.shnu.work.entity.Student;
import com.shnu.work.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class WorkApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
        Student student = new Student();
        student.setStuAddress("sh");
        student.setStuAge("23");
        student.setStuSex("male");
        student.setStuName("zs");
        student.setGmtModified(new Date());
        Student save = studentRepository.save(student);
        System.out.println("save = " + save);
    }

}
