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
	private String place;
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Region region;
	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String house;
	@Column(nullable = false)
	private String apt;

	public Address() {
	}

	public Address(String zip, String place, Region region, String street, String house, String apt) {
		super();
		this.zip = zip;
		this.place = place;
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

}
