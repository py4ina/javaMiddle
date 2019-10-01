package com.learn;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final String PATH = "/src/main/resources/learnFiles/input.xml";


    public static void main(String ... args) {
        Set<Person> people = new TreeSet<>();
        people.add(new Person("Anna", 25));
        people.add(new Person("Anna", 26));
        people.add(new Person("Anna", 21));

        System.out.println(people.toString());
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person that) {
        int result = this.age - that.age;
        if (result != 0){
            return result;
        } else {
            return this.name.compareTo(that.name);
        }
    }
}