package harvest.arvin.android.com.androidcommontool.util;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
*@author arvin
*@date 2017/9/29
*@describe TO DO
*@name TimeUtils
*/


public class TimeUtils {

    public static final String SECONDS = "yyyy-MM-dd HH:mm:ss";
    public static final String MINITUS = "yyyy-MM-dd HH:mm";
    public static final String MILLISECONDS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String MONTH_DAY = "MM/dd";

    public static String getTimeStr(String time, String... format) {
        if (TextUtils.isEmpty(time)) {
            return null;
        }
        String f = SECONDS;
        if (format != null && format.length > 0) {
            f = format[0];
        }
        SimpleDateFormat dataFormate = new SimpleDateFormat(f, Locale.CHINA);
        String timeStr = dataFormate.format(new Date(Long.valueOf(time)));
        return timeStr;
    }

    public static String getTimeStr(long time, String... format) {
        String f = SECONDS;
        if (format != null && format.length > 0) {
            f = format[0];
        }
        SimpleDateFormat dataFormate = new SimpleDateFormat(f, Locale.CHINA);
        String timeStr = dataFormate.format(new Date(time));
        return timeStr;
    }

    public static String getDateByLong(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getDateForMinuteSecondByLong(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MINITUS, Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getDateForSecondByLong(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SECONDS, Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getYMDDateByLong(long time){
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取星期几
     */
    public static String getWeekOfDate(long time) {
        Date date = new Date(time);
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    /**
     * 获取类似08-29 周一 12:30的日期格式
     */
    public static String getFinalDate(long time) {
        String date = getDateForMinuteSecondByLong(time);
        String month = date.substring(5, 10);
        String minute = date.substring(11, date.length());
        String week = getWeekOfDate(time);
        return month + " " + week + " " + minute;
    }

    /**
     * 获取类似08-29 12:30的日期格式
     */
    public static String getMonthHourDate(long time) {
        String date = getDateForMinuteSecondByLong(time);
        String month = date.substring(5, 10);
        String minute = date.substring(11, date.length());
        return month + " " + minute;
    }


    public static String getDateByLongByPattern(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getRemainTimeStrByLong(long endtime, long curtime) {
        String timeStr;
        long day = 1000 * 60 * 60 * 24; //一天的毫秒数
        long mRemainDay = 0;
        long mRemainHour = 0;
        long mRemainMinute = 0;
        long mRemainSeconds = 0;

        if (endtime < curtime) {
            timeStr = "已过期";
            return timeStr;
        }

        if (endtime - curtime > day) {
            mRemainDay = (endtime - curtime) / day;
        }

        long tmpTime = endtime - curtime - mRemainDay * 24 * 60 * 60 * 1000;
        if (tmpTime < day) {
            mRemainHour = tmpTime / (60 * 60 * 1000);
            mRemainMinute = (tmpTime - mRemainHour * 60 * 60 * 1000) / (60 * 1000);
            mRemainSeconds = (tmpTime - mRemainHour * 60 * 60 * 1000 - mRemainMinute * 60 * 1000) / 1000;
        }

        if (mRemainDay > 0) {
            timeStr = "剩余" + mRemainDay + "天" + mRemainHour + "小时" + mRemainMinute + "分" + mRemainSeconds + "秒";
        } else {
            timeStr = "剩余" + mRemainHour + "小时" + mRemainMinute + "分" + mRemainSeconds + "秒";
        }
        return timeStr;
    }

    /**
     * 29分26秒
     */
    public static String getRemainMinuteSecondByLong(long endtime, long curtime) {
        String timeStr;
        long day = 1000 * 60 * 60 * 24; //一天的毫秒数
        long mRemainDay = 0;
        long mRemainHour = 0;
        long mRemainMinute = 0;
        long mRemainSeconds = 0;

        if (endtime < curtime) {
            timeStr = "已过期";
            return timeStr;
        }

        if (endtime - curtime > day) {
            mRemainDay = (endtime - curtime) / day;
        }

        long tmpTime = endtime - curtime - mRemainDay * 24 * 60 * 60 * 1000;
        if (tmpTime < day) {
            mRemainHour = tmpTime / (60 * 60 * 1000);
            mRemainMinute = (tmpTime - mRemainHour * 60 * 60 * 1000) / (60 * 1000);
            mRemainSeconds = (tmpTime - mRemainHour * 60 * 60 * 1000 - mRemainMinute * 60 * 1000) / 1000;
        }

        if (mRemainMinute > 0) {
            timeStr = "剩余" + mRemainMinute + "分" + mRemainSeconds + "秒";
        } else {
            timeStr = "剩余" + 0 + "分" + mRemainSeconds + "秒";
        }
        return timeStr;
    }


    public static String getDetaiTimeStrByLong(long createTime, long curTime) {
        String timeStr;
        long day = 60 * 60 * 24; //一天的秒数
        long mRemainDay = 0;
        long mRemainHour = 0;
        long mRemainMinute = 0;

        if (createTime > curTime) {
            return "";
        }

        mRemainDay = (curTime - createTime) / day;
        if (mRemainDay >= 7) {
            timeStr = getDateForMinuteSecondByLong(createTime * 1000);
        } else if (mRemainDay >= 1 && mRemainDay < 7) {
            timeStr = mRemainDay + "天前";
        } else {
            long tmpTime = curTime - createTime;
            mRemainHour = tmpTime / (60 * 60);
            if (mRemainHour >= 1 && mRemainHour <= 23) {
                timeStr = mRemainHour + "小时前";
            } else {
                mRemainMinute = tmpTime / (60);
                /**如果时间是0分钟则改为刚刚 2016 11 16按测试反馈修改*/
                if (mRemainMinute == 0) {
                    timeStr = "刚刚";
                } else {
                    timeStr = mRemainMinute + "分钟前";
                }

            }
        }
        return timeStr;
    }





}
