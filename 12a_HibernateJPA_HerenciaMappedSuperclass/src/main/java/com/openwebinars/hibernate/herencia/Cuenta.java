package com.openwebinars.hibernate.herencia;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entity implementation class for Entity: Cuenta
 *
 */
@MappedSuperclass
public class Cuenta implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	private String titular;
	private double balance;
	private double tipoInteres;
	private static final long serialVersionUID = 1L;

	public Cuenta() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	  
	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}   
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}   
	public double getTipoInteres() {
		return this.tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}
   
}
