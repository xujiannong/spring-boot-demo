package com.example.designpattern.FactoryPattern.shape;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: xujiannong
 * @create: 2020-08-05 13:37
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a circle");
    }
}
