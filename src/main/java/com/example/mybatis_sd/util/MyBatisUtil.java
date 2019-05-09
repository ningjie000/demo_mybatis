package com.example.mybatis_sd.util;

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
/**
 * DCL的单例模式
 */
public class MyBatisUtil {
    //不需要将构造方法私有化，因为这里的单例只是保证外界使用当前工具时创建一个SqlSessionFactory对象就行
//    private MyBatisUtil() {
//
//    }

    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        try {
            if (sqlSessionFactory == null) {
                //读取主配置文件
                InputStream input = Resources.getResourceAsStream("mybatis.xml");
                synchronized (MyBatisUtil.class) {
                    if (sqlSessionFactory == null){
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory.openSession();
    }

}
