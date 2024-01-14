package com.example.centemanagerdemo.utils;

/**
 * @author: njb
 * @date: 2023/2/6 16:45
 * @desc:
 */
public class TimeUtils {

    public static String formatVideoTime(int timeValue) {
        String time = "00:00";
        if (timeValue == 0) {
            return time;
        }
        int hour = 0;
        int minute = 0;
        int second;
        if (timeValue >= 3600) {
            hour = timeValue / 3600;
        }
        if (timeValue >= 60) {
            minute = timeValue / 60;
            minute = minute % 60;
        }
        second = timeValue % 60;

        String minuteStr = getTimeValue(minute) + ":";
        String secondStr = getTimeValue(second);
        return minuteStr + secondStr;
    }

    /**
     * 格式化 时间数字
     */
    public static String getTimeValue(int value) {
        String num = "";
        if (value == 0) {
            num = "00";
        } else if (value < 10) {
            num = "0" + value;
        } else {
            num = value + "";
        }
        return num;
    }
}
