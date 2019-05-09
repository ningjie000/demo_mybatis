package com.example.mybatis_sd.dao;

import com.example.mybatis_sd.bean.Student;
import com.example.mybatis_sd.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: NJ
 * @Description:
 * @Date: 2019/5/5
 */
public class StudentDaoImpl implements StudentDao {

    private SqlSession sqlSession;

//    @Override
//    public void insertStudent(Student student) {
//        try {
//            //读取主配置文件
//            InputStream input = Resources.getResourceAsStream("mybatis.xml");
//            //创建SqlSessionFactory对象
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
//            //创建SqlSession对象
//            sqlSession = sessionFactory.openSession();
//            //新增数据操作
//            sqlSession.insert("insertStudent", student);
//            //提交SqlSession
//            sqlSession.commit();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (sqlSession != null){
//                sqlSession.close();
//            }
//        }
//    }


    /**
     * 修改后的方法，通过工具类获取SqlSessionFactory
     * SqlSession继承了AutoCloseable接口，所以可以将其放到try后面自动关闭。
     * @param student
     */
    @Override
    public void insertStudent(Student student) {
        //SqlSession继承了AutoCloseable接口，所以可以自动关闭
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //新增数据操作
            sqlSession.insert("insertStudent", student);
            //提交SqlSession
            sqlSession.commit();

        }
    }
}
