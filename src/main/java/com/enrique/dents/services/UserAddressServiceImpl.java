package com.enrique.dents.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrique.dents.dao.UserAddressDao;
import com.enrique.dents.dao.UserDao;
import com.enrique.dents.entity.User;
import com.enrique.dents.entity.UserAddress;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserAddressSaveUpdateReq;
import com.enrique.dents.utils.response.UserAddressResp;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	private UserAddressDao userAddressDao;

	@Autowired
	private UserDao userDao;

	@Override
	public UserAddressResp findByUser(Long userId) {
		UserAddressResp resp = null;
		UserAddress userAddress = null;
		Optional<User> user = this.userDao.findById(userId);
		if (!user.isPresent()) {
			return null;
		}
		userAddress = this.userAddressDao.findByUser(user.get());
		if (userAddress != null) {
			resp = new UserAddressResp(userAddress.getId(), userAddress.getCp(), userAddress.getState(),
					userAddress.getMunicipality(), userAddress.getColony(), userAddress.getStreet(),
					userAddress.getNum_ext(), userAddress.getNum_int());
		}else {
			resp = new UserAddressResp(0l);
		}
		return resp;
	}

	@Override
	public String saveUpdate(UserAddressSaveUpdateReq userAddressSaveUpdateReq) {
		String respuesta = "";
		Optional<User> user = this.userDao.findById(userAddressSaveUpdateReq.getUserId());
		UserAddress userAddress = this.userAddressDao.findByUser(user.get());
		if (userAddress == null) {
			userAddress = new UserAddress(userAddressSaveUpdateReq.getCp(), userAddressSaveUpdateReq.getState(),
					userAddressSaveUpdateReq.getMunicipality(), userAddressSaveUpdateReq.getColony(),
					userAddressSaveUpdateReq.getStreet(), userAddressSaveUpdateReq.getNum_ext(),
					userAddressSaveUpdateReq.getNum_int());
			userAddress.setUser(user.get());
			respuesta = Status._SUCCESS.getDescripcion();
		} else {
			userAddress = user.get().getUserAddress();
			userAddress = new UserAddress(userAddressSaveUpdateReq.getCp(), userAddressSaveUpdateReq.getState(),
					userAddressSaveUpdateReq.getMunicipality(), userAddressSaveUpdateReq.getColony(),
					userAddressSaveUpdateReq.getStreet(), userAddressSaveUpdateReq.getNum_ext(),
					userAddressSaveUpdateReq.getNum_int());
			respuesta = Status._UPDATED.getDescripcion();
		}
		this.userAddressDao.save(userAddress);
		System.out.println(respuesta);
		return respuesta;
	}

}
