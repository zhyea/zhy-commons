package org.chobit.commons.enums;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * 全球标准 UTC 时区枚举，包含缩写与地理描述
 */
public enum UtcTimeZone {

    /**
     * UTC-12:00 (IDLW) - 国际换日线西
     * 支持国家：无常驻人口（仅贝克岛、豪兰岛）
     */
    UTC_M12_00("UTC-12:00", "IDLW", "国际换日线西", -12, 0, -43200),

    /**
     * UTC-11:00 (NT) - 萨摩亚标准时间（无夏令时）
     * 支持国家：美属萨摩亚、新西兰的彭林群岛
     */
    UTC_M11_00("UTC-11:00", "NT", "萨摩亚标准时间（无夏令时）", -11, 0, -39600),

    /**
     * UTC-10:00 (HAST) - 夏威夷-阿留申标准时间
     * 支持国家：美国（夏威夷）、阿拉斯加部分地区
     */
    UTC_M10_00("UTC-10:00", "HAST", "夏威夷-阿留申标准时间", -10, 0, -36000),

    /**
     * UTC-09:30 (MIT) - 马贵斯群岛时间
     * 支持国家：法属波利尼西亚马贵斯群岛
     */
    UTC_M09_30("UTC-09:30", "MIT", "马贵斯群岛时间", -9, -30, -34200),

    /**
     * UTC-09:00 (AKST) - 阿拉斯加标准时间
     * 支持国家：美国（阿拉斯加部分地区）
     */
    UTC_M09_00("UTC-09:00", "AKST", "阿拉斯加标准时间", -9, 0, -32400),

    /**
     * UTC-08:00 (PST) - 太平洋标准时间
     * 支持国家：加拿大、美国（如加州、华盛顿州）、墨西哥（下加利福尼亚）
     */
    UTC_M08_00("UTC-08:00", "PST", "太平洋标准时间", -8, 0, -28800),

    /**
     * UTC-07:00 (MST) - 山地标准时间
     * 支持国家：加拿大、美国（如科罗拉多州、亚利桑那州）、墨西哥北部
     */
    UTC_M07_00("UTC-07:00", "MST", "山地标准时间", -7, 0, -25200),

    /**
     * UTC-06:00 (CST) - 中部标准时间
     * 支持国家：加拿大、美国（如伊利诺伊州、德克萨斯州）、中美洲、墨西哥大部分地区
     */
    UTC_M06_00("UTC-06:00", "CST", "中部标准时间", -6, 0, -21600),

    /**
     * UTC-05:00 (EST) - 东部标准时间
     * 支持国家：加拿大、美国（如纽约州、佛罗里达州）、巴拿马、哥伦比亚
     */
    UTC_M05_00("UTC-05:00", "EST", "东部标准时间", -5, 0, -18000),

    /**
     * UTC-04:00 (AST) - 大西洋标准时间
     * 支持国家：加拿大（大西洋省份）、加勒比海地区（如波多黎各、维尔京群岛）
     */
    UTC_M04_00("UTC-04:00", "AST", "大西洋标准时间", -4, 0, -14400),

    /**
     * UTC-03:30 (NST) - 纽芬兰标准时间
     * 支持国家：加拿大（纽芬兰与拉布拉多省部分地区）
     */
    UTC_M03_30("UTC-03:30", "NST", "纽芬兰标准时间", -3, -30, -12600),

    /**
     * UTC-03:00 (BRT) - 巴西东部时间
     * 支持国家：巴西（东部沿海地区）、阿根廷、格陵兰南部
     */
    UTC_M03_00("UTC-03:00", "BRT", "巴西东部时间", -3, 0, -10800),

    /**
     * UTC-02:00 (FNT) - 大西洋中部时间
     * 支持国家：巴西（费尔南多·迪诺罗尼亚）、南乔治亚和南桑威奇群岛
     */
    UTC_M02_00("UTC-02:00", "FNT", "大西洋中部时间", -2, 0, -7200),

    /**
     * UTC-01:00 (AZOT) - 亚速尔群岛标准时间
     * 支持国家：葡萄牙（亚速尔群岛）、佛得角、格陵兰西部
     */
    UTC_M01_00("UTC-01:00", "AZOT", "亚速尔群岛标准时间", -1, 0, -3600),

    /**
     * UTC±00:00 (GMT/UTC) - 格林尼治标准时间
     * 支持国家：英国（冬季）、爱尔兰（冬季）、冰岛、加纳、塞内加尔
     */
    UTC_00_00("UTC+00:00", "GMT/UTC", "格林尼治标准时间", 0, 0, 0),

    /**
     * UTC+01:00 (CET) - 中欧时间
     * 支持国家：德国、法国、西班牙、意大利、波兰、瑞典等欧洲国家（冬季）
     */
    UTC_P01_00("UTC+01:00", "CET", "中欧时间", 1, 0, 3600),

    /**
     * UTC+02:00 (EET) - 东欧时间
     * 支持国家：俄罗斯（莫斯科）、土耳其、希腊、埃及、南非、乌克兰
     */
    UTC_P02_00("UTC+02:00", "EET", "东欧时间", 2, 0, 7200),

    /**
     * UTC+03:00 (MSK) - 莫斯科标准时间
     * 支持国家：俄罗斯（莫斯科及西部）、伊拉克、沙特阿拉伯、肯尼亚
     */
    UTC_P03_00("UTC+03:00", "MSK", "莫斯科标准时间", 3, 0, 10800),

    /**
     * UTC+03:30 (IRST) - 伊朗标准时间
     * 支持国家：伊朗（全年使用 IRST）
     */
    UTC_P03_30("UTC+03:30", "IRST", "伊朗标准时间", 3, 30, 12600),

    /**
     * UTC+04:00 (AZT) - 阿塞拜疆时间
     * 支持国家：阿塞拜疆、格鲁吉亚、亚美尼亚、阿曼、阿联酋
     */
    UTC_P04_00("UTC+04:00", "AZT", "阿塞拜疆时间", 4, 0, 14400),

    /**
     * UTC+04:30 (AFT) - 阿富汗标准时间
     * 支持国家：阿富汗（全年使用 AFT）
     */
    UTC_P04_30("UTC+04:30", "AFT", "阿富汗标准时间", 4, 30, 16200),

    /**
     * UTC+05:00 (PKT) - 巴基斯坦标准时间
     * 支持国家：巴基斯坦、马尔代夫、哈萨克斯坦（西部）
     */
    UTC_P05_00("UTC+05:00", "PKT", "巴基斯坦标准时间", 5, 0, 18000),

    /**
     * UTC+05:30 (IST) - 印度标准时间
     * 支持国家：印度、斯里兰卡
     */
    UTC_P05_30("UTC+05:30", "IST", "印度标准时间", 5, 30, 19800),

    /**
     * UTC+05:45 (NPT) - 尼泊尔标准时间
     * 支持国家：尼泊尔（全年使用 NPT）
     */
    UTC_P05_45("UTC+05:45", "NPT", "尼泊尔标准时间", 5, 45, 20700),

    /**
     * UTC+06:00 (BDT) - 孟加拉国时间
     * 支持国家：孟加拉国、不丹、哈萨克斯坦（东部）
     */
    UTC_P06_00("UTC+06:00", "BDT", "孟加拉国时间", 6, 0, 21600),

    /**
     * UTC+06:30 (MMT) - 缅甸标准时间
     * 支持国家：缅甸、印度科科群岛
     */
    UTC_P06_30("UTC+06:30", "MMT", "缅甸标准时间", 6, 30, 23400),

    /**
     * UTC+07:00 (ICT) - 印度支那时间
     * 支持国家：泰国、越南、柬埔寨、老挝、印尼西部（如雅加达）
     */
    UTC_P07_00("UTC+07:00", "ICT", "印度支那时间", 7, 0, 25200),

    /**
     * UTC+08:00 (CST) - 中国标准时间
     * 支持国家：中国、新加坡、马来西亚、菲律宾、印尼西部、澳大利亚西部
     */
    UTC_P08_00("UTC+08:00", "CST", "中国标准时间", 8, 0, 28800),

    /**
     * UTC+08:45 (CWST) - 澳大利亚中西部标准时间
     * 支持国家：澳大利亚中西部地区（非官方，部分使用）
     */
    UTC_P08_45("UTC+08:45", "CWST", "澳大利亚中西部标准时间", 8, 45, 31500),

    /**
     * UTC+09:00 (JST) - 日本标准时间
     * 支持国家：日本、朝鲜、韩国、印尼东部（如查亚普拉）
     */
    UTC_P09_00("UTC+09:00", "JST", "日本标准时间", 9, 0, 32400),

    /**
     * UTC+09:30 (ACST) - 澳大利亚中部标准时间
     * 支持国家：澳大利亚中部地区（如阿德莱德）
     */
    UTC_P09_30("UTC+09:30", "ACST", "澳大利亚中部标准时间", 9, 30, 34200),

    /**
     * UTC+10:00 (AEST) - 澳大利亚东部标准时间
     * 支持国家：澳大利亚东部、巴布亚新几内亚
     */
    UTC_P10_00("UTC+10:00", "AEST", "澳大利亚东部标准时间", 10, 0, 36000),

    /**
     * UTC+10:30 (ACDT) - 澳大利亚中部夏令时
     * 支持国家：澳大利亚中部地区（夏季使用）
     */
    UTC_P10_30("UTC+10:30", "ACDT", "澳大利亚中部夏令时", 10, 30, 37800),

    /**
     * UTC+11:00 (SBT) - 所罗门群岛时间
     * 支持国家：所罗门群岛、瓦努阿图、新喀里多尼亚
     */
    UTC_P11_00("UTC+11:00", "SBT", "所罗门群岛时间", 11, 0, 39600),

    /**
     * UTC+12:00 (NZST) - 新西兰标准时间
     * 支持国家：新西兰、斐济、图瓦卢、基里巴斯（部分）
     */
    UTC_P12_00("UTC+12:00", "NZST", "新西兰标准时间", 12, 0, 43200),

    /**
     * UTC+13:00 (PHST) - 菲律宾夏令时（历史使用）
     * 支持国家：菲律宾（历史上使用 PHST）
     */
    UTC_P13_00("UTC+13:00", "PHST", "菲律宾夏令时", 13, 0, 46800),

    /**
     * UTC+14:00 (+14) - 基里巴斯时间
     * 支持国家：基里巴斯（线岛群岛），全球最早迎接新一天的地方
     */
    UTC_P14_00("UTC+14:00", "+14", "基里巴斯时间", 14, 0, 50400);

    private final String displayName;
    private final String abbreviation;
    private final String description;
    private final int hours;
    private final int minutes;
    private final long totalSeconds;
    private final ZoneId zoneId;

    UtcTimeZone(String displayName, String abbreviation, String description,
                int hours, int minutes, long totalSeconds) {
        this.displayName = displayName;
        this.abbreviation = abbreviation;
        this.description = description;
        this.hours = hours;
        this.minutes = minutes;
        this.totalSeconds = totalSeconds;
        this.zoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutes(hours, minutes));
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public long getTotalSeconds() {
        return totalSeconds;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public static UtcTimeZone fromTotalSeconds(int seconds) {
        for (UtcTimeZone tz : values()) {
            if (tz.totalSeconds == seconds) {
                return tz;
            }
        }
        throw new IllegalArgumentException("未找到匹配的 UTC 时区：" + seconds);
    }

    public static Map<String, UtcTimeZone> toMap() {
        Map<String, UtcTimeZone> map = new HashMap<>();
        for (UtcTimeZone tz : values()) {
            map.put(tz.getDisplayName(), tz);
            map.put(tz.getAbbreviation(), tz);
        }
        return map;
    }


    /**
     * 根据秒级偏移量找到最接近的 UTC 时区枚举值
     *
     * @param offsetInSeconds 秒级偏移量（例如：19800 表示 UTC+05:30）
     * @return 最接近的 UtcTimeZone 枚举
     */
    public static UtcTimeZone findClosest(long offsetInSeconds) {
        UtcTimeZone closest = null;
        long minDiff = Integer.MAX_VALUE;

        for (UtcTimeZone tz : values()) {
            long diff = Math.abs(tz.totalSeconds - offsetInSeconds);
            if (diff < minDiff) {
                minDiff = diff;
                closest = tz;
            }
        }

        return closest;
    }


    @Override
    public String toString() {
        return String.format("%s (%s): %s", displayName, abbreviation, description);
    }
}
