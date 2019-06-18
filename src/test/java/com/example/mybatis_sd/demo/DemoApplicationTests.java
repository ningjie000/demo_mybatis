package com.example.mybatis_sd.demo;

import com.example.mybatis_sd.bean.Student;
import com.example.mybatis_sd.dao.StudentDao;
import com.example.mybatis_sd.dao.StudentDaoImpl;
import com.example.mybatis_sd.util.SSHHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

    }

//    @Test
//    public void insertStudent(){
//        StudentDao studentDao = new StudentDaoImpl();
//        Student student = new Student("华1223", 52, 98.50);
//
//        studentDao.insertStudent(student);
//    }


    @Test
    public void insertStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student("年后", 522, 298.5202);

        //id是默认值0
        System.out.println("before:" + student);
        studentDao.insertStudent(student);
        //可以获取id的值
        System.out.println("end:" + student);
    }

    @Test
    public void updateStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student(1,"年后1111", 522, 298.5202);

        //id是默认值0
        System.out.println("before:" + student);
        studentDao.updateStudent(student);
        //可以获取id的值
        System.out.println("end:" + student);
    }

    @Test
    public void selectAllStudents() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testStr(){
        try {
            SSHHelper.connectionHost("wonders", "123456","10.1.192.135",22);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String exec = SSHHelper.exec("10.1.192.135", "wonders", "123456", 21, "");
        System.out.println(exec);
    }

}
