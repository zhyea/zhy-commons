package org.chobit.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.chobit.commons.utils.LocalDateKit.COMMON_DATETIME_PATTERN;
import static org.chobit.commons.utils.LocalDateKit.COMMON_DATE_PATTERN;

/**
 * 日期工具类
 *
 * @author robin
 */
public final class DateKit {


    /**
     * 格式化日期对象
     *
     * @param date    日期对象
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }


    /**
     * 格式化日期对象，默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期对象
     * @return 格式化后的日期字符串
     */
    public static String format(Date date) {
        return format(date, COMMON_DATETIME_PATTERN);
    }


    /**
     * 格式化日期对象，默认格式：yyyy-MM-dd
     *
     * @param date 日期对象
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date date) {
        return format(date, COMMON_DATE_PATTERN);
    }


    private DateKit() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
