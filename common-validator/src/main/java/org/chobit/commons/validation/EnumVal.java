package org.chobit.commons.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import org.chobit.commons.contract.CodeEnum;

import java.lang.annotation.*;

/**
 * 枚举值验证注解
 *
 * @author robin
 */
@Documented
@Constraint(
		validatedBy = {EnumValValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumVal {


	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};

	/**
	 * 枚举类型
	 *
	 * @return 枚举类类型
	 */
	Class<? extends Enum<? extends CodeEnum>> enumClass();


	/**
	 * 可排除的枚举值
	 *
	 * @return 可排除的枚举值
	 */
	int[] exclude() default {};


	/**
	 * 提示消息
	 *
	 * @return 提示消息
	 */
	String message() default "非法的枚举值";
}
