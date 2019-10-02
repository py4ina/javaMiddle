package com.learn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[] {
                Employee.builder()
                        .name("John")
                        .age(25)
                        .salary(3000.0)
                        .mobile(9922001)
                        .build(),
                Employee.builder()
                        .name("Ace")
                        .age(22)
                        .salary(2000.0)
                        .mobile(9922002)
                        .build(),
                Employee.builder()
                        .name("Keith")
                        .age(35)
                        .salary(4000.0)
                        .mobile(9922003)
                        .build(),
        };
    }
}

@Data
@AllArgsConstructor
@Builder
class Employee {
    String name;
    int age;
    double salary;
    long mobile;
}