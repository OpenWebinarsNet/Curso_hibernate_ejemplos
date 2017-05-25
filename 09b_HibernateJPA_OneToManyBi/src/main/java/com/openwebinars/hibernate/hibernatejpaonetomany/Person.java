package com.openwebinars.hibernate.hibernatejpaonetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();
	
	private String name;
	
	public Person() { }
	
	public Person(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
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
	
	public void addPhone(Phone phone) {
		phones.add(phone);
		phone.setPerson(this);
	}

	public void removePhone(Phone phone) {
		phones.remove(phone);
		phone.setPerson(null);
	}
	

}
