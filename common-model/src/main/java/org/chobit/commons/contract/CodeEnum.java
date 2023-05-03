package org.chobit.commons.contract;

/**
 * 枚举接口
 * <p>
 * 接口需要返回Code时可继承此类
 *
 * @author robin
 */
public interface CodeEnum {


    /**
     * 返回code值
     *
     * @return code值
     */
    Integer getCode();


    /**
     * 判断提供的值是否与枚举值code匹配
     *
     * @param code code值
     * @return true 匹配， false 不匹配
     */
    default boolean is(Integer code) {
        if (null == code) {
            return false;
        }
        return this.getCode().equals(code);
    }

    /**
     * 判断提供的值是否与枚举值code不一致
     *
     * @param code code值
     * @return true 不一致， false 一致
     */
    default boolean isNot(Integer code) {
        return !this.is(code);
    }


}
