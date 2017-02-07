package com.ehealth.mpi.validator;

import org.springframework.stereotype.Component;

import com.ehealth.mpi.entity.Patient;

@Component
public class DataValidator {

	public boolean isValid(Patient data) {
		return true;
	}
}
