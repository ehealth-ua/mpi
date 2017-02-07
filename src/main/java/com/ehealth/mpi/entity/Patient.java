package com.ehealth.mpi.entity;

import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@AttributeOverride(name = "surname", column = @Column(name = "person_surname"))
	private MpiId mpiId;
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "person_name")),
			@AttributeOverride(name = "surname", column = @Column(name = "person_surname")),
			@AttributeOverride(name = "fname", column = @Column(name = "person_fname")),
			@AttributeOverride(name = "inn", column = @Column(name = "person_inn")),
			@AttributeOverride(name = "addedDate", column = @Column(name = "person_addedDate")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "person_normalizedby")),
			@AttributeOverride(name = "lastUpdatedDate", column = @Column(name = "person_lastUpdatedDate")) })
	@Column(name = "person")
	private Citizen person;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "id_document_type")),
			@AttributeOverride(name = "number", column = @Column(name = "id_document_number")),
			@AttributeOverride(name = "issuedOn", column = @Column(name = "id_document_issuedOn")),
			@AttributeOverride(name = "expiredOn", column = @Column(name = "id_document_expiredOn")) })
	@Column(name = "id_document")
	private IdDocument document;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "additional_document_type")),
			@AttributeOverride(name = "number", column = @Column(name = "additional_document_number")),
			@AttributeOverride(name = "issuedOn", column = @Column(name = "additional_document_issuedOn")),
			@AttributeOverride(name = "expiredOn", column = @Column(name = "additional_document_expiredOn")) })
	@Column(name = "additional_document")
	private IdDocument additionalDocument;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "phone_type")),
			@AttributeOverride(name = "details", column = @Column(name = "phone_details")),
			@AttributeOverride(name = "normalizedValue", column = @Column(name = "phone_normalizedValue")),
			@AttributeOverride(name = "value", column = @Column(name = "phone_value")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "phone_normalizedby")) })
	@Column(name = "phone")
	private Contactpoint phone;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "email_type")),
			@AttributeOverride(name = "details", column = @Column(name = "email_details")),
			@AttributeOverride(name = "normalizedValue", column = @Column(name = "email_normalizedValue")),
			@AttributeOverride(name = "value", column = @Column(name = "email_value")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "email_normalizedby")) })
	@Column(name = "email")
	private Contactpoint email;
	@Column(name = "address")
	@AttributeOverrides({ @AttributeOverride(name = "zip", column = @Column(name = "address_zip")),
			@AttributeOverride(name = "locality", column = @Column(name = "address_locality")),
			@AttributeOverride(name = "region", column = @Column(name = "address_region")),
			@AttributeOverride(name = "street", column = @Column(name = "address_street")),
			@AttributeOverride(name = "house", column = @Column(name = "address_house")),
			@AttributeOverride(name = "apt", column = @Column(name = "address_apt")) })
	private Address address;
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "reletedPerson_name")),
			@AttributeOverride(name = "surname", column = @Column(name = "reletedPerson_surname")),
			@AttributeOverride(name = "fname", column = @Column(name = "reletedPerson_fname")),
			@AttributeOverride(name = "inn", column = @Column(name = "reletedPerson_inn")),
			@AttributeOverride(name = "addedDate", column = @Column(name = "reletedPerson_addedDate")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "reletedPerson_normalizedby")),
			@AttributeOverride(name = "lastUpdatedDate", column = @Column(name = "reletedPerson_lastUpdatedDate")) })
	@Column(name = "reletedPerson")
	private Citizen relatedPerson;
	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "emergency_contact_type")),
			@AttributeOverride(name = "name", column = @Column(name = "emergency_contact_name")),
			@AttributeOverride(name = "surname", column = @Column(name = "emergency_contact_surname")),
			@AttributeOverride(name = "fname", column = @Column(name = "emergency_contact_fname")),
			@AttributeOverride(name = "addedDate", column = @Column(name = "emergency_contact_addedDate")),
			@AttributeOverride(name = "normalizedby", column = @Column(name = "emergency_contact_normalizedby")),
			@AttributeOverride(name = "lastUpdatedDate", column = @Column(name = "emergency_contact_lastUpdatedDate")) })
	@Column(name = "emergency_contact")
	private Contactpoint emergencyContact;

	public Patient() {
		setId();
	}

	public String getId() {
		return mpiId.getId();
	}

	public void setId() {
		if (mpiId == null) {
			mpiId = new MpiId(UUID.randomUUID().toString(), "0");
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

	public Citizen getRelatedPerson() {
		return relatedPerson;
	}

	public void setRelatedPerson(Citizen relatedPerson) {
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
		result = prime * result + ((additionalDocument == null) ? 0 : additionalDocument.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emergencyContact == null) ? 0 : emergencyContact.hashCode());
		result = prime * result + ((mpiId == null) ? 0 : mpiId.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((relatedPerson == null) ? 0 : relatedPerson.hashCode());
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
		if (additionalDocument == null) {
			if (other.additionalDocument != null)
				return false;
		} else if (!additionalDocument.equals(other.additionalDocument))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emergencyContact == null) {
			if (other.emergencyContact != null)
				return false;
		} else if (!emergencyContact.equals(other.emergencyContact))
			return false;
		if (mpiId == null) {
			if (other.mpiId != null)
				return false;
		} else if (!mpiId.equals(other.mpiId))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (relatedPerson == null) {
			if (other.relatedPerson != null)
				return false;
		} else if (!relatedPerson.equals(other.relatedPerson))
			return false;
		return true;
	}

}
