package org.chobit.commons.constans;

/**
 * 通用常量
 *
 * @author robin
 */
public final class CommonConstants {


    /**
     * 默认日期格式
     */
    public static final String COMMON_DATE_PATTERN = "yyyy-MM-dd";


    /**
     * 默认日期时间格式
     */
    public static final String COMMON_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    /**
     * 北京时区标记
     */
    public static final String BEIJING_TIMEZONE_FLAG = "UTC+8";


    private CommonConstants() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
