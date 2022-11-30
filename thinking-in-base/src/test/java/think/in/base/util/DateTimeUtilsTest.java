package think.in.base.util;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class DateTimeUtilsTest {

    @Test
    public void getNow() {
        LocalDate now = DateTimeUtils.getNow();
        System.out.println(now);
    }

    @Test
    public void getNowBefore() {
        LocalDate nowBefore = DateTimeUtils.getNowBefore(12);
        System.out.println(nowBefore);
    }

    @Test
    public void getCurrentWeekMonday() {
        LocalDate now = LocalDate.now();
        LocalDate currentWeekMonday = DateTimeUtils.getCurrentWeekMonday(now);
        System.out.println(currentWeekMonday);
    }

    @Test
    public void getCurrentWeekSunday() {
        LocalDate now = LocalDate.now();
        LocalDate currentWeekMonday = DateTimeUtils.getCurrentWeekSunday(now);
        System.out.println(currentWeekMonday);
    }

    @Test
    public void getDayStartTime() {
        System.out.println(DateTimeUtils.getDayStartTime(LocalDate.now()));
    }

    @Test
    public void getEndTime() {
        System.out.println(DateTimeUtils.getDayEndTime(LocalDate.now().plusDays(5L)));
    }

    @Test
    public void getPeriod() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
    }


    @Test
    public void getDayEndTime() {
        LocalDateTime dayEndTime = DateTimeUtils.getDayEndTime(LocalDate.now());
        System.out.println(dayEndTime);
    }

    @Test
    public void getMonthFistDay() {
        LocalDateTime monthFistDay = DateTimeUtils.getMonthFistDay(LocalDateTime.now());
        System.out.println(monthFistDay);
    }

    @Test
    public void getMonthLastDay() {
        LocalDateTime monthLastDay = DateTimeUtils.getMonthLastDay(LocalDateTime.now());
        System.out.println(monthLastDay);
    }

    @Test
    public void getZonedDateTime() {
        System.out.println(ZoneId.getAvailableZoneIds());
    }
}