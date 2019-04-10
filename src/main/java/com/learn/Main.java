package com.learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map map = new TestMap();
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            Object o = iterator.next();
            System.out.println(o);
        }
    }
}

class TestMap extends HashMap {
    @Override
    public Set keySet(){
        return  null;
    }
}