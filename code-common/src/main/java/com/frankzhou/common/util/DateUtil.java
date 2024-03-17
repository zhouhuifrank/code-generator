package com.frankzhou.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 日期时间工具类
 * @date 2024-03-16
 */
public class DateUtil {

    public static Date addByTimeUnit(Date nowDate, int times, TimeUnit unit) {
        Date nextDate = null;
        if (unit.equals(TimeUnit.SECONDS)) {
            nextDate = addSeconds(nowDate, times);
        } else if (unit.equals(TimeUnit.MINUTES)) {
            nextDate = addMinutes(nowDate, times);
        } else if (unit.equals(TimeUnit.HOURS)) {
            nextDate = addHours(nowDate, times);
        } else if (unit.equals(TimeUnit.DAYS)) {
            nextDate = addDays(nowDate, times);
        }
        return nextDate;
    }

    public static Date addSeconds(Date nowDate, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

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
