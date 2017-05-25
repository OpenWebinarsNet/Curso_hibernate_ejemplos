package com.openwebinars.hibernate.colecciones;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {
	
		
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


}
