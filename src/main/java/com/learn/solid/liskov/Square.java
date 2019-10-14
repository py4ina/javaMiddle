package com.learn.solid.liskov;

import lombok.Data;

@Data
public class Square implements Shape {
    private int width;

    @Override
    public void getArea() {
        System.out.println(width * width);
    }
}
