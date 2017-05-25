package com.openwebinars.hibernate.colecciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Person {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("number")
	private List<Phone> phones = new ArrayList<Phone>();
	
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

	public List<Phone> getPhones() {
		return phones;
	}
	

}
