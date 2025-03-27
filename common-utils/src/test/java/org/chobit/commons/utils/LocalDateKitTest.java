package org.chobit.commons.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangrui
 * @since 2025/3/27
 */
public class LocalDateKitTest {



    @Test
    public void parse(){
        LocalDateTime time = LocalDateKit.parseTime("2025-03-27T07:43:32.951Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println(time.atZone(ZoneId.of("+08:00")));
        LocalDateTime time1 = LocalDateKit.parseTime("2025-03-27T07:43:32.951+05:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println(time1.atZone(ZoneId.of("+08:00")));
        LocalDateTime time2 = LocalDateKit.parseTime("2025-03-27T07:43:32.951", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(time2.atZone(ZoneId.of("+08:00")));
        LocalDateTime time3 = LocalDateKit.parseTime("2025-03-27T07:43:32", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(time3.atZone(ZoneId.of("+08:00")));
    }
}
