package com.bange.user.service.impl;

import com.bange.mall.service.IDateTimeConvertor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class LocalDateTimeConvertorImpl implements IDateTimeConvertor {
    @Override
    public LocalDateTime longToLocalDateTime(Long timestamp) {
       return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

    @Override
    public String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public LocalDateTime StringToLocalDatetime(String datetime) {
        return LocalDateTime.parse(datetime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
