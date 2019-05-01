package com.learn.servlet.paradigm.oop;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

interface Figure {
    public void draw(Graphics graphics);
}

abstract class AbstractFigure implements Figure {
    protected AbstractFigure() {
        System.out.println("create " + this.getClass().getSimpleName());
    }

    public final String toString(){
        return this.getClass().getSimpleName();
    }
}

interface Graphics {
    public void drawLine(int x0, int y0, int x1, int y1);
}

class Oval extends AbstractFigure {

    @Override
    public void draw(Graphics graphics) {
        throw new UnsupportedOperationException();
    }
}

class Rect extends AbstractFigure {
    private int leftBottomX;
    private int leftBottomY;
    private int width;
    private int height;

    public Rect(int leftBottomX, int leftBottomY, int width, int height) {
        this.leftBottomX = leftBottomX;
        this.leftBottomY = leftBottomY;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        throw new UnsupportedOperationException();
    }
}

class VisualUtils {
    public static void drawALL(List<Figure> figures, Graphics graphics) {
        Iterator<Figure> iterator = figures.iterator();
        while (iterator.hasNext()){
            iterator.next().draw(graphics);
        }
    }

    public static void main(String[] args) {
        drawALL(Arrays.asList(
                new Rect(0, 0, 0, 0),
                new Rect(1, 1, 1, 1)),
                (x0, y0, x1, y1) -> System.out.println("draw: "+x0+", "+y0+", "+x1+", "+y1)

        );
    }
}