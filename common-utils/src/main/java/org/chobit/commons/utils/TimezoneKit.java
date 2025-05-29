package org.chobit.commons.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TimezoneKit {


    // 支持 ±HH:mm:ss、±HH:mm、±HHmmss、±HHmm、±HH
    private static final Pattern CUSTOM_OFFSET_PATTERN = Pattern.compile("([+-]?)(\\d{2})(?::?(\\d{2}))?(?::?(\\d{2}))?$");

    // 支持 GMT+08:00、UTC-05:30:00 等格式
    private static final Pattern GMT_UTC_OFFSET_PATTERN = Pattern.compile(
            "(?i)(GMT|UTC)?([+-])(\\d{1,2})(?::(\\d{1,2})(?::(\\d{1,2}))?)?");

    /**
     * 解析时区字符串，转换为总秒数
     *
     * @param tz 时区字符串，例如 "+00:10:39"、"+0800"、"Z"、"GMT+8"、"UTC-5"、"GMT+08:00:00"
     * @return 对应的时区偏移量（秒）
     */
    public static int parseTimeZoneOffset(String tz) {
        if (tz == null || tz.isEmpty()) {
            throw new IllegalArgumentException("时区字符串不能为空");
        }

        // 处理特殊格式 "Z"
        if ("Z".equalsIgnoreCase(tz)) {
            return 0;
        }

        // 尝试标准 ZoneId 解析
        try {
            ZoneId zone = ZoneId.of(tz);
            if (zone instanceof ZoneOffset) {
                return ((ZoneOffset) zone).getTotalSeconds();
            } else {
                return zone.getRules().getOffset(Instant.now()).getTotalSeconds();
            }
        } catch (Exception e) {
            // Logger.warn("Standard parsing failed", e);
        }

        // 自定义格式解析
        Matcher matcher = CUSTOM_OFFSET_PATTERN.matcher(tz);
        if (matcher.matches()) {
            String signStr = matcher.group(1);
            int hours = Integer.parseInt(matcher.group(2));
            int minutes = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 0;
            int seconds = matcher.group(4) != null ? Integer.parseInt(matcher.group(4)) : 0;

            if (hours > 18 || minutes >= 60 || seconds >= 60) {
                throw new IllegalArgumentException("时区偏移量超出合理范围: " + tz);
            }

            int totalSeconds = hours * 3600 + minutes * 60 + seconds;
            return "-".equals(signStr) ? -totalSeconds : totalSeconds;
        }

        // GMT/UTC 带秒格式解析
        Matcher gmtMatcher = GMT_UTC_OFFSET_PATTERN.matcher(tz);
        if (gmtMatcher.matches()) {
            int hours = Integer.parseInt(gmtMatcher.group(3));
            int minutes = gmtMatcher.group(4) != null ? Integer.parseInt(gmtMatcher.group(4)) : 0;
            int seconds = gmtMatcher.group(5) != null ? Integer.parseInt(gmtMatcher.group(5)) : 0;

            if (minutes >= 60 || seconds >= 60) {
                throw new IllegalArgumentException("时区偏移量中的分钟或秒超出范围: " + tz);
            }

            int totalSeconds = hours * 3600 + minutes * 60 + seconds;
            return gmtMatcher.group(2).equals("-") ? -totalSeconds : totalSeconds;
        }

        throw new IllegalArgumentException("Unsupported timezone: " + tz);
    }


    private TimezoneKit() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
