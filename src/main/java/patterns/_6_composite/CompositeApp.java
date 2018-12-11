package patterns._6_composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square_1 = new Square();
        Shape square_2 = new Square();

        Shape triangle_1 = new Triangle();
        Shape triangle_2 = new Triangle();
        Shape triangle_3 = new Triangle();

        Shape circle_1 = new Circle();
        Shape circle_2 = new Circle();
        Shape circle_3 = new Circle();
        Shape circle_4 = new Circle();

        Composite composite_1 = new Composite();
        Composite composite_2 = new Composite();
        Composite composite_3 = new Composite();

        composite_1.addComponents(square_1);
        composite_1.addComponents(triangle_1);
        composite_1.addComponents(circle_1);

        composite_2.addComponents(square_2);
        composite_2.addComponents(triangle_2);
        composite_2.addComponents(circle_2);

        composite_3.addComponents(triangle_3);
        composite_3.addComponents(circle_3);
        composite_3.addComponents(circle_4);

        composite_1.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponents(Shape components) {
        this.components.add(components);
    }

    public void removeComponents(Shape components) {
        this.components.remove(components);
    }

    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}