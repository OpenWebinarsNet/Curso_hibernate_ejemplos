package com.openwebinars.hibernate.transactions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Control de transacciones Resource Local con JPA e Hibernate
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {

	static EntityManagerFactory emf;

	static EntityManager em;

	public static void main(String[] args) {

		// Configuramos el EMF a través de la unidad de persistencia
		emf = Persistence.createEntityManagerFactory("Transacciones");

		// Generamos un EntityManager
		em = emf.createEntityManager();

		// Construimos un objeto de tipo User
		UserAccount user1 = new UserAccount();
		user1.setId(1);
		user1.setName("Pepe");
		user1.setBalance(500);
		
		insertUserAccount(user1);

		// Construimos otro objeto de tipo User
		UserAccount user2 = new UserAccount();
		user2.setId(2);
		user2.setName("Juan");
		user2.setBalance(300);

		insertUserAccount(user2);

		makeTransfer(user1, user2, 100.0);


		// Cerramos el EntityManager
		em.close();
		emf.close();

	}

	public static void insertUserAccount(UserAccount userAccount) {
		try {
			//Iniciamos una transacción
			em.getTransaction().begin();
			//Persistimos los datos
			em.persist(userAccount);
			//Commiteamos la transacción
			em.getTransaction().commit();
			System.out.println("El objeto ha sido dado de alta correctamente. Muchas gracias.");
		} catch(Exception e) {
			System.out.println("El objeto no ha sido dado de alta correctamente. Disculpe las molestias");
			System.err.println(e.getMessage());
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}

	

	public static void makeTransfer(UserAccount origen, UserAccount destino, double cantidad) {
		try {
			//Iniciamos una transacción
			em.getTransaction().begin();
			
			origen.setBalance(origen.getBalance() - cantidad);
			destino.setBalance(destino.getBalance() + cantidad);
			
			em.persist(origen);
			em.persist(destino);
			
			//Commiteamos la transacción
			em.getTransaction().commit();

			System.out.println("El traspaso ha sido realizado correctamente. Muchas gracias.");
		} catch(Exception e) {
			System.out.println("El traspaso no ha sido realizado correctamente. Disculpe las molestias");
			System.err.println(e.getMessage());
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

}
