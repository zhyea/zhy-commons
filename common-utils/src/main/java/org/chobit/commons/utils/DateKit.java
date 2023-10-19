package org.chobit.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.chobit.commons.constans.CommonConstants.COMMON_DATETIME_PATTERN;
import static org.chobit.commons.constans.CommonConstants.COMMON_DATE_PATTERN;


/**
 * 日期工具类
 *
 * @author robin
 */
public final class DateKit {


    private static final Logger logger = LoggerFactory.getLogger(DateKit.class);

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


    /**
     * 解析日期时间字符串
     *
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return 日期对象
     */
    public static Date parse(String dateStr, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            logger.error("Parse date string error, source:{}, pattern:{}, e", dateStr, pattern);
            return null;
        }
    }


    /**
     * 解析日期时间字符串，默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr 日期字符串
     * @return 日期对象
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, COMMON_DATETIME_PATTERN);
    }


    /**
     * 解析日期字符串，默认格式：yyyy-MM-dd
     *
     * @param dateStr 日期字符串
     * @return 日期对象
     */
    public static Date parseDate(String dateStr) {
        return parse(dateStr, COMMON_DATE_PATTERN);
    }


    private DateKit() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
