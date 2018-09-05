package com.enrique.dents.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.enrique.dents.dao.ConsultingRoomsDao;
import com.enrique.dents.dao.ProfileDao;
import com.enrique.dents.dao.TypeUserDao;
import com.enrique.dents.dao.UserDao;
import com.enrique.dents.entity.ConsultingRooms;
import com.enrique.dents.entity.User;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProfileDao profileDao;

	@Autowired
	private TypeUserDao typeUserDao;

	@Autowired
	private ConsultingRoomsDao consultingRoomsDao;

	@Override
	public List<User> findAll() {
		return (List<User>) this.userDao.findAll();
	}

	@Override
	public void save(User user, Long consulting_room_id, Long profile_id, Long type_user_id, Integer level) {
		Optional<ConsultingRooms> consultingRooms = this.consultingRoomsDao.findById(consulting_room_id);
		
		this.userDao.save(user);

	}

}
