package com.example.designpattern.SingletonPattern;

/**
 * @program: spring-boot-demo
 * @description: Ensure a class has only one instance, and provide a global point of access to it.
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * 饿汉式，从名字上也很好理解，就是“比较勤”，实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说。好处是没有线程安全的问题，坏处是浪费内存空间。
 * 使用场景：
 * ● 要求生成唯一序列号的环境；
 * ● 在整个项目中需要一个共享访问点或共享数据，例如一个Web页面上的计数器，可以不用把每次刷新都记录到数据库中，使用单例模式保持计数器的值，并确保是线程安全的；
 * ● 创建一个对象需要消耗的资源过多，如要访问IO和数据库等资源；
 * ● 需要定义大量的静态常量和静态方法（如工具类）的环境，可以采用单例模式（当然，也可以直接声明为static的方式）。
 * @author: xujiannong
 * @create: 2020-07-30 17:38
 **/
public class SingleObjectHungry {
    //创建 SingleObject 的一个对象
    private static SingleObjectHungry instance = new SingleObjectHungry() ;

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObjectHungry(){}

    //获取唯一可用的对象
    public static SingleObjectHungry getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}


