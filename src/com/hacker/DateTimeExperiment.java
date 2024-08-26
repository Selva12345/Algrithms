package com.hacker;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class DateTimeExperiment {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Duration duration=Duration.between(LocalDateTime.parse("2021-01-01 01:00",dateTimeFormatter),LocalDateTime.parse("2021-01-03 04:00",dateTimeFormatter));
       long valuie= duration.toHours();
      System.out.println(dateTimeFormatter.toString());
    }
}
