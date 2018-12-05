package patterns._1_delegate;

public class DelegatApp {
    public static void main(String[] args) {
        Painter painter = new Painter();

        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();
    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}

class Square implements Graphics {
    public void draw() {
        System.out.println("Square.draw()");
    }
}

class Circle implements Graphics {
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

class Painter {
    Graphics graphics;

    void setGraphics(Graphics g) {
        this.graphics = g;
    }

    void draw(){
        graphics.draw();
    }
}