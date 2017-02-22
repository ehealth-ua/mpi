package com.ehealth.mpi.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ConstraintValidator.class)
@Documented
public @interface CheckIndividualPatient {
	public String message() default "Patient is not valid";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
