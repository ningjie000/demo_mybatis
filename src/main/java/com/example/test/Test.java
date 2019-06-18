package com.example.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: NJ
 * @Description: callable获取线程返回结果
 * @Date: 2019/6/10
 */
public class Test {

    /**
     * 1.Callable接口介绍：
     *
     * （1）java.util.concurrent.Callable是一个泛型接口，只有一个call()方法
     *
     * （2）call()方法抛出异常Exception异常，且返回一个指定的泛型类对象
     *
     * 2.Callable接口实现多线程的应用场景
     *
     * （1）当父线程想要获取子线程的运行结果时
     *
     * 3.使用Callable接口实现多线程的步骤
     *
     * （1）第一步：创建Callable子类的实例化对象
     *
     * （2）第二步：创建FutureTask对象，并将Callable对象传入FutureTask的构造方法中
     *
     * （注意：FutureTask实现了Runnable接口和Future接口）
     *
     *  (3)第三步：实例化Thread对象，并在构造方法中传入FurureTask对象
     *
     *  (4)第四步：启动线程
     * @param args
     */

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();

        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<>(td);

        new Thread(result).start();

        //2.接收线程运算后的结果
        try {
            Integer sum = result.get();  //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
            System.out.println(sum);
            System.out.println("------------------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class ThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        try{
            for (int i = 0; i <= 1000; i++) {
                sum += 1000/(1000/i);
            }
        }catch (Exception e){
            e.printStackTrace();
            return sum;
        }
        return sum;
    }

}
