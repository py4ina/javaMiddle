package com.learn.solid.liskov;

public class Calculate {
    public int calculateRectangleSquare(Rectangle rectangle, int width, int height){
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        int square = rectangle.getHeight() * rectangle.getWidth();
        System.out.println(square);
        return square;
    }
}
