package com.enrique.dents.services;

import com.enrique.dents.utils.request.UserAddressSaveUpdateReq;
import com.enrique.dents.utils.response.UserAddressResp;

public interface UserAddressService {
	
	public UserAddressResp findByUser(Long userId);
	
	public String saveUpdate(UserAddressSaveUpdateReq userAddressSaveUpdateReq);
	
}
