package com.openwebinars.hibernate.mapeoembedd;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion {

	@Column(nullable = false)
	private String via;

	@Column(nullable = false, length = 5)
	private String codigoPostal;

	@Column(nullable = false)
	private String poblacion;

	@Column(nullable = false)
	private String provincia;
	
	public Direccion() { }
	

	public Direccion(String via, String codigoPostal, String poblacion, String provincia) {
		this.via = via;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}



	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	

}
