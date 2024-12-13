package kopo.poly.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Objects;

public class DateUtil {
    /**
     * 날짜, 시간 출력하기
     * @param fm 날짜 출력 형식
     * @return date
     */
    public static String getDateTime(String fm) {

        Date today = new Date();
        System.out.println(today);

        SimpleDateFormat date = new SimpleDateFormat(fm);

        return date.format(today);
    }


    public static String getLongDateTime(Object time, String fm) {
        return getLongDateTime((Integer) time, fm);
    }


    public static String getLongDateTime(Integer time, String fm) {
        Instant instant = Instant.ofEpochSecond(time);
        return DateTimeFormatter.ofPattern(fm)
                .withZone(ZoneId.systemDefault())
                .format(instant);
    }

    public static LocalDateTime stringToLocalDateTime(String dateTimeString, String format) {
        try{
            String date = CmmUtil.nvl(dateTimeString, getDateTime(format));

            DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(format);

            return LocalDateTime.parse(date, FORMATTER);
        } catch (DateTimeParseException e) {

            // 변환에 실패한 경우 예외 처리
            throw new IllegalArgumentException("Invalid date format, expected 'yyyy-MM-dd HH:mm:ss'",e);
        }
    }


    public static LocalDateTime stringToLocalDateTime(String s) {
        return stringToLocalDateTime(s, "yyyy-MM-dd HH:mm:ss");
    }
}

