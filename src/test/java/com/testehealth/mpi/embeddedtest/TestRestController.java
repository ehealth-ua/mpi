package com.testehealth.mpi.embeddedtest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ehealth.mpi.config.WebMvcConfig;
import com.ehealth.mpi.entity.Patient;
import com.ehealth.mpi.service.PatientServiceImpl;
import com.testehealth.mpi.testconfig.SpringTestConfig;
import com.testehealth.mpi.testentity.EntityTestFactory;
import com.testehealth.mpi.testentity.JsonEntityTestFactory;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringTestConfig.class, WebMvcConfig.class })
@WebAppConfiguration
@Transactional
public class TestRestController {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private PatientServiceImpl servicePatient;

	@Autowired
	private EntityTestFactory entityTestFactory;

	@Autowired
	private JsonEntityTestFactory jsonEntityTestFactory;

	private Patient testPatient;

	private MockMvc mockMvc;

	@Before
	public void innit() {
		testPatient = entityTestFactory.getTestPatient();
		servicePatient.save(testPatient);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).dispatchOptions(true).build();
	}

	@Test
	public void testGetId() throws Exception {
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders
				.get("/mip/id/" + testPatient.getMpiId().getId()).contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(getRequest);
		mockMvc.perform(getRequest).andExpect(MockMvcResultMatchers.status().is(200));
		Patient finded = servicePatient.getPatientBy(testPatient.getId());
		Assert.assertTrue(finded.equals(testPatient));
	}

	@Test
	public void testFailGetId() throws Exception {
		MockHttpServletRequestBuilder emptyRequest = MockMvcRequestBuilders
				.get("/mip/id/" + (testPatient.getMpiId().getId() + 10)).contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(emptyRequest);
		mockMvc.perform(emptyRequest).andExpect(MockMvcResultMatchers.status().is(404));

		MockHttpServletRequestBuilder requestToFailUrl = MockMvcRequestBuilders.get("errorURL")
				.contentType(MediaType.APPLICATION_XML);
		this.mockMvc.perform(requestToFailUrl);
		mockMvc.perform(requestToFailUrl).andExpect(MockMvcResultMatchers.status().is(404));
	}

	@Test
	public void testPostPatient() throws Exception {
		servicePatient.deletePatientBy(testPatient.getId());
		MockHttpServletRequestBuilder postRequest201 = MockMvcRequestBuilders.post("/mip/patient")
				.content(jsonEntityTestFactory.getTestPatient()).contentType(MediaType.APPLICATION_JSON_VALUE);
		mockMvc.perform(postRequest201).andExpect(MockMvcResultMatchers.status().is(201));
		org.junit.Assert.assertTrue(servicePatient.getPatientBy(testPatient.getId()).equals(testPatient));
	}

	@Test
	public void testFailPostPatient() throws Exception {
		MockHttpServletRequestBuilder postTofillCell = MockMvcRequestBuilders.post("/mip/patient")
				.contentType(MediaType.APPLICATION_JSON).content(jsonEntityTestFactory.getTestPatient());
		mockMvc.perform(postTofillCell).andExpect(MockMvcResultMatchers.status().is(409));

		MockHttpServletRequestBuilder postUnvalidatedPatient = MockMvcRequestBuilders.post("/mip/patient")
				.contentType(MediaType.APPLICATION_JSON).content(jsonEntityTestFactory.getTestUnvalidatedPatient());
		mockMvc.perform(postUnvalidatedPatient).andExpect(MockMvcResultMatchers.status().is(400));
	}

	@Test
	public void testPutPatient() throws Exception {
		MockHttpServletRequestBuilder postRequest201 = MockMvcRequestBuilders.put("/mip/patient")
				.content(jsonEntityTestFactory.getTestPatient()).contentType(MediaType.APPLICATION_JSON_VALUE);
		ResultActions result201 = mockMvc.perform(postRequest201);
		result201.andExpect(MockMvcResultMatchers.status().is(201));
		org.junit.Assert.assertTrue(servicePatient.getPatientBy(testPatient.getId()).equals(testPatient));
	}

	@Test
	public void testFailPutPatient() throws Exception {
		servicePatient.deletePatientBy(testPatient.getId());
		MockHttpServletRequestBuilder changeEmptyCell = MockMvcRequestBuilders.put("/mip/patient")
				.contentType(MediaType.APPLICATION_JSON).content(jsonEntityTestFactory.getTestPatient());
		mockMvc.perform(changeEmptyCell).andExpect(MockMvcResultMatchers.status().is(400));

		MockHttpServletRequestBuilder putUnvalidatedPatient = MockMvcRequestBuilders.put("/mip/patient")
				.contentType(MediaType.APPLICATION_JSON).content(jsonEntityTestFactory.getTestUnvalidatedPatient());
		mockMvc.perform(putUnvalidatedPatient).andExpect(MockMvcResultMatchers.status().is(400));
	}

	@After
	public void deletePateinsFromDB() {
		servicePatient.deletePatientBy(testPatient.getMpiId().getId());
	}
}