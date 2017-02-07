package com.ehealth.mpi.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Address {

	public enum Region {
		CityKiyv, VinnitsyaRegion, VolynRegion, DniproRegion, DonetskRegion, ZhitomirRegion, ZakarpattyaRegion, ZaporizhyaRegion, IvanoFrankivskRegion, KirovogradRegion, KievRegion, BukovelResort, LuganskRegion, LvivRegion, MikolayivRegion, OdessaRegion, PoltavaRegion, RivneRegion, SumiRegion, TernopilRegion, KharkivRegion, KhersonRegion, KhmelnitskRegion, CherkassiRegion, ChernivciRegion, CernigivRegion, ARK, SevastopolCity;
	}

	@Column(nullable = false)
	private String zip;
	@Column(nullable = false)
	private String locality;
	@Enumerated(EnumType.ORDINAL)
	private Region region;
	private String street;
	@Column(nullable = false)
	private String house;
	private String apt;

	public Address() {
	}

	public Address(String zip, String locality, Region region, String street, String house, String apt) {
		super();
		this.zip = zip;
		this.locality = locality;
		this.region = region;
		this.street = street;
		this.house = house;
		this.apt = apt;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((locality == null) ? 0 : locality.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Address other = (Address) obj;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (locality == null) {
			if (other.locality != null)
				return false;
		} else if (!locality.equals(other.locality))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

}
