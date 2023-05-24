package org.chobit.commons.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateKitTest {


    @Test
    public void format() {
        Date date = new Date(1684897070000L);
        String s = DateKit.format(date);
        Assertions.assertEquals("2023-05-24 10:57:50", s);
    }


    @Test
    public void parse() {
        String s = "2023-05-24 10:57:50";
        Date d = DateKit.parse(s);
        Assertions.assertEquals(new Date(1684897070000L), d);
    }


    @Test
    public void formatDate() {
        Date date = new Date(1684897070000L);
        String s = DateKit.formatDate(date);
        Assertions.assertEquals("2023-05-24", s);
    }


    @Test
    public void parseDate() {
        String s = "2023-05-24";
        Date d = DateKit.parseDate(s);
        System.out.println(d.getTime());
        Assertions.assertEquals(new Date(1684857600000L), d);
    }
}
