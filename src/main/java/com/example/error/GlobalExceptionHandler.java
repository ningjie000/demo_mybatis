package com.example.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: NJ
 * @Description: 全局捕获异常
 * @Date: 2019/6/10
 */
//扫包
@ControllerAdvice(basePackages = "")
public class GlobalExceptionHandler {
    //lombok日志



    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object errorController(){
        //错误日志存放至manggoDB中
        return null;
    }
}
