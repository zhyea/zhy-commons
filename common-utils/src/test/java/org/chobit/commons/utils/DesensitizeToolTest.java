package org.chobit.commons.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DesensitizeToolTest {


    @Test
    public void desensitize() {

        String src = "123456789";
        String phone = DesensitizeTool.desensitize(src, 3, 3);
        Assertions.assertEquals("123***789", phone);

        String name = DesensitizeTool.desensitize(src, 1, 0);
        Assertions.assertEquals("1********", name);

        String fail = DesensitizeTool.desensitize(src, 6, 6);
        Assertions.assertEquals("123456789", fail);
    }


    @Test
    public void desensitizeHead() {
        String src = "12345";
        String result = "";

        result = DesensitizeTool.desensitize(src, 1);
        Assertions.assertEquals("*2345", result);

        result = DesensitizeTool.desensitize(src, 5);
        Assertions.assertEquals("*****", result);

        result = DesensitizeTool.desensitize(src, 4);
        Assertions.assertEquals("****5", result);

        result = DesensitizeTool.desensitize(src, 0);
        Assertions.assertEquals("12345", result);

        result = DesensitizeTool.desensitize(src, 6);
        Assertions.assertEquals("12345", result);
    }


    @Test
    public void desensitizeTail() {
        String src = "12345";
        String result = "";

        result = DesensitizeTool.desensitize(src, -1);
        Assertions.assertEquals("1234*", result);

        result = DesensitizeTool.desensitize(src, -5);
        Assertions.assertEquals("*****", result);

        result = DesensitizeTool.desensitize(src, -4);
        Assertions.assertEquals("1****", result);

        result = DesensitizeTool.desensitize(src, 0);
        Assertions.assertEquals("12345", result);

        result = DesensitizeTool.desensitize(src, -6);
        Assertions.assertEquals("12345", result);
    }


}
