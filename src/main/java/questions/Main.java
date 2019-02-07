package questions;

import lombok.Data;
import lombok.ToString;

import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("A", "B", "C", "A", "B", "A"));

        Map<String, Integer> map = new HashMap<>();
        toStatMap(list, map);
        System.out.println(map);

        ArrayList<Integer> tmp = new ArrayList<>(map.values());
        Collections.sort(tmp);
        System.out.println(tmp.listIterator(tmp.size()).previous());


    }

    private static void toStatMap(List<String> list, Map<String, Integer> map) {
        for (String key : list) {
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, (value + 1));
            }
        }
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