package com.ehealth.mpi.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.ehealth.mpi.entity.Patient;

@Service
public class ValidationService {

	@Autowired
	LocalValidatorFactoryBean localValidatorFactoryBean;

	@Autowired
	Validator validation;

	public Set<ConstraintViolation<Patient>> validatePatient(Patient patient) {
		return validation.validate(patient);
	}

	public String listViolations(Set<ConstraintViolation<Patient>> violations) {
		StringBuilder strBuilder = new StringBuilder();
		for (ConstraintViolation<Patient> violation : violations) {
			strBuilder.append(violation.getMessage());
		}
		return strBuilder.toString();
	}

}
