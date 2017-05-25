package com.openwebinars.hibernate.generacionentidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Generación de entidades usando el asistente de eclipse
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App 
{
    public static void main( String[] args )
    {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GeneracionEntidades");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		/*Autor autor1 = new Autor();
		autor1.setNombre("Pepe Pérez");
		autor1.setAnioNac((short)1970);
		autor1.setNacionalidad("Española");
		
		Autor autor2 = new Autor();
		autor2.setNombre("Antonio López");
		autor2.setAnioNac((short)1975);
		autor2.setNacionalidad("Española");
		
		
		
		Libro libro1 = new Libro();
		libro1.setTitulo("Aprender Hibernate de forma rápida y fácil");
		libro1.setIsbn("9781234567");
		libro1.setCategoria("Persistencia");
		libro1.setAnioPublic((short)2015);
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(libro1);
		
		em.flush();

		em.refresh(autor1);
		em.refresh(autor2);
		em.refresh(libro1);
		
		libro1.getAutors().add(autor1);
		libro1.getAutors().add(autor2);
		autor1.getLibros().add(libro1);
		autor2.getLibros().add(libro1);
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(libro1);
		*/
		
		em.getTransaction().commit();
		
		em.close();		
		emf.close();

    }
}
