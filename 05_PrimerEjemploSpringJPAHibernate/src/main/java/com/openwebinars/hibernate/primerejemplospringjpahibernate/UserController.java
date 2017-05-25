package com.openwebinars.hibernate.primerejemplospringjpahibernate;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


	// Inyectamos el DAO dentro del Controller
	@Autowired
	private UserDao userDao;

	/**
	 * 
	 * Crea un nuevo usuario con un Id autogenerado, y con los datos recibidos
	 * por la URL 
	 * 
	 * /create?name=...&message=....
	 * 
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(String name, String message) {
		try {
			User user = new User();
			// Estas líneas de código generan un Id aleatorio.
			// En las próximas lecciones veremos como delegar esto en la base de
			// datos
			Random r = new Random();
			int randomId = r.nextInt(Integer.MAX_VALUE);
			// Asignamos los datos
			user.setId(randomId);
			user.setUserName(name);
			user.setUserMessage(message);

			userDao.create(user);
		} catch (Exception ex) {
			return "Error creando el usuario: " + ex.toString();
		}
		return "Usuario creado correctamente";
	}

	/**
	 * 
	 * Elimina un usuario, localizándolo por su Id
	 * 
	 * /delete?id=...
	 * 
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(int id) {
		try {
			User user = new User();
			user.setId(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error eliminando el usuario: " + ex.toString();
		}
		return "Usuario eliminado correctamente";
	}

	/**
	 * 
	 * Actualiza el nombre y el mensaje de un usuario, localizándolo por su Id
	 * 
	 * /update?id=...&name=...&message=....
	 * 
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public String updateName(int id, String name, String message) {
		try {
			User user = userDao.getById(id);
			user.setUserName(name);
			user.setUserMessage(message);
			userDao.update(user);
		} catch (Exception ex) {
			return "Error actualizando el usuario: " + ex.toString();
		}
		return "Usuario actualizado correctamente";
	}

}