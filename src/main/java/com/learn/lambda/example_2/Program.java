package com.learn.lambda.example_2;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("A", 1));
        people.add(new Person("B", 2));
        people.add(new Person("C", 3));
        people.add(new Person("D", 4));
        people.add(new Person("E", 5));

        people.stream()
                .filter(p -> p.getAge() > 3)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
    }
}