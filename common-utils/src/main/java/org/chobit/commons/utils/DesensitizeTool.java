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
     * @param preLen 前置保留长度
     * @param affLen 后置保留长度
     * @return 脱敏结果
     */
    public static String desensitize(String source, int preLen, int affLen) {
        return desensitize(source, preLen, affLen, STAR.charAt(0));
    }


    /**
     * 执行脱敏
     *
     * @param source      源字符串
     * @param preLen      前置保留长度
     * @param affLen      后置保留长度
     * @param replacement 替换符
     * @return 脱敏结果
     */
    public static String desensitize(String source, int preLen, int affLen, char replacement) {
        if (isBlank(source)) {
            return EMPTY;
        }

        if (preLen < 0 || affLen < 0) {
            return source;
        }

        int desensitizeLen = source.length() - (preLen + affLen);

        if (desensitizeLen <= 0) {
            return source;
        }

        String preStr = EMPTY, affStr = EMPTY;

        if (preLen > 0) {
            preStr = source.substring(0, preLen - 1);
        }
        if (affLen > 0) {
            affStr = source.substring(source.length() - affLen);
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
