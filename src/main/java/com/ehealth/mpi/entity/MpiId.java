package com.ehealth.mpi.entity;

import java.io.Serializable;


import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class MpiId implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 1L;

	private Long id;
	private String ttl;

	public MpiId() {
	}

	public MpiId(Long uuid, String ttl) {
		super();
		this.id = uuid;
		this.ttl = ttl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
}
