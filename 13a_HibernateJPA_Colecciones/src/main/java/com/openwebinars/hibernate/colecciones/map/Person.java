package com.openwebinars.hibernate.colecciones.map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PersonMap")
public class Person {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhonesMap", joinColumns=@JoinColumn(name="person_id"))
	private Map<String, String> phones = new HashMap<String, String>();
	
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

	public Map<String, String> getPhones() {
		return phones;
	}


}
