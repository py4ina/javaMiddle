package com.learn;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null, "p");
        System.out.println(map);
    }

    private static boolean isMeating(int firstStart, int firstLengthJump, int secondStart, int secondLengthJump){

        while (true){

            if ((firstStart + firstLengthJump) == (secondStart + secondLengthJump)){
                return true;
            }
//            firstLengthJump
        }
    }
}
