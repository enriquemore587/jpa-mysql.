package com.enrique.dents.dao;

import org.springframework.data.repository.CrudRepository;

import com.enrique.dents.entity.User;
import com.enrique.dents.entity.UserPersonalData;

public interface UserPersonalDataDao extends CrudRepository<UserPersonalData, Long>{
	
	public UserPersonalData findByUser(User user);
}
