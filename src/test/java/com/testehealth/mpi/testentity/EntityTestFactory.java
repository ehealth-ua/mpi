package com.testehealth.mpi.testentity;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ehealth.mpi.entity.Address;
import com.ehealth.mpi.entity.Address.Region;
import com.ehealth.mpi.entity.Citizen;
import com.ehealth.mpi.entity.Citizen.Sex;
import com.ehealth.mpi.entity.Contactpoint;
import com.ehealth.mpi.entity.Contactpoint.TypeContactpoint;
import com.ehealth.mpi.entity.IdDocument;
import com.ehealth.mpi.entity.IdDocument.DocType;
import com.ehealth.mpi.entity.Patient;
import com.ehealth.mpi.entity.RelatedPerson;

@Component
public class EntityTestFactory {

	private Patient testPatient;
	private Patient updateTestPatient;
	private Patient unvalidatedTestPatient;

	public Patient getTestPatient() {
		return testPatient;
	}

	public Patient getUpdateTestPatient() {
		return updateTestPatient;
	}

	public Patient getUnvalidatedTestPatient() {
		return unvalidatedTestPatient;
	}

	@PostConstruct
	private void initTestPatient() {
		testPatient = new Patient();
		String personBirthDate = "2017-01-01";
		Calendar personAddedDate = Calendar.getInstance();
		personAddedDate.set(2017, 01, 01, 01, 1);
		Calendar personLastUpdatedDate = Calendar.getInstance();
		personLastUpdatedDate.set(2017, 01, 01, 01, 1);
		Calendar idDocIssuedOn = Calendar.getInstance();
		idDocIssuedOn.set(2017, 01, 01, 01, 1);
		Calendar idDocExpiredOn = Calendar.getInstance();
		idDocExpiredOn.set(2017, 01, 01, 01, 1);
		Calendar addDocIssuedOn = Calendar.getInstance();
		addDocIssuedOn.set(2017, 01, 01, 01, 1);
		Calendar addDocExpiredOn = Calendar.getInstance();
		addDocExpiredOn.set(2017, 01, 01, 01, 1);
		Calendar relatedPersonAddedDate = Calendar.getInstance();
		relatedPersonAddedDate.set(2017, 01, 01, 01, 1);
		Calendar relatedPersonLastUpdatedDate = Calendar.getInstance();
		personLastUpdatedDate.set(2017, 01, 01, 01, 1);

		String relatedPersonBirthDate = "2017-01-01";
		Calendar relatedPersonIdDocIssuedOn = Calendar.getInstance();
		relatedPersonIdDocIssuedOn.set(2017, 01, 01, 01, 1);
		Calendar relatedPersonidDocExpiredOn = Calendar.getInstance();
		relatedPersonidDocExpiredOn.set(2017, 01, 01, 01, 1);

		testPatient.setPerson(new Citizen("����", "������", "��������", personBirthDate, "���", Region.KievRegion,
				"1234567890", Sex.male, personAddedDate, personLastUpdatedDate));
		testPatient.setDocument(new IdDocument(DocType.pasport, "��12345", idDocIssuedOn, idDocExpiredOn));
		testPatient.setAdditionalDocument(
				new IdDocument(DocType.driversLicense, "���123456", addDocIssuedOn, addDocExpiredOn));
		testPatient.setPhone(new Contactpoint(TypeContactpoint.phone, "0631234567", "+380631234567", "0631234567",
				"phoneNormalized"));
		testPatient.setEmail(new Contactpoint(TypeContactpoint.email, "patient@gmail.com", "patient@gmail.com",
				"patient@gmail.com", "EmeilNormalized"));
		testPatient.setAddress(new Address("4400", "Kiev", Region.KievRegion, "������ ��������", "���.20", "��.1"));
		Citizen relatedPerson = new Citizen("������", "������", "����������", relatedPersonBirthDate, "Kiev",
				Region.KievRegion, "234567890", Sex.male, relatedPersonAddedDate, relatedPersonLastUpdatedDate);
		IdDocument relatedPersonDocument = new IdDocument(DocType.pasport, "��12345", relatedPersonIdDocIssuedOn,
				relatedPersonidDocExpiredOn);
		testPatient.setRelatedPerson(new RelatedPerson(relatedPerson, relatedPersonDocument));
		testPatient.setEmergencyContact(
				new Contactpoint(TypeContactpoint.mobilePhone, "112", "044112", "112", "emergNormalizedby"));
		testPatient.setId();
	}

	@PostConstruct
	private void initUpdateTestPatient() {
		updateTestPatient = new Patient();
		String updatePersonBirthDate = "2017-02-02";

		Calendar personAddedDate = Calendar.getInstance();
		personAddedDate.set(2017, 02, 02, 02, 2);
		Calendar personLastUpdatedDate = Calendar.getInstance();
		personLastUpdatedDate.set(2017, 02, 02, 02, 2);
		Calendar idDocIssuedOn = Calendar.getInstance();
		idDocIssuedOn.set(2017, 02, 02, 02, 2);
		Calendar idDocExpiredOn = Calendar.getInstance();
		idDocExpiredOn.set(2017, 02, 02, 02, 2);
		Calendar addDocIssuedOn = Calendar.getInstance();
		addDocIssuedOn.set(2017, 02, 02, 02, 2);
		Calendar addDocExpiredOn = Calendar.getInstance();
		addDocExpiredOn.set(2017, 02, 02, 02, 2);
		Calendar updateReletedPersonAddedDate = Calendar.getInstance();
		updateReletedPersonAddedDate.set(2017, 02, 02, 02, 2);
		Calendar updateReletedPersonLastUpdatedDate = Calendar.getInstance();
		personLastUpdatedDate.set(2017, 02, 02, 02, 2);

		String updateReletedPersonBirthDate = "2017-02-02";
		Calendar updateReletedPersonIdDocIssuedOn = Calendar.getInstance();
		updateReletedPersonIdDocIssuedOn.set(2017, 02, 02, 02, 2);
		Calendar updateReletedPersonIdDocExpiredOn = Calendar.getInstance();
		updateReletedPersonIdDocExpiredOn.set(2017, 02, 02, 02, 2);

		updateTestPatient.setPerson(new Citizen("update����", "update���������", "update�����������",
				updatePersonBirthDate, "update�������", Region.KievRegion, "1234567890", Sex.male, personAddedDate,
				personLastUpdatedDate));
		updateTestPatient.setDocument(new IdDocument(DocType.pasport, "��22222", idDocIssuedOn, idDocExpiredOn));
		updateTestPatient.setAdditionalDocument(
				new IdDocument(DocType.driversLicense, "���123456", addDocIssuedOn, addDocExpiredOn));
		updateTestPatient.setPhone(new Contactpoint(TypeContactpoint.phone, "0632222222", "+380632222222",
				"380632222222", "phoneNormalized"));
		updateTestPatient.setEmail(new Contactpoint(TypeContactpoint.email, "patient@gmailcom", "patient@gmailcom",
				"patient@gmail.com", "EmeilNormalized"));
		updateTestPatient.setAddress(new Address("update4400", "updateKiev", Region.KievRegion, "������ update��������",
				"update���.20", "update��.1"));
		Citizen relatedPerson = new Citizen("update������", "update������", "update����������",
				updateReletedPersonBirthDate, "updateKiev", Region.KievRegion, "234567890", Sex.male,
				updateReletedPersonAddedDate, updateReletedPersonLastUpdatedDate);
		IdDocument relatedPersonDocument = new IdDocument(DocType.pasport, "��12345", updateReletedPersonIdDocIssuedOn,
				updateReletedPersonIdDocExpiredOn);
		updateTestPatient.setRelatedPerson(new RelatedPerson(relatedPerson, relatedPersonDocument));
		updateTestPatient.setEmergencyContact(
				new Contactpoint(TypeContactpoint.mobilePhone, "911", "044911", "911", "emergNormalizedby"));
		updateTestPatient.setId();
	}

	@PostConstruct
	private void initUnvalidatedTestPatient() {
		unvalidatedTestPatient = new Patient();
		String updatePersonBirthDate = "1900-00-00";

		Calendar personAddedDate = Calendar.getInstance();
		personAddedDate.set(2017, 02, 02, 02, 2);
		Calendar personLastUpdatedDate = Calendar.getInstance();
		personLastUpdatedDate.set(2017, 02, 02, 02, 2);
		Calendar idDocIssuedOn = Calendar.getInstance();
		idDocIssuedOn.set(2017, 02, 02, 02, 2);
		Calendar idDocExpiredOn = Calendar.getInstance();
		idDocExpiredOn.set(2017, 02, 02, 02, 2);
		Calendar addDocIssuedOn = Calendar.getInstance();
		addDocIssuedOn.set(2017, 02, 02, 02, 2);
		Calendar addDocExpiredOn = Calendar.getInstance();
		addDocExpiredOn.set(2017, 02, 02, 02, 2);
		Calendar updateReletedPersonAddedDate = Calendar.getInstance();
		updateReletedPersonAddedDate.set(2017, 02, 02, 02, 2);
		Calendar updateReletedPersonLastUpdatedDate = Calendar.getInstance();
		personLastUpdatedDate.set(2017, 02, 02, 02, 2);

		String updateReletedPersonBirthDate = "2017-02-02";
		Calendar updateReletedPersonIdDocIssuedOn = Calendar.getInstance();
		updateReletedPersonIdDocIssuedOn.set(2017, 02, 02, 02, 2);
		Calendar updateReletedPersonIdDocExpiredOn = Calendar.getInstance();
		updateReletedPersonIdDocExpiredOn.set(2017, 02, 02, 02, 2);

		unvalidatedTestPatient.setPerson(new Citizen("update����", "update���������", "update�����������",
				updatePersonBirthDate, "update�������", Region.KievRegion, "1234567890", Sex.male, personAddedDate,
				personLastUpdatedDate));
		unvalidatedTestPatient.setDocument(new IdDocument(DocType.pasport, "��22222", idDocIssuedOn, idDocExpiredOn));
		unvalidatedTestPatient.setAdditionalDocument(
				new IdDocument(DocType.driversLicense, "���123456", addDocIssuedOn, addDocExpiredOn));
		unvalidatedTestPatient.setPhone(
				new Contactpoint(TypeContactpoint.phone, "0632222222", "+380632222222", "06322222", "phoneNormalized"));
		unvalidatedTestPatient.setEmail(new Contactpoint(TypeContactpoint.email, "patientgmail", "patientgmail",
				"patientgmail", "EmeilNormalized"));
		unvalidatedTestPatient.setAddress(new Address("update4400", "updateKiev", Region.KievRegion,
				"������ update��������", "update���.20", "update��.1"));
		Citizen relatedPerson = new Citizen("update������", "update������", "update����������",
				updateReletedPersonBirthDate, "updateKiev", Region.KievRegion, "234567890", Sex.male,
				updateReletedPersonAddedDate, updateReletedPersonLastUpdatedDate);
		IdDocument relatedPersonDocument = new IdDocument(DocType.pasport, "��12345", updateReletedPersonIdDocIssuedOn,
				updateReletedPersonIdDocExpiredOn);
		unvalidatedTestPatient.setRelatedPerson(new RelatedPerson(relatedPerson, relatedPersonDocument));
		unvalidatedTestPatient.setEmergencyContact(
				new Contactpoint(TypeContactpoint.mobilePhone, "911", "044911", "911", "emergNormalizedby"));
		unvalidatedTestPatient.setId();
	}

}
