package org.chobit.commons.validation;


import org.chobit.commons.contract.CodeEnum;
import org.chobit.commons.utils.EnumKit;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 枚举值验证
 *
 * @author robin
 */
public class EnumValValidator implements ConstraintValidator<EnumVal, Integer> {


	/**
	 * 枚举类型
	 */
	private Class<? extends Enum<? extends CodeEnum>> enumClass;

	/**
	 * 已排除的枚举code值
	 */
	private int[] excludeCodes;


	@Override
	public void initialize(EnumVal enumVal) {
		this.enumClass = enumVal.enumClass();
		if (!CodeEnum.class.isAssignableFrom(this.enumClass)) {
			throw new IllegalArgumentException(this.enumClass + "不是继承自BaseEnum");
		}
		this.excludeCodes = enumVal.exclude();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (null == value) {
			return true;
		}

		if (null != excludeCodes) {
			for (int code : excludeCodes) {
				if (code == value) {
					return false;
				}
			}
		}

		CodeEnum e = EnumKit.enumOf(value, this.enumClass);

		return null != e;
	}
}
