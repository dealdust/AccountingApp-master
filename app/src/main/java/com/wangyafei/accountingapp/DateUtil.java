package com.wangyafei.accountingapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //unix time -> 11:11
    public static String getFormattedTime(long timeStamp){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(new Date(timeStamp));
    }

    //2017-06-15
    public static String getFormattedDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
    }

    private static Date strToDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String getWeekDay(String date){
        String[] weekdays = {"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strToDate(date));
        int index = calendar.get(Calendar.DAY_OF_WEEK)-1;
        return  weekdays[index];
    }

    public static String getDateTitle(String date){
        String[] months ={"一月", "二月", "三月", "四月", "五月", "六月","七月", "八月","九月","十月", "十一月", "十二月"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strToDate(date));
        int monthIndex = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return  months[monthIndex] + " "+String.valueOf(day);
    }
}
