package com.example.designpattern.SingletonPattern;

/**
 * @program: spring-boot-demo
 * @description: Ensure a class has only one instance, and provide a global point of access to it.
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * 饿汉式，从名字上也很好理解，就是“比较勤”，实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说。好处是没有线程安全的问题，坏处是浪费内存空间。
 * @author: xujiannong
 * @create: 2020-07-30 17:38
 **/
public class SingleObjectLazy {
    private static SingleObjectLazy instance;
    private SingleObjectLazy(){}

    //加锁即为安全,必须加锁 synchronized 才能保证单例，但加锁会影响效率。
    public static synchronized SingleObjectLazy getInstance() {
        if (instance == null) {
            instance = new SingleObjectLazy();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
