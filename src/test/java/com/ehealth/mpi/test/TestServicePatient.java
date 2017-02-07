package com.ehealth.mpi.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ehealth.mpi.config.AppConfiguration;
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
@ContextConfiguration(classes = { AppConfiguration.class, })
public class TestServicePatient {

	@Autowired
	private ServicePatient servicePatient;

	private Patient patient;

	@Before
	public void innitAndSavePatient() {
		patient = createPatient();
		servicePatient.save(patient);
	}

	@Test
	public void testFindPatientById() {
		Patient findedPatient = servicePatient.getPatientBy(patient.getId());
		Assert.assertNotNull(findedPatient);
	}

	// @Test
	// public void testGeneratedMpiIndexForPatient() {
	// servicePatient.generatedMpiIndex(patient);
	// Patient patientWithGeneretedTTL =
	// servicePatient.getPatientBy(patient.getMpiId().getId());
	// Assert.assertTrue((patientWithGeneretedTTL.getMpiId().getId() != null)
	// && (!patientWithGeneretedTTL.getMpiId().getTtl().equals("0")));
	// }

	@Test
	public void testUpdatePatientData() {
		Citizen updatePerson = new Citizen("update_name", "update_surname", "update_fname", "update_inn",
				"2017-01-04T10:15:12Z", "2017-01-05T11:16:13Z");
		patient.setPerson(updatePerson);
		servicePatient.update(patient);
		Patient updatePatient = servicePatient.getPatientBy(patient.getId());
		Assert.assertTrue(patient.equals(updatePatient));
		Assert.assertNotNull(patient);
	}

	@After
	public void deletePateinsFromDB() {
		servicePatient.deletePatientBy(patient.getMpiId().getId());
	}

	public Patient createPatient() {
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

}
