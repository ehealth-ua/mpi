package com.ehealth.mpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.mpi.dao.ICrudPatientDAO;
import com.ehealth.mpi.entity.Patient;

@Service
@Transactional
public class PatientServiceImpl {

	@Autowired
	private ICrudPatientDAO iPatientDAO;

	public Patient save(Patient patient) {
		return iPatientDAO.save(patient);
	}

	public Patient update(Patient patient) {
		return iPatientDAO.save(patient);
	}

	@Transactional(readOnly = true)
	public Patient getPatientBy(long id) {
		return iPatientDAO.findOneBympiIdId(id);
	}

	public void deletePatientBy(long id) {
		iPatientDAO.deletePatientBympiIdId(id);
	}

}
