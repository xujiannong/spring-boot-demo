package com.example.designpattern.FactoryPattern.shape;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: xujiannong
 * @create: 2020-08-05 11:40
 **/
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("this is a rectangle");
    }
}
