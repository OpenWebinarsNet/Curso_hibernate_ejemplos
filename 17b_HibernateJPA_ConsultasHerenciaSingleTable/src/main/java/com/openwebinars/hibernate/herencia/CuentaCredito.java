package com.openwebinars.hibernate.herencia;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CuentaCredito
 *
 */
@Entity
@DiscriminatorValue("CC")
public class CuentaCredito extends Cuenta implements Serializable {

	
	private double limiteCredito;
	private static final long serialVersionUID = 1L;

	public CuentaCredito() {
		super();
	}   
	public double getLimiteCredito() {
		return this.limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	@Override
	public String toString() {
		return "CuentaCredito [limiteCredito=" + limiteCredito + ", Cuenta" + super.toString() + "]";
	}
	
	
	
   
}
