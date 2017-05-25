package com.openwebinars.hibernate.colecciones.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity(name="PersonSortedSet")
@Table(name="PersonSortedSet")
public class Person {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhonesSortedSet", joinColumns=@JoinColumn(name="person_id"))
	@SortNatural
	private SortedSet<String> phones = new TreeSet<String>();
	
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

	public SortedSet<String> getPhones() {
		return phones;
	}


}
