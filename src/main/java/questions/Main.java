package questions;

import lombok.Data;
import lombok.ToString;

import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("A", "B", "C", "A", "B"));

        Map<String, Integer> map = toStatMap(list);
        System.out.println(map);

        TreeSet<Map.Entry<String, Integer>> entries = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry0, Map.Entry<String, Integer> entry1) {
                int delta = entry0.getValue() - entry1.getValue();
                return delta != 0 ? delta : entry0.getKey().compareTo(entry1.getKey());
            }
        });
        entries.addAll(map.entrySet());
        TreeMap<String, Integer> tmp = new TreeMap<>();
        tmp.put("*", entries.last().getValue());
        Map.Entry<String, Integer> edge = tmp.entrySet().iterator().next();
        entries.tailSet(edge);
        System.out.println(entries);
    }

    private static HashMap<String, Integer> toStatMap(List<String> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String key : list) {
            Integer value = hashMap.get(key);
            if (value == null) {
                hashMap.put(key, 1);
            } else {
                hashMap.put(key, (value + 1));
            }
        }
        return hashMap;
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