package com.ehealth.mpi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.ehealth.mpi.entity.Address.Region;

@Embeddable
public class Citizen {

	public enum Sex {
		male, female
	}

	public Citizen() {
	}

	public Citizen(String name, String surname, String fname, String birthDate, String place, Region region, String inn,
			Sex sex, Calendar addedDate, Calendar lastUpdatedDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.fname = fname;
		this.inn = inn;
		this.birthDate = birthDate;
		this.place = place;
		this.region = region;
		this.addedDate = addedDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.sex = sex;
	}

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private String fname;
	private String inn;
	private String birthDate;
	@Column(nullable = false)
	private String place;
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Region region;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm a z")
	private Calendar addedDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm a z")
	private Calendar lastUpdatedDate;
	@Enumerated(EnumType.ORDINAL)
	private Sex sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Calendar getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Calendar addedDate) {
		this.addedDate = addedDate;
	}

	public Calendar getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((inn == null) ? 0 : inn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Citizen other = (Citizen) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (inn == null) {
			if (other.inn != null)
				return false;
		} else if (!inn.equals(other.inn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (region != other.region)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	protected Long generetedId() {
		final int prime = 31;
		long result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((inn == null) ? 0 : inn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = (long) Math.round(result * 100l) / 100l;
		return result;
	}

}
