package org.chobit.commons.json;

import org.chobit.commons.utils.JsonKit;
import org.junit.jupiter.api.Test;

public class JsonKitTest {


    @Test
    public void codeDesc() {
        Person p = new Person();
        p.setGender(Gender.MALE);
        p.setAge(12);

        String json = JsonKit.toJson(p);
        System.out.println(json);
    }

}
