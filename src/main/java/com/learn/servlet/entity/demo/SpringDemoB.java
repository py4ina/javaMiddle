package com.learn.servlet.entity.demo;

import lombok.Getter;

@Getter
public class SpringDemoB {
    private int x;
    private int y;

    public SpringDemoB(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
