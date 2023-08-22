package org.chobit.commons.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static org.chobit.commons.enums.CommonRegexPattern.EMOJI;

/**
 * @author robin
 */
public class NoEmojiValidator implements ConstraintValidator<NoEmoji, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }

        return !EMOJI.matches(value);
    }


}
