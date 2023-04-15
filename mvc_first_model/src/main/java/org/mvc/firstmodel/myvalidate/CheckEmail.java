package org.mvc.firstmodel.myvalidate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {

	public String value()

	default "@gmail.com";

	public String message()

	default "email must ends with @gmail.com";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
