package org.chobit.commons.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static org.chobit.commons.enums.CommonRegexPattern.EMOJI_CONTAINED;
import static org.chobit.commons.utils.StrKit.isBlank;

/**
 * @author robin
 */
public class NoEmojiValidator implements ConstraintValidator<NoEmoji, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (isBlank(value)) {
			return true;
		}

		return !EMOJI_CONTAINED.matches(value);
	}


}
