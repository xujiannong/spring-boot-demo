package com.example.designpattern.AbstractFactoryPattern;

import com.example.designpattern.AbstractFactoryPattern.color.Color;
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
public class ShapeFactory extends AbstractFactory{

    //使用 getShape 方法获取形状类型的对象
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
