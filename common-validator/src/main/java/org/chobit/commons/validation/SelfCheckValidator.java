package org.chobit.commons.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自检验证
 *
 * @author robin
 */
public class SelfCheckValidator implements ConstraintValidator<SelfCheck, Boolean> {


	@Override
	public boolean isValid(Boolean result, ConstraintValidatorContext context) {
		return null != result && result;
	}
}
