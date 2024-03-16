package com.frankzhou.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 日期时间工具类
 * @date 2024-03-16
 */
public class DateUtil {

    /**
     * 时间加减(分钟)
     */
    public static Date addMinutes(Date nowDate, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    public static Date addHours(Date nowDate, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    public static Date addDays(Date nowDate, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}
