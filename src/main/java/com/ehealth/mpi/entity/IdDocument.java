package com.ehealth.mpi.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class IdDocument {

	public enum DocType {
		pasport, travelPassport, birthCertificate, driversLicense, schoolId, studentId, militaryId, officialID;
	}

	@Enumerated(EnumType.ORDINAL)
	private DocType type;
	@Column(nullable = false)
	private String number;
	private String issuedOn;
	private String expiredOn;

	public IdDocument() {
	}

	public IdDocument(DocType type, String number, String issuedOn, String expiredOn) {
		super();
		this.type = type;
		this.number = number;
		this.issuedOn = issuedOn;
		this.expiredOn = expiredOn;
	}

	public DocType getType() {
		return type;
	}

	public void setType(DocType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(String issuedOn) {
		this.issuedOn = issuedOn;
	}

	public String getExpiredOn() {
		return expiredOn;
	}

	public void setExpiredOn(String expiredOn) {
		this.expiredOn = expiredOn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		IdDocument other = (IdDocument) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}
