package com.enrique.dents.dao;

import org.springframework.data.repository.CrudRepository;

import com.enrique.dents.entity.User;
import com.enrique.dents.entity.UserAddress;

public interface UserAddressDao extends CrudRepository<UserAddress, Long> {
	public UserAddress findByUser(User user);
}
