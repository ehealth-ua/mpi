package com.ehealth.mpi.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Contactpoint {

	public enum TypeContactpoint {
		email, phone, mobilePhone, bankid;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TypeContactpoint type;
	private String details;
	private String normalizedValue;
	@Column(nullable = false)
	private String value;
	private String normalizedby;

	public Contactpoint() {
	}

	public Contactpoint(TypeContactpoint type, String details, String normalizedValue, String value,
			String normalizedby) {
		super();
		this.type = type;
		this.details = details;
		this.normalizedValue = normalizedValue;
		this.value = value;
		this.normalizedby = normalizedby;
	}

	public TypeContactpoint getType() {
		return type;
	}

	public void setType(TypeContactpoint type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getNormalizedValue() {
		return normalizedValue;
	}

	public void setNormalizedValue(String normalizedValue) {
		this.normalizedValue = normalizedValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNormalizedby() {
		return normalizedby;
	}

	public void setNormalizedby(String normalizedby) {
		this.normalizedby = normalizedby;
	}
}
