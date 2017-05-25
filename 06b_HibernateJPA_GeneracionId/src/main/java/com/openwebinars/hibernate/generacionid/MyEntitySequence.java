package com.openwebinars.hibernate.generacionid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MyEntitySequence {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myentitysequence")
	@SequenceGenerator(name = "myentitysequence")
	private long id;

	private String text;
	
	public MyEntitySequence() {
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}
	
	
	
	


}