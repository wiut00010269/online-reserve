package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek 08/04/2024   10:25

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {



//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDateTime dateTime = LocalDateTime.parse("2024-04-07 08:21:10.046699");
//
//        LocalDateTime startDateTime = dateTime.minusDays(1);
//        String start = startDateTime.format(formatter);
//
//        LocalDateTime endDateTime = dateTime.plusDays(1);
//        String end = endDateTime.format(formatter);
//
//        System.out.println(start);
//        System.out.println(end);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse("2024-04-07 08:21:10.046699", formatter);

        LocalDateTime startDateTime = dateTime.minusDays(1);
        String start = startDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        LocalDateTime endDateTime = dateTime.plusDays(1);
        String end = endDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println(start);
        System.out.println(end);

    }
}
