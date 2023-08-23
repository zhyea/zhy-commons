package org.chobit.commons.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

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

        String[] arr = EMOJI.pattern.split(value);

        if (arr.length > 1) {
            return false;
        }

        if (arr.length == 1 && !Objects.equals(arr[0], value)) {
            return false;
        }

        return true;
    }


}
