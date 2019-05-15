package com.example.mybatis_sd.dao;

import com.example.mybatis_sd.bean.Student;

import java.util.List;

/**
 * @Author: NJ
 * @Description:
 * @Date: 2019/5/5
 */
public interface StudentDao {

    void insertStudent(Student student);

    void updateStudent(Student student);

    /**
     * 查询所有列表
     */
    List<Student> selectAllStudents();
}
