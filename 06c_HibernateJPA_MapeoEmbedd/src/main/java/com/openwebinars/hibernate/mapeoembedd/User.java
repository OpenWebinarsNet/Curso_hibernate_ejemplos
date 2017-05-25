package com.openwebinars.hibernate.mapeoembedd;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USERCONEMBEDD")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String name;	
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	private Direccion address;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "via", column = @Column(name="VIA_FACTURACION")),
		@AttributeOverride(name = "codigoPostal", column = @Column(name="CODIGOPOSTAL_FACTURACION", length=5)),
		@AttributeOverride(name = "poblacion", column = @Column(name="POBLACION_FACTURACION")),
		@AttributeOverride(name = "provincia", column = @Column(name="PROVINCIA_FACTURACION"))
		
	})
	private Direccion billingAddress;
	
	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Direccion getAddress() {
		return address;
	}


	public void setAddress(Direccion address) {
		this.address = address;
	}


	public Direccion getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(Direccion billingAddress) {
		this.billingAddress = billingAddress;
	}


}