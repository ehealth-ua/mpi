package com.ehealth.mpi.dao;

import org.springframework.stereotype.Repository;

import com.ehealth.mpi.entity.Patient;

@Repository
public interface IPatientService {

	Patient save(Patient patient);

	Patient update(Patient patient);

	Patient getPatientBy(long id);

	// using in JUnit
	void deletePatientBy(long id);
}
