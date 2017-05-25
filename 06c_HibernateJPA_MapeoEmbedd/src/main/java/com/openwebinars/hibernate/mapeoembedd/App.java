package com.openwebinars.hibernate.mapeoembedd;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Mapeo de entidades Embedd
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MapeoEmbedd");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();

		//Obtenemos el Calendar con el que gestionaremos las fechas
		Calendar calendar = Calendar.getInstance();

		// Construimos un objeto de tipo User
		User user1 = new User();
		user1.setName("Pepe");
		
		calendar.set(1982, 9, 18);
		user1.setBirthDate(calendar.getTime());
		
		user1.setAddress(new Direccion("Calle Rue del Percebe 13", "28000", "Madrid", "Madrid"));
		user1.setBillingAddress(new Direccion("Calle Betis 1", "41010", "Sevilla", "Sevilla"));

		// Construimos otro objeto de tipo User
		User user2 = new User();
		user2.setName("Pepe");
		calendar.set(1990, 5, 20);
		user2.setBirthDate(calendar.getTime());
		user2.setAddress(new Direccion("Calle Betis 1", "41010", "Sevilla", "Sevilla"));
		user2.setBillingAddress(new Direccion("Calle Rue del Percebe 13", "28000", "Madrid", "Madrid"));

		
		//Persistimos los objetos
		em.persist(user1);
		em.persist(user2);

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();

	}
}
