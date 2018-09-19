package com.enrique.dents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.services.UserAddressService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserAddressSaveUpdateReq;
import com.enrique.dents.utils.response.GenericResp;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.UserAddressResp;

@RestController
@RequestMapping("userAddress")
public class UserAddressController {

	@Autowired
	private UserAddressService userAddressService;

	@GetMapping("findByUser")
	public GenericResp findByUser(@RequestParam Long userId) {
		UserAddressResp resp = this.userAddressService.findByUser(userId);
		return new GenericResp(Status._SUCCESS.getDescripcion(),
				resp == null ? Messages._USER_ADDRESS_INCOMPLETE.getDescripcion()
						: Messages._USER_ADDRESS.getDescripcion(),
				resp);
	}

	@PostMapping("saveUpdate")
	public GenericSuccesResp saveUpdate(@RequestBody UserAddressSaveUpdateReq req) {
		String response = this.userAddressService.saveUpdate(req);
		return new GenericSuccesResp(Status._SUCCESS.getDescripcion(), response);
	}
}
