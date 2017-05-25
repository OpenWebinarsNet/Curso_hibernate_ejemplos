package com.openwebinars.hibernate.generacionid;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Diferente estrategias de generación de Ids
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GeneracionId");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();

		// Construimos un par de objetos de tipo MyEntityAuto
		MyEntityAuto entityAuto1 = new MyEntityAuto();
		entityAuto1.setText("Hello world");
		MyEntityAuto entityAuto2 = new MyEntityAuto();
		entityAuto2.setText("Hello world again");

		// Construimos un par de objetos de tipo MyEntityIdentity
		MyEntityIdentity entityIdentity1 = new MyEntityIdentity();
		entityIdentity1.setText("Hello world");
		MyEntityIdentity entityIdentity2 = new MyEntityIdentity();
		entityIdentity2.setText("Hello world again");

		// Construimos un par de objetos de tipo MyEntitySequence
		MyEntitySequence entitySequence1 = new MyEntitySequence();
		entitySequence1.setText("Hello world");
		MyEntitySequence entitySequence2 = new MyEntitySequence();
		entitySequence2.setText("Hello world again");


		// Construimos un par de objetos de tipo MyEntityTable
		MyEntityTable entityTable1 = new MyEntityTable();
		entityTable1.setText("Hello world");
		MyEntityTable entityTable2 = new MyEntityTable();
		entityTable2.setText("Hello world again");

		
		//Persistimos los objetos
		em.persist(entityAuto1);
		em.persist(entityAuto2);

		em.persist(entityIdentity1);
		em.persist(entityIdentity2);

		em.persist(entitySequence1);
		em.persist(entitySequence2);
		
		em.persist(entityTable1);
		em.persist(entityTable2);
		
		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();

	}
}
