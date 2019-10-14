package com.learn.solid.liskov;

import lombok.Data;

@Data
public class Rectangle implements Shape {
    protected int width;
    protected int height;

    @Override
    public void getArea() {
        System.out.println(width * height);
    }
}
