package com.example.mybatis_sd.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: NJ
 * @Description:
 * @Date: 2019/6/10
 */
@Slf4j   //日志注解，
//@Setter  //直接加在类上
//@Getter
@Data //data等于上面两个注解
public class UserPO {
    //字节码技术生成setter getter
//    @Setter
//    @Getter
    //初始化的时候读取
    @Value("${}")
    private String userName;
//    @Setter
//    @Getter
    private String password;

    public static void main(String[] args) {
        log.info("");
    }
}
