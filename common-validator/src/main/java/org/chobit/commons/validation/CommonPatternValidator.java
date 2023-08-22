package org.chobit.commons.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.commons.enums.CommonRegexPattern;

/**
 * @author robin
 */
public class CommonPatternValidator implements ConstraintValidator<CommonPattern, String> {


    private CommonRegexPattern regexPattern;

    @Override
    public void initialize(CommonPattern annotation) {
        this.regexPattern = annotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }

        return this.regexPattern.matches(value);
    }
}
