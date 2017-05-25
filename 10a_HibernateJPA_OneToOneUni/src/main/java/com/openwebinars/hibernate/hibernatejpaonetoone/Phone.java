package com.openwebinars.hibernate.hibernatejpaonetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue
	private long id;

	private String number;

	@OneToOne
	@JoinColumn(name = "details_id")
	private PhoneDetails details;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDetails getDetails() {
		return details;
	}

	public void setDetails(PhoneDetails details) {
		this.details = details;
	}

	public long getId() {
		return id;
	}

}
