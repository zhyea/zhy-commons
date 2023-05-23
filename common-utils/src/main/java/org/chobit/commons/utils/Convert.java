package org.chobit.commons.utils;

/**
 * 通用转换处理工具
 *
 * @author robin
 */
public final class Convert {


    /**
     * 将数值字符串转为整型数值
     *
     * @param s 数值字符串
     * @return 整型数值
     */
    public static int toInt(final String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }


    /**
     * 将数值字符串转为长整型数值
     *
     * @param s 数值字符串
     * @return 长整型数值
     */
    public static long toLong(String s) {
        try {
            return Long.parseLong(s.trim());
        } catch (Exception e) {
            return 0L;
        }
    }


    /**
     * 将数值字符串转为浮点型数值
     *
     * @param s 数值字符串
     * @return 浮点型数值
     */
    public static double toDouble(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }


    /**
     * 将数值字符串转为布尔型数值
     *
     * @param s 布尔值字符串
     * @return 布尔型数值
     */
    public static boolean toBool(String s) {
        try {
            return Boolean.parseBoolean(s.trim());
        } catch (Exception e) {
            return false;
        }
    }


    private Convert() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
