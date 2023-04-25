package com.bange.mall.entity.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class APPDemo {
    public static void main(String[] args) {

        //设立请求
//        LocalDateTime dateTime=LocalDateTime.now();
//        String date="2023-04-19 00:01:20";
        String date="2023-04-25 23:01:20";
        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 设立执行节点
//        SecondJudge secondJudge = new SecondJudge("秒");
//        MinuteJudge minuteJudge = new MinuteJudge("分");
//        HourJudge hourJudge = new HourJudge("时");
//        DaysJudge daysJudge = new DaysJudge("天");
//        OtherDateTimeJudge yearJudge = new OtherDateTimeJudge("日期");

        //设置成环状
//        secondJudge.setNextJudge(minuteJudge);
//        minuteJudge.setNextJudge(hourJudge);
//        hourJudge.setNextJudge(daysJudge);
//        daysJudge.setNextJudge(yearJudge);
//        yearJudge.setNextJudge(secondJudge);
        //流程开始
        DateJudge dateJudge = new DateJudge();
        String result = dateJudge.exectueJudge(dateTime);
        System.out.println("==>"+result);

    }
}
