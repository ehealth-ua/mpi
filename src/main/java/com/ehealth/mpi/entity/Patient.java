package com.ehealth.mpi.entity;

import javax.annotation.PostConstruct;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ehealth.mpi.validator.CheckIndividualPatient;

@Entity
@Table(name = "patient")
@CheckIndividualPatient
public class Patient {

	@Id
	@Column(nullable = false)
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
			@AttributeOverride(name = "ttl", column = @Column(name = "ttl")) })
	private MpiId mpiId;
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "person_name")),
			@AttributeOverride(name = "surname", column = @Column(name = "person_surname")),
			@AttributeOverride(name = "fname", column = @Column(name = "person_fname")),
			@AttributeOverride(name = "birthDate", column = @Column(name = "person_birthDate")),
			@AttributeOverride(name = "place", column = @Column(name = "person_birthPlace")),
			@AttributeOverride(name = "region", column = @Column(name = "person_birthRegion")),
			@AttributeOverride(name = "inn", column = @Column(name = "person_inn")),
			@AttributeOverride(name = "addedDate", column = @Column(name = "person_addedDate")),
			@AttributeOverride(name = "lastUpdatedDate", column = @Column(name = "person_lastUpdatedDate")),
			@AttributeOverride(name = "sex", column = @Column(name = "person_sex")) })
	@Column(nullable = false)
	private Citizen person;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "id_document_type")),
			@AttributeOverride(name = "number", column = @Column(name = "id_document_number")),
			@AttributeOverride(name = "issuedOn", column = @Column(name = "id_document_issuedOn")),
			@AttributeOverride(name = "expiredOn", column = @Column(name = "id_document_expiredOn")) })
	@Column(nullable = false)
	private IdDocument document;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "additional_document_type")),
			@AttributeOverride(name = "number", column = @Column(name = "additional_document_number")),
			@AttributeOverride(name = "issuedOn", column = @Column(name = "additional_document_issuedOn")),
			@AttributeOverride(name = "expiredOn", column = @Column(name = "additional_document_expiredOn")) })
	private IdDocument additionalDocument;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "phone_type")),
			@AttributeOverride(name = "details", column = @Column(name = "phone_details")),
			@AttributeOverride(name = "normalizedValue", column = @Column(name = "phone_normalizedValue")),
			@AttributeOverride(name = "value", column = @Column(name = "phone_value")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "phone_normalizedby")) })
	@Column(nullable = false)
	private Contactpoint phone;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "email_type")),
			@AttributeOverride(name = "details", column = @Column(name = "email_details")),
			@AttributeOverride(name = "normalizedValue", column = @Column(name = "email_normalizedValue")),
			@AttributeOverride(name = "value", column = @Column(name = "email_value")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "email_normalizedby")) })
	private Contactpoint email;
	@AttributeOverrides({ @AttributeOverride(name = "zip", column = @Column(name = "address_zip")),
			@AttributeOverride(name = "street", column = @Column(name = "address_street")),
			@AttributeOverride(name = "house", column = @Column(name = "address_house")),
			@AttributeOverride(name = "apt", column = @Column(name = "address_apt")) })
	@Column(nullable = false)
	private Address address;
	private RelatedPerson relatedPerson;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "emergency_type")),
			@AttributeOverride(name = "details", column = @Column(name = "emergency_details")),
			@AttributeOverride(name = "normalizedValue", column = @Column(name = "emergency_normalizedValue")),
			@AttributeOverride(name = "value", column = @Column(name = "emergency_value")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "emergency_normalizedby")) })
	private Contactpoint emergencyContact;

	public Patient() {
	}

	public long getId() {
		return mpiId.getId();
	}

	@PostConstruct
	public void setId() {
		if (mpiId == null) {
			mpiId = new MpiId(generatedId(), "0");
		}
	}

	public MpiId getMpiId() {
		return mpiId;
	}

	public void setMpiId(MpiId mpi) {
		this.mpiId = mpi;
	}

	public Citizen getPerson() {
		return person;
	}

	public void setPerson(Citizen person) {
		this.person = person;
	}

	public IdDocument getDocument() {
		return document;
	}

	public void setDocument(IdDocument document) {
		this.document = document;
	}

	public IdDocument getAdditionalDocument() {
		return additionalDocument;
	}

	public void setAdditionalDocument(IdDocument additionalDocument) {
		this.additionalDocument = additionalDocument;
	}

	public Contactpoint getPhone() {
		return phone;
	}

	public void setPhone(Contactpoint phone) {
		this.phone = phone;
	}

	public Contactpoint getEmail() {
		return email;
	}

	public void setEmail(Contactpoint email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public RelatedPerson getRelatedPerson() {
		return relatedPerson;
	}

	public void setRelatedPerson(RelatedPerson relatedPerson) {
		this.relatedPerson = relatedPerson;
	}

	public Contactpoint getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(Contactpoint emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	private long generatedId() {
		return person.generetedId();
	}

	@Override
	public String toString() {
		return "Patient [mpiId=" + mpiId + ", person=" + person + ", document=" + document + ", additionalDocument="
				+ additionalDocument + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", relatedPerson=" + relatedPerson + ", emergencyContact=" + emergencyContact + "]";
	}

}
