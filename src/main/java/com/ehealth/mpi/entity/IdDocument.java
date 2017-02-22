package com.ehealth.mpi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class IdDocument {

	public enum DocType {
		pasport, travelPassport, birthCertificate, driversLicense, schoolId, studentId, militaryId, officialID;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private DocType type;
	@Column(nullable = false)
	private String number;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm a z")
	private Calendar issuedOn;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm a z")
	private Calendar expiredOn;

	public IdDocument() {
	}

	public IdDocument(DocType type, String number, Calendar issuedOn, Calendar expiredOn) {
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

	public Calendar getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(Calendar issuedOn) {
		this.issuedOn = issuedOn;
	}

	public Calendar getExpiredOn() {
		return expiredOn;
	}

	public void setExpiredOn(Calendar expiredOn) {
		this.expiredOn = expiredOn;
	}
}
