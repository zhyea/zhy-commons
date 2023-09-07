package org.chobit.commons.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.commons.utils.CharacterChecker;

import static org.chobit.commons.utils.StrKit.isBlank;

/**
 * @author robin
 */
public class ChineseOnlyValidator implements ConstraintValidator<ChineseOnly, String> {


    private boolean allowPunctuation;

    @Override
    public void initialize(ChineseOnly annotation) {
        this.allowPunctuation = annotation.allowPunctuation();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (isBlank(value)) {
            return true;
        }

        return CharacterChecker.isChineseOnly(value, this.allowPunctuation);
    }
}
