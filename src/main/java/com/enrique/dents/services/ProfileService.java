package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.Profile;
import com.enrique.dents.utils.response.ProfileList;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface ProfileService {

	public List<ProfileList> findAll();

	public void save(Profile profile);
	
}
