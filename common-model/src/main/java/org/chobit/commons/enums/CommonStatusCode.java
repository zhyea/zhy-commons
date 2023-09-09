package org.chobit.commons.enums;

import org.chobit.commons.contract.CodeDescEnum;

/**
 * 通用接口状态码
 *
 * @author robin
 */
public enum CommonStatusCode implements CodeDescEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    FAIL(10000, "失败"),

    ;

    public final int code;

    public final String desc;


    CommonStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public int getCode() {
        return this.code;
    }


    @Override
    public String getDesc() {
        return this.desc;
    }
}
