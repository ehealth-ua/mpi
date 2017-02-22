package com.ehealth.mpi.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehealth.mpi.entity.Patient;
import com.ehealth.mpi.service.PatientServiceImpl;
import com.ehealth.mpi.service.ValidationService;

@RestController
@RequestMapping(path = "/mip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

	@Autowired
	private PatientServiceImpl patientService;

	@Autowired
	private ValidationService myBeanValidationService;

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> getPatientBy(@PathVariable Long id) {
		Patient patient = patientService.getPatientBy(id);
		if (patient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient is null");
		}
		Set<ConstraintViolation<Patient>> validateViolations = myBeanValidationService.validatePatient(patient);
		if (!validateViolations.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(myBeanValidationService.listViolations(validateViolations));
		} else {
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/patient")
	public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
		Set<ConstraintViolation<Patient>> validateViolations = myBeanValidationService.validatePatient(patient);
		if (!validateViolations.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(myBeanValidationService.listViolations(validateViolations));
		}
		if (patient.equals(patientService.getPatientBy(patient.getId()))) {
			return new ResponseEntity<Patient>(patient, HttpStatus.CONFLICT);
		}
		patientService.save(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}

	@PutMapping(value = "/patient")
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient) {
		if (patientService.getPatientBy(patient.getId()) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient is null");
		}
		Set<ConstraintViolation<Patient>> validateViolations = myBeanValidationService.validatePatient(patient);
		if (!validateViolations.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(myBeanValidationService.listViolations(validateViolations));
		}
		patientService.update(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}

}