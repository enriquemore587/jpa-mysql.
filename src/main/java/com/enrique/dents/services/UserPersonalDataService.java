package com.enrique.dents.services;

import java.text.ParseException;

import com.enrique.dents.entity.UserPersonalData;
import com.enrique.dents.utils.request.UserPersonalDataSaveReq;

public interface UserPersonalDataService {

	public void save(UserPersonalData userPersonalData);
	
	public String save(UserPersonalDataSaveReq userPersonalDataSaveReq) throws ParseException;
	
	public UserPersonalData findByUser(Long userId);
	
}
