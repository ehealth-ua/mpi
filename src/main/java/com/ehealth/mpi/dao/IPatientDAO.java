package com.ehealth.mpi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ehealth.mpi.entity.Patient;

@Repository
public interface IPatientDAO extends CrudRepository<Patient, Long> {

	Patient findOneBympiIdId(String id);

	void deletePatientBympiIdId(String id);
}