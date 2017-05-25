package com.openwebinars.hibernate.colecciones.bag;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="PersonBag")
public class Person {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhonesBags", joinColumns=@JoinColumn(name="person_id"))
	@OrderColumn  //es ignorada en la práctica
	private Collection<String> phones = new ArrayList<String>();
	
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

	public Collection<String> getPhones() {
		return phones;
	}


}
