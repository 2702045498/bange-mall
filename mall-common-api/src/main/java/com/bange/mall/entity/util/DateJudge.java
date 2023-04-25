package com.bange.mall.entity.util;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DateJudge implements Serializable {
    private SecondJudge secondJudge;
    private MinuteJudge minuteJudge;
    private HourJudge hourJudge;
    private DaysJudge daysJudge;
    private OtherDateTimeJudge otherDateTimeJudge;

    public DateJudge() {
        // 设立执行节点
        secondJudge = new SecondJudge("秒");
        minuteJudge = new MinuteJudge("分");
        hourJudge = new HourJudge("时");
        daysJudge = new DaysJudge("天");
        otherDateTimeJudge = new OtherDateTimeJudge("日期");
        //设置成环状
        secondJudge.setNextJudge(minuteJudge);
        minuteJudge.setNextJudge(hourJudge);
        hourJudge.setNextJudge(daysJudge);
        daysJudge.setNextJudge(otherDateTimeJudge);
        otherDateTimeJudge.setNextJudge(secondJudge);
    }

    public String exectueJudge(LocalDateTime localDateTime){
      return   secondJudge.processRequest(localDateTime);
    }
}
