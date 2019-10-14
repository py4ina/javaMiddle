package com.learn.solid.liskov;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        square.setWidth(10);
        square.getArea();

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(10);
        rectangle.getArea();
    }
}
