package org.chobit.commons.json.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.chobit.commons.json.CodeDescEnumSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对实现CodeDescEnum的注解进行序列化
 *
 * @author robin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = CodeDescEnumSerializer.class)
public @interface CodeDescSerialize {


    /**
     * 展示code值
     *
     * @return 是否展示code值
     */
    boolean showCode() default false;


    /**
     * 展示描述信息
     *
     * @return 是否展示描述信息
     */
    boolean showDesc() default false;

}
