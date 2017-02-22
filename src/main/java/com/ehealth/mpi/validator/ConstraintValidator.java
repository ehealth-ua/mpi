package com.ehealth.mpi.validator;

import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.ehealth.mpi.entity.Patient;

@Component
public class ConstraintValidator implements javax.validation.ConstraintValidator<CheckIndividualPatient, Patient> {

	private static EmailValidator emailValidator;
	private static PhoneValidator phoneValidator;
	private static NameValidator nameValidator;

	@Override
	public void initialize(CheckIndividualPatient checkIndividualPatient) {
		emailValidator = new EmailValidator();
		phoneValidator = new PhoneValidator();
		nameValidator = new NameValidator();
	}

	@Override
	public synchronized boolean isValid(Patient patient, ConstraintValidatorContext context) {
		if (patient == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Patien tnull!").addConstraintViolation();
			return false;
		}
		if (!emailValidator.isValid(patient.getEmail().getValue())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					"Patient email " + patient.getEmail().getValue() + " doesn't valid!").addConstraintViolation();
			return false;
		}
		if (!phoneValidator.isValid(patient.getPhone().getValue())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					"Patient phone " + patient.getPhone().getValue() + " doesn't valid!").addConstraintViolation();
			return false;
		}
		if (!nameValidator.isValid(patient.getPhone().getValue())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					"Patient name " + patient.getPerson().getName() + " doesn't valid!").addConstraintViolation();
			return false;
		}
		return true;

	}

}
