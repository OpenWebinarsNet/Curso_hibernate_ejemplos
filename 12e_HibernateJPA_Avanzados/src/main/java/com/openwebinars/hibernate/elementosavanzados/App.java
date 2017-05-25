package com.openwebinars.hibernate.elementosavanzados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Algunos elementos avanzados de Hibernate 
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Avanzados");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		User autor = new User();
		autor.setEmail("luismi@openwebinars.net");
		autor.setPassword("12345678");
		autor.setCity("Sevilla, España");
		
		em.persist(autor);
		
		em.flush();

		em.refresh(autor);

		System.out.println("Hola: " + autor.getGenerated() + " (created At " + autor.getCreatedDate()+")");
		System.out.println("Su contraseña es: " + autor.getPassword());
		
		em.getTransaction().commit();
		

		//Cerramos el EntityManager
		em.close();

	}
}
