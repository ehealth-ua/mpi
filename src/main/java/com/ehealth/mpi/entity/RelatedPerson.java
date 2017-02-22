package com.ehealth.mpi.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RelatedPerson {

	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "relatedPerson_name")),
			@AttributeOverride(name = "surname", column = @Column(name = "relatedPerson_surname")),
			@AttributeOverride(name = "fname", column = @Column(name = "relatedPerson_fname")),
			@AttributeOverride(name = "inn", column = @Column(name = "relatedPerson_inn")),
			@AttributeOverride(name = "birthDate", column = @Column(name = "relatedPerson_birthDate")),
			@AttributeOverride(name = "place", column = @Column(name = "relatedPerson_place")),
			@AttributeOverride(name = "region", column = @Column(name = "relatedPerson_region")),
			@AttributeOverride(name = "sex", column = @Column(name = "relatedPerson_sex")),
			@AttributeOverride(name = "addedDate", column = @Column(name = "relatedPerson_addedDate")),
			@AttributeOverride(name = "lastUpdatedDate", column = @Column(name = "relatedPerson_lastUpdatedDate")) })
	private Citizen relatedPerson;

	@AttributeOverrides({ @AttributeOverride(name = "type", column = @Column(name = "relatedPerson_document_type")),
			@AttributeOverride(name = "number", column = @Column(name = "relatedPerson_document_number")),
			@AttributeOverride(name = "issuedOn", column = @Column(name = "relatedPerson_document_issuedOn")),
			@AttributeOverride(name = "expiredOn", column = @Column(name = "relatedPerson_document_expiredOn")) })
	private IdDocument document;

	
	public RelatedPerson() {
		super();
	}

	public RelatedPerson(Citizen relatedPerson, IdDocument document) {
		super();
		this.relatedPerson = relatedPerson;
		this.document = document;
	}

	public Citizen getRelatedPerson() {
		return relatedPerson;
	}

	public void setRelatedPerson(Citizen relatedPerson) {
		this.relatedPerson = relatedPerson;
	}

	public IdDocument getDocument() {
		return document;
	}

	public void setDocument(IdDocument document) {
		this.document = document;
	}

}
