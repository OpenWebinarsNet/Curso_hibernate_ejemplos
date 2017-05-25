package com.openwebinars.hibernate.herencia;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CuentaCredito
 *
 */
@Entity
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
   
}
