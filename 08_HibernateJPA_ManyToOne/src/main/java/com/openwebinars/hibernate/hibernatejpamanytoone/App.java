package com.openwebinars.hibernate.hibernatejpamanytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociaciones ManyToOne
 * www.openwebinars.net
 * @LuisMLopezMag
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToOne");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person = new Person("Pepe");
		em.persist( person );

		Phone phone = new Phone("954000000");
		phone.setPerson(person);
		em.persist(phone);

		em.flush();
		phone.setPerson(null);
		
		


		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
