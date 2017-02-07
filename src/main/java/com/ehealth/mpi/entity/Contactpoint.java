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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Contactpoint other = (Contactpoint) obj;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
