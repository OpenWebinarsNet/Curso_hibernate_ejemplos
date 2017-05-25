package com.openwebinars.hibernate.colecciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Manejo de colecciones (Embedd)
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColeccionesEmbedd");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person = new Person("Pepe");
		em.persist( person );
		
		person.getPhones().add(new Phone("Fijo", "954123456"));
		person.getPhones().add(new Phone("Móvil", "612345678"));


		em.flush();
		

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
