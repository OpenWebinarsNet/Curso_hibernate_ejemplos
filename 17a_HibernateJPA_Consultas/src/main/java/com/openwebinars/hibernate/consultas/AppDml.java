package com.openwebinars.hibernate.consultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Consultas (JPQL, con nombre, nativas, ....)
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class AppDml 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Consultas");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        

        //UPDATE
        
        //Incremento del 10% en el límite de crédito a todos los clientes
        int numUpdateResults = em.createQuery(
        		"update Customer c "
        		+ "set c.creditLimit = c.creditLimit * 1.1")
        		.executeUpdate();
        System.out.println("Número de registros afectados: " + numUpdateResults);
        
        //DELETE

        Date date = null;
        try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse("05/07/2003");
			
	        int numDeleteResults = em.createQuery(
	        		"delete from Payment p "
	        		+ "where p.paymentDate = :fecha")
	        		.setParameter("fecha", date)
	        		.executeUpdate();

	        System.out.println("Número de registros afectados: " + numDeleteResults);

	        
		} catch (ParseException e) {
			System.err.println("Error en el parseo de la fecha");
		}
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
}
