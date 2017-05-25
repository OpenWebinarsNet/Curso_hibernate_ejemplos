package com.openwebinars.hibernate.elementosavanzados;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="ADVANCEDUSER")
public class User {

	@Id
	@GeneratedValue
	private long id;

	private String email;

	private String city;
	
	@Generated(value=GenerationTime.ALWAYS)
	@Column(columnDefinition=
		" varchar(512) AS (CONCAT(email,' (', city,')')) "
	)
	private String generatedField;
	

	@CreationTimestamp
	private Date createdDate;
	
	@Column(name="pswd")
	@ColumnTransformer(
			write= " MD5(?) "
	)
	private String password;
	

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getGenerated() {
		return this.generatedField;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
		

}