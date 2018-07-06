package com.jwx.studying.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * PackageName:PACKAGE_NAME
 * FileName: DateUtil.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/6/21
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    static GregorianCalendar cldr = new GregorianCalendar();
    public static final long DAYMILLI = 86400000L;
    public static final long HOURMILLI = 3600000L;
    public static final long MINUTEMILLI = 60000L;
    public static final long SECONDMILLI = 1000L;
    public static final String TIMETO = " 23:59:59";
    public static final transient int BEFORE = 1;
    public static final transient int AFTER = 2;
    public static final transient int EQUAL = 3;
    public static final String TIME_PATTERN_LONG = "dd/MMM/yyyy:HH:mm:ss +0900";
    public static final String TIME_PATTERN_LONG2 = "dd/MM/yyyy:HH:mm:ss +0900";
    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DB_TIME_PATTERN = "YYYY-MM-DD HH24:MI:SS";
    public static final String TIME_PATTERN_SHORT = "dd/MM/yy HH:mm:ss";
    public static final String TIME_PATTERN_SHORT_1 = "yyyy/MM/dd HH:mm";
    public static final String TIME_PATTERN_SESSION = "yyyyMMddHHmmss";
    public static final String DATE_FMT_0 = "yyyyMMdd";
    public static final String DATE_FMT_1 = "yyyy/MM/dd";
    public static final String DATE_FMT_2 = "yyyy/MM/dd hh:mm:ss";
    public static final String DATE_FMT_3 = "yyyy-MM-dd";
    public static final String DATE_FMT_4 = "MM.dd";
    public static final String DATE_FMT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'";


    public static Date toDate(String sDate, String sFmt) {
        if(!org.apache.commons.lang3.StringUtils.isBlank(sDate) && !org.apache.commons.lang3.StringUtils.isBlank(sFmt)) {
            SimpleDateFormat sdfFrom = null;
            Date dt = null;

            Object var5;
            try {
                sdfFrom = new SimpleDateFormat(sFmt);
                dt = sdfFrom.parse(sDate);
                return dt;
            } catch (Exception var9) {
                logger.error("An toDate exception occurs: ", var9);
                var5 = null;
            } finally {
                sdfFrom = null;
            }

            return (Date)var5;
        } else {
            return null;
        }
    }

    public static String toString(Date dt) {
        return toString(dt, "yyyyMMdd");
    }

    public static String toString(Date dt, String sFmt) {
        if(null != dt && !org.apache.commons.lang3.StringUtils.isBlank(sFmt)) {
            SimpleDateFormat sdfFrom = null;
            String sRet = null;

            Object var5;
            try {
                sdfFrom = new SimpleDateFormat(sFmt);
                sRet = sdfFrom.format(dt).toString();
                return sRet;
            } catch (Exception var9) {
                logger.error("An toString exception occurs: ", var9);
                var5 = null;
            } finally {
                sdfFrom = null;
            }

            return (String)var5;
        } else {
            return null;
        }
    }

    public static Date getMonthLastDate(Date date) {
        if(null == date) {
            return null;
        } else {
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(11, 23);
            ca.set(12, 59);
            ca.set(13, 59);
            ca.set(5, 1);
            ca.add(2, 1);
            ca.add(5, -1);
            Date lastDate = ca.getTime();
            return lastDate;
        }
    }

    public static String getMonthLastDate(Date date, String pattern) {
        Date lastDate = getMonthLastDate(date);
        if(null == lastDate) {
            return null;
        } else {
            if(org.apache.commons.lang3.StringUtils.isBlank(pattern)) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }

            return toString(lastDate, pattern);
        }
    }

    public static Date getMonthFirstDate(Date date) {
        if(null == date) {
            return null;
        } else {
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(11, 0);
            ca.set(12, 0);
            ca.set(13, 0);
            ca.set(5, 1);
            Date firstDate = ca.getTime();
            return firstDate;
        }
    }

    public static Date getLastMonthFirstDate(Date date) {
        if(null == date) {
            return null;
        } else {
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(11, 0);
            ca.set(12, 0);
            ca.set(13, 0);
            ca.set(5, 1);
            ca.add(2, -1);
            Date firstDate = ca.getTime();
            return firstDate;
        }
    }

    public static Date getLastMonthLastDate(Date date) {
        if(null == date) {
            return null;
        } else {
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(11, 23);
            ca.set(12, 59);
            ca.set(13, 59);
            ca.set(5, 1);
            ca.add(5, -1);
            Date lastDate = ca.getTime();
            return lastDate;
        }
    }

    public static String getMonthFirstDate(Date date, String pattern) {
        Date firstDate = getMonthFirstDate(date);
        if(null == firstDate) {
            return null;
        } else {
            if(org.apache.commons.lang3.StringUtils.isBlank(pattern)) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }

            return toString(firstDate, pattern);
        }
    }

    public static int getIntervalDays(Date firstDate, Date lastDate) {
        if(null != firstDate && null != lastDate) {
            long intervalMilli = lastDate.getTime() - firstDate.getTime();
            return (int)(intervalMilli / 86400000L);
        } else {
            return -1;
        }
    }

    public static int getDatesInterval(Date firstDate, Date lastDate) throws NullPointerException {
        if(null == firstDate) {
            throw new NullPointerException("firstDate can not be null!");
        } else if(null == lastDate) {
            throw new NullPointerException("lastDate can not be null!");
        } else {
            long intervalMilli = beginOfADay(lastDate).getTime() - beginOfADay(firstDate).getTime();
            BigDecimal b = new BigDecimal(86400000);
            return (new BigDecimal(intervalMilli)).divide(b, 0, 0).intValue();
        }
    }

    public static int getTimeIntervalHours(Date firstDate, Date lastDate) {
        if(null != firstDate && null != lastDate) {
            long intervalMilli = lastDate.getTime() - firstDate.getTime();
            return (int)(intervalMilli / 3600000L);
        } else {
            return -1;
        }
    }

    public static int getTimeIntervalMins(Date firstDate, Date lastDate) {
        if(null != firstDate && null != lastDate) {
            long intervalMilli = lastDate.getTime() - firstDate.getTime();
            return (int)(intervalMilli / 60000L);
        } else {
            return -1;
        }
    }

    public static String formatDate(Date d, String pattern) {
        if(null != d && !org.apache.commons.lang3.StringUtils.isBlank(pattern)) {
            SimpleDateFormat formatter = (SimpleDateFormat) DateFormat.getDateInstance();
            formatter.applyPattern(pattern);
            return formatter.format(d);
        } else {
            return null;
        }
    }

    public static int compareDate(Date src, Date desc) {
        if(src == null && desc == null) {
            return 3;
        } else if(desc == null) {
            return 1;
        } else if(src == null) {
            return 2;
        } else {
            long timeSrc = src.getTime();
            long timeDesc = desc.getTime();
            return timeSrc == timeDesc?3:(timeDesc > timeSrc?2:1);
        }
    }

    public static int compareTwoDate(Date first, Date second) {
        return first == null && second == null?3:(first == null?1:(second == null?2:(first.before(second)?1:(first.after(second)?2:3))));
    }

    public static boolean isDateBetween(Date date, Date begin, Date end) {
        int c1 = compareTwoDate(begin, date);
        int c2 = compareTwoDate(date, end);
        return c1 == 1 && c2 == 1 || c1 == 3 || c2 == 3;
    }

    public static boolean isDateBetween(Date myDate, int begin, int end) {
        return isDateBetween(myDate, getCurrentDateTime(), begin, end);
    }

    public static boolean isDateBetween(Date utilDate, Date dateBaseLine, int begin, int end) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String my = toString(utilDate, pattern);
        Date myDate = parseString2Date(my, pattern);
        String baseLine = toString(dateBaseLine, pattern);
        String from = addDays(baseLine, begin);
        Date fromDate = parseString2Date(from, pattern);
        String to = addDays(baseLine, end);
        Date toDate = parseString2Date(to, pattern);
        return isDateBetween(myDate, fromDate, toDate);
    }

    /** @deprecated */
    public static Timestamp parseString2Timestamp(String str, String sFmt) {
        if(str != null && !str.equals("")) {
            try {
                long time = Long.parseLong(str);
                return new Timestamp(time);
            } catch (Exception var7) {
                try {
                    DateFormat df = new SimpleDateFormat(sFmt);
                    Date dt = df.parse(str);
                    return new Timestamp(dt.getTime());
                } catch (Exception var6) {
                    try {
                        return Timestamp.valueOf(str);
                    } catch (Exception var5) {
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
    }

    /** @deprecated */
    public static Date parseString2Date(String str, String sFmt) {
        if(str != null && !str.equals("")) {
            try {
                long time = Long.parseLong(str);
                return new Date(time);
            } catch (Exception var7) {
                try {
                    DateFormat df = new SimpleDateFormat(sFmt);
                    Date dt = df.parse(str);
                    return new Date(dt.getTime());
                } catch (Exception var6) {
                    logger.warn("parseString2Date warning:", var6);

                    try {
                        return new Date(str);
                    } catch (Exception var5) {
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
    }

    public static Date addDate(Date date, int day) {
        if(null == date) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(5, calendar.get(5) + day);
            return calendar.getTime();
        }
    }

    public static String addDays(Date date, int day, String pattern) {
        return addDays(toString(date, pattern), day, pattern);
    }

    public static String addDays(Date date, int day) {
        return addDays(toString(date, "yyyy-MM-dd HH:mm:ss"), day);
    }

    public static String addDays(String date, int day) {
        return addDays(date, day, "yyyy-MM-dd HH:mm:ss");
    }

    public static String addDays(String date, int day, String pattern) {
        if(date == null) {
            return "";
        } else if(date.equals("")) {
            return "";
        } else if(day == 0) {
            return date;
        } else {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                Calendar calendar = dateFormat.getCalendar();
                calendar.setTime(dateFormat.parse(date));
                calendar.set(5, calendar.get(5) + day);
                return dateFormat.format(calendar.getTime());
            } catch (Exception var5) {
                logger.error("An addDays exception occurs: ", var5);
                return "";
            }
        }
    }

    public static String formatTimestamp(Timestamp t, String sFmt) {
        if(t != null && !org.apache.commons.lang3.StringUtils.isBlank(sFmt)) {
            t.setNanos(0);
            DateFormat ft = new SimpleDateFormat(sFmt);
            String str = "";

            try {
                str = ft.format(t);
            } catch (NullPointerException var5) {
                logger.error("An formatTimestamp exception occur:", var5);
            }

            return str;
        } else {
            return "";
        }
    }

    /** @deprecated */
    public static Timestamp parseString(String str, String sFmt) {
        if(str != null && !str.equals("")) {
            try {
                long time = Long.parseLong(str);
                return new Timestamp(time);
            } catch (Exception var7) {
                try {
                    DateFormat df = new SimpleDateFormat(sFmt);
                    Date dt = df.parse(str);
                    return new Timestamp(dt.getTime());
                } catch (Exception var6) {
                    try {
                        return Timestamp.valueOf(str);
                    } catch (Exception var5) {
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }

    public static Timestamp getCurrentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static final int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static final int getYear(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(1);
    }

    public static final int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static final int getMonth(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(2) + 1;
    }

    public static final int getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static final int getDays(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(11, 23);
        ca.set(12, 59);
        ca.set(13, 59);
        ca.set(5, 1);
        ca.add(2, 1);
        ca.add(5, -1);
        return ca.get(5);
    }

    public static final int getDate(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(5);
    }

    public static final int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(7);
    }

    public static final int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(11);
    }

    public static final int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(12);
    }

    public static final int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(13);
    }

    public static final int getHour(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(11);
    }

    public static final Date zerolizedTime(Date fullDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fullDate);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date beginOfADay(Date date) {
        return setCalendarTime(date, 0, 0, 0).getTime();
    }

    public static Date endOfADay(Date date) {
        return setCalendarTime(date, 23, 59, 59).getTime();
    }

    public static Date specificTimeOfDay(Date date, Integer hour, Integer min, Integer sec) {
        return setCalendarTime(date, hour.intValue(), min.intValue(), sec.intValue()).getTime();
    }

    private static Calendar setCalendarTime(Date date, int hour, int min, int sec) {
        Calendar cal = Calendar.getInstance();
        if(null != date) {
            cal.setTime(date);
        }

        cal.set(11, hour);
        cal.set(12, min);
        cal.set(13, sec);
        cal.set(14, 0);
        return cal;
    }



    public static Boolean isToday(Date date) {
        Date nowTime = new Date();
        return Boolean.valueOf(isDateBetween(date, beginOfADay(nowTime), endOfADay(nowTime)));
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String format) {
        return (new SimpleDateFormat(format)).format(date);
    }

    public static long diff(Date begin, Date end, int field) {
        long diff = end.getTime() - begin.getTime();
        if(14 == field) {
            return diff;
        } else {
            diff /= 1000L;
            if(13 == field) {
                return diff;
            } else {
                diff /= 60L;
                if(12 == field) {
                    return diff;
                } else {
                    diff /= 60L;
                    if(10 != field && 11 != field) {
                        diff /= 24L;
                        return 5 != field && 7 != field && 8 != field && 6 != field?(2 == field?diff / 30L:(1 == field?diff / 365L:diff)):diff;
                    } else {
                        return diff;
                    }
                }
            }
        }
    }

    public static Date getDayOfWeek(Date selectTime, Integer distanceWeeks, Integer dayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, distanceWeeks.intValue() * 7);
        return new Date();
    }

    public static Date getWholeHourFormatOfDate(Date date) {
        int hour = getHour(date);
        return addHour(beginOfADay(date), hour);
    }

    public static Date addHour(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(11, offset);
        return calendar.getTime();
    }

    public static Date addSecond(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(13, offset);
        return calendar.getTime();
    }


    public static boolean isLeapYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(1);
        if(year % 100 == 0) {
            if(year % 400 == 0) {
                return true;
            }
        } else if(year % 4 == 0) {
            return true;
        }

        return false;
    }

    public static int getMonthsOfTwoDate(String date1, String date2) {
        int n = 0;
        date2 = date2 == null?getCurrentDateStr():date2;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (ParseException var7) {
            var7.printStackTrace();
        }

        while(!c1.after(c2)) {
            ++n;
            c1.add(2, 1);
        }

        --n;
        return n;
    }

    public static String getCurrentDateStr() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        return simple.format(date);
    }

    static {
        cldr.setTimeZone(TimeZone.getTimeZone("GMT+9:00"));
    }
    public static void main(String[] args){
          System.out.println(DateUtil.addDate(new Date(),1));
    }
}
