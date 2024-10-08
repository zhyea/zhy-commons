package org.chobit.commons.utils;

import org.junit.jupiter.api.Test;

public class StrKitTest {


    @Test
    public void join(){
        String str = StrKit.join("1", "2", "3");
        System.out.println(str);
    }


}
