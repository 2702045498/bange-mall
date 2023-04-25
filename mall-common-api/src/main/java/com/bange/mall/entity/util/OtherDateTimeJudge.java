package com.bange.mall.entity.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OtherDateTimeJudge extends TimeJudgeAbstract{
    public OtherDateTimeJudge(String name) {
        super(name);
    }

    @Override
    String processRequest(LocalDateTime localDateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration between = Duration.between(localDateTime, now);
        long days = between.toDays();
        if (days >1) {
            return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            return  nextJudge.processRequest(localDateTime);
        }
    }
}
