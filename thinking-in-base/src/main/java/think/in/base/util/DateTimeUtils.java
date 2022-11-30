package think.in.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

/**
 * @Author: GuYan
 * @Time: 2022/11/29 23:39
 * @Description: 时间和日期工具类
 **/
public class DateTimeUtils {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static LocalDate getNow() {
        return LocalDate.now();
    }

    public static LocalDate getNowBefore(long minusDay) {
        return LocalDate.now().minusDays(minusDay);
    }

    public static LocalDate getCurrentWeekMonday(LocalDate date) {
        WeekFields weekFields = WeekFields.ISO;
        LocalDate monday = date.with(weekFields.dayOfWeek(), 1L);
        return monday;
    }

    public static LocalDate getCurrentWeekSunday(LocalDate date) {
        WeekFields weekFields = WeekFields.ISO;
        LocalDate sunday = date.with(weekFields.dayOfWeek(), 7L);
        return sunday;
    }

    /**
     * 一天开始时，精确到分钟
     *
     * @return
     */
    public static LocalDateTime getDayStartTime(LocalDate date) {
        LocalDateTime localDateTime = date.atStartOfDay();
        return localDateTime;
    }

    /**
     * 一天结束时间，精确到毫秒
     *
     * @param date
     * @return
     */
    public static LocalDateTime getDayEndTime(LocalDate date) {
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalTime.MAX);
        return localDateTime;
    }

    /**
     * 获取当月的第一天
     *
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getMonthFistDay(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取当月的最后一天
     *
     * @param localDateTime 指定时间
     * @return 当月最后一日
     */
    public static LocalDateTime getMonthLastDay(LocalDateTime localDateTime) {
        return localDateTime.with(TemporalAdjusters.lastDayOfMonth());
    }
}
