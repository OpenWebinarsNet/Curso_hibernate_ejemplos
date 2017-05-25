package com.openwebinars.hibernate.hibernatejpamanytoone;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String number;
	
	@ManyToOne
	@JoinColumn(name = "person_id", 
					foreignKey = @ForeignKey(name="PERSON_ID_FK"))
	private Person person;
	
	
	public Phone() { }
	
	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getId() {
		return id;
	}
	
	

}
