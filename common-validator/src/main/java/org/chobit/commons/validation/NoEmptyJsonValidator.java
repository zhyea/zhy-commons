package org.chobit.commons.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static org.chobit.commons.utils.StrKit.isBlank;

/**
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
		if (!value.startsWith("{") || !value.endsWith("}")) {
			return false;
		}

		value = value.substring(1, value.length() - 1);
		if (isBlank(value)) {
			return false;
		}

		return true;
	}


}
