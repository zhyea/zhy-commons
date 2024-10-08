package org.chobit.commons.utils;

/**
 * 数组操作工具
 *
 * @author robin
 */
public final class Arrays {


    /**
     * 判断元素在数组中是否存在
     *
     * @param arr   数组
     * @param value 元素
     * @return true 存在, false 不存在
     */
    public static boolean contains(int[] arr, int value) {
        for (int v : arr) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断元素在数组中是否存在
     *
     * @param arr   数组
     * @param value 元素
     * @return true 存在, false 不存在
     */
    public static boolean contains(short[] arr, short value) {
        for (short v : arr) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断元素在数组中是否存在
     *
     * @param arr   数组
     * @param value 元素
     * @return true 存在, false 不存在
     */
    public static boolean contains(long[] arr, long value) {
        for (long v : arr) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }





    private Arrays() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }

}
