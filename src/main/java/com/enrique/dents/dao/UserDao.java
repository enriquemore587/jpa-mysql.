package com.enrique.dents.dao;

import org.springframework.data.repository.CrudRepository;

import com.enrique.dents.entity.User;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface UserDao extends CrudRepository<User, Long> {

	public User findByUserName(String userName);

}
