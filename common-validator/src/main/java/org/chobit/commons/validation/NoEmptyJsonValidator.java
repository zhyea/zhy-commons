package org.chobit.commons.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.chobit.commons.utils.StrKit.isBlank;

/**
 * 非空json验证
 * <p>
 * 仅对空字符串、`{}`、`[]`做了处理
 *
 * @author robin
 */
public class NoEmptyJsonValidator implements ConstraintValidator<NoEmptyJson, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (null == value) {
			return true;
		}

		if (isBlank(value)) {
			return false;
		}

		value = value.trim();

		boolean isJsonObj = value.startsWith("{") && value.endsWith("}");
		boolean isJsonArr = value.startsWith("[") && value.endsWith("]");
		if (!isJsonArr && !isJsonObj) {
			return false;
		}

		value = value.substring(1, value.length() - 1);

		return !isBlank(value);
	}

}
