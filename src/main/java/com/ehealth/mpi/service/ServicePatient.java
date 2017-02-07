package com.ehealth.mpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.mpi.dao.IPatientDAO;
import com.ehealth.mpi.entity.Patient;

@Service
@Transactional
public class ServicePatient {

	@Autowired
	IPatientDAO iPatientDAO;

	public Patient save(Patient patient) {
		return iPatientDAO.save(patient);
	}

	// TODO
	public Boolean generatedMpiIndex(Patient patient) {
		Patient patientFromDb = getPatientBy(patient.getId());
		patientFromDb.getMpiId().setTtl("ttl");
		return true;
	}

	public Patient update(Patient patient) {
		return iPatientDAO.save(patient);
	}

	public Patient getPatientBy(String id) {
		return iPatientDAO.findOneBympiIdId(id);
	}

	// for JUnit testing
	public void deletePatientBy(String id) {
		iPatientDAO.deletePatientBympiIdId(id);
	}

}
