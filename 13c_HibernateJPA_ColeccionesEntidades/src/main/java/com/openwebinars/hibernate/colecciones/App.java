package com.openwebinars.hibernate.colecciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Manejo de colecciones (Entidades)
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColeccionesEntidades");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person = new Person("Pepe");
		em.persist( person );
		
		person.getPhones().add(new Phone("Fijo", "954123456"));
		person.getPhones().add(new Phone("Móvil", "612345678"));


		em.flush();

		//Forzamos el volver a leer de la base de datos
		em.refresh(person);
		
		
		System.out.println("Name: " + person.getName());
		for (Phone phone : person.getPhones()) {
			System.out.println("Phone: " + phone.getNumber() + " (" + phone.getType()+ ")");
		}

		

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
