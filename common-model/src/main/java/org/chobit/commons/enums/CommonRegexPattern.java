package org.chobit.commons.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用正则表达式
 *
 * @author robin
 */
public enum CommonRegexPattern {

    /**
     * 邮箱地址
     */
    EMAIL("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"),

    /**
     * URL地址
     */
    URL("(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\&%\\+\\$#_=]*)?"),

    /**
     * 手机号
     */
    PHONE("^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$"),

    /**
     * 身份证号
     */
    ID_CARD("^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$"),

    /**
     * 日期
     */
    DATE("^\\d{4}-\\d{2}-\\d{2}$"),

    /**
     * 邮编
     */
    ZIP_CODE("^[0-9]\\d{5}(?!\\d)$"),

    /**
     * 中英文姓名
     */
    NAME_CN_EN("^[ \\w\\-\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A]+$"),


    /**
     * 通用中文标点
     * <p>
     * 匹配这些中文标点符号: 。 ？ ！ ， 、 ； ： “ ” ‘ ' （ ） 《 》 〈 〉 【 】 『 』 「 」 ﹃ ﹄ 〔 〕 … — ～ ﹏ ￥
     */
    COMMON_CHINESE_PUNCTUATION("^[\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5]+$"),


    /**
     * 中文文书标题通用字符
     * <p>
     * 包括：中文、中文字符、英文、数字
     */
    COMMON_CHINESE_DOC_TITLE("^[\\w\\d\\-\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5]+$"),



    /**
     * emoji表情
     */
    EMOJI("(?:[\uD83C\uDF00-\uD83D\uDDFF]|[\uD83E\uDD00-\uD83E\uDDFF]|[\uD83D\uDE00-\uD83D\uDE4F]|[\uD83D\uDE80-\uD83D\uDEFF]|[\u2600-\u26FF]\uFE0F?|[\u2700-\u27BF]\uFE0F?|\u24C2\uFE0F?|[\uD83C\uDDE6-\uD83C\uDDFF]{1,2}|[\uD83C\uDD70\uD83C\uDD71\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD8E\uD83C\uDD91-\uD83C\uDD9A]\uFE0F?|[\u0023\u002A\u0030-\u0039]\uFE0F?\u20E3|[\u2194-\u2199\u21A9-\u21AA]\uFE0F?|[\u2B05-\u2B07\u2B1B\u2B1C\u2B50\u2B55]\uFE0F?|[\u2934\u2935]\uFE0F?|[\u3030\u303D]\uFE0F?|[\u3297\u3299]\uFE0F?|[\uD83C\uDE01\uD83C\uDE02\uD83C\uDE1A\uD83C\uDE2F\uD83C\uDE32-\uD83C\uDE3A\uD83C\uDE50\uD83C\uDE51]\uFE0F?|[\u203C\u2049]\uFE0F?|[\u25AA\u25AB\u25B6\u25C0\u25FB-\u25FE]\uFE0F?|[\u00A9\u00AE]\uFE0F?|[\u2122\u2139]\uFE0F?|\uD83C\uDC04\uFE0F?|\uD83C\uDCCF\uFE0F?|[\u231A\u231B\u2328\u23CF\u23E9-\u23F3\u23F8-\u23FA]\uFE0F?)+"),

    ;


    public final String regex;

    public final Pattern pattern;

    CommonRegexPattern(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }


    /**
     * 校验字符串是否与正则表达式匹配
     *
     * @param str 字符串
     * @return true 匹配
     */
    public boolean matches(String str) {
        Matcher m = pattern.matcher(str);
        return m.matches();
    }


}
