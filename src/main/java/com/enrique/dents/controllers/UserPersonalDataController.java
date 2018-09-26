package com.enrique.dents.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.entity.UserPersonalData;
import com.enrique.dents.services.UserPersonalDataService;
import com.enrique.dents.utils.enums.Constants;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserPersonalDataSaveReq;
import com.enrique.dents.utils.response.GenericResp;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.UserPersonalDataResp;

/**
 * @author Jose Enrique Vergara
 *
 */
@CrossOrigin
@RestController
@RequestMapping("userPersonalData")
public class UserPersonalDataController {

	@Autowired
	private UserPersonalDataService userPersonalDataService;

	@PostMapping("saveUpdate")
	public GenericSuccesResp save(@RequestBody UserPersonalDataSaveReq userPersonalDataSaveReq) throws ParseException {
		if (userPersonalDataSaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			String response = this.userPersonalDataService.save(userPersonalDataSaveReq);
			if (response == Status._SUCCESS.getDescripcion()) {
				return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
						Messages._SAVED_MSG.getDescripcion());
			} else if (response == Status._UPDATED.getDescripcion()) {
				return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
						Status._UPDATED.getDescripcion());
			} else{
				return new GenericSuccesResp(Messages._UNREGISTERED_USER_PERSONAL_DATA.getDescripcion(), response);
			}
		}
	}

	@GetMapping("findById")
	public @ResponseBody GenericResp findById(@RequestParam Long userId) {
		UserPersonalData data = this.userPersonalDataService.findByUser(userId);
		UserPersonalDataResp dataResp = null;
		GenericResp resp = null;
		if (data == null) {
			resp = new GenericResp(Status._USER_NOT_FOUND.getDescripcion(), Messages._USER_NOT_FOUND.getDescripcion(),
					null);
		} else if (data.getCivilStatus() != null) {
			dataResp = new UserPersonalDataResp(data.getId(), data.getName(), data.getLast_name(), data.getLast_name2(),
					data.getPhone_number(), data.getMobile_phone_number(), data.getGender(), data.getBirthdate(),
					data.getImportant_note(), data.getCivilStatus().getId(), data.getCivilStatus().getDescription());
			resp = new GenericResp(Status._SUCCESS.getDescripcion(),
					Messages._USER_PERSONAL_DATA_COMPLETE.getDescripcion(), dataResp);
		} else {
			dataResp = new UserPersonalDataResp(data.getId(), data.getName(), data.getLast_name(), data.getLast_name2(),
					data.getPhone_number(), data.getMobile_phone_number(), data.getGender(), data.getBirthdate(),
					data.getImportant_note(), 0l, Constants._NO_DATA.getDescripcion());
			resp = new GenericResp(Status._SUCCESS.getDescripcion(),
					Messages._USER_PERSONAL_DATA_COMPLETE.getDescripcion(), dataResp);
		}

		return resp;
	}
	
}
