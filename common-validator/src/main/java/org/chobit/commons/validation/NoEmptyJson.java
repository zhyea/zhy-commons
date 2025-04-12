package org.chobit.commons.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 枚举值验证注解
 *
 * @author robin
 */
@Documented
@Constraint(
		validatedBy = {NoEmptyJsonValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoEmptyJson {


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};


	/**
	 * 提示消息
	 *
	 * @return 提示消息
	 */
	String message() default "空json字符串";
}
