package com.learn.servlet.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private Role role;

    public User(int id, String login, String password, String email, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}