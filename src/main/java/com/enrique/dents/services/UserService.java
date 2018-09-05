package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.User;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface UserService {

	public List<User> findAll();

	public void save(User user, Long consulting_room_id, Long profile_id, Long type_user_id, Integer level);
	
}
