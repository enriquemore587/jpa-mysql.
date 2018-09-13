package com.enrique.dents.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrique.dents.dao.ConsultingRoomsDao;
import com.enrique.dents.dao.ProfileDao;
import com.enrique.dents.dao.TypeUserDao;
import com.enrique.dents.dao.UserDao;
import com.enrique.dents.entity.ConsultingRooms;
import com.enrique.dents.entity.Profile;
import com.enrique.dents.entity.TypeUser;
import com.enrique.dents.entity.User;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.response.GenericResp;
import com.enrique.dents.utils.response.UserLoggedResp;

@Service
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
	public void save(User user) {
		this.userDao.save(user);
	}

	@Override
	public String register(User user, Long consulting_room_id, Long profile_id, Long type_user_id, Integer level) {
		String response = "";
		User userMaybeExist = this.userDao.findByUserName(user.getUserName());
		if (userMaybeExist != null) {
			response = Status._THERE_IS_ALREADY_A_USER.getDescripcion();
		} else {
			Optional<ConsultingRooms> consultingRooms = this.consultingRoomsDao.findById(consulting_room_id);
			if (!consultingRooms.isPresent()) {
				response = Status._CONSULTING_ROOMS_NOT_FOUND.getDescripcion();
			} else {
				user.setConsultingRooms(consultingRooms.get());
				Optional<Profile> profile = this.profileDao.findById(profile_id);
				if (!profile.isPresent()) {
					response = Status._PROFILE_NOT_FOUND.getDescripcion();
				} else {
					user.setProfile(profile.get());
					Optional<TypeUser> typeUser = this.typeUserDao.findById(type_user_id);
					if (!typeUser.isPresent()) {
						response = Status._TYPE_USER_NOT_FOUND.getDescripcion();
					} else {
						user.setTypeUser(typeUser.get());
						user.setCreateAt(new Date());
						this.save(user);
						response = Status._SUCCESS.getDescripcion();
					}
				}
			}
		}
		return response;
	}

	@Override
	public GenericResp login(String username, String password) {
		GenericResp genericResp = new GenericResp();
		UserLoggedResp userLoggedResp = new UserLoggedResp();
		User user = this.userDao.findByUserName(username);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				genericResp.setStatus(Status._SUCCESS.getDescripcion());
				genericResp.setMessage(Messages._SUCCESS_STATUS.getDescripcion());
				userLoggedResp.setId(user.getId());
				userLoggedResp.setProfileId(user.getProfile().getId());
				userLoggedResp.setProfileName(user.getProfile().getDescription());
				userLoggedResp.setToken("TOKEN");
				userLoggedResp.setTypeUserId(user.getTypeUser().getId());
				userLoggedResp.setTypeUserName(user.getTypeUser().getDescription());
				userLoggedResp.setLevel(user.getLevel());
				userLoggedResp.setConsultingRoomsId(user.getConsultingRooms().getId());
				userLoggedResp.setConsultingRoomsName(user.getConsultingRooms().getDescription());
				user.setMomentStartsSession(new Date());
				this.save(user);
				genericResp.setData(userLoggedResp);
			} else {
				genericResp.setStatus(Status._INCORRECT_PASSWORD.getDescripcion());
				genericResp.setMessage(Messages._INCORRECT_PASSWORD.getDescripcion());
			}
		} else {
			genericResp.setStatus(Status._USER_NOT_FOUND.getDescripcion());
			genericResp.setMessage(Messages._USER_NOT_FOUND.getDescripcion());
		}
		return genericResp;
	}
}
