package org.chobit.commons.json;

import org.chobit.commons.contract.CodeDescEnum;

public enum Gender implements CodeDescEnum {

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女"),
    ;

    public final int code;

    public final String desc;

    Gender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
