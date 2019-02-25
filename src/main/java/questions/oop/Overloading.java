package questions.oop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Overloading {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Circle(1));
        figures.add(new Rectangle(2, 1));
        figures.add(new Triangle());

        for (Figure figure : figures) {
            FigureUtils.perimeter(figure);
        }
    }
}

interface Figure {}

class FigureUtils {
    public static String perimeter(Circle circle) {
        return "circle: " + circle.toString();
    }

    public static String perimeter(Rectangle rectangle) {
        return "rectangle: " + rectangle.toString();
    }

    public static String perimeter(Figure figure) {
        if (figure instanceof Circle) {
            return perimeter((Circle) figure);
        } else if (figure instanceof Rectangle) {
            return perimeter((Rectangle) figure);
        } else {
            throw new Error("Bad type!");
        }
    }
}

@Data
class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
}

@Data
class Rectangle implements Figure {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

@Data
class Triangle implements Figure {}