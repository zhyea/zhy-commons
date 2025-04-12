package org.chobit.commons.validation;


import org.chobit.commons.contract.Checkable;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 整体检查验证
 *
 * @author robin
 */
public class WholeCheckValidator implements ConstraintValidator<WholeCheck, Checkable> {


	@Override
	public void initialize(WholeCheck anno) {
	}


	@Override
	public boolean isValid(Checkable checkableObj, ConstraintValidatorContext context) {
		return checkableObj.check();
	}
}
