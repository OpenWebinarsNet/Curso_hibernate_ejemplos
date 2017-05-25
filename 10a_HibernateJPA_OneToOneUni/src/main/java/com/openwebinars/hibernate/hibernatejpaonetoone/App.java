package com.openwebinars.hibernate.hibernatejpaonetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociaciones OneToOne unidireccionales
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUni");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Phone phone = new Phone("954000000");
		em.persist(phone);

		PhoneDetails details = new PhoneDetails("Movistar", "Fijo");
		phone.setDetails(details);
		em.persist(details);
		
		
		Phone phone2 = new Phone("600000000");
		em.persist(phone2);

		PhoneDetails details2 = new PhoneDetails("Vodafone", "Móvil");
		phone2.setDetails(details2);
		em.persist(details2);


		em.flush();
		
		


		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
