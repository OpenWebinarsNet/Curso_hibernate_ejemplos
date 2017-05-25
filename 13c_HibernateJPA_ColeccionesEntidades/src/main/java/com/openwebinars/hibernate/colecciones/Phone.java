package com.openwebinars.hibernate.colecciones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private long id;
		
	private String type;
	
	private String number;
	
	
	
	public Phone() { }
	
	public Phone(String type, String number) {
		this.type = type;
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}
	
	public long getId() {
		return id;
	}


}
