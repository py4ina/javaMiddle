package com.learn;


import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        LocalDateTime parse = LocalDateTime.parse("2020-01-14 14:35:12.0");
        LocalDate now = LocalDate.now();
        LocalTime lt = LocalTime.parse("02:53:40");
        Instant instant = lt.atDate(LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth())).
                atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(),
                ZoneId.systemDefault());
        System.out.println(localDateTime);
    }
}
