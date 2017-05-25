package com.openwebinars.hibernate.generacionentidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="anio_nac")
	private short anioNac;

	private String nacionalidad;

	private String nombre;

	//bi-directional many-to-many association to Libro
	@ManyToMany
	@JoinTable(
		name="autor_libro"
		, joinColumns={
			@JoinColumn(name="id_autor")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_libro")
			}
		)
	private List<Libro> libros;

	public Autor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public short getAnioNac() {
		return this.anioNac;
	}

	public void setAnioNac(short anioNac) {
		this.anioNac = anioNac;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}