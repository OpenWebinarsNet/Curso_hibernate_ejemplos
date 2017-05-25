package com.openwebinars.hibernate.envers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Audited
public class Producto implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	private String descripcion;
	private double pvp;
	
	@ManyToOne
	private Categoria categoria;
	private static final long serialVersionUID = 1L;

	public Producto() {
		super();
	}   

	public Producto(String nombre, String descripcion, double pvp) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pvp = pvp;
	}

	
	public long getId() {
		return this.id;
	}
	

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public double getPvp() {
		return this.pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}   
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
   
}
