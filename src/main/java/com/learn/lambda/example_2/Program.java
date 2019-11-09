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

        double averageAge = people.stream()
                .filter(p -> p.getAge() >= 2)
                .mapToInt(p -> p.getAge()).average().getAsDouble();

        System.out.println(averageAge);
    }
}