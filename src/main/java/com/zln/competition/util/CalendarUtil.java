package com.zln.competition.util;

import java.util.Calendar;

public class CalendarUtil {
    //获取年
    public static Integer getYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    //获取月
    public static Integer getMonth(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        if(month + 1 > 12){
            return 1;
        }else{
            return month + 1;
        }
    }

    //获取日
    public static Integer getDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

}
