package com.enrique.dents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrique.dents.dao.ProfileDao;
import com.enrique.dents.entity.Profile;
import com.enrique.dents.utils.response.ProfileList;

/**
 * @author Jose Enrique Vergara
 *
 */
@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileDao profileDao;

	@Override
	public List<ProfileList> findAll() {
		List<ProfileList> list = new ArrayList<>();
		for (Profile profile : this.profileDao.findAll()) {
			list.add(new ProfileList(profile.getId(), profile.getDescription()));
		}
		return list;
	}

	@Override
	public void save(Profile profile) {
		this.profileDao.save(profile);
	}

}
