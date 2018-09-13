package com.enrique.dents.services;

import com.enrique.dents.entity.UserPersonalData;
import com.enrique.dents.utils.request.UserPersonalDataSaveReq;

public interface UserPersonalDataService {

	public void save(UserPersonalData userPersonalData);

	public String save(UserPersonalDataSaveReq userPersonalDataSaveReq);
}
