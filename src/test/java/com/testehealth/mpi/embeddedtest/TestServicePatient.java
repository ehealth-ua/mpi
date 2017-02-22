package com.testehealth.mpi.embeddedtest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ehealth.mpi.entity.Patient;
import com.ehealth.mpi.service.PatientServiceImpl;
import com.testehealth.mpi.testconfig.SpringTestConfig;
import com.testehealth.mpi.testentity.EntityTestFactory;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class })
@Transactional
public class TestServicePatient {

	@Autowired
	private PatientServiceImpl servicePatient;

	@Autowired
	private EntityTestFactory testEntityFactory;

	private Patient testPatient;

	@Before
	public void innitAndSavePatient() {
		testPatient = testEntityFactory.getTestPatient();
		servicePatient.save(testPatient);
	}

	@Test
	public void testFindPatientById() {
		Patient findedPatient = servicePatient.getPatientBy(testPatient.getId());
		Assert.assertNotNull(findedPatient);
		findedPatient.equals(testPatient);
	}

	@Test
	public void testUpdatePatientData() {
		Patient updateTestPatient = testEntityFactory.getUpdateTestPatient();
		servicePatient.update(updateTestPatient);
		Patient findedPatient = servicePatient.getPatientBy(updateTestPatient.getId());
		Assert.assertNotNull(findedPatient);
		Assert.assertTrue(updateTestPatient.equals(findedPatient));
	}

	@After
	public void deletePateinsFromDB() {
		servicePatient.deletePatientBy(testPatient.getMpiId().getId());
	}

}
