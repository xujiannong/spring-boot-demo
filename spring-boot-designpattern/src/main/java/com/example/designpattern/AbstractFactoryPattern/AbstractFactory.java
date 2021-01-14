package com.example.designpattern.AbstractFactoryPattern;

import com.example.designpattern.AbstractFactoryPattern.color.Color;
import com.example.designpattern.AbstractFactoryPattern.shape.Shape;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: xujiannong
 * @create: 2020-08-05 17:51
 **/
public abstract class AbstractFactory {
    public abstract Shape getShape(String shape);
    public abstract Color getColor(String color);
}
