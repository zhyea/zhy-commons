package org.chobit.commons.utils;

import static org.chobit.commons.constans.Symbol.EMPTY;
import static org.chobit.commons.constans.Symbol.STAR;
import static org.chobit.commons.utils.StrKit.isBlank;

/**
 * 脱敏处理工具类
 *
 * @author rui.zhang
 */
public final class DesensitizeTool {


    /**
     * 执行脱敏
     *
     * @param source 源字符串
     * @param len    要脱敏的长度，正数从头部脱敏，负数从尾部脱敏
     * @return 脱敏结果
     */
    public static String desensitize(String source, int len) {
        return desensitize(source, len, STAR);
    }


    /**
     * 执行脱敏
     *
     * @param source      源字符串
     * @param len         要脱敏的长度，正数从头部脱敏，负数从尾部脱敏
     * @param replacement 脱敏替换符
     * @return 脱敏结果
     */
    public static String desensitize(String source, int len, String replacement) {
        if (isBlank(source)) {
            return EMPTY;
        }

        if (Math.abs(len) == 0) {
            return source;
        }

        if (source.length() < Math.abs(len)) {
            return source;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.abs(len); i++) {
            builder.append(replacement);
        }


        if (len > 0) {
            return builder.append(source.substring(len)).toString();
        } else {
            return source.substring(0, source.length() + len) + builder;
        }
    }


    /**
     * 执行脱敏
     *
     * @param source    源字符串
     * @param prefixLen 前置保留长度
     * @param affixLen  后置保留长度
     * @return 脱敏结果
     */
    public static String desensitize(String source, int prefixLen, int affixLen) {
        return desensitize(source, prefixLen, affixLen, STAR);
    }


    /**
     * 执行脱敏
     *
     * @param source      源字符串
     * @param prefixLen   前置保留长度
     * @param affixLen    后置保留长度
     * @param replacement 替换符
     * @return 脱敏结果
     */
    public static String desensitize(String source, int prefixLen, int affixLen, String replacement) {
        if (isBlank(source)) {
            return EMPTY;
        }

        if (prefixLen < 0 || affixLen < 0) {
            return source;
        }

        int desensitizeLen = source.length() - (prefixLen + affixLen);

        if (desensitizeLen <= 0) {
            return source;
        }

        String preStr = EMPTY, affStr = EMPTY;

        if (prefixLen > 0) {
            preStr = source.substring(0, prefixLen);
        }
        if (affixLen > 0) {
            affStr = source.substring(source.length() - affixLen);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(preStr);
        for (int i = 0; i < desensitizeLen; i++) {
            builder.append(replacement);
        }
        builder.append(affStr);

        return builder.toString();
    }


    private DesensitizeTool() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }

}
