package questions;

import lombok.Data;
import lombok.ToString;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        NavigableSet<User> users = new TreeSet<>(User.BY_AGE);

        users.add(new User(1, "A"));
        users.add(new User(2, "B"));
        users.add(new User(3, "C"));
        users.add(new User(4, "D"));
        users.add(new User(5, "I"));
        users.add(new User(6, "F"));

        System.out.println(users
                .subSet(new User(2, "B"),
                        true ,
                        new User(5, "I"),
                        true)
        );
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