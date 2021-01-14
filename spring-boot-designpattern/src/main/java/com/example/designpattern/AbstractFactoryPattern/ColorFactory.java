package com.example.designpattern.AbstractFactoryPattern;

import com.example.designpattern.AbstractFactoryPattern.AbstractFactory;
import com.example.designpattern.AbstractFactoryPattern.color.Blue;
import com.example.designpattern.AbstractFactoryPattern.color.Color;
import com.example.designpattern.AbstractFactoryPattern.color.Green;
import com.example.designpattern.AbstractFactoryPattern.color.Red;
import com.example.designpattern.AbstractFactoryPattern.shape.Circle;
import com.example.designpattern.AbstractFactoryPattern.shape.Rectangle;
import com.example.designpattern.AbstractFactoryPattern.shape.Shape;
import com.example.designpattern.AbstractFactoryPattern.shape.Square;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: xujiannong
 * @create: 2020-08-05 11:35
 **/
public class ColorFactory extends AbstractFactory{

    //使用 getShape 方法获取形状类型的对象
    @Override
    public Shape getShape(String colorType){
       return null;
    }

    @Override
    public Color getColor(String colorType) {
        if(colorType == null){
            return null;
        }
        if(colorType.equalsIgnoreCase("RED")){
            return new Red();
        } else if(colorType.equalsIgnoreCase("BLUE")){
            return new Blue();
        } else if(colorType.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;
    }
}
