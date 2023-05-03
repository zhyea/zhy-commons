package org.chobit.commons.enums;

import org.chobit.commons.contract.CodeDescEnum;

/**
 * 通用接口状态码
 *
 * @author robin
 */
public enum CommonStatusCode implements CodeDescEnum {

    SUCCESS(0, "成功"),

    ;

    public final int code;

    public final String desc;

    CommonStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String getDesc() {
        return this.desc;
    }
}
