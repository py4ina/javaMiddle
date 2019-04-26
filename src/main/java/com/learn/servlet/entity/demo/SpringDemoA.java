package com.learn.servlet.entity.demo;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Setter
public class SpringDemoA {
    private int[] intArray;
//    @Autowired
    private Map<String, SpringDemoB> map;

    public SpringDemoA() {
    }
}
