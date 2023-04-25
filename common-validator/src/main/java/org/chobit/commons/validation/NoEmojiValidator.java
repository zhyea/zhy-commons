package org.chobit.commons.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.commons.utils.CharacterChecker;

/**
 * @author robin
 */
public class NoEmojiValidator implements ConstraintValidator<NoEmoji, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }

        return !CharacterChecker.containsEmoji(value);
    }


}
