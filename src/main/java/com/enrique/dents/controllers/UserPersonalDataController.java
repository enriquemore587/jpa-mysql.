package com.enrique.dents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.services.UserPersonalDataService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserPersonalDataSaveReq;
import com.enrique.dents.utils.response.GenericSuccesResp;

@RestController
@RequestMapping("userPersonalData")
public class UserPersonalDataController {

	@Autowired
	private UserPersonalDataService userPersonalDataService;

	@PostMapping("save")
	public GenericSuccesResp save(@RequestBody UserPersonalDataSaveReq userPersonalDataSaveReq) {
		if (userPersonalDataSaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			String response = this.userPersonalDataService.save(userPersonalDataSaveReq);
			if (response == Status._SUCCESS.getDescripcion()) {
				return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
						Messages._SAVED_MSG.getDescripcion());
			} else {
				return new GenericSuccesResp(Messages._UNREGISTERED_USER_PERSONAL_DATA.getDescripcion(), response);
			}
		}
	}
}
