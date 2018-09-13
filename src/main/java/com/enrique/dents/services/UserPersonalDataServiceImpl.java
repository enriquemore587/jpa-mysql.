package com.enrique.dents.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrique.dents.dao.CivilStatusDao;
import com.enrique.dents.dao.UserDao;
import com.enrique.dents.dao.UserPersonalDataDao;
import com.enrique.dents.entity.CivilStatus;
import com.enrique.dents.entity.User;
import com.enrique.dents.entity.UserPersonalData;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserPersonalDataSaveReq;

@Service
public class UserPersonalDataServiceImpl implements UserPersonalDataService {

	@Autowired
	private UserPersonalDataDao userPersonalDataDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CivilStatusDao civilStatusDao;

	@Override
	public String save(UserPersonalDataSaveReq userPersonalDataSaveReq) {
		String response = "";
		Optional<User> user = this.userDao.findById(userPersonalDataSaveReq.getUserId());
		if (!user.isPresent()) {
			// aqui no existe usuario
			response = Status._USER_NOT_FOUND.getDescripcion();
		} else {
			
			UserPersonalData userPersonalData = new UserPersonalData(userPersonalDataSaveReq.getName(),
					userPersonalDataSaveReq.getLast_name(), userPersonalDataSaveReq.getLast_name2(),
					userPersonalDataSaveReq.getPhone_number(), userPersonalDataSaveReq.getMobile_phone_number(),
					userPersonalDataSaveReq.getGender(), new Date(), userPersonalDataSaveReq.getImportant_note());
			userPersonalData.setUser(user.get());

			Optional<CivilStatus> civilStatus = this.civilStatusDao
					.findById(userPersonalDataSaveReq.getCivilStatusId());

			if (!civilStatus.isPresent()) {
				// aqui no existe civilstatus
				response = Status._CIVIL_STATUS_NOT_FOUND.getDescripcion();
			} else {
				userPersonalData.setCivilStatus(civilStatus.get());
				this.save(userPersonalData);
				response = Status._SUCCESS.getDescripcion();
			}

		}
		return response;
	}

	@Override
	public void save(UserPersonalData userPersonalData) {
		this.userPersonalDataDao.save(userPersonalData);
	}

}
