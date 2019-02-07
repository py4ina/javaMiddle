package questions;

import lombok.Data;
import lombok.ToString;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<String> list = Arrays.asList("A", "B", "C", "A", "B", "A");
//        System.out.println(list);
        f(1,2,3,4,5,6,7,8,9,1,1,1,1,1,1,1,1);

    }

    public static void f(int... args) {
        System.out.println(Arrays.toString(args));
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