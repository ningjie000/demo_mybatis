package com.example.mybatis_sd.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**  启动。默认扫包是同级包 **/
@SpringBootApplication
@Controller
@ComponentScan
@Service
@RestController
/**
 * 1在mapper层需要加@mapper注解
 * 2在springboot可以在mapper层不加注解，但是必须在启动类加@MapperScan扫包，多个包逗号隔开
 * spring事物，通过aop技术 环绕通知进行拦截
 *
 * yml文件比Properties更加节约
 * yml文件冒号：后一定有空格
 *
 * 需要制定java- jar主函数，pom。xml中
 *
 * springboot2.0内置tomcat是8.5.28
 *
 * tomcat以下版本用户不了，高版本向下兼容
 *
 *
 * 热部署原理：核心类加载器，字节码
 *             监听class文件是否发生改变
 *             发生改变用classloder重新读取
 *
 *
 * 热部署不能用在生产环境
 *
 * 热部署本地开发提高效率，缺点比较占内存
 *
 * dev—tools每次部署的时候重启  采用重启机制，工具使用类加载机制
 *
 *
 * springboot性能优化问题
 * JVM参数调优
 * 扫包优化
 * 默认容器TOMCAT改为 undertow
 *
 * undertow web服务器
 * tomcat吞吐量5000，undertow8000
 *
 * 1、扫包优化
 *    不是运行优化，是启动优化
 *
 * 2 、JVM参数调优， 初始化内存与最大堆相同 尽量减少GC回收
 * 不一致，频繁回收。。
 *
 *
 *  Springboot监控中心
 *  针对微服务 服务器监控，服务器内存变化（堆内存，线程，日志等）。检测服务配置连接诶地址
 *  是否可用（模拟访问、懒加载） 统计spring容器中多少bean
 *  为什么使用Springboot监控中心 http请求资源监控
 *
 *  ****actuator监控应用（没有界面，返回json格式）
 *  默认3个权限开启
 *
 *  adminUI：有可视化界面，一般生产环境
 *
 *  外网映射工具netapp
 *
 *     nginx应用场景 http服务器（ngix静态服务器）
 *     ，减小单台服务器压力故障转移（重试机制） 健康检查（tcp http 心跳）
 *     虚拟主机 反向代理 （
 *     负载均衡 - 减小单台服务器压力
 *     ）反向代理隐藏真实IP地址
 *     安全配置
 *     实现网站动静分离
 *     搭建api网关
 *     防止ddos（安全控制）
 *
 *
 *      nginx启动监听端口号是80
 *      使用nginx使用域名区分项目
 *      创建data----里面文件www和bbs区分域名
 *      config文件里配置
 *      localtion配/表示匹配所有
 *      反向代理 nginx拦截所有请求，内部实现转发到真实服务器中
 *      反向代理作用 实现安全性
 *      nginx反向代理内网比外网效率高，而且安全
 *
 *
 *
 *      location ：主要配置路径地址URL
 *···server  表示服务
 *      listen 创建监听端口号
 *      server_name服务器名称，默认不区分大小写
 *      location: / 表示/后面不能带任何地址
 *      nginx反向代理，网关作用权限控制
 *
 *    负载均衡：使用负载均衡器（四层负载均衡器-基于tcp LV5（软负载）换人F5硬件负载
 *    ，七层负载均衡器 基于应用层（基于http协议实现））  1.9之后支持4层负载均衡
 *    目的是解决高并发
 *    将所有请求转发到负载均衡器，
 *    四层负载均衡主要针对传输层tcp协议，七层应用层主要针对http
 *
 *    负载均衡带来的问题，分布式的分题
 *
 *    ngix中配置负载均衡，使用upstream server上游服务器，使用上游服务器转发到真实服务器
 *    nginx 负载均衡  故障转移
 *
 *    轮询机制 均匀分配访问
 *    算法
 *    1.轮询机制
 *    2.权重截止
 *    3、ip绑定
 * consul实现分布式服务发现与注册
 * nginx + consul +upsync(新浪开源技术)实现动态负载均衡
 *
 *
 * 服务访问过多，添加一个限制
 * 服务熔断可服务降级一起使用 目的是服务不会被宕机掉、
 * 默认情况下只有一个线程池维护所有接口
 * 解决雪崩：使用服务隔离（线程池方式和信号量）
 *
 * **/
//@EnableConfigurationProperties(value = )开启读取配置文件
//@SpringBootApplication 等同于@ComponentScan缺点 扫包核心，同级包，递归遍历包下子类
//影响到启动项目时间 会扫到无用的包
//定位包，不扫同级包


public class DemoApplication {
    //t为引入的类
    @Value("#{T(System).currentTimeMillis()}")
    private Long initTime = null;


    /**
     * 外部启动和内部启动  // run - editconfig springboot
     *
     * 默认4g 初始化不是
     *
     * jconsole查看堆内存 java安装bin目录下 ，图曲线突然下降gc回收
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
