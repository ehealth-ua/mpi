package com.testehealth.mpi.testentity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class JsonEntityTestFactory {

	@Autowired
	private EntityTestFactory entityFactoryForTest;
	private String testPatient;
	private String updateTestPatient;
	private String testUnvalidatedPatient;

	public EntityTestFactory getEntityFactoryForTest() {
		return entityFactoryForTest;
	}

	public String getTestPatient() {
		return testPatient;
	}

	public String getUpdateTestPatient() {
		return updateTestPatient;
	}

	public String getTestUnvalidatedPatient() {
		return testUnvalidatedPatient;
	}

	@PostConstruct
	private void initJsonTestPatient() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
		testPatient = ow.writeValueAsString(entityFactoryForTest.getTestPatient());

		updateTestPatient = ow.writeValueAsString(entityFactoryForTest.getUpdateTestPatient());
		testUnvalidatedPatient = ow.writeValueAsString(entityFactoryForTest.getUnvalidatedTestPatient());
	}

}
