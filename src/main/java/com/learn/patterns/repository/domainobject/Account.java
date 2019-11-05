package com.learn.patterns.repository.domainobject;

public class Account {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public boolean hasUseName(String desiredUserName) {
        return this.userName.equals(desiredUserName);
    }

    public boolean ageBetween(int minAge, int maxAge) {
        return age >= minAge && age <= maxAge;
    }
}
