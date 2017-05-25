package com.openwebinars.hibernate.primerejemplospringjpahibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * 
 * Esta es la clase que usaremos para acceder a los datos de las entidades User.
 * Al estar anotada con el estereotipo @Repository, será localizada rapidamente,
 * y usada para tal fin.
 * 
 * Al tener definido un motor de transacciones en DatabaseConfig, toda clase
 * anotada con @Transactional provocará que se invoquen los método begin()
 * y commit() de forma "mágica" en el inicio y el fin del método.
 * 
 * 
 */
@Repository
@Transactional
public class UserDao {
	
	// A través de la anotación @PersistenceContext, se inyectará automáticamente
	// un EntityManager producido desde el entityManagerFactory definido en la clase
	// DatabaseConfig.
	
	@PersistenceContext
	private EntityManager entityManager;


	/**
	 * Almacena el usuario en la base de datos
	 */
	public void create(User user) {
		entityManager.persist(user);
		return;
	}

	/**
	 * Elimina el usuario de la base de datos.
	 */
	public void delete(User user) {
		if (entityManager.contains(user))
			entityManager.remove(user);
		else
			entityManager.remove(entityManager.merge(user));
		return;
	}

	/**
	 * Devuelve todos los usuarios de la base de datos.
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return entityManager.createQuery("from User").getResultList();
	}

	/**
	 * Devuelve un usuario en base a su Id
	 */
	public User getById(int id) {
		return entityManager.find(User.class, id);
	}

	/**
	 * Actualiza el usuario proporcionado
	 */
	public void update(User user) {
		entityManager.merge(user);
		return;
	}

	

}