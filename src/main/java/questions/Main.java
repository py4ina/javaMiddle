package questions;

import lombok.Data;
import lombok.ToString;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import static java.lang.Integer.*;

public class Main {

    public static void main(String[] args) {
        Area area = new Area();
        area.add(new Point(0, 0));
        area.add(new Point(0, 1000));
        area.add(new Point(1000, 0));
        area.add(new Point(1000, 1000));
        area.add(new Point(900, 900));

        System.out.println(area.select(500, 10000, 500, 10000));
    }
}

@Data
@ToString
class User {

    public static final Comparator<User> BY_AGE = new AgeComparator();
    public static final Comparator<User> BY_NAME = new NameComparator();

    private int age;
    private String name;

    User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class AgeComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getAge() - user2.getAge();
    }
}

class NameComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}

@ToString
class Point {
    public final int x;
    public final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Area {
    private NavigableSet<Point> setX = new TreeSet<>((p0, p1) -> {
        int delta = p0.x - p1.x;
        return delta != 0 ? delta : (p0.y - p1.y);
    });


    private NavigableSet<Point> setY = new TreeSet<>((p0, p1) -> {
        int delta = p0.y - p1.y;
        return delta != 0 ? delta : (p0.x - p1.x);
    });

    public void add(Point point){
        setX.add(point);
        setY.add(point);
    }

    Collection<Point> select(int x0, int x1, int y0, int y1){
        NavigableSet<Point> dX = setX.subSet(
                new Point(x0, MIN_VALUE), true,
                new Point(x1, MAX_VALUE), true);
        NavigableSet<Point> dY = setY.subSet(
                new Point(MIN_VALUE, y0), true,
                new Point(MAX_VALUE, y1), true);

        dX.retainAll(dY);
        return dX;
    }
}