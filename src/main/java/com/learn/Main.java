package com.learn;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(null, "p");
        System.out.println(map);
    }

    private static boolean isMeating(int firstStart, int firstLengthJump, int secondStart, int secondLengthJump){
        int firstPosition;
        int secondPosition = firstStart >= secondStart ? firstStart : secondStart;

        if (firstStart <= secondStart) {
            firstPosition = firstStart;
        }
        else {
            firstPosition = secondStart;
        }

        while (true){

            secondPosition = secondStart;

            if (firstPosition == secondPosition){
                return true;
            }

            firstPosition += firstLengthJump;
            secondPosition += secondLengthJump;
        }
    }
}
