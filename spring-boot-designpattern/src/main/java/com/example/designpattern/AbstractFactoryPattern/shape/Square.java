package com.example.designpattern.AbstractFactoryPattern.shape;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: xujiannong
 * @create: 2020-08-05 13:38
 **/
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a square");
    }
}
