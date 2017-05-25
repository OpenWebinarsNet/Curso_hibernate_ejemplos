package com.openwebinars.hibernate.colecciones.set;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PersonSet")
public class Person {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhonesSet", joinColumns=@JoinColumn(name="person_id"))
	private Set<String> phones = new HashSet<String>();
	
	public Person() { }
	
	public Person(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPhones() {
		return phones;
	}


}
