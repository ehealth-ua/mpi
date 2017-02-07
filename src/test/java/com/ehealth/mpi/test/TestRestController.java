package com.ehealth.mpi.test;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.After;
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
import org.springframework.web.context.WebApplicationContext;

import com.ehealth.mpi.config.AppConfiguration;
import com.ehealth.mpi.config.SpringWebConfig;
import com.ehealth.mpi.entity.Address;
import com.ehealth.mpi.entity.Address.Region;
import com.ehealth.mpi.entity.Citizen;
import com.ehealth.mpi.entity.Contactpoint;
import com.ehealth.mpi.entity.Contactpoint.TypeContactpoint;
import com.ehealth.mpi.entity.IdDocument;
import com.ehealth.mpi.entity.IdDocument.DocType;
import com.ehealth.mpi.entity.Patient;
import com.ehealth.mpi.service.ServicePatient;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfiguration.class, SpringWebConfig.class })
@WebAppConfiguration
public class TestRestController {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private ServicePatient servicePatient;

	private Patient patient;

	private MockMvc mockMvc;

	@Before
	public void innit() {
		patient = createPatient();
		servicePatient.save(patient);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).dispatchOptions(true).build();
	}

	@Test
	public void getRequestFindPatientById() throws Exception {
		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/mip/id/" + patient.getMpiId().getId())
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(getRequest);
		ResultActions result = mockMvc.perform(getRequest);
		result.andExpect(MockMvcResultMatchers.status().is(200));

		MockHttpServletRequestBuilder getRequest400 = MockMvcRequestBuilders.get("errorURL")
				.contentType(MediaType.APPLICATION_XML);
		this.mockMvc.perform(getRequest400);
		ResultActions result400 = mockMvc.perform(getRequest400);
		result400.andExpect(MockMvcResultMatchers.status().is(404));

		MockHttpServletRequestBuilder getRequest404 = MockMvcRequestBuilders.get("errorURL")
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(getRequest404);
		ResultActions result404 = mockMvc.perform(getRequest404);
		result404.andExpect(MockMvcResultMatchers.status().is(404));
	}

	// @Test
	// public void postRequestGeneratedMpiIndex() throws Exception {
	// MockHttpServletRequestBuilder postRequest201 = MockMvcRequestBuilders
	// .post("/mip/id/" +
	// patient.getMpiId().getId()).contentType(MediaType.APPLICATION_JSON);
	// this.mockMvc.perform(postRequest201);
	// ResultActions result201 = mockMvc.perform(postRequest201);
	// result201.andExpect(MockMvcResultMatchers.status().is(201));
	//
	// servicePatient.getPatientBy("1");
	// Patient patientWithGeneretedTTL =
	// servicePatient.getPatientBy(patient.getMpiId().getId());
	// Assert.assertTrue((patientWithGeneretedTTL.getMpiId().getId() != null)
	// && (!patientWithGeneretedTTL.getMpiId().getTtl().equals("0")));
	//
	// }

	@Test
	public void postRequestaAddPatient() throws Exception {
		servicePatient.deletePatientBy(patient.getId());
		MockHttpServletRequestBuilder postRequest201 = MockMvcRequestBuilders.post("/mip/patient")
				.content(createJSONPatient()).contentType(MediaType.APPLICATION_JSON);
		ResultActions result201 = mockMvc.perform(postRequest201);
		result201.andExpect(MockMvcResultMatchers.status().is(201));
		MockHttpServletRequestBuilder postRequest409 = MockMvcRequestBuilders.post("/mip/patient")
				.contentType(MediaType.APPLICATION_JSON).content(createJSONPatient());
		this.mockMvc.perform(postRequest409);
		ResultActions result409 = mockMvc.perform(postRequest409);
		result409.andExpect(MockMvcResultMatchers.status().is(409));
	}

	@Test
	public void putRequestaChangePatient() throws Exception {
		servicePatient.deletePatientBy(patient.getId());
		Citizen updatePerson = new Citizen("update_name", "update_surname", "update_fname", "update_inn",
				"2017-01-04T10:15:12Z", "2017-01-05T11:16:13Z");
		patient.setPerson(updatePerson);

		MockHttpServletRequestBuilder postRequest201 = MockMvcRequestBuilders.put("/mip/patient")
				.content(createJSONPatient()).contentType(MediaType.APPLICATION_JSON);
		ResultActions result201 = mockMvc.perform(postRequest201);
		result201.andExpect(MockMvcResultMatchers.status().is(201));

		MockHttpServletRequestBuilder postRequest409 = MockMvcRequestBuilders.post("/mip/patient")
				.contentType(MediaType.APPLICATION_JSON).content(createJSONPatient());
		this.mockMvc.perform(postRequest409);
		ResultActions result409 = mockMvc.perform(postRequest409);
		result409.andExpect(MockMvcResultMatchers.status().is(409));
	}

	@After
	public void deletePateinsFromDB() {
		servicePatient.deletePatientBy(patient.getMpiId().getId());
	}

	private Patient createPatient() {
		Patient patient = new Patient();

		String personName = "name", personSurname = "surname", personFname = "fname", personInn = "inn",
				personAddedDate = "2017-01-04T10:15:12Z", personLastUpdatedDate = "2017-01-05T11:16:13Z";
		Citizen testCitizen = new Citizen(personName, personSurname, personFname, personInn, personAddedDate,
				personLastUpdatedDate);
		patient.setPerson(testCitizen);

		String idDocNumber = "AA1234", idDocIssuedOn = "01.01.2000", idDocExpiredOn = "01.01.2010";
		IdDocument testdocument = new IdDocument(DocType.pasport, idDocNumber, idDocIssuedOn, idDocExpiredOn);
		patient.setDocument(testdocument);

		String addDocNumber = "DL1234", addDocIssuedOn = "01.01.2000", addDocExpiredOn = "01.01.2010";
		IdDocument testAdditionalDocument = new IdDocument(DocType.driversLicense, addDocNumber, addDocIssuedOn,
				addDocExpiredOn);
		patient.setAdditionalDocument(testAdditionalDocument);

		String phoneDetails = "0631234567", phoneNormalizedValue = "+380631234567", phoneValue = "0631234567",
				phoneNormalizedby = "+38";
		Contactpoint testPhone = new Contactpoint(TypeContactpoint.phone, phoneDetails, phoneNormalizedValue,
				phoneValue, phoneNormalizedby);
		patient.setPhone(testPhone);

		String emailDetails = "ehealth@gmai.com", emailNormalizedValue = "ehealth@gmai.com",
				emailValue = "ehealth@gmai.com", emailNormalizedby = "+ehealth@gmai.com";
		Contactpoint testEmail = new Contactpoint(TypeContactpoint.email, emailDetails, emailNormalizedValue,
				emailValue, emailNormalizedby);
		patient.setEmail(testEmail);

		String zip = "4400", locality = "Ukraine", street = "Khreshatik st.", house = "1", apt = "13";
		Address testAddress = new Address(zip, locality, Region.CityKiyv, street, house, apt);
		patient.setAddress(testAddress);

		String relName = "rel_name", relSurname = "rel_surname", relFname = "rel_fname", relInn = "rel_inn",
				relAddedDate = "2017-01-04T10:15:12Z", relLastUpdatedDate = "2017-01-05T11:16:13Z";
		Citizen relatedPerson = new Citizen(relName, relSurname, relFname, relInn, relAddedDate, relLastUpdatedDate);
		patient.setRelatedPerson(relatedPerson);

		String emerg = "emerg112", emergNormalizedValue = "112", emergValue = "112", emergNormalizedby = "112";
		Contactpoint emergencyPhone = new Contactpoint(TypeContactpoint.mobilePhone, emerg, emergNormalizedValue,
				emergValue, emergNormalizedby);
		patient.setEmergencyContact(emergencyPhone);
		return patient;
	}

	private String createJSONPatient() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(patient);
		return requestJson;
	}
}