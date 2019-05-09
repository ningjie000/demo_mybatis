package com.example.mybatis_sd.demo;

import com.example.mybatis_sd.bean.Student;
import com.example.mybatis_sd.dao.StudentDao;
import com.example.mybatis_sd.dao.StudentDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void insertStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student("华1223", 52, 98.50);

        studentDao.insertStudent(student);
    }

}
