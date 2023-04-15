package org.mvc.firstmodel.myvalidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

	private String endOfEmail;

	public void initialize(CheckEmail checkEmail) {
		endOfEmail = checkEmail.value();
	}

	@Override
	public boolean isValid(String enteredValue, ConstraintValidatorContext context) {

		return enteredValue.endsWith(endOfEmail);
	}

}
