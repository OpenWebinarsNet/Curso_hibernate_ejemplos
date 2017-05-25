package com.openwebinars.hibernate.hibernatejpamanytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociación @ManyToMany con tabla de enlace y atributos extra
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToManyLink");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		
		//Creamos algunas personas
		Person person1 = new Person("Pepe Pérez");
		Person person2 = new Person("Juan Martínez");

		
		//Creamos algunas direcciones
		Address address1 = new Address( "Rue del Percebe", "13", "41010" );
		Address address2 = new Address( "Av. de la Constitución", "1", "41000" );
		
		em.persist( person1 );
		em.persist( person2 );

		em.persist( address1 );
		em.persist( address2 );

		em.flush();

		//Añadimos a la primera persona dos direcciones
		person1.addAddress( address1, "Casa");
		person1.addAddress( address2, "Trabajo" );

		//Añadimos a la segunda persona una dirección
		person2.addAddress( address1, "Trabajo" );

		//Almacenamos
		em.flush();
		//Desasociamos la primera dirección de la primera persona
		person1.removeAddress( address1 );

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		emf.close();
	}
}
