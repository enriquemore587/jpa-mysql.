package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.User;
import com.enrique.dents.utils.response.GenericResp;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface UserService {

	/**
	 * @return - RETORNA LISTA DE USUARIOS EN FORMATO: [ { "user_name": "correo/numero", "password": "*********" }, { "user_name":
	 *         "correo/numero", "password": "*********" }, { "user_name":
	 *         "correo/numero", "password": "*********" } ]
	 */
	public List<User> findAll();

	public void save(User user);

	public String register(User user, Long consulting_room_id, Long profile_id, Long type_user_id, Integer level);

	public GenericResp login(String username, String password);

}
