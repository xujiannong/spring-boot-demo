package com.example.designpattern.AbstractFactoryPattern.color;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: xujiannong
 * @create: 2020-08-05 13:50
 **/
public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("Green");
    }
}
