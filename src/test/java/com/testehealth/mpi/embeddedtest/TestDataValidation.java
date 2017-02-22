package com.testehealth.mpi.embeddedtest;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ehealth.mpi.entity.Patient;
import com.google.i18n.phonenumbers.NumberParseException;
import com.testehealth.mpi.testconfig.SpringTestConfig;
import com.testehealth.mpi.testentity.EntityTestFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringTestConfig.class })
public class TestDataValidation {

	@Autowired
	private EntityTestFactory testEntityFactory;

	private Set<ConstraintViolation<Patient>> violations;

	@Autowired
	private com.ehealth.mpi.service.ValidationService MyBeanValidationService;

	private Patient testPatient;

	@Before
	public void innit() throws NumberParseException {
		testPatient = testEntityFactory.getUnvalidatedTestPatient();
		violations = new HashSet<>();
	}

	@Test
	public void test() {
		violations = MyBeanValidationService.validatePatient(testPatient);
		MyBeanValidationService.listViolations(violations);
	}

}
