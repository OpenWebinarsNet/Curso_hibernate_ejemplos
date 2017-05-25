package com.openwebinars.hibernate.colecciones.sortedset;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Manejo de colecciones (SortedSet)
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Colecciones");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person = new Person("Pepe");
		em.persist( person );
		
		person.getPhones().add("954123456");
		person.getPhones().add("600123456");
		person.getPhones().add("954123456"); //No se almacenará, puesto que está repetido		
		

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		System.out.println("Name: " + person.getName());
		for (String phone : person.getPhones()) {
			System.out.println("Phone: " + phone);
		}
		
		//Por consola deben aparecer ordenados 
		//mediante el orden natural
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
