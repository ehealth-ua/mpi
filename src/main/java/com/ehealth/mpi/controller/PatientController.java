package com.ehealth.mpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehealth.mpi.entity.Patient;
import com.ehealth.mpi.service.ServicePatient;
import com.ehealth.mpi.validator.DataValidator;

@RestController
@RequestMapping("/mip")
public class PatientController {

	@Autowired
	ServicePatient servicePatient;

	@Autowired
	DataValidator dataValidator;

	@GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> getPatientBy(String id) {
		Patient patient = servicePatient.getPatientBy(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@PostMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> addPatient(Patient patient) {
		if ((patient == null) && (!dataValidator.isValid((patient)))) {
			return new ResponseEntity<Patient>(patient, HttpStatus.BAD_REQUEST);
		}
		Patient findedInDb = servicePatient.getPatientBy(patient.getId());
		if ((findedInDb != null) && (patient.equals(findedInDb))) {
			return new ResponseEntity<Patient>(patient, HttpStatus.CONFLICT);
		}
		servicePatient.save(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}

	@PutMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> updatePatient(Patient patient) {
		if ((patient == null) && (!dataValidator.isValid((patient)))) {
			return new ResponseEntity<Patient>(patient, HttpStatus.BAD_REQUEST);
		}
		Patient findedInDb = servicePatient.getPatientBy(patient.getId());
		if ((findedInDb != null) && (patient.equals(findedInDb))) {
			return new ResponseEntity<Patient>(patient, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}

	// @PostMapping(value = "/id/{id}", produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<Patient> generatedMPIIndex(@PathVariable String id)
	// {
	// Patient patient = servicePatient.getPatientBy(id);
	// if (patient == null) {
	// return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
	// }
	// servicePatient.generatedMpiIndex(patient);
	// return new ResponseEntity<Patient>(HttpStatus.CREATED);
	// }

}