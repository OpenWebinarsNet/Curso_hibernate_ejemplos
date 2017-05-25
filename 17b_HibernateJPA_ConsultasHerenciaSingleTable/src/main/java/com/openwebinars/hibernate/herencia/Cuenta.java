package com.openwebinars.hibernate.herencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Cuenta
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)	
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
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", titular=" + titular + ", balance=" + balance + ", tipoInteres=" + tipoInteres
				+ "]";
	}
	
	
   
}
